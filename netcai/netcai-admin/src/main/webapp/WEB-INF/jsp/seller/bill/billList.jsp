<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="pv" uri="/pageTaglib"%>  
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html>
<html>
<head>
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
	.form-footer{
	  margin-right:75px;
	  float:right;
	}
	.btn-select{
	  margin-right:20px;
	}
  </style>
</head>
<body>
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>账单信息管理</h1>
    </section>
    <!-- Main content -->
    <shiro:hasPermission name="bill:query">
	    <section class="content">
	      <div class="row">
	        <div class="col-xs-12">
	          <div class="box">
	            <div class="box-header">
	              <h3 class="box-title">账单列表</h3>
	            </div>
	            <div class="box box-info">
		           <form  id="form_submit" action="/admin/bill/list" method="post" class="form-horizontal">
		             <input type="hidden" name="pageNum" id="pageNum" value="${paginator.currentPage}">
	                 <input type="hidden" name="pageSize" id="pageSize" value="${paginator.pageRecord}">
		             <input type="hidden" name="sellerId"  value="${bill.sellerId}">
		             <div class="box-body">
		               <div class="form-group">
		                 <label for="buyerName" class="col-sm-2 control-label">商铺名称：</label>
		                 <div class="col-xs-2">
		                   <input type="text" class="form-control" id="sellerName" name="sellerName" placeholder="请输入餐馆名称" value="${bill.sellerName}">
		                 </div>
		                 <label for="createTime" class="control-label col-sm-2">开始时间：</label>
				         <div class="col-xs-2">
				           <input type="date" class="form-control" id="startTimeStr" name="startTimeStr" value="${bill.startTimeStr}" >
				         </div>
				         <label for="createTime" class="control-label col-sm-2">结束时间：</label>
				         <div class="col-xs-2">
				           <input type="date" class="form-control" id="endTimeStr" name="endTimeStr" value="${bill.endTimeStr}" >
				         </div>
		               </div>
		               <div class="form-group">
		                 <label for="status" class="col-sm-2 control-label">状态：</label>
		                 <div class="col-xs-2">
		                   <select id="status" name="status" class="form-control" >
							   <option value="" selected>全部</option>
						       <option value="0" <c:if test="${bill.status==0}">selected</c:if >>待结算</option>
						       <option value="1" <c:if test="${bill.status==1}">selected</c:if >>已结算</option>
						   </select>
		                 </div>
		               </div>
		               <div class="form-footer" >
		                 <button type="submit" class="btn btn-info pull-left btn-select">查询</button>
		                 <button type="reset" class="btn btn-info pull-left" onclick="clearSearch()">重置</button>
		               </div>
		             </div>
		           </form>
		        </div>
	            <!-- /.box-header -->
	            <div class="layui-form" >
	              <table class="layui-table" lay-skin="row">
	                <thead>
		              <tr>
		                <th>商铺名称</th>
		              	<th>账单时间</th>
		                <th>今日预收款</th>
		                <th>补扣款</th>
		                <th>今日实收款</th>
		                <th>状态</th>
		              </tr>
	                </thead>
	                <tbody>
		               <c:forEach items="${paginator.object}" var="r"> 
			   			 <tr>
					       <td>${r.sellerName}</td>
			   			   <td><fmt:formatDate value="${r.createTime }" pattern="yyyy-MM-dd"/></td>
					       <td>${r.expectIncome}</td>
					       <td><a href="<%=request.getContextPath()%>/admin/orderRefund/sellerDetails?sellerId=${r.sellerId }&createTime=${r.createTime }"><u><b>${r.deductMoney}</b></u></a></td>
					       <td>${r.realIncome}</td>
					       <td>
					         <c:if test="${r.status ==1}">已结算</c:if>
					         <c:if test="${r.status ==0}">待结算</c:if>
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
	window.location.href="<%=request.getContextPath()%>/admin/bill/list";
}

function onSelectPage(currentPage,pageSize)
{  
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
   //新增数据弹窗
   layui.use('layer', function(){ //独立版的layer无需执行这一句
	   var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句  
	   //触发事件
	   var active = {
			 setTop: function(data){
				 //点击修改按钮时获取id
				 var id = data.val();
			     //多窗口模式，层叠置顶
			     layer.open({
			         type: 2, 
			         title: '账单详情列表',
			         area: ['950px', '530px'],
			         shade: 0.5,
			         content: '/admin/bill/billItems?billId='+id,
			         zIndex: layer.zIndex, //重点1
			         success: function(layero, index){
			        	 layer.setTop(layero);
			         }
			     });
			 }
		  };
	   $('.site-demo-button .layui-btn').on('click', function(){
	       var othis = $(this), method = othis.data('method');
	       active[method] ? active[method].call(this, othis) : '';
	   });
	});
</script>
</body>
</html>