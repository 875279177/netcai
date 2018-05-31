<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="pv" uri="/pageTaglib"%>
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
      <h1>${buyer.buyerName}/新增清单管理</h1>
    </section>
    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <!-- 表单start -->
            <form id="submitForm" class="form-horizontal" action="<%=request.getContextPath() %>/admin/buyerCommon/toAdd" method="post" >
			       <input type="hidden" name="buyerId"  value="${buyer.buyerId}" >
			       <input type="hidden" name="buyerName" id="buyerName" value="${buyer.buyerName}"  >
			       <input type="hidden" name="regionId" id="regionId" value="${buyer.regionId}"   >
               <input type="hidden" name="pageNum" id="pageNum" value="${paginator.currentPage}">
              <input type="hidden" name="pageSize" id="pageSize" value="${paginator.pageRecord}">
              <div class="col-sm-12" style="top: 20px">
                <div class="form-group" >
	              	<label for="searchName" class="col-sm-2 control-label">商品信息：</label>
	                 <div class="col-xs-2">
	                   <input type="text" class="form-control" id="searchName" name="searchName" placeholder="请输入商品信息" value="${sgv.searchName}">
	                 </div>
	                 <label for="sellerName" class="col-sm-1 control-label">卖家店铺名称：</label>
	                 <div class="col-sm-2">
	                   <input type="text" class="form-control" id="sellerName" name="sellerName" placeholder="请输入卖家店铺名称" value="${sgv.sellerName}">
	                 </div>
                 	<label for="categoryName" class="col-sm-2 control-label">商品分类：</label>
	                 <div class="col-xs-2">
	                   <input type="text" class="form-control" id="categoryName" name="categoryName" placeholder="请输入商品分类" value="${sgv.categoryName}">
	                 </div>
                </div>
              </div>
              <div class="box-footer" style="top: 50px">
	                 <button type="reset" id="reset" class="btn btn-info pull-right">重置</button>
	                 <button type="submit" class="btn btn-info pull-right" >查询</button>
	               </div>
              </form>
            <!-- 表单end -->
            
            <div class="row">
			<div class="col-sm-12">
			<div class="pull-left">
            <button type="button" class="btn btn-primary" id="save" 
			    data-complete-text="Loading finished" >保存
			</button>
			</div>
			</div>
			</div>
            
            <!-- /.box-header -->
            <div class="layui-form" >
              <table id="contentTable" class="layui-table table-striped">
                <thead>
	             <tr>
	             	<th><input type="checkbox"  lay-skin="primary" lay-filter="allChoose"></th>
	                <th>商品名称</th>
	                <th>商品标签</th>
	                <th>商品品牌</th>
	                <th>卖家店铺名称</th>
	                <th>状态</th>
	                <th>规格</th>
	              </tr>
                </thead>
                <tbody>
	              <c:forEach items="${paginator.object}" var="r"> 
		   			 <tr>
		   			 		<td><input type="checkbox" id="${r.goodsId}" lay-skin="primary" class="i-checks"></td>
					       <td>${r.goodsName}</td>
					       <td>
					       		<c:choose>
		                    		<c:when test="${r.goodsLabel == ''} ">暂无</c:when>
		                    		<c:otherwise>${r.goodsLabel}</c:otherwise>
		                    	</c:choose>
					       </td>
					       <td>
						       <c:choose>
		                    		<c:when test="${r.goodsBrand == ''} ">暂无</c:when>
		                    		<c:otherwise>${r.goodsBrand}</c:otherwise>
		                    	</c:choose>
					       </td>
					       <td>${r.sellerName}</td>
					       <td>
					       		<c:if test="${r.goodsStatus == 1}">上架</c:if>
					       		<c:if test="${r.goodsStatus == -1}">下架</c:if>
					       </td>
					       <td>
					       <table>
				                <tr>
				                    <td>规格</td>
				                    <td>价格</td>
				                </tr>
					       <c:forEach items="${r.formatList}" var="list">
					       		<tr>
				                    <td>
				                    	<c:choose>
				                    		<c:when test="${list.formatName != null || list.formatName != ''} ">${list.formatName}</c:when>
				                    		<c:otherwise>暂无</c:otherwise>
				                    	</c:choose>
				                    </td>
				                    <td>${list.formatPrice}/${list.formatNum}${list.unitName}</td>
				                </tr>
					       </c:forEach>
				            </table>
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
  </div>
<input type="hidden" id="areaIdVO" value="${sysCommonVo.areaId}"/>
<input type="hidden" id="buyerTypeVO" value="${sysCommonVo.buyerTypeId}"/>


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

//重置
 $("#reset").click(function(){
	   	var buyerId = "${buyer.buyerId}";
		  var buyerName = "${buyer.buyerName}";
		  var regionId = "${buyer.regionId}";
	   window.location.href="/admin/buyerCommon/toAdd?buyerId="+buyerId+"&buyerName="+buyerName+"&regionId="+regionId;
 });

//选择页码
function onSelectPage(currentPage,pageSize){  
	$('#pageNum').val(currentPage);
	$('#pageSize').val(pageSize);
	$('#submitForm').submit();
} 

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

//新增数据弹窗
layui.use('layer', function(){ //独立版的layer无需执行这一句
	   var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句  
	  $('.site-demo-button .layui-btn').on('click', function(){
	    var othis = $(this), method = othis.data('method');
	    active[method] ? active[method].call(this, othis) : '';
	  });
	});
	
//保存
$(function() { 
	  var buyerId = "${buyer.buyerId}";
	  var buyerName = "${buyer.buyerName}";
	  var regionId = "${buyer.regionId}";
	  var search = "${sgv.searchName}";
	  var name = "${sgv.sellerName}";
	  var category = "${sgv.categoryName}";
	  (search == undefined)? searchName = "" :searchName = search;
	  (category == undefined)? categoryName = "" :categoryName = category;
	  (name == undefined)? sellerName = "" :sellerName = name;
    $("#save").click(function(){
		  var goodsIds = new Array();
		  $("#contentTable tbody tr td input.i-checks:checkbox").each(function(){
		    if(true == $(this).is(':checked')){
		    	goodsIds.push($(this).attr("id"));
		    }
		  });
		  if(goodsIds.length<1){
				top.layer.alert('请至少选择一条数据!', {icon: 0, title:'警告'});
				return;
			  }
		  if(buyerId==null || buyerId == '' || buyerId  == undefined){
			  alert("请重新添加!");
			  return ;
		  }
 		//询问框
	    layer.msg('确定添加？', {
	       time: 0 //不自动关闭
	      ,icon: 6
	      ,btn: ['确定','取消']
	    ,btn1: function(index){
	        	  $.ajax({  
			            url:"/admin/buyerCommon/add",
			            data:{"goodsIds":goodsIds,"buyerId":buyerId},
			            dataType:"json",  
			            success:function(data){ 
			            	var code = data.code;
			            	var message = data.message;
			            	layer.msg(message, {icon: 6});
					        layer.close(index);
			                location.href="/admin/buyerCommon/toAdd?buyerId="+buyerId+"&buyerName="+buyerName+"&regionId="+regionId+"&searchName="+searchName+"&categoryName="+categoryName+"&sellerName="+sellerName;
			            }  
			        });
	      }
	    ,btn2: function(index){
	        layer.close(index);
	      }
	    });
	});
});
	
</script>
</body>
</html>