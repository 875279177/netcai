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
    button{
      margin-right:5px;
    }
  </style>
</head>
<body>
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>商品价格调整</h1>
    </section>
    <!-- Main content -->
    <shiro:hasPermission name="priceRevise:query">
	    <section class="content">
	      <div class="row">
	        <div class="col-xs-12">
	          <div class="box ">
	            <div class="box-header">
	              <h3 class="box-title">价格调整列表信息</h3>
	            </div>
	            <div class="box box-body">
	              <form id="priceForm" action="/admin/priceRevise/list" class="form-horizontal" method="post" >
	                 <input type="hidden" name="pageNum" id="pageNum" value="${paginator.currentPage}">
	              <input type="hidden" name="pageSize" id="pageSize" value="${paginator.pageRecord}">
		             <div class="box-body">
		               <div class="col-sm-12" >
			               <div class="form-group" >
			                 <label for="goodsName" class="col-sm-1 control-label">商品名称：</label>
			                 <div class="col-sm-2">
				               <input type="text" class="form-control input-small" id="goodsName" name="goodsName" value="${priceRevise.goodsName}" placeholder="请输入商品名称">
				             </div>
			                 <label for="formatName" class="col-sm-1 control-label">规格名称：</label>
			                 <div class="col-sm-2">
				               <input type="text" class="form-control input-small" id="formatName" name="formatName" value="${priceRevise.formatName}" placeholder="请输入规格名称">
				             </div>
				             <label for="startTime" class="col-sm-1 control-label">开始时间：</label>
				             <div class="col-sm-2">
				               <input type="date" class="form-control" id="startTime" name="startTimeStr">
				             </div>
				             <label for="endTime" class="col-sm-1 control-label">结束时间：</label>
				             <div class="col-sm-2">
				               <input type="date" class="form-control" id="endTime" name="endTimeStr">
				             </div>
			               </div>
		               </div>
		               
		               <div class="col-sm-12" >
			               <div class="form-group" >
			                 <label for="sellerName" class="col-sm-1 control-label">店铺名称：</label>
			                 <div class="col-sm-2">
				               <input type="text" class="form-control input-small" id="sellerName" name="sellerName" value="${priceRevise.sellerName}" placeholder="请输入店铺名称">
				             </div>
			               </div>
		               </div>
		               <div class="box-footer">
		                 <button type="submit" class="btn btn-info ">查询</button>
		                 <button type="reset" id="reset" class="btn btn-info ">重置</button>
		               </div>
		             </div>
		          </form> 
	            </div>
	            <div class="box">
		           <div class="box-body">
		             <table id="example1" class="table table-bordered table-striped">
		               <thead >
			             <tr >
			               <th>店铺名称</th>
			               <th>商品名称</th>
			               <th>规格名称</th>
			               <th>原价</th>
			               <th>单位</th>
			               <th>现价</th>
			               <th>来源</th>
			               <th>修改人</th>	             
			               <th>修改时间</th>
			             </tr>
		               </thead>
		               <tbody>
			             <c:forEach items="${paginator.object}" var="r"> 
				   		   <tr>
						     <td>${r.sellerName}</td>
						     <td>${r.goodsName}</td>
						     <td>${r.formatName}</td>
						     <td>${r.oldPrice}</td>
						     <td>${r.unitName}</td>
						     <td>${r.revisePrice}</td>
						     <td>
						       <c:if test="${r.reviseFrom==1}">平台</c:if>
							   <c:if test="${r.reviseFrom==2}">商家</c:if>
							 </td> 
						     <td>${r.trueName}</td>
			   			 	 <td><fmt:formatDate value="${r.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				           </tr>
						 </c:forEach>
		                </tbody>
		             </table>
		           </div>
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
<script src="/plugins/datepicker/bootstrap-datepicker.js"></script>
<script src="/plugins/fastclick/fastclick.js"></script>
<script charset="utf-8" src="/My97DatePicker/WdatePicker.js"></script>
<script src="/dist/js/app.min.js"></script>
<script src="/dist/js/demo.js"></script>
<script src="/js/jquery-ui.min.js"></script>
<script src="/layer/layer.js"></script>
<script type="text/javascript">
function onSelectPage(currentPage,pageSize)
{  
	$('#pageNum').val(currentPage);
	$('#pageSize').val(pageSize);
	$('#priceForm').submit();
}

//初始化时间选择器
$("#startTime").bind("click focus", function () {
    var endtimeTf = $dp.$('endTime');
    WdatePicker({
        maxDate: '#F{$dp.$D(\'startTime\')}',
        dateFmt: "yyyy-MM-dd ",
        onpicked: function () { endtimeTf.focus(); }
    });
});
$("#endTime").bind("click focus", function () {
    WdatePicker({
        minDate: '#F{$dp.$D(\'startTime\')}',
        dateFmt: "yyyy-MM-dd "
    });
});

//重置
$(function(){
   $("#reset").click(function(){
	   window.location.href="/admin/priceRevise/list";
   });
  });
</script>
</body>
</html>