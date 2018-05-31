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
    .layui-form-label{
      width:100px;
    }
    .layui-table .layui-form-checkbox[lay-skin=primary]{margin:0;}
  </style>
</head>
<body>
  <!-- 商品信息列表start -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>买家商品分类统计</h1>
    </section>
    <!-- Main content -->
    <shiro:hasPermission name="reportDayCategory:query">
	    <section class="content">
	      <div class="row">
	        <div class="col-xs-12">
	          <div class="box">
	            <div class="box-header">
	              <h3 class="box-title">买家商品分类统计</h3>
	            </div>
	            <!-- 表单start -->
	           <form id="searchForm" class="form-horizontal" method="post" action="/admin/reportDay/category" >
	              <div class="col-sm-12">
	                 <div class="form-group">
		                 <label for="areaId" class="col-sm-1 control-label">所属区域：</label>
		                 <div class="col-sm-3" style="width: 180px">
		                   <select id="areaId" name="areaId" class="form-control">
							   <option value="" >全部</option>
						   </select>
		                 </div>
	                     <label for="saleId" class="col-sm-1 control-label">销售姓名</label>
		                 <div class="col-xs-3" style="width: 180px">
		                   <select id="saleId" name="saleId" class="form-control" >
		                   <option value="" >全部</option>
						   </select>
		                 </div>
		                 <label class="col-sm-2 control-label">买家名称</label>
		                  <div class="col-xs-3" style="width: 180px">
		                     <input type="text" name="buyerName"  value="${search.buyerName}" class="form-control input-small" placeholder="请输入商家名称">
			              </div>
			              <label class="col-sm-2 control-label">商品分类</label>
		                  <div class="col-xs-3" style="width: 180px">
			                  <input type="text" name="categoryName" value="${search.categoryName}" class="form-control input-small" placeholder="请输入商品分类名称">
			              </div>
		             </div>
	       
			         <div class="form-group">
		                 <label for="createTimeStart" class="col-sm-1 control-label">送达日期:</label>
		                  <div class="col-sm-3" style="width: 200px">
			                <input type="text" name="beginDate" id="createTimeStart" value="${search.beginDate}" class="form-control input-small" placeholder="请选择查询开始时间">
			              </div>
			             <div class="layui-form-mid">--</div>
		                  <div class="col-sm-3" style="width: 200px">
			                <input type="text" name="endDate" id="createTimeStop" value="${search.endDate}"  class="form-control" placeholder="请选择查询结束时间">
			              </div>
			         </div>
			      </div>
	              <div class="box-footer">
	                <button type="reset" id="reset" class="btn btn-info pull-right" style="margin-right:40px;">重置</button>
	                <button type="submit"  class="btn btn-info pull-right" >查询</button>
	                <button type="button" class="btn btn-info pull-right" onclick="exportExcel()">导出</button>
	              </div>
	            </form>
	            <!-- 表单end -->
	        	<c:set var="totalAmt" value="0"></c:set>
	        	<c:set var="amt1" value="0"></c:set>
	        	<c:set var="amt2" value="0"></c:set>
	        	<c:set var="amt3" value="0"></c:set>
	        	<c:set var="amt4" value="0"></c:set>
	        	<c:set var="amt5" value="0"></c:set>
	        	<c:set var="amt6" value="0"></c:set>
	        	<c:set var="amt7" value="0"></c:set>
	        	<c:set var="amt8" value="0"></c:set>
	        	<c:set var="amt9" value="0"></c:set>
	        	<c:forEach items="${ocList}" var="o" > 
		        	 <c:set var="totalAmt" value="${totalAmt+o.totalAmount}"></c:set>
		        	 <c:set var="amt1" value="${amt1+o.itemAmount1}"></c:set>
		        	 <c:set var="amt2" value="${amt2+o.itemAmount2}"></c:set>
		        	 <c:set var="amt3" value="${amt3+o.itemAmount3}"></c:set>
		        	 <c:set var="amt4" value="${amt4+o.itemAmount4}"></c:set>
		        	 <c:set var="amt5" value="${amt5+o.itemAmount5}"></c:set>
		        	 <c:set var="amt6" value="${amt6+o.itemAmount6}"></c:set>
		        	 <c:set var="amt7" value="${amt7+o.itemAmount7}"></c:set>
		        	 <c:set var="amt8" value="${amt8+o.itemAmount8}"></c:set>
		        	 <c:set var="amt9" value="${amt9+o.itemAmount9}"></c:set>
	           	</c:forEach> 
	            <!-- /.box-header -->
	            <div class="layui-form" >
	              <table class="layui-table">
	                <thead>
		              <tr>
		                <th>送达时间</th>
		                <th>买家名称</th>
		                <th>订单总额</th>
		                <th>蔬菜类</th>
		                <th>禽肉快捷菜</th>
		                <th>蛋类</th>
		                <th>米面粮油</th>
		                <th>冰鲜冻品</th>
		                <th>干货调料</th>
		                <th>酒水饮料</th>
		                <th>水产海鲜</th>
		                <th>豆制品</th>
		              </tr>
		              <tr>
		                <th></th>
		                <th>总计</th>
		                <th style="color: red;">${totalAmt}</th>
		                <th style="color: red;">${amt1}</th>
		                <th style="color: red;">${amt2}</th>
		                <th style="color: red;">${amt3}</th>
		                <th style="color: red;">${amt4}</th>
		                <th style="color: red;">${amt5}</th>
		                <th style="color: red;">${amt6}</th>
		                <th style="color: red;">${amt7}</th>
		                <th style="color: red;">${amt8}</th>
		                <th style="color: red;">${amt9}</th>
		              </tr>
	                </thead>
	                <tbody>
		               <c:forEach items="${ocList}" var="r"> 
			   			 <tr>
			   			   <td>${r.sendDate}</td>
			   			   <td>${r.buyerName}</td>
			   			   <td>${r.totalAmount}</td>
					       <td>${r.itemAmount1}</td>
					       <td>${r.itemAmount2}</td>
					       <td>${r.itemAmount3}</td>
					       <td>${r.itemAmount4}</td>
					       <td>${r.itemAmount5}</td>
					       <td>${r.itemAmount6}</td>
					       <td>${r.itemAmount7}</td>
					       <td>${r.itemAmount8}</td>
					       <td>${r.itemAmount9}</td>
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
<script src="/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="/bootstrap/js/bootstrap.min.js"></script>
<script src="/js/jquery-ui.min.js"></script>
<script src="/layui/layui.js"></script>
<script src="/dist/js/app.min.js"></script>
<script charset="utf-8" src="/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
//导出
function exportExcel(){
	window.location.href="/admin/reportDay/category/export?"+$('#searchForm').serialize();
}
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
//获取区域信息;
$(document).ready(function(){ 
	loadregion(); 
	loadsaleId();
}); 
var saleId = '${search.saleId}';
function loadsaleId(){
	if(saleId == null || saleId == '' ||saleId == undefined){
		saleId = 0;
	}
	  var url='/admin/sales/salesList?status=1'; 
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
var areaId = '${search.areaId}';
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