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
      <h1>配送人员信息管理</h1>
    </section>
    <!-- Main content -->
    <shiro:hasPermission name="delivery:query">
	    <section class="content">
	      <div class="row">
	        <div class="col-xs-12">
	          <div class="box">
	            <div class="box-header">
	              <h3 class="box-title">配送人员信息</h3>
	            </div><div class="box box-info">
		           <!-- form start -->
		           <form  id="form_submit" class="form-horizontal" action="<%=request.getContextPath()%>/admin/delivery/list" method="post">
		             <input type="hidden" name="pageNum" id="pageNum" value="${paginator.currentPage}">
	                 <input type="hidden" name="pageSize" id="pageSize" value="${paginator.pageRecord}">
		             <div class="box-body">
		               <div class="form-group">
		                 <label for="deliveryName" class="col-sm-2 control-label">姓名：</label>
		                 <div class="col-xs-2">
		                   <input type="text" class="form-control" id="deliveryName" name="deliveryName" placeholder="请输入姓名" value="${delivery.deliveryName}">
		                 </div>
		                 <label for="bossTel" class="col-sm-2 control-label">手机号：</label>
		                 <div class="col-xs-2">
		                   <input type="text" class="form-control" id="deliveryPhone" name="deliveryPhone" placeholder="请输入手机号" value="${delivery.deliveryPhone}">
		                 </div>
		                 <label for="areaId" class="col-sm-2 control-label">所在区域：</label>
		                 <div class="col-xs-2">
		                   <select id="areaId" name="areaId" class="form-control" >
							   <option value="" >全部</option>
							   <c:forEach items="${regions}" var="r">
							     <option value="${r.id }" <c:if test="${r.id ==delivery.areaId }">selected</c:if> >${r.areaName }</option>
							   </c:forEach>
						   </select>
		                 </div>
		               </div>
		               <div class="form-group">
		                 <label for="status" class="col-sm-2 control-label">状态：</label>
		                 <div class="col-xs-2">
		                   <select id="status" name="status" class="form-control" >
							   <option value="" >全部</option>
							   <option value="-1" <c:if test="${delivery.status ==-1}">selected</c:if>>不可用</option>
						       <option value="1" <c:if test="${delivery.status ==1}">selected</c:if>>可用</option>
						   </select>
		                 </div>
		               </div>
			           <div class="form-footer" >
			             <button type="submit" class="btn btn-info pull-left btn-select">查询</button>
			             <button type="reset" class="btn btn-info pull-left" onclick="clearSearch()">重置</button>
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
		                <th>区域</th>
		                <th>姓名</th>
		                <th>手机号</th>
		                <th>身份证号码</th>
		                <th>年龄</th>
		                <th>性别</th>
		                <th>状态</th>
		                <th>权限</th>
		                <th>注册时间</th>
		                <th>操作</th>
		              </tr>
	                </thead>
	                <tbody>
		               <c:forEach items="${paginator.object}" var="r"> 
			   			 <tr>
					       <td>${r.areaName}</td>
					       <td>${r.deliveryName}</td>
					       <td>${r.deliveryPhone}</td>
					       <td>${r.deliveryIdCard}</td>
					       <td>${r.deliveryAge}</td>
					       <td>
					         <c:if test="${r.deliverySex==1}">男</c:if>
					         <c:if test="${r.deliverySex==2}">女</c:if>
					       </td>
					       <td>
					         <c:if test="${r.status ==-1}">不可用</c:if>
					         <c:if test="${r.status ==1}">可用</c:if>
					       </td>
					       <td>
					         <c:if test="${r.permissionType ==0}">查看</c:if>
					         <c:if test="${r.permissionType ==1}">可操作</c:if>
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
							     <button onclick="distributeArea(${r.id },${r.areaId })" class="layui-btn layui-btn-warm layui-btn-small"><span>分配区域</span></button>
							     <!--<button type="button" class="btn btn-primary" onclick="Tasking(${r.id })"  data-complete-text="Loading finished" >任务分配</button>-->
							     <c:if test="${r.permissionType ==1}"><button type="button" class="layui-btn layui-btn-normal layui-btn-small" onclick="Runing(${r.id })" >运行轨迹</button></c:if>
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
	window.location.href="<%=request.getContextPath()%>/admin/delivery/list";
}

