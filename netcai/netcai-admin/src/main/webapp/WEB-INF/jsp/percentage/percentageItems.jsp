<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="pv" uri="/pageTaglib"%>  
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title></title>
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- 引入公共部分jsp文件 -->
  <meta name="decorator" content="default"/>
  <style type="text/css">
    .layui-form-label{
      width:100px;
    }
    .layui-input-block{
      width:auto;
      height:auto;
    }
    table th{
      background:#ffffff;
    }
	table tr:nth-child(odd){
	  background:#F0F0F0;
	}
	.col-sm-2 {
	  width: 10%;
	}
	.box-footer{
	  text-align:center;
	}
  </style>
</head>
<body>
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>平台抽点详情列表</h1>
		</section>
		<!-- Main content -->
		<section class="content">
			<div class="row">
				<div class="col-xs-12">
					<div class="box">
						<div class="box-header">
							<h3 class="box-title">平台抽点详情</h3>
						</div>
						<!-- /.box-header -->
						<table class="layui-table" lay-skin="row">
							<thead>
								<tr>
									<th>商铺名称</th>
									<th>订单号</th>
									<th>订单金额</th>
									<th>抽点比率</th>
									<th>抽点金额</th>
									<th>卖家收入金额</th>
									<th>订单时间</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${percentageList}" var="r">
									<tr>
										<td>${r.sellerName}</td>
						   			    <td>${r.orderNumber}</td>
								        <td>${r.originalAmount}</td>
								        <td>${r.percentage}</td>
								        <td>${r.percentageAmount}</td>
								        <td>${r.realAmount}</td>
							            <td><fmt:formatDate value="${r.createTime }" pattern="yyyy-MM-dd"/></td>
							            <td>
											<div class="site-demo-button">
											    <button data-method="offset" value="${r.id }" class="layui-btn layui-btn-danger layui-btn-small"><i class="layui-icon"></i><span>&nbsp;&nbsp;删除</span></button>
											</div>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</section>
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
layui.use('layer', function(){ //独立版的layer无需执行这一句
	   var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句  
	   //触发事件
	   var active = {
			 //删除数据
		     offset: function(othis){
		         var type = othis.data('type');
		         var id = othis.val();
		         var html = "<p style='margin-top:25px;margin-left:50px;'>确定要删除此条数据吗？</p>";
		         layer.open({
		             type: 1,
		             title:'删除',
		             offset: type, 
		             area: ['350px', '215px'],
		             id: 'LAY_demo'+type, //防止重复弹出
		             content: '<div style="padding: 20px 35px;">'+html+'</div>',
		             btn: ['确定', '取消'],
		             btnAlign: 'c', //按钮居中
		             shade: 0.5 ,//不显示遮罩
		             yes: function(){
			             $.ajax({
			            	 type: "POST",
			                 url: "<%=request.getContextPath()%>/admin/orderPercentage/deleteById",
							 data : {"id" : id},
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
								alert("操作失败");
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