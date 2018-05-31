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
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">账单列表</h3>
            </div>
            <!-- /.box-header -->
            <div class="layui-form" >
              <input id="seller_id" type="hidden" value="${sellerId }">
              <input id="time" type="hidden" value="${time }">
              <table class="layui-table" lay-skin="row">
                <thead>
	              <tr>
	                <th>收益时间</th>
					<th>收益金额</th>
					<th>账单状态</th>
					<th>操作</th>
	              </tr>
                </thead>
                <tbody>
	               <c:forEach items="${paginator.object }" var="r"> 
		   			 <tr>
				        <td><fmt:formatDate value="${r.createTime }" pattern="yyyy-MM-dd"/></td>
		   			    <td>${r.realIncome}</td>
				        <td>
				          <span style="color:#F00"><c:if test="${r.status==0}">未出账</c:if></span>
				          <span><c:if test="${r.status==1}">已出账</c:if></span>
				        </td>
				        <td>
				           <a href="<%=request.getContextPath()%>/admin/seller/getAllTransactionDetails?sellerId=${r.sellerId}&createTime=${r.createTime }" target="_blank"><b><u> 查看详情</u></b></a>
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
function onSelectPage(currentPage,pageSize)
{  
	var sellerId = $("#seller_id").val();
	var time = $("#time").val();
	window.location.href="<%=request.getContextPath()%>/admin/seller/getBillsBySellerId?pageNum="+currentPage+"&pageSize="+pageSize+"&sellerId="+sellerId+"&time="+time;
}   
</script>
</body>
</html>