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
    #menu li{  
            text-decoration: none;//去掉li前面的圆点  
            list-style: none;  
            display: inline;//让li横向排列  
            border: 1px solid #FFFFFF;  
            background-color: #f2f2f2;  
        }  
  </style>
</head>
<body >
  <!-- 配送人员列表start -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>购物车管理</h1>
    </section>
    <!-- Main content -->
    <shiro:hasPermission name="goodsCart:query">
	    <section class="content">
	      <div class="row">
	        <div class="col-xs-12">
	          <div class="box">
	            <div class="box-header">
	              <h3 class="box-title">购物车信息</h3>
	            </div>
	            <!--  表单start -->
	            <form id="subForm" class="layui-form" action="<%=request.getContextPath() %>/admin/goodsCart/list" method="post" >
	            <input type="hidden" name="pageNum" id="pageNum" value="${paginator.currentPage}">
	              <input type="hidden" name="pageSize" id="pageSize" value="${paginator.pageRecord}">
	              <div class="box-body">
	                <div class="form-group" >
	                  <label for="queryTime" class="col-sm-1 control-label">创建时间</label>
	                  <div class="col-sm-2">
		                <input type="date" class="form-control input-small" id="queryTime" name="queryTime" value="${goodsCart.queryTime}" >
		              </div>
		              
	                  <label for="goodsFormat.formatName" class="col-sm-1 control-label">买家店铺</label>
	                  <div class="col-sm-2">
		                <input type="text" class="form-control input-small" id="buyerName" name="buyer.buyerName" value="${goodsCart.buyer.buyerName}" placeholder="请输入买家店铺名称">
		              </div>
	                </div>
	              </div>
	              
	               <div class="col-xs-12 layui-form-item layui-form-btns" style="text-align:center;">
		               <div class="col-xs-5"></div>
		               <div class="col-xs-2">
						     <button type="submit" class="btn btn-info pull-left" onclick="saveOrUp()" style="text-align: center;">提交</button>
						     <button type="reset" id="reset" class="btn btn-info pull-left" style="text-align: center;">重置</button>
		               </div>
		               <div class="col-xs-5"></div>
				   </div>
	            </form> 
				
				 <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;" >
				</fieldset>
				<div  class="layui-collapse" lay-accordion="">
					<c:forEach items="${paginator.object}" var="l"> 
				      <div class="layui-colla-item">
				          <h2 class="layui-colla-title">
					          <span style="color: green;">
								          买家店铺名称:${l.buyerName}&nbsp;&nbsp;&nbsp;&nbsp;
								          购买者:${l.bossName}&nbsp;&nbsp;&nbsp;&nbsp;
								          总价:
								          <c:set var="count" value="0"></c:set>
							                <c:forEach items="${l.goodsCarts }" var="item">
											    	<c:set var="count" value="${count+item.goodsFormat.formatPrice*item.goodsNumber}"></c:set>
											</c:forEach>
											${count}
					          </span>
					      </h2>
				          <div class="layui-colla-content">
				            <div class="layui-form" >
				              <table class="layui-table table-striped">
				                <thead >
						             <tr >
						                <th>卖家店铺名称</th>
						                <th>商品名称 </th>
						                <th>数量</th>
						                <th>单价</th>
						                <th>创建时间</th>
						              </tr>
				                </thead>
				                <tbody>
					              <c:forEach items="${l.goodsCarts}" var="r"> 
						   			 <tr>
								       <td>${r.goodsFormat.goods.seller.sellerName}</td>
								       <td>${r.goodsFormat.goods.goodsName}/${r.goodsFormat.unit.unitName }</td>
								       <td>${r.goodsNumber }</td>
								       <td>${r.goodsFormat.formatPrice}</td>
								       <td><fmt:formatDate value="${r.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
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
    </shiro:hasPermission>
  </div>
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
function onSelectPage(currentPage,pageSize)
{  
	$('#pageNum').val(currentPage);
	$('#pageSize').val(pageSize);
	$('#subForm').submit();
} 
</script>
<script>
//重置
$(function(){
   $("#reset").click(function(){
	   window.location.href="/admin/goodsCart/list";
   });
  });

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
</script>
</body>
</html>