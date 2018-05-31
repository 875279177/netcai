<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="pv" uri="/pageTaglib"%>  
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%> 
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title></title>
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- 引入公共部分jsp文件 -->
  <meta name="decorator" content="default"/>
  <!--[if lt IE 9]>
  <script src="/js/html5shiv.min.js"></script>
  <script src="/js/respond.min.js"></script>
  <![endif]-->
  <style type="text/css">
    .layui-form-label{
      width:100px;
    }
    
    .layui-input-block{
      width:auto;
      height:auto;
      position:relative;
	  left:800px;
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
	
  </style>
</head>
<body class="hold-transition skin-blue sidebar-mini">
  <!-- 账单周期配置列表start -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) --> 
    <section class="content-header">
      <h1>账单周期配置管理</h1>
    </section>
    <!-- Main content -->
    <shiro:hasPermission name="billSellerConfig:query">
	    <section class="content">
	      <div class="row">
	        <div class="col-xs-12">
	          <div class="box">
	            <div class="box-header">
	              <h3 class="box-title">账单周期配置 </h3>
	            </div>
		        <div class="box box-info">
		           <!-- form start -->
		           <form  id="form_submit" action="<%=request.getContextPath()%>/admin/billSellerConfig/list" class="form-horizontal">
		             <div class="box-body">
		               <div class="form-group">
		                 <input type="hidden" name="pageNum" id="pageNum" value="${paginator.currentPage}">
	                     <input type="hidden" name="pageSize" id="pageSize" value="${paginator.pageRecord}">
		                 <label for="userName" class="col-sm-2 control-label">卖家商铺名称：</label>
		                 <div class="col-xs-2">
		                   <input type="text" class="form-control" id="sellerName" name="sellerName" value="${billSellerConfig.sellerName}" placeholder="请输入店铺名称">
		                 </div>
		                 <label for="regionId" class="col-sm-2 control-label">区域：</label>
						 <div class="col-xs-2">
						   <select id="regionId" name="regionId" class="form-control" style="width:150px;">
						     <option value="">全部</option>
							 <c:forEach items="${areaList}" var="r"> 
							     <option value="${r.id }" <c:if test="${r.id==billSellerConfig.regionId}">selected</c:if> >${r.areaName }</option>
							 </c:forEach>
						   </select>
						 </div>
						 <label for="status" class="col-sm-2 control-label">状态：</label>
						 <div class="col-xs-2">
						   <select id="status" name="status" class="form-control" style="width:150px;">
							 <option value="" >全部</option>
							 <option value="1" <c:if test="${billSellerConfig.status==1}">selected</c:if> >启用</option>
							 <option value="-1" <c:if test="${billSellerConfig.status==1}">selected</c:if>>禁用</option>
						   </select>
						 </div>
		               </div>
		               <div class="box-footer">
		                 <button type="submit" class="btn btn-info ">查询</button>
		                 <button type="reset" id="reset" class="btn btn-info ">重置</button>
		               </div>
		             </div>
		           </form>
		           <!-- form end -->
		        </div>
				<!-- 表格列表start -->
	            <div class="box">
		           <div class="box-body">
		             <div class="site-demo-button" >
					   <button data-method="setTop" id="addUser" class="layui-btn layui-btn-small"><i class="layui-icon"></i><span>&nbsp;&nbsp;新增</span></button>
					 </div>
		             <table id="example1" class="table table-bordered table-striped">
		               <thead>
			             <tr>
			                <th>区域名称</th>
			                <th>卖家商铺名称</th>
			                <th>手机号</th>
			                <th>结算周期(天)</th>
			                <th>状态</th>
			                <th>创建时间</th>
			                <th>操作</th>
			              </tr>
			           </thead>
		               <tbody>
			             <c:forEach items="${paginator.object}" var="r"> 
				   			<tr>
				   			  <td>${r.regionName}</td>
						      <td>${r.sellerName}</td>
						      <td>${r.phone}</td>
						      <td>${r.period}</td>
						      <td>
						        <c:if test="${r.status==1 }">启用</c:if>
						        <c:if test="${r.status==-1 }">禁用</c:if>
						      </td>
						      <td><fmt:formatDate value="${r.createTime }" pattern="yyyy-MM-dd"/></td>
						      <td>
						        <div class="site-demo-button" >
								  <button data-method="offset" value="${r.id }" class="layui-btn layui-btn-normal layui-btn-small" ><i class="layui-icon"></i><span>&nbsp;&nbsp;修改</span></button>
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
		        </div>
	            <!-- 表格列表end -->
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
<script src="/layer/layer.js"></script>
<script src="/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript">
function onSelectPage(currentPage,pageSize)
{  
	$('#pageNum').val(currentPage);
	$('#pageSize').val(pageSize);
	$('#form_submit').submit();
}  
</script>
<script type="text/javascript">
//重置
$("#reset").click(function(){
    window.location.href="/admin/billSellerConfig/list";
});


