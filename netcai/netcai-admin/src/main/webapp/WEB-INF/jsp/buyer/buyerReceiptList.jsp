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
<body class="hold-transition skin-blue sidebar-mini">
  <!-- 广告信息列表start -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) --> 
    <section class="content-header">
      <h1>线下收款信息管理</h1>
    </section>
    <!-- Main content -->
    <shiro:hasPermission name="buyerReceipt:query">
	    <section class="content">
	      <div class="row">
	        <div class="col-xs-12">
	          <div class="box">
	          <div class="box-header">
	              <h3 class="box-title">线下收款信息管理 </h3>
	            </div>
		        <div class="box box-info">
		           <!-- form start -->
		           <form  id="form_submit" class="form-horizontal layui-form" action="/admin/buyerReceipt/list">
		             <input type="hidden" name="pageNum" id="pageNum" value="${paginator.currentPage}">
	              <input type="hidden" name="pageSize" id="pageSize" value="${paginator.pageRecord}">
		           <div class="box-body">
		               <div class="col-sm-12" >
			               <div class="form-group">
	         		        <label for="areaId" class="col-xs-1 control-label">区域：</label>
			                 <div class="col-xs-2" >
			                   <select id="areaId" name="areaId" class="form-control" >
								   <option value="" >全部</option>
							   </select>
			                 </div>
	                          <label for="saleId" class="col-xs-1 control-label">销售人员</label>
				              <div class="col-xs-2">
				                <select id="saleId" name="saleId" class="form-control" >
								  <option value="" >全部</option>
								</select>
				              </div>
				              <label for="deliveryId" class="col-xs-1 control-label">物流人员</label>
				              <div class="col-xs-2">
				                <select id="deliveryId" name="deliveryIds" class="form-control" multiple="multiple">
								  <option value="" >全部</option>
								</select>
				              </div>
		               </div>
		               </div>
		               <div class="col-sm-12">
			               <div class="form-group">
							 <label for="skStatus" class="col-xs-1 control-label">收款状态</label>
							 <div class="col-xs-2">
							   <select id="skStatus" name="skStatus" class="form-control" >
								 <option value="" selected>全部</option>
								 <option value="1" <c:if test="${buyerReceipt.skStatus == 1}">selected</c:if>>未收</option>
								 <option value="2" <c:if test="${buyerReceipt.skStatus == 2}">selected</c:if>>已收</option>
							   </select>
							 </div>
							 <label for="hsStatus" class="col-xs-1 control-label">核实状态</label>
							 <div class="col-xs-2">
							   <select id="hsStatus" name="hsStatus" class="form-control" >
								 <option value="" selected>全部</option>
								 <option value="1" <c:if test="${buyerReceipt.hsStatus == 1}">selected</c:if>>未核实</option>
								 <option value="2" <c:if test="${buyerReceipt.hsStatus == 2}">selected</c:if>>已核实</option>
							   </select>
							 </div>
							 <label for="alike" class="col-xs-1 control-label">收款差异</label>
							 <div class="col-xs-2">
							   <select id="alike" name="alike" class="form-control" >
								 <option value="" selected>全部</option>
								 <option value="1" <c:if test="${buyerReceipt.alike == 1}">selected</c:if>>有差异</option>
							   </select>
							 </div>
			               </div>
		               </div>
		             <div class="col-sm-12">
			               <div class="form-group">
			               	<label for="beatTimeStart" class="col-xs-1 control-label">送达开始</label>
			                 <div class="col-xs-2">
			                   <input type="date" class="form-control" id="beatTimeStart" name="beatTimeStart" value="${buyerReceipt.beatTimeStart}" placeholder="请送达开始时间">
			                 </div>
			                 <label for="beatTimeStop" class="col-xs-1 control-label">送达结束</label>
			                 <div class="col-xs-2">
			                   <input type="date" class="form-control" id="beatTimeStop" name="beatTimeStop" value="${buyerReceipt.beatTimeStop}" placeholder="请选择送达结束时间">
			                 </div>
			                 <label for="buyerName" class="col-xs-1 control-label">买家店铺</label>
							 <div class="col-xs-2">
							 	<input type="text" class="form-control" id="buyerName" name="buyerName" value="${buyerReceipt.buyerName}" placeholder="请输入买家店铺">
							 </div>
			               </div>
		               </div>
		               <div class="col-sm-12">
			               <div class="form-group">
							 <label for="skReamk" class="col-xs-1 control-label">备注</label>
							 <div class="col-xs-2">
							 	<input type="text" class="form-control" id="skReamk" name="skReamk" value="${buyerReceipt.skReamk}" placeholder="请输入备注信息">
							 </div>
			               </div>
		               </div>
		                <div class="form-footer" >
							<button type="submit" class="btn btn-info pull-left" onclick="submit()">提交</button>
				            <button type="reset" id="reset" class="btn btn-info pull-left" style="margin-left:6px;">重置</button>
						</div>
						</div>
		           </form>
		           
		           <!-- form end -->
		        </div>
		        
		        <div class="row">
				    <div class="col-sm-12">
					    <div class="pull-left">
			                <button type="button" class="btn btn-primary" id="countYSAmt" data-complete-text="Loading finished" >计算订单金额</button>
			                <button type="button" class="btn btn-primary" id="countSSAmt" data-complete-text="Loading finished" >计算实收金额</button>
			                <button type="button" class="btn btn-primary" id="export" data-complete-text="Loading finished" >导出</button>
			                <button type="button" class="btn btn-primary" id="operation" data-complete-text="Loading finished" >操作</button>
					    </div>
				    </div>
				</div>
				
				<!-- 表格列表start -->
	            <div class="layui-form">
		           <div class="box-body">
		             <table id="contentTable" class="layui-table table-striped">
		               <thead>
			              <tr>
			                <th><input type="checkbox"  lay-skin="primary" lay-filter="allChoose"></th>
			                <th>区域</th>
			                <th>买家店铺</th>
			                <th>物流司机</th>
			                <th>销售人员</th>
			                <th>原订单总金额</th>
			                <th>最终总金额</th>
			                <th>实收款金额</th>
			                <th style="width: 350px">信息备注</th>
			                <th>收款时间</th>
			                <th>送货时间</th>
			                <th>核实状态</th>
			                <th>入账状态</th>
			                <th style="width: 200px">操作</th>
			              </tr>
		               </thead>
		               <tbody>
		               <c:forEach items="${paginator.object}" var="r"> 
			   			 <tr>
					       <td><input type="checkbox" id="${r.brId}" lay-skin="primary" class="i-checks"></td>
					       <td>${r.areaName}</td>
					       <td><a style="color: blue;" href="/admin/orderItem/getAll?buyerId=${r.buyerId}&bestTime=<fmt:formatDate value='${r.receiptDate }' pattern='yyyy-MM-dd HH:mm:ss'/>&pageSize=30&payStatus=3,4">${r.buyerName}</a></td>
					       <td>${r.deliveryName}</td>
					       <td>${r.trueName}</td>
					       <td>${r.oldAmt}</td>
					       <td>
					       		<c:choose>
					       			<c:when test="${r.ssAmt == r.totalAmount}">
					       				${r.totalAmount}
					       			</c:when>
					       			<c:otherwise>
					       				<span style="color: blue;">${r.totalAmount}</span>
					       			</c:otherwise>
					       		</c:choose>
					       </td>
					       <td>
			       				<a href="#" id="${r.brId},,${r.ssAmt}" class="ssAmt">${r.ssAmt}</a>
					       </td>
					       <td>
					       		<a href="#" id="${r.brId}" class="skReamk">${r.skReamk}</a>
				       		</td>
					       <td><fmt:formatDate value="${r.skTime }" pattern="yyyy-MM-dd"/></td>
					       <td><fmt:formatDate value="${r.receiptDate }" pattern="yyyy-MM-dd"/></td>
					       <td>
					         <c:if test="${r.hsStatus==1 }">未核实</c:if>
					         <c:if test="${r.hsStatus==2 }">已核实</c:if>
					       </td>
					       <td>
					         <c:if test="${r.rzStatus==1 }">未入账</c:if>
					         <c:if test="${r.rzStatus==2 }">已入账</c:if>
					       </td>
					       <td>
					         <div class="site-demo-button" >
							     <c:if test="${r.hsStatus==1}">
							       <button onclick="updateHSStatus(${r.brId },2)" class="layui-btn layui-btn-warm layui-btn-small"><i class="layui-icon"></i><span>&nbsp;&nbsp;核实</span></button>
							     </c:if>
							     <c:if test="${r.rzStatus==1}">
							       <button onclick="updateRZStatus(${r.brId },2)" class="layui-btn layui-btn-warm layui-btn-small"><i class="layui-icon"></i><span>&nbsp;&nbsp;入账</span></button>
							     </c:if>
							 </div>
					       </td>
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
<input type="hidden" id="saleIdVO" value="${buyerReceipt.saleId}"/>
<input type="hidden" id="areaIdVO" value="${buyerReceipt.areaId}"/>
<input type="hidden" id="deliveryIdsVO" value="${buyerReceipt.deliveryIds}"/>
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
	$('#form_submit').submit();
} 


