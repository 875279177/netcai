<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="pv" uri="/pageTaglib"%>  
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html>
<html>
<head>
  <!-- 引入公共部分jsp文件 -->
  <meta name="decorator" content="default"/>
  <style type="text/css">
    .layui-form-label{
      width:100px;
    }
    .layui-input-block{
      width:auto;
      height:auto;
    }
    table th{
      background:#ffffff;
    }
	table tr:nth-child(odd){
	  background:#F0F0F0;
	}
	.col-sm-2 {
	  width: 10%;
	}
	.form-footer{
	  margin-right:75px;
	  float:right;
	}
	.btn-select{
	  margin-right:20px;
	}
  </style>
</head>
<body>
  <!-- 销售人员列表start -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>销售人员信息管理</h1>
    </section>
    <!-- Main content -->
    <shiro:hasPermission name="sales:query">
	    <section class="content">
	      <div class="row">
	        <div class="col-xs-12">
	          <div class="box">
	            <div class="box-header">
	              <h3 class="box-title">销售人员列表</h3>
	            </div>
	            <div class="box box-info">
	              <form id="deliveryForm" class="form-horizontal" action="/admin/sales/list" method="post" >
				    <input type="hidden" name="pageNum" id="pageNum" value="${paginator.currentPage}">
	                <input type="hidden" name="pageSize" id="pageSize" value="${paginator.pageRecord}">
				    <div class="box-body">
					   <div class="form-group">
					     <label class="col-sm-2 control-label">姓名：</label>
					     <div class="col-xs-2">
					       <input name="realName" type="text" class="form-control" placeholder="请输入姓名" value="${sales.realName}">
					     </div>
					     <label class="col-sm-2 control-label">手机号：</label>
						 <div class="col-xs-2">
						   <input name="phone" type="text" placeholder="请输入手机号" class="form-control" value="${sales.phone}">
						 </div>
						 <label for="status" class="col-sm-2 control-label">状态：</label>
		                 <div class="col-xs-2">
		                   <select id="status" name="status" class="form-control" style="width:150px;">
							   <option value="" selected>全部</option>
						       <option value="1" <c:if test="${sales.status==1}">selected</c:if>>在职</option>
						       <option value="-1" <c:if test="${sales.status==-1}">selected</c:if>>离职</option>
						   </select>
		                 </div>
					   </div>
					   <div class="form-footer" >
			             <button type="submit" class="btn btn-info pull-left btn-select">查询</button>
			             <button type="reset" class="btn btn-info pull-left" onclick="clearSearch()">重置</button>
			           </div>
				    </div>
				  </form>
	            </div>
	            <!-- /.box-header -->
	            <div class="layui-form" >
		          <div class="site-demo-button" >
				     <button data-method="setTop" class="layui-btn layui-btn-primary layui-btn-small"><i class="layui-icon"></i><span>&nbsp;&nbsp;新增</span></button>
				  </div>
	              <table class="layui-table" lay-skin="row">
	                <thead>
		              <tr>
		                <th>姓名</th>
		                <th>手机号码</th>
		                <th>类型</th>
		                <th>经验值</th>
		                <th>在职状态</th>
		                <th>创建时间</th>
		                <th>更新时间</th>
		                <th>操作</th>
		              </tr>
	                </thead>
	                <tbody>
		               <c:forEach items="${paginator.object}" var="r"> 
			   			 <tr>
					       <td>${r.realName}</td>
					       <td>${r.phone}</td>
					       <td>
					         <c:if test="${r.level==1 }">总监</c:if>
					         <c:if test="${r.level==2 }">主管</c:if>
					         <c:if test="${r.level==3 }">职员</c:if>
					         <c:if test="${r.level==0 }">管理员</c:if>
					       </td>
					       <td>${r.experience}</td>
					       <td>
					         <c:if test="${r.status==1 }">在职</c:if>
					         <c:if test="${r.status==-1 }">离职</c:if>
					       </td>
				           <td><fmt:formatDate value="${r.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				           <td><fmt:formatDate value="${r.lastUpdateTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					       <td>
					         <div class="site-demo-button" >
							   <button data-method="setTop" value="${r.id }" class="layui-btn layui-btn-normal layui-btn-small"><i class="layui-icon"></i><span>&nbsp;&nbsp;修改</span></button>
							   <c:if test="${r.status==1}">
							     <button data-method="offset" value="${r.id }" class="layui-btn layui-btn-danger layui-btn-small"><i class="layui-icon"></i><span>&nbsp;&nbsp;禁用</span></button>
							   </c:if>
							   <c:if test="${r.status==-1}">
							     <button data-method="offset" value="${r.id }" class="layui-btn layui-btn-danger layui-btn-small"><i class="layui-icon"></i><span>&nbsp;&nbsp;启用</span></button>
							   </c:if>
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
<script src="/js/raphael-min.js"></script>
<script src="/plugins/sparkline/jquery.sparkline.min.js"></script>
<script src="/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script src="/plugins/knob/jquery.knob.js"></script>
<script src="/js/moment.min.js"></script>
<script src="/plugins/daterangepicker/daterangepicker.js"></script>
<script src="/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script src="/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="/plugins/fastclick/fastclick.js"></script>
<script src="/dist/js/app.min.js"></script>
<script src="/dist/js/demo.js"></script>
<script src="/js/jquery-ui.min.js"></script>
<script src="/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript">
//重置
function clearSearch(){
	window.location.href="<%=request.getContextPath()%>/admin/sales/list";
}

function onSelectPage(currentPage,pageSize)
{  
	$('#pageNum').val(currentPage);
	$('#pageSize').val(pageSize);
	$('#deliveryForm').submit();
}   
</script>
<script>
layui.use(['form', 'layedit', 'laydate'], function(){
	   var form = layui.form(),layer = layui.layer,layedit = layui.layedit,laydate = layui.laydate;
	   
	   //监听指定开关
	   form.on('switch(switchTest)', function(data){
	       layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
	           offset: '6px'
	       });
	   });
});
//新增数据弹窗
layui.use('layer', function(){ //独立版的layer无需执行这一句
	   var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句  
	   //触发事件
	   var active = {
			 setTop: function(data){
				 //获取salesId
		       	 var salesId = data.val();
			     //多窗口模式，层叠置顶
			     layer.open({
			         type: 2, 
			         title: '新增/修改销售人员信息',
			         area: ['760px', '400px'],
			         shade: 0.5,
			         anim: 3,//0-6的动画形式，-1不开启
			         content: '/admin/sales/addSales?id='+salesId,
			         zIndex: layer.zIndex, //重点1
			         success: function(layero, index){
			        	 layer.setTop(layero);
			        	 var body = layer.getChildFrame('body', index);
			             var iframeWin = window[layero.find('iframe')[0]['name']]; 
			             //弹窗表单的取消操作时关闭弹窗
			             var canclebtn=body.find('button[name="cancleSubmit"]').click(function cancleSubmit(){
			            	 layer.closeAll();
			             });
			         }
			     });
			 },
			 //启用和禁用
		     offset: function(othis){
		         var type = othis.data('type');
		         var id = othis.val();
		         var status = othis.text();
		         if(status.indexOf("禁用")!=-1){
	        		 html = "<p>确定要禁用此条数据吗？</p>";
	        		 //禁用的url
	        		 requestUrl="<%=request.getContextPath()%>/admin/sales/disabled";
	        	 }else if(status.indexOf("启用")!=-1){
	        		 html = "<p>确定要启用此条数据吗？</p>";
	        		 //启用的url
	        		 requestUrl="<%=request.getContextPath()%>/admin/sales/enabled";
	        	 }
		         layer.open({
		             type: 1,
		             offset: type, 
		             id: 'LAY_demo'+type, //防止重复弹出
		             content: '<div style="padding: 20px 100px;">'+ html +'</div>',
		             btn: ['确定', '取消'],
		             btnAlign: 'c', //按钮居中
		             shade: 0.5 ,//不显示遮罩
		             yes: function(){
			        	 layer.closeAll();
			        	 var id = othis.val();
			             $.ajax({
			            	 type: "POST",
			                 url: requestUrl,
			                 data: {"id":id},
			                 dataType: "json",
			                 cache:false,
			                 success: function(data){
			                	 var code = data.code;
			                	 var msg = data.message;
			                	 if(code == "200"){
			                		 layer.msg(msg, {icon: 1,time: 2000});//2秒关闭
			                		 //刷新页面
			                		 window.location.reload();
			                	 }
			                 }
			             });
		             },
		             btn2: function(){
			             layer.closeAll();
			         }
		        });
		      }
		  };
	   $('.site-demo-button .layui-btn').on('click', function(){
	       var othis = $(this), method = othis.data('method');
	       active[method] ? active[method].call(this, othis) : '';
	   });
	});
</script>
</body>
</html>