<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>快速配置页面</title>
<link rel="stylesheet" href="/layui/css/layui.css"  media="all">
<style type="text/css">
  .layui-input-inline{
    margin-left:8px;
  }
  .layui-input-inline{
    padding:5px;
  }
  select>option{
    width:100px;
  }
  ul li{
    float:left; 
    list-style-type:none;
    border:1px red;
  } 
  img{
    margin:8px;
    height:125px;
    width:275px;
    display:none;
  }
  .buyer_logo>img{
    margin-left:35px;
    margin-right:120px;
  }
</style>
</head>
<body>
  <form class="layui-form" style="margin-top:30px;">
    <div class="layui-form-item" >
       <div class="layui-inline">
	     <div class="layui-form-item">
		   <label class="layui-form-label">区域选择：</label>
		   <div class="layui-input-inline">
		     <select id="region" name="regionId" lay-filter="region" lay-verify="required" >
		       <option value="" >请选择</option>
		       <c:forEach items="${regions }" var="r">
		         <option value="${r.id }" >${r.areaName }</option>
		       </c:forEach>
		     </select>
		   </div>
		 </div>
	   </div>
	   <div class="layui-inline">
	     <label class="layui-form-label">卖家商铺：</label>
	     <div class="layui-input-inline">
		   <select id="seller" name="sellerId" lay-filter="seller" lay-verify="required" >
		     <option value="" selected>请选择</option>
		   </select>
		 </div>
		 <label class="layui-form-label">抽点率：</label>
	     <div class="layui-input-inline">
	       <input type="text" name="percentage" placeholder="请输入抽点率" lay-verify="required" class="layui-input" >
	     </div>
	   </div>
       <div class="layui-input-block" style="margin-top:30px;margin-left:450px;">
         <button class="layui-btn" lay-submit="" lay-filter="addBuyer">确定</button>
         <button class="layui-btn" id="cancleSubmit" name="cancleSubmit" >取消</button>
       </div>
    </div>
  </form>
</body>
<script src="/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/js/jquery.formPlugin.js"></script>
<script type="text/javascript" src="/js/jquery.form.js"></script>
<script type="text/javascript">
layui.use(['form', 'jquery', 'layedit', 'laydate','upload'], function(){
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
	  form.on('submit(addBuyer)', function(data){
		  //获取传递的参数
		  var requestData={
							  "regionId":data.field.regionId,
							  "sellerId":data.field.sellerId,
							  "percentage":data.field.percentage
			              };
	      $.ajax({
	    	  type:"POST",
	    	  url:"<%=request.getContextPath()%>/admin/percentageConfig/insertBySellerId",
	    	  data:requestData,
	    	  async:false,
	    	  success:function(result){
	    		  var code=result.code;
	    		  var msg = result.message;
	    		  alert(msg);
	    		  var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
    			  parent.layer.close(index);//关闭父页面的弹窗
    			  //刷新页面
    			  parent.location.reload();
    			  window.location.href="/admin/percentageConfig/list";
	    	  }
	      });
	  });
});
</script>
</html>