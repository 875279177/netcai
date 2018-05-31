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
  <!-- 角色列表start -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>角色管理</h1>
    </section>
    <!-- Main content -->
    <shiro:hasPermission name="role:query">
	    <section class="content">
	      <div class="row">
	        <div class="col-xs-12">
	          <div class="box">
	            <div class="site-demo-button" style="margin-bottom: 0;">
	              <button data-method="setTop" class="layui-btn layui-btn-small" onclick="add()"><i class="layui-icon">新增</i></button>
	            </div>
	            <!-- 表单end -->
	            <!-- /.box-header -->
	            <div class="box-body" style="padding-top: 1px;">
	              <table id="roleData" class="table table-bordered table-hover">
	                <thead>
		              <tr>
		                <th>名称</th>
		                <th>描述</th>
		                <th>备注</th>
		                <th>状态</th>
		                <th>创建时间</th>
		                <th>操作</th>
		              </tr>
	                </thead>
	                <tbody>
		               <c:forEach items="${paginator.object}" var="r"> 
			   			 <tr>
						       <td>${r.roleName}</td>
						       <td>${r.roleDesc}</td>
						       <td>${r.remarks}</td>
						       <td>
						       	  <c:if test="${r.status==1}">在用</c:if>
								  <c:if test="${r.status==-1}">停用</c:if>
						       </td>
						       <td><fmt:formatDate value="${r.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						       <td>
				  				 <button data-method="setTop" class="layui-btn layui-btn-small" onclick="update(${r.id})"><i class="layui-icon">修改</i></button>
				  				 <button data-method="setTop" class="layui-btn layui-btn-small" onclick="setRoleMenu(${r.id})"><i class="layui-icon">设置菜单</i></button>
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
  <div id="content" style="display: none">
      <form id="subForm" method="post" action="<%=request.getContextPath()%>/admin/role/saveOrUpdate" class="form-horizontal">
        <input type="hidden" name="id" id="id" value="">
        <div class="box-body">
          <div class="form-group">
            <label class="col-sm-2 control-label">名称:</label>
            <div class="col-sm-10">
              <input type="text" name="roleName" class="form-control" id="roleName" placeholder="请输入名称" required maxlength="10">
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-2 control-label">描述:</label>
            <div class="col-sm-10">
              <input type="text" name="roleDesc" class="form-control" id="roleDesc" placeholder="请输入描述">
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-2 control-label">备注:</label>
            <div class="col-sm-10">
              <input type="text" name="remarks" class="form-control" id="remarks" placeholder="请输入备注">
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-2 control-label">状态:</label>
            <div class="col-sm-10">
              <select name="status" id="status" class="form-control select2" style="width: 100%;">
                  <option value="1">在用</option>
                  <option value="-1">停用</option>
              </select>
            </div>
          </div>
        </div>
        <div class="box-footer">
          <button type="submit" class="btn btn-info pull-left">提交</button>
        </div>
      </form>
  </div>
  
<script src="/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="/bootstrap/js/bootstrap.min.js"></script>
<script src="/js/jquery-ui.min.js"></script>
<script src="/js/jquery.validate.js"></script>
<script src="/layui/layui.js"></script>
<script src="/dist/js/app.min.js"></script>
<script type="text/javascript" src="/jquery-easyui-1.5.2/jquery.easyui.min.js" charset="utf-8"></script>
<script type="text/javascript" src="/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<script src="/js/layuiUtil.js" charset="utf-8"></script>
<script>
  $.validator.setDefaults({
     submitHandler: function() {
      alert("提交事件!");
     }
  });
  //分页
  function onSelectPage(currentPage,pageSize){  
	 location.href="/admin/role/list?pageNum="+currentPage+"&pageSize="+pageSize;
  }  
  //新增数据
  function add(){
	  $("#id").attr("value", "");
	  $("#roleName").attr("value", "");
	  $("#roleDesc").attr("value", "");
	  $("#remarks").attr("value", "");
	  popup('新增角色','480px','350px',$('#content').html());
  }
  //修改数据
  function update(roleId){
	  $.ajax({
		  type: 'POST',
		  url: '/admin/role/getSysRoleById?id='+roleId,
		  dataType: 'json',
		  success: function (data) {
			  $("#id").attr("value", data.id);
			  $("#roleName").attr("value", data.roleName);
			  $("#roleDesc").attr("value", data.roleDesc);
			  $("#remarks").attr("value", data.remarks);
			  $("#status option[value='" + data.status + "']").attr("selected", true);  
			  popup('修改角色','480px','350px',$('#content').html());
		  }
	  });
  }
  //设置加色菜单
  function setRoleMenu(roleId){
	  window.location.href="/admin/menu/setRoleMenu?roleId="+roleId;
  }
</script>
</body>
</html>