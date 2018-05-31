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
    button{
      margin-right:5px;
    }
  </style>
</head>
<body>
  <!-- 配送人员列表start -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>取消订单日志管理</h1>
    </section>
    <!-- Main content -->
    <shiro:hasPermission name="orderCancelLogs:query">
	    <section class="content">
	      <div class="row">
	        <div class="col-xs-12">
	          <div class="box">
	            <!-- 表单start -->
	            <form id="submitForm" class="layui-form" action="<%=request.getContextPath() %>/admin/orderCancelLogs/list" method="post" >
	              <input type="hidden" name="pageNum" id="pageNum" value="${paginator.currentPage}">
	              <input type="hidden" name="pageSize" id="pageSize" value="${paginator.pageRecord}">
	              <div class="col-sm-12" style="top: 20px">
	                <div class="form-group" >
	                 <label for="areaId" class="col-sm-1 control-label">区域：</label>
	                 <div class="col-sm-3">
	                   <select id="areaId" name="areaId" class="form-control" >
						   <option value="" >全部</option>
					   </select>
	                 </div>
	                	<label for="buyerName" class="col-sm-1 control-label">店铺名称：</label>
		                 <div class="col-sm-3">
		                   <input type="text" class="form-control" id="buyerName" name="buyerName" placeholder="请输入店铺名称" value="${orderCancelLogs.buyerName}">
		                 </div>
		                 <label for="bossTel" class="col-sm-1 control-label">手机号：</label>
		                 <div class="col-sm-3">
		                   <input type="text" class="form-control" id="bossTel" name="bossTel" placeholder="请输入手机号" value="${orderCancelLogs.bossTel}">
		                 </div>
	                </div>
	              </div>
	              <div class="col-sm-3 layui-form-item layui-form-btns" style="float: right;top: 50px">
					   <div class="layui-input-block">
					     <button class="layui-btn" lay-submit="" lay-filter="demo1">查询</button>
					     <button type="reset" id="reset" class="layui-btn layui-btn-primary">重置</button>
					   </div>
				   </div>
	            </form> 
	            <!-- 表单end -->
	            <!-- /.box-header -->
	            <div class="layui-form" style="margin-top: 150px">
	              <table id="contentTable" class="layui-table table-striped">
	                <thead>
		             <tr>
		                <th>所在区域</th>
		                <th>订单号</th>
		                <th>销售人员</th>
		                <th>手机号</th>
		                <th>买家店铺</th>
		                <th>金额</th>
		                <th>下单时间</th>
		                <th>取消时间</th>
		                <th>备注</th>
		              </tr>
	                </thead>
	                <tbody>
		              <c:forEach items="${paginator.object}" var="r"> 
			   			 <tr>
						       <td>${r.areaName}</td>
						       <td><a style="color: blue;" href="/admin/orderInfo/list?orderNumber=${r.orderNumber}&pageSize=30">${r.orderNumber}</a></td>
						       <td>${r.trueName}</td>
						       <td>${r.bossTel}</td>
						       <td>${r.buyerName}</td>
						       <td>${r.lastMoney}</td>
							       <td><fmt:formatDate value="${r.orderCreateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							       <td><fmt:formatDate value="${r.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						       <td>${r.remarks}</td>
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
<input type="hidden" id="areaIdVO" value="${orderCancelLogs.areaId}"/>
<script src="/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="/bootstrap/js/bootstrap.min.js"></script>
<script src="/bootstrap/js/bootstrap-datetimepicker.js"></script>
<script src="/bootstrap/js/bootstrap-editable.js"></script>
<script src="/js/raphael-min.js"></script>
<script src="/plugins/sparkline/jquery.sparkline.min.js"></script>
<script src="/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script src="/plugins/knob/jquery.knob.js"></script>
<script src="/js/moment.min.js"></script>
<script src="/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script src="/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="/plugins/fastclick/fastclick.js"></script>
<script src="/dist/js/app.min.js"></script>
<script src="/dist/js/demo.js"></script>
<script src="/js/jquery-ui.min.js"></script>
<script src="/layui/layui.js" charset="utf-8"></script>
<script src="/bootstrap/js/layui-mz-min.js" charset="utf-8"></script>
<script charset="utf-8" src="/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
//分页
function onSelectPage(currentPage,pageSize){  
	$('#pageNum').val(currentPage);
	$('#pageSize').val(pageSize);
	$('#submitForm').submit();
} 
</script>
<script>

var pageNum = $('#pageNum').val();
var pageSize =  $('#pageSize').val();

//重置
$(function(){
   $("#reset").click(function(){
	   window.location.href="/admin/orderCancelLogs/list";
   });
  });

layui.use(['form', 'jquery','layedit', 'laydate'], function(){
	   var form = layui.form(),layer = layui.layer,$ = layui.jquery,
	       layedit = layui.layedit,laydate = layui.laydate;
	   $ = layui.jquery;
	   layui.selMeltiple($);
});

//新增数据弹窗
layui.use('layer', function(){ //独立版的layer无需执行这一句
	   var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句  
	  $('.site-demo-button .layui-btn').on('click', function(){
	    var othis = $(this), method = othis.data('method');
	    active[method] ? active[method].call(this, othis) : '';
	  });
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
   	   var list = date.object;  
         if(list != null && list.length > 0){
             for(var i = 0; i< list.length; i++){
                 if(list[i].id == areaId){
              	   $("<option value='"+list[i].id+"' selected>"+list[i].areaName+"</option>").appendTo("#areaId");
                 }else {
                 $("<option value='"+list[i].id+"'>"+list[i].areaName+"</option>").appendTo("#areaId");  
				}
             }  
         } 
	    } 
	  }); 
	}
</script>
</body>
</html>