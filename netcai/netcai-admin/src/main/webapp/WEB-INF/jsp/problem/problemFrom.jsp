<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增</title>
<link rel="stylesheet" href="/layui/css/layui.css" media="all">
<style type="text/css">
.layui-input-inline {
	margin-left: 8px;
}

.layui-input-inline {
	padding: 5px;
}

select {
	width: 10px;
}

img {
	margin: 8px;
	height: 150px;
	width: 300px;
	display: none;
}
</style>
</head>
<body>
	<form  class="layui-form"
		style="margin-top: 30px;">
		<input type="hidden" name="id" id="id" value="${problem.id}">
			<div class="layui-form-item ">
			<div class="layui-inline" >
				<label class="layui-form-label">类型</label>
				 <div class="layui-input-inline" >
				   <select id="type" name="type" lay-filter="type">
					 <option value="1" <c:if test="${problem.type == 1}">selected</c:if>>买家</option>
					 <option value="2" <c:if test="${problem.type == 2}">selected</c:if>>卖家</option>
				   </select>
				 </div>
				 <label class="layui-form-label">分类</label>
				 <div class="layui-input-inline" >
				   <input type="text" name="classify" placeholder="请输入分类" value="${problem.classify}" lay-verify="required" class="layui-input">
				 </div>
			 </div>
			 <div class="layui-inline" >
				 <label class="layui-form-label">状态</label>
				 <div class="layui-input-inline" >
				   <select id="status" name="status" lay-filter="status">
					 <option value="1" <c:if test="${problem.status == 1}">selected</c:if>>显示</option>
					 <option value="-1" <c:if test="${problem.status == -1}">selected</c:if>>不显示</option>
				   </select>
				 </div>
				 <label class="layui-form-label">排序</label>
				 <div class="layui-input-inline" >
				   <input type="text" name="sequence" placeholder="请输入排序" value="${problem.sequence}" lay-verify="required" class="layui-input">
				 </div>
			</div>
			</div>
			<div class="layui-form-item ">
			<div class="layui-inline" >
				<label class="layui-form-label">问题标题</label>
				<div class="layui-input-block" style="width: 1000px">
					<textarea placeholder="请输入问题标题" class="layui-textarea" id="question" lay-verify="content"></textarea>
				</div>
			</div>
			</div>
			<div class="layui-form-item ">
			<div class="layui-inline">
				<label class="layui-form-label">问题答案</label>
				<div class="layui-input-block" style="width: 1000px;">
					<textarea class="layui-textarea layui-hide" style="display: none;" name="answer"
						lay-verify="content" id="answer" ></textarea>
				</div>
			</div>
			</div>

		<div class="layui-input-block"
			style="margin-top: 30px; margin-left: 324px;">
			<button class="layui-btn" lay-submit="" lay-filter="addproblem">确定</button>
			<button class="layui-btn" id="cancleSubmit" name="cancleSubmit">取消</button>
		</div>
	</form>
</body>
<script src="/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/js/jquery.formPlugin.js"></script>
<script type="text/javascript" src="/js/jquery.form.js"></script>
<script type="text/javascript">
$("#answer").val("${answer}");
</script>
<script type="text/javascript">
layui.use(['form', 'jquery', 'layedit', 'laydate','upload'], function(){
	  var $ = layui.jquery,form = layui.form(),layer = layui.layer,
	  layedit = layui.layedit,laydate = layui.laydate;
	  var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
  layedit.set({
	  uploadImage: {
	    url: '<%=request.getContextPath()%>/admin/uploadImgsByLayedit' //接口url
	    ,type: 'post' //默认post
	  }
		});
	  
	//创建一个编辑器
	  var editIndex = layedit.build('answer');
		//关闭弹窗
		$("#cancleSubmit").click(function() {
			parent.layer.close(index);//关闭父页面的弹窗
			return false;
		})
						
		
	//监听提交
	  form.on('submit(addproblem)', function(data){
		  //var answer = layedit.getSelection(editIndex);
		  
	//编辑器外部操作
	var answer = layedit.getContent(editIndex);
		  var question = $("#question").val();
		  var requestData={
							  "classify":data.field.classify,
							  "type":data.field.type,
							  "status":data.field.status,
							  "sequence":data.field.sequence ,
				  			  "answer":answer,
				  				"id":data.field.id,
							  "question":question 
			              };
	      $.ajax({
	    	  type : "post",
	    	  url : "/admin/problem/insertAndUpdate",
	    	  data : requestData,
	    	  cache:false,
	    	  async : false,
	    	  success:function(result){
	    		  var code=result.code;
	    		  if(code=="200"){
	    			  alert(result.message);
	    		  }else{
	    			  alert(result.message);
	    		  }
  			  parent.layer.close(index);//关闭父页面的弹窗
  			parent.location.reload();
	    	  }
	      });
	  });
	
});
$(function(){
	$("#question").val("${problem.question}");
	
});
</script>
</html>