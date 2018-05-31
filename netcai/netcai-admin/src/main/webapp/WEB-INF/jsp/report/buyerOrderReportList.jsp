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
      <h1>买家订单量报表</h1>
    </section>
    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            
            
             <div class="box box-info">
	           <!-- form start -->
	           <form  id="form_submit" class="form-horizontal" action="<%=request.getContextPath()%>/admin/buyerOrderReport/list" method="post">
	             <div class="col-sm-12">
		             <div class="form-group">
		                 <label for="areaId" class="col-sm-1 control-label">区域：</label>
		                 <div class="col-sm-3">
		                   <select id="areaId" name="areaId" class="form-control" >
							   <option value="" >全部</option>
						   </select>
						   <input type="hidden" id="time" name="time" value="${buyerOrderReportVo.time}">
		                 </div>
		             </div>
	             </div>
		             <div class="form-footer" >
		               <button type="submit" class="btn btn-info pull-left btn-select">查询</button>
		               <button type="reset" id="reset"  class="btn btn-info pull-left">重置</button>
		               <button type="reset" id="down"  class="btn btn-info pull-left">前一天</button>
		               <button type="reset" id="up" class="btn btn-info pull-left">后一天</button>
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
                  	<th></th>
	                <th>店铺名称</th>
	                <th colspan="2">今天金额</th>
	                <th>昨天金额</th>
	                <th>前天金额</th>
	                <th>所属区</th>
	              </tr>
	        	<c:set var="sumToday" value="0"></c:set>
	        	<c:set var="sumYesterday" value="0"></c:set>
	        	<c:set var="sumAnteayer" value="0"></c:set>
	        	<c:forEach items="${map}" var="ma" > 
              	 <c:forEach items="${ma.value}" var="list" varStatus="status"> 
              	 <c:set var="sumToday" value="${sumToday+list.today}"></c:set>
              	 <c:set var="sumYesterday" value="${sumYesterday+list.yesterday}"></c:set>
              	 <c:set var="sumAnteayer" value="${sumAnteayer+list.anteayer}"></c:set>
            	</c:forEach> 
            	</c:forEach>
	              <tr>
	              	<th></th>
	                <th>总计</th>
	                <th colspan="2">${sumToday }</th>
	                <th>${sumYesterday }</th>
	                <th>${sumAnteayer }</th>
	                <th></th>
	              </tr>
                </thead>
                <tbody>
	              <c:forEach items="${map}" var="r"> 
		              	<c:forEach items="${r.value}" var="list" varStatus="status"> 
				   			 <tr>
							       <td><c:out value="${status.count}"/> </td>
							       <td><a style="color: blue;" href="/admin/orderItem/getAll?buyerId=${list.buyerId}&orderStatus=1">${list.name}</a></td>
							       <td>
									     <c:choose> 
											 <c:when test="${list.warnT == 0}">   
											   <span style="color: red;">${list.today}</span>
											 </c:when> 
											 <c:otherwise>   
								       			 ${list.today}
											 </c:otherwise> 
										</c:choose> 
							       </td>
							       <td>
							       		<fmt:formatDate value="${list.dateTime}" pattern="yyyy年MM月dd日"/>
							       </td>
							       <td>
							       		<c:choose> 
											 <c:when test="${list.warnY == 0}">   
											   <span style="color: red;">${list.yesterday}</span>
											 </c:when> 
											 <c:otherwise>   
								       			${list.yesterday}
											 </c:otherwise> 
										</c:choose> 
							       </td>
							       <td>
							       		<c:choose> 
											 <c:when test="${list.warnV == 0}">   
											   <span style="color: red;">${list.anteayer}</span>
											 </c:when> 
											 <c:otherwise>   
								       			${list.anteayer}
											 </c:otherwise> 
										</c:choose> 
						       		</td>
							       <td><c:choose> 
											 <c:when test="${list.areaId == 3}">   
											   <span >佛祖岭区</span>
											 </c:when>
											 <c:when test="${list.areaId == 4}">   
											   <span >徐东区</span>
											 </c:when>
											 <c:when test="${list.areaId == 0}">   
											   <span style="color: red;">无区域</span>
											 </c:when> 
											 <c:otherwise>   
											 </c:otherwise> 
										</c:choose> 
									</td>
				             </tr>
			             </c:forEach>
				   </c:forEach>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
  <input type="hidden" id="areaIdVO" value="${buyerOrderReportVo.areaId}"/>
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
<script src="/js/layuiUtil.js" charset="utf-8"></script>
<script type="text/javascript">
//分页
function onSelectPage(currentPage,pageSize){  
	$('#pageNum').val(currentPage);
	$('#pageSize').val(pageSize);
	$('#form_submit').submit();
} 

//重置
$(function(){
   $("#reset").click(function(){
	   window.location.href="/admin/buyerOrderReport/list";
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
<script>
//导出;
$(function() { 
    $("#export").click(function(){
    	window.location.href="/admin/seller/export?"+$('#sellerForm').serialize();
    })
})


//后一天
$(function(){
	var time = $('#time').val();
   $("#down").click(function(){
	   if(time != null || time != '' || time != undefined){
		   time=time - 1;
	   }
	   $('#time').val(time);
	   $('#form_submit').submit();
   });
  });
  
//前一天
$(function(){
	var time = $('#time').val();
   $("#up").click(function(){
	   if(time != null || time != '' || time != undefined){
		   var times = parseInt(time);
		   times += 1;
	   }
	   $('#time').val(times);
	   $('#form_submit').submit();
   });
  });
</script>
</body>
</html>