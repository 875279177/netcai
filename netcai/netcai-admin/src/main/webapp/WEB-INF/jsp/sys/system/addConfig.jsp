<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 	<link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="/libs/font-awesome.min.css">
  <link rel="stylesheet" href="/libs/ionicons.min.css">
  <link rel="stylesheet" href="/dist/css/AdminLTE.min.css">
  <link rel="stylesheet" href="/dist/css/skins/_all-skins.min.css">
  <link rel="stylesheet" href="/plugins/iCheck/flat/blue.css">
  <link rel="stylesheet" href="/plugins/morris/morris.css">
  <link rel="stylesheet" href="/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
  <link rel="stylesheet" href="/plugins/datepicker/datepicker3.css">
  <link rel="stylesheet" href="/plugins/daterangepicker/daterangepicker.css">
  <link rel="stylesheet" href="/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
  <link rel="stylesheet" href="/plugins/datatables/dataTables.bootstrap.css">
  <link rel="stylesheet" href="/layui/css/layui.css"  media="all">
<title>新增配送人员信息</title>
</head>
<body>
<div class="row">
  <div class="col-sm-1"></div>
  <div class="col-sm-10">
	  <form class="form-horizontal" action="/admin/sysSystemConfig/add" role="form"  method="post">
           <fieldset>
              <div class="form-group">
                 <label class="col-sm-2 control-label" for="ds_host">参数编码</label>
                 <div class="col-sm-10">
                    <input class="form-control" id="param_code" type="text" placeholder="参数编码" value="${sysSystemConfig.paramCode}" name="paramCode"/>
                 </div>
              </div>
              
              <div class="form-group">
                 <label class="col-sm-2 control-label" for="param_name">参数名称</label>
                 <div class="col-sm-4">
                    <input class="form-control" id="param_name" type="text" placeholder="参数名称" value="${sysSystemConfig.paramName}" name="paramName"/>
                 </div>
                 <label class="col-sm-2 control-label" for="param_value">参数值</label>
                 <div class="col-sm-4">
                    <input class="form-control" id="param_value" type="text" placeholder="参数值" value="${sysSystemConfig.paramValue}" name="paramValue"/>
                 </div>
              </div>
              
              <c:if test="${sysSystemConfig != null}">
              <div class="form-group">
              <label class="col-sm-2 control-label" for="param_desc">参数描述</label>
                 <div class="col-sm-10">
                   <textarea class="form-control" rows="3"  name="paramDesc">${sysSystemConfig.paramDesc}</textarea>
                 </div>
             </div>
             </c:if>
             
             <c:if test="${sysSystemConfig == null}">
             <div class="form-group">
              <label class="col-sm-2 control-label" for="param_desc">参数描述</label>
                 <div class="col-sm-10">
                   <textarea class="form-control" rows="3" name="paramDesc"></textarea>
                 </div>
             </div>
             </c:if>
           </fieldset>     
       </form>
  </div>
  <div class="col-sm-2"></div>
</div>


<script>
	function confirm(){
		alert(1);
	}
	
	function cancel(){
		 window.history.back(-1);
	}
</script>
</body>
</html>