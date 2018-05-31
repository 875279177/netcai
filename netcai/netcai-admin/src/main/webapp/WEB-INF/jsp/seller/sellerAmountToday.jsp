<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="pv" uri="/pageTaglib"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<!-- 引入公共部分jsp文件 -->
<meta name="decorator" content="default" />
<style type="text/css">
.form-footer {
	margin-left: 325px;
}
</style>
</head>
<body>
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>卖家收益详情</h1>
		</section>
		<!-- Main content -->
		<shiro:hasPermission name="seller:getTodayAmount">
			<section class="content">
				<div class="row">
					<div class="col-xs-12">
						<div class="box">
							<div class="box-header">
								<h3 class="box-title">卖家收益列表</h3>
							</div>
							<div class="box box-info">
								<form id="form_submit" class="form-horizontal"
									action="<%=request.getContextPath()%>/admin/seller/getTodayAmount"
									method="post">
									<input type="hidden" name="pageNum" id="pageNum"
										value="${paginator.currentPage}"> <input type="hidden"
										name="pageSize" id="pageSize" value="${paginator.pageRecord}">
									<div class="box-body">
										<div class="form-group">
											<label for="buyerName" class="col-md-1 control-label">商铺名称：</label>
											<div class="col-md-2">
												<input type="text" class="form-control" id="sellerName"
													name="sellerName" placeholder="请输入商铺名称"
													value="${seller.sellerName}">
											</div>
											<label for="account" class="col-md-1 control-label">手机号：</label>
											<div class="col-md-2">
												<input type="text" class="form-control" id="account"
													name="account" placeholder="请输入手机号"
													value="${seller.account}">
											</div>
											<label for="account" class="col-md-1 control-label">日期选择：</label>
											<div class="col-md-2">
												<input type="date" class="form-control" id="time"
													name="time" placeholder="请输入手机号" value="${seller.time}">
											</div>
										</div>
										<div class="form-group">
											<label for="areaId" class="col-xs-1 control-label">区域：</label>
											<div class="col-xs-2">
												<select id="areaId" name="areaId" class="form-control"></select>
											</div>
										</div>
										<div class="form-footer">
											<button type="submit" class="btn btn-info">
												<i class="fa fa-search"></i>查询
											</button>
											<button type="reset" id="reset" class="btn btn-info ">
												<i class="fa fa-fw fa-refresh"></i> 重置
											</button>
										</div>
									</div>
								</form>
							</div>
							<!-- /.box-header -->
							<div class="box-body">
								<table class="table table-bordered table-striped table-hover">
									<thead>
										<tr>
											<th>区域</th>
											<th>商铺名称</th>
											<th>手机号</th>
											<th>今日订单</th>
											<th>今日收益</th>
											<th>可用余额</th>
											<th>可提现余额</th>
											<th>已提现总额</th>
											<th>已结算总额</th>
											<th>待结算总额</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${paginator.object}" var="r">
											<tr>
												<td>${r.areaName}</td>
												<td>${r.sellerName}</td>
												<td>${r.account}</td>
												<td><a
													href="<%=request.getContextPath()%>/admin/orderInfo/getOrdersBySellerId?sellerId=${r.sellerId}&time=${seller.time}"
													target="_blank"><b><u>${r.orderNum}</u></b></td>
												<td><a
													href="<%=request.getContextPath()%>/admin/seller/getTransactionDetails?sellerId=${r.sellerId}&time=${seller.time}"
													target="_blank"><b><u>${r.totayIncome}</u></b></a></td>
												<td><a
													href="<%=request.getContextPath()%>/admin/seller/getBillsBySellerId?sellerId=${r.sellerId}&time=${seller.time}"
													target="_blank"><b><u>${r.balanceMoney}</u></b></a></td>
												<td>${r.withdrawalAmount}</td>
												<td>${r.withdrawaledAmount}</td>
												<td>${r.alreadySettled}</td>
												<td>${r.waitSettled}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<div class="box-footer clearfix">
								<ul class="pagination pagination-sm no-margin pull-left">
									<pv:showPaging pageVo="${paginator}" />
								</ul>
							</div>
						</div>
					</div>
				</div>
			</section>
		</shiro:hasPermission>
	</div>
	<input type="hidden" id="areaIdVO" value="${seller.areaId}" />
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
		function onSelectPage(currentPage, pageSize) {
			$('#pageNum').val(currentPage);
			$('#pageSize').val(pageSize);
			$('#form_submit').submit();
		}

		//重置
		$(function() {
			$("#reset").click(function() {
				window.location.href = "/admin/seller/getTodayAmount";
			});
		});

		//获取列表;
		$(document).ready(function() {
			loadarea();
		});

		var areaId = $('#areaIdVO').val();
		function loadarea() {
			if (areaId == null || areaId == '' || areaId == undefined) {
				areaId = 0;
			}
			var url = '/admin/region/Alllist';
			jQuery.ajax({
						type : 'post',
						url : url,
						async : false,
						success : function(date) {
							var areaList = date.object;
							if (areaList != null && areaList.length > 0) {
								if (areaId == 0) {
									$(
											"<option value='' selected>" + "全部"
													+ "</option>").appendTo(
											"#areaId");
								} else {
									$("<option value=''>" + "全部" + "</option>")
											.appendTo("#areaId");
								}
								for (var i = 0; i < areaList.length; i++) {
									if (areaList[i].id == areaId) {
										$(
												"<option value='"+areaList[i].id+"' selected>"
														+ areaList[i].areaName
														+ "</option>")
												.appendTo("#areaId");
									} else {
										$(
												"<option value='"+areaList[i].id+"'>"
														+ areaList[i].areaName
														+ "</option>")
												.appendTo("#areaId");
									}
								}
							}
						}
					});
		}
	</script>
</body>
</html>