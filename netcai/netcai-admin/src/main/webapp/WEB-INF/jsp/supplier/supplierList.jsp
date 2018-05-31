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
    .form-footer{
        margin-left:325px;
    }
    
</style>
</head>
<body>
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>供应商管理</h1>
		</section>
		<!-- Main content -->
		<shiro:hasPermission name="supplier:query">
		<section class="content">
			<div class="row">
				<div class="col-xs-12">
					<div class="box">
						<div class="box-header">
							<h3 class="box-title">供应商列表</h3>
						</div>
						<div class="box box-info">
							<form id="supplierForm" class="form-horizontal" action="<%=request.getContextPath()%>/admin/supplier/list" method="post">
								<input type="hidden" name="pageNum" id="pageNum"value="${paginator.currentPage}"> 
								<input type="hidden" name="pageSize" id="pageSize" value="${paginator.pageRecord}">
								<div class="box-body">
									<div class="col-md-12">
										<div class="form-group">
											<label for="supplierName" class="col-md-1 control-label">店铺名称：</label>
											<div class="col-md-2">
												<input type="text" class="form-control " id="supplierName"
													name="supplierName" value="${supplier.supplierName}"
													placeholder="请输入供应商信息">
											</div>
											<label for="status" class="col-xs-1 control-label">状态：</label>
											<div class="col-xs-2">
												<select id="status" name="status" class="form-control" >
													<option value=" ">全部</option>
													<option value="-1"
														<c:if test="${supplier.status == -1}">selected</c:if>>不可用</option>
													<option value="1"
														<c:if test="${supplier.status == 3}">selected</c:if>>可用</option>
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
								<button onclick="add()" class="btn btn-success"><i class="fa fa-fw fa-plus-square"></i>新增</button>
								<!-- <button class="btn btn-success" id="export" data-complete-text="Loading finished"><i class="fa fa-fw fa-arrow-circle-down"></i>导出</button> -->
					        </div>
					    </div>
						<!-- /.box-header -->
						<div class="box-body">
							<table class="table table-bordered table-striped table-hover">
								<thead style="border-collapse:collapse;">
									<tr>
										<th>供应商名称</th>
										<th>所属公司</th>
										<th>供应商联系人</th>
										<th>供应商手机号码</th>
										<th>供应商账号</th>
										<th>状态</th>
										<th>创建时间</th>
										<th>备注</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${paginator.object}" var="r">
										<tr>
											<td>${r.supplierName}</td>
											<td>${r.companyName}</td>
											<td>${r.supplierContact}</td>
											<td>${r.supplierTel}</td>
											<td>${r.supplierAccount}</td>
											<td><c:if test='${r.status == -1}'><span style="color:graytext;">不可用</span></c:if> 
											    <c:if test='${r.status == 1}'><span style="color: fuchsia;">可用</span></c:if> 
											</td>
											<td><fmt:formatDate value="${r.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
											<td>${r.remarks}</td>
											<td>
											    <c:choose>
													<c:when test="${r.status == -1}">
														<button href="#" onclick="updateStatus(${r.supplierId},1)" class="btn btn-success"><i class="fa fa-fw fa-check-square"></i> 启用</button>
													</c:when>
													<c:when test="${r.status == 1}">
														<button href="#" onclick="updateStatus(${r.supplierId},-1)" class="btn btn-danger"><i class="fa fa-fw fa-ban"></i>禁用</button>
													</c:when>
													<c:otherwise>
													</c:otherwise>
												</c:choose>
												<button href="#" onclick="update(${r.supplierId})" class="btn btn-success"><i class="fa fa-edit"></i>修改</button>
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
//分页
function onSelectPage(currentPage,pageSize){  
	$('#pageNum').val(currentPage);
	$('#pageSize').val(pageSize);
	$('#supplierForm').submit();
}

//重置
$(function(){
	$("#reset").click(function(){
		window.location.href="/admin/supplier/list";
	});
});

//禁用启用
function updateStatus(supplierId,status){
	  $.ajax({
		  type: 'post',
		  url: '/admin/supplier/updateStatus?supplierId='+supplierId+"&status="+status,
		  dataType: 'json',
		  success: function (data) {
			  var msg = data.message;
			  layer.msg(msg, {shade: 0.3} ,{time: 3000});
			  //刷新页面
	          parent.location.reload();
		  }
	  });
}

layui.use(['form', 'jquery','layedit', 'laydate'], function(){
	   var form = layui.form(),layer = layui.layer,$ = layui.jquery,
	       layedit = layui.layedit,laydate = layui.laydate;
});

//新增
function add(){
	layer.open({
        type: 2, 
        title: '新增供应商',
        area: ['1000px', '350px'],
        shade: 0.5,
        content: '/admin/supplier/toAdd',
        zIndex: layer.zIndex, //重点1
        cache: false,
      });
}
//修改
function update(supplierId){
	layer.open({
        type: 2, 
        title: '修改供应商',
        area: ['1000px', '350px'],
        shade: 0.5,
        content: '/admin/supplier/toAdd?supplierId='+supplierId,
        zIndex: layer.zIndex, //重点1
        cache:false,
      });
}
</script>
</body>
</html>