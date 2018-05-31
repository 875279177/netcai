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
	margin-right: 75px;
	float: right;
}

.btn-select {
	margin-right: 20px;
}
</style>
</head>
<body>
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>用户建议信息管理</h1>
		</section>
		<!-- Main content -->
		<shiro:hasPermission name="suggestion:query">
			<section class="content">
				<div class="row">
					<div class="col-xs-12">
						<div class="box">
							<div class="box-header">
								<h3 class="box-title">用户建议信息列表</h3>
							</div>
							<div class="box box-info">
								<form id="form_submit" action="/admin/suggestion/list"
									method="post" class="form-horizontal">
									<input type="hidden" name="pageNum" id="pageNum"
										value="${paginator.currentPage}"> <input type="hidden"
										name="pageSize" id="pageSize" value="${paginator.pageRecord}">
									<div class="box-body">
										<div class="form-group">
											<label for="status" class="col-sm-2 control-label">用户类型：</label>
											<div class="col-xs-2">
												<select id="type" name="type" class="form-control"
													style="width: 150px;">
													<option value="" selected>全部</option>
													<option value="1"
														<c:if test="${suggestion.type ==1 }">selected</c:if>>买家</option>
													<option value="2"
														<c:if test="${suggestion.type ==2 }">selected</c:if>>卖家</option>
												</select>
											</div>
											<!--                      <label for="datetimeStart" class="col-sm-1 control-label">开始时间：</label> -->
											<!-- 	                 <div class="col-sm-3"> -->
											<!-- 	                    <input type="date" class="form-control" id="startTime" name="startTime" value=""  > -->
											<!-- 	                 </div> -->
											<!-- 				     <label for="datetimeEnd" class="col-sm-1 control-label">结束时间：</label> -->
											<!-- 				     <div class="col-sm-3"> -->
											<!-- 	                   <input type="date" class="form-control" id="endTime" name="endTime" value=""  > -->
											<!-- 	                 </div> -->
										</div>
										<div class="form-footer">
											<button type="submit"
												class="btn btn-info pull-left btn-select">查询</button>
											<button type="reset" class="btn btn-info pull-left">重置</button>
										</div>
									</div>
								</form>
							</div>
							<!-- /.box-header -->
							<div class="layui-form">
								<table class="layui-table" lay-skin="row">
									<thead>
										<tr>
											<th>店铺名称</th>
											<th>用户姓名</th>
											<th>用户账号</th>
											<th>用户类型</th>
											<th>建议内容</th>
											<th>建议时间</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${paginator.object}" var="r">
											<tr>
												<td>${r.shopName}</td>
												<td>${r.userName}</td>
												<td>${r.account}</td>
												<td>
													<c:if test="${r.type ==1}">买家</c:if>
													<c:if test="${r.type ==2}">卖家</c:if>
												</td>
												<td>${r.suggestionContent}</td>
												<td><fmt:formatDate value="${r.createTime }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
												<td>
											        <shiro:hasPermission name="suggestion:view">
														<a href="#" onclick="get(${r.id},'${r.shopName}')" class="btn btn-success btn-xs"><i class="fa fa-edit"></i>查询</a>
													</shiro:hasPermission>
													<shiro:hasPermission name="suggestion:reply">
														<a href="#" onclick="add(${r.id},'${r.shopName}')" class="btn btn-success btn-xs"><i class="fa fa-edit"></i>回复</a>
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
		function onSelectPage(currentPage,pageSize){  
			$('#pageNum').val(currentPage);
			$('#pageSize').val(pageSize);
			$('#form_submit').submit();
		}  
		
		layui.use(['form', 'layedit', 'laydate'], function(){
			   var form = layui.form(),layer = layui.layer,layedit = layui.layedit,laydate = layui.laydate;
			   $ = layui.jquery;
			   layui.selMeltiple($);
			 //全选
			   form.on('checkbox(allChoose)', function(data){
			     var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]');
			     child.each(function(index, item){
			       item.checked = data.elem.checked;
			     });
			     form.render('checkbox');
			   });
			   
			   //监听指定开关
			   form.on('switch(switchTest)', function(data){
			       layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
			           offset: '6px'
			       });
			   });
		});
		
		//回复
		function add(id,shopName){
			layer.open({
		        type: 2, 
		        title: shopName+'回复建议',
		        area: ['800px', '300px'],
		        shade: 0.5,
		        content: '/admin/suggestionReply/toAdd?suggestionId='+id,
		        zIndex: layer.zIndex, //重点1
		        cache: false,
		      });
		}
		
		//查看
		function get(id,shopName){
			layer.open({
		        type: 2, 
		        title: '查看'+shopName,
		        area: ['1050px', '600px'],
		        shade: 0.5,
		        content: '/admin/suggestionReply/list?suggestionId='+id,
		        zIndex: layer.zIndex, //重点1
		        cache: false,
		      });
		}
	</script>
</body>
</html>