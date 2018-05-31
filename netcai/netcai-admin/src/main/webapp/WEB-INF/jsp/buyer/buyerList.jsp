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
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>买家信息管理</h1>
		</section>
		<!-- Main content -->
		<shiro:hasPermission name="buyer:query">
			<section class="content">
				<div class="row">
					<div class="col-xs-12">
						<div class="box">
							<div class="box-header">
								<h3 class="box-title">买家信息</h3>
							</div>
							<div class="box box-info">
								<!-- form start -->
								<form id="form_submit" class="form-horizontal"
									action="<%=request.getContextPath()%>/admin/buyer/list"
									method="post">
									<input type="hidden" name="pageNum" id="pageNum"
										value="${paginator.currentPage}"> <input type="hidden"
										name="pageSize" id="pageSize" value="${paginator.pageRecord}">
									<div class="box-body">
										<div class="form-group">
											<label for="buyerName" class="col-sm-2 control-label">餐馆名称：</label>
											<div class="col-xs-2">
												<input type="text" class="form-control" id="buyerName"
													name="buyerName" placeholder="请输入餐馆名称"
													value="${buyer.buyerName}">
											</div>
											<label for="bossName" class="col-sm-2 control-label">买家姓名：</label>
											<div class="col-xs-2">
												<input type="text" class="form-control" id="bossName"
													name="bossName" placeholder="请输入姓名"
													value="${buyer.bossName}">
											</div>
											<label for="bossTel" class="col-sm-2 control-label">手机号：</label>
											<div class="col-xs-2">
												<input type="text" class="form-control" id="bossTel"
													name="bossTel" placeholder="请输入手机号"
													value="${buyer.bossTel}">
											</div>
										</div>
										<div class="form-group">
											<label for="areaId" class="col-sm-2 control-label">所在区域：</label>
											<div class="col-xs-2">
												<select id="areaId" name="regionId" class="form-control">
													<option value="">全部</option>
												</select>
											</div>
											<label for="deliveryAreaId" class="col-sm-2 control-label">配送区域：</label>
											<div class="col-xs-2">
												<select id="deliveryAreaId" name="deliveryAreaId"
													class="form-control">
													<option value="">全部</option>
													<option value="-1"
														<c:if test="${buyer.deliveryAreaId==-1 }">selected</c:if>>未分配配送区域</option>
													<c:forEach items="${deliveryAreas}" var="r">
														<option value="${r.id }"
															<c:if test="${r.id==buyer.deliveryAreaId }">selected</c:if>>${r.address }</option>
													</c:forEach>
												</select>
											</div>
											<label for="saleId" class="col-sm-2 control-label">所属销售：</label>
											<div class="col-xs-2">
												<select id="saleId" name="saleId" class="form-control">
													<option value="">全部</option>
													<option value="-1"
														<c:if test="${buyer.saleId==-1 }">selected</c:if>>未分配销售</option>
													<c:forEach items="${sales}" var="r">
														<option value="${r.id }"
															<c:if test="${r.id==buyer.saleId }">selected</c:if>>${r.realName }</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="form-group">
											<label for="status" class="col-sm-2 control-label">状态：</label>
											<div class="col-xs-2">
												<select id="status" name="status" class="form-control">
													<option value="">全部</option>
													<option value="-1"
														<c:if test="${buyer.status ==-1}">selected</c:if>>不可用</option>
													<option value="0"
														<c:if test="${buyer.status ==0}">selected</c:if>>资料未完善</option>
													<option value="1"
														<c:if test="${buyer.status ==1}">selected</c:if>>未审核</option>
													<option value="2"
														<c:if test="${buyer.status ==2}">selected</c:if>>审核未通过</option>
													<option value="3"
														<c:if test="${buyer.status ==3}">selected</c:if>>审核通过</option>
												</select>
											</div>
										</div>
										<div class="form-footer">
											<button type="submit"
												class="btn btn-info pull-left btn-select">查询</button>
											<button type="reset" class="btn btn-info pull-left"
												onclick="clearSearch()">重置</button>
										</div>
								</form>
								<!-- form end -->
							</div>
							<!-- /.box-header -->
							<div class="layui-form">
								<div class="site-demo-button">
								    <shiro:hasPermission name="buyer:insert">
										<button data-method="setTop" class="layui-btn layui-btn-small layui-btn-primary"><i class="layui-icon"></i><span>&nbsp;&nbsp;新增</span>
										</button>
									</shiro:hasPermission>
									<shiro:hasPermission name="buyer:export">
										<button type="button" class="layui-btn layui-btn-small layui-btn-primary " onclick="exportExcel()"> <i class="fa fa-fw fa-download"></i> 导出</button>
									</shiro:hasPermission>
								</div>
								<table class="layui-table" lay-skin="row">
									<thead>
										<tr>
											<th>配送区域名称</th>
											<th>所在区域</th>
											<th>销售人员</th>
											<th>买家姓名</th>
											<th>手机号</th>
											<th>餐馆名称</th>
											<th>餐馆地址</th>
											<th>账户余额</th>
											<th>状态</th>
											<th>注册时间</th>
											<th style="width: 400px;">操作</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${paginator.object}" var="r">
											<tr>
												<td>${r.deliveryAreaName}</td>
												<td>${r.regionName}</td>
												<td>${r.salesName}</td>
												<td>${r.bossName}</td>
												<td>${r.bossTel}</td>
												<td>${r.buyerName}</td>
												<td>${r.buyerAddress}</td>
												<td>${r.balanceMoney}</td>
												<td><c:if test="${r.status ==-1}">不可用</c:if> <c:if
														test="${r.status ==0}">资料未完善</c:if> <c:if
														test="${r.status ==1}">未审核</c:if> <c:if
														test="${r.status ==2}">审核未通过</c:if> <c:if
														test="${r.status ==3}">审核通过</c:if></td>
												<td><fmt:formatDate value="${r.createTime }"
														pattern="yyyy-MM-dd HH:mm:ss" /></td>
												<td>
												    <shiro:hasPermission name="buyer:update">
														<div class="site-demo-button">
															<c:if test="${r.status ==0 || r.status ==3}">
																<button data-method="setTop" value="${r.buyerId }"
																	class="layui-btn layui-btn-normal layui-btn-small">
																	<i class="layui-icon"></i><span>&nbsp;&nbsp;修改</span>
																</button>
															</c:if>
															<c:if test="${r.status ==-1}">
																<button data-method="offset" value="${r.buyerId }"
																	class="layui-btn layui-btn-normal layui-btn-small">
																	<i class="layui-icon"></i><span>&nbsp;&nbsp;启用</span>
																</button>
															</c:if>
															<c:if test="${r.status ==1}">
																<button data-method="offset" value="${r.buyerId }"
																	class="layui-btn layui-btn-warm layui-btn-small">
																	<i class="layui-icon"></i><span>审核通过</span>
																</button>
																<button data-method="offset" value="${r.buyerId }"
																	class="layui-btn layui-btn-warm layui-btn-small">
																	<i class="layui-icon"></i><span>审核不通过</span>
																</button>
															</c:if>
															<c:if test="${r.status ==3}">
																<button
																	onclick="notice('${r.buyerId }','${r.buyerName }')"
																	class="layui-btn  layui-btn-small">
																	<i class="layui-icon">&#xe642;</i><span>&nbsp;&nbsp;选择商家</span>
																</button>
																<button
																	onclick="bound('${r.buyerId }','${r.buyerName }')"
																	class="layui-btn  layui-btn-small">
																	<i class="layui-icon">&#xe642;</i><span>&nbsp;&nbsp;绑定卖家</span>
																</button>
																<button data-method="offset" value="${r.buyerId }"
																	class="layui-btn layui-btn-danger layui-btn-small">
																	<i class="layui-icon"></i><span>&nbsp;&nbsp;禁用</span>
																</button>
															</c:if>
														</div>
													</shiro:hasPermission>
												</td>
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
	<input type="hidden" id="areaIdVO" value="${buyer.regionId}" />
	<script src="/plugins/jQuery/jquery-2.2.3.min.js"></script>
	<script src="/bootstrap/js/bootstrap.min.js"></script>
	<script src="/js/raphael-min.js"></script>
	<script src="/plugins/sparkline/jquery.sparkline.min.js"></script>
	<script src="/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
	<script src="/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
	<script src="/plugins/knob/jquery.knob.js"></script>
	<script src="/js/moment.min.js"></script>
	<script src="/plugins/daterangepicker/daterangepicker.js"></script>
	<script
		src="/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
	<script src="/plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<script src="/plugins/fastclick/fastclick.js"></script>
	<script src="/dist/js/app.min.js"></script>
	<script src="/dist/js/demo.js"></script>
	<script src="/js/jquery-ui.min.js"></script>
	<script src="/layui/layui.js" charset="utf-8"></script>
	<script type="text/javascript">

