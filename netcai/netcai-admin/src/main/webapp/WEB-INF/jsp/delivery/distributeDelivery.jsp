<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分配配送人员</title>
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
    <div class="layui-form-item">
      <div class="layui-inline">
	       <label class="layui-form-label">配送区域:</label>
		   <div class="layui-input-block">
		     <c:forEach items="${requestScope.deliveryAreas}" var="r"> 
		       <input type="checkbox" name="deliveryArea" title="${r.address }" value="${r.id }" <c:if test="${r.checked==1 }">checked</c:if> >
	         </c:forEach>
		   </div>
		  </div>
	    <div class="layui-input-inline">
	      <input type="hidden" name="deliveryId" value="${deliveryId }" >
	    </div>
	  </div>
    </div>
    <div class="layui-input-block" style="margin-top:45px;margin-left:295px;">
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
	  //关闭弹窗
	  $("#cancleSubmit").click(function(){
		  var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		  parent.layer.close(index);//关闭父页面的弹窗
		  return false;
	  })
	  //监听提交
	  form.on('submit(addDelivery)', function(data){
		  //获取传递的参数
		  var deliveryAreaIds="";
		  var count = 0;
		  $('input[name="deliveryArea"]:checked').each(function(){ 
			  deliveryAreaIds += $(this).val()+","; 
		  });
		  if(deliveryAreaIds.indexOf(",")!=-1){
			  deliveryAreaIds = deliveryAreaIds.substr(0,deliveryAreaIds.length-1); 
		  }
		  var requestData={
							  "deliveryId":data.field.deliveryId,
							  "deliveryAreaIds":deliveryAreaIds
			              };
	      $.ajax({
	    	  type:"POST",
	    	  url:"<%=request.getContextPath()%>/admin/deliveryArea/distributeDelivery",
	    	  data:requestData,
	    	  async:false,
	    	  success:function(result){
	    		  alert(result.message);
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