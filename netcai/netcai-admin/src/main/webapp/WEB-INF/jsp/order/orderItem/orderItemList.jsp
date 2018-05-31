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
    button{
      margin-right:5px;
    }
  </style>
</head>
<body>
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>订单详细</h1>
    </section>
    <!-- Main content -->
    <shiro:hasPermission name="orderItem:query">
	    <section class="content">
	      <div class="row">
	        <div class="col-xs-12">
	          <div class="box">
	            <div class="box-header">
	              <h3 class="box-title">订单详细信息</h3>
	            </div>
	            <!-- <!-- 表单start -->
	            <form id="subForm" class="layui-form" action="<%=request.getContextPath() %>/admin/orderItem/list" method="post" >
	               <input type="hidden" name="pageNum" id="pageNum" value="${paginator.currentPage}">
	              <input type="hidden" name="pageSize" id="pageSize" value="${paginator.pageRecord}">
		            
	               <div class="col-sm-3 layui-form-item layui-form-btns" style="float: right;margin-top: 50px;">
					     <button type="submit" class="btn btn-info pull-left" onclick="saveOrUp()">提交</button>
					     <button type="reset" id="reset" class="btn btn-info pull-left">重置</button>
				   </div>
				   
	            </form> 
	            
	            <!-- 订单详情; -->
	            <div class="layui-form"  style="margin-top:40px;">
	              <table class="layui-table table-striped">
	                <thead >
		             <tr >
		                <th>订单号</th>
		                <th>买家店铺名称</th>
		                <th>买家ID</th>
		                <th>商品总金额</th>
		                <th>最终金额</th>
		              </tr>
	                </thead>
	                <tbody>
			   			 <tr>
					        <th>${orderInfo.orderNumber}</th>
			                <th>${orderInfo.buyer.buyerName}</th>
			                <th>${orderInfo.buyerId}</th>
			                <th>${orderInfo.orderAmount}</th>
			                <th>${orderInfo.totalAmount}</th>
			             </tr>
	                </tbody>
	              </table>
	            </div>
	            <!-- 表单end -->
	            <!-- /.box-header -->
	             <!-- 订单项详情; -->
	            <div class="layui-form"  style="margin-top:40px;">
	              <table class="layui-table table-striped">
	                <thead >
		             <tr >
		                <th>商品名称</th>
		                <th>订单状态</th>
		                <th>卖家店铺名称</th>
		                <th>商品金额</th>
		                <th>原始数量</th>
		                <th>现数量</th>
		                <!-- <th style="color: red;">修正数量Error</th> -->
		                <th>单价</th>
		                <th>配送费用</th>
		                <th>配送类型</th>
		                <th>配送完成时间</th>
		                <th>配送人员</th>
		                <th>配送状态</th>
		                <th>备注</th>
		              </tr>
	                </thead>
	                <tbody>
		              <c:forEach items="${orderItems}" var="r"> 
			   			 <tr>
					       <td>${r.goodsName}</td>
					       <td><c:if test="${r.orderStatus==1}">提交订单</c:if>
							   <c:if test="${r.orderStatus==2}">取消订单</c:if>
							</td>
					       <td>${r.seller.sellerName}</td>
					       <td>${r.goodsAmount}</td>
					       <td>
					       		<c:if test="${r.goodsNumberOld != r.goodsNumber}">
					       				<span style="color: red;">${r.goodsNumberOld}</span>
					       		</c:if>
					       		<c:if test="${r.goodsNumberOld == r.goodsNumber}">
					       				${r.goodsNumberOld}
					       		</c:if>
					       </td>
					       <td><a href="#" id="${r.id},,${orderInfo.id}" class="goodsNumber">${r.goodsNumber}</a></td>
					       <%-- <td><a href="#" id="${r.id},,${orderInfo.id},," class="goodsNumberError">${r.goodsNumber}</a></td> --%>
					       <td>
					       		${r.goodsPrice}/
					       		<c:if test="${r.formatNum != 1}">${r.formatNum}</c:if>
					       		${r.unitName}
					       </td>
					       <td>${r.deliveryMoney}</td>
					       <td><c:if test="${r.deliveryType==1}">平台送</c:if>
							   <c:if test="${r.deliveryType==2}">卖家送</c:if>
							</td>
							<td><fmt:formatDate value="${r.deliveryFinishTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td>${r.deliveryName}</td>
					       <td><c:if test="${r.deliveryStatus==1}">已收货,送货中</c:if>
							   <c:if test="${r.deliveryStatus==2}">已收货,已送货</c:if>
							</td>
					       <td>${r.remark}</td>
			             </tr>
					   </c:forEach>
	                </tbody>
	              </table>
	            </div>
	          </div>
	          </div>
	        </div>
	    </section>
    </shiro:hasPermission>
 </div>
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
<script type="text/javascript">
function onSelectPage(currentPage,pageSize)
{  
	$('#pageNum').val(currentPage);
	$('#pageSize').val(pageSize);
	$('#subForm').submit();
}  
</script>
<script>
//调重;
$(function () {
    $('.goodsNumber').editable({
        type: "text",                //编辑框的类型。支持text|textarea|select|date|checklist等
        title: "修改数量",              //编辑框的标题
        disabled: false,             //是否禁用编辑
        emptytext: "空文本",          //空值的默认文本
        mode: "popup",              //编辑框的模式：支持popup和inline两种模式，默认是popup
        validate: function (value) { //字段验证
        	arr = $(this).attr('id').split(",,");
        	var reg = new RegExp(/^[0-9]+([.]{1}[0-9]+){0,1}$/); 
	        var itemId = arr[0];
	        var orderId = arr[1];
        	if (!$.trim(itemId) || !$.trim(orderId)) {
        		layer.msg("id不能为空!", {icon: 5});
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
      		  url: '/admin/orderItem/update/goodsNumber',
      		  data:{"itemId":itemId,"orderId":orderId,"goodsNumber":goodsNumber},
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
	        var orderId = arr[1];
        	if (!$.trim(itemId) || !$.trim(orderId)) {
        		layer.msg("id不能为空!", {icon: 5});
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
      		  data:{"itemId":itemId,"orderId":orderId,"goodsNumber":goodsNumber},
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

//重置
$(function(){
   $("#reset").click(function(){
	   window.location.href="/admin/orderItem/list";
   });
  });

layui.use('form', function(){
	  var $ = layui.jquery, form = layui.form();
});
</script>
</body>
</html>