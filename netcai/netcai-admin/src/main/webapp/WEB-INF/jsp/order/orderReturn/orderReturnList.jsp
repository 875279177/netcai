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
    button{
      margin-right:5px;
    }
  </style>
</head>
<body class="hold-transition skin-blue sidebar-mini">
  <!-- 配送人员列表start -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>商品退货</h1>
    </section>
    <!-- Main content -->
    <shiro:hasPermission name="orderReturn:query">
	    <section class="content">
	      <div class="row">
	        <div class="col-xs-12">
	          <div class="box">
	            <div class="box-header">
	              <h3 class="box-title">商品退货详细信息</h3>
	            </div>
	            <!--  表单start -->
	            <form id="withdrawalBank" class="layui-form" action="<%=request.getContextPath() %>/admin/orderReturn/list" method="post" >
	              <div class="box-body">
	                <div class="form-group" >
	              	  <label for="seller.sellerName" class="col-sm-1 control-label">商品名称</label>
	                  <div class="col-sm-2">
		                <input type="text" class="form-control input-small" id="formatName" name="orderItem.goodsFormat.formatName" value="${orderReturn.orderItem.goodsFormat.formatName}" placeholder="请输入卖家店铺名称">
		              </div>
		              
	                  <label for="orderNumber" class="col-sm-1 control-label">订单号</label>
	                  <div class="col-sm-2">
		                <input type="text" class="form-control input-small" id="orderNumber" name="orderNumber" value="${orderReturn.orderNumber}" placeholder="请输入商品名称">
		              </div>
	                </div>
	              </div>
	              
	               <div class="col-sm-3 layui-form-item layui-form-btns" style="float: right;margin-top: 50px;">
					     <button type="submit" class="btn btn-info pull-left" onclick="saveOrUp()">提交</button>
					     <button type="reset" id="reset" class="btn btn-info pull-left">重置</button>
				   </div>
				   
	            </form> 
	            <!-- 增删改图标按钮组 -->
	            <div class="site-demo-button" >
					<!-- 频道信息新增 Modal start -->
					<div class="modal hide fade" id="addChannelInfoModal"  tabindex="-1" role="dialog">
					<div class="modal-header"><button class="close" type="button" data-dismiss="modal">×</button>
					<h3>新增频道信息</h3>
					</div>
					<div class="modal-body"></div>
					</div>
	            
	            
				</div>
	            <!-- 表单end -->
	            <!-- /.box-header -->
	            <div class="layui-form"  style="margin-top:40px;">
	              <table class="layui-table table-striped">
	                <thead >
		             <tr >
		                <th>订单号</th>
		                <th>商品名称</th>
		                <th>买家店铺名称</th>
		                <th>商品金额</th>
		                <th>应退金额</th>
		                <th>实退金额</th>
		                <th>备注</th>
		                <th>创建时间</th>
		                <th>操作</th>
		              </tr>
	                </thead>
	                <tbody>
		              <c:forEach items="${paginator.object}" var="r"> 
			   			 <tr>
						       <td>${r.orderNumber}</td>
						       <td>${r.orderItem.goodsFormat.formatName}</td>
						       <td>${r.buyer.buyerName}</td>
						       <td>${r.orderItem.goodsFormat.formatPrice}</td>
						       <td>${r.shouldReturn}</td>
						       <td>${r.actualReturn}</td>
							   <td>${r.remark}</td>
						       <td><fmt:formatDate value="${r.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						       <td>
							       	<a href="#" onclick="get(${r.id})" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
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
	var format_name=$("#formatName").val();
	var order_number=$("#orderNumber").val();
	(format_name == undefined)? formatName = "" :formatName = format_name;
	(order_number == undefined)? orderNumber = "" :orderNumber = order_number;
	window.location.href="/admin/orderReturn/list?pageNum="+currentPage+
			"&orderItem.goodsFormat.formatName="+orderNumber+"&orderNumber="+orderNumber;
}  
</script>
<script>
//重置
$(function(){
   $("#reset").click(function(){
    $("#formatName").attr("value","");
    $("#orderNumber").attr("value","");
   });
  });
  
/* 查看 */
function get(id) {
    layer.open({
        type: 2,
        title: '订单项详情',
        shadeClose: true,
        shade: 0.8,
        area: ['50%', '50%'],
        content: "/admin/orderItem/getView?id="+id
    }); 
}

layui.use('form', function(){
	  var $ = layui.jquery, form = layui.form();
	  
	  //全选
	  form.on('checkbox(allChoose)', function(data){
	    var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]');
	    child.each(function(index, item){
	      item.checked = data.elem.checked;
	    });
	    form.render('checkbox');
	  });
	  
});
</script>
</body>
</html>