<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="pv" uri="/pageTaglib"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html>
<html>
<head>
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
<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>平台抽点列表</h1>
		</section>
		<!-- Main content -->
		<shiro:hasPermission name="orderPercentage:query">
			<section class="content">
				<div class="row">
					<div class="col-xs-12">
						<div class="box">
							<div class="box-header">
								<h3 class="box-title">平台抽点列表</h3>
							</div>
							<div class="box box-info">
								<!-- form start -->
								<form id="subForm" class="form-horizontal" action="<%=request.getContextPath()%>/admin/orderPercentage/list" method="post">
									<input type="hidden" name="pageNum" id="pageNum" value="${paginator.currentPage}">
	             					<input type="hidden" name="pageSize" id="pageSize" value="${paginator.pageRecord}">
									<div class="box-body">
										<div class="col-md-12">
											<div class="form-group">
											    <label for="sellerName" class="col-md-1 control-label">商铺名称：</label>
											    <div class="col-md-2">
												  <input type="text" class="form-control" id="sellerName" name="sellerName" placeholder="请输商铺名称" value="${percentage.sellerName}">
											    </div>
											    <label for="createTimeStart" class="col-md-1 control-label">开始时间:</label>
								                  <div class="col-md-2">
									                <input type="text" name="createTimeStart" id="createTimeStart" value="${percentage.createTimeStart}" class="form-control input-small" placeholder="请选择开始时间">
									              </div>
									              <label for="createTimeStop" class="col-md-1 control-label">结束时间:</label>
								                  <div class="col-md-2">
									                <input type="text" name="createTimeStop" id="createTimeStop" value="${percentage.createTimeStop}"  class="form-control" placeholder="请输入结束时间">
									              </div>
											</div>
										</div>
										<div class="form-footer">
											<button type="submit" class="btn btn-info  btn-select">查询</button>
											<button type="reset" id="reset" class="btn btn-info " onclick="clearSearch()">重置</button>
										</div>
									</div>
								</form>
								<!-- form end -->
							</div>
							<div class="row">
							    <div class="col-sm-12">
								    <div class="pull-left">
								      <button type="button" class="btn btn-primary" id="export" data-complete-text="Loading finished" >导出</button>
								      <button type="button" class="btn btn-primary" id="exportAll" data-complete-text="Loading finished" >导出全部</button>
								      <span style="margin-left:30px;font-weight:900;font-size:16px;color:#000aaa;" >平台抽成总金额：${totalPercentageAmount }</span>
								      <c:set var="percentageAmount" value="0"></c:set>
								      <c:forEach items="${paginator.object}" var="list" varStatus="status"> 
						              	 <c:set var="percentageAmount" value="${percentageAmount+list.percentageAmount}"></c:set>
						              </c:forEach> 
								      <span style="margin-left:30px;font-weight:900;font-size:16px;color:#000aaa;" >总计抽成金额：${percentageAmount }</span>
								    </div>
							    </div>
							</div>
							<!-- /.box-header -->
							<div class="layui-form">
								<table class="layui-table" lay-skin="row">
									<thead>
										<tr>
											<th>商铺名称</th>
											<th>订单金额</th>
											<th>抽点金额</th>
											<th>订单实际金额</th>
											<th>订单时间</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${paginator.object}" var="r">
											<tr>
												<td>${r.sellerName}</td>
								   			    <td>${r.originalAmount}</td>
										        <td>${r.percentageAmount}</td>
										        <td>${r.realAmount}</td>
									            <td><fmt:formatDate value="${r.createTime }" pattern="yyyy-MM-dd"/></td>
												<td><a href="<%=request.getContextPath()%>/admin/orderPercentage/percentageItems?sellerId=${r.sellerId}&time=<fmt:formatDate value="${r.createTime }" pattern="yyyy-MM-dd"/>" target="_blank" style="font-family:'微软雅黑';"><b><u>查看明细</u></b></a></td>
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
<script charset="utf-8" src="/My97DatePicker/WdatePicker.js"></script>
<script src="/js/layuiUtil.js" charset="utf-8"></script>
<script type="text/javascript">
//重置
function clearSearch(){
	window.location.href="<%=request.getContextPath()%>/admin/orderPercentage/list";
}

function onSelectPage(currentPage,pageSize)
{  
	$('#pageNum').val(currentPage);
	$('#pageSize').val(pageSize);
	$('#subForm').submit();
}  
</script>
<script type="text/javascript">
//初始化时间选择器
$("#createTimeStart").bind("click focus", function () {
    var endtimeTf = $dp.$('createTimeStop');
    WdatePicker({
        maxDate: '#F{$dp.$D(\'createTimeStart\')}',
        dateFmt: "yyyy-MM-dd",
        onpicked: function () { endtimeTf.focus(); }
    });
});
$("#createTimeStop").bind("click focus", function () {
    WdatePicker({
        minDate: '#F{$dp.$D(\'createTimeStart\')}',
        dateFmt: "yyyy-MM-dd"
    });
});

//重置
$(function(){
   $("#reset").click(function(){
	   window.location.href="/admin/orderPercentage/list";
   });
  });
//导出;
$(function() { 
    $("#export").click(function(){
    	window.location.href="/admin/orderPercentage/export?"+$('#subForm').serialize();
    })
});

//导出全部;
$(function() { 
    $("#exportAll").click(function(){
    	window.location.href="/admin/orderPercentage/exportAll";
    })
});
</script>
</body>
</html>