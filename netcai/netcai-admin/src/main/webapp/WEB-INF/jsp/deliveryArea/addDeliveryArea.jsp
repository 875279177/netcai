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
		   <label class="layui-form-label">区域选择:省</label>
		   <div class="layui-input-inline">
		     <select id="province" name="provinceId"  lay-filter="province">
		       <option value="">请选择省</option>
		       <c:forEach items="${requestScope.provice}" var="r"> 
		         <option value="${r.id }" >${r.areaName }</option>
		       </c:forEach>
		     </select>
		   </div>
		   <label class="layui-form-label">市</label>
		   <div class="layui-input-inline">
		     <select id="city" name="cityId" lay-filter="city">
		       <option value="">请选择市</option>
		     </select>
		   </div>
		   <label class="layui-form-label">区</label>
		   <div class="layui-input-inline">
		     <select id="region" name="regionId">
		       <option value="">请选择县/区</option>
		     </select>
		   </div>
	   </div>
	</div>
    <div class="layui-form-item">
      <div class="layui-inline">
	    <label class="layui-form-label">详细地址</label>
	    <div class="layui-input-inline">
	      <input type="text" name="address" placeholder="请输入详细地址" lay-verify="required" class="layui-input" value="${deliveryArea.address }" style="width:518px;">
	    </div>
	    <div class="layui-input-inline">
	      <input type="hidden" name="id" value="${deliveryArea.id }" >
	    </div>
	  </div>
    </div>
    <div class="layui-input-block" style="margin-top:30px;margin-left:425px;">
      <button class="layui-btn" lay-submit="" lay-filter="addDelivery">确定</button>
      <button class="layui-btn" id="cancleSubmit" >取消</button>
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
	  });
	  //关闭弹窗
	  $("#cancleSubmit").click(function(){
		  var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		  parent.layer.close(index);//关闭父页面的弹窗
		  return false;
	  })
	  //获取id
      var id = $("input[name='id']").val();
      
	  //加载所选省下得所有市
	  form.on('select(province)', function(data){
          $.getJSON("<%=request.getContextPath()%>/admin/city/list?provinceId="+data.value, function(data){
              var optionstring = "";
              $.each(data.object, function(i,item){
                  optionstring += "<option value=\"" + item.id + "\" >" + item.areaName + "</option>";
              });
              $("#city").html('<option value=""></option>' + optionstring);
              form.render('select'); //重新渲染
          });
      });
	  //加载所选市下得所有区
	  form.on('select(city)', function(data){
          $.getJSON("<%=request.getContextPath()%>/admin/region/list?cityId="+data.value, function(data){
              var optionstring = "";
              $.each(data.object, function(i,item){
                  optionstring += "<option value=\"" + item.id + "\" >" + item.areaName + "</option>";
              });
              $("#region").html('<option value=""></option>' + optionstring);
              form.render('select'); //重新渲染
          });
      });
	  
	  //监听提交
	  form.on('submit(addDelivery)', function(data){
		  //获取传递的参数
		  var requestData={
					          "id":id,
							  "areaId":data.field.regionId,
							  "address":data.field.address
			              };
	      $.ajax({
	    	  type:"POST",
	    	  url:"<%=request.getContextPath()%>/admin/deliveryArea/insertAndUpdate",
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