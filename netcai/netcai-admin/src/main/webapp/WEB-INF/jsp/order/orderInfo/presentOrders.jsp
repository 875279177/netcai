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
	.seller_amount p{
	  display:inline;
	  padding-left:10px;
	  font-weight:900;
	  font-size:16px;
	  color:#000aaa;
	}
  </style>
</head>
<body>
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>卖家今日订单列表</h1>
		</section>
		<!-- Main content -->
		<section class="content">
			<div class="row">
				<div class="col-xs-12">
					<div class="box">
						<div class="box-header seller_amount" >
						     <p>日期：${time }</p>
							 <p>订单总金额：${totalAmount }</p>
							 <p>订单数量：${orderNum }</p>
						</div>
						<!-- /.box-header -->
						<table class="layui-table" lay-skin="row">
							<thead>
								<tr>
									<th>卖家店铺</th>
									<th>卖家手机号</th>
									<th>下单时间</th>
									<th>送达时间</th>
									<th>订单金额</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="r">
									<tr>
						   			    <td>${r.buyerName}</td>
								        <td>${r.buyerPhone}</td>
								        <td><fmt:formatDate value="${r.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								        <td><fmt:formatDate value="${r.bestTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								        <td>${r.orderAmount}</td>
								        <td>
								          <div class="site-demo-button" >
								            <button data-method="setTop" onclick="getOrderItems(${r.orderId },${r.sellerId} )" class="layui-btn layui-btn-normal layui-btn-small"><span>查看详情</span></button>
								          </div>
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
<script type="text/javascript">
layui.use(['form', 'jquery','layedit', 'laydate'], function(){
	   var form = layui.form(),layer = layui.layer,$ = layui.jquery,
	       layedit = layui.layedit,laydate = layui.laydate;
	   //监听指定开关
	   form.on('switch(switchTest)', function(data){
	       layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
	           offset: '6px'
	       });
	   });
});
  function getOrderItems(orderId,sellerId){
	  console.log(orderId+","+sellerId);
	  layer.open({
	         type: 2, 
	         title: '订单详情',
	         area: ['1000px', '450px'],
	         shade: 0.5,
	         content: '<%=request.getContextPath()%>/admin/orderItem/getOrderItemsByOrderId?orderId='+orderId+'&sellerId='+sellerId,
	         zIndex: layer.zIndex, //重点1
	         success: function(layero, index){
	        	 layer.setTop(layero);
	        	 var body = layer.getChildFrame('body', index);
	             var iframeWin = window[layero.find('iframe')[0]['name']]; 
	        	
	         }
	     });
  }
</script>
</body>
</html>