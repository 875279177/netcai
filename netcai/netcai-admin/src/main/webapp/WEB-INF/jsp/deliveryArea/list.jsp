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
	  margin-right:800px;
	  float:right;
	}
	.btn-select{
	  margin-right:10px;
	}
  </style>
</head>
<body>
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>配送区域信息管理</h1>
    </section>
    <!-- Main content -->
    <shiro:hasPermission name="deliveryArea:query">
	    <section class="content">
	      <div class="row">
	        <div class="col-xs-12">
	          <div class="box">
	            <div class="box-header">
	              <h3 class="box-title">配送区域信息</h3>
	            </div><div class="box box-info">
		           <!-- form start -->
		           <form  id="form_submit" class="form-horizontal" action="<%=request.getContextPath()%>/admin/deliveryArea/list" method="post">
		             <div class="box-body">
		               <div class="form-group">
		                 <label for="bossTel" class="col-sm-2 control-label">区域名称：</label>
		                 <div class="col-xs-2">
		                   <input type="text" class="form-control" name="address" placeholder="请输入区域名称" value="${deliveryArea.address}">
		                 </div>
		                 <label for="status" class="col-sm-2 control-label">状态：</label>
		                 <div class="col-xs-2">
		                   <select id="status" name="status" class="form-control" style="width:150px;">
							   <option value="" >全部</option>
							   <option value="-1" <c:if test="${deliveryArea.status ==-1}">selected</c:if>>不可用</option>
						       <option value="1" <c:if test="${deliveryArea.status ==1}">selected</c:if>>可用</option>
						   </select>
		                 </div>
		               </div>
			           <div class="form-footer" >
			             <button type="submit" class="btn btn-info pull-left btn-select">查询</button>
			             <button type="reset" id="reset" class="btn btn-info pull-left">重置</button>
			           </div>
		           </form>
		           <!-- form end -->
		        </div>
	            <!-- /.box-header -->
	            <div class="layui-form" >
		          <div class="site-demo-button" >
				     <button data-method="setTop" class="layui-btn layui-btn-small layui-btn-primary"><i class="layui-icon"></i><span>&nbsp;&nbsp;新增</span></button>
				  </div>
	              <table class="layui-table" lay-skin="row">
	                <thead>
		              <tr>
		                <th>区域名称</th>
		                <th>状态</th>
		                <th>创建时间</th>
		                <th>操作</th>
		              </tr>
	                </thead>
	                <tbody>
		               <c:forEach items="${paginator.object}" var="r"> 
			   			 <tr>
					       <td>${r.address}</td>
					       <td>
					         <c:if test="${r.status ==-1}">不可用</c:if>
					         <c:if test="${r.status ==1}">可用</c:if>
					       </td>
					       <td><fmt:formatDate value="${r.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					       <td>
					         <div class="site-demo-button" >
							   <c:if test="${r.status ==-1}">
							     <button data-method="offset" value="${r.id }" class="layui-btn layui-btn-normal layui-btn-small"><i class="layui-icon"></i><span>&nbsp;&nbsp;启用</span></button>
							   </c:if>
							   <c:if test="${r.status ==1}">
							     <button data-method="setTop" value="${r.id }" class="layui-btn layui-btn-normal layui-btn-small"><i class="layui-icon"></i><span>&nbsp;&nbsp;修改</span></button>
							     <button data-method="offset" value="${r.id }" class="layui-btn layui-btn-danger layui-btn-small"><i class="layui-icon"></i><span>&nbsp;&nbsp;禁用</span></button>
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
//分页
function onSelectPage(currentPage,pageSize){
	$('#pageNum').val(currentPage);
	$('#pageSize').val(pageSize);
	$('#form_submit').submit();
}

//重置
$(function(){
   $("#reset").click(function(){
	   window.location.href="/admin/deliveryArea/list";
   });
  });
</script>
<script>
   layui.use(['form', 'jquery','layedit', 'laydate'], function(){
	   var form = layui.form(),layer = layui.layer,$ = layui.jquery,
	       layedit = layui.layedit,laydate = layui.laydate;
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
				 //点击修改按钮时获取id
				 var id = data.val();
				 var name = data.text();
				 var requestUrl ='/admin/deliveryArea/toAdd?id='+id;
			     //多窗口模式，层叠置顶
			     layer.open({
			         type: 2, 
			         title: '新增/修改配送区域信息',
			         area: ['1050px', '300px'],
			         shade: 0.5,
			         content: requestUrl,
			         zIndex: layer.zIndex, //重点1
			         success: function(layero, index){
			        	 layer.setTop(layero);
			        	 var body = layer.getChildFrame('body', index);
			             var iframeWin = window[layero.find('iframe')[0]['name']]; 
			        	
			         }
			     });
			 },
			 //启用和禁用弹窗
		     offset: function(othis){
		         var type = othis.data('type');
		         var html = "";
		         var status=othis.text();
	        	 var requestUrl ;
	        	 if(status.indexOf("禁用")!=-1){
	        		 html = "<p>确定要禁用此条数据吗？</p>";
	        		 //禁用的url
	        		 requestUrl="<%=request.getContextPath()%>/admin/deliveryArea/disabled";
	        	 }else{
	        		 html = "<p>确定要启用此条数据吗？</p>";
	        		//启用的url
	        		 requestUrl="<%=request.getContextPath()%>/admin/deliveryArea/enabled";
	        	 }
		         layer.open({
		             type: 1,
		             title:"启用/禁用",
		             offset: type, 
		             area: ['295px', '190px'],
		             id: 'LAY_demo'+type, //防止重复弹出
		             content: '<div style="padding: 20px 35px;">'+ html +'</div>',
		             btn: ['确定', '取消'],
		             btnAlign: 'c', //按钮居中
		             shade: 0.5 ,//不显示遮罩
		             yes: function(){
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
			                		 layer.msg(msg, {icon: 1,time: 2000});//1.5秒关闭
			                		 //刷新页面
			                		 window.location.reload();
			                	 }
			                 },
			                 error:function()
			                 {
			                	 alert("操作失败");
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