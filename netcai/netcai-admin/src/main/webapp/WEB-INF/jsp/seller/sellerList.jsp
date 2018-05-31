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
	        <h1>卖家管理</h1>
		</section>
		<!-- Main content -->
		<shiro:hasPermission name="seller:query">
		<section class="content">
			<div class="row">
				<div class="col-xs-12">
					<div class="box">
						<div class="box-header">
							<h3 class="box-title">卖家列表</h3>
						</div>
						<div class="box box-info">
							<form id="sellerForm" class="form-horizontal" action="<%=request.getContextPath()%>/admin/seller/list" method="post">
								<input type="hidden" name="pageNum" id="pageNum"value="${paginator.currentPage}"> 
								<input type="hidden" name="pageSize" id="pageSize" value="${paginator.pageRecord}">
								<div class="box-body">
									<div class="col-md-12">
										<div class="form-group">
											<label for="areaId" class="col-md-1 control-label">区域：</label>
											<div class="col-md-2">
												<select id="areaId" name="areaId" class="form-control">
													<option value="">全部</option>
												</select>
											</div>
											<label for="sellerName" class="col-md-1 control-label">店铺名称：</label>
											<div class="col-md-2">
												<input type="text" class="form-control " id="sellerName"
													name="sellerName" value="${sellerquery.sellerName}"
													placeholder="请输入店铺名称">
											</div>
											<label for="sellerAccount" class="col-md-1 control-label">联系方式：</label>
											<div class="col-md-2">
												<input type="text" class="form-control" id="sellerAccount"
													name="sellerAccount" value="${sellerquery.sellerAccount}"
													placeholder="请输入手机号码">
											</div>
										</div>
										<div class="form-group">
											<label for="status" class="col-xs-1 control-label">状态：</label>
											<div class="col-xs-2">
												<select id="status" name="users.status" class="form-control" >
													<option value=" ">全部</option>
													<option value="-1"
														<c:if test="${sellerquery.users.status == -1}">selected</c:if>>禁用</option>
													<option value="3"
														<c:if test="${sellerquery.users.status == 3}">selected</c:if>>启用</option>
													<option value="4"
														<c:if test="${sellerquery.users.status == 4}">selected</c:if>>暂停关店</option>
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
						        <shiro:hasPermission name="seller:insert">
						            <button onclick="add()" class="btn btn-success"><i class="fa fa-fw fa-plus-square"></i>新增</button>
						        </shiro:hasPermission>
						        <shiro:hasPermission name="seller:export">    
						            <button class="btn btn-success" id="export" data-complete-text="Loading finished"><i class="fa fa-fw fa-arrow-circle-down"></i>导出</button>
						        </shiro:hasPermission>
					        </div>
					    </div>
						<!-- /.box-header -->
						<div class="box-body">
							<table class="table table-bordered table-striped table-hover">
								<thead style="border-collapse:collapse;">
									<tr>
										<th>所在区域</th>
										<th>卖家名称</th>
										<th>卖家账号</th>
										<th>状态</th>
										<th>卖家等级</th>
										<th>卖家评分</th>
										<th>卖家类型</th>
										<th>余额</th>
										<th>可提现金</th>
										<th>备注</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${paginator.object}" var="r">
										<tr>
											<td>${r.areaName}</td>
											<td>${r.sellerName}</td>
											<td>${r.sellerAccount}</td>
											<td><c:if test='${r.users.status == -1}'><span style="color:graytext;">不可用</span></c:if> 
											    <c:if test='${r.users.status == 0}'><span style="color: fuchsia;">未完善资料</span></c:if> 
											    <c:if test='${r.users.status == 1}'><span style="color: purple;">未审核</span></c:if> 
											    <c:if test='${r.users.status == 2}'><span style="color: orange;">审核不通过</span></c:if> 
											    <c:if test='${r.users.status == 3}'><span style="color: green;">可用</span></c:if>
											    <c:if test='${r.users.status == 4}'><span style="color: red;">暂停关店</span></c:if>
											</td>
											<td>${r.sellerRank}</td>
											<td>${r.sellerGrade}</td>
											<td>
												<c:if test='${r.sellerType == 1}'><span style="color:red;">自营</span></c:if> 
											    <c:if test='${r.sellerType == 2}'><span style="color: fuchsia;">加盟</span></c:if> 
											    <c:if test='${r.sellerType == 3}'><span style="color: purple;">合作</span></c:if> 
											</td>
											<td>${r.balanceMoney}</td>
											<td>${r.billMoney}</td>
											<td>${r.remark}</td>
											<td>
											    <shiro:hasPermission name="seller:update">
												    <c:choose>
														<c:when test="${r.users.status == -1}">
															<button href="#" onclick="update(${r.users.id},3)" class="btn btn-success"><i class="fa fa-fw fa-check-square"></i> 启用</button>
														</c:when>
														<c:when test="${r.users.status == 3}">
															<button href="#" onclick="update(${r.users.id},-1)" class="btn btn-danger"><i class="fa fa-fw fa-ban"></i>禁用</button>
														</c:when>
														<c:otherwise>
															<button href="#" onclick="update(${r.users.id},3)" class="btn btn-success "><i class="fa fa-fw fa-check-square"></i>通过</button>
															<button href="#" onclick="update(${r.users.id},-1)" class="btn btn-danger "><i class="fa fa-fw fa-ban"></i>不通过</button>
														</c:otherwise>
													</c:choose> 
													<button href="#" onclick="addCategory(${r.sellerId})" class="btn btn-success "><i class="fa fa-fw fa-cog"></i>设置分类</button>
													<button href="#" onclick="addGoods(${r.sellerId},'${r.sellerName}')" class="btn btn-success "><i class="fa fa-fw fa-cog"></i>设置商品</button>
													<button href="#" onclick="getAllItem(${r.sellerId})" class="btn btn-success"><i class="fa fa-fw fa-eye"></i>查询订单</button>
													<button href="#" onclick="updateSeller(${r.sellerId})" class="btn btn-success"><i class="fa fa-edit"></i>修改</button>
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
	<div id="content" style="display: none">
		<div class="col-sm-1"></div>
		<div class="col-sm-10">
			<form class="form-horizontal" action="/admin/seller/add" role="form"
				method="post">
				<fieldset>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="paramCode">店铺名称</label>
						<div class="col-sm-10">
							<input class="form-control" id="fromsellerName" type="text"
								placeholder="请输入店铺名称" name="sellerName" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label" for="sellerAccount">店铺账号</label>
						<div class="col-sm-4">
							<input class="form-control" id="fromsellerAccount" type="text"
								placeholder="请输入手机号码" name="sellerAccount" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label" for="remark">备注</label>
						<div class="col-sm-4">
							<input class="form-control" id="fromremark" type="text"
								placeholder="请输入备注" name="remark" />
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-10">
							<button type="submit" class="btn btn-info pull-left"
								onclick="saveOrUp()">提交</button>
						</div>
					</div>
				</fieldset>
			</form>
		</div>
		<div class="col-sm-2"></div>
	</div>
	<input type="hidden" id="areaIdVO" value="${sellerquery.areaId}" />
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
	$('#sellerForm').submit();
}

