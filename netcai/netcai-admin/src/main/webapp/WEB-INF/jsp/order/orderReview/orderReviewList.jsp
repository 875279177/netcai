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
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>评论管理</h1>
    </section>
    <!-- Main content -->
    <shiro:hasPermission name="orderReview:query">
	    <section class="content">
	      <div class="row">
	        <div class="col-xs-12">
	          <div class="box">
	            <div class="box-header">
	              <h3 class="box-title">评论详细信息</h3>
	            </div>
	            <!--  表单start -->
	            <form id="withdrawalBank" class="layui-form" action="<%=request.getContextPath() %>/admin/orderReview/list" method="post" >
	            <input type="text" name="orderItemId" value="${orderReview.orderItemId}" hidden="">
	              <div class="box-body">
	                <div class="form-group" >
	                  <label for="seller.sellerName" class="col-sm-1 control-label">卖家店铺名称</label>
	                  <div class="col-sm-2">
		                <input type="text" class="form-control input-small" id="sellerName" name="seller.sellerName" value="${orderReview.seller.sellerName}" placeholder="请输入卖家店铺名称">
		              </div>
		              
	                  <label for="goods.goodsName" class="col-sm-1 control-label">商品名称</label>
	                  <div class="col-sm-2">
		                <input type="text" class="form-control input-small" id="goodsName" name="goods.goodsName" value="${orderReview.goods.goodsName}" placeholder="请输入商品名称">
		              </div>
	                </div>
	              </div>
	              
	               <div class="col-sm-3 layui-form-item layui-form-btns" style="float: right;margin-top: 50px;">
					     <button type="submit" class="btn btn-info pull-left" onclick="saveOrUp()">提交</button>
					     <button type="reset" id="reset" class="btn btn-info pull-left" >重置</button>
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
		                <th>卖家店铺名称</th>
		                <th>商品规格</th>
		                <th>商品名称</th>
		                <th>评论等级</th>
		                <th>评论内容</th>
		                <th>评论人</th>
		                <th>评论时间</th>
		                <th>状态</th>
		                <th>操作</th>
		              </tr>
	                </thead>
	                <tbody>
		              <c:forEach items="${paginator.object}" var="r"> 
			   			 <tr>
						       <td>${r.seller.sellerName}</td>
						       <td>${r.goodsformat.formatId}</td>
						       <td>${r.goods.goodsName}</td>
						       <td>${r.reviewGrade}</td>
						       <td>${r.reviewDesc}</td>
						       <td>${r.buyer.bossName}</td>
						       <td><fmt:formatDate value="${r.reviewTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						       <td><c:if test="${r.reviewStatus==-1}">不显示</c:if>
								   <c:if test="${r.reviewStatus==1}">显示</c:if>
								</td>
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
	var seller_name=$("#sellerName").val();
	var goods_name=$("#goodsName").val();
	(seller_name == undefined)? sellerName = "" :sellerName = seller_name;
	(goods_name == undefined)? goodsName = "" :goodsName = goods_name;
	window.location.href="/admin/orderReview/list?pageNum="+currentPage+
			"&seller.sellerName="+sellerName+"&goods.goodsName="+goodsName;
}  
</script>
<script>
//重置
$(function(){
   $("#reset").click(function(){
    $("#sellerName").attr("value","");
    $("#goodsName").attr("value","");
   });
  });
//修改数据
function update(id){
	  $.ajax({
		  type: 'POST',
		  url: '/admin/withdrawalBank/getById?id='+id,
		  dataType: 'json',
		  success: function (data) {
			  $("#id").attr("value", data.id);
			  $("#paramCode").attr("value", data.paramCode);
			  $("#paramName").attr("value", data.paramName);
			  $("#paramValue").attr("value", data.paramValue);
			  $("#paramDesc").attr("value", data.paramDesc);
			  popup('修改系统配置','800px','350px',$('#content').html());
		  }
	  });
}

/* 查看 */
function get(id) {
    layer.open({
        type: 2,
        title: '订单项详情',
        shadeClose: true,
        shade: 0.8,
        area: ['50%', '50%'],
        content: "/admin/orderReview/getView?id="+id
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