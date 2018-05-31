<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="pv" uri="/pageTaglib"%>
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
      <h1>买家订单报表</h1>
    </section>
    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-sm-12">
          <div class="box">
            
              <div class="box box-info">
	           <!-- form start -->
	           <form  id="form_submit" class="form-horizontal" action="<%=request.getContextPath()%>/admin/buyerOrderReport/reportBuyer" method="post">
	             <div class="col-sm-12">
		             <div class="form-group">
		                 <label for="areaId" class="col-sm-1 control-label">区域：</label>
		                 <div class="col-sm-3">
		                   <select id="areaId" name="regionId" class="form-control" >
						   </select>
		                 </div>
		                 <label for="createTimeStart" class="col-sm-1 control-label">开始时间:</label>
		                  <div class="col-sm-3">
			                <input type="text" name="createTimeStart" id="createTimeStart" value="${reportBuyerVo.createTimeStart}" class="form-control input-small" placeholder="请选择开始时间">
			              </div>
			             <label for="createTimeStop" class="col-sm-1 control-label">结束时间:</label>
		                  <div class="col-sm-3">
			                <input type="text" name="createTimeStop" id="createTimeStop" value="${reportBuyerVo.createTimeStop}"  class="form-control" placeholder="请输入结束时间">
			              </div>
			         </div>
	             </div>
	             <div class="col-sm-12">
			         <div class="form-group">
		                 <label for="more" class="col-sm-1 control-label">大于频次：</label>
		                 <div class="col-sm-3">
		                   <input type="number" name="more" id="more" value="${reportBuyerVo.more}" class="form-control input-small" placeholder="请输入频次">
		                 </div>
		                 <label for="less" class="col-sm-1 control-label">下于频次：</label>
		                 <div class="col-sm-3">
		                   <input type="number" name="less" id="less" value="${reportBuyerVo.less}" class="form-control input-small" placeholder="请输入频次">
		                 </div>
		                 <label for="buyerName" class="col-sm-1 control-label">买家信息：</label>
		                 <div class="col-sm-3">
		                   <input type="text" name="buyerName"  value="${reportBuyerVo.buyerName}" class="form-control input-small" placeholder="请输入买家信息">
		                 </div>
			         </div>
		         </div>
		             <div class="form-footer" >
		               <button type="submit" class="btn btn-info pull-left btn-select">查询</button>
		               <button type="reset" id="reset"  class="btn btn-info pull-left">重置</button>
		             </div>
	           </form>
	           <!-- form end -->
	        </div>
            <!-- 表单end -->
            <!-- /.box-header -->
            <div class="layui-form" >
              <table class="layui-table table-striped">
                <thead>
	             <tr>
	                <th>数量</th>
	                <th>买家店铺名称</th>
	                <th>餐馆地址</th>
	                <th>老板名称</th>
	                <th>老板电话号码</th>
	                <th>配送区域名称</th>
	                <th>区名称</th>
	                <th>订单频次</th>
	                <th>总价</th>
	                <th>均价</th>
	              </tr>
	              
	            <c:set var="totalMoney" value="0"></c:set>
	        	<c:set var="frequency" value="0"></c:set>
              	 <c:forEach items="${reportBuyers}" var="list" varStatus="status"> 
              	 <c:set var="totalMoney" value="${totalMoney+list.totalMoney}"></c:set>
              	 <c:set var="frequency" value="${frequency+list.frequency}"></c:set>
            	</c:forEach> 
	              <tr>
	                <th>总计</th>
	                <th style="color: red;"></th>
	                <th style="color: red;"></th>
	                <th style="color: red;"></th>
	                <th style="color: red;"></th>
	                <th style="color: red;"></th>
	                <th style="color: red;"></th>
	                <th style="color: red;">${frequency}</th>
	                <th style="color: red;">${totalMoney}</th>
	                <th style="color: red;">
	                	<c:if test="${frequency>0 || frequency<0}">
	                		${totalMoney/frequency }
	                	</c:if>
	                </th>
	              </tr>
                </thead>
                <tbody>
		              	<c:forEach items="${reportBuyers}" var="list" varStatus="status"> 
				   			 <tr>
							       <td>${status.count}</td>
							       <td>${list.buyerName}</td>
							       <td>${list.buyerAddress}</td>
							       <td>${list.bossName}</td>
							       <td>${list.bossTel}</td>
							       <td>${list.deliveryAreaName}</td>
							       <td>${list.regionName}</td>
							       <td>${list.frequency}</td>
							       <td>${list.totalMoney}</td>
							       <td>${list.avgMoney}</td>
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
    <input type="hidden" id="areaIdVO" value="${reportBuyerVo.regionId}"/>
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
<script type="text/javascript">
//分页
function onSelectPage(currentPage,pageSize){  
	$('#pageNum').val(currentPage);
	$('#pageSize').val(pageSize);
	$('#form_submit').submit();
} 
</script>
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
	   window.location.href="/admin/buyerOrderReport/reportBuyer";
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
   	   var areaList = date.object;  
         if(areaList != null && areaList.length > 0){
        	 if(areaId == 0){
        	 $("<option value='' selected>"+"全部"+"</option>").appendTo("#areaId");
        	 }else{
        		 $("<option value=''>"+"全部"+"</option>").appendTo("#areaId");
        	 }
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