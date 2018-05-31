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
  <!-- 销售日报列表start -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>销售周报管理</h1>
    </section>
    <!-- Main content -->
    <shiro:hasPermission name="weekly:query">
	    <section class="content">
	      <div class="row">
	        <div class="col-xs-12">
	          <div class="box">
	            <div class="box-header">
	              <h3 class="box-title">销售周报</h3>
	            </div>
	            <!-- 表单start -->
	            <form id="searchForm" class="form-horizontal" method="post" action="/admin/weekly/list" >
	              <input type="hidden" name="pageNum" id="pageNum" value="${paginator.currentPage}">
	              <input type="hidden" name="pageSize" id="pageSize" value="${paginator.pageRecord}">
	              <div class="box-body">
	                <div class="form-group" >
	                  <label class="col-sm-1 control-label">销售姓名</label>
	                  <div class="col-sm-3" style="width: 200px">
	                    <select id="saleId" name="saleId" class="form-control" >
		                   <option value="" >全部</option>
						</select>
		              </div>
		              <label class="col-sm-1 control-label">阅读状态</label>
	                  <div class="col-sm-3" style="width: 200px">
	                    <select id="lookStatus" name="lookStatus" class="form-control" >
		                   <option value="" >全部</option>
		                   <option value="0" <c:if test="${lookStatus==0}">selected</c:if>>未读</option>
		                   <option value="1" <c:if test="${lookStatus==1}">selected</c:if>>已读</option>
						</select>
		              </div>
	                </div>
	              </div>
	              <div class="box-footer">
	                <button type="reset" id="reset" class="btn btn-info pull-right" style="margin-right:40px;">重置</button>
	                <button type="submit"  class="btn btn-info pull-right" >查询</button>
	              </div>
	            </form>
	            <!-- 表单end -->
	            <!-- /.box-header -->
	            <div class="layui-form" >
	              <table class="layui-table">
	                <thead>
		              <tr>
		                <th>姓名</th>
		                <th>月份</th>
		                <th>范围</th>
		                <th>总结</th>
		                <th>计划</th>
		                <th>需求帮助</th>
		                <th>提交时间</th>
		                <th>查阅状态</th>
		                <th>查阅人</th>
		                <th>查阅时间</th>
		                <th>主管回复</th>
		              </tr>
	                </thead>
	                <tbody>
		               <c:forEach items="${paginator.object}" var="r"> 
			   			 <tr>
			   			   <td>${r.saleName}</td>
			   			   <td>${r.swFmon}</td>
					       <td>${r.swRange}</td>
	                       <td>${r.swSummary}</td>
					       <td>${r.swPlan}</td>
					       <td>${r.needHelp}</td>
					       <td><fmt:formatDate value="${r.swTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					       <td>
					       	  <c:if test="${r.lookStatus==0}">未读</c:if>
							  <c:if test="${r.lookStatus==1}">已读</c:if>
					       </td>
					       <td>${r.lookName}</td>
					       <td><fmt:formatDate value="${r.lookTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					       <td>${r.lookReply}</td>
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
<script type="text/javascript">
//分页
function onSelectPage(currentPage,pageSize){  
	$('#pageNum').val(currentPage);
	$('#pageSize').val(pageSize);
	$('#searchForm').submit();
}

//重置
$(function(){
 $("#reset").click(function(){
	   window.location.href="/admin/weekly/list";
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

</script>
</body>
</html>