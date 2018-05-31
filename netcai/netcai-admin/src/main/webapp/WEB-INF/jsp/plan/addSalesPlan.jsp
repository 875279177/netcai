<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName();
	String port = String.valueOf(request.getServerPort());
	if(port.equals("80")) {
		basePath += path+"/";
	} else {
		basePath += ":" + port+path+"/";
	}
%>
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
      <h1>添加销售目标</h1>
    </section>
    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">销售目标</h3>
            </div>
            <!-- 表单start -->
            <form id="subForm" class="form-horizontal" method="post" action="/admin/plan/saveOrUpdate" >
              <input id="spId" name="spId" value="${spId}"  type="hidden"/> 
              <input name="spType" value="${spType}"  type="hidden"/> 
              <div class="box-body">
                <div class="form-group" >
                  <label for="inputEmail3" class="col-sm-2 control-label">销售月份:</label>
	              <div class="col-xs-3">
		             <input type="text" name="spFmon" value="${salesPlan.spFmon}" class="form-control input-small" placeholder="请输入销售月份">
		          </div>
	              <c:if test="${spType==1}">
                       <label for="inputPassword3" class="col-sm-2 control-label">销售区域:</label>
		               <div class="col-xs-3">
			              <select name="areaId" id="areaId" class="form-control select2" ></select>
			           </div>
	              </c:if>
	              <c:if test="${spType==2}">
	                   <label for="inputPassword3" class="col-sm-2 control-label">销售人员:</label>
		               <div class="col-xs-3">
			              <select name="saleId" id="saleId" class="form-control select2" ></select>
			           </div>
	              </c:if>
                </div>
                <div class="form-group" >
                  <label for="inputEmail3" class="col-sm-2 control-label">销售金额:</label>
                  <div class="col-xs-3">
	                <input type="text" name="goalAmt" value="${salesPlan.goalAmt}"  class="form-control input-small" placeholder="请输入销售金额">
	              </div>
	              <label for="inputPassword3" class="col-sm-2 control-label">线上金额:</label>
                  <div class="col-xs-3">
	                <input type="text" name="onlineAmt" value="${salesPlan.onlineAmt}"  class="form-control" placeholder="请输入线上金额">
	              </div>
                </div>
                <div class="form-group" >
                  <label for="inputEmail3" class="col-sm-2 control-label">非标金额:</label>
                  <div class="col-xs-3">
	                <input type="text" name="greenAmt" value="${salesPlan.greenAmt}"  class="form-control input-small" placeholder="请输入非标金额">
	              </div>
	              <label for="inputPassword3" class="col-sm-2 control-label">注册买家:</label>
                  <div class="col-xs-3">
	                  <input type="text" name="registerNum" value="${salesPlan.registerNum}"  class="form-control input-small" placeholder="请输入注册买家">
	              </div>
                </div>

              </div>

              <div class="box-footer">
                <button type="reset" class="btn btn-info pull-right" style="margin-right:40px;">重置</button>
                <button type="button" class="btn btn-info pull-right" onclick="saveOrUp()">提交</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </section>
  </div>

<script src="/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="/bootstrap/js/bootstrap.min.js"></script>
<script src="/js/raphael-min.js"></script>
<script src="/dist/js/app.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){ 
	<c:if test="${spType==2}">
	   loadsaleId();
	</c:if>
	<c:if test="${spType==1}">
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
//保存、修改数据
function saveOrUp(){
  $('#subForm').submit();
}
</script>
</body>
</html>