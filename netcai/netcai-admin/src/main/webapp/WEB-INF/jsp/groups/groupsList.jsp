<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="pv" uri="/pageTaglib"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta name="decorator" content="default" />
<style type="text/css">
    .form-footer{
        margin-left:325px;
    }
</style>
</head>
<body>
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
	        <h1>团购活动管理</h1>
		</section>
		<!-- Main content -->
		<shiro:hasPermission name="groups:query">
		<section class="content">
			<div class="row">
				<div class="col-xs-12">
					<div class="box">
						<div class="box-header">
							<h3 class="box-title">团购活动列表</h3>
						</div>
						<div class="box box-info">
							<form id="groupsForm" class="form-horizontal" action="<%=request.getContextPath()%>/admin/groups/list" method="post">
								<input type="hidden" name="pageNum" id="pageNum"value="${paginator.currentPage}"> 
								<input type="hidden" name="pageSize" id="pageSize" value="${paginator.pageRecord}">
								<div class="box-body">
									<div class="col-md-12">
										<div class="form-group">
											<label for="sellerName" class="col-md-1 control-label">编号：</label>
											<div class="col-md-2">
												<input type="text" class="form-control " id="groupNumber" name="groupNumber" value="${sellerquery.groupNumber}" placeholder="请输入编号">
											</div>
											<label for="sellerAccount" class="col-md-1 control-label">标题：</label>
											<div class="col-md-2">
												<input type="text" class="form-control" id="title" name="title" value="${groups.title}" placeholder="请输入标题">
											</div>
										</div>
										<div class="form-group">
											<label for="status" class="col-xs-1 control-label">状态：</label>
											<div class="col-xs-2">
												<select id="status" name="status" class="form-control" >
													<option value=" ">全部</option>
													<option value="-1" <c:if test="${groups.status == -1}">selected</c:if>>已结束</option>
													<option value="1" <c:if test="${groups.status == 1}">selected</c:if>>进行中</option>
													<option value="2" <c:if test="${groups.status == 2}">selected</c:if>>团购成功</option>
													<option value="3" <c:if test="${groups.status == 3}">selected</c:if>>团购失败</option>
												</select>
											</div>
										</div>
									</div>
									<div class="form-footer" >
										<button type="submit" class="btn btn-info"><i class="fa fa-search"></i>查询</button>
										<button type="reset" id="reset" class="btn btn-info "><i class="fa fa-fw fa-refresh"></i> 重置</button>
									</div>
								</div>
							</form>
						</div>
						<!-- 按钮组 -->
						<div class="col-sm-12">
						    <div class="pull-left">
						        <shiro:hasPermission name="groups:insert">
						            <button class="btn btn-success" onclick="addAndUpdate();"><i class="fa fa-fw fa-plus-square" ></i>新增</button>
						        </shiro:hasPermission>
					        </div>
					    </div>
						<!-- /.box-header -->
						<div class="box-body">
							<table class="table table-bordered table-striped table-hover">
								<thead style="border-collapse:collapse;">
									<tr>
										<th>所在区域</th>
										<th>活动编号</th>
										<th>标题</th>
										<th>开始时间</th>
										<th>结束时间</th>
										<th>参团最小金额</th>
										<th>团购总金额</th>
										<th>状态</th>
										<th>备注</th>
										<th>创建时间</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${paginator.object}" var="r">
										<tr>
											<td><c:if test="${not empty r.regionNames}">${r.regionNames}</c:if></td>
											<td>${r.groupNumber}</td>
											<td>${r.title}</td>
											<td><fmt:formatDate value="${r.beginTime }" pattern="yyyy-MM-dd HH:mm"/></td>
											<td><fmt:formatDate value="${r.endTime }" pattern="yyyy-MM-dd HH:mm"/></td>
											<td>${r.minGroupsAmount}</td>
											<td>${r.groupsAmount}</td>
											<td>
											    <c:if test="${r.status == -1}">未开团</c:if>
											    <c:if test="${r.status == 1}">开团</c:if>
											    <c:if test="${r.status == 2}">团购成功</c:if>
											    <c:if test="${r.status == 3}">团购失败</c:if>
										    </td>
											<td>${r.remarks}</td>
											<td><fmt:formatDate value="${r.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
											<td>
											    <shiro:hasPermission name="groups:update">
													<c:if test="${r.status == -1 }">
														<button class="btn btn-success" onclick="enabledGroups(${r.id});"><i class="fa fa-fw fa-check-square"></i>开团</button>
													</c:if>
													<c:if test="${r.status == 1}">
														<button class="btn btn-danger" onclick="disabledGroups(${r.id});"><i class="fa fa-fw fa-ban"></i>未开团</button>
													</c:if>
													<button class="btn btn-success" onclick="addAndUpdate(${r.id});"><i class="fa fa-edit"></i>修改</button>
													<button class="btn btn-success" onclick="addGoupsItem(${r.id});"><i class="fa fa-edit"></i>团购商品</button>
													<button class="btn btn-success" onclick="viewDetails(${r.id});"><i class="fa fa-edit"></i>查看详情</button>
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
	<script src="/plugins/jQuery/jquery-2.2.3.min.js"></script>
	<script src="/bootstrap/js/bootstrap.min.js"></script>
	<script src="/bootstrap/js/bootstrapValidator.js"></script>
	<script src="/js/raphael-min.js"></script>
	<script src="/plugins/sparkline/jquery.sparkline.min.js"></script>
	<script src="/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
	<script src="/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
	<script src="/plugins/knob/jquery.knob.js"></script>
	<script src="/js/moment.min.js"></script>
	<script src="/plugins/daterangepicker/daterangepicker.js"></script>
	<script src="/plugins/datepicker/bootstrap-datepicker.js"></script>
	<script src="/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
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
	<script type="text/javascript">
	//加载layui组件
	layui.use(['form', 'jquery','layedit', 'laydate'], function(){
		   var form = layui.form(),layer = layui.layer,$ = layui.jquery,
		       layedit = layui.layedit,laydate = layui.laydate;
	});
	//选择页码
	function onSelectPage(currentPage,pageSize){  
		$('#pageNum').val(currentPage);
		$('#pageSize').val(pageSize);
		$('#groupsForm').submit();
	}
	
	//重置
	$(function(){
		$("#reset").click(function(){
			window.location.href="/admin/groups/list";
		});
	});
	
	//开团
	function disabledGroups(id){
		$.ajax({
			type: 'post',
			url: '/admin/groups/disabled',
			data:{"id":id},
			dataType: 'json',
			success: function (data) {
				var msg = data.message;
				layer.msg(msg, {shade: 0.3} ,{time: 3000});
				//刷新页面
		        parent.location.reload();
			}
		});
	}
	//结束开团
	function enabledGroups(id){
		$.ajax({
			type: 'post',
			url: '/admin/groups/enabled',
			data:{"id":id},
			dataType: 'json',
			success: function (data) {
				var msg = data.message;
				layer.msg(msg, {shade: 0.3} ,{time: 3000});
				//刷新页面
		        parent.location.reload();
		    }
		});
	}

	//新增和修改
	function addAndUpdate(id){
		var url ="/admin/groups/toAdd";
		if(id != null){
			url += "?id="+id;
		}
		layer.open({
	        type: 2, 
	        title: '新增/修改',
	        area: ['1035px', '500px'],
	        shade: 0.5,
	        content: url,
	        zIndex: layer.zIndex, //重点1
	        cache: false,
	    });
	}
	
	//选择团购商品
	function addGoupsItem(id){
		layer.open({
	        type: 2, 
	        title: '选择商品',
	        area: ['1035px', '300px'],
	        shade: 0.5,
	        content: "/admin/groups/selectGoods?id="+id,
	        zIndex: layer.zIndex, //重点1
	        cache: false,
	    });
	}
	
	//选择团购商品
	function viewDetails(id){
		layer.open({
	        type: 2, 
	        title: '团购明细',
	        area: ['980px', '450px'],
	        shade: 0.5,
	        content: "/admin/groupsItem/getDetails?groupsId="+id,
	        zIndex: layer.zIndex, //重点1
	        cache: false,
	    });
	}
	
</script>
</body>
</html>