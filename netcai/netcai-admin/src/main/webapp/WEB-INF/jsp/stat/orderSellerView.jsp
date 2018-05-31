<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="pv" uri="/pageTaglib"%>  
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title></title>
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- 引入公共部分jsp文件 -->
  <meta name="decorator" content="default"/>
  <style type="text/css">
    .layui-form-label{
      width:100px;
    }
    .layui-input-block{
      width:auto;
      height:auto;
    }
    table th{
      background:#ffffff;
    }
	table tr:nth-child(odd){
	  background:#F0F0F0;
	}
	.col-sm-2 {
	  width: 10%;
	}
	.box-footer{
	  text-align:center;
	}
  </style>
</head>
<body class="hold-transition skin-blue sidebar-mini">
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>实时营收额</h1>
    </section>
    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
            </div>
            
            <div style="margin-top:10px;">
	           <form  id="form_submit" class="form-horizontal" action="<%=request.getContextPath()%>/index/orders/today" method="post">
	             <div class="col-xs-12">
		             <div class="form-group">
		                 <label for="saleId" class="col-xs-2 control-label">销售姓名</label>
		                 <div class="col-xs-2" style="width: 180px">
		                   <select id="saleId" name="saleId" class="form-control" >
		                   <option value="" >全部</option>
						   </select>
		                 </div>
		                 <label for="areaId" class="col-xs-2 control-label">区域：</label>
		                 <div class="col-xs-2" style="width: 180px">
		                   <select id="areaId" name="regionId" class="form-control" >
						   </select>
		                 </div>
		                 <label for="areaId" class="col-xs-2 control-label">付款类型：</label>
		                 <div class="col-xs-2" style="width: 180px">
		                   <select name="payStatus" class="form-control" >
		                  		 <option value="" >全部</option>	
		                   		<option value="3" <c:if test="${orderInfo.payStatus == 3}">selected</c:if>>线下付款</option>
		                   		<option value="2" <c:if test="${orderInfo.payStatus == 2}">selected</c:if>>已支付</option>
						   </select>
		                 </div>
		             </div>
	             </div>
		             <div class="form-footer" >
		               <button type="submit" class="btn btn-info pull-left btn-select">查询</button>
		               <button type="reset" id="reset" class="btn btn-info pull-left">重置</button>
		             </div>
	           </form>
	        </div>
	        
	        <div class="layui-form-item" style="margin:0 auto">
	        	<c:set var="sum" value="0"></c:set>
	        	<c:set var="sumXX" value="0"></c:set>
	        	<c:set var="sumXS" value="0"></c:set>
              	 <c:forEach items="${orderList}" var="r" varStatus="status"> 
              	 <c:set var="sum" value="${sum+r.totalAmount}"></c:set>
              	 <c:if test="${r.payStatus==3}">
              	 	<c:set var="sumXX" value="${sumXX+r.totalAmount}"></c:set>
              	 </c:if>
              	 <c:set var="sumXX" value="${sumXX+0}"></c:set>
              	 <c:if test="${r.payStatus!=3}">
              	 	<c:set var="sumXS" value="${sumXS+r.totalAmount}"></c:set>
              	 </c:if>
              	 <c:set var="sumXS" value="${sumXS+0}"></c:set>
            	</c:forEach> 
			    <label class="layui-form-label" style="width: 100px"><strong style="color: blue;">总计 :</strong></label>
			    <label class="layui-form-label" style="width: 50px"><strong style="color: red;">${fn:length(orderList) }</strong></label>
			    <label class="layui-form-label" style="width: 150px"><strong style="color: blue;">实付款金额总计 :</strong></label>
			    <label class="layui-form-label" style="width: 50px"><strong style="color: red;">${sum }</strong></label>
			    			    <label class="layui-form-label" style="width: 150px"><strong style="color: blue;">线下付款总计 :</strong></label>
			    <label class="layui-form-label" style="width: 50px"><strong style="color: red;">${sumXX }</strong></label>
			    <label class="layui-form-label" style="width: 150px"><strong style="color: blue;">线上付款总计 :</strong></label>
			    <label class="layui-form-label" style="width: 50px"><strong style="color: red;">${sumXS }</strong></label>
			  </div>
	        
	        
            <table class="layui-table" lay-skin="row">
              <thead>
	            <tr>
	              <th>序号</th>
	              <th>所属区域</th>
	              <th>销售姓名</th>
	              <th>买家店铺</th>
	              <th>销售额</th>
	              <th>付款状态</th>
	            </tr>
	          </thead>
	          <tbody>
                <c:forEach items="${orderList}" var="r" varStatus="status"> 
	   			  <tr>
		   			  	<td><c:out value="${status.count}"/> </td>
		   			    <td>${r.areaName}</td>
		   			    <td>${r.salesName}</td>
		   			    <td>${r.buyer.buyerName}</td>
			            <td ><a style="color: blue;" href="/admin/orderItem/getAll?orderNumber=${r.orderNumber}&pageSize=30">${r.totalAmount }</a></td>
			            <td >
			            	<c:if test="${r.payStatus ==2}">已支付</c:if>
				          	<c:if test="${r.payStatus ==3}">线下付款</c:if>
			            </td>
	              </tr>
			    </c:forEach>
             </tbody>
            </table>
          </div>
        </div>
      </div>
    </section>
  </div>
  <input type="hidden" id="saleIdVO" value="${orderInfo.saleId}"/>
       <input type="hidden" id="areaIdVO" value="${orderInfo.regionId}"/>
