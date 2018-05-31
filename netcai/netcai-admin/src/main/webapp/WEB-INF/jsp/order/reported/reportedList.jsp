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
	.layui-form-label {
		width: 100px;
	}
	
	.layui-input-block {
		width: auto;
		height: auto;
	}
	
	table th {
		background: #ffffff;
	}
	
	table tr:nth-child(odd) {
		background: #F0F0F0;
	}
	
	.col-sm-2 {
		width: 10%;
	}
	
	.form-footer {
		margin-right: 800px;
		float: right;
	}
	
	.btn-select {
		margin-right: 10px;
	}
  </style>
</head>
<body class="hold-transition skin-blue sidebar-mini">
  <!-- 广告信息列表start -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) --> 
    <section class="content-header">
      <h1>报备信息管理</h1>
    </section>
    <!-- Main content -->
    <shiro:hasPermission name="reported:query">
	    <section class="content">
	      <div class="row">
	        <div class="col-xs-12">
	          <div class="box">
	            <div class="box-header">
	              <h3 class="box-title">报备信息列表 </h3>
	            </div>
		        <div class="box box-info" >
		           <!-- form start -->
		           <form  id="form_submit" class="form-horizontal layui-form" action="/admin/reported/list">
		             <input type="hidden" name="pageNum" id="pageNum" value="${paginator.currentPage}">
	              <input type="hidden" name="pageSize" id="pageSize" value="${paginator.pageRecord}">
		              <div class="box-body">
		               <div class="col-sm-12">
			               <div class="form-group">
			                 <label for="title" class="col-sm-1 control-label">商品名称</label>
			                 <div class="col-xs-3" >
			                   <input type="text" class="form-control" id="goodsName" name="goodsName" value="${reported.goodsName}" placeholder="请输入商品名称">
			                 </div>
	                          <label for="sellerName" class="col-sm-1 control-label">卖家信息</label>
			                 <div class="col-xs-3" >
			                   <input type="text" class="form-control" id="sellerName" name="sellerName" value="${reported.sellerName}" placeholder="请输入卖家信息">
			                 </div>
			                 <label for="buyerName" class="col-sm-1 control-label">买家信息</label>
			                 <div class="col-xs-3">
			                   <input type="text" class="form-control" id="buyerName" name="buyerName" value="${reported.buyerName}" placeholder="请输入买家信息">
			                 </div>
			               </div>
			               </div>
			               <div class="col-sm-12">
			               <div class="form-group">
			                 <label for="queryTime" class="col-sm-1 control-label">报备时间</label>
			                 <div class="col-xs-3">
			                   <input type="date" class="form-control" id="queryTime" name="queryTime" value="${reported.queryTime}" placeholder="选择时间" >
			                 </div>
			                 <label for="saleId" class="col-sm-1 control-label">销售姓名</label>
			                 <div class="col-xs-3">
			                   <select id="saleId" name="saleId" class="form-control" >
								   <option value="" >全部</option>
							   </select>
			                 </div>
			                 <label for="deliveryId" class="col-sm-1 control-label">物流人员</label>
				              <div class="col-xs-3" >
				                <select id="deliveryId" name="deliveryId" class="form-control" >
								  <option value="" >全部</option>
								</select>
				              </div>
			               </div>
		               </div>
		               <div class="col-sm-12">
			               <div class="form-group">
	                           <label for="areaId" class="col-sm-1 control-label">区域：</label>
			                 <div class="col-xs-3" >
			                   <select id="areaId" name="areaId" class="form-control" >
								   <option value="" >全部</option>
							   </select>
			                 </div>
			                 <label for="rType" class="col-sm-1 control-label">类型</label>
							 <div class="col-xs-3" >
							   <select id="rType" name="rTypes" class="form-control" multiple="multiple">
								 <option value="" selected>全部</option>
								 <option value="1" <c:forEach items="${rTypes}" var="rType"><c:if test="${fn:contains(rTypes,1)}">selected</c:if></c:forEach>>缺货</option>
								 <option value="2" <c:forEach items="${rTypes}" var="rType"><c:if test="${fn:contains(rTypes,2)}">selected</c:if></c:forEach>>补货</option>
								 <option value="3" <c:forEach items="${rTypes}" var="rType"><c:if test="${fn:contains(rTypes,3)}">selected</c:if></c:forEach>>退货</option>
								 <option value="4" <c:forEach items="${rTypes}" var="rType"><c:if test="${fn:contains(rTypes,4)}">selected</c:if></c:forEach>>换货</option>
							   </select>
							 </div>
							 <label for="payStatus" class="col-sm-1 control-label">付款类型</label>
							 <div class="col-xs-3">
							   <select id="payStatus" name="payStatus" class="form-control" >
								 <option value="" selected>全部</option>
								 <option value="2" <c:if test="${reported.payStatus == 2}">selected</c:if>>已付款</option>
								 <option value="3" <c:if test="${reported.payStatus == 3}">selected</c:if>>线下付款</option>
							   </select>
							 </div>
			               </div>
		               </div>
		               <div class="form-footer">
							<button type="submit" class="btn btn-info pull-left" onclick="submit()">提交</button>
				            <button type="reset" id="reset" class="btn btn-info pull-left" style="margin-left:6px;">重置</button>
						</div>
					</div>
		           </form>
		           <!-- form end -->
		        </div>
		        <div class="row">
				    <div class="col-sm-12">
					    <div class="pull-left">
						    <button type="button" class="btn btn-primary" id="export" data-complete-text="Loading finished" >导出</button>
					    </div>
				    </div>
				</div>
				<!-- 表格列表start -->
	            <div class="box">
		           <div class="box-body">
		             <table id="example1" class="table table-bordered table-striped">
		               <thead>
			              <tr>
			                <th>区域</th>
			                <th>商品名称</th>
			                <th>买家店铺</th>
			                <th>卖家店铺</th>
			                <th>销售</th>
			                <th>配送人员</th>
			                <th>单价</th>
			                <th>金额</th>
			                <th>数量</th>
			                <th>规格名称</th>
			                <th>订单创建时间</th>
			                <th>送货时间</th>
			                <th>付款状态</th>
			                <th>来源</th>
			                <th>报备人员</th>
			                <th style="width: 200px">报备内容</th>
			                <th>类型</th>
			                <th>报备时间</th>
			                <th style="width: 240px">操作</th>
			              </tr>
		               </thead>
		               <tbody>
		               <c:forEach items="${paginator.object}" var="r"> 
			   			 <tr>
					       <td>${r.areaName}</td>
					       <td>${r.goodsName}</td>
					       <td>${r.buyerName}</td>
					       <td>${r.sellerName}</td>
					       <td>${r.realName}</td>
					       <td>${r.deliveryName}</td>
					       <td>${r.goodsPrice}</td>
					       <td>${r.goodsAmount}</td>
					       <td>${r.goodsNumber}</td>
					       <td>${r.formatName}</td>
					       <td><fmt:formatDate value="${r.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					       <td><fmt:formatDate value="${r.bestTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					       <td>
					         <c:if test="${r.payStatus==1 }">未付款</c:if>
					         <c:if test="${r.payStatus==2 }">已付款</c:if>
					         <c:if test="${r.payStatus==3 }">线下付款</c:if>
					         <c:if test="${r.payStatus==4 }">线下付款已收款</c:if>
					       </td>
					       <td>
					         <c:if test="${r.rFrom==1 }">配送端</c:if>
					         <c:if test="${r.rFrom==2 }">销售端</c:if>
					         <c:if test="${r.rFrom==3 }">后台</c:if>
					         <c:if test="${r.rFrom==4 }">卖家</c:if>
					         <c:if test="${r.rFrom==5 }">采购端</c:if>
					       </td>
					       <td>${r.name}</td>
					       <td>${r.rContent}</td>
					       <td>
					         <c:if test="${r.rType==1 }">缺货</c:if>
					         <c:if test="${r.rType==2 }">补货</c:if>
					         <c:if test="${r.rType==3 }">退货</c:if>
					         <c:if test="${r.rType==4 }">换货</c:if>
					       </td>
				           <td><fmt:formatDate value="${r.rTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					       <td>
					         <div class="site-demo-button" >
					         	<c:if test="${r.rReadStatus !=2}">
							       <button onclick="updateReadStatus(${r.rId },2)" name="2" value="${r.rId }" class="layui-btn layui-btn-warm layui-btn-small"><span>&nbsp;&nbsp;待读</span></button>
					         	</c:if>
					         	<c:if test="${r.rSolveStatus !=2}">
							       <button onclick="updateSolveStatus(${r.rId },2)" name="2" value="${r.rId }" class="layui-btn layui-btn-warm layui-btn-small"><span>&nbsp;&nbsp;待处理</span></button>
					         	</c:if>
							       <button onclick="getList(${r.rItemId })" class="layui-btn layui-btn-danger layui-btn-small"><span>&nbsp;&nbsp;时间轴</span></button>
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
<input type="hidden" id="areaIdVO" value="${reported.areaId}"/>
<input type="hidden" id="saleIdVO" value="${reported.saleId}"/>
<input type="hidden" id="deliveryIdVO" value="${reported.deliveryId}"/>
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
<script src="/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script src="/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="/plugins/fastclick/fastclick.js"></script>
<script src="/dist/js/app.min.js"></script>
<script src="/dist/js/demo.js"></script>
<script src="/js/jquery-ui.min.js"></script>
<script src="/layui/layui.js" charset="utf-8"></script>
<script src="/bootstrap/js/layui-mz-min.js" charset="utf-8"></script>
<script charset="utf-8" src="/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
function onSelectPage(currentPage,pageSize)
{  
	$('#pageNum').val(currentPage);
	$('#pageSize').val(pageSize);
	$('#form_submit').submit();
} 

//保存、修改数据
function submit(){
	  $('#form_submit').validate({ 		
			submitHandler: function (form) {
				$('#form_submit').submit();
			}
		});
}

//重置
$(function(){
   $("#reset").click(function(){
	   window.location.href="/admin/reported/list";
   });
  });
</script>
<script>
layui.use(['form', 'layedit', 'laydate'], function(){
	   var form = layui.form(),layer = layui.layer,layedit = layui.layedit,laydate = layui.laydate;
	   $ = layui.jquery;
	   layui.selMeltiple($);
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
   
   
   
//阅读状态
function updateReadStatus(id,statu){
	//询问框
    layer.msg('确定已阅读？', {
       time: 0 //不自动关闭
      ,icon: 6
      ,btn: ['确定','退出']
    ,btn1: function(index){
	  $.ajax({
		  type: 'post',
		  url: '/admin/reported/updateReadStatus?id='+id+"&rReadStatus="+statu,
		  dataType: 'json',
		  success: function (data) {
			  var code = data.code;
	          	if(code =='200'){
	          	layer.msg("操作成功", {icon: 6});
	          	location.reload();
	          	}else{
				  alert("更新失败！");
			  }
		  }
	  });
    }
    ,btn2: function(index){
        layer.close(index);
      }
    });
}

/* 查看时间轴 */
function getList(id) {
    layer.open({
        type: 2,
        title: '操作详情',
        shade: 0.5,
        area: ['900px', '600px'],
        content: "/admin/orderTimeline/getList?itemId="+id,
        zIndex: layer.zIndex, //重点1
        cache:false,
	    }); 
}

//导出;
$(function() { 
    $("#export").click(function(){
    	window.location.href="/admin/reported/export?"+$('#form_submit').serialize();
    })
})

//解决状态 ;
function updateSolveStatus(id,statu){
	//询问框
    layer.msg('确定已解决？', {
       time: 0 //不自动关闭
      ,icon: 6
      ,btn: ['确定','退出']
    ,btn1: function(index){
	  $.ajax({
		  type: 'post',
		  url: '/admin/reported/updateSolveStatus?id='+id+"&rSolveStatus="+statu,
		  dataType: 'json',
		  success: function (data) {
			  var code = data.code;
          	if(code =='200'){
          	layer.msg("操作成功", {icon: 6});
          	location.reload();
          	}
          	else{
				  alert("更新失败！");
			  }
		  }
	  });
    }
    ,btn2: function(index){
        layer.close(index);
      }
    });
}

//获取销售人员列表;
$(document).ready(function(){
	loadsaleId(); 
	loaddeliveryId();
	loadarea();
	}); 
	
var saleId = $('#saleIdVO').val();
function loadsaleId(){
	if(saleId == null || saleId == '' ||saleId == undefined){
		saleId = 0;
	}
	  var url='/admin/sales/salesList'; 
	  jQuery.ajax({ 
	    type:'post', 
	    url:url, 
	    async:false,
	    success:function (date){
   	   var r = date.object;  
         if(r != null && r.length > 0){
            for(var i = 0; i< r.length; i++){
                if(r[i].id == saleId){
             	   $("<option value='"+r[i].id+"' selected>"+r[i].realName+"</option>").appendTo("#saleId");
                }else {
                $("<option value='"+r[i].id+"'>"+r[i].realName+"</option>").appendTo("#saleId");  
			}
            }  
         } 
	    } 
	  }); 
	}
	
var deliveryId = $('#deliveryIdVO').val();
function loaddeliveryId(){
	if(deliveryId == null |deliveryId  == '' ||deliveryId == undefined){
		deliveryId = 0;
	}
	  var url='/admin/delivery/getDelivery'; 
	  jQuery.ajax({ 
	    type:'post', 
	    url:url, 
	    async:false,
	    success:function (date){
   	   var r = date.object;  
         if(r != null && r.length > 0){
             for(var i = 0; i< r.length; i++){
                 if(r[i].id == deliveryId){
              	   $("<option value='"+r[i].id+"' selected>"+r[i].deliveryName+"</option>").appendTo("#deliveryId");
                 }else {
                 $("<option value='"+r[i].id+"'>"+r[i].deliveryName+"</option>").appendTo("#deliveryId");  
				}
             }  
         } 
	    } 
	  }); 
	}
	
var areaId = $('#areaIdVO').val();
function loadarea(){
	if(areaId == null || areaId == '' ||areaId == undefined){
		areaId = 0;
	}
	  var url='/admin/region/Alllist'; 
	  jQuery.ajax({ 
	    type:'post', 
	    url:url, 
	    async:false,
	    success:function (date){
   	   var areaList = date.object;  
         if(areaList != null && areaList.length > 0){
        	 if(areaId == 0){
        	 $("<option value='' selected>"+"全部"+"</option>").appendTo("#areaId");
        	 }else{
        		 $("<option value=''>"+"全部"+"</option>").appendTo("#areaId");
        	 }
             for(var i = 0; i< areaList.length; i++){
                 if(areaList[i].id == areaId){
              	   $("<option value='"+areaList[i].id+"' selected>"+areaList[i].areaName+"</option>").appendTo("#areaId");
                 }else {
                 $("<option value='"+areaList[i].id+"'>"+areaList[i].areaName+"</option>").appendTo("#areaId");  
				}
             }  
         } 
	    } 
	  }); 
	}
</script>
</body>
</html>