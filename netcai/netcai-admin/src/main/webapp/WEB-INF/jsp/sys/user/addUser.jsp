<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增系统用户</title>
<link rel="stylesheet" href="/layui/css/layui.css"  media="all">
<script type="text/javascript" src="/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/js/jquery.formPlugin.js"></script>
<script type="text/javascript" src="/js/jquery.form.js"></script>
<style type="text/css">
  .layui-input-inline{
    margin-left:30px;
  }
  .layui-input-inline{
    padding:5px;
  }
</style>
<script type="text/javascript">

</script>
</head>
<body>
 <form id="saleForm" class="layui-form" style="margin-top:30px;">
     <div class="layui-form-item" >
	   <div class="layui-inline">
	     <label class="layui-form-label">用&nbsp;&nbsp;户&nbsp;&nbsp;名</label>
	     <div class="layui-input-inline">
	       <input type="text" name="userName" placeholder="请输入用户名" lay-verify="required" value="${user.userName }" class="layui-input">
	     </div>
	     <label class="layui-form-label">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码</label>
		 <div class="layui-input-inline">
		   <input type="password" name="password" placeholder="请输入密码" lay-verify="" class="layui-input">
		 </div>
		 <div class="layui-input-inline">
		   <input type="text" name="id" style="display:none;" class="layui-input">
		 </div>
	   </div>
	   <div class="layui-inline">
	     <label class="layui-form-label">真实姓名</label>
	     <div class="layui-input-inline">
	       <input type="text" name="name" placeholder="请输入真实姓名" lay-verify="required" value="${user.name }" class="layui-input">
	     </div>
		 <label class="layui-form-label">手&nbsp;&nbsp;机&nbsp;&nbsp;号</label>
	     <div class="layui-input-inline">
	       <input type="tel" name="phone" placeholder="请输入手机号" lay-verify="phone" value="${user.phone }" class="layui-input">
	     </div>
	   </div>
	   <div class="layui-inline">
	     <label class="layui-form-label">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱</label>
	     <div class="layui-input-inline">
	       <input type="text" name="email" placeholder="请输入邮箱" lay-verify="email" value="${user.email}" class="layui-input">
	     </div>
		 <label class="layui-form-label">备注信息</label>
	     <div class="layui-input-inline">
	       <input type="text" name="remarks" placeholder="请输入备注信息" value="${user.remarks}" class="layui-input">
	     </div>
	   </div>
	   <div class="layui-inline">
	     <label class="layui-form-label">请选择角色</label>
	     <div class="layui-input-inline">
	         <c:forEach items="${sysRoleList}" var="role"> 
	            <input type="checkbox" name="roleIds" value="${role.id}" id="check_${role.id}">${role.roleName}
	         </c:forEach>
	     </div>
	   </div>
	 </div>
	 <div class="layui-input-block" style="margin-top:30px;margin-left:324px;">
       <button class="layui-btn" name="commit" lay-submit="" lay-filter="addData">确定</button>
       <button class="layui-btn" name="cancleSubmit" >取消</button>
     </div>
  </form>
</body>
<script src="/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript">
//提交表单数据
layui.use(['form', 'jquery', 'layedit', 'laydate'], function(){
	  var $ = layui.jquery,form = layui.form(),layer = layui.layer,
	  layedit = layui.layedit,laydate = layui.laydate;
	  form.verify({
		  //验证密码
		  pass:[/^[\w]{6,12}$/, '请输入写6到12位密码'],
		  //验证手机号
	      phone: [/^1[34578]\d{9}$/, '请输入正确的手机号'],
	      email:[/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/,'请输入正确的邮箱']
	  });
	  
	  //监听提交
	  form.on('submit(addData)', function(data){
		//获取选中数据的id(点击修改按钮时)
		  var id=$("input[name='id']").val();
		  var msg = "新增数据成功";
		  if(id != null){
			  msg = "更新数据成功";
		  }
		  var roleIds="";
		  $('input[name="roleIds"]:checked').each(function(){ 
			  roleIds += $(this).val()+","; 
		  });
		  if(roleIds==""){
			  alert("请选择角色");
			  return;
		  }
		  roleIds = roleIds.substr(0,roleIds.length-1); 
		  //获取传递的参数
		  var requestData={
				          "id":id,
						  "userName":data.field.userName,
						  "password":data.field.password,
						  "name":data.field.name,
						  "phone":data.field.phone,
						  "email":data.field.email,
						  "remarks":data.field.remarks,
						  "roleIds":roleIds
		              };
	      $.ajax({
	    	  type:"POST",
	    	  url:"<%=request.getContextPath()%>/admin/sysUser/insertAndUpdate",
	    	  data:requestData,
	    	  dataType:"json",
	    	  success:function(result){
	    		  var code = result.code;
	    		  var msg = result.message;
	    		  if(code=="200" || code=="201"){
	    			  alert(msg);
    				  var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	    			  parent.layer.close(index);//关闭父页面的弹窗
	    			  //刷新页面
	    			  parent.location.reload();
	    		  }
	    	  },
	    	  error:function(){
	    		  layer.msg("更新数据异常", {icon: 1,time: 1200},function(){
    				  var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	    			  parent.layer.close(index);//关闭父页面的弹窗
    			  });
	    	  }
	      });
	  });
})
<c:forEach items="${myRoleList}" var="m" varStatus="status"> 
   $(('#check_${m.id}')).attr("checked",true);
</c:forEach>
</script>
</html>