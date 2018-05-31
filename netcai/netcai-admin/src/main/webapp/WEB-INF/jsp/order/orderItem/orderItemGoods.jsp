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
<body>
  <!-- 订单详细列表start -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>订单详细</h1>
    </section>
    <!-- Main content -->
    <shiro:hasPermission name="allOrderItem:query">
	    <section class="content">
	      <div class="row">
	        <div class="col-xs-12">
	          <div class="box">
	            <div class="box-header">
	              <h3 class="box-title">订单详细信息</h3>
	            </div>
	            <div class="box box-info">
	                <form id="subForm" class="form-horizontal layui-form" action="<%=request.getContextPath() %>/admin/orderItem/getAll" method="post" >
		                <input type="hidden" name="pageNum" id="pageNum" value="${paginator.currentPage}">
		                <input type="hidden" name="pageSize" id="pageSize" value="${paginator.pageRecord}">
		                <input type="hidden" name="buyerId"  value="${orderItem.buyerId}">
		                <input type="hidden" name="sellerId"  value="${orderItem.sellerId}">
		                <input type="hidden" name="orderId"  value="${orderItem.orderId}">
	              	    <div class="box-body">
	              	        <div class="col-sm-12">
		                        <div class="form-group" >
		                            <label for="areaId" class="col-sm-2  control-label">区域选择：</label>
				                    <div class="col-xs-2">
				                         <select id="areaId" name="regionId" class="form-control" >
									         <option value="" >全部</option>
								         </select>
				                    </div>
		                            <label for="orderItemorderNumber" class="col-sm-2 control-label">订单号：</label>
				                    <div class="col-xs-2">
					                	<input type="text" class="form-control input-small" id="orderItemorderNumber" name="orderNumber" value="${orderItem.orderNumber}" placeholder="请输入订单号">
					                </div>
		                            <label for="buyerName" class="col-sm-2 control-label">餐馆名称：</label>
				                    <div class="col-xs-2">
					                    <input type="text" class="form-control input-small" id="buyerName" name="buyer.buyerName" value="${orderItem.buyer.buyerName}" placeholder="请输入买家信息">
					                </div>
		                        </div>
		                        <div class="form-group">
		                            <label for="sellerName" class="col-sm-2 control-label">商铺名称：</label>
				                    <div class="col-xs-2">
					                	<input type="text" class="form-control input-small" id="sellerName" name="seller.sellerName" value="${orderItem.seller.sellerName}" placeholder="请输入卖家信息">
					                </div>
					                <label for="createTimeStart" class="col-sm-2 control-label">下单开始时间：</label>
				                    <div class="col-xs-2">
					                	<input type="text" name="createTimeStart" id="createTimeStart" value="${orderItem.createTimeStart}" class="form-control input-small" placeholder="请选择开始时间">
					                </div>
					                <label for="createTimeStop" class="col-sm-2 control-label">下单结束时间：</label>
				                    <div class="col-xs-2">
					                	<input type="text" name="createTimeStop" id="createTimeStop" value="${orderItem.createTimeStop}"  class="form-control" placeholder="请输入结束时间">
					                </div>
		                        </div>
		                        <div class="form-group">
					                <label for="goodsName" class="col-sm-2 control-label">商品名称：</label>
				                    <div class="col-xs-2">
					                	<input type="text" class="form-control input-small" id="goodsName" name="goodsName" value="${orderItem.goodsName}" placeholder="请输入商品名称">
					                </div>
					                <label for="orderStatus" class="col-sm-2 control-label">交易状态：</label>
				                    <div class="col-xs-2">
						                <select id="orderStatus" name="orderStatus" >
									        <option value="" <c:if test="${orderItem.orderStatus==null}">selected</c:if>>全部</option>
									        <option value="1" <c:if test="${orderItem.orderStatus==1}">selected</c:if>>提交订单</option>
									        <option value="2" <c:if test="${orderItem.orderStatus==2}">selected</c:if>>取消订单</option>
									     </select>
					                </div>
					                <label for="sellerStatus" class="col-sm-2 control-label">备货状态：</label>
				                    <div class="col-xs-2">
						                <select id="sellerStatus" name="sellerStatus" >
									        <option value="" <c:if test="${orderItem.sellerStatus==null}">selected</c:if>>全部</option>
									        <option value="0" <c:if test="${orderItem.sellerStatus==0}">selected</c:if>>备货中</option>
									        <option value="1" <c:if test="${orderItem.sellerStatus==1}">selected</c:if>>备货完成</option>
									        <option value="4" <c:if test="${orderItem.sellerStatus==4}">selected</c:if>>已补货</option>
									        <option value="5" <c:if test="${orderItem.sellerStatus==5}">selected</c:if>>不需补货</option>
									     </select>
					                </div>
				                </div>
				                <div class="form-group">
					                <label for="goodsNumber" class="col-sm-2 control-label">调重：</label>
				                    <div class="col-xs-2">
						                <select  name="goodsNumber" >
									        <option value=""  selected>全部</option>
									        <option value="" >全部</option>
									        <option value="0" <c:if test="${orderItem.goodsNumber==0}">selected</c:if>>调重过</option>
									     </select>
					                </div>
				                </div>
		                    </div>
			                <div class="form-footer">
							     <button type="submit" class="btn btn-info pull-left" onclick="saveOrUp()">提交</button>
							     <button type="reset" id="reset" class="btn btn-info pull-left">重置</button>
						    </div> 
	              	    </div>
	                </form> 
	            </div>       
	            <div class="row">
				    <div class="col-sm-12">
				        <div class="pull-left">
				        	<button type="button" class="btn btn-primary" id="exportGoods" data-complete-text="Loading finished" >导出</button>
				        </div>
				    </div>
				</div>
	            <!-- 订单项详情 -->
	            <div class="layui-form"  style="margin-top:40px;">
	              <table class="layui-table table-striped">
	                <thead >
		             <tr >
		                <th>所属区域</th>
		                <th>订单号</th>
		                <th>商品名称</th>
		                <th>买家店铺名称</th>
		                <th>卖家店铺名称</th>
		                <th>商品原总金额</th>
		                <th>商品现总金额</th>
		                <th>原数量</th>
		                <th>数量</th>
		                <th>加工方式</th>
		                <th>单价</th>
		                <th>交易状态</th>
		                <th>创建时间</th>
		                <th>送达时间</th>
		                <th>备注</th>
		                <th>操作</th>
		              </tr>
	                </thead>
	                <tbody>
		              <c:forEach items="${paginator.object}" var="r"> 
			   			 <tr>
						       <td>${r.areaName}</td>
						       <td><a style="color: blue;" href="/admin/orderItem/getAll?orderNumber=${r.orderNumber}&pageSize=30">${r.orderNumber}</a></td>
						       <td>${r.formatName}${r.goodsName}</td>
						       <td>${r.buyer.buyerName}</td>
						       <td>${r.seller.sellerName}</td>
						       <td>
						       		<c:choose> 
									  <c:when test="${r.goodsAmountOld != r.goodsAmount}">   
									  		<span style="color: red;">${r.goodsAmountOld}</span>
									  </c:when> 
									  <c:otherwise>   
									 ${r.goodsAmountOld}
									  </c:otherwise> 
									</c:choose> 
						       </td>
						       <td>${r.goodsAmount}</td>
						       <td>
						       		<c:if test="${r.goodsNumberOld != r.goodsNumber}">
						       				<span style="color: red;">${r.goodsNumberOld}</span>
						       		</c:if>
						       		<c:if test="${r.goodsNumberOld == r.goodsNumber}">
						       				${r.goodsNumberOld}
						       		</c:if>
						       </td>
						       <td><a href="#" id="${r.id},,${r.goodsNumber}" class="goodsNumberError">${r.goodsNumber}</a></td>
						       <td>
						       <c:choose> 
								  <c:when test="${empty r.methodName}">   
								    无加工
								  </c:when> 
								  <c:otherwise>   
								 ${r.methodName}
								  </c:otherwise> 
								</c:choose> 
						       </td>
						       <td>
						       		${r.goodsPrice}/
						       		<c:if test="${r.formatNum != 1}">${r.formatNum}</c:if>
						       		${r.unitName}
						       </td>
						       <td><c:if test="${r.orderStatus==1}">提交订单</c:if>
								   <c:if test="${r.orderStatus==2}">取消订单</c:if>
							   </td>
							   <td><fmt:formatDate value="${r.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							   <td><fmt:formatDate value="${r.deliveryFinishTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						       <td>${r.remark}</td>
						       <td>
				   			 	   <c:if test="${r.orderStatus == 1 && r.buyerStatus==0 || r.sellerStatus==0}">
				   			 	   		<button  class="layui-btn layui-btn-normal layui-btn-small" onclick="delItem(${r.id},${r.buyerId})"><i class="layui-icon"></i><span>取消交易</span></button>
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
 <input type="hidden" id="areaIdVO" value="${orderItem.regionId}"/>
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

layui.use('form', function(){
	  var $ = layui.jquery, form = layui.form();
});

//重置
$(function(){
   $("#reset").click(function(){
	   window.location.href="/admin/orderItem/getAll";
   });
  });

//导出;
$(function() { 
    $("#exportGoods").click(function(){
    	window.location.href="/admin/orderItem/exportGoods?"+$('#subForm').serialize();
    })
})

$(".form-group input").bind("blur",function(){  
        var result=$(this).attr("value").replace(/(^\s*)|(\s*$)/g, "");  
        $(this).attr("value",result);  
    });
    

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

//修正调重;
$(function () {
    $('.goodsNumberError').editable({
        type: "text",                //编辑框的类型。支持text|textarea|select|date|checklist等
        title: "修改数量",              //编辑框的标题
        disabled: false,             //是否禁用编辑
        emptytext: "空文本",          //空值的默认文本
        mode: "popup",              //编辑框的模式：支持popup和inline两种模式，默认是popup
        validate: function (value) { //字段验证
        	arr = $(this).attr('id').split(",,");
        	var reg = new RegExp(/^[0-9]+([.]{1}[0-9]+){0,1}$/); 
	        var itemId = arr[0];
	        var goodsNumber = arr[1];
        	if (!$.trim(itemId)) {
        		layer.msg("id不能为空!", {icon: 5});
        		location.reload();
        		return;
            }
        	if (value != goodsNumber) {
            	layer.msg('原数量不等于现数量', {icon: 5});
            	location.reload();
            	return;
            }
            if (!$.trim(value)) {
            	layer.msg('数量不能为空!', {icon: 5});
            	location.reload();
            	return;
            }
            if (!reg.test(value)) {
            	layer.msg('只能输入数字或小数!', {icon: 5});
            	location.reload();
            	return;
            }
            var goodsNumber = value;
            $.ajax({
      		  type: 'POST',
      		  url: '/admin/orderItem/update/goodsNumberError',
      		  data:{"itemId":itemId,"goodsNumber":goodsNumber},
      		  dataType: 'json',
      		  success: function (data) {
      			  layer.msg(data.message, {icon: 6});
      			location.reload();
      		  },error: function () {
      			layer.msg("更新失败", {icon: 5});
			}
      	  });
        }
    });
});

//取消订单;
function delItem(itemId,buyerId){
		//询问框
    layer.msg('确定取消订单？', {
       time: 0 //不自动关闭
      ,icon: 6
      ,btn: ['确定','退出']
    ,btn1: function(index){
        	  $.ajax({  
        		  	url:"/admin/order/item/delete",
		            data:{"itemId":itemId,"buyerId":buyerId},
		            dataType:"json",  
		            cache:false,
		            success:function(data){
		            	var code = data.code;
		            	if(code =='200'){
		            	    layer.msg("操作成功", {icon: 6},{time: 3500});
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
</script>
</body>
</html>