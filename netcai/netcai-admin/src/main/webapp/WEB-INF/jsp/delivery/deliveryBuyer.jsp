<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="pv" uri="/pageTaglib"%>  
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
      <h1>配送买家</h1>
    </section>
    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">配送买家信息</h3>
            </div><div class="box box-info">
	           <!-- form start -->
	           <!-- form end -->
	        </div>
            <!-- /.box-header -->
            <div style="margin-top: 70px">
              <table class="layui-table" lay-skin="row" >
                <thead>
	              <tr>
	              	<th></th>
	                <th>店铺名称</th>
	                <th>配送区域</th>
	                <th>店铺地址</th>
	                <th>老板名称</th>
	                <th>配送人员姓名</th>
	                <th>送达金额</th>
	              </tr>
                </thead>
                <tbody>
	               <c:forEach items="${buyers}" var="r" varStatus="status"> 
		   			 <tr>
		   			 	<td><c:out value="${status.count}"/> </td>
				       <td><a style="color: blue;" href="/admin/orderItem/getAll?buyerId=${r.buyerId}&deliveryId=${r.deliveryId}&bestTime=${time}&pageSize=30">${r.buyerName}</a></td>
				       <td>${r.deliveryAreaName}</td>
				       <td>${r.buyerAddress}</td>
				       <td>${r.bossName}</td>
				       <td>${r.deliveryName}</td>
				       <td>${r.orderCount}</td>
		             </tr>
				   </c:forEach>
                </tbody>
              </table>
            </div>
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
<script charset="utf-8" src="/My97DatePicker/WdatePicker.js"></script>
</body>
</html>