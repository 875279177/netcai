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
  <!-- 计量单位列表start -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>计量单位管理</h1>
    </section>
    <!-- Main content -->
    <shiro:hasPermission name="unit:query">
	    <section class="content">
	      <div class="row">
	        <div class="col-xs-12">
	          <div class="box">
	            <div class="box-header">
	              <h3 class="box-title">计量单位</h3>
	            </div>
	            <!-- 表单start -->
	            <form id="searchForm" method="post" class="form-horizontal"  action="/admin/unit/list">
	              <input type="hidden" name="pageNum" id="pageNum" value="${paginator.currentPage}">
	              <input type="hidden" name="pageSize" id="pageSize" value="${paginator.pageRecord}">
	              <div class="box-body">
	                <div class="form-group" >
	                  <label class="col-sm-2 control-label">编码</label>
	                  <div class="col-xs-3">
		                <input type="text" mame="unitCode" value="${unitCode}" class="form-control" placeholder="请输入编码">
		              </div>
		              <label class="col-sm-2 control-label">名称</label>
	                  <div class="col-xs-3">
		                <input type="text" name="unitName" value="${unitName}" class="form-control" placeholder="请输入名称">
		              </div>
	                </div>
	              </div>
	              <div class="box-footer">
	                <button type="reset" id="reset" class="btn btn-info pull-right" style="margin-right:40px;">重置</button>
	                <button type="submit" class="btn btn-info pull-right">查询</button>
	              </div>
	            </form>
	            <div class="site-demo-button" style="margin-bottom: 0;">
				  <button data-method="setTop" class="layui-btn layui-btn-primary layui-btn-small" onclick="add()"><i class="layui-icon"></i><span>&nbsp;&nbsp;新增</span></button>
	            </div>
	            <!-- 表单end -->
	            <!-- /.box-header -->
	            <div class="box-body" style="padding-top: 1px;">
	              <table id="unitData" class="table table-bordered table-hover">
	                <thead>
		              <tr>
		                <th>编码</th>
		                <th>名称</th>
		                <th>顺序号</th>
		                <th>状态</th>
		                <th>创建时间</th>
		                <th>操作</th>
		              </tr>
	                </thead>
	                <tbody>
		               <c:forEach items="${paginator.object}" var="r"> 
			   			 <tr>
						       <td>${r.unitCode}</td>
						       <td>${r.unitName}</td>
						       <td>${r.unitSeq}</td>
						       <td>
						       	  <c:if test="${r.unitStatus==1}">在用</c:if>
								  <c:if test="${r.unitStatus==-1}">停用</c:if>
						       </td>
						       <td><fmt:formatDate value="${r.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						       <td>
				  				 <button data-method="setTop" class="layui-btn layui-btn-small" onclick="update(${r.unitId})"><i class="layui-icon"></i></button>
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
      <form id="subForm" method="post" action="<%=request.getContextPath()%>/admin/unit/saveOrUpdate" class="form-horizontal">
        <input type="hidden" name="unitId" id="unitId" value="">
        <div class="box-body">
          <div class="form-group">
            <label class="col-sm-2 control-label">编码:</label>
            <div class="col-sm-10">
              <input type="text" name="unitCode" class="form-control" id="unitCode" placeholder="请输入编码" required maxlength="10">
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-2 control-label">名称:</label>
            <div class="col-sm-10">
              <input type="text" name="unitName" class="form-control" id="unitName" placeholder="请输入名称" required maxlength="10">
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-2 control-label">顺序号:</label>
            <div class="col-sm-10">
              <input type="text" name="unitSeq" class="form-control" id="unitSeq" placeholder="请输入顺序号" required digits:true>
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-2 control-label">状态:</label>
            <div class="col-sm-10">
              <select name="unitStatus" id="unitStatus" class="form-control select2" style="width: 100%;">
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
  	 $('#pageNum').val(currentPage);
	 $('#pageSize').val(pageSize);
	 $('#searchForm').submit();
  }  
  
//重置
  $(function(){
     $("#reset").click(function(){
  	   window.location.href="/admin/unit/list";
     });
    });
  //新增数据
  function add(){
	  $("#unitId").attr("value", "");
	  $("#unitCode").attr("value", "");
	  $("#unitName").attr("value", "");
	  $("#unitSeq").attr("value", "");
	  popup('新增计量单位','480px','350px',$('#content').html());
  }
  //修改数据
  function update(unitId){
	  $.ajax({
		  type: 'POST',
		  url: '/admin/unit/getUnitById?unitId='+unitId,
		  dataType: 'json',
		  success: function (data) {
			  $("#unitId").attr("value", data.unitId);
			  $("#unitCode").attr("value", data.unitCode);
			  $("#unitName").attr("value", data.unitName);
			  $("#unitSeq").attr("value", data.unitSeq);
			  $("#unitStatus option[value='" + data.unitStatus + "']").attr("selected", true);  
			  popup('修改计量单位','480px','350px',$('#content').html());
		  }
	  });
  }
</script>
</body>
</html>