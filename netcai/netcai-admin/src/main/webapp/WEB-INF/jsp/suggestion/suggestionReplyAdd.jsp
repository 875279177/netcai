<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增</title>
<link rel="stylesheet" href="/layui/css/layui.css"  media="all">
<style type="text/css">
  .layui-input-inline{
    margin-left:8px;
  }
  .layui-input-inline{
    padding:5px;
  }
  select{
    width:10px;
  }
  img{
    margin:8px;
    height:150px;
    width:300px;
    display:none;
  }
</style>
</head>
<body>
 <form id="sellerFrom" class="layui-form" action="" style="margin-top:30px;">
    <div class="layui-form-item" >
    <input type="text" id="suggestionId" name="suggestionId" style="display:none;" value="${suggestionId}" class="layui-input">
	   <div class="layui-inline">
	     <label class="layui-form-label">回复内容</label>
	     <div class="layui-input-inline">
	       <textarea placeholder="请输入回复内容" lay-verify="" class="layui-textarea" lay-verify="content" name="content" style="width: 600px"></textarea>
	     </div>
	 </div>
     <div class="layui-input-block" style="margin-top:30px;margin-left:324px;">
        <button class="layui-btn"  lay-submit="" lay-filter="addData">确定</button>
       <button class="layui-btn" id="cancleSubmit" name="cancleSubmit" >取消</button>
     </div>
  </form>
</body>
<script src="/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="/js/jquery.formPlugin.js"></script>
<script type="text/javascript" src="/js/jquery.form.js"></script>
<script type="text/javascript">
layui.use(['form', 'jquery', 'layedit', 'laydate','upload'], function(){
	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	  var $ = layui.jquery,form = layui.form(),
	  layer = layui.layer,
	  layedit = layui.layedit,
	  laydate = layui.laydate;
	//关闭弹窗
	  $("#cancleSubmit").click(function(){
		  parent.layer.close(index);//关闭父页面的弹窗
		  return false;
	  })
	  
	
		//监听提交
	  form.on('submit(addData)', function(data){
		  var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		  
		  var requestData={
				          "suggestionId":data.field.suggestionId,
						  "content":data.field.content
		              };
	      $.ajax({
	    	  type:"POST",
	    	  url:"<%=request.getContextPath()%>/admin/suggestionReply/add",
	    	  data:requestData,
	    	  async:false,
	    	  cache: false,
	    	  success:function(result){
	    			alert(result.message);
    			  parent.layer.close(index);//关闭父页面的弹窗
    			  parent.location.reload();
	    	  },error:function(){
	    		  layer.msg("更新数据异常", {icon: 1,time: 1200},function(){
	    			  console.log(index);
	    			  parent.layer.close(index);//关闭父页面的弹窗
    			  });
	    	  }
	      });
	  });
	  
	});
</script>
</html>