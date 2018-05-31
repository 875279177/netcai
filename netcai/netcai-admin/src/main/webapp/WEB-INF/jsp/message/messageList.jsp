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
<body class="hold-transition skin-blue sidebar-mini">
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>消息管理</h1>
    </section>
    <!-- Main content -->
    <shiro:hasPermission name="message:query">
	    <section class="content">
	      <div class="row">
	        <div class="col-xs-12">
	          <div class="box">
	            <div class="box-header">
	              <h3 class="box-title">消息列表信息</h3>
	            </div>
	            <!-- <!-- 表单start -->
	            <form id="subForm" class="layui-form" action="/admin/message/list" method="post" >
	            	<input type="hidden" name="pageNum" id="pageNum" value="${pageResult.currentPage}">
	              <input type="hidden" name="pageSize" id="pageSize" value="${pageResult.pageRecord}">
	               <div class="col-sm-12">
	                <div class="form-group" >
	                  <label for="createTimeStart" class="col-sm-1 control-label">开始时间:</label>
	                  <div class="col-sm-3">
		                <input type="text" name="createTimeStart" id="createTimeStart" value="${message.createTimeStart}" class="form-control input-small" placeholder="请选择开始时间">
		              </div>
		             <label for="createTimeStop" class="col-sm-1 control-label">结束时间:</label>
	                  <div class="col-sm-3">
		                <input type="text" name="createTimeStop" id="createTimeStop" value="${message.createTimeStop}"  class="form-control" placeholder="请输入结束时间">
		              </div>
	                </div>
	              </div>
	              
	              <div class="col-sm-3 layui-form-item layui-form-btns" style="float: right;margin-top: 50px;">
					     <button type="submit" class="btn btn-info pull-left" onclick="saveOrUp()">提交</button>
					     <button type="reset" id="reset" class="btn btn-info pull-left">重置</button>
				   </div>
	            </form> 
	           <div class="row">
				<div class="col-sm-12">
				<div class="pull-left">
				</div>
				</div>
				</div>
	            <!-- 表单end -->
	            <!-- /.box-header -->
	            <div class="layui-form" >
	              <table id="contentTable" class="layui-table table-striped">
	                <thead >
		             <tr >
		                <th>消息标题</th>
		                <th>用户账号</th>
		                <th>店铺名称</th>
		                <th>用户类型</th>
		                <th>消息内容</th>
		                <th>创建时间</th>
		              </tr>
	                </thead>
	                <tbody>
		              <c:forEach items="${pageResult.object}" var="r"> 
			   			 <tr>
						       <td>${r.msgName}</td>
						       <td>${r.account}</td>
						       <td>${r.shopName}</td>
						       <td>
						       		<c:choose>
						       			<c:when test="${r.type ==1}">买家</c:when>
						       			<c:otherwise>卖家</c:otherwise>
						       		</c:choose>
						       </td>
						       <td><a href="#" id="${r.msgId}" class="update">${r.msgContent}</a></td>
						       <td><fmt:formatDate value="${r.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			             </tr>
					   </c:forEach>
	                </tbody>
	              </table>
	            </div>
	            <div class="box-footer clearfix">
	              <ul class="pagination pagination-sm no-margin pull-left">
	              	 <pv:showPaging pageVo="${pageResult}" />
	              </ul>
	            </div>
	          </div>
	          </div>
	        </div>
	    </section>
    </shiro:hasPermission>
  </div>
</div>
<script src="/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="/bootstrap/js/bootstrap.min.js"></script>
<script src="/bootstrap/js/bootstrap-datetimepicker.js"></script>
<script src="/bootstrap/js/bootstrap-editable.js"></script>
<script src="/js/raphael-min.js"></script>
<script src="/plugins/sparkline/jquery.sparkline.min.js"></script>
<script src="/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script src="/plugins/knob/jquery.knob.js"></script>
<script src="/js/moment.min.js"></script>
<script src="/plugins/daterangepicker/daterangepicker.js"></script>
<script src="/plugins/datepicker/bootstrap-datepicker.js"></script>
<script src="/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script src="/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="/plugins/fastclick/fastclick.js"></script>
<script src="/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script src="/dist/js/app.min.js"></script>
<script src="/dist/js/demo.js"></script>
<script src="/js/jquery-ui.min.js"></script>
<script src="/layui/layui.js" charset="utf-8"></script>
<script src="/js/jquery.validate.min.js" charset="utf-8"></script>
<script src="/js/layuiUtil.js" charset="utf-8"></script>
<script src="/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
function onSelectPage(currentPage,pageSize)
{  
	$('#pageNum').val(currentPage);
	$('#pageSize').val(pageSize);
	$('#subForm').submit();
}
</script>
<script>
//重置
$(function(){
   $("#reset").click(function(){
	   window.location.href="/admin/message/list";
   });
  });
  
  //修改消息;
$(function () {
    $('.update').editable({
        type: "textarea",                //编辑框的类型。支持text|textarea|select|date|checklist等
        title: "最佳送货时间",              //编辑框的标题
        disabled: false,             //是否禁用编辑
        emptytext: "空文本",          //空值的默认文本
        mode: "popup",              //编辑框的模式：支持popup和inline两种模式，默认是popup
        validate: function (value) { //字段验证
        	var msgId = $(this).attr('id');
        	if (!$.trim(msgId)) {
        		layer.msg("id不能为空", {icon: 5});
        		return false;
            }
            if (!$.trim(value)) {
            	layer.msg('请输入内容', {icon: 5});
            	return false;
            }
            var msgContent = value;
            $.ajax({
      		  type: 'POST',
      		  url: '/admin/message/update',
      		  data:{"msgId":msgId,"msgContent":msgContent},
      		  dataType: 'json',
      		  success: function (data) {
      			  layer.msg(data.message, {icon: 6});
      		  },error: function () {
      			layer.msg("更新失败", {icon: 5});
			}
      	  });
        }
    });
});

//初始化时间选择器
$("#createTimeStart").bind("click focus", function () {
    var endtimeTf = $dp.$('createTimeStop');
    WdatePicker({
        maxDate: '#F{$dp.$D(\'createTimeStart\')}',
        dateFmt: "yyyy-MM-dd HH:mm",
        onpicked: function () { endtimeTf.focus(); }
    });
});
$("#createTimeStop").bind("click focus", function () {
    WdatePicker({
        minDate: '#F{$dp.$D(\'createTimeStart\')}',
        dateFmt: "yyyy-MM-dd HH:mm"
    });
});
</script>
</body>
</html>