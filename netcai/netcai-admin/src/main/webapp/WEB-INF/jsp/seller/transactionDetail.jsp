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
			<h1>卖家营业额详情列表</h1>
		</section>
		<!-- Main content -->
		<section class="content">
			<div class="row">
				<div class="col-xs-12">
					<div class="box">
						<div class="box-header seller_amount" >
						     <p>日期：${time }
							 <p>营业额：${map.totalGoodsAmount }</p>
						     <p>服务抽成金额：${map.totalPercentageAmount }</p>
						     <p>补扣款金额：${map.totalSellerMoney }</p>
						     <p>实际营业额：${map.totalIncome }</p>
						</div>
						<!-- /.box-header -->
						<table class="layui-table" lay-skin="row">
							<thead>
								<tr>
									<th>商品名称</th>
									<th>单价</th>
									<th>数量</th>
									<th>订单金额</th>
									<th>抽点比率</th>
									<th>抽点金额</th>
									<th>实际收益</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="r">
									<tr>
										<td>
										  <c:if test="${not empty r.goodsBrand}">[${r.goodsBrand}]</c:if>
										  ${r.goodsName}
										  <c:if test="${not empty r.goodsLabel}">(${r.goodsLabel})</c:if>
										</td>
						   			    <td>${r.goodsPrice}/${r.unitName}</td>
								        <td>${r.goodsNumber}</td>
								        <td>${r.goodsAmount}</td>
								        <td>${r.orderPercentage}</td>
								        <td>${r.percentageAmount}</td>
							            <td>
							              <c:if test="${r.realityMoney==null}">
							                ${r.goodsAmount}
							              </c:if>
							              <c:if test="${r.realityMoney!=null}">
							                ${r.realityMoney}
							              </c:if>
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
</body>
</html>