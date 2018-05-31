<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增配送人员</title>
<link rel="stylesheet" href="/layui/css/layui.css"  media="all">
<script type="text/javascript" src="/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/js/jquery.formPlugin.js"></script>
<script type="text/javascript" src="/js/jquery.form.js"></script>
<script src="/layui/layui.js" charset="utf-8"></script>
<style type="text/css">
  .layui-input-inline{
    margin-left:30px;
  }
  .layui-input-inline{
    padding:5px;
  }
</style>
</head>
<body>
 <form id="saleForm" class="layui-form" action="" style="margin-top:30px;">
     <div class="layui-form-item" >
	   <div class="layui-inline">
	     <label class="layui-form-label">姓&nbsp;&nbsp;&nbsp;&nbsp;名</label>
	     <div class="layui-input-inline">
	       <input type="text" name="realName" placeholder="请输入姓名" lay-verify="required" value="${sales.realName }" class="layui-input">
	     </div>
		 <label class="layui-form-label">手&nbsp;机&nbsp;号</label>
	     <div class="layui-input-inline">
	       <input type="tel" name="phone" placeholder="请输入手机号" lay-verify="phone" value="${sales.phone }" class="layui-input">
	     </div>
	     <label class="layui-form-label">密&nbsp;&nbsp;&nbsp;&nbsp;码</label>
	     <div class="layui-input-inline">
	       <input type="password" name="password" placeholder="请输入密码" <c:if test="${sales.id==null }">lay-verify="pass"</c:if> class="layui-input">
	     </div>
	     <label class="layui-form-label">类&nbsp;&nbsp;&nbsp;&nbsp;型</label>
	     <div class="layui-input-inline">
	       <select name="level" id="level" class="form-control select2" >
                <option value="3" <c:if test="${sales.level==3}">selected</c:if>>职员</option>
                <option value="2" <c:if test="${sales.level==2}">selected</c:if>>主管</option>
                <option value="1" <c:if test="${sales.level==1}">selected</c:if>>总监</option>
                <option value="0" <c:if test="${sales.level==0}">selected</c:if>>管理员</option>
           </select>
	     </div>
	     <label class="layui-form-label">直属上级</label>
	     <div class="layui-input-inline">
	       <select name="parentId" id="saleId" class="form-control select2" ></select>
	     </div>
		 <label class="layui-form-label">经&nbsp;验&nbsp;值</label>
	     <div class="layui-input-inline">
	       <input type="text" name="experience" placeholder="请输入经验值" value="${sales.experience }" class="layui-input">
	     </div>
		 <div class="layui-input-inline">
		   <input type="text" name="id" style="display:none;" value="${sales.id }" class="layui-input">
		 </div>
	   </div>
	 </div>
	 <div class="layui-input-block" style="margin-top:30px;margin-left:324px;">
       <button class="layui-btn" name="commit" lay-submit="" lay-filter="addData">确定</button>
       <button class="layui-btn" name="cancleSubmit" >取消</button>
     </div>
  </form>
</body>

<script type="text/javascript">
$(document).ready(function(){ 
	loadsaleId();
}); 
var saleId = '${sales.parentId}';
function loadsaleId(){
	if(saleId == null || saleId == '' ||saleId == undefined){
		saleId = 0;
	}
	  var url='/admin/sales/salesList?status=1&level=1'; 
	  jQuery.ajax({ 
	    type:'post', 
	    url:url, 
	    async:false,
	    success:function (date){
   	     var r = date.object;  
   	     $("<option value='' selected>请选择</option>").appendTo("#saleId");
         if(r != null && r.length > 0){
             for(var i = 0; i< r.length; i++){
                 if(r[i].id == saleId){
              	   $("<option value='"+r[i].id+"' selected>"+r[i].realName+"</option>").appendTo("#saleId");
                 }else {
                 $("<option value='"+r[i].id+"'>"+r[i].realName+"</option>").appendTo("#saleId");  
				}
             }  
         } 
	    } 
	  }); 
}	
//提交表单数据
layui.use(['form', 'jquery', 'layedit', 'laydate'], function(){
	  var $ = layui.jquery,form = layui.form(),layer = layui.layer,
	  layedit = layui.layedit,laydate = layui.laydate;
	  form.verify({
		  //验证密码
		  pass:[/^[\w]{6,12}$/, '请输入写6到12位密码'],
		  //验证手机号
	      phone: [/^1[34578]\d{9}$/, '请输入正确的手机号']
	  });
	  
	  //监听提交
	  form.on('submit(addData)', function(data){
		  //获取选中数据的id(点击修改按钮时)
		  var id=$("input[name='id']").val();
		  //获取传递的参数
		  var requestData={
				          "id":id,
						  "realName":data.field.realName,
						  "password":data.field.password,
						  "phone":data.field.phone,
						  "level":data.field.level,
						  "parentId":data.field.parentId,
						  "experience":data.field.experience
		              };
	      $.ajax({
	    	  type:"POST",
	    	  url:"<%=request.getContextPath()%>/admin/sales/insertAndUpdate",
	    	  data:requestData,
	    	  dataType:"json",
	    	  async:false,
	    	  success:function(result){
	    		  var code=result.code;
    			  var msg=result.message;
    			  var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
    			  parent.layer.close(index);//关闭父页面的弹窗
    			  //刷新页面
    			  parent.location.reload();
    			  alert(msg);
    			  window.location.href="<%=request.getContextPath()%>/admin/sales/list";
	    	  },
	    	  error:function(){
	    		  layer.msg("新增数据异常", {icon: 1,time: 1200},function(){
    				  var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	    			  parent.layer.close(index);//关闭父页面的弹窗
    			  });
	    	  }
	      });
	  });
})
</script>
</html>