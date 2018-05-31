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
<meta name="decorator" content="default" />
<style type="text/css">
button {
	margin-right: 5px;
}
</style>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="content-wrapper">
		<section class="content-header">
			<h1>密码管理</h1>
		</section>
		<!-- Main content start-->
		<shiro:hasPermission name="withdrawalPassword:query">
			<section class="content">
				<div class="row">
					<div class="col-xs-12">
						<div class="box">
							<div class="box-header">
								<h3 class="box-title">密码列表信息</h3>
							</div>
							<form id="subForm" class="layui-form"
								action="<%=request.getContextPath()%>/admin/withdrawalPassword/list"
								method="post">
								<input type="hidden" name="pageNum" id="pageNum"
									value="${paginator.currentPage}"> <input type="hidden"
									name="pageSize" id="pageSize" value="${paginator.pageRecord}">
								<div class="box-body">
									<div class="form-group">
										<label for="users.trueName" class="col-sm-2 control-label">姓名</label>
										<div class="col-sm-3">
											<input type="text" class="form-control input-small"
												id="userstrueName"
												value="${withdrawalPassword.users.trueName}"
												name="users.trueName" placeholder="请输入申请人姓名">
										</div>
										<label for="users.account" class="col-sm-2 control-label">手机号码</label>
										<div class="col-sm-3">
											<input type="text" class="form-control input-small"
												id="usersaccount"
												value="${withdrawalPassword.users.account}"
												name="users.account" placeholder="请输入手机号码">
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
							<!-- 增删改按钮组 -->
							<div class="site-demo-button">
								<!-- 频道信息新增 Modal start -->
								<div class="modal hide fade" id="addChannelInfoModal"
									tabindex="-1" role="dialog">
									<div class="modal-header">
										<button class="close" type="button" data-dismiss="modal">×</button>
										<h3>新增频道信息</h3>
									</div>
									<div class="modal-body"></div>
								</div>
							</div>
							<div class="layui-form" style="margin-top: 40px;">
								<table class="layui-table table-striped">
									<thead>
										<tr>
											<th>姓名</th>
											<th>手机号码</th>
											<th>所属类型</th>
											<th>提现密码</th>
											<th>添加时间</th>
											<th>最后一次修改时间</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${paginator.object}" var="r">
											<tr>
												<td>${r.users.trueName}</td>
												<td>${r.users.account}</td>
												<td><c:if test="${r.users.type==1}">买家</c:if> <c:if
														test="${r.users.type==2}">卖家</c:if></td>
												<td>${r.password}</td>
												<td><fmt:formatDate value="${r.createTime}"
														pattern="yyyy-MM-dd HH:mm:ss" /></td>
												<td><fmt:formatDate value="${r.lastUpdateTime}"
														pattern="yyyy-MM-dd HH:mm:ss" /></td>
												<td><a href="#" onclick="update(${r.id})"
													class="btn btn-info btn-xs"><i
														class="fa fa-search-plus"></i>重置密码</a></td>
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
		<!-- Main content end-->
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
		function onSelectPage(currentPage,pageSize)
		{  
			$('#pageNum').val(currentPage);
			$('#pageSize').val(pageSize);
			$('#subForm').submit();
		} 
	</script>
	<script>
		//重置
		$(function(){
		   $("#reset").click(function(){
			   window.location.href="/admin/withdrawalPassword/list"
		   });
		  });

		//修改数据
		function update(id){
			layer.confirm('确定要初始化密码吗?', {
				  btn: ['确定','取消'] //按钮
				}, function(){
					$.ajax({  
			            url:"<%=request.getContextPath()%>/admin/withdrawalPassword/updatePasswordById",
			            data:{"id":id},
			            dataType:"json",  
			            success:function(data){  
			            	layer.alert(data.message, {
			            		  skin: 'layui-layer-molv' //样式类名
			            		  ,closeBtn: 0
			            		});
			            }  
			        }); 
				}, function(){
				  return;
				});
		}
		
		layui.use('form', function(){
			  var $ = layui.jquery, form = layui.form();
			  
			  //全选
			  form.on('checkbox(allChoose)', function(data){
			    var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]');
			    child.each(function(index, item){
			      item.checked = data.elem.checked;
			    });
			    form.render('checkbox');
			  });
			  
		});
	</script>
</body>
</html>