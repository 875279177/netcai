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
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- 引入公共部分jsp文件 -->
  <meta name="decorator" content="default"/>
  <style type="text/css">
    .layui-form-label{
      width:100px;
    }
    
    .layui-input-block{
      width:auto;
      height:auto;
      position:relative;
	  left:800px;
    }
    table th{
      background:#ffffff;
    }
	table tr:nth-child(odd){
	  background:#F0F0F0;
	}
	.col-sm-2 {
	  width: 10%;
	}
  </style>
</head>
<body class="hold-transition skin-blue sidebar-mini">
  <!-- 广告信息列表start -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) --> 
    <section class="content-header">
      <h1>销售业绩管理</h1>
    </section>
    <!-- Main content -->
    <shiro:hasPermission name="salesPerf:query">
	    <section class="content">
	      <div class="row">
	        <div class="col-xs-12">
	          <div class="box">
	            <div class="box-header">
	              <h3 class="box-title">销售业绩列表 </h3>
	            </div>
		        <div class="box box-info">
		           <!-- form start -->
		           <form  id="form_submit" class="form-horizontal" action="/admin/salesPerf/list">
		             <input type="hidden" name="pageNum" id="pageNum" value="${paginator.currentPage}">
	              <input type="hidden" name="pageSize" id="pageSize" value="${paginator.pageRecord}">
		               <div class="col-sm-12" style="top: 20px">
			               <div class="form-group">
	                          <label for="createTimeStart" class="col-sm-2 control-label">下单起始时间：</label>
							    <div class="col-xs-2">
				                    <input type="text" name="createTimeStart" id="createTimeStart" value="${salesPerf.createTimeStart}" class="form-control input-small" placeholder="请选择下单开始时间">
				                </div>
				                <label for="createTimeStop" class="col-sm-2 control-label">下单结束时间：</label>
			                    <div class="col-xs-2">
				                    <input type="text" name="createTimeStop" id="createTimeStop" value="${salesPerf.createTimeStop}"  class="form-control" placeholder="请输入下单结束时间">
				                </div>
				                <label for="saleId" class="col-sm-2 control-label">销售姓名</label>
			                 <div class="col-xs-2">
			                   <select id="saleId" name="salesId" class="form-control" >
								   <option value="" >全部</option>
							   </select>
			                 </div>
			               </div>
			               <div class="form-group">
							    <label for="beatTimeStart" class="col-sm-2 control-label">送达起始时间：</label>
			                    <div class="col-xs-2">
				                    <input type="text" name="beatTimeStart" id="beatTimeStart" value="${salesPerf.beatTimeStart}" class="form-control input-small" placeholder="请选择送达开始时间">
				                </div>
				                <label for="beatTimeStop" class="col-sm-2 control-label">送达结束时间：</label>
			                    <div class="col-xs-2">
				                    <input type="text" name="beatTimeStop" id="beatTimeStop" value="${salesPerf.beatTimeStop}"  class="form-control" placeholder="请输入送达结束时间">
				                </div>
				            </div>
		               </div>
		               
		               <div class="box-footer" style="top: 100px">
		                 <button type="submit" class="btn btn-info">查询</button>
		                 <button type="reset"  id="reset" class="btn btn-info">重置</button>
		               </div>
		           </form>
		           
		           <div class="row">
				    <div class="col-sm-12">
					    <div class="pull-left">
						    <button type="button" class="btn btn-primary" id="export" data-complete-text="Loading finished" >导出</button>
					    </div>
				    </div>
				</div>
		           <!-- form end -->
		        </div>
				<!-- 表格列表start -->
	            <div class="box">
		           <div class="box-body">
		             <table id="example1" class="table table-bordered table-striped">
		               <thead>
			              <tr>
			                <th>销售姓名</th>
			                <th>卖家店铺名称</th>
			                <th>买家店铺名称</th>
			                <th>金额</th>
			                <th>下单时间</th>
			                <th>送货时间</th>
			              </tr>
		               </thead>
		               <tbody>
		               <c:forEach items="${paginator.object}" var="r"> 
			   			 <tr>
					       <td>${r.trueName}</td>
					       <td>${r.sellerName}</td>
					       <td>${r.buyerName}</td>
					       <td>${r.sumAmount}</td>
					       <td><fmt:formatDate value="${r.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				           <td><fmt:formatDate value="${r.bestTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			             </tr>
					   </c:forEach>
	                  </tbody>
		             </table>
		           </div>
		        </div>
	            <!-- 表格列表end -->
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
  <input type="hidden" id="saleIdVO" value="${salesPerf.salesId}"/>
<script src="/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="/bootstrap/js/bootstrap.min.js"></script>
<script src="/js/raphael-min.js"></script>
<script src="/plugins/sparkline/jquery.sparkline.min.js"></script>
<script src="/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script src="/plugins/knob/jquery.knob.js"></script>
<script src="/js/moment.min.js"></script>
<script src="/plugins/daterangepicker/daterangepicker.js"></script>
<script src="/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script src="/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="/plugins/fastclick/fastclick.js"></script>
<script src="/dist/js/app.min.js"></script>
<script src="/dist/js/demo.js"></script>
<script src="/js/jquery-ui.min.js"></script>
<script src="/layer/layer.js"></script>
<script charset="utf-8" src="/My97DatePicker/WdatePicker.js"></script>
<script src="/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript">
function onSelectPage(currentPage,pageSize)
{  
	$('#pageNum').val(currentPage);
	$('#pageSize').val(pageSize);
	$('#form_submit').submit();
} 

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

//导出;
$(function() { 
    $("#export").click(function(){
    	window.location.href="/admin/salesPerf/export?"+$('#form_submit').serialize();
    })
})

//重置
$(function(){
   $("#reset").click(function(){
	   window.location.href="/admin/salesPerf/list";
   });
  });
</script>
<script>
   //新增数据弹窗
   layui.use(['layer','jquery','form','element'], function(){ //独立版的layer无需执行这一句
	   var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句  
	   //触发事件
	   $('.site-demo-button .layui-btn').on('click', function(){
	       var othis = $(this), method = othis.data('method');
	       active[method] ? active[method].call(this, othis) : '';
	   });
	});
   
 //获取销售人员列表;
   $(document).ready(function(){
   	loadregion(); 
   	}); 
   	
   var saleId = $('#saleIdVO').val();
   function loadregion(){
   	if(saleId == null || saleId == '' ||saleId == undefined){
   		saleId = 0;
   	}
   	  var url='/admin/sales/salesList'; 
   	  jQuery.ajax({ 
   	    type:'post', 
   	    url:url, 
   	    async:false,
   	    success:function (date){
      	   var r = date.object;  
            if(r != null && r.length > 0){
               for(var i = 0; i< r.length; i++){
                   if(r[i].id == saleId){
                	   $("<option value='"+r[i].id+"' selected>"+r[i].realName+"</option>").appendTo("#saleId");
                   }else {
                   $("<option value='"+r[i].id+"'>"+r[i].realName+"</option>").appendTo("#saleId");  
   			}
               }  
            } 
   	    } 
   	  }); 
   	}
</script>
</body>
</html>