//选择页码
function onSelectPage(currentPage,pageSize){  
	$('#pageNum').val(currentPage);
	$('#pageSize').val(pageSize);
	$('#form_submit').submit();
}  
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
			     //多窗口模式，层叠置顶
			     layer.open({
			         type: 2, 
			         title: '新增/修改配送人员信息',
			         area: ['1030px', '430px'],
			         shade: 0.5,
			         content: '/admin/delivery/addDelivery?id='+id,
			         zIndex: layer.zIndex, //重点1
			         success: function(layero, index){
			        	 layer.setTop(layero);
			        	 var body = layer.getChildFrame('body', index);
			             var iframeWin = window[layero.find('iframe')[0]['name']]; 
			             body.find('input[name="id"]').val(id);
			        	
			         }
			     });
			 },
			 //修改买家状态弹窗
		     offset: function(othis){
		         var type = othis.data('type');
		         var html = "";
		         var status=othis.text();
	        	 var requestUrl ;
	        	 if(status.indexOf("禁用")!=-1){
	        		 html = "<p>确定要禁用此条数据吗？</p>";
	        		 //禁用的url
	        		 requestUrl="<%=request.getContextPath()%>/admin/delivery/disabled";
	        	 }else{
	        		 html = "<p>确定要启用此条数据吗？</p>";
	        		//启用的url
	        		 requestUrl="<%=request.getContextPath()%>/admin/delivery/enabled";
	        	 }
		         layer.open({
		             type: 1,
		             title:"更新状态",
		             offset: type, 
		             area: ['350px', '215px'],
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
		         
		      },
			  //拒看商家
		      notice: function(data){
				 //点击修改按钮时获取id
				 var id = data.val().split(',,')[0];
				 var name = data.val().split(',,')[1];
			     //多窗口模式，层叠置顶
			     layer.open({
			         type: 2, 
			         title: name+'拒看商家',
			         area: ['900px', '400px'],
			         shade: 0.5,
			         content: '/admin/delivery/selectSeller?id='+id,
			         zIndex: layer.zIndex, //重点1
			         success: function(layero){
			         }
			     });
			 }
			 
		  };
	   $('.site-demo-button .layui-btn').on('click', function(){
	       var othis = $(this), method = othis.data('method');
	       active[method] ? active[method].call(this, othis) : '';
	   });
	});
   
  //任务分配;
  function Tasking(id){
   if(id == '' || id == undefined || id == null){
	   alert("参数为空，稍后再试！");
	   return;
   }
	//询问框
    layer.msg('选择订单', {
       time: 0 //不自动关闭
      ,icon: 6
      ,btn: ['未分配','已分配','历史','退出']
    ,btn1: function(index){
        layer.close(index);
        window.location.href="/admin/orderInfo/toTasking?id="+id+'&status=0';//-1历史订单,0未分配, 1,已分配,
      }
    ,btn2: function(index){
        layer.close(index);
        window.location.href="/admin/orderInfo/toTasking?id="+id+'&status=1';//-1历史订单,0未分配, 1,已分配,
      }
    ,btn3: function(index){
        layer.close(index);
        window.location.href="/admin/orderInfo/toTasking?id="+id+'&status=-1';//-1历史订单,0未分配, 1,已分配,
      }
    ,btn4: function(index){
        layer.close(index);
      }
    });
	
	
}
  //分配区域
  function distributeArea(id,areaId){
	  layer.open({
	         type: 2, 
	         title: '分配配送区域',
	         area: ['750px', '280px'],
	         shade: 0.5,
	         content: '/admin/delivery/toDistribute?deliveryId='+id+"&areaId="+areaId,
	         zIndex: layer.zIndex, //重点1
	         success: function(layero, index){
	        	 layer.setTop(layero);
	        	 var body = layer.getChildFrame('body', index);
	             var iframeWin = window[layero.find('iframe')[0]['name']]; 
	             body.find('input[name="id"]').val(id);
	        	
	         }
	     });
  }
  function Runing(deliveryId){
	  location.href="/admin/delivery/runing?deliveryId="+deliveryId;
  }
</script>
</body>
</html>