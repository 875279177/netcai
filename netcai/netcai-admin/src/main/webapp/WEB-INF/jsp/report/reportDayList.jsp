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
      <h1>日报表</h1>
    </section>
    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            
              <div class="box box-info">
	           <!-- form start -->
	           <form  id="form_submit" class="form-horizontal" action="<%=request.getContextPath()%>/admin/reportDay/list" method="post">
	             <div class="col-sm-12">
		             <div class="form-group">
		                 <label for="areaId" class="col-sm-1 control-label">区域：</label>
		                 <div class="col-sm-3">
		                   <select id="areaId" name="areaId" class="form-control">
							   <option value="" >全部</option>
						   </select>
		                 </div>
		                 <label for="createTimeStart" class="col-sm-1 control-label">时间查询:</label>
		                  <div class="col-sm-3">
			                <input type="text" name="createTimeStart" id="createTimeStart" value="${reportDayVo.createTimeStart}" class="form-control input-small" placeholder="请选择查询时间">
			              </div>
			             <div class="layui-form-mid">--</div>
		                  <div class="col-sm-3">
			                <input type="text" name="createTimeStop" id="createTimeStop" value="${reportDayVo.createTimeStop}"  class="form-control" placeholder="请输入查询时间">
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
	             	<th>所属区</th>
	                <th>时间</th>
	                <th>订单数</th>
	                <th>订单总金额</th>
	                <th>购买商家总数</th>
	                <th>客单价</th>
	                <th>订单均价</th>
	                <th>空降A</th>
	                <th>新注册买家</th>
	              </tr>
	              
	            <c:set var="sumorderNum" value="0"></c:set>
	        	<c:set var="sumorderAmount" value="0"></c:set>
	        	<c:set var="sumsellerNum" value="0"></c:set>
	        	<c:set var="sumnewBuyerNum" value="0"></c:set>
	        	<c:set var="sumnewBuyer" value="0"></c:set>
	        	<c:forEach items="${map}" var="ma" > 
              	 <c:forEach items="${ma.value}" var="list" varStatus="status"> 
              	 <c:set var="sumorderNum" value="${sumorderNum+list.orderNum}"></c:set>
              	 <c:set var="sumorderAmount" value="${sumorderAmount+list.orderAmount}"></c:set>
              	 <c:set var="sumsellerNum" value="${sumsellerNum+list.sellerNum}"></c:set>
              	 <c:set var="sumnewBuyerNum" value="${sumnewBuyerNum+list.newBuyerNum}"></c:set>
              	 <c:set var="sumnewBuyer" value="${sumnewBuyer+list.newBuyer}"></c:set>
            	</c:forEach> 
            	</c:forEach>
	              <tr>
	                <th></th>
	                <th>总计</th>
	                <th style="color: red;">${sumorderNum }</th>
	                <th style="color: red;">${sumorderAmount }</th>
	                <th style="color: red;"><%-- ${sumsellerNum } --%></th>
	                <th style="color: red;">
	                	<c:if test="${sumsellerNum>0 || sumsellerNum<0}">
	                		${sumorderAmount/sumsellerNum }
	                	</c:if>
	                </th>
	                <th style="color: red;">
	                	<c:if test="${sumorderNum>0 || sumorderNum<0}">
	                		${sumorderAmount/sumorderNum }
	                	</c:if>
	                </th>
	                <th style="color: red;"><%-- ${sumnewBuyerNum } --%></th>
	                <th style="color: red;"> <%-- ${sumnewBuyer } --%> </th>
	              </tr>
                </thead>
                <tbody>
	              <c:forEach items="${map}" var="r"> 
		              	<c:forEach items="${r.value}" var="list"> 
				   			 <tr>
				   			 	   <td>${list.areaName}</td>
							       <td><fmt:formatDate value="${list.today}" pattern="MM月dd日"/></td>
							       <td>${list.orderNum}</td>
							       <td>${list.orderAmount}</td>
							       <td>${list.sellerNum}</td>
							       <td>${list.perAmount}</td>
							       <td>${list.avAmount}</td>
							       <td>${list.newBuyerNum}</td>
							       <td>${list.newBuyer}</td>
				             </tr>
			             </c:forEach>
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
    <input type="hidden" id="areaIdVO" value="${reportDayVo.areaId}"/>
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
	   window.location.href="/admin/reportDay/list";
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