<script src="/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="/bootstrap/js/bootstrap.min.js"></script>
<script src="/js/raphael-min.js"></script>
<script src="/plugins/sparkline/jquery.sparkline.min.js"></script>
<script src="/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script src="/plugins/knob/jquery.knob.js"></script>
<script src="/js/moment.min.js"></script>
<script src="/plugins/daterangepicker/daterangepicker.js"></script>
<script src="/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script src="/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="/plugins/fastclick/fastclick.js"></script>
<script src="/dist/js/app.min.js"></script>
<script src="/dist/js/demo.js"></script>
<script src="/js/jquery-ui.min.js"></script>
<script src="/layui/layui.js" charset="utf-8"></script>
<script>


//重置
$(function(){
   $("#reset").click(function(){
	   window.location.href="/index/orders/today";
  });
});
//获取销售人员列表;
$(document).ready(function(){
	loadsaleId(); 
	loadregion(); 
	}); 
	
var saleId = $('#saleIdVO').val();
function loadsaleId(){
	if(saleId == null || saleId == '' ||saleId == undefined){
		saleId = 0;
	}
	  var url='/admin/sales/salesList'; 
	  jQuery.ajax({ 
	    type:'post', 
	    url:url, 
	    async:false,
	    success:function (date){
   	   var r = date.object;  
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
	
	
var areaId = $('#areaIdVO').val();
function loadregion(){
	if(areaId == null || areaId == '' ||areaId == undefined){
		areaId = 0;
	}
	  var url='/admin/region/Alllist'; 
	  jQuery.ajax({ 
	    type:'post', 
	    url:url, 
	    async:false,
	    success:function (date){
   	   var areaList = date.object;  
         if(areaList != null && areaList.length > 0){
        	 if(areaId == 0){
        	 $("<option value='' selected>"+"全部"+"</option>").appendTo("#areaId");
        	 }else{
        		 $("<option value=''>"+"全部"+"</option>").appendTo("#areaId");
        	 }
             for(var i = 0; i< areaList.length; i++){
                 if(areaList[i].id == areaId){
              	   $("<option value='"+areaList[i].id+"' selected>"+areaList[i].areaName+"</option>").appendTo("#areaId");
                 }else {
                 $("<option value='"+areaList[i].id+"'>"+areaList[i].areaName+"</option>").appendTo("#areaId");  
				}
             }  
         } 
	    } 
	  }); 
	}
</script>
</body>
</html>