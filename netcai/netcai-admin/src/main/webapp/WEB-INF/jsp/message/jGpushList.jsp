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
  <!-- 配送人员列表start -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>推送管理</h1>
    </section>
    <!-- Main content -->
    <shiro:hasPermission name="jdpush:query">
	    <section class="content">
	      <div class="row">
	        <div class="col-xs-12">
	          <div class="box">
	            <!-- 表单start -->
	            <form id="jdpushForm" class="layui-form" action="<%=request.getContextPath() %>/admin/jdpush/list" method="post" >
	              <input type="hidden" name="pageNum" id="pageNum" value="${paginator.currentPage}">
	              <input type="hidden" name="pageSize" id="pageSize" value="${paginator.pageRecord}">
	              <div class="col-xs-12" style="top: 20px">
	                <div class="form-group" >
	                  <label for="msgName" class="col-xs-1 control-label" >内容</label>
	                  <div class="col-xs-2">
		                <input type="text" class="form-control input-small" id="msgName" name="msgContent" value="${message.msgContent}" placeholder="请输入内容">
		              </div>
	                </div>
	              </div>
	              <div class="col-xs-3 layui-form-item layui-form-btns" style="float: right;top: 50px">
					   <div class="layui-input-block">
					     <button class="layui-btn" lay-submit="" lay-filter="demo1">查询</button>
					     <button type="reset" id="reset" class="layui-btn layui-btn-primary">重置</button>
					   </div>
				   </div>
	            </form> 
	            <!-- 增删改图标按钮组 -->
	            <div class="site-demo-button" style="margin-top: 100px">
	               <button onclick="add()" class="btn btn-success btn-xs"><i class="layui-icon"></i><span>&nbsp;&nbsp;新增</span></button>
				</div>
	            <!-- 表单end -->
	            <!-- /.box-header -->
	            <div class="layui-form" >
	              <table id="contentTable" class="layui-table table-striped">
	                <thead >
		             <tr >
		                <th>推送结果</th>
		                <th>推送人群</th>
		                <th>消息标题</th>
		                <th>消息内容</th>
		                <th>创建时间</th>
		              </tr>
	                </thead>
	                <tbody>
		              <c:forEach items="${pageResult.object}" var="r"> 
			   			 <tr>
						       <td>
						       		<c:choose>
						       			<c:when test="${r.status ==-1}">
						       				失败
						       			</c:when>
						       			<c:otherwise>成功</c:otherwise>
						       		</c:choose>
						       </td>
						       <td>${r.shopName}</td>
						       <td>${r.msgName}</td>
						       <td>${r.msgContent}</td>
						       <td><fmt:formatDate value="${r.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
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
//分页
function onSelectPage(currentPage,pageSize){  
	$('#pageNum').val(currentPage);
	$('#pageSize').val(pageSize);
	$('#jdpushForm').submit();
} 
</script>
<script>
layui.use(['form', 'jquery', 'layedit', 'laydate'], function(){
	var $ = layui.jquery,form = layui.form(),layer = layui.layer,
	  layedit = layui.layedit,laydate = layui.laydate;
	 //全选
	   form.on('checkbox(allChoose)', function(data){
	     var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]');
	     child.each(function(index, item){
	       item.checked = data.elem.checked;
	     });
	     form.render('checkbox');
	   });
	   
	   //监听指定开关
	   form.on('switch(switchTest)', function(data){
	       layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
	           offset: '6px'
	       });
	   });
});

//重置
$(function(){
   $("#reset").click(function(){
	   window.location.href="/admin/jdpush/list";
   });
  });

//修改;
function add(){
	layer.open({
        type: 2, 
        title: '新增',
        area: ['600px', '300px'],
        shade: 0.5,
        content: '/admin/jdpush/toAdd',
        zIndex: layer.zIndex, //重点1
        cache: false,
      });
}
</script>
</body>
</html>