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
	  margin-right:800px;
	  float:right;
	}
	.btn-select{
	  margin-right:10px;
	}
  </style>
</head>
<body>
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>配送人员绩效</h1>
    </section>
    <!-- Main content -->
    <shiro:hasPermission name="deliveryIncome:query">
	    <section class="content">
	      <div class="row">
	        <div class="col-xs-12">
	          <div class="box">
	            <div class="box-header">
	              <h3 class="box-title">配送人员绩效信息</h3>
	            </div><div class="box box-info">
		           <!-- form start -->
		           <form  id="form_submit" class="form-horizontal" action="<%=request.getContextPath()%>/admin/deliveryIncome/list" method="post">
		             <input type="hidden" name="pageNum" id="pageNum" value="${paginator.currentPage}">
	              	 <input type="hidden" name="pageSize" id="pageSize" value="${paginator.pageRecord}">
		               
		               <div class="col-sm-12">
			               <div class="form-group">
			                  <label for="createTimeStart" class="col-sm-1 control-label">查询时间:</label>
			                  <div class="col-sm-2">
				                <input type="text" name="createTimeStart" id="createTimeStart" value="${deliveryIncome.createTimeStart}" class="form-control" placeholder="请输入查询时间">
				              </div>
				              <div class="layui-form-mid">---</div>
			                  <div class="col-sm-2">
				                <input type="text" name="createTimeStop" id="createTimeStop" value="${deliveryIncome.createTimeStop}"  class="form-control" placeholder="请输入查询时间">
				              </div>
				              <label for="countStart" class="col-sm-1 control-label">查询数量:</label>
			                  <div class="col-sm-2">
				                <input type="number" name="countStart" id="countStart" value="${deliveryIncome.countStart}" class="form-control" placeholder="请输入查询数量">
				              </div>
				              <div class="layui-form-mid">---</div>
			                  <div class="col-sm-2">
				                <input type="number" name="countStop" id="countStop" value="${deliveryIncome.countStop}"  class="form-control" placeholder="请输入查询数量">
				              </div>
			                 <div class="col-sm-2">
			                   <input type="text" class="form-control" id="deliveryName" name="deliveryName" placeholder="请输入查询姓名" value="${deliveryIncome.deliveryName}">
			                 </div>
			               </div>
		               </div>
		               
		               <div class="col-sm-12">
			               <div class="form-group">
			               	  <label for="amtStart" class="col-sm-1 control-label">查询订单金额:</label>
			                  <div class="col-sm-2">
				                <input type="number" name="amtStart" id="amtStart" value="${deliveryIncome.amtStart}" class="form-control" placeholder="请输入查询订单金额">
				              </div>
				              <div class="layui-form-mid">---</div>
			                  <div class="col-sm-2">
				                <input type="number" name="amtStop" id="amtStop" value="${deliveryIncome.amtStop}"  class="form-control" placeholder="请输入查询订单金额">
				              </div>
				              <label for="incomeStart" class="col-sm-1 control-label">查询收入:</label>
			                  <div class="col-sm-2">
				                <input type="number" name="incomeStart" id="incomeStart" value="${deliveryIncome.incomeStart}" class="form-control" placeholder="请输入查询收入">
				              </div>
				              <div class="layui-form-mid">---</div>
			                  <div class="col-sm-2">
				                <input type="number" name="incomeStop" id="incomeStop" value="${deliveryIncome.incomeStop}"  class="form-control" placeholder="请输入查询收入">
				              </div>
			               </div>
		               </div>
			           <div class="form-footer" >
			             <button type="submit" class="btn btn-info pull-left btn-select">查询</button>
			             <button type="reset" id="reset" class="btn btn-info pull-left">重置</button>
			           </div>
		           </form>
		           <!-- form end -->
		           
		           <div class="row">
				<div class="col-sm-12">
				<div class="pull-left">
				<button type="button" class="btn btn-primary" id="export" 
				    data-complete-text="Loading finished" >导出
				</button>
				</div>
				</div>
				</div>
		           
		        </div>
	            <!-- /.box-header -->
	            <div>
	              <table class="layui-table" lay-skin="row" >
	                <thead>
		              <tr>
		              	<th></th>
		                <th>配送日期</th>
		                <th>配送人员名称</th>
		                <th>配送人员电话</th>
		                <th>送达金额</th>
		                <th>送达数量</th>
		                <th>提成收入</th>
		                <th>配送区域</th>
		              </tr>
			              <c:set var="diAmt" value="0"></c:set>
			        	<c:set var="diCount" value="0"></c:set>
			        	<c:set var="diIncome" value="0"></c:set>
	                </thead>
	                <tbody>
		               <c:forEach items="${paginator.object}" var="r" varStatus="status"> 
			              	 <c:set var="diAmt" value="${diAmt+r.diAmt}"></c:set>
			              	 <c:set var="diCount" value="${diCount+r.diCount}"></c:set>
			              	 <c:set var="diIncome" value="${diIncome+r.diIncome}"></c:set>
			   			 <tr>
			   			 	<td><c:out value="${status.count}"/> </td>
					       <td><fmt:formatDate value="${r.diDate}" pattern="yyyy-MM-dd"/></td>
					       <td>${r.deliveryName}</td>
					       <td>${r.deliveryPhone}</td>
					       <td>${r.diAmt}</td>
					       <td><a style="color: blue;" href="/admin/deliveryIncome/getBuyer?deliveryId=${r.deliveryId}&time=<fmt:formatDate value="${r.diDate}" pattern="yyyy-MM-dd"/>">${r.diCount}</a></td>
					       <td>${r.diIncome}</td>
					       <td>${r.diArea}</td>
			             </tr>
					   </c:forEach>
					   <tr>
		            	<th></th>
		                <th style="color: red;">总计</th>
		                <th></th>
		                <th></th>
		                <th style="color: red;">${diAmt}</th>
		                <th style="color: red;">${diCount}</th>
		                <th style="color: red;">${diIncome}</th>
		                <th></th>
		                <th></th>
		              </tr>
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
<script charset="utf-8" src="/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
function onSelectPage(currentPage,pageSize){  
	$('#pageNum').val(currentPage);
	$('#pageSize').val(pageSize);
	$('#form_submit').submit();
}

//重置
$(function(){
   $("#reset").click(function(){
	   window.location.href="/admin/deliveryIncome/list";
   });
  });
  
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

//导出;
$(function() { 
    $("#export").click(function(){
    	window.location.href="/admin/deliveryIncome/export?"+$('#form_submit').serialize();
    })
})

</script>
</body>
</html>