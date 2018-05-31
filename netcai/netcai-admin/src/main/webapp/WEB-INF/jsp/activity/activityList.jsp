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
  </style>
</head>
<body >
  <!-- 活动信息列表start -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>活动信息管理</h1>
    </section>
    <!-- Main content -->
    <shiro:hasPermission name="activity:query">
	    <section class="content">
	      <div class="row">
	        <div class="col-xs-12">
	          <div class="box">
	            <div class="box-header">
	              <h3 class="box-title">活动信息</h3>
	            </div>
	            <!-- 表单start -->
	            <form id="subForm" method="post" class="form-horizontal" action="" >
	              <input type="hidden" name="pageNum" id="pageNum" value="${paginator.currentPage}">
	              <input type="hidden" name="pageSize" id="pageSize" value="${paginator.pageRecord}">
	              <div class="box-body">
	                <div class="form-group" >
	                  <label for="inputEmail3" class="col-sm-2 control-label">主题</label>
	                  <div class="col-xs-3">
		                <input type="text" name="activityTitle" value="${activity.activityTitle}" class="form-control input-small" placeholder="请输入活动主题">
		              </div>
		              <label for="inputPassword3" class="col-sm-2 control-label">状态</label>
	                  <div class="col-xs-3">
		                  <select name="activityStatus" id="activityStatus" class="form-control select2" style="width: 100%;">
			                  <option value="1" <c:if test="${activity.activityStatus==1}">selected</c:if>>在用</option>
			                  <option value="-1" <c:if test="${activity.activityStatus==-1}">selected</c:if>>停用</option>
			              </select>
		              </div>
	                </div>
	              </div>
	              <div class="box-footer">
	                <button type="reset" id="reset" class="btn btn-info pull-right" style="margin-right:40px;">重置</button>
	                <button type="submit" class="btn btn-info pull-right" >查询</button>
	              </div>
	            </form>
	            <!-- 表单end -->
	            <div class="site-demo-button" >
				   <button data-method="setTop" class="layui-btn layui-btn-small" onclick="add(1)"><i class="layui-icon"></i><span>&nbsp;&nbsp;满减活动</span></button>
				   <button data-method="setTop" class="layui-btn layui-btn-small" onclick="add(2)"><i class="layui-icon"></i><span>&nbsp;&nbsp;满赠活动</span></button>
				   <button data-method="setTop" class="layui-btn layui-btn-small" onclick="add(3)"><i class="layui-icon"></i><span>&nbsp;&nbsp;特价商品</span></button>
				</div>
	            <!-- /.box-header -->
	            <div class="layui-form" >
	              <table class="layui-table">
	                <thead>
		              <tr>
	                    <th>活动类型</th>	              
		                <th>主题</th>
		                <th>开始时间</th>
		                <th>结束时间</th>
		                <th>活动渠道</th>
		                <th>状态</th>
		                <th>创建时间</th>
		                <th>操作</th>
		              </tr>
	                </thead>
	                <tbody>
		               <c:forEach items="${paginator.object}" var="r"> 
			   			 <tr>
			   			   <td>
					          <c:if test="${r.activityType==1}">满减活动</c:if>
							  <c:if test="${r.activityType==2}">满赠活动</c:if>
							  <c:if test="${r.activityType==3}">特价活动</c:if>
					       </td>
			   			   <td>${r.activityTitle}</td>
					       <td>${r.activityBeginTime}</td>
					       <td>${r.activityEndTime}</td>
					       <td>
					          <c:if test="${r.activityChannel==1}">平台活动</c:if>
							  <c:if test="${r.activityChannel==2}">商家自建</c:if>
					       </td>
					       <td>
					       	  <c:if test="${r.activityStatus==1}">在用</c:if>
							  <c:if test="${r.activityStatus==-1}">停用</c:if>
					       </td>
					       <td><fmt:formatDate value="${r.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					       <td>
					         <div class="site-demo-button" >
							   <button data-method="setTop" class="layui-btn layui-btn-normal layui-btn-small" onclick="update(${r.activityId},${r.activityType})"><i class="layui-icon"></i><span>&nbsp;&nbsp;修改</span></button>
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
<script type="text/javascript" src="/jquery-easyui-1.5.2/jquery.easyui.min.js" charset="utf-8"></script>
<script type="text/javascript" src="/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<script type="text/javascript">
//分页
function onSelectPage(currentPage,pageSize){  
	$('#pageNum').val(currentPage);
	$('#pageSize').val(pageSize);
	$('#subForm').submit();
}

//重置
$(function(){
   $("#reset").click(function(){
	   window.location.href="/admin/activity/list";
   });
  });
//新增
function add(type){
	window.location.href="/admin/activity/addOrEdit?activityType="+type;
}
//修改
function update(activityId,activityType){
	window.location.href="/admin/activity/addOrEdit?activityId="+activityId+"&activityType="+activityType;
}
</script>
</body>
</html>