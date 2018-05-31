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
  <meta name="decorator" content="default"/>
  <style type="text/css">
    .layui-form-label {
		width: 100px;
	}
	
	.layui-input-block {
		width: auto;
		height: auto;
	}
	
	table th {
		background: #ffffff;
	}
	
	table tr:nth-child(odd) {
		background: #F0F0F0;
	}
	
	.col-sm-2 {
		width: 10%;
	}
	
	.form-footer {
		margin-right: 800px;
		float: right;
	}
	
	.btn-select {
		margin-right: 10px;
	}
  </style>
</head>
<body>
  <!-- 退/缺货订单详细列表start -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>退/缺货订单详细信息</h1>
    </section>
    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">退/缺货订单列表</h3>
            </div>
            <div class="box box-info">
                <form id="subForm" class="form-horizontal layui-form" action="<%=request.getContextPath()%>/admin/orderItem/redressOrderItems" method="post" >
              	    <div class="box-body">
              	        <div class="col-sm-12">
	                        <div class="form-group" >
	                            <input type="hidden" name="pageNum" id="pageNum" value="${paginator.currentPage}">
                                <input type="hidden" name="pageSize" id="pageSize" value="${paginator.pageRecord}">
	                            <label for="areaId" class="col-sm-2  control-label">区域选择：</label>
			                    <div class="col-xs-2">
			                         <select id="areaId" name="regionId" class="form-control" >
								         <option value="" >全部</option>
							         </select>
			                    </div>
	                            <label for="orderItemorderNumber" class="col-sm-2 control-label">订单号：</label>
			                    <div class="col-xs-2">
				                	<input type="text" class="form-control input-small" id="orderItemorderNumber" name="orderNumber" value="${orderItem.orderNumber}" placeholder="请输入订单号">
				                </div>
	                            <label for="buyerName" class="col-sm-2 control-label">餐馆名称：</label>
			                    <div class="col-xs-2">
				                    <input type="text" class="form-control input-small" id="buyerName" name="buyer.buyerName" value="${orderItem.buyer.buyerName}" placeholder="请输入买家信息">
				                </div>
	                        </div>
	                        <div class="form-group">
	                            <label for="sellerName" class="col-sm-2 control-label">商铺名称：</label>
			                    <div class="col-xs-2">
				                	<input type="text" class="form-control input-small" id="sellerName" name="seller.sellerName" value="${orderItem.seller.sellerName}" placeholder="请输入卖家信息">
				                </div>
				                <label for="createTimeStart" class="col-sm-2 control-label">下单开始时间：</label>
			                    <div class="col-xs-2">
				                	<input type="text" name="createTimeStart" id="createTimeStart" value="${orderItem.createTimeStart}" class="form-control input-small" placeholder="请选择开始时间">
				                </div>
				                <label for="createTimeStop" class="col-sm-2 control-label">下单结束时间：</label>
			                    <div class="col-xs-2">
				                	<input type="text" name="createTimeStop" id="createTimeStop" value="${orderItem.createTimeStop}"  class="form-control" placeholder="请输入结束时间">
				                </div>
	                        </div>
	                        <div class="form-group">
				                <label for="goodsName" class="col-sm-2 control-label">商品名称：</label>
			                    <div class="col-xs-2">
				                	<input type="text" class="form-control input-small" id="goodsName" name="goodsName" value="${orderItem.goodsName}" placeholder="请输入商品名称">
				                </div>
				                <label for="orderStatus" class="col-sm-2 control-label">交易状态：</label>
			                    <div class="col-xs-2">
					                <select id="statusCode" name="statusCode" >
								        <option value="0" <c:if test="${statusCode==0}">selected</c:if>>全部</option>
								        <option value="1" <c:if test="${statusCode==1}">selected</c:if>>缺货流程正常</option>
								        <option value="2" <c:if test="${statusCode==2}">selected</c:if>>缺货流程异常</option>
								        <option value="3" <c:if test="${statusCode==3}">selected</c:if>>退货流程正常</option>
								        <option value="4" <c:if test="${statusCode==4}">selected</c:if>>退货流程异常</option>
								     </select>
				                </div>
				                <label for="goodsNumber" class="col-sm-2 control-label">调重：</label>
			                    <div class="col-xs-2">
					                <select  name="goodsNumber" >
								        <option value="" selected>全部</option>
								        <option value="">全部</option>
								        <option value="0" <c:if test="${orderItem.goodsNumber==0}">selected</c:if>>调重过</option>
								     </select>
				                </div>
			                </div>
	                    </div>
		                <div class="form-footer">
						     <button type="submit" class="btn btn-info pull-left" >提交</button>
						     <button type="reset" id="reset" class="btn btn-info pull-left">重置</button>
					    </div> 
              	    </div>
                </form> 
            </div>       
            <!-- 订单项详情 -->
            <div class="layui-form"  style="margin-top:40px;">
              <table class="layui-table table-striped">
                <thead >
	             <tr >
	                <th>所属区域</th>
	                <th>订单号</th>
	                <th>商品名称</th>
	                <th>买家店铺名称</th>
	                <th>卖家店铺名称</th>
	                <th>实收总金额</th>
	                <th>原数量</th>
	                <th>现数量</th>
	                <th>加工方式</th>
	                <th>交易状态</th>
	                <th>缺/退货状态</th>
	                <th>创建时间</th>
	                <th>备注</th>
	                <th>查看详情</th>
	              </tr>
                </thead>
                <tbody>
	              <c:forEach items="${pageResult.object}" var="r"> 
		   			 <tr>
					       <td>${r.areaName}</td>
					       <td><a style="color: blue;" href="/admin/orderItem/getAll?orderNumber=${r.orderNumber}&pageSize=30">${r.orderNumber}</a></td>
					       <td>${r.formatName}${r.goodsName}</td>
					       <td>${r.buyer.buyerName}</td>
					       <td>${r.seller.sellerName}</td>
					       <td>${r.goodsAmount}</td>
					       <td>
					       		<c:if test="${r.goodsNumberOld != r.goodsNumber}">
					       				<span style="color: red;">${r.goodsNumberOld}</span>
					       		</c:if>
					       		<c:if test="${r.goodsNumberOld == r.goodsNumber}">
					       				${r.goodsNumberOld}
					       		</c:if>
					       </td>
					       <td>${r.goodsNumber}</td>
					       <td>
						       <c:choose> 
								   <c:when test="${empty r.methodName}">无加工</c:when> 
								   <c:otherwise>${r.methodName}</c:otherwise> 
							   </c:choose> 
					       </td>
					       <td>
					           <c:if test="${r.orderStatus==1}">提交订单</c:if>
							   <c:if test="${r.orderStatus==2}">取消订单</c:if>
						   </td>
						   <td>
						       <c:if test="${r.sellerStatus==2}">卖家确认缺货</c:if>
							   <c:if test="${r.sellerStatus==3}">配送人员缺货</c:if>
							   <c:if test="${r.sellerStatus==4}">已补货</c:if>
							   <c:if test="${r.sellerStatus==5}">不需补货</c:if>
							   <c:if test="${r.buyerStatus==3}">申请退货</c:if>
							   <c:if test="${r.buyerStatus==4}">退还中，卖家待确认</c:if>
							   <c:if test="${r.buyerStatus==5}">退货完成</c:if>
						   </td>
						   <td><fmt:formatDate value="${r.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					       <td>${r.remark}</td>
					       <td>
					          <div class="site-demo-button" >
						         <button onclick="getList(${r.id })" class="layui-btn layui-btn-danger layui-btn-small">时间轴</button>
						         <c:if test="${r.buyerStatus==4 || r.buyerStatus==3}">
						             <button onclick="returnConfirm(${r.id },${r.orderStatus})" class="layui-btn layui-btn-danger layui-btn-small">确认退货</button>
						         </c:if>
						      </div> 
					       </td>
		             </tr>
				   </c:forEach>
                </tbody>
              </table>
            </div>
            <div class="box-footer clearfix">
              <ul class="pagination pagination-sm no-margin pull-left">
              	 <pv:showPaging pageVo="${pageResult}" />
              </ul>
            </div>
          </div>
          </div>
        </div>
    </section>
 </div>
   <input type="hidden" id="areaIdVO" value="${orderItem.regionId}"/>