//保存、修改数据
function submit(){
	  $('#form_submit').validate({ 		
			submitHandler: function (form) {
				$('#form_submit').submit();
			}
		});
}
//重置
$(function(){
   $("#reset").click(function(){
	   window.location.href="/admin/buyerReceipt/list";
   });
  });
</script>
<script>
   //新增数据弹窗
   layui.use(['layer','jquery','form','element', 'layedit', 'laydate'], function(){ //独立版的layer无需执行这一句
	   var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句  
	   var form = layui.form(),layer = layui.layer,layedit = layui.layedit,laydate = layui.laydate;
	   layui.selMeltiple($);
	   //触发事件
	   $('.site-demo-button .layui-btn').on('click', function(){
	       var othis = $(this), method = othis.data('method');
	       active[method] ? active[method].call(this, othis) : '';
	   });
	   
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
   
//更改核实状态;
function updateHSStatus(id,statu){
	  $.ajax({
		  type: 'post',
		  url: '/admin/buyerReceipt/updateHSStatus?id='+id+"&status="+statu,
		  dataType: 'json',
		  success: function (data) {
			  var msg = data.message;
			  if(data.code==200||data.code==201){
			  alert(msg);
			  window.location.reload();
			  }else{
				  alert("更新失败！");
			  }
		  }
	  });
}

//计算金额；
$(function() { 
    $("#countYSAmt").click(function(){
    	var ids = new Array();
		  var ysAmts = 0 ;
		  $("#contentTable tbody tr td input.i-checks:checkbox").each(function(){
		    if(true == $(this).is(':checked')){
		    	var ysAmt= $(this).parents().children().eq(8).text()
		    	ysAmts =Number(ysAmt) + Number(ysAmts);
		    	ids.push($(this).attr("id"));
		    }
		  });
		  if(ids.length<1){
			top.layer.alert('请至少选择一条数据!', {icon: 0, title:'警告'});
			return;
		  }else {
			  layer.alert(ysAmts, {icon: 6, title:'订单金额'});
		}
		
	});
});

//计算金额；
$(function() { 
    $("#countSSAmt").click(function(){
    	var ids = new Array();
		  var ysAmts = 0 ;
		  $("#contentTable tbody tr td input.i-checks:checkbox").each(function(){
		    if(true == $(this).is(':checked')){
		    	var ysAmt= $(this).parents().children().eq(9).text()
		    	ysAmts =Number(ysAmt) + Number(ysAmts);
		    	ids.push($(this).attr("id"));
		    }
		  });
		  if(ids.length<1){
			top.layer.alert('请至少选择一条数据!', {icon: 0, title:'警告'});
			return;
		  }else {
			  layer.alert(ysAmts, {icon: 6, title:'实收金额'});
		}
		
	});
});


//更改入账状态
function updateRZStatus(id,statu){
	  $.ajax({
		  type: 'post',
		  url: '/admin/buyerReceipt/updateRZStatus?id='+id+"&status="+statu,
		  dataType: 'json',
		  success: function (data) {
			  var msg = data.message;
			  if(data.code==200||data.code==201){
			  alert(msg);
			  window.location.reload();
			  }else{
				  alert("更新失败！");
			  }
		  }
	  });
}

//导出;
$(function() { 
    $("#export").click(function(){
    	window.location.href="/admin/buyerReceipt/export?"+$('#form_submit').serialize();
    })
})

//修改实收金额
$(function () {
    $('.ssAmt').editable({
        type: "text",                //编辑框的类型。支持text|textarea|select|date|checklist等
        title: "修改实收金额",              //编辑框的标题
        disabled: false,             //是否禁用编辑
        emptytext: "0",          //空值的默认文本
        mode: "popup",              //编辑框的模式：支持popup和inline两种模式，默认是popup
        validate: function (value) { //字段验证
        	arr = $(this).attr('id').split(",,");
        	var reg = new RegExp(/^[0-9]+([.]{1}[0-9]+){0,1}$/); 
	        var brId = arr[0];
	        
        	if (!$.trim(brId)) {
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
            var ssAmt = value;
            $.ajax({
      		  type: 'POST',
      		  url: '/admin/buyerReceipt/updateSSAmt',
      		  data:{"id":brId,"ssAmt":ssAmt},
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

//修改备注
$(function () {
    $('.skReamk').editable({
        type: "text",                //编辑框的类型。支持text|textarea|select|date|checklist等
        title: "修改备注",              //编辑框的标题
        disabled: false,             //是否禁用编辑
        emptytext: "无",          //空值的默认文本
        mode: "popup",              //编辑框的模式：支持popup和inline两种模式，默认是popup
        validate: function (value) { //字段验证
        	brId = $(this).attr('id');
	        
        	if (!$.trim(brId)) {
        		layer.msg("id不能为空!", {icon: 5});
        		location.reload();
        		return;
            }
            if (!$.trim(value)) {
            	layer.msg('备注不能为空!', {icon: 5});
            	location.reload();
            	return;
            }
            var skReamk = value;
            $.ajax({
      		  type: 'POST',
      		  url: '/admin/buyerReceipt/updateSKReamk',
      		  data:{"id":brId,"skReamk":skReamk},
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
   
//获取销售人员列表;
$(document).ready(function(){
	loadsaleId(); 
	loaddeliveryId();
	loadarea();
	}); 
	
var saleId = $('#saleIdVO').val();
function loadsaleId(){
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
	
var deliveryIds = $('#deliveryIdsVO').val();
function loaddeliveryId(){
	var ids = new Array();
	if(deliveryIds == null |deliveryIds  == '' ||deliveryIds == undefined){
		ids.push(0);
	}else{
		var ids = deliveryIds.split(",");
		ids = stringToInt(ids);
	}
	  var url='/admin/delivery/getDelivery'; 
	  jQuery.ajax({ 
	    type:'post', 
	    url:url, 
	    async:false,
	    success:function (date){
   	   var r = date.object;
         if(r != null && r.length > 0){
           for(var i = 0; i< r.length; i++){
        	   if(contains(ids, r[i].id)){
        		   $("<option value='"+r[i].id+"' selected>"+r[i].deliveryName+"</option>").appendTo("#deliveryId");  
        	   }else{
               $("<option value='"+r[i].id+"'>"+r[i].deliveryName+"</option>").appendTo("#deliveryId");  
        	   }
           }  
         } 
	    } 
	  }); 
	}
//判断arr里是否含有 obj元素;
function contains(arr, obj) {  
    var i = arr.length;  
    while (i--) {  
        if (arr[i] === obj) {  
            return true;  
        }  
    }  
    return false;  
} 
//将集合ar里的String转int
function stringToInt(ar) {
	var ids = new Array();
    var r = ar.length;
    for(var i = 0; i< r; i++){
    	ids.push(Number(ar[i]));
    }
    return ids;
}

var areaId = $('#areaIdVO').val();
function loadarea(){
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
        	 if(areaId == 0){
        	 $("<option value='' selected>"+"全部"+"</option>").appendTo("#areaId");
        	 }else{
        		 $("<option value=''>"+"全部"+"</option>").appendTo("#areaId");
        	 }
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
	

//修改状态；
$(function() { 
  $("#operation").click(function(){
		  var ids = new Array();
		  $("#contentTable tbody tr td input.i-checks:checkbox").each(function(){
		    if(true == $(this).is(':checked')){
		    	ids.push($(this).attr("id"));
		    }
		  });
		  if(ids.length<1){
			top.layer.alert('请至少选择一条数据!', {icon: 0, title:'警告'});
			return;
		  }
// 		  alert(ids);
// 		  return false;
		//询问框
	    layer.msg('选择状态', {
	       time: 0 //不自动关闭
	      ,icon: 6
	      ,btn: ['入账','核实','退出']
	    ,btn1: function(index){
	        layer.close(index);
	        layer.confirm('确定入账？', {
	        	  btn: ['确定','取消'] //按钮
	        	}, function(){
	        	  $.ajax({  
			            url:"/admin/buyerReceipt/batchUpdateRZStatus",
			            data:{"ids":ids,"status":2},
			            dataType:"json",  
			            success:function(data){ 
			            	var code = data.code;
			            	if(code =='200'){
			            		parent.layer.msg("操作成功", {icon: 6});
			            	}else{
			            		parent.layer.msg(data.message, {icon: 5},{time: 3500});
			            	}
			                location.reload();
			            }  
			        });
	        	}, function(){
	        	  return;
	        	});
	      }
	    ,btn2: function(index){
	        layer.close(index);
	        layer.confirm('确定核实？', {
	        	  btn: ['确定','取消'] //按钮
	        	}, function(){
	        	  $.ajax({  
			            url:"/admin/buyerReceipt/batchUpdateHSStatus",
			            data:{"ids":ids,"status":2},
			            dataType:"json",  
			            success:function(data){ 
			            	var code = data.code;
			            	if(code =='200'){
			            		parent.layer.msg("操作成功", {icon: 6});
			            	}else{
			            		parent.layer.msg(data.message, {icon: 5},{time: 3500});
			            	}
			                location.reload();
			            }  
			        });
	        	}, function(){
	        	  return;
	        	});
	      }
	    ,btn3: function(index){
	        layer.close(index);
	      }
	    });
	});
});
</script>
</body>
</html>