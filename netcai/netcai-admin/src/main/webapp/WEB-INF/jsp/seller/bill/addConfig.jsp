<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
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
 <form id="billForm" class="layui-form" action="" style="margin-top:30px;">
     <div class="layui-form-item" >
	   <div class="layui-inline">
	     <label for="regionId" class="layui-form-label">区域：</label>
		 <div class="layui-input-inline">
		   <select id="regionId" name="regionId" class="form-control" style="width:150px;" lay-filter="region">
		     <option value="">请选择</option>
			 <c:forEach items="${areaList}" var="r"> 
			     <option value="${r.id }" <c:if test="${r.id==billSellerConfig.regionId}">selected</c:if> >${r.areaName }</option>
			 </c:forEach>
		   </select>
		 </div>
	     <label class="layui-form-label">卖家店铺：</label>
	     <div class="layui-input-inline">
		   <select id="seller" name="sellerId" >
		       <option value="" >全部</option>
		   </select>
		 </div>
	   </div>
	   <div class="layui-inline">
	     <label class="layui-form-label">结账周期：</label>
	     <div class="layui-input-block">
	       <input type="radio" name="period" value="1" title="1天">
	       <input type="radio" name="period" value="3" title="3天">
	       <input type="radio" name="period" value="5" title="5天" >
	       <input type="radio" name="period" value="10" title="10天" checked="">
	       <input type="radio" name="period" value="15" title="15天">
	     </div>
	   </div>
	 </div>
	 <div class="layui-input-block" style="margin-top:100px;margin-left:324px;">
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
	  //加载所选区下的所有卖家
	  form.on('select(region)', function(data){
          $.getJSON("<%=request.getContextPath()%>/admin/seller/getByRegionId?regionId="+data.value, function(data){
              var optionstring = "";
              $.each(data.object, function(i,item){
                  optionstring += "<option value=\"" + item.sellerId + "\" >" + item.sellerName + "</option>";
              });
              $("#seller").html('<option value=""></option>' + optionstring);
              form.render('select'); //重新渲染
          });
      });
	  //监听提交
	  form.on('submit(addData)', function(data){
		  //获取传递的参数
		  var requestData={
						  "sellerId":data.field.sellerId,
						  "period":data.field.period
		              };
	      $.ajax({
	    	  type:"POST",
	    	  url:"<%=request.getContextPath()%>/admin/billSellerConfig/insert",
	    	  data:requestData,
	    	  async:false,
	    	  dataType:"json",
	    	  success:function(result){
	    		  var msg = result.message;
	    		  parent.layer.msg(msg, {shade: 0.3} ,{time: 2000})
    			  var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
    			  parent.layer.close(index);//关闭父页面的弹窗
    			  //刷新页面
    			  parent.location.reload(); 
	    		  
    			  
	    	  },
	      });
	  });
	  //弹窗表单的取消操作时关闭弹窗
      $('button[name="cancleSubmit"]').click(function cancleSubmit(){
     	 var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		 parent.layer.close(index);//关闭父页面的弹窗
     	 return ;
      });
})
</script>
</html>