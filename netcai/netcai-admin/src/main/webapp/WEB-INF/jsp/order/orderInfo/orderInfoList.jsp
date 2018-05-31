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
  <!-- 配送人员列表start -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>订单管理</h1>
    </section>
    <!-- Main content -->
    <shiro:hasPermission name="orderInfo:query">
	    <section class="content">
	      <div class="row">
	        <div class="col-xs-12">
	          <div class="box">
	            <div class="box-header">
	              <h3 class="box-title">订单列表信息</h3>
	            </div>
	            <div class="box box-info">
	                <form id="subForm" class="form-horizontal layui-form" action="<%=request.getContextPath() %>/admin/orderInfo/list" method="post" >
	                    <input type="hidden" name="pageNum" id="pageNum" value="${paginator.currentPage}">
	                    <input type="hidden" name="pageSize" id="pageSize" value="${paginator.pageRecord}">
	                    <input type="hidden" name="buyerId"  value="${orderInfo.buyerId}">
	                    <div class="box-body">
							<div class="col-sm-12">
								<div class="form-group">
								    <label for="buyerName" class="col-sm-2 control-label">餐馆名称：</label>
					                <div class="col-xs-2">
						                <input type="text" class="form-control input-small" id="buyerName" name="buyer.buyerName" value="${orderInfo.buyer.buyerName}" placeholder="请输入买家信息">
						            </div>
				                    <label for="orderNumber" class="col-sm-2 control-label">订单号：</label>
					                <div class="col-xs-2">
						                <input type="text" class="form-control input-small" id="orderNumber" name="orderNumber" value="${orderInfo.orderNumber}" placeholder="请输入订单号">
						            </div>
						            <label for="payStatus" class="col-sm-1 control-label">支付状态</label>
					                <div class="col-xs-2">
						                <select id="orderInfopayStatus" name="pStatus" multiple="multiple" >
									        <option value="" >全部</option>
									        <option value="1" <c:forEach items="${pStatus}" var="pStatus"><c:if test="${fn:contains(pStatus,1)}">selected</c:if></c:forEach>>未付款</option>
									        <option value="2" <c:forEach items="${pStatus}" var="pStatus"><c:if test="${fn:contains(pStatus,2)}">selected</c:if></c:forEach>>已付款</option>
									        <option value="3" <c:forEach items="${pStatus}" var="pStatus"><c:if test="${fn:contains(pStatus,3)}">selected</c:if></c:forEach>>线下付款</option>
									        <option value="4" <c:forEach items="${pStatus}" var="pStatus"><c:if test="${fn:contains(pStatus,4)}">selected</c:if></c:forEach>>线下付款已收款</option>
									     </select>
						            </div>
								</div>
								<div class="form-group">
								    <label for="createTimeStart" class="col-sm-2 control-label">下单开始:</label>
								    <div class="col-xs-2">
					                    <input type="text" name="createTimeStart" id="createTimeStart" value="${orderInfo.createTimeStart}" class="form-control input-small" placeholder="请选择下单开始时间">
					                </div>
					                <label for="createTimeStop" class="col-sm-2 control-label">下单结束：</label>
				                    <div class="col-xs-2">
					                    <input type="text" name="createTimeStop" id="createTimeStop" value="${orderInfo.createTimeStop}"  class="form-control" placeholder="请输入下单结束时间">
					                </div>
				                    <label for="tradeStatus" class="col-sm-1 control-label">订单状态</label>
				                    <div class="col-xs-2">
						                <select id="orderInfotradeStatus" name="tStatus" multiple="multiple">
									          <option value="" >全部</option>
									          <option value="0" <c:forEach items="${tStatus}" var="tStatus"><c:if test="${fn:contains(tStatus,0)}">selected</c:if></c:forEach>>进行中</option>
									          <option value="1" <c:forEach items="${tStatus}" var="tStatus"><c:if test="${fn:contains(tStatus,1)}">selected</c:if></c:forEach>>已完成</option>
									          <option value="2" <c:forEach items="${tStatus}" var="tStatus"><c:if test="${fn:contains(tStatus,2)}">selected</c:if></c:forEach>>取消交易</option>
									          <option value="3" <c:forEach items="${tStatus}" var="tStatus"><c:if test="${fn:contains(tStatus,3)}">selected</c:if></c:forEach>>已结算</option>
									     </select>
					                </div>
								</div>
								<div class="form-group">
								    <label for="beatTimeStart" class="col-sm-2 control-label">送达起始：</label>
				                    <div class="col-xs-2">
					                    <input type="text" name="beatTimeStart" id="beatTimeStart" value="${orderInfo.beatTimeStart}" class="form-control input-small" placeholder="请选择送达开始时间">
					                </div>
					                <label for="beatTimeStop" class="col-sm-2 control-label">送达结束：</label>
				                    <div class="col-xs-2">
					                    <input type="text" name="beatTimeStop" id="beatTimeStop" value="${orderInfo.beatTimeStop}"  class="form-control" placeholder="请输入送达结束时间">
					                </div>
					                <label for="regionId" class="col-sm-1 control-label">所在区域</label>
				                    <div class="col-xs-2">
						                <select name="regionId" id="areaId">
									    </select>
					                </div>
					            </div>
					            <div class="form-group">
					                <label for="orderType" class="col-sm-2 control-label">订单类型：</label>
				                    <div class="col-xs-2">
						                <select name="orderType">
									    	<option value="" >全部</option>
									    	<option value="0" <c:if test="${orderInfo.orderType == 0}">selected</c:if>>普通订单</option>
									    	<option value="1" <c:if test="${orderInfo.orderType == 1}">selected</c:if>>团购订单</option>
									    </select>
					                </div>
					            </div>
							</div>
							<div class="form-footer">
								<button type="submit" class="btn btn-info pull-left" onclick="saveOrUp()">提交</button>
					            <button type="reset" id="reset" class="btn btn-info pull-left" style="margin-left:6px;">重置</button>
							</div>
						</div>
					</form>
			    </div>
	            <div class="row">
				    <div class="col-sm-12">
					    <div class="pull-left">
						    <button type="button" class="btn btn-primary" id="export" data-complete-text="Loading finished" >导出</button>
						    <button type="button" class="btn btn-primary" id="exportAll" data-complete-text="Loading finished" >导出全部</button>
						    <c:set var="totalAmount" value="0"></c:set>
					        <c:forEach items="${paginator.object}" var="list" varStatus="status"> 
			              	    <c:set var="totalAmount" value="${totalAmount+list.totalAmount}"></c:set>
			            	</c:forEach> 
					        <span style="margin-left:60px;font-weight:900;font-size:16px;color:#000aaa;">最终总金额：${totalAmount }</span>
					    </div>
				    </div>
				</div>
	            <!-- 表单end -->
	            <!-- /.box-header -->
	            <div class="layui-form"  >
	              <table id="contentTable" class="layui-table table-striped">
	                <thead >
		             <tr >
		             <th><input type="checkbox"  lay-skin="primary" lay-filter="allChoose"></th>
		                <th style="width: 100px">订单号</th>
		                <th style="width: 100px">买家账号</th>
		                <th style="width: 100px">买家店铺</th>
		                <th style="width: 150px">买家地址</th>
		                <th>销售人员</th>
		                <th>订单类型</th>
		                <th>配送人员</th>
		                <th>所在区域</th>
		                <th>配送区域</th>
		                <th>支付金额</th>
		                <th>订单金额</th>
		                <th>最终金额</th>
		                <th>订单状态</th>
		                <th>支付状态</th>
		                <th>支付方式</th>
		             	<th style="width: 110px">下单时间</th>
		             	<th style="width: 110px">最佳送货时间</th>
		                <th style="width: 200px">操作</th>
		              </tr>
	                </thead>
	                <tbody>
		              <c:forEach items="${paginator.object}" var="r"> 
			   			 <tr>
			   			 	   <td><input type="checkbox" id="${r.id}" lay-skin="primary" class="i-checks"></td>
						       <td><a style="color: blue;" href="/admin/orderItem/getAll?orderNumber=${r.orderNumber}&pageSize=30">${r.orderNumber}</a></td>
						       <td>${r.buyer.users.account}</td>
						       <td>${r.buyer.buyerName}</td>
						       <td>${r.buyer.buyerAddress}</td>
						       <td>${r.salesName}</td>
						       <td>
						       		<c:if test="${r.orderType==0}">普通订单</c:if>
								   	<c:if test="${r.orderType==1}">团购订单</c:if>
						       </td>
						       <td>${r.deliveryName}</td>
						       <td>${r.areaName}</td>
						       <td>${r.buyer.daAddress}</td>
						       <td>
						       <c:choose> 
									 <c:when test="${r.orderAmount != r.payAmount}">   
									   <span style="color: red;">${r.payAmount}</span>
									 </c:when> 
									 <c:otherwise>   
						       			 ${r.payAmount}
									 </c:otherwise> 
									</c:choose> 
						      
						       </td>
						       <td>${r.orderAmount}</td>
						       <td>
						       		<c:choose> 
									 <c:when test="${r.orderAmount != r.totalAmount}">   
									   <span style="color: red">${r.totalAmount}</span>
									 </c:when> 
									 <c:otherwise>   
						       			${r.totalAmount}
									 </c:otherwise> 
									</c:choose> 
						       </td>
						       <td><c:if test="${r.tradeStatus==0}">进行中</c:if>
								   <c:if test="${r.tradeStatus==1}">已完成</c:if>
								   <c:if test="${r.tradeStatus==2}">取消交易</c:if>
								   <c:if test="${r.tradeStatus==3}">已结算</c:if>
								</td>
						       <td><c:if test="${r.payStatus==1}">未付款</c:if>
								   <c:if test="${r.payStatus==2}">已付款</c:if>
								   <c:if test="${r.payStatus==3}">线下付款</c:if>
								   <c:if test="${r.payStatus==4}">线下付款已收款</c:if>
								</td>
								<td>${r.cardName}</td>
			   			 	   <td><fmt:formatDate value="${r.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			   			 	   <td><a href="#" id="${r.id}" class="bestTime"><fmt:formatDate value="${r.bestTime}" pattern="yyyy-MM-dd HH:mm:ss"/></a></td>
						       <td>
						           <shiro:hasPermission name="orderItem:query">
							       	   <a href="/admin/orderItem/list?orderId=${r.id}"  class="layui-btn layui-btn-normal layui-btn-small" ><i class="fa fa-search-plus"></i> 查看</a>
				   			 	   </shiro:hasPermission>
				   			 	   <c:if test="${r.tradeStatus != 2}">
				   			 	   		<button  class="layui-btn layui-btn-normal layui-btn-small" onclick="delInfo(${r.id},${r.buyerId},'<fmt:formatDate value="${r.bestTime}" pattern="yyyy-MM-dd"/>')"><i class="layui-icon"></i><span>取消交易</span></button>
				   			 	   </c:if>
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
<input type="hidden" id="areaIdVO" value="${orderInfo.regionId}"/>
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
	$('#subForm').submit();
}  
</script>
<script>
layui.use(['form', 'jquery', 'layedit', 'laydate'], function(){
	var $ = layui.jquery,form = layui.form(),layer = layui.layer,
	  layedit = layui.layedit,laydate = layui.laydate;
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
//重置
$(function(){
   $("#reset").click(function(){
	   window.location.href="/admin/orderInfo/list";
   });
  });


//初始化时间选择器
$("#beatTimeStart").bind("click focus", function () {
    var endtimeTf = $dp.$('beatTimeStop');
    WdatePicker({
        maxDate: '#F{$dp.$D(\'beatTimeStart\')}',
        dateFmt: "yyyy-MM-dd HH:mm",
        onpicked: function () { endtimeTf.focus(); }
    });
});
$("#beatTimeStop").bind("click focus", function () {
    WdatePicker({
        minDate: '#F{$dp.$D(\'beatTimeStart\')}',
        dateFmt: "yyyy-MM-dd HH:mm"
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

//保存、修改数据
function saveOrUp(){
	  $('#subForm').validate({ 		
			submitHandler: function (form) {
				$('#subForm').submit();
			}
		});
}

//导出;
$(function() { 
    $("#export").click(function(){
    	window.location.href="/admin/orderInfo/export?"+$('#subForm').serialize();
    })
})

//导出全部;
$(function() { 
    $("#exportAll").click(function(){
    	window.location.href="/admin/orderInfo/export?all=all";
    })
})

//修改状态；
$(function() { 
    $("#fixPayStatus").click(function(){
		  var ids = new Array();
		  $("#contentTable tbody tr td input.i-checks:checkbox").each(function(){
		    if(true == $(this).is(':checked')){
		    	ids.push($(this).attr("id"));
		    }
		  });
		  if(ids.length<1){
			top.layer.alert('请至少选择一条数据!', {icon: 0, title:'警告'});
			return;
		  }
 		//询问框
	    layer.msg('选择状态', {
	       time: 0 //不自动关闭
	      ,icon: 6
	      ,btn: ['已完成','已结算','退出']
	    ,btn1: function(index){
	        layer.close(index);
	        layer.confirm('确定更新？', {
	        	  btn: ['确定','取消'] //按钮
	        	}, function(){
	        	  $.ajax({  
			            url:"/admin/orderInfo/update/status",
			            data:{"ids":ids,"status":1},//0为进行中, 1,已完成，2,为取消交易,3,已结算',
			            dataType:"json",  
			            success:function(data){ 
			            	var code = data.code;
			            	var message = data.message;
			            	layer.msg(message, {icon: 6});
			                location.reload();
			            }  
			        });
	        	}, function(){
	        	  return;
	        	});
	      }
	    ,btn2: function(index){
	        layer.close(index);
	        layer.confirm('确定更新？', {
	        	  btn: ['确定','取消'] //按钮
	        	}, function(){
	        	  $.ajax({  
			            url:"/admin/orderInfo/update/status",
			            data:{"ids":ids,"status":3},//0为进行中, 1,已完成，2,为取消交易,3,已结算',
			            dataType:"json",  
			            success:function(data){ 
			            	var code = data.code;
			            	var message = data.message;
			            	layer.msg(message, {icon: 6});
			                location.reload();
			            }  
			        });
	        	}, function(){
	        	  return;
	        	});
	      }
	    ,btn3: function(index){
	        layer.close(index);
	      }
	    });
	});
});

//取消订单;
function delInfo(orderId,buyerId,bestTime){
    layer.msg('确定取消订单？', {
       time: 0 //不自动关闭
      ,icon: 6
      ,btn: ['确定','退出']
    ,btn1: function(index){
        	  $.ajax({  
        		  	url:"/admin/order/info/delete",
		            data:{"orderId":orderId,"buyerId":buyerId},
		            dataType:"json",  
		            cache:false,
		            success:function(data){
		            	var code = data.code;
		            	if(code =='200'){
		            		parent.layer.msg("操作成功", {icon: 6},{time: 3500});
		            		//刷新页面
		      	            parent.location.reload();
		            	}else{
		            		parent.layer.msg(data.message, {icon: 5},{time: 3500});
		            	}
		            }  
		        });
      }
    ,btn2: function(index){
        layer.close(index);
      }
    });
}

//修改送货时间;
$(function () {
    $('.bestTime').editable({
        type: "datetime",                //编辑框的类型。支持text|textarea|select|date|checklist等
        title: "最佳送货时间",              //编辑框的标题
        disabled: false,             //是否禁用编辑
        emptytext: "空文本",          //空值的默认文本
        mode: "popup",              //编辑框的模式：支持popup和inline两种模式，默认是popup
        validate: function (value) { //字段验证
        	var id = $(this).attr('id');
        	if (!$.trim(id)) {
        		layer.msg("id不能为空", {icon: 5});
        		location.reload();
        		return;
            }
            if (!$.trim(value)) {
            	layer.msg('时间不能为空', {icon: 5});
            	location.reload();
            	return;
            }
            var bestTime = value;
            $.ajax({
	      		  type: 'POST',
	      		  url: '/admin/orderInfo/updateBestTime',
	      		  data:{"id":id,"bestTime":bestTime},
	      		  dataType: 'json',
	      		  success: function (data) {
	      			  layer.msg(data.message, {icon: 6});
	      		  },
	      		  error: function () {
	      			  layer.msg("更新失败", {icon: 5});
				  }
      	    });
        }
    });
});


//获取销售人员列表;
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
	    cache:false,
	    success:function (date){
   	     var areaList = date.object;  
         if(areaList != null && areaList.length > 0){
        	 if(areaId == 0){
        	 	$("<option value='' selected>"+"全部"+"</option>").appendTo("#areaId");
        	 }else
        	 {
        		 $("<option value=''>"+"全部"+"</option>").appendTo("#areaId");
        	 }
             for(var i = 0; i< areaList.length; i++)
             {
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