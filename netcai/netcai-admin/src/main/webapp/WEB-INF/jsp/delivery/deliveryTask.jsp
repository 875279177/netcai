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
<body class="hold-transition skin-blue sidebar-mini">
  <!-- 配送人员列表start -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
    <c:choose> 
		 <c:when test="${status == 0}">   
      		<h1>选择${delivery.deliveryName}今天配送订单：</h1>
		 </c:when> 
		 <c:when test="${status == 1}">   
      		<h1>${delivery.deliveryName}今天配送订单：</h1>
		 </c:when> 
		 <c:when test="${status == -1}">   
      		<h1>${delivery.deliveryName}历史配送订单：</h1>
		 </c:when> 
		 <c:otherwise>   
		 </c:otherwise> 
	</c:choose>
    </section>
    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
              <!-- 表单end -->
              
              
              <div class="row">
			<div class="col-sm-12">
			<div class="pull-left">
			<c:choose> 
				 <c:when test="${status == 0}">   
		            <button type="button" class="btn btn-primary" id="addTask" 
					    data-complete-text="Loading finished" >分配订单
					</button>
				 </c:when> 
				 <c:otherwise>   
				 </c:otherwise> 
			</c:choose>
			</div>
			</div>
			</div>
            <!-- /.box-header -->
            <div class="layui-form"  >
            <input type="hidden" name="deliveryId" id="deliveryId" value="${deliveryId}">
              <table id="contentTable" class="layui-table table-striped">
                <thead >
	             <tr >
	             	<c:choose> 
						 <c:when test="${status == 0}">   
	             			<th><input type="checkbox"  lay-skin="primary" lay-filter="allChoose"></th>
						 </c:when> 
						 <c:otherwise>   
						 </c:otherwise> 
					</c:choose>
	                <th>订单号</th>
	             	<th>送货时间</th>
	                <th>订单金额</th>
	                <th>买家店铺</th>
	                <th>餐馆地址</th>
					 <c:if test="${status == 1}">   
             			<th>操作</th>
					 </c:if> 
	              </tr>
                </thead>
                <tbody>
	              <c:forEach items="${list}" var="r"> 
		   			 <tr>
		   			 <c:choose> 
						 <c:when test="${status == 0}">   
	   			 			<td><input type="checkbox" id="${r.orderId}" lay-skin="primary" class="i-checks"></td>
						 </c:when> 
						 <c:otherwise>   
						 </c:otherwise> 
					</c:choose> 
				       <td>${r.orderNumber}</td>
	   			 	   <td><fmt:formatDate value="${r.bestTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				       <td>${r.orderAmount}</td>
				       <td>${r.buyerName}</td>
				       <td>${r.buyerAddress}</td>
				       <c:if test="${status == 1}">
             			<th>
             				<button type="button" class="btn btn-primary" onclick="del(${r.orderId },${deliveryId})"  data-complete-text="Loading finished" >移除订单</button>
             			</th>
					 </c:if> 
		             </tr>
				   </c:forEach>
                </tbody>
              </table>
              </div>
	     </div>
	  </div>
	</section>
	</div>
  <!-- 配送人员列表end -->
    </section>
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

//修改状态；
$(function() { 
    $("#addTask").click(function(){
    	var deliveryId=$("#deliveryId").val();
		  var orderIds = new Array();
		  $("#contentTable tbody tr td input.i-checks:checkbox").each(function(){
		    if(true == $(this).is(':checked')){
		    	orderIds.push($(this).attr("id"));
		    }
		  });
		  if(orderIds.length<1){
			top.layer.alert('请至少选择一条数据!', {icon: 0, title:'警告'});
			return;
		  }
 		//询问框
	    layer.msg('选择订单', {
	       time: 0 //不自动关闭
	      ,icon: 6
	      ,btn: ['保存','取消']
	    ,btn1: function(index){
	        layer.close(index);
	        layer.confirm('确定分配订单？', {
	        	  btn: ['确定','取消'] //按钮
	        	}, function(){
	        	  $.ajax({  
			            url:"/admin/delivery/addTask",
			            data:{"orderIds":orderIds,"deliveryId":deliveryId},//
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
	      }
	    });
	});
});

//删除任务;
//任务分配;
  function del(orderId,deliveryId){
   if(orderId == '' || orderId == undefined || orderId == null || deliveryId == '' || deliveryId == undefined || deliveryId == null){
	   alert("参数为空，稍后再试！");
	   return;
   }
	//询问框
    layer.msg('确定删除?', {
       time: 0 //不自动关闭
      ,icon: 6
      ,btn: ['确定','退出']
    ,btn1: function(index){
        layer.close(index);
        $.ajax({  
            url:"/admin/delivery/delTask",
            data:{"orderId":orderId,"deliveryId":deliveryId},
            dataType:"json",  
            success:function(data){ 
            	var code = data.code;
            	var message = data.message;
            	layer.msg(message, {icon: 6});
                location.reload();
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