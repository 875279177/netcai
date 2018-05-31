<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="pv" uri="/pageTaglib"%>
<!DOCTYPE html>
<html>
<head>
<meta name="decorator" content="default" />
<style type="text/css">
button {
	margin-right: 5px;
}
</style>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>提现管理</h1>
		</section>
		<!-- Main content -->
		<shiro:hasPermission name="withdrawal:query">
			<section class="content">
				<div class="row">
					<div class="col-xs-12">
						<div class="box">
							<div class="box-header">
								<h3 class="box-title">提现列表信息</h3>
							</div>

							<!-- <!-- 表单start -->
							<form id="subForm" class="layui-form"
								action="/admin/withdrawal/list" method="post">
								<input type="hidden" name="pageNum" id="pageNum"
									value="${paginator.currentPage}"> <input type="hidden"
									name="pageSize" id="pageSize" value="${paginator.pageRecord}">
								<div class="col-sm-12">
									<div class="form-group">
										<label for="applyer" class="col-sm-1 control-label">申请人</label>
										<div class="col-sm-2">
											<input type="text" class="form-control input-small"
												id="userstrueName" name="users.trueName"
												value="${withdrawal.users.trueName}" placeholder="请输入申请人姓名">
										</div>
										<label for="users.account" class="col-sm-1 control-label">联系方式</label>
										<div class="col-sm-2">
											<input type="text" class="form-control" id="usersaccount"
												name="users.account" value="${withdrawal.users.account}"
												placeholder="请输入手机号">
										</div>
										<label for="status" class="col-sm-1 control-label">状态</label>
										<div class="col-sm-2">
											<select id="status" name="status">
												<option value="0">全部</option>
												<option value="-1"
													<c:if test="${withdrawal.status==-1}">selected</c:if>>审批不通过</option>
												<option value="1"
													<c:if test="${withdrawal.status==1}">selected</c:if>>申请提现</option>
												<option value="2"
													<c:if test="${withdrawal.status==2}">selected</c:if>>审批通过</option>
												<option value="3"
													<c:if test="${withdrawal.status==3}">selected</c:if>>交易完成</option>
											</select>
										</div>

										<label for="withdrawApplyTime" class="col-sm-1 control-label">申请时间</label>
										<div class="col-sm-2">
											<input type="date" class="form-control"
												id="withdrawApplyTime" name="queryDate"
												value="${withdrawal.queryDate}">
										</div>
									</div>
								</div>

								<div class="col-sm-3 layui-form-item layui-form-btns"
									style="float: right; margin-top: 50px;">
									<button type="submit" class="btn btn-info pull-left"
										onclick="saveOrUp()">提交</button>
									<button type="reset" id="reset" class="btn btn-info pull-left">重置</button>
								</div>
							</form>
							<!-- /.box-header -->
							<div class="layui-form">
								<table id="contentTable" class="layui-table table-striped">
									<thead>
										<tr>
											<th>流水号</th>
											<th>申请人</th>
											<th>店铺名称</th>
											<th>联系方式</th>
											<th>申请时间</th>
											<th>申请金额</th>
											<th>实际提现金额</th>
											<th>提现手续费</th>
											<th>提现方式</th>
											<th>卡的号码</th>
											<th>状态</th>
											<th>管理操作</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${paginator.object}" var="r">
											<tr>
												<td>${r.withdrawOrder}</td>
												<td><a style="color: blue;"
													href="/admin/bill/list?sellerId=${r.uid}">${r.users.trueName}</a></td>
												<td>${r.shopName}</td>
												<td>${r.users.account}</td>
												<td><fmt:formatDate value="${r.withdrawApplyTime}"
														pattern="yyyy-MM-dd HH:mm:ss" /></td>
												<td>${r.withdrawApplyTotal}</td>
												<td>${r.withdrawRealityTotal}</td>
												<td>${r.withdrawCharge}</td>
												<td>${r.withdrawalBank.bankName}</td>
												<td>${r.withdrawalBank.bankNumber}</td>
												<td><c:if test="${r.status==-1}">
														<span style="color: red;">审批不通过</span>
													</c:if> 
													<c:if test="${r.status==1}">
														<span style="color: orange;">申请提现</span>
													</c:if> 
													<c:if test="${r.status==2}">
														<span style="color: aqua;">审批通过</span>
													</c:if> 
													<c:if test="${r.status==3}">
														<span>交易完成</span>
													</c:if>
												</td>
												<td><a href="#" onclick="get('${r.id}','${r.withdrawOrder}')" class="btn btn-info btn-xs"><i class="fa fa-search-plus"></i> 查看</a></td>
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
	<script src="/plugins/jQuery/jquery-2.2.3.min.js"></script>
	<script src="/bootstrap/js/bootstrap.min.js"></script>
	<script src="/js/raphael-min.js"></script>
	<script src="/plugins/sparkline/jquery.sparkline.min.js"></script>
	<script src="/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
	<script src="/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
	<script src="/plugins/knob/jquery.knob.js"></script>
	<script src="/js/moment.min.js"></script>
	<script src="/plugins/daterangepicker/daterangepicker.js"></script>
	<script src="/plugins/datepicker/bootstrap-datepicker.js"></script>
	<script
		src="/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
	<script src="/plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<script src="/plugins/fastclick/fastclick.js"></script>
	<script src="/plugins/datatables/jquery.dataTables.min.js"></script>
	<script src="/plugins/datatables/dataTables.bootstrap.min.js"></script>
	<script src="/dist/js/app.min.js"></script>
	<script src="/dist/js/demo.js"></script>
	<script src="/js/jquery-ui.min.js"></script>
	<script src="/layui/layui.js" charset="utf-8"></script>
	<script src="/js/jquery.validate.min.js" charset="utf-8"></script>
	<script src="/js/layuiUtil.js" charset="utf-8"></script>
	<script src="/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		function onSelectPage(currentPage, pageSize) {
			$('#pageNum').val(currentPage);
			$('#pageSize').val(pageSize);
			$('#subForm').submit();
		}
	</script>
	<script>
		//重置
		$(function() {
			$("#reset").click(function() {
				window.location.href = "/admin/withdrawal/list";
			});
		});

		/* 查看 */
		function get(id, withdrawOrder) {
			//iframe层
			layer.open({
				type : 2,
				title : '提现详情',
				shade : 0.5,
				area : [ '1000px', '700px' ],
				content : "/admin/withdrawal/getView?id=" + id
						+ "&withdrawOrder=" + withdrawOrder,
				zIndex : layer.zIndex, //重点1
				cache : false,
			});
		}

		layui.use('form', function() {
			var $ = layui.jquery, form = layui.form();

			//全选
			form.on('checkbox(allChoose)', function(data) {
				var child = $(data.elem).parents('table').find(
						'tbody input[type="checkbox"]');
				child.each(function(index, item) {
					item.checked = data.elem.checked;
				});
				form.render('checkbox');
			});

		});

		//修改状态；
		$(function() {
			$("#fixStatus")
					.click(
							function() {
								var ids = new Array();
								$(
										"#contentTable tbody tr td input.i-checks:checkbox")
										.each(
												function() {
													if (true == $(this).is(
															':checked')) {
														ids.push($(this).attr(
																"id"));
													}
												});
								if (ids.length < 1) {
									top.layer.alert('请至少选择一条数据!', {
										icon : 0,
										title : '警告'
									});
									return;
								}
								//询问框
								layer
										.msg(
												'选择状态',
												{
													time : 0 //不自动关闭
													,
													icon : 6,
													btn : [ '审批通过', '不通过', '退出' ],
													btn1 : function(index) {
														layer.close(index);
														layer
																.confirm(
																		'确定更新？',
																		{
																			btn : [
																					'确定',
																					'取消' ]
																		//按钮
																		},
																		function() {
																			$
																					.ajax({
																						url : "/admin/withdrawal/update/status",
																						data : {
																							"ids" : ids,
																							"status" : 1
																						},//提现状态,1表示申请提现,2表示审批通过,3,交易完成,-1审批不通过.',
																						dataType : "json",
																						success : function(
																								data) {
																							var code = data.code;
																							var message = data.message;
																							layer
																									.msg(message);
																							location
																									.reload();
																						}
																					});
																		},
																		function() {
																			return;
																		});
													},
													btn2 : function(index) {
														layer.close(index);
														layer
																.confirm(
																		'确定更新？',
																		{
																			btn : [
																					'确定',
																					'取消' ]
																		//按钮
																		},
																		function() {
																			$
																					.ajax({
																						url : "/admin/orderInfo/update/status",
																						data : {
																							"ids" : ids,
																							"status" : 2
																						},//提现状态,1表示申请提现,2表示审批通过,3,交易完成,-1审批不通过.',
																						dataType : "json",
																						success : function(
																								data) {
																							var code = data.code;
																							var message = data.message;
																							layer
																									.msg(message);
																							location
																									.reload();
																						}
																					});
																		},
																		function() {
																			return;
																		});
													},
													btn3 : function(index) {
														layer.close(index);
													}
												});
							});
		});
	</script>
</body>
</html>