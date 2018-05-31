<%@ page language="java" pageEncoding="UTF-8"%>
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
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
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
			<h1>抽点配置管理</h1>
		</section>
		<!-- Main content -->
		<shiro:hasPermission name="percentageConfig:query">
			<section class="content">
				<div class="row">
					<div class="col-xs-12">
						<div class="box">
							<div class="box-header">
								<h3 class="box-title">抽点配置信息</h3>
							</div>
							<div class="box box-info">
								<!-- form start -->
								<form id="form_submit" class="form-horizontal" action="<%=request.getContextPath()%>/admin/percentageConfig/list" method="post">
									<input type="hidden" name="pageNum" id="pageNum" value="${paginator.currentPage}">
	                                <input type="hidden" name="pageSize" id="pageSize" value="${paginator.pageRecord}">
									<div class="box-body">
										<div class="col-xs-12">
											<div class="form-group">
											    <label for="provinceId" class="col-xs-1 control-label">区域选择</label>
												<div class="col-xs-2">
													<select id="region" name="regionId" class="form-control">
														<option value="">全部</option>
														<c:forEach items="${regions}" var="r">
															<option value="${r.regionId }" <c:if test="${r.regionId==percentageConfig.regionId }">selected</c:if>>${r.regionName }</option>
														</c:forEach>
													</select>
												</div>
												<label for="bossName" class="col-xs-1 control-label">商铺名称</label>
												<div class="col-xs-2">
													<input type="text" class="form-control" id="sellerName" name="sellerName" placeholder="请输入商铺名称" value="${percentageConfig.sellerName}">
												</div>
												<label for="bossTel" class="col-xs-1 control-label">商品分类</label>
												<div class="col-xs-2">
													<input type="text" class="form-control" id="categoryName" name="categoryName" placeholder="请输入商品分类" value="${percentageConfig.categoryName}">
												</div>
											</div>
											<div class="form-footer">
												<button type="submit" class="btn btn-info pull-left btn-select">查询</button>
												<button type="reset" class="btn btn-info pull-left" onclick="clearSearch()">重置</button>
											</div>
										</div>
									</div>
								</form>
								<!-- form end -->
							</div>
							<!-- /.box-header -->
							<div class="layui-form">
								<div class="site-demo-button">
									<button data-method="setTop" class="layui-btn layui-btn-small layui-btn-primary"><i class="layui-icon"></i><span>&nbsp;&nbsp;新增</span></button>
									<button data-method="setTop" class="layui-btn layui-btn-small layui-btn-primary"><i class="layui-icon"></i><span>快速配置</span></button>
								</div>
								<table class="layui-table" lay-skin="row">
									<thead>
										<tr>
											<th>区域</th>
											<th>商铺名称</th>
											<th>商品分类名称</th>
											<th>平台抽点率</th>
											<th>状态</th>
											<th>创建时间</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${paginator.object}" var="r">
											<tr>
												<td>${r.regionName}</td>
												<td>${r.sellerName}</td>
												<td>${r.categoryName}</td>
												<td>${r.percentage}%</td>
												<td><c:if test="${r.status ==-1}">禁用</c:if> <c:if test="${r.status ==1}">可用</c:if></td>
												<td><fmt:formatDate value="${r.createTime }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
												<td>
													<div class="site-demo-button">
														<button data-method="offset" value="${r.id }" class="layui-btn layui-btn-normal layui-btn-small"><i class="layui-icon"></i><span>&nbsp;&nbsp;修改</span></button>
													    <button data-method="offset" value="${r.id }" class="layui-btn layui-btn-danger layui-btn-small"><i class="layui-icon"></i><span>&nbsp;&nbsp;删除</span></button>
													</div>
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
//重置
function clearSearch(){
	window.location.href="<%=request.getContextPath()%>/admin/percentageConfig/list";
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
   layui.use('table', function(){
	   var table = layui.table;
	   
	 });
   //新增数据弹窗
   layui.use('layer', function(){ //独立版的layer无需执行这一句
	   var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句  
	   //触发事件
	   var active = {
			 setTop: function(data){
				 var text = data.text();
				 var url ,title;
				 if(text.indexOf("新增")!=-1){
					 title = '新增抽点配置信息';
					 url = '/admin/percentageConfig/toAdd';
				 }else if(text.indexOf("快速配置")!=-1){
					 title = '快速配置';
					 url = '/admin/percentageConfig/addBySellerId';
				 }
			     //多窗口模式，层叠置顶
			     layer.open({
			         type: 2, 
			         title: title,
			         area: ['1035px', '350px'],
			         shade: 0.5,
			         content: url,
			         zIndex: layer.zIndex, //重点1
			         success: function(layero, index){
			        	 layer.setTop(layero);
			        	 var body = layer.getChildFrame('body', index);
			             var iframeWin = window[layero.find('iframe')[0]['name']]; 
			         }
			     });
			 },
			 //修改平台抽点率
		     offset: function(othis){
		         var type = othis.data('type');
		         var id = othis.val();
		         var text = othis.text();
		         var html,url,title;
		         if(text.indexOf("删除")!=-1){
		        	 title = "删除";
		        	 url = "<%=request.getContextPath()%>/admin/percentageConfig/deleteById";
		        	 html = "<p style='margin-top:25px;margin-left:50px;'>确定要删除此条数据吗？</p>";
		         }else if(text.indexOf("修改")!=-1){
		        	 title = "修改抽点率";
		        	 url = "<%=request.getContextPath()%>/admin/percentageConfig/update";
		        	 html = '<span>抽点率：</span><input type="text" id="update_percentage" style="margin-top:10px;margin-left:10px;width:175px;height:30px;" >';
		         }
		         layer.open({
		             type: 1,
		             title:title,
		             offset: type, 
		             area: ['350px', '215px'],
		             id: 'LAY_demo'+type, //防止重复弹出
		             content: '<div style="padding: 20px 35px;">'+ html +'</div>',
		             btn: ['确定', '取消'],
		             btnAlign: 'c', //按钮居中
		             shade: 0.5 ,//不显示遮罩
		             yes: function(){
		            	 if(text.indexOf("修改")!=-1){
		            		 var percentage = $("#update_percentage").val();
				        	 if(percentage==null || percentage==""){
				        		 alert("请输入抽点率");
				        		 return false;
				        	 } 
		            	 }
			             $.ajax({
			            	 type: "POST",
			                 url: url,
							 data : {"id" : id,"percentage" : percentage},
							 dataType : "json",
							 async:false,
							 cache : false,
							 success : function(data) {
								var msg = data.message;
								layer.msg(msg, {shade: 0.3} ,{time: 2000});
								//刷新页面
    			                parent.location.reload();
							},
							error : function() {
								layer.msg("操作失败", {shade: 0.3} ,{time: 2000});
							}
						 });
					 },
					 btn2 : function() {
						 layer.closeAll();
					 }
			     });

			 }

	   };
	   $('.site-demo-button .layui-btn').on('click',function() {
		   var othis = $(this), method = othis.data('method');
		   active[method] ? active[method].call(this, othis) : '';
	   });
   });
</script>
</body>
</html>