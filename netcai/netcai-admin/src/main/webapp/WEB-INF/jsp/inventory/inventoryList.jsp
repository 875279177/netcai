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
    #areaTree{
      width:400px;
      height:500px
    }
    .layui-form-label{
      width:100px;
    }
    .layui-input-block{
      width:auto;
      height:auto;
      position:relative;
	  left:800px;
    }
    .table th{
      background:#ffffff;
    }
	.table tr:nth-child(odd){
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
  <!-- 系统清单start -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>系统清单管理</h1>
    </section>
    <!-- Main content -->
    <shiro:hasPermission name="inventory:query">
	    <section class="content">
	      <div class="row">
	        <div class="col-xs-12">
	          <div class="box">
				   <!-- tree start -->
				   <div style="float: left;width: 25%;height: 500px;">
					 <table id="areaTree" title="区域列表" >
				        <thead>
				            <tr>
				                <th data-options="field:'areaName'" width="220">区域选择：</th>
				            </tr>
				        </thead>
				     </table>
				   </div>
				   <!-- tree end -->
				   <!-- table start -->
				   <div style="float: left;width: 73%;height: 100%; ">
			         <div class="box box-info">
			           <form  id="form_submit" class="form-horizontal" action="/admin/inventory/list">
			             <input type="hidden" name="pageNum" id="pageNum" value="${paginator.currentPage}">
	                     <input type="hidden" name="pageSize" id="pageSize" value="${paginator.pageRecord}">
			             <div class="box-body">
			               <div class="form-group">
							 <label for="regionId" class="col-sm-2 control-label">区域：</label>
							 <div class="col-xs-2">
							   <select id="regionId" name="regionId" class="form-control" style="width:150px;">
								 <option value="" >全部</option>
								 <c:forEach items="${areaList }" var="r">
								   <option value="${r.id}" <c:if test="${r.id==inventory.regionId }">selected</c:if> >${r.areaName }</option>
								 </c:forEach>
							   </select>
							 </div>
							 <label for="buyerTypeId" class="col-sm-2 control-label">餐厅类型：</label>
							 <div class="col-xs-2">
							   <select id="buyerTypeId" name="buyerTypeId" class="form-control" style="width:150px;">
								 <option value="" >全部</option>
								 <c:forEach items="${buyerTypeList }" var="r">
								   <option value="${r.id}" <c:if test="${r.id==inventory.buyerTypeId }">selected</c:if> >${r.name }</option>
								 </c:forEach>
							   </select>
							 </div>
			               </div>
			               <div class="form-footer" >
				             <button type="submit" class="btn btn-info pull-left btn-select">查询</button>
				             <button type="reset" class="btn btn-info pull-left" onclick="clearSearch()">重置</button>
				           </div>
			             </div>
			           </form>
			           <div class="box-body">
		                 <table id="example1" class="table table-bordered table-striped">
		                   <div class="site-demo-button" >
						     <button data-method="setTop" id="add_btn" value="" class="layui-btn layui-btn-primary layui-btn-small"><i class="layui-icon"></i><span>&nbsp;&nbsp;新增</span></button>
						   </div>
		                   <thead>
			                 <tr>
			                   <th>区域</th>
			                   <th>餐厅类型</th>
			                   <th>商铺名称</th>
			                   <th>商品名称</th>
			                   <th>创建时间</th>
			                   <th>操作</th>
			                 </tr>
		                   </thead>
		                   <tbody>
		                     <c:forEach items="${paginator.object}" var="r"> 
			   			       <tr>
			   			         <td>${r.regionName}</td>
					             <td>${r.buyerTypeName}</td>
					             <td>${r.sellerName}</td>
					             <td>${r.goodsName}</td>
				                 <td><fmt:formatDate value="${r.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						         <td>
						           <div class="site-demo-button" >
	<%-- 							   <button data-method="setTop" value="${r.id }" class="layui-btn layui-btn-normal layui-btn-small"><i class="layui-icon"></i><span>&nbsp;&nbsp;修改</span></button> --%>
								     <button data-method="offset" value="${r.id }" class="layui-btn layui-btn-danger layui-btn-small"><i class="layui-icon"></i><span>&nbsp;&nbsp;删除</span></button>
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
	        </div>
	      </div>
	    </section>
    </shiro:hasPermission>
  </div>
<script src="/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="/bootstrap/js/bootstrap.min.js"></script>
<script src="/js/jquery-ui.min.js"></script>
<script src="/layui/layui.js"></script>
<script src="/dist/js/app.min.js"></script>
<script type="text/javascript" src="/jquery-easyui-1.5.2/jquery.easyui.min.js" charset="utf-8"></script>
<script type="text/javascript" src="/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<script type="text/javascript" charset="utf-8">
$(document).ready(function () {
	//加载商品分类树
	$('#areaTree').treegrid({
	    url:'<%=request.getContextPath()%>/admin/inventory/tree',
	    method:'get',          //请求方式
	    idField:'id',           //定义标识树节点的键名字段
	    treeField:'areaName',       //定义树节点的字段
	    fit:true,               //网格自动撑满
	    fitColumns:true,
	    onClickRow:function(row){
	    	$("#add_btn").val(row.id+","+row.areaName);
		}
	    
	});
});

//重置
function clearSearch(){
	window.location.href="<%=request.getContextPath()%>/admin/inventory/list";
}

//当前页码查询数据
function onSelectPage(currentPage,pageSize){  
	$('#pageNum').val(currentPage);
	$('#pageSize').val(pageSize);
	$('#form_submit').submit();
} 
//新增数据弹窗
layui.use(['layer','jquery','form','element'], function(){ //独立版的layer无需执行这一句
	  var $ = layui.jquery,form = layui.form(),layer = layui.layer,
	      layedit = layui.layedit,laydate = layui.laydate;
	   //触发事件
	   var active = {
			 setTop: function(data){
				 var id = '',region = '';
				 var type = data.text();
				 if(type.indexOf("修改")!=-1){
					 //获取id
			       	 id = data.val();
				 }else if((type.indexOf("新增")!=-1)){
					 //获取区域id和名称
					 region = data.val();
					 if(region==null || region==''){
						 layer.msg("请选择区域",{icon: 2,time: 1500});
						 return false;
					 }
				 }
			     //多窗口模式，层叠置顶
			     layer.open({
			         type: 2, 
			         title: '新增/修改清单信息',
			         area: ['1200px', '608px'],
			         shade: 0.5,
			         anim: 3,//0-6的动画形式，-1不开启
			         content: '/admin/inventory/addInventory?id='+id,
			         zIndex: layer.zIndex, //重点1
			         success: function(layero, index){
			        	 layer.setTop(layero);
			        	 var body = layer.getChildFrame('body', index);
			             var iframeWin = window[layero.find('iframe')[0]['name']];
			             //获取选中的区域id和名称
			             var regions = region.split(",");
			             body.find('p').text(regions[1]);
			             body.find('input[name="regionId"]').val(regions[0]);
			             //弹窗表单的取消操作时关闭弹窗
			             var canclebtn=body.find('button[name="cancleSubmit"]').click(function cancleSubmit(){
			            	 layer.closeAll();
			             });
			         }
			     });
			 },
			 //删除操作
		     offset: function(othis){
		         var type = othis.data('type');
        		 text = "确定要删除此条数据吗？";
		         layer.open({
		             type: 1,
		             offset: type, 
		             id: 'LAY_demo'+type, //防止重复弹出
		             content: '<div style="padding: 20px 100px;">'+ text +'</div>',
		             btn: ['确定', '取消'],
		             btnAlign: 'c', //按钮居中
		             shade: 0.5 ,//不显示遮罩
		             yes: function(){
			        	 layer.closeAll();
			        	 var id = othis.val();
			             $.ajax({
			            	 type: "POST",
			                 url: "<%=request.getContextPath()%>/admin/inventory/delete",
			                 data: {"id":id},
			                 dataType: "json",
			                 cache:false,
			                 success: function(data){
			                	 var code = data.code;
			                	 var msg = data.message;
			                	 if(code == "200"){
			                		 layer.msg(msg, {icon: 1,time: 3000});
			                		 //刷新页面
			                		 window.location.href="<%=request.getContextPath() %>/admin/inventory/list";
			                	 }
			                 },
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