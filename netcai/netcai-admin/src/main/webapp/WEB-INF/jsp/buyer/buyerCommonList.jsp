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
<body>
  <!-- 配送人员列表start -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>常用清单管理</h1>
    </section>
    <!-- Main content -->
    <shiro:hasPermission name="buyerCommon:query">
	    <section class="content">
	      <div class="row">
	        <div class="col-xs-12">
	          <div class="box box-info">
	            <!-- 表单start -->
	            <form id="submitForm" class="layui-form" action="<%=request.getContextPath() %>/admin/buyerCommon/list" method="post" >
	               <input type="hidden" name="pageNum" id="pageNum" value="${paginator.currentPage}">
	              <input type="hidden" name="pageSize" id="pageSize" value="${paginator.pageRecord}">
	              <div class="box-body">
	              <div class="col-sm-12">
	                <div class="form-group" >
		              	<label for="buyerName" class="col-sm-1 control-label">买家店铺</label>
		                 <div class="col-xs-2">
		                   <input type="text" class="form-control input-small" id="buyerName" name="buyer.buyerName" placeholder="请输入买家店铺名称" value="${buyerCommonVo.buyer.buyerName}">
		                 </div>
		                 <label for="sellerName" class="col-sm-1 control-label">卖家店铺</label>
		                 <div class="col-xs-2">
		                   <input type="text" class="form-control input-small" id="sellerName" name="goods.seller.sellerName" placeholder="请输入卖家店铺名称" value="${buyerCommonVo.goods.seller.sellerName}">
		                 </div>
	                 <label for="goodsName" class="col-sm-1 control-label">商品名称</label>
		                 <div class="col-xs-2">
		                   <input type="text" class="form-control input-small" id="goodsName" name="goods.goodsName" placeholder="请输入商品名称" value="${buyerCommonVo.goods.goodsName}">
		                 </div>
	                </div>
	              </div>
	              <div class="form-footer">
						<button type="submit" class="btn btn-info pull-left" onclick="saveOrUp()">提交</button>
			            <button type="reset" id="reset" class="btn btn-info pull-left" style="margin-left:6px;">重置</button>
					</div>
					</div>
	              </form>
	            <!-- 表单end -->
	            
	            <!-- 增删改图标按钮组 -->
	            <div class="site-demo-button" >
				<button onclick="add()" class="btn btn-success btn-xs"><i class="layui-icon"></i><span>&nbsp;&nbsp;新增</span></button>
	            <button type="button" class="btn btn-primary" id="del" 
				    data-complete-text="Loading finished" >删除
				</button>
				</div>
	            
	            <!-- /.box-header -->
	            <div class="layui-form" >
	              <table id="contentTable" class="layui-table table-striped">
	                <thead>
		             <tr>
		             	<th><input type="checkbox"  lay-skin="primary" lay-filter="allChoose"></th>
		                <th>商品ID</th>
		                <th>商品名称</th>
		                <th>卖家店铺</th>
		                <th>状态</th>
		                <th>买家店铺名称</th>
		                <th>买家店铺地址</th>
		                <th>买家联系方式</th>
		              </tr>
	                </thead>
	                <tbody>
		              <c:forEach items="${paginator.object}" var="r"> 
			   			 <tr>
			   			 		<td><input type="checkbox" id="${r.bcId}" lay-skin="primary" class="i-checks"></td>
						       <td>${r.goodsId}</td>
						       <td>${r.goods.goodsName}</td>
						       <td>${r.goods.seller.sellerName}</td>
						       <td>
						       		<c:if test="${r.goods.goodsStatus == 1}">上架</c:if>
						       		<c:if test="${r.goods.goodsStatus == -1}">下架</c:if>
						       </td>
						       <td>${r.buyer.buyerName}</td>
						       <td>${r.buyer.buyerAddress}</td>
						       <td>${r.buyer.bossTel}</td>
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
<script src="/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="/bootstrap/js/bootstrap.min.js"></script>
<script src="/bootstrap/js/bootstrap-datetimepicker.js"></script>
<script src="/bootstrap/js/bootstrap-editable.js"></script>
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
//分页
function onSelectPage(currentPage,pageSize){  
	$('#pageNum').val(currentPage);
	$('#pageSize').val(pageSize);
	$('#submitForm').submit();
} 
</script>
<script>
layui.use(['form', 'jquery','layedit', 'laydate'], function(){
	   var form = layui.form(),layer = layui.layer,$ = layui.jquery,
	       layedit = layui.layedit,laydate = layui.laydate;
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

//重置
$(function(){
   $("#reset").click(function(){
	   window.location.href="/admin/buyerCommon/list";
   });
  });

//新增数据弹窗
layui.use('layer', function(){ //独立版的layer无需执行这一句
	   var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句  
	  $('.site-demo-button .layui-btn').on('click', function(){
	    var othis = $(this), method = othis.data('method');
	    active[method] ? active[method].call(this, othis) : '';
	  });
	});
	
//批量删除
$(function() { 
    $("#del").click(function(){
		  var bcIds = new Array();
		  $("#contentTable tbody tr td input.i-checks:checkbox").each(function(){
		    if(true == $(this).is(':checked')){
		    	bcIds.push($(this).attr("id"));
		    }
		  });
		  if(bcIds.length<1){
				top.layer.alert('请至少选择一条数据!', {icon: 0, title:'警告'});
				return;
			  }
 		//询问框
	    layer.msg('确定删除?', {
	       time: 0 //不自动关闭
	      ,icon: 6
	      ,btn: ['确定','取消']
	    ,btn1: function(index){
	        	  $.ajax({  
			            url:"/admin/buyerCommon/delete",
			            data:{"bcIds":bcIds},
			            dataType:"json",  
			            success:function(data){ 
			            	var code = data.code;
			            	var message = data.message;
			            	layer.msg(message, {icon: 6});
					        layer.close(index);
					        location.reload();
			            }  
			        });
	      }
	    ,btn2: function(index){
	        layer.close(index);
	      }
	    });
	});
});
	
//新增;
function add(){
	layer.open({
        type: 2, 
        title: '新增',
        area: ['600px', '500px'],
        shade: 0.5,
        content: '/admin/buyerCommon/toSelect',
        zIndex: layer.zIndex, //重点1
        cache: false,
      });
}
</script>
</body>
</html>