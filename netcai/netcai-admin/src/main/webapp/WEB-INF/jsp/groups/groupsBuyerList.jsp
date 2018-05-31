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
    .form-footer{
        margin-left:325px;
    }
</style>
</head>
<body>
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
	        <h1>团购买家下单管理</h1>
		</section>
		<!-- Main content -->
		<shiro:hasPermission name="groupsBuyer:query">
		<section class="content">
			<div class="row">
				<div class="col-xs-12">
					<div class="box">
						<div class="box-header">
							<h3 class="box-title">团购买家下单列表</h3>
						</div>
						<div class="box box-info">
							<form id="groupsBuyerForm" class="form-horizontal" action="<%=request.getContextPath()%>/admin/groupsBuyer/list" method="post">
								<input type="hidden" name="pageNum" id="pageNum"value="${paginator.currentPage}"> 
								<input type="hidden" name="pageSize" id="pageSize" value="${paginator.pageRecord}">
								<div class="box-body">
									<div class="col-md-12">
										<div class="form-group">
											<label for="areaId" class="col-md-1 control-label">区域：</label>
											<div class="col-md-2">
												<select id="areaId" name="buyer.regionId" class="form-control">
													<option value="">全部</option>
												</select>
											</div>
											<label for="buyerName" class="col-md-1 control-label">店铺信息：</label>
											<div class="col-md-2">
												<input type="text" class="form-control " id="buyerName"
													name="buyer.buyerName" value="${groupsBuyer.buyer.buyerName}"
													placeholder="请输入店铺信息">
											</div>
											<label for="title" class="col-md-1 control-label">团购标题：</label>
											<div class="col-md-2">
												<input type="text" class="form-control " id="title"
													name="groups.title" value="${groupsBuyer.groups.title}"
													placeholder="请输入团购标题">
											</div>
										</div>
										<div class="form-group">
											<label for="gbStatus" class="col-xs-1 control-label">状态：</label>
											<div class="col-xs-2">
												<select id="gbStatus" name="gbStatus" class="form-control" >
													<option value=" ">全部</option>
													<option value="-1"
														<c:if test="${groupsBuyer.gbStatus == -1}">selected</c:if>>取消</option>
													<option value="1"
														<c:if test="${groupsBuyer.gbStatus == 1}">selected</c:if>>完成</option>
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
						<!-- /.box-header -->
						<div class="box-body">
							<table class="table table-bordered table-striped table-hover">
								<thead style="border-collapse:collapse;">
									<tr>
										<th>所在区域</th>
										<th>团购标题</th>
										<th>订单号</th>
										<th>买家店铺</th>
										<th>联系方式</th>
										<th>状态</th>
										<th>团购时间</th>
										<th>商品名称</th>
										<th>商品品牌</th>
										<th>团购数量</th>
										<th>团购价格</th>
										<th>团购金额</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${pageResult.object}" var="r">
										<tr>
											<td>${r.areaName}</td>
											<td>${r.groups.title}</td>
											<td><a style="color: blue;" href="/admin/orderItem/getAll?orderNumber=${r.orderInfo.orderNumber}&pageSize=30">${r.orderInfo.orderNumber}</a></td>
											<td>${r.buyer.buyerName}</td>
											<td>${r.buyer.bossTel}</td>
											<td>
												<c:if test="${r.gbStatus == 1}">完成</c:if>
												<c:if test="${r.gbStatus == -1}">取消</c:if>
											</td>
											<td><fmt:formatDate value="${r.gbTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
											<td>${r.goods.goodsName}</td>
											<td>${r.goods.goodsBrand}</td>
											<td>${r.gbNum}</td>
											<td>${r.gbPrice}</td>
											<td>${r.gbAmt}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<div class="box-footer clearfix">
							<ul class="pagination pagination-sm no-margin pull-left">
								<pv:showPaging pageVo="${pageResult}" />
							</ul>
						</div>
					</div>
				</div>
			</div>
		</section>
		</shiro:hasPermission>
	</div>
<input type="hidden" id="areaIdVO" value="${groupsBuyer.buyer.regionId}" />
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
	$('#groupsBuyerForm').submit();
}

//重置
$(function(){
	$("#reset").click(function(){
		window.location.href="/admin/groupsBuyer/list";
	});
});

//禁用启用
function update(id,statu){
	  $.ajax({
		  type: 'post',
		  url: '/admin/groupsBuyer/update?id='+id+"&status="+statu,
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

//获取区域信息;
$(document).ready(function(){ 
	loadregion(); 
	}); 
	
var areaId = $('#areaIdVO').val();
function loadregion(){
	if(areaId == null || areaId == '' ||areaId == undefined){
		areaId = 0;
	}
	  var url='/admin/region/Alllist'; 
	  jQuery.ajax({ 
	    type:'post', 
	    url:url, 
	    async:false,
	    success:function (date){
   	   var areaList = date.object;  
         if(areaList != null && areaList.length > 0){
             for(var i = 0; i< areaList.length; i++){
                 if(areaList[i].id == areaId){
              	   $("<option value='"+areaList[i].id+"' selected>"+areaList[i].areaName+"</option>").appendTo("#areaId");
                 }else {
                 $("<option value='"+areaList[i].id+"'>"+areaList[i].areaName+"</option>").appendTo("#areaId");  
				}
             }  
         } 
	    } 
	  }); 
	}
</script>
</body>
</html>