<script src="/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="/bootstrap/js/bootstrap.min.js"></script>
<script src="/bootstrap/js/bootstrap-datetimepicker.js"></script>
<script src="/bootstrap/js/bootstrap-editable.js"></script>
<script src="/js/raphael-min.js"></script>
<script src="/plugins/sparkline/jquery.sparkline.min.js"></script>
<script src="/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script src="/plugins/knob/jquery.knob.js"></script>
<script src="/js/moment.min.js"></script>
<script src="/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script src="/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="/plugins/fastclick/fastclick.js"></script>
<script src="/dist/js/app.min.js"></script>
<script src="/dist/js/demo.js"></script>
<script src="/js/jquery-ui.min.js"></script>
<script src="/layui/layui.js" charset="utf-8"></script>
<script charset="utf-8" src="/My97DatePicker/WdatePicker.js"></script>
<script>
function onSelectPage(currentPage,pageSize)
{  
	$('#pageNum').val(currentPage);
	$('#pageSize').val(pageSize);
	$('#subForm').submit();
} 

//初始化时间选择器
$("#createTimeStart").bind("click focus", function () {
    var endtimeTf = $dp.$('createTimeStop');
    WdatePicker({
        maxDate: '#F{$dp.$D(\'createTimeStart\')}',
        dateFmt: "yyyy-MM-dd HH:mm",
        onpicked: function () { endtimeTf.focus(); }
    });
});
$("#createTimeStop").bind("click focus", function () {
    WdatePicker({
        minDate: '#F{$dp.$D(\'createTimeStart\')}',
        dateFmt: "yyyy-MM-dd HH:mm"
    });
});

layui.use('form', function(){
	  var $ = layui.jquery, form = layui.form();
});

//重置
$(function(){
   $("#reset").click(function(){
	   window.location.href="/admin/orderItem/redressOrderItems";
   });
});

$(".form-group input").bind("blur",function(){  
        var result=$(this).attr("value").replace(/(^\s*)|(\s*$)/g, "");  
        $(this).attr("value",result);  
    });
    
//获取区域信息;
$(document).ready(function(){
	loadregion(); 
}); 
	
var areaId = $('#areaIdVO').val();
//加载区域
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
/* 查看时间轴 */
function getList(id) {
    layer.open({
        type: 2,
        title: '操作详情',
        shade: 0.5,
        area: ['900px', '600px'],
        content: "/admin/orderTimeline/getList?itemId="+id,
        zIndex: layer.zIndex, //重点1
        cache:false,
	    }); 
}

//确认缺货
function returnConfirm(id,orderStatus){
	if(orderStatus==2){
		layer.msg("订单已取消，不能进行确认退货操作");
		return false;
	}
	$.ajax({
	    type:'post', 
	    url:'/admin/orderReturn/confirm',
	    data:{"itemId":id},
	    dataType:'json',
	    async:false,
	    success:function (result){
	    	layer.msg(result.message);
	    	//刷新页面
	    	window.location.href="/admin/orderItem/redressOrderItems";
	    }
	})
}
</script>
</body>
</html>