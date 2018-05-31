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
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>卡号管理</h1>
		</section>
		<!-- Main content -->
		<shiro:hasPermission name="withdrawalBank:query">
			<section class="content">
				<div class="row">
					<div class="col-xs-12">
						<div class="box">
							<div class="box-header">
								<h3 class="box-title">卡号列表信息</h3>
							</div>
							<form id="subForm" class="layui-form"
								action="<%=request.getContextPath()%>/admin/withdrawalBank/list"
								method="post">
								<input type="hidden" name="pageNum" id="pageNum"
									value="${paginator.currentPage}"> <input type="hidden"
									name="pageSize" id="pageSize" value="${paginator.pageRecord}">
								<div class="box-body">
									<div class="col-sm-12">
										<div class="form-group">
											<label for="cnname" class="col-sm-1 control-label">姓名</label>
											<div class="col-sm-3">
												<input type="text" class="form-control input-small"
													id="cnname" name="cnname" value="${withdrawalBank.cnname}"
													placeholder="请输入申请人姓名">
											</div>
											<label for="users.account" class="col-sm-1 control-label">联系方式</label>
											<div class="col-sm-3">
												<input type="text" class="form-control" id="usersaccount"
													name="users.account"
													value="${withdrawalBank.users.account}"
													placeholder="请输入手机号">
											</div>
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
							<!-- 增删改图标按钮组 -->
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
											<th>卡主姓名</th>
											<th>联系方式</th>
											<th>卡的缩写</th>
											<th>所属银行</th>
											<th>卡号</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${paginator.object}" var="r">
											<tr>
												<td>${r.cnname}</td>
												<td>${r.users.account}</td>
												<td>${r.bankCode}</td>
												<td>${r.bankName}</td>
												<td>${r.bankNumber}</td>
												<td><a href="#" onclick="get(${r.id})"
													class="btn btn-info btn-xs"><i
														class="fa fa-search-plus"></i> 查看</a></td>
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
			    window.location.href="/admin/withdrawalBank/list";
		    });
		});
		
		/* 提交表单数据 */
		function checkForm(){
			alert("提交数据");
		}
		
		function add(){
			popup('新增','800px','350px',$('#content').html());
		}
		
		//修改数据
		function update(id){
			  $.ajax({
				  type: 'POST',
				  url: '/admin/withdrawalBank/getById?id='+id,
				  dataType: 'json',
				  success: function (data) {
					  $("#id").attr("value", data.id);
					  $("#paramCode").attr("value", data.paramCode);
					  $("#paramName").attr("value", data.paramName);
					  $("#paramValue").attr("value", data.paramValue);
					  $("#paramDesc").attr("value", data.paramDesc);
					  popup('修改系统配置','800px','350px',$('#content').html());
				  }
			  });
		}
		
		//保存、修改数据
		function saveOrUp(){
			  $('#subForm').validate({ 		
					submitHandler: function (form) {
						$('#subForm').submit();
					}
				});
		}
		
		/* 删除 */
		function del(id) {
			if(confirm("真的要删除吗?")){
				$.ajax({  
		            url:"/admin/withdrawalBank/delete",
		            data:{"id":id},
		            dataType:"json",  
		            success:function(){  
		                alert("删除成功！"); 
		                window.location.reload();
		            }
		        })
			}else{
				return;
			}
		}
		
		/* 查看 */
		function get(id) {
		    layer.open({
		        type: 2,
		        title: '提现银行详情',
		        shadeClose: false,
		        shade: 0.8,
		        area: ['50%', '25%'],
		        content: "<%=request.getContextPath()%>/admin/withdrawalBank/getView?id="+id
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