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
</style>
</head>
<body>
 <form class="layui-form" style="margin-top:30px;">
    <div class="layui-form-item" >
       <div class="layui-inline">
	       <label class="layui-form-label">区域选择:</label>
		   <div class="layui-input-inline">
		     <select id="region" name="regionId" <c:if test="${delivery.id==null }">lay-verify="required"</c:if>>
		       <option value="">请选择</option>
		       <c:forEach items="${regions }" var="r"> 
		         <option value="${r.id }" <c:if test="${r.id==delivery.areaId }">selected</c:if>   >${r.areaName}</option>
		       </c:forEach>
		     </select>
		   </div>
		   <label class="layui-form-label">姓名</label>
	       <div class="layui-input-inline">
	         <input type="text" name="deliveryName" placeholder="请输入姓名" lay-verify="required" class="layui-input" value="${delivery.deliveryName }">
	       </div>
	       <label class="layui-form-label">手机号</label>
		   <div class="layui-input-inline">
		     <input type="text" name="deliveryPhone" placeholder="请输入手机号" lay-verify="phone" class="layui-input" value="${delivery.deliveryPhone }" <c:if test="${delivery.id!=null }">disabled="disabled"</c:if>>
		   </div>
	   </div>
	   <div class="layui-inline">
		 <label class="layui-form-label">密码</label>
		 <div class="layui-input-inline">
		   <input type="password" name="deliveryPassword" placeholder="请输入密码" class="layui-input" <c:if test="${delivery.id==null }">lay-verify="pass"</c:if> >
		 </div>
		 <label class="layui-form-label">年龄</label>
		 <div class="layui-input-inline">
		   <input type="text" name="deliveryAge" placeholder="请输入年龄" class="layui-input" value="${delivery.deliveryAge }">
		 </div>
		 <label class="layui-form-label">性别</label>
		 <div class="layui-input-inline">
		   <input type="radio" name="deliverySex" value="1" title="男" checked="">
		   <input type="radio" name="deliverySex" value="2" title="女" <c:if test="${delivery.deliverySex==2 }">checked</c:if>>
		 </div>
	   </div>
	   <div class="layui-inline">
		 <label class="layui-form-label">配送类型</label>
		 <div class="layui-input-inline">
		   <select name="deliveryType">
	         <option value="">请选择</option>
	         <option value="1" <c:if test="${delivery.deliveryType==1 }">selected</c:if>>自营</option>
	         <option value="2" <c:if test="${delivery.deliveryType==2 }">selected</c:if>>加盟</option>
	       </select>
		 </div>
		 <label class="layui-form-label">身份证号</label>
		 <div class="layui-input-inline">
		   <input type="text" name="deliveryIdCard" placeholder="请输入身份证号" class="layui-input" value="${delivery.deliveryIdCard }">
		 </div>
		 <label class="layui-form-label">操作权限</label>
		 <div class="layui-input-inline">
		   <select name="permissionType">
	         <option value="">请选择</option>
	         <option value="0" <c:if test="${delivery.permissionType==0 }">selected</c:if>>查看</option>
	         <option value="1" <c:if test="${delivery.permissionType==1 }">selected</c:if>>可操作</option>
	       </select>
		 </div>
	   </div>
	   <div class="layui-inline">
	     <label class="layui-form-label">备注信息</label>
	     <div class="layui-input-inline">
	       <input type="text" name="remark" autocomplete="off" class="layui-input" value="${delivery.remark }" style="width:519px;">
	     </div>
	     <div class="layui-input-inline">
	       <input type="text" name="id" value="${delivery.id }" class="layui-input" style="display:none">
	     </div>
	   </div>
       <div class="layui-input-block" style="margin-top:30px;margin-left:450px;">
         <button class="layui-btn" lay-submit="" lay-filter="addDelivery">确定</button>
         <button class="layui-btn" id="cancleSubmit" >取消</button>
       </div>
     </div>
  </form>
</body>
<script src="/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/js/jquery.formPlugin.js"></script>
<script type="text/javascript" src="/js/jquery.form.js"></script>
<script type="text/javascript">
layui.use(['form', 'jquery', 'layedit', 'laydate'], function(){
	  var $ = layui.jquery,form = layui.form(),layer = layui.layer,
	  layedit = layui.layedit,laydate = layui.laydate;
	  //自定义验证
	  form.verify({
		 //验证手机号
	     phone: [/^1[34578]\d{9}$/, '请输入正确的手机号'],
	     //验证密码
	     pass:[/^[\w]{6,12}$/,'请输入6-12位密码(由字母和数字组成)']
	  });
	  //关闭弹窗
	  $("#cancleSubmit").click(function(){
		  var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		  parent.layer.close(index);//关闭父页面的弹窗
		  return false;
	  })
	  //获取deliveryId
      var deliveryId = $("input[name='id']").val();
      
	  //监听提交
	  form.on('submit(addDelivery)', function(data){
		  //获取传递的参数
		  var requestData={
					          "id":deliveryId,
							  "areaId":data.field.regionId,
							  "deliveryName":data.field.deliveryName,
							  "deliveryPhone":data.field.deliveryPhone,
							  "deliveryPassword":data.field.deliveryPassword,
							  "deliveryAge":data.field.deliveryAge,
							  "deliveryType":data.field.deliveryType,
							  "deliverySex":data.field.deliverySex,
							  "deliveryIdCard":data.field.deliveryIdCard,
							  "permissionType":data.field.permissionType,
							  "remark":data.field.remark
		                   };
	      $.ajax({
	    	  type:"POST",
	    	  url:"<%=request.getContextPath()%>/admin/delivery/insertAndUpdate",
	    	  data:requestData,
	    	  async:false,
	    	  success:function(result){
    			  var msg=result.message;
    			  alert(msg);
    			  var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
    			  parent.layer.close(index);//关闭父页面的弹窗
    			  //刷新页面
    			  parent.location.reload();
	    			  
	    	  }
	      });
	  });
	  
	});
</script>
</html>