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
      <h1>买家消费信息管理</h1>
    </section>
    <!-- Main content -->
    <shiro:hasPermission name="buyerExpense:query">
	    <section class="content">
	      <div class="row">
	        <div class="col-xs-12">
	          <div class="box">
	            <div class="box-header">
	              <h3 class="box-title">买家消费信息</h3>
	            </div><div class="box box-info">
		           <!-- form start -->
		           <form  id="form_submit" class="form-horizontal" action="<%=request.getContextPath()%>/admin/buyerExpense/list?pageSize=25" method="post">
		             <div class="box-body">
		               <div class="form-group">
		                 <label for="deliveryName" class="col-sm-2 control-label">手机号：</label>
		                 <div class="col-xs-2">
		                   <input type="text" class="form-control" id="buyerPhone" name="buyerPhone" placeholder="请输入手机号" value="${buyerExpenseVo.buyerPhone }">
		                 </div>
		               </div>
			           <div class="form-footer" >
			             <button type="submit" class="btn btn-info pull-left btn-select">查询</button>
			             <button type="reset" class="btn btn-info pull-left">重置</button>
			           </div>
		           </form>
		           <!-- form end -->
		        </div>
	            <!-- /.box-header -->
	            <div class="layui-form" >
	              <table class="layui-table" lay-skin="row">
	                <thead>
		              <tr>
		                <th>餐馆名称</th>
		                <th>买家手机号</th>
		                <th>今日消费</th>
		                <th>昨日消费</th>
		                <th>前天消费</th>
		              </tr>
	                </thead>
	                <tbody>
		               <c:forEach items="${paginator.object}" var="r"> 
			   			 <tr>
					       <td>${r.buyerName}</td>
					       <td>${r.buyerPhone}</td>
					       <td>${r.totayExpense}</td>
					       <td>${r.yesterdayExpense}</td>
					       <td>${r.foreExpense}</td>
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
function onSelectPage(currentPage){  
	window.location.href="/admin/buyerExpense/list?pageNum="+currentPage+"&pageSize=25";
}  
</script>
</body>
</html>