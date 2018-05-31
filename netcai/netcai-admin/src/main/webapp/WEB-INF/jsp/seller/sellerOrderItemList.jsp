<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="pv" uri="/pageTaglib"%>
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
    #menu li{  
            text-decoration: none;//去掉li前面的圆点  
            list-style: none;  
            display: inline;//让li横向排列  
            border: 1px solid #FFFFFF;  
            background-color: #f2f2f2;  
        }  
  </style>
</head>
<body>
  <!-- 配送人员列表start -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>订单详细</h1>
    </section>
    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">订单详细信息</h3>
            </div>
            <!-- 增删改图标按钮组 -->
            <div class="site-demo-button" style="margin-top: 50px">
               <button type="button" class="btn btn-primary" id="export" 
			    data-complete-text="Loading finished" >导出
			</button>
			</div>
            
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
  <legend>卖家订单明细</legend>
</fieldset>
<div class="layui-collapse" lay-accordion="">
    <c:forEach items="${orderItem}" var="r"> 
		  <div class="layui-colla-item">
		    <h2 class="layui-colla-title">
		    	<ul  id="menu">  
		    		<li>订单号&nbsp;&nbsp;:&nbsp;&nbsp;${r.orderNumber}</li>
		    		<li>支付状态&nbsp;&nbsp;:&nbsp;&nbsp;
		    		<c:if test="${r.payStatus==1}">未付款&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if>
				   <c:if test="${r.payStatus==2}">已付款&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if>
				   <c:if test="${r.payStatus==3}">线下付款&nbsp;&nbsp;&nbsp;</c:if>
				   <c:if test="${r.payStatus==4}">线下付款已收款</c:if></li>
		    		</li>
		    		<li>下单时间&nbsp;&nbsp;:&nbsp;&nbsp;<fmt:formatDate value="${r.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></li>  
			        <li>买家店铺名称&nbsp;&nbsp;:&nbsp;&nbsp;${r.buyerName}</li>  
			        <li>客户的类型&nbsp;&nbsp;:&nbsp;&nbsp;<c:if test="${r.buyerType==1}">火锅店</c:if>
							   <c:if test="${r.buyerType==2}">小餐馆</c:if>
							   <c:if test="${r.buyerType==3}">中餐馆</c:if>
							   <c:if test="${r.buyerType==4}">烧烤&nbsp;</c:if></li>  
			        <li>老板电话号码&nbsp;&nbsp;:&nbsp;&nbsp;${r.bossTel}</li>  
			        <li>老板名称&nbsp;&nbsp;:&nbsp;&nbsp;${r.bossName}</li>
			        <li>总计&nbsp;&nbsp;:&nbsp;&nbsp;${r.totalMoney}</li>            
			    </ul>  
		    </h2>
		    <div class="layui-colla-content">
			       <div class="layui-form">
			           <table class="layui-table table-striped">
			             <thead >
				           <tr >
				              <th>商品类型</th>
				              <th>计量单位</th>
				              <th>加工方式</th>
				              <th>名称</th>
				              <th>商品总金额</th>
				              <th>商品数量</th>
				              <th>商品单价</th>
				              <th>备注</th>
				            </tr>
			             </thead>
			             <tbody>
				   			<c:forEach items="${r.orderItems}" var="o"> 
				  			 <tr>
						       <td>${o.goodsName}</td>
						       <td>${o.unitName}</td>
						       <td>${o.methodName}</td>
						       <td>${o.formatName}</td>
						       <td>${o.goodsAmount}</td>
						       <td>${o.goodsNumber}</td>
						       <td>${o.goodsPrice}</td>
						       <td>${o.remark}</td>
				            </tr>
						   </c:forEach> 
					   </tbody>
			         </table>
			     </div>
		    </div>
	  </div>
    </c:forEach>
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
<script src="/plugins/datepicker/bootstrap-datepicker.js"></script>
<script src="/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script src="/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="/plugins/fastclick/fastclick.js"></script>
<script src="/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script src="/dist/js/app.min.js"></script>
<script src="/dist/js/demo.js"></script>
<script src="/js/jquery-ui.min.js"></script>
<script src="/layui/layui.js" charset="utf-8"></script>
<script src="/js/jquery.validate.min.js" charset="utf-8"></script>
<script src="/js/layuiUtil.js" charset="utf-8"></script>
<script type="text/javascript">
function onSelectPage(currentPage)
{  
	window.location.href="/admin/orderItem/list?pageNum="+currentPage;
}  
</script>
<script>
layui.use(['element', 'layer'], function(){
	  var element = layui.element();
	  var layer = layui.layer;
	  
	  //监听折叠
	  element.on('collapse(test)', function(data){
	    layer.msg('展开状态：'+ data.show);
	  });
	});

layui.use('form', function(){
	  var $ = layui.jquery, form = layui.form();
});

//导出;
$(function() { 
    $("#export").click(function(){
    	window.location.href="/admin/orderItem/exportAllItem?sellerId=${sellerId}";
    })
})
</script>
</body>
</html>