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
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>买家与卖家绑定</h1>
    </section>
    <!-- Main content -->
    <shiro:hasPermission name="buyerSellerRelation:query">
	   <section class="content">
	     <div class="row">
	       <div class="col-xs-12">
	         <div class="box">
	           <div class="box-header">
	             <h3 class="box-title">买家与卖家绑定列表</h3>
	           </div>
	           <div class="box box-info">
	           <form  id="form_submit" action="/admin/buyerSellerRelation/list" method="post" class="form-horizontal">
	             <input type="hidden" name="pageNum" id="pageNum" value="${paginator.currentPage}">
	             <input type="hidden" name="pageSize" id="pageSize" value="${paginator.pageRecord}">
	             <div class="box-body">
	               <div class="form-group">
	                 <label for="buyerName" class="col-sm-2 control-label">买家信息：</label>
	                   <div class="col-xs-2">
	                    <input type="text" class="form-control input-small" id="buyerName" name="buyer.buyerName" value="${buyerSellerRelation.buyer.buyerName}" placeholder="请输入买家信息">
	                </div>
	                <label for="sellerName" class="col-sm-2 control-label">卖家信息：</label>
	                   <div class="col-xs-2">
	                	<input type="text" class="form-control input-small" id="sellerName" name="seller.sellerName" value="${buyerSellerRelation.seller.sellerName}" placeholder="请输入卖家信息">
	                </div>
	               </div>
	               <div class="form-footer" >
	                 <button type="submit" class="btn btn-info pull-left btn-select">查询</button>
	                 <button type="reset" id="reset" class="btn btn-info pull-left">重置</button>
	               </div>
	             </div>
	           </form>
	        </div>
	        
	        <div class="row">
			    <div class="col-sm-12">
				    <div class="pull-left">
					    <button type="button" class="btn btn-primary" id="add" data-complete-text="Loading finished" >新增绑定</button>
				    </div>
			    </div>
			</div>
			
			
	           <!-- /.box-header -->
	           <div class="layui-form" >
	             <table class="layui-table" lay-skin="row">
	               <thead>
	              <tr>
	                <th>所在区域</th>
	                <th>买家店铺名称</th>
	                <th>买家联系方式</th>
	                <th>卖家店铺名称</th>
	                <th>卖家联系方式</th>
	                <th>创建时间</th>
	                <th>操作</th>
	              </tr>
	               </thead>
	               <tbody>
	               <c:forEach items="${paginator.object}" var="r"> 
		   			 <tr>
				       <td>${r.areaName}</td>
				       <td>${r.buyer.buyerName}</td>
				       <td>${r.buyer.bossTel}</td>
				       <td>${r.seller.sellerName}</td>
				       <td>${r.seller.sellerAccount}</td>
				       <td><fmt:formatDate value="${r.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				       <td>
			  			  <a href="#" onclick="del(${r.id})" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i>解绑</a>
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
<script type="text/javascript" src="/js/jquery-1.9.1.min.js"></script>
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
function onSelectPage(currentPage,pageSize){  
	$('#pageNum').val(currentPage);
	$('#pageSize').val(pageSize);
	$('#form_submit').submit();
}  

//重置
$(function(){
	$("#reset").click(function(){
		window.location.href="/admin/buyerSellerRelation/list";
	});
});
layui.use(['form', 'layedit', 'laydate'], function(){
	   var form = layui.form(),layer = layui.layer,layedit = layui.layedit,laydate = layui.laydate;
	   $ = layui.jquery;
});

//绑定新增;
$(function() { 
    $("#add").click(function(){
    	window.location.href="/admin/buyer/list";
    })
})

//删除
function del(id) {
    layer.msg('确定解绑?', {
       time: 0 //不自动关闭
      ,icon: 5
      ,btn: ['确定','取消']
    ,btn1: function(index){
        	  $.ajax({  
		            url:'/admin/buyerSellerRelation/delete?id='+id,
		            dataType:"json",  
		            success: function (data) {
		  			  var msg = data.message;
		  			  if(data.code==200||data.code==201){
		  			  alert(msg);
		  			  window.location.reload();
		  			  }else{
		  				  alert("删除失败！");
		  			  }
		  		  } 
		        });
      }
    ,btn2: function(index){
        layer.close(index);
      }
    });
}
</script>
</body>
</html>