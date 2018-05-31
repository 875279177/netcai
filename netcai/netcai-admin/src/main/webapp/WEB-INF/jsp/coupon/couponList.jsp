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
  <!-- 广告信息列表start -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) --> 
    <section class="content-header">
      <h1>优惠券信息管理</h1>
    </section>
    <!-- Main content -->
    <shiro:hasPermission name="coupon:query">
	   <section class="content">
	     <div class="row">
	       <div class="col-xs-12">
	         <div class="box">
	           <div class="box-header">
	             <h3 class="box-title">优惠券信息列表 </h3>
	           </div>
	        <div class="box box-info">
	           <!-- form start -->
	           <form  id="form_submit" class="form-horizontal" action="/admin/coupon/list">
	             <input type="hidden" name="pageNum" id="pageNum" value="${paginator.currentPage}">
	             <input type="hidden" name="pageSize" id="pageSize" value="${paginator.pageRecord}">
	               <div class="col-sm-12" style="top: 20px">
		               <div class="form-group">
		                 <label for="title" class="col-sm-1 control-label">名称：</label>
		                 <div class="col-sm-3">
		                   <input type="text" class="form-control" id="name" name="name" value="${coupon.name}" placeholder="请输入优惠券名称">
		                 </div>
	                         <label for="areaId" class="col-sm-1 control-label">区域：</label>
		                 <div class="col-sm-3">
		                   <select id="areaId" name="areaId" class="form-control" >
							   <option value="" >全部</option>
						   </select>
		                 </div>
						 <label for="status" class="col-sm-1 control-label">状态</label>
						 <div class="col-sm-3">
						   <select id="status" name="status" class="form-control" >
							 <option value="" selected>全部</option>
							 <option value="0" <c:if test="${coupon.status == 0}">selected</c:if>>未开始</option>
							 <option value="1" <c:if test="${coupon.status == 1}">selected</c:if>>进行中</option>
							 <option value="-1" <c:if test="${coupon.status == -1}">selected</c:if>>结束</option>
						   </select>
						 </div>
		               </div>
	               </div>
	               
	               <div class="box-footer" style="top: 100px">
	                 <button type="submit" class="btn btn-info">查询</button>
	                 <button type="reset"  id="reset" class="btn btn-info">重置</button>
	               </div>
	           </form>
	           <!-- form end -->
	        </div>
			<!-- 表格列表start -->
	           <div class="box">
	           <div class="box-body">
	             <div class="site-demo-button" >
				   <button onclick="add()" class="btn btn-success btn-xs"><i class="layui-icon"></i><span>&nbsp;&nbsp;新增</span></button>
				 </div>
	             <table id="example1" class="table table-bordered table-striped">
	               <thead>
		              <tr>
		                <th>所属区域</th>
		                <th>类型</th>
		                <th>名称</th>
		                <th>期限</th>
		                <th>优惠券金额</th>
		                <th>状态</th>
		                <th>创建时间</th>
		                <th>操作</th>
		              </tr>
	               </thead>
	               <tbody>
	               <c:forEach items="${paginator.object}" var="r"> 
		   			 <tr>
				       <td>${r.areaName}</td>
				       <td>
				      	 <c:if test="${r.type==1 }">满减</c:if>
				      </td>
				       <td>${r.name}</td>
				       <td><fmt:formatDate value="${r.startTime }" pattern="yyyy-MM-dd"/>——<fmt:formatDate value="${r.endTime }" pattern="yyyy-MM-dd"/></td>
				       <td>${r.money}</td>
				       <td>
				         <c:if test="${r.status==1 }">进行中</c:if>
				         <c:if test="${r.status==0 }">未开始</c:if>
				         <c:if test="${r.status==-1 }">结束</c:if>
				       </td>
			           <td><fmt:formatDate value="${r.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				       <td>
				         <div class="site-demo-button" >
						   <c:choose>
						     <c:when test="${r.status==1}">
						       <button onclick="update(${r.id },-1)" name="1" value="${r.id }" class="layui-btn layui-btn-warm layui-btn-small"><i class="layui-icon"></i><span>&nbsp;&nbsp;结束</span></button>
						     </c:when>
						     <c:otherwise>
						       <button onclick="update(${r.id },1)" name="-1" value="${r.id }" class="layui-btn layui-btn-warm layui-btn-small"><i class="layui-icon"></i><span>&nbsp;&nbsp;开启</span></button>
						     </c:otherwise>
						   </c:choose>
						   <%-- <button data-method="offset" value="${r.id }" class="layui-btn layui-btn-danger layui-btn-small"><i class="layui-icon"></i><span>&nbsp;&nbsp;删除</span></button> --%>
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
  <input type="hidden" id="areaIdVO" value="${coupon.areaId}"/>
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

//重置
$(function(){
   $("#reset").click(function(){
	   window.location.href="/admin/coupon/list";
   });
  });
</script>
<script>
   //新增数据弹窗
   layui.use(['layer','jquery','form','element'], function(){ //独立版的layer无需执行这一句
	   var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句  
	   //触发事件
	   $('.site-demo-button .layui-btn').on('click', function(){
	       var othis = $(this), method = othis.data('method');
	       active[method] ? active[method].call(this, othis) : '';
	   });
	});
   
//开启结束;
function update(id,statu){
	  $.ajax({
		  type: 'post',
		  url: '/admin/coupon/updateStatus?id='+id+"&status="+statu,
		  dataType: 'json',
		  success: function (data) {
			  var msg = data.message;
			  if(data.code==200||data.code==201){
			  alert(msg);
			  window.location.reload();
			  }else{
				  alert("更新失败！");
			  }
		  }
	  });
}
   
//新增;
 function add(){
 	layer.open({
         type: 2, 
         title: '新增',
         area: ['900px', '800px'],
         shade: 0.5,
         content: '/admin/coupon/toAdd',
         zIndex: layer.zIndex, //重点1
         cache: false,
       });
 }
   
   
 //获取区域信息;
   $(document).ready(function(){ 
   	loadregion(); 
   	}); 
   	
   var areaId = $('#areaIdVO').val();
   function loadregion(){
   	if(areaId == null || areaId == '' ||areaId == undefined){
   		areaId = 0;
   	}
   	  var url='/admin/region/Alllist'; 
   	  jQuery.ajax({ 
   	    type:'post', 
   	    url:url, 
   	    async:false,
   	    success:function (date){
      	   var list = date.object;  
            if(list != null && list.length > 0){
                for(var i = 0; i< list.length; i++){
                    if(list[i].id == areaId){
                 	   $("<option value='"+list[i].id+"' selected>"+list[i].areaName+"</option>").appendTo("#areaId");
                    }else {
                    $("<option value='"+list[i].id+"'>"+list[i].areaName+"</option>").appendTo("#areaId");  
   				}
                }  
            } 
   	    } 
   	  }); 
   	}
</script>
</body>
</html>