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
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>销售目标管理</h1>
    </section>
    <!-- Main content -->
    <shiro:hasPermission name="plan:query">
	    <section class="content">
	      <div class="row">
	        <div class="col-xs-12">
	          <div class="box">
	            <div class="box-header">
	              <h3 class="box-title">销售目标</h3>
	            </div>
	            <!-- 表单start -->
	            <form id="searchForm" class="form-horizontal" method="post" action="/admin/plan/list" >
	              <input type="hidden" name="pageNum" id="pageNum" value="${paginator.currentPage}">
	              <input type="hidden" name="pageSize" id="pageSize" value="${paginator.pageRecord}">
	              <input type="hidden" name="spType" id="spType" value="${salesPlan.spType}">
	              <div class="box-body">
	                <div class="form-group" >
	                  <label class="col-sm-2 control-label">销售月份</label>
	                  <div class="col-xs-3">
		                <input type="text" name="spFmon" value="${salesPlan.spFmon}" class="form-control input-small" placeholder="请输入销售月份">
		              </div>
	                  <c:if test="${salesPlan.spType==1}">
	                     <label class="col-sm-2 control-label">销售区域</label>
			             <div class="col-xs-3">
				              <select name="areaId" id="areaId" class="form-control select2" ></select>
				         </div>
	                  </c:if>
	                  <c:if test="${salesPlan.spType==2}">
		                  <label class="col-sm-2 control-label">销售人员</label>
			              <div class="col-xs-3">
				              <select name="saleId" id="saleId" class="form-control select2" ></select>
				          </div>
	                  </c:if>
		              </div>
	                </div>
	              </div>
	              <div class="box-footer">
	                <button type="reset" id="reset" class="btn btn-info pull-right" style="margin-right:40px;">重置</button>
	                <button type="submit"  class="btn btn-info pull-right" >查询</button>
	              </div>
	            </form>
	            <!-- 表单end -->
	            <div class="site-demo-button" > 
					<button data-method="setTop" class="layui-btn layui-btn-small" onclick="add()"><i class="layui-icon"></i><span>&nbsp;&nbsp;新增</span></button>
				</div>
	            <!-- /.box-header -->
	            <div class="layui-form" >
	              <table class="layui-table">
	                <thead>
		              <tr>
		                <th>月份</th>
		                <c:if test="${salesPlan.spType==2}">
		                   <th>销售人员</th>
		                </c:if>
		                <c:if test="${salesPlan.spType==1}">
		                   <th>区域</th>
		                </c:if>
		                <th>销售金额</th>
		                <th>线上金额</th>
		                <th>非标金额</th>
		                <th>注册量</th>
		                <th>创建时间</th>
		                <th>操作</th>
		              </tr>
	                </thead>
	                <tbody>
		               <c:forEach items="${paginator.object}" var="r"> 
			   			 <tr>
			   			   <td>${r.spFmon}</td>
			   			   <c:if test="${salesPlan.spType==2}">
		                      <td>${r.saleName}</td>
		                   </c:if>
		                   <c:if test="${salesPlan.spType==1}">
		                      <td>${r.areaName}</td>
		                   </c:if>
					       <td>${r.goalAmt}</td>
					       <td>${r.onlineAmt}</td>
					       <td>${r.greenAmt}</td>
					       <td>${r.registerNum}</td>
					       <td><fmt:formatDate value="${r.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					       <td>
					         <div class="site-demo-button" > 
								 <button data-method="setTop" class="layui-btn layui-btn-normal layui-btn-small" onclick="update(${r.spId})"><i class="layui-icon"></i><span>&nbsp;&nbsp;修改</span></button>
							 </div>
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
$(document).ready(function(){ 
	<c:if test="${salesPlan.spType==2}">
	   loadsaleId();
	</c:if>
	<c:if test="${salesPlan.spType==1}">
	  loadarea();
	</c:if>
}); 
var saleId = '${salesPlan.saleId}';
function loadsaleId(){
	if(saleId == null || saleId == '' ||saleId == undefined){
		saleId = 0;
	}
	  var url='/admin/sales/salesList?status=1&level=2'; 
	  jQuery.ajax({ 
	    type:'post', 
	    url:url, 
	    async:false,
	    success:function (date){
   	     var r = date.object;  
   	    $("<option value='' selected>请选择</option>").appendTo("#saleId");
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
var areaId = '${salesPlan.areaId}';
function loadarea(){
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
		   $("<option value='' selected>请选择</option>").appendTo("#areaId");
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
//新增
function add(){
	window.location.href="/admin/plan/addOrEdit?"+$('#searchForm').serialize();
}
//修改
function update(spId){
	window.location.href="/admin/plan/addOrEdit?spId="+spId+"&"+$('#searchForm').serialize();
}
</script>
</body>
</html>