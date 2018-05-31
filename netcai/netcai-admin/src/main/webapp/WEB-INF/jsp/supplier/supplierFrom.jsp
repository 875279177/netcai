<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>供应商</title>
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
    <input type="text" id="supplierId" name="supplierId" style="display:none;" value="${supplier.supplierId}" class="layui-input">
	   <div class="layui-inline">
	     <label class="layui-form-label">供应商名称</label>
		 <div class="layui-input-inline">
		   <input type="text" name="supplierName" placeholder="请输入供应商名称" value="${supplier.supplierName}" lay-verify="required" class="layui-input">
		 </div>
		 <label class="layui-form-label">联系人</label>
	     <div class="layui-input-inline">
	       <input type="text" name="supplierContact" placeholder="请输入供应商联系人" value="${supplier.supplierContact}" lay-verify="required" class="layui-input">
	     </div>
    	  <label class="layui-form-label">联系方式</label>
	     <div class="layui-input-inline">
	       <input type="text" name="supplierTel" placeholder="请输入手机号码" value="${supplier.supplierTel}" lay-verify="supplierTel" class="layui-input">
	     </div>
	   </div>
	   <div class="layui-inline">
	   	<label class="layui-form-label">供应商账号</label>
	     <div class="layui-input-inline">
	       <input type="text" name="supplierAccount" placeholder="请输入供应商账号" value="${supplier.supplierAccount}" lay-verify="supplierAccount" class="layui-input">
	     </div>
	   	<label class="layui-form-label">密码</label>
	     <div class="layui-input-inline">
	       <input type="text" name="supplierPassword" placeholder="请输入6位数字密码"  lay-verify="supplierPassword" class="layui-input">
	     </div>
	     <label class="layui-form-label">备注信息</label>
	     <div class="layui-input-inline">
	       <input type="text" name="remarks" lay-verify="" autocomplete="off" value="${supplier.remarks}" class="layui-input" >
	     </div>
	 </div>
	 
	   </div>
     <div class="layui-input-block" style="margin-top:30px;margin-left:324px;">
        <button class="layui-btn"  lay-submit="" lay-filter="addData">确定</button>
       <button class="layui-btn" id="cancleSubmit" name="cancleSubmit" >取消</button>
     </div>
  </form>
</body>
<script src="/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="/js/jquery.formPlugin.js"></script>
<script type="text/javascript" src="/js/jquery.form.js"></script>
<script src="/bootstrap/js/layui-mz-min.js" charset="utf-8"></script>
<script type="text/javascript">
layui.use(['form', 'jquery', 'layedit', 'laydate'], function(){
	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	  var $ = layui.jquery,form = layui.form(),
	  layer = layui.layer,
	  layedit = layui.layedit,
	  laydate = layui.laydate;
		//获取选中数据的id(点击修改按钮时)
		  var supplierId=$("#supplierId").val();
	  //自定义验证
	  if(supplierId=="" || supplierId ==null || supplierId ==undefined){
		  form.verify({
		  supplierTel: [/^1[34578]\d{9}$/, '请输入正确的手机号']
		  ,supplierPassword: [/(.+){6,12}$/, '密码必须6到12位']
		  });
	  }else{
		  form.verify({
		  supplierTel: [/^1[34578]\d{9}$/, '请输入正确的手机号']
		  });
	  }
	//关闭弹窗
	  $("#cancleSubmit").click(function(){
		  parent.layer.close(index);//关闭父页面的弹窗
		  return false;
	  })
		//监听提交
	  form.on('submit(addData)', function(data){
		  var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		//获取图片路径
		  
		  var requestData={
				          "supplierId":data.field.supplierId,
						  "supplierTel":data.field.supplierTel,
						  "supplierAccount":data.field.supplierAccount,
						  "supplierContact":data.field.supplierContact,
						  "supplierName":data.field.supplierName,
						  "supplierPassword":data.field.supplierPassword,
						  "remarks":data.field.remarks
		              };
	      $.ajax({
	    	  type:"POST",
	    	  url:"<%=request.getContextPath()%>/admin/supplier/updateAndAdd",
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