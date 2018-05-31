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
  <!-- 加工方式列表start -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>加工方式管理</h1>
    </section>
    <!-- Main content -->
    <shiro:hasPermission name="processmethod:query">
	    <section class="content">
	      <div class="row">
	        <div class="col-xs-12">
	          <div class="box">
	           <div class="site-demo-button" >
				  <button data-method="setTop" class="layui-btn layui-btn-primary layui-btn-small" onclick="add()"><i class="layui-icon"></i><span>&nbsp;&nbsp;新增</span></button>
				</div>
	            <!-- 表单end -->
	            <!-- /.box-header -->
	            <div class="box-body" style="padding-top: 1px;">
	              <table id="methodData" class="table table-bordered table-hover">
	                <thead>
		              <tr>
		                <th>名称</th>
		                <th>状态</th>
		                <th>创建时间</th>
		                <th>操作</th>
		              </tr>
	                </thead>
	                <tbody>
		               <c:forEach items="${paginator.object}" var="r"> 
			   			 <tr>
						       <td>${r.methodName}</td>
						       <td>
						       	  <c:if test="${r.methodStatus==1}">在用</c:if>
								  <c:if test="${r.methodStatus==-1}">停用</c:if>
						       </td>
						       <td><fmt:formatDate value="${r.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						       <td>
				  				 <button data-method="setTop" class="layui-btn layui-btn-small" onclick="update(${r.methodId})"><i class="layui-icon"></i></button>
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
	    </section>
    </shiro:hasPermission>
  </div>
  <div id="content" style="display: none">
      <form id="subForm" action="<%=request.getContextPath()%>/admin/processmethod/saveOrUpdate" class="form-horizontal">
        <input type="hidden" name="methodId" id="methodId" value="">
        <div class="box-body">
          <div class="form-group">
            <label for="inputName3" class="col-sm-2 control-label">名称:</label>
            <div class="col-sm-10">
              <input type="text" name="methodName" class="form-control" id="methodName" placeholder="请输入名称">
            </div>
          </div>
          <div class="form-group">
            <label for="inputStatus3" class="col-sm-2 control-label">状态:</label>
            <div class="col-sm-10">
              <select name="methodStatus" id="methodStatus" class="form-control select2" style="width: 100%;">
                  <option value="1">在用</option>
                  <option value="-1">停用</option>
              </select>
            </div>
          </div>
        </div>
        <div class="box-footer">
          <button type="submit" class="btn btn-info pull-left" onclick="saveOrUp()">提交</button>
        </div>
      </form>
  </div>
<script src="/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="/bootstrap/js/bootstrap.min.js"></script>
<script src="/js/jquery-ui.min.js"></script>
<script src="/layui/layui.js"></script>
<script src="/dist/js/app.min.js"></script>
<script type="text/javascript" src="/jquery-easyui-1.5.2/jquery.easyui.min.js" charset="utf-8"></script>
<script type="text/javascript" src="/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<script src="/js/layuiUtil.js" charset="utf-8"></script>
<script>
  //分页
  function onSelectPage(currentPage,pageSize){  
	  window.location.href="/admin/processmethod/list?pageNum="+currentPage+"&pageSize="+pageSize;
  }  
  //新增数据
  function add(){
	  popup('新增加工方式','450px','270px',$('#content').html());
  }
  //修改数据
  function update(methodId){
	  $.ajax({
		  type: 'POST',
		  url: '/admin/processmethod/getMethodById?methodId='+methodId,
		  dataType: 'json',
		  success: function (data) {
			  $("#methodId").attr("value", data.methodId);
			  $("#methodName").attr("value", data.methodName);
			  $("#methodStatus option[value='" + data.methodStatus + "']").attr("selected", true);  
			  popup('修改加工方式','450px','270px',$('#content').html());
		  }
	  });
  }
  //保存、修改数据
  function saveOrUp(){
	  $('#subForm').validate({ 		
			submitHandler: function (form) {
				$('#subForm').submit();
			}
		});
  }
</script>
</body>
</html>