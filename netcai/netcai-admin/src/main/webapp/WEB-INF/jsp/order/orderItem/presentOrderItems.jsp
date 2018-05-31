<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单详情</title>
<link rel="stylesheet" href="/layui/css/layui.css"  media="all">
<style type="text/css">
  table th{
     background:#ffffff;
  }
  table tr:nth-child(odd){
	 background:#F0F0F0;
  }
</style>
</head>
<body>
  <div class="row">
	<div class="col-xs-12">
		<div class="box">
			<!-- /.box-header -->
			<table class="layui-table" lay-skin="row">
				<thead>
					<tr>
						<th>买家餐馆地址</th>
						<th>买家餐馆</th>
						<th>买家手机号</th>
						<th>商品名称</th>
						<th>单价</th>
						<th>购买数量</th>
						<th>金额</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="r">
						<tr>
						    <td>${r.address}</td>
			   			    <td>${r.buyerName}</td>
					        <td>${r.buyerPhone}</td>
					        <td>
					          <c:if test="${not empty r.goodsBrand}">[${r.goodsBrand}]</c:if>
							  ${r.goodsName}
							  <c:if test="${not empty r.goodsLabel}">(${r.goodsLabel})</c:if>
							</td>
					        <td>${r.goodsPrice}/${r.unitName}</td>
					        <td>${r.goodsNumber}</td>
					        <td>${r.orderAmount}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
  </div>
</body>
<script src="/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/js/jquery.formPlugin.js"></script>
<script type="text/javascript" src="/js/jquery.form.js"></script>
</html>