//重置
$(function(){
	$("#reset").click(function(){
		window.location.href="/admin/seller/list";
	});
});

//禁用启用
function update(id,statu){
	  $.ajax({
		  type: 'post',
		  url: '/admin/seller/update?id='+id+"&status="+statu,
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
//新增数据弹窗
layui.use('layer', function(){ //独立版的layer无需执行这一句
	   var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句  
	   //触发事件
	  var active = {
			  setTop: function(data){
			      //多窗口模式，层叠置顶
			      layer.open({
			        type: 2, 
			        title: '新增商家',
			        area: ['1000px', '600px'],
			        shade: 0.5,
			        content: '/admin/seller/toAdd',
			        zIndex: layer.zIndex, //重点1
			        cache:false,
			        success: function(layero, index){
			        	layer.setTop(layero);
			        	var body = layer.getChildFrame('body', index);
			            var iframeWin = window[layero.find('iframe')[0]['name']];
			            //弹窗表单的取消操作时关闭弹窗
			        }
			        
			      });
			  }
	  };
	  $('.site-demo-button .layui-btn').on('click', function(){
	    var othis = $(this), method = othis.data('method');
	    active[method] ? active[method].call(this, othis) : '';
	  });
});

//添加商家的商品分类
function addCategory(sellerId){
	window.location.href="/admin/sellercategory/add?sellerId="+sellerId;
}
//商品列表
function addGoods(sellerId,sellerName){
	window.location.href="/admin/goods/list?type=1&sellerId="+sellerId+"&sellerName="+sellerName;
}
//查询订单;
function getAllItem(sellerId){
	window.location.href="/admin/orderItem/getAllItem?sellerId="+sellerId;
}

//导出;
$(function() { 
    $("#export").click(function(){
    	window.location.href="/admin/seller/export?"+$('#sellerForm').serialize();
    })
})

//新增
function add(){
	layer.open({
        type: 2, 
        title: '新增商家',
        area: ['1050px', '600px'],
        shade: 0.5,
        content: '/admin/seller/toAdd',
        zIndex: layer.zIndex, //重点1
        cache: false,
      });
}
//修改
function updateSeller(id){
	layer.open({
        type: 2, 
        title: '修改商家',
        area: ['1050px', '600px'],
        shade: 0.5,
        content: '/admin/seller/toAdd?id='+id,
        zIndex: layer.zIndex, //重点1
        cache:false,
      });
}

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