//重置
function clearSearch(){
	window.location.href="<%=request.getContextPath()%>/admin/buyer/list";
}
//导出
function exportExcel(){
	window.location.href="/admin/buyer/export?"+$('#form_submit').serialize();
}
//选择页码
function onSelectPage(currentPage,pageSize){  
	$('#pageNum').val(currentPage);
	$('#pageSize').val(pageSize);
	$('#form_submit').submit();
} 
</script>
	<script>
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
   //新增数据弹窗
   layui.use('layer', function(){ //独立版的layer无需执行这一句
	   var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句  
	   //触发事件
	   var active = {
			 setTop: function(data){
				 //点击修改按钮时获取id
				 var id = data.val();
			     //多窗口模式，层叠置顶
			     layer.open({
			         type: 2, 
			         title: '新增/修改买家信息',
			         area: ['1330px', '600px'],
			         shade: 0.5,
			         content: '/admin/buyer/addBuyer?id='+id,
			         zIndex: layer.zIndex, //重点1
			         success: function(layero, index){
			        	 layer.setTop(layero);
			        	 var body = layer.getChildFrame('body', index);
			             var iframeWin = window[layero.find('iframe')[0]['name']]; 
			             body.find('input[name="id"]').val(id);
			        	
			         }
			     });
			 },
			 //修改买家状态弹窗
		     offset: function(othis){
		         var type = othis.data('type');
		         var html = "";
		         var status=othis.text();
	        	 var requestUrl ;
	        	 if(status.indexOf("禁用")!=-1){
	        		 html = "<p>确定要禁用此条数据吗？</p>";
	        		 //禁用的url
	        		 requestUrl="<%=request.getContextPath()%>/admin/buyer/disabledBuyer";
	        	 }else if(status.indexOf("审核通过")!=-1){
	        		 html = "<p>确定要审核通过吗？</p>";
	        		 //审核通过的url
	        		 requestUrl="<%=request.getContextPath()%>/admin/buyer/auditThrough";
	        	 }else if(status.indexOf("审核不通过")!=-1){
// 	        		 html = "<p style='padding-bottom:10px'>审核不通过原因：</p><input type='text' id='reason' style='width:280px;height:35px;'></input>";
                     html = "<p>确定要审核不通过吗？</p>";
	        		 var reason = $("#reason").val();
	        		//审核不通过的url
	        		 requestUrl="<%=request.getContextPath()%>/admin/buyer/auditNotThrough";
	        	 }else{
	        		 html = "<p>确定要启用此条数据吗？</p>";
	        		//启用的url
	        		 requestUrl="<%=request.getContextPath()%>/admin/buyer/enabledBuyer";
				}
				layer.open({
							type : 1,
							title : "更新状态",
							offset : type,
							area : [ '350px', '215px' ],
							id : 'LAY_demo' + type, //防止重复弹出
							content : '<div style="padding: 20px 35px;">'
									+ html + '</div>',
							btn : [ '确定', '取消' ],
							btnAlign : 'c', //按钮居中
							shade : 0.5,//不显示遮罩
							yes : function() {
								var id = othis.val();
								$.ajax({
											type : "POST",
											url : requestUrl,
											data : {
												"id" : id,
												"reason" : reason
											},
											dataType : "json",
											cache : false,
											success : function(
													data) {
												var code = data.code;
												var msg = data.message;
												if (code == "200") {
													layer.msg(msg,{icon : 1,time : 2000});//1.5秒关闭
													//刷新页面
													window.location.reload();
												}
											},
											error : function() {
												alert("操作失败");
											}
								});
							},
							btn2 : function() {
								layer.closeAll();
							}
						})
					}

	   };
	   $('.site-demo-button .layui-btn').on('click',function() {
			var othis = $(this), method = othis.data('method');
			active[method] ? active[method].call(this, othis) : '';
	   });
   });

		//拒看商家;
		function notice(id, name) {
			if (id == "" || name == "") {
				alert('参数错误!');
				return;
			}
			layer.open({
				type : 2,
				title : name + '拒看商家',
				area : [ '900px', '400px' ],
				shade : 0.5,
				content : '/admin/buyer/selectSeller?id=' + id,
				zIndex : layer.zIndex, //重点1
				cache : false,
			});
		}

		//绑定卖家;
		function bound(id, name) {
			if (id == "" || name == "") {
				alert('参数错误!');
				return;
			}
			layer.open({
				type : 2,
				title : name + '绑定卖家',
				area : [ '900px', '400px' ],
				shade : 0.5,
				content : '/admin/buyer/toBoundSeller?id=' + id,
				zIndex : layer.zIndex, //重点1
				cache : false,
			});
		}

		//获取区域信息;
		$(document).ready(function() {
			loadregion();
		});
		var areaId = $('#areaIdVO').val();
		function loadregion() {
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
						for (var i = 0; i < areaList.length; i++) {
							if (areaList[i].id == areaId) {
								$(
										"<option value='"+areaList[i].id+"' selected>"
												+ areaList[i].areaName
												+ "</option>").appendTo(
										"#areaId");
							} else {
								$("<option value='"+areaList[i].id+"'>"
												+ areaList[i].areaName
												+ "</option>").appendTo(
										"#areaId");
							}
						}
					}
				}
			});
		}
	</script>
</body>
</html>