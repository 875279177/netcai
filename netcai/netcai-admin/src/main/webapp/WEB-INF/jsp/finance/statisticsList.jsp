<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="pv" uri="/pageTaglib"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
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
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>总财务统计</h1>
    </section>
    <!-- Main content -->
    <shiro:hasPermission name="statistics:query">
	    <section class="content">
	      <div class="row">
	        <div class="col-xs-12">
	          <div class="box">
	              <div class="box box-info">
		           <!-- form start -->
		           <form  id="form_submit" class="form-horizontal" action="<%=request.getContextPath()%>/admin/statistics/list" method="post">
		             <div class="col-sm-12">
			             <div class="form-group">
			                 <label for="areaId" class="col-sm-1 control-label">区域：</label>
			                 <div class="col-sm-3" style="width: 200px">
			                   <select id="areaId" name="areaId" class="form-control">
								   <option value="" >全部</option>
							   </select>
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
	             <div class="row">
				    <div class="col-sm-12">
					    <div class="pull-left">
						    <button type="button" class="btn btn-primary" id="export" data-complete-text="Loading finished" >导出</button>
					    </div>
				    </div>
				</div>
	            <div class="layui-form" >
	              <table class="layui-table table-striped">
	                <thead>
		             <tr>
		                <th>时间</th>
		             	<th>所属区</th>
		                <th>注册用户</th>
		                <th>月活跃用户</th>
		                <th>下订单频率</th>
		              </tr>
	                </thead>
	                <tbody>
		              	<c:forEach items="${lists}" var="list"> 
				   			 <tr>
				   			 	   <td>${list.time}</td>
							       <td>${list.names}</td>
							       <td>${list.newUser}</td>
							       <td>${list.activeUser}</td>
							       <td>
							       		<c:choose>
								       		<c:when test="${list.activeUser != 0}">
								       			<fmt:formatNumber type="number" value=" ${list.hz/list.activeUser}" pattern="0.00" maxFractionDigits="2"/> 
								       		</c:when>
								       		<c:otherwise>0</c:otherwise>
							       		</c:choose>
							       </td>
				             </tr>
			             </c:forEach>
	                </tbody>
	              </table>
	            </div>
	          </div>
	        </div>
	      </div>
	    </section>
    </shiro:hasPermission>
  </div>
    <input type="hidden" id="areaIdVO" value="${statistics.areaId}"/>
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
//导出;
$(function() { 
    $("#export").click(function(){
    	window.location.href="/admin/statistics/export?"+$('#form_submit').serialize();
    })
})
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
	   window.location.href="/admin/statistics/list";
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