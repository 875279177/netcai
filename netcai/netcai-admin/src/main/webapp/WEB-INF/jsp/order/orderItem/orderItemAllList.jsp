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
  <!-- 买家/卖家订单详细start -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>买家/卖家订单详细</h1>
    </section>
    <!-- Main content -->
    <shiro:hasPermission name="orderItemList:query">
	    <section class="content">
	      <div class="row">
	        <div class="col-xs-12">
	          <div class="box">
	            <div class="box-header">
	              <h3 class="box-title">买家/卖家订单详细信息</h3>
	            </div>
	            <div class="box box-info">
	                <form id="subForm" class="form-horizontal layui-form" action="<%=request.getContextPath() %>/admin/orderItem/getList" method="post" >
	                    <input type="hidden" name="pageNum" id="pageNum" value="${paginator.currentPage}">
	                    <input type="hidden" name="pageSize" id="pageSize" value="${paginator.pageRecord}">
	                    <div class="box-body">
							<div class="col-sm-12">
								<div class="form-group">
								    <label for="buyerNameTel" class="col-sm-2 control-label">买家信息：</label>
					                <div class="col-xs-2">
						                <input type="text" class="form-control input-small" id="buyerNameTel" name="buyerNameTel" value="${orderItemQuery.buyerNameTel}" placeholder="请输入餐馆名称或者买家手机号">
						            </div>
				                    <label for="sellerNameTel" class="col-sm-2 control-label">卖家信息：</label>
					                <div class="col-xs-2">
						                <input type="text" class="form-control input-small" id="sellerNameTel" name="sellerNameTel" value="${orderItemQuery.sellerNameTel}" placeholder="请输入商铺名称或者卖家手机号">
						            </div>
						            <label for="payStatus" class="col-sm-1 control-label">支付状态：</label>
					                <div class="col-xs-2">
						                <select id="orderInfopayStatus" name="pStatus" multiple="multiple" >
									        <option value="" >全部</option>
									        <option value="2" <c:forEach items="${pStatus}" var="pStatus"><c:if test="${fn:contains(pStatus,2)}">selected</c:if></c:forEach>>已付款</option>
								            <option value="3" <c:forEach items="${pStatus}" var="pStatus"><c:if test="${fn:contains(pStatus,3)}">selected</c:if></c:forEach>>线下付款</option>
								            <option value="4" <c:forEach items="${pStatus}" var="pStatus"><c:if test="${fn:contains(pStatus,4)}">selected</c:if></c:forEach>>线下付款已收款</option>
									    </select>
						            </div>
								</div>
								<div class="form-group">
								    <label for="createTimeStart" class="col-sm-2 control-label">下单起始时间：</label>
								    <div class="col-xs-2">
					                    <input type="text" name="createTimeStart" id="createTimeStart" value="${orderItemQuery.createTimeStart}" class="form-control input-small" placeholder="请选择下单时间">
					                </div>
					                <label for="createTimeStop" class="col-sm-2 control-label">下单结束时间：</label>
				                    <div class="col-xs-2">
					                    <input type="text" name="createTimeStop" id="createTimeStop" value="${orderItemQuery.createTimeStop}"  class="form-control" placeholder="请选择下单时间">
					                </div>
				                    <label for="tradeStatus" class="col-sm-1 control-label">订单状态：</label>
				                    <div class="col-xs-2">
						                <select id="orderItemQuerytradeStatus" name="tStatus" multiple="multiple" >
								            <option value="" >全部</option>
								            <option value="0" <c:forEach items="${tStatus}" var="tStatus"><c:if test="${fn:contains(tStatus,0)}">selected</c:if></c:forEach>>进行中</option>
								            <option value="1" <c:forEach items="${tStatus}" var="tStatus"><c:if test="${fn:contains(tStatus,1)}">selected</c:if></c:forEach>>已完成</option>
								            <option value="3" <c:forEach items="${tStatus}" var="tStatus"><c:if test="${fn:contains(tStatus,3)}">selected</c:if></c:forEach>>已结算</option>
								        </select>
					                </div>
								</div>
								<div class="form-group">
								    <label for="beatTimeStart" class="col-sm-2 control-label">送货起始时间：</label>
				                    <div class="col-xs-2">
					                    <input type="text" name="beatTimeStart" id="beatTimeStart" value="${orderItemQuery.beatTimeStart}" class="form-control input-small" placeholder="请选择送货起始时间">
					                </div>
					                <label for="beatTimeStop" class="col-sm-2 control-label">送货结束时间：</label>
				                    <div class="col-xs-2">
					                    <input type="text" name="beatTimeStop" id="beatTimeStop" value="${orderItemQuery.beatTimeStop}"  class="form-control" placeholder="请选择送货结束时间">
					                </div>
					                <label for="regionId" class="col-sm-1 control-label">所在区域：</label>
				                    <div class="col-xs-2">
						                <select name="regionId" id="areaId">
									    </select>
					                </div>
					            </div>
							</div>
							<div class="form-footer">
								<button type="submit" class="btn btn-info pull-left" onclick="saveOrUp()">提交</button>
					            <button type="reset" id="reset" class="btn btn-info pull-left" style="margin-left:6px;">重置</button>
							</div>
						</div>
					</form>
			    </div>
	            <div class="row">
				    <div class="col-sm-12">
						<div class="pull-left">
							<button type="button" class="btn btn-primary" id="exportSellerBuyer" data-complete-text="Loading finished" >导出</button>
							<button type="button" class="btn btn-primary" id="exportAllSellerBuyer" data-complete-text="Loading finished" >导出全部</button>
						</div>
				    </div>
				</div>
	            <!-- 订单项详情  -->
	            <div class="layui-form"  style="margin-top:40px;">
	              <table class="layui-table table-striped">
	                <thead >
		             <tr >
		             	<th>所属区域</th>
		                <th style="width: 100px">买家店铺名称</th>
		                <th style="width: 180px">买家地址</th>
		                <th style="width: 80px">买家账号</th>
		                <th style="width: 110px">卖家店铺名称</th>
		                <th>卖家账号</th>
		                <th style="width: 50px">订单号</th>
		                <th style="width: 120px">下单时间</th>
		                <th style="width: 120px">最佳送货时间</th>
		                <th style="width: 50px">原总计</th>
		                <th style="width: 50px">现总计</th>
		                <th>订单状态</th>
		                <th>支付状态</th>
		                <th style="width: 200px">操作</th>
		              </tr>
	                </thead>
	                <tbody>
		              <c:forEach items="${paginator.object}" var="r"> 
			   			 <tr>
						       <td>${r.areaName}</td>
						       <td>${r.buyerName}</td>
						       <td>${r.buyerAddress}</td>
						       <td>${r.bossTel}</td>
						       <td>${r.sellerName}</td>
						       <td>${r.sellerAccount}</td>
						       <td>${r.orderNumber}</td>
						       <td><fmt:formatDate value="${r.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						       <td><fmt:formatDate value="${r.bestTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						       <td>
						       		<c:choose> 
									  <c:when test="${r.totalMoney != r.oldTotalMoney}">   
									  		<span style="color: red;">${r.oldTotalMoney}</span>
									  </c:when> 
									  <c:otherwise>   
									 ${r.oldTotalMoney}
									  </c:otherwise> 
									</c:choose> 
					       		</td>
						       <td>${r.totalMoney}</td>
						       <td><c:if test="${r.tradeStatus==0}">进行中</c:if>
								   <c:if test="${r.tradeStatus==1}">已完成</c:if>
								   <c:if test="${r.tradeStatus==2}">取消交易</c:if>
								   <c:if test="${r.tradeStatus==3}">已结算</c:if>
								</td>
						       <td><c:if test="${r.payStatus==1}">未付款</c:if>
								   <c:if test="${r.payStatus==2}">已付款</c:if>
								   <c:if test="${r.payStatus==3}">线下付款</c:if>
								   <c:if test="${r.payStatus==4}">线下付款已收款</c:if>
								</td>
						       <td>
						          <div class="site-demo-button" >
						            <button  class="layui-btn layui-btn-normal layui-btn-small" onclick="getView(${r.sellerId},${r.buyerId},${r.orderId})"><i class="layui-icon"></i><span>查看</span></button>
						       		<button  data-method="setTop" class="layui-btn layui-btn-normal layui-btn-small" value="${r.buyerId},${r.sellerId},${r.orderNumber}"><i class="layui-icon"></i><span>多退少补</span></button>
						          </div>
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
   <input type="hidden" id="areaIdVO" value="${orderItemQuery.regionId}"/>
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

layui.use('form', function(){
	  var $ = layui.jquery, form = layui.form();
});
//查看;
function getView(sellerId,buyerId,orderId){
	
	window.location.href="/admin/orderItem/getAll?sellerId="+sellerId+"&buyerId="+buyerId+"&orderId="+orderId;
}

//导出;
$(function() { 
    $("#exportSellerBuyer").click(function(){
    	window.location.href="/admin/orderItem/exportSellerBuyer?"+$('#subForm').serialize();
    })
});

//导出全部;
$(function() { 
    $("#exportAllSellerBuyer").click(function(){
    	window.location.href="/admin/orderItem/exportAllSellerBuyer?"+$('#subForm').serialize();
    })
});

//重置
$(function(){
   $("#reset").click(function(){
	   window.location.href="/admin/orderItem/getList";
   });
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
             $("<option value=''>"+"全部"+"</option>").appendTo("#areaId");
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
  
//新增数据弹窗
layui.use('layer', function(){ //独立版的layer无需执行这一句
	   var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句  
	   //触发事件
	   var active = {
			 //多退少补弹窗
	    	 setTop: function(data){ 
	    		 var id = data.val();
			     //多窗口模式，层叠置顶
			     layer.open({
			         type: 2, 
			         title: '订单多退少补',
			         area: ['760px', '435px'],
			         shade: 0.5,
			         anim: 3,//0-6的动画形式，-1不开启
			         content: '/admin/orderRefund/toAdd?id='+id,
			         zIndex: layer.zIndex, //重点1
			         success: function(layero, index){
			        	 layer.setTop(layero);
			        	 var body = layer.getChildFrame('body', index);
			             var iframeWin = window[layero.find('iframe')[0]['name']];
				         
			         }
			     });
			 }
		  };
	   $('.site-demo-button .layui-btn').on('click', function(){
	       var othis = $(this), method = othis.data('method');
	       active[method] ? active[method].call(this, othis) : '';
	   });
	});
</script>
</body>
</html>