//新增数据弹窗
layui.use(['layer','form'], function(){ //独立版的layer无需执行这一句
var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句  
//触发事件
var active = {
		 setTop: function(data){
			 //获取id
	       	 var id = data.val();
		     //多窗口模式，层叠置顶
		     layer.open({
		         type: 2, 
		         title: '新增/修改系统用户信息',
		         area: ['760px', '325px'],
		         shade: 0.5,
		         anim: 3,//0-6的动画形式，-1不开启
		         content: '/admin/billSellerConfig/addBillSeller?id='+id,
		         zIndex: layer.zIndex, //重点1
		         success: function(layero, index){
		        	 layer.setTop(layero);
		        	 var body = layer.getChildFrame('body', index);
		             var iframeWin = window[layero.find('iframe')[0]['name']]; 
			       	 //更新数据时将id存入input中
			       	 body.find('input[name="id"]').val(id);
		         }
		     });
		 },
		 //启用和禁用数据弹窗
	     offset: function(othis){
	         var type = othis.data('type');
	         var text=othis.text();
	         var html;
	         if(text.indexOf("禁用")!=-1){
        		 //禁用的url
        		 requestUrl="<%=request.getContextPath()%>/admin/billSellerConfig/disabled";
        		 html = "确定要禁用此条数据吗？";
        	 }else if(text.indexOf("启用")!=-1){
        		//启用的url
        		 requestUrl="<%=request.getContextPath()%>/admin/billSellerConfig/enabled";
        		 html = "确定要启用此条数据吗？";
        	 }else if(text.indexOf("修改")!=-1){
	        	 title = "修改抽点率";
	        	 requestUrl = "<%=request.getContextPath()%>/admin/billSellerConfig/update";
	        	 html = '<span>账单周期：</span><input type="text" id="period" style="margin-top:10px;margin-left:5px;width:175px;height:30px;" >';
	         }
	         layer.open({
	             type: 1,
	             offset: type, 
	             id: 'LAY_demo'+type, //防止重复弹出
	             content: '<div style="padding: 20px 50px;">'+ html +'</div>',
	             btn: ['确定', '取消'],
	             btnAlign: 'c', //按钮居中
	             shade: 0.5 ,//不显示遮罩
	             yes: function(){
		        	 layer.closeAll();
		        	 var id = othis.val();
		        	 if(text.indexOf("修改")!=-1){
	            		 var period = $("#period").val();
			        	 if(period==null || period==""){
			        		 alert("请输入账单周期");
			        		 return false;
			        	 } 
	            	 }
		             $.ajax({
		            	 type: "POST",
		                 url: requestUrl,
		                 data: {"id":id,"period":period},
		                 dataType: "json",
		                 cache:false,
		                 success: function(data){
		                	 var code = data.code;
		                	 var msg = data.message;
		                	 layer.msg(msg, {icon: 1});
		                	 //刷新页面
	                		 window.location.href="<%=request.getContextPath()%>/admin/billSellerConfig/list";
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