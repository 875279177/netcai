<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增多退少补</title>
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
</head>
<body>
 <form id="saleForm" class="layui-form" style="margin-top:30px;">
     <div class="layui-form-item" >
       <div class="layui-inline">
         <label class="layui-form-label">订单号：</label>
	     <div class="layui-input-inline">
		   <input type="text" id="orderNumber" value="${requestScope.orderNumber}" class="layui-input" readOnly >
	     </div>
	     <label for="createTime" class="layui-form-label">日期选择：</label>
         <div class="layui-input-inline">
           <input class="layui-input" id="createTime" placeholder="请选择日期" lay-verify="required" onfocus="WdatePicker({skin:'whyGreen',maxDate:'%y-%M-{%d-1}'})">
         </div>
	   </div>
	   <div class="layui-inline">
	     <label class="layui-form-label">卖家金额：</label>
	     <div class="layui-input-inline">
	       <input type="text" name="sellerMoney" placeholder="请输入金额" lay-verify="money" class="layui-input">
	     </div>
	     <label class="layui-form-label">买家金额：</label>
	     <div class="layui-input-inline">
	       <input type="text" name="buyerMoney" placeholder="请输入金额" lay-verify="money" class="layui-input">
	     </div>
       </div>
	   <div class="layui-inline">
	     <label class="layui-form-label">原因1：</label>
	     <div class="layui-input-inline">
	       <select id="user_reason"  > 
	         <option value="" >请选择</option>
	         <c:forEach items="${requestScope.userReasons}" var="r"> 
	           <option value="${r.id }" >${r.name }</option>
	         </c:forEach>
	       </select>
	     </div>
	     <label class="layui-form-label">原因2：</label>
	     <div class="layui-input-inline">
	       <select id="our_reason"   > 
	         <option value="" >请选择</option>
	         <c:forEach items="${requestScope.ourReasons}" var="r"> 
	           <option value="${r.id }" >${r.name }</option>
	         </c:forEach>
	       </select>
	     </div>
	   </div>
	   <div class="layui-inline">
		 <div class="layui-input-inline">
		   <input type="hidden" name="buyerId" value="${requestScope.buyerId}" class="layui-input">
		   <input type="hidden" name="sellerId" value="${requestScope.sellerId}" class="layui-input">
		   <input type="hidden" name="orderNumber" value="${requestScope.orderNumber}" class="layui-input">
		 </div>
	   </div>
	   <div class="layui-form-item layui-form-text">
	     <label class="layui-form-label">详细说明：</label>
	     <div class="layui-input-block">
	       <textarea placeholder="请输入内容" lay-verify="remark" name="remark" class="layui-textarea" style="margin-left:35px;width:541px;"></textarea>
	     </div>
	   </div>
	 </div>
	 <div class="layui-input-block" style="margin-top:30px;margin-left:324px;">
       <button id="save_btn" class="layui-btn" name="commit" lay-submit="" lay-filter="addData">确定</button>
       <button class="layui-btn" id="cancleSubmit" >取消</button>
     </div>
  </form>
</body>
<script src="/layui/layui.js" charset="utf-8"></script>
<script charset="utf-8" src="/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
//提交表单数据
layui.use(['form', 'jquery', 'layedit', 'laydate'], function(){
	  var $ = layui.jquery,form = layui.form(),layer = layui.layer,
	  layedit = layui.layedit,laydate = layui.laydate;
	  var reg = /^[^\/]+(\/[^\/]+)+$/;
	  form.verify({
		  //验证金额
		  money:[/^(-)?\d{1,4}(\.\d{1,2})?$/, '请输入正确的格式'],
		  remark: function(value){
			  if(value.indexOf("/")==-1){
				  return '未选取分割号/';
			  }
				  if (!reg.exec(value)) {
			            return "格式有误，请重新填写！";
			        }
		  }
	  });
	  //关闭弹窗
	  $("#cancleSubmit").click(function(){
		  var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		  parent.layer.close(index);//关闭父页面的弹窗
		  return false;
	  })
	  
	  //监听提交
	  form.on('submit(addData)', function(data){
		  //提交数据之后将确定按钮禁用
		  var saveBtn=$("#save_btn");
		  saveBtn.attr("disabled","disabled");
		  saveBtn.css("background","#C0C0C0");
		  var time =$("#createTime").val();
		  var refundCauseIds ="";
		  if($("#user_reason").val()!=null&&$("#user_reason").val()!=""){
			  refundCauseIds += $("#user_reason").val();
		  }
		  if($("#our_reason").val()!=null&&$("#our_reason").val()!=""){
			  if(refundCauseIds==""){
				  refundCauseIds += $("#our_reason").val();
			  }else{
				  refundCauseIds +=","+$("#our_reason").val();
			  }
		  }
		  //获取传递的参数
		  var requestData={
				          "buyerId":data.field.buyerId,
				          "sellerId":data.field.sellerId,
				          "orderNumber":data.field.orderNumber,
						  "sellerMoney":data.field.sellerMoney,
						  "buyerMoney":data.field.buyerMoney,
						  "remark":data.field.remark,
						  "refundCauseIds":refundCauseIds,
						  "time":time
		              };
	      $.ajax({
	    	  type:"POST",
	    	  url:"<%=request.getContextPath()%>/admin/orderRefund/insert",
	    	  data:requestData,
	    	  dataType:"json",
	    	  success:function(result){
    			  var msg=result.message;
    			  parent.layer.msg(msg, {shade: 0.3} ,{time: 3500});
    			  var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
    			  parent.layer.close(index);//关闭父页面的弹窗
    			  //刷新页面
    			  parent.location.reload();
	    	  }
	      });
	  });
})

</script>
</html>