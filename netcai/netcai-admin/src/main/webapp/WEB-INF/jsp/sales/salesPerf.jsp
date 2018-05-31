<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="pv" uri="/pageTaglib"%> 
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%> 
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
<body class="hold-transition skin-blue sidebar-mini">
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>销售人员业绩列表</h1>
    </section>
    <!-- Main content -->
    <shiro:hasPermission name="salesPerfTotal:query">
	    <section class="content">
	      <div class="row">
	        <div class="col-xs-12">
	          <div class="box">
	            <div class="box-header">
	              <h3 class="box-title">销售人员业绩统计</h3>
	            </div>
	            <div class="box box-info">
		           <!-- form start -->
		           <form  id="form_submit" class="form-horizontal" action="<%=request.getContextPath()%>/admin/sales/perf" method="post">
			         <div class="box-body">
					   <div class="form-group">
						  <label for="saleId" class="col-sm-1 control-label">姓名：</label>
			              <div class="col-sm-2">
			                <select id="saleId" name="saleId" class="form-control" style="width:150px;">
							  <option value="" >全部</option>
							</select>
			              </div>
						  <label for="createTimeStart" class="col-sm-1 control-label">开始时间:</label>
		                  <div class="col-sm-2">
			                <input type="text" name="createTimeStart" id="createTimeStart" value="${buyer.createTimeStart}" class="form-control" placeholder="请选择开始时间">
			              </div>
			              <label for="createTimeStop" class="col-sm-1 control-label">结束时间:</label>
		                  <div class="col-sm-2">
			                <input type="text" name="createTimeStop" id="createTimeStop" value="${buyer.createTimeStop}"  class="form-control" placeholder="请输入结束时间">
			              </div>
					   </div>
					   <div class="form-footer">
						 <button type="submit" class="btn btn-info pull-left btn-select">查询</button>
						 <button type="reset" id="reset" class="btn btn-info pull-left" >重置</button>
					   </div>
					</div> 
		           </form>
		           <!-- form end -->
		        </div>
	            
	            <div >
		        	<c:forEach items="${buyerList}" > 
	            	</c:forEach>
	              	 <span style="color: red;">&nbsp; &nbsp;共计&nbsp; &nbsp; : &nbsp;&nbsp;${fn:length(buyerList) }</span> 
	            </div>
	            
	            <table class="layui-table" lay-skin="row">
	              <thead>
		            <tr>
	            	  <th></th>
		              <th>所在区域</th>
		              <th>销售人员</th>
		              <th>餐馆名称</th>
		              <th>餐馆地址</th>
		              <th>餐馆老板</th>
		              <th>手号码</th>
		              <th>账户余额</th>
		              <th>状态</th>
		              <th>入驻时间</th>
		            </tr>
		          </thead>
		          <tbody>
	                <c:forEach items="${buyerList}" var="r" varStatus="status"> 
		   			  <tr>
		   			  	<td><c:out value="${status.count}"/> </td>
		   			    <td>${r.regionName}</td>
		   			  	<td>
		   			  		<c:choose>
		   			  			<c:when test="${r.salesName != null}">${r.salesName}</c:when>
		   			  			<c:otherwise><span style="color: red;">未绑定</span></c:otherwise>
		   			  		</c:choose>
		   			  	</td>
		   			    <td>${r.buyerName}</td>
				        <td>${r.buyerAddress}</td>
				        <td>${r.bossName}</td>
				        <td>${r.bossTel}</td>
				        <td>${r.balanceMoney}</td>
				        <td>
				          <c:if test="${r.status ==3}">审核通过</c:if>
				        </td>
			            <td><fmt:formatDate value="${r.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		              </tr>
				    </c:forEach>
	             </tbody>
	            </table>
	          </div>
	        </div>
	      </div>
	    </section>
    </shiro:hasPermission>
  </div>
  <input type="hidden" id="saleIdVO" value="${buyer.saleId}"/>
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
<script charset="utf-8" src="/My97DatePicker/WdatePicker.js"></script>
<script src="/js/layuiUtil.js" charset="utf-8"></script>
<script>
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
//重置
$(function(){
   $("#reset").click(function(){
	   window.location.href="/admin/sales/perf";
   });
  });
//获取销售人员列表;
$(document).ready(function(){
	loadregion(); 
	}); 
	
var saleId = $('#saleIdVO').val();
function loadregion(){
	if(saleId == null || saleId == '' ||saleId == undefined){
		saleId = 0;
	}
	  var url='/admin/sales/salesList'; 
	  jQuery.ajax({ 
	    type:'post', 
	    url:url, 
	    async:false,
	    success:function (date){
   	   var r = date.object;  
         if(r != null && r.length > 0){
             for(var i = 0; i< r.length; i++){
                 if(r[i].id == saleId){
              	   $("<option value='"+r[i].id+"' selected>"+r[i].realName+"</option>").appendTo("#saleId");
                 }else {
                 $("<option value='"+r[i].id+"'>"+r[i].realName+"</option>").appendTo("#saleId");  
				}
             }  
         } 
	    } 
	  }); 
	}
</script>
</body>
</html>