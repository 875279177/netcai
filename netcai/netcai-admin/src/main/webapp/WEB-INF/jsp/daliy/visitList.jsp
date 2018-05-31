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
  <!-- 销售拜访列表start -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>销售拜访管理</h1>
    </section>
    <!-- Main content -->
    <shiro:hasPermission name="visit:query">
	    <section class="content">
	      <div class="row">
	        <div class="col-xs-12">
	          <div class="box">
	            <div class="box-header">
	              <h3 class="box-title">销售拜访</h3>
	            </div>
	            <!-- 表单start -->
	            <form id="searchForm" class="form-horizontal" method="post" action="/admin/visit/list" >
	              <input type="hidden" name="pageNum" id="pageNum" value="${paginator.currentPage}">
	              <input type="hidden" name="pageSize" id="pageSize" value="${paginator.pageRecord}">
	              <div class="box-body">
	                <div class="form-group" >
	                  <label class="col-sm-1 control-label">买家店铺</label>
	                  <div class="col-xs-3" style="width: 200px">
		                  <input type="text" name="buyerName" value="${buyerName}" class="form-control input-small" placeholder="请输入买家店铺">
		              </div>
	                  <label class="col-sm-1 control-label">销售姓名</label>
	                  <div class="col-xs-3" style="width: 200px">
	                    <select id="saleId" name="saleId" class="form-control" >
		                   <option value="" >全部</option>
						</select>
		              </div>
		              <label for="createTimeStart" class="col-sm-1 control-label">工作日期:</label>
	                  <div class="col-sm-3" style="width: 200px">
		                <input type="text" name="beginDate" id="createTimeStart" value="${beginDate}" class="form-control input-small" placeholder="请选择查询开始时间">
		              </div>
		              <div class="layui-form-mid">--</div>
	                  <div class="col-sm-3" style="width: 200px">
		                <input type="text" name="endDate" id="createTimeStop" value="${endDate}"  class="form-control" placeholder="请选择查询结束时间">
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
	            <!-- /.box-header -->
	            <div class="layui-form" >
	              <table class="layui-table">
	                <thead>
		              <tr>
		                <th>拜访方式</th>
		                <th>拜访类型</th>
		                <th>销售姓名</th>
		                <th>买家店铺</th>
		                <th>买家姓名</th>
		                <th>买家电话</th>
		                <th>拜访地址</th>
		                <th>拜访感想</th>
		                <th>拜访状态</th>
		                <th>拜访时间</th>
		              </tr>
	                </thead>
	                <tbody>
		               <c:forEach items="${paginator.object}" var="r"> 
			   			 <tr>
			   			   <td>
			   			      <c:if test="${r.svWay==1}">预约</c:if>
							  <c:if test="${r.svWay==2}">其他</c:if>
			   			   </td>
			   			   <td>
			   			      <c:if test="${r.svType==1}">上门</c:if>
							  <c:if test="${r.svType==2}">电话</c:if>
			   			   </td>
			   			   <td>${r.saleName}</td>
			   			   <td>${r.buyerName}</td>
			   			   <td>${r.bossName}</td>
					       <td>${r.bossTel}</td>
					       <td>${r.svAddress}</td>
					       <td>${r.svRemark}</td>
					       <td>
			   			      <c:if test="${r.svStatus==0}">未完成</c:if>
							  <c:if test="${r.svStatus==1}">已完成</c:if>
			   			   </td>
					       <td><fmt:formatDate value="${r.svTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
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
<script src="/js/jquery-ui.min.js"></script>
<script src="/layui/layui.js"></script>
<script src="/dist/js/app.min.js"></script>
<script charset="utf-8" src="/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
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
//分页
function onSelectPage(currentPage,pageSize){  
	$('#pageNum').val(currentPage);
	$('#pageSize').val(pageSize);
	$('#searchForm').submit();
}

//重置
$(function(){
 $("#reset").click(function(){
	   window.location.href="/admin/visit/list";
 });
 loadsaleId();
});
var saleId = '${saleId}';
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

//导出
function exportExcel(){
	window.location.href="/admin/visit/export?"+$('#searchForm').serialize();
}
</script>
</body>
</html>