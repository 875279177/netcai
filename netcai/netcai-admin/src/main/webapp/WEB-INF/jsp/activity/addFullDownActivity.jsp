<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="pv" uri="/pageTaglib"%>  
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName();
	String port = String.valueOf(request.getServerPort());
	if(port.equals("80")) {
		basePath += path+"/";
	} else {
		basePath += ":" + port+path+"/";
	}
%>
<!DOCTYPE html>
<html>
<head>
  <meta name="decorator" content="default"/> 
  <style type="text/css">
    button{
      margin-right:5px;
    }
    .layui-form-label{
      width:100px;
    }
  </style>
</head>
<body>
  <!-- 活动信息列表start -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>添加满减活动</h1>
    </section>
    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">活动信息</h3>
            </div>
            <!-- 表单start -->
            <form class="form-horizontal" method="post" action="/admin/activity/saveOrUpdate" >
              <input id="activityId" name="activityId" value="${activity.activityId}"  type="hidden"/> 
              <input id="activityChannel" name="activityChannel" value="1"  type="hidden"/> 
              <input id="activityType" name="activityType" value="${activityType}"  type="hidden"/> 
              <div class="box-body">
                <div class="form-group" >
                  <label for="inputEmail3" class="col-sm-2 control-label">活动主题:</label>
                  <div class="col-xs-3">
	                <input id="activityTitle" name="activityTitle" value="${activity.activityTitle}" type="text" class="form-control input-small" />
	              </div>
	              <label for="inputPassword3" class="col-sm-2 control-label">活动状态:</label>
                  <div class="col-xs-3">
	                  <select name="activityStatus" id="activityStatus" class="form-control select2" style="width: 100%;">
		                  <option value="1" <c:if test="${activity.activityStatus==1}">selected</c:if>>在用</option>
		                  <option value="-1" <c:if test="${activity.activityStatus==-1}">selected</c:if>>停用</option>
		              </select>
	              </div>
                </div>
                <div class="form-group" >
                  <label for="inputEmail3" class="col-sm-2 control-label">开始时间:</label>
                  <div class="col-xs-3">
	                <input type="text" name="activityBeginTime" id="activityBeginTime" value="${activity.activityBeginTime}" class="form-control input-small" placeholder="请选择活动开始时间">
	              </div>
	              <label for="inputPassword3" class="col-sm-2 control-label">结束时间:</label>
                  <div class="col-xs-3">
	                <input type="text" name="activityEndTime" id="activityEndTime" value="${activity.activityEndTime}"  class="form-control" placeholder="请输入活动结束时间">
	              </div>
                </div>
                <div class="form-group" >
	              <label for="inputPassword3" class="col-sm-2 control-label">同享规则:</label>
                  <div class="col-xs-3">
	                 <select name="activityShare" id="activityShare" class="form-control select2" style="width: 100%;" onchange="changeType(this.value)">
		                  <option value="1" <c:if test="${activity.activityShare==1}">selected</c:if>>与折扣特价同享(推荐)</option>
		                  <option value="2" <c:if test="${activity.activityShare==2}">selected</c:if>>不与折扣特价同享</option>
		             </select>
	              </div>
                </div>
                <div class="form-group" >
                  <label for="inputEmail3" class="col-sm-2 control-label">活动描述:</label>
                  <div class="col-xs-3">
	                <textarea id="activityDesc" name="activityDesc" rows="5" cols="53">${activity.activityDesc}</textarea>
	              </div>
                </div>
              </div>
              <div class="form-group" >
                  <div class="col-xs-3">
                     <div id="picList" style="width:100%"></div>
                  </div>
              </div>
              <div class="box-header">
                <h3 class="box-title">活动规则</h3>
              </div>
              <div class="box-body">
                <table id="format_dg" title="活动规则" style="height:auto">
				  <thead>
				   <tr>
				    <th data-options="field:'formatTitle',width:200">主题</th>
				    <th data-options="field:'formatFullRmb',width:200">金额满</th>
				    <th data-options="field:'formatMinusRmb',width:100">扣减金额</th>
				    <th data-options="field:'formatStatus',width:100">状态</th>
				   </tr>
				  </thead>
				 </table>
              </div>
              <div class="box-header">
                <h3 class="box-title">活动商家</h3>
              </div>
              <div class="box-body">
                <table id="seller_dg" title="活动商家" style="height:auto">
				  <thead>
				   <tr>
				    <th data-options="field:'sellerName',width:200">店铺名称</th>
				    <th data-options="field:'sellerTel',width:200">手机号码</th>
				   </tr>
				  </thead>
				 </table>
              </div>
              <div class="box-footer">
                <button type="reset" class="btn btn-info pull-right" style="margin-right:40px;">重置</button>
                <button type="submit" class="btn btn-info pull-right"  onclick="saveOrUp();">提交</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </section>
  </div>
  <!-- 活动规则按钮 -->
  <div id="format_tb" style="height:auto">
  	<a href="javascript:void(0)" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="appendFormat()">新增</a>
  	<a href="javascript:void(0)" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="removeitFormat()">删除</a>
  </div>
  <!-- 活动商家按钮 -->
  <div id="seller_tb" style="height:auto;display: none">
  	<a href="javascript:void(0)" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="appendSeller()">新增</a>
  	<a href="javascript:void(0)" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="removeitSeller()">删除</a>
  </div>
  
  <div id="w" class="easyui-window" title="选择商家" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:600px;height:550px;padding:10px;">  
      <form id="subForm" class="form-horizontal" action="" >
        <input name="activityId" value="${activity.activityId}"  type="hidden"/> 
        <div class="box-body">
          <div class="form-group" >
            <label class="col-sm-2 control-label">名称:</label>
            <div class="col-xs-3">
               <input type="text" id="sellerName" name="sellerName" class="form-control input-small" placeholder="请输入店铺名称">
            </div>
            <label class="col-sm-2 control-label">商场:</label>
          </div>
        </div>
        <div class="box-footer">
          <button type="reset" class="btn btn-info pull-right" style="margin-right:40px;" onclick="selectSeller()">确定</button>
          <button type="button" class="btn btn-info pull-right" onclick="searchSeller()">查询</button>
        </div>
      </form>
	  <table id="cg" style="height:360px;width:560px;">   
	  </table>
  </div>
<script src="/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="/bootstrap/js/bootstrap.min.js"></script>
<script src="/js/jquery-ui.min.js"></script>
<script src="/layui/layui.js"></script>
<script src="/dist/js/app.min.js"></script>
<script type="text/javascript" src="/jquery-easyui-1.5.2/jquery.easyui.min.js" charset="utf-8"></script>
<script type="text/javascript" src="/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<script charset="utf-8" src="/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
//初始化时间选择器
$("#activityBeginTime").bind("click focus", function () {
    var endtimeTf = $dp.$('activityEndTime');
    WdatePicker({
        maxDate: '#F{$dp.$D(\'activityBeginTime\')}',
        dateFmt: "yyyy-MM-dd HH:mm",
        onpicked: function () { endtimeTf.focus(); }
    });
});
$("#activityEndTime").bind("click focus", function () {
    WdatePicker({
        minDate: '#F{$dp.$D(\'activityBeginTime\')}',
        dateFmt: "yyyy-MM-dd HH:mm"
    });
});
//活动规则
$("#format_dg").datagrid({
	url:'',
	toolbar:"#format_tb",
	fitColumns:"true",
	singleSelect : true,
	rownumbers:true
});
//初始化活动商家
$("#seller_dg").datagrid({
	url:'',
	width: '100%',
	toolbar:"#seller_tb",
	fitColumns:"true",
	singleSelect : true,
	rownumbers:true
});
//活动规则行数
var format_index = ${fn:length(activity.activityFormatVoList)};
//活动商家行数
var seller_index = ${fn:length(activity.activitySellerVoList)};
//添加活动规则行
function appendFormat(){
  $("#format_dg").datagrid("insertRow", {
	  index: format_index,
	  row: {
		  formatTitle:'<input type="text" name="activityFormatList['+format_index+'].formatTitle" />',
		  formatFullRmb:'<input type="text" name="activityFormatList['+format_index+'].formatFullRmb"/>',
		  formatMinusRmb:'<input type="text" name="activityFormatList['+format_index+'].formatMinusRmb"/>',
		  formatStatus:'<select name="activityFormatList['+format_index+'].formatStatus"><option value="1">在用</option><option value="-1">停用</option></select>'
	  }
  });
  format_index++;
}
//删除活动规则行
function removeitFormat(){
  var sindex = $('#format_dg').datagrid('getRowIndex', $('#format_dg').datagrid('getSelected'));
  $('#format_dg').datagrid('deleteRow', sindex);
  format_index--;
}
//添加商家
function appendSeller(){
	searchSeller();
	$('#w').window('open');
}
//搜索商家
function searchSeller(){
	$("#cg").datagrid({
		url:'/admin/seller/search?'+$('#subForm').serialize(),
	    rownumbers: true,
	    columns:[[
	        { field:'ck',checkbox:true }, 
	        { field: 'sellerId',width:'50', title: '商家ID' },
	        { field: 'sellerName',width:'200', title: '店铺名称' },
	        { field: 'sellerTel',width:'100', title: '手机号' }
	    ]],
	    fitColumns:"true",
	    singleSelect: false,
	    selectOnCheck: true,
	    checkOnSelect: true
	});	
}
//选定商家
function selectSeller(){
	var checkedItems = $('#cg').datagrid('getChecked');
	$.each(checkedItems, function(index, item){
		$("#seller_dg").datagrid("insertRow", {
			  index: seller_index,
			  row: {
				  sellerId: item.sellerId,
				  sellerName:'<input type="hidden" name="activitySellerList['+seller_index+'].sellerId" value="'+item.sellerId+'"/>'+item.sellerName,
				  sellerTel: item.sellerTel
			  }
		  });
		  seller_index++;
	}); 
	$('#w').window('close');
}
//删除活动商家行
function removeitSeller(){
  var sindex = $('#seller_dg').datagrid('getRowIndex', $('#seller_dg').datagrid('getSelected'));
  $('#seller_dg').datagrid('deleteRow', sindex);
  seller_index--;
}
//保存、修改数据
function saveOrUp(){
	  $('#subForm').validate({ 		
			submitHandler: function (form) {
				$('#subForm').submit();
			}
	  });
}
function loadData(){
//修改数据时初始化数据
<c:if test="${activity != null}">
  //活动规则
  <c:forEach items="${activity.activityFormatVoList}" var="format" varStatus="status"> 
	  $("#format_dg").datagrid("insertRow", {
		  index: ${status.index},
		  row: {
			  formatTitle:'<input type="text" name="activityFormatList[${status.index}].formatTitle" value="${format.formatTitle}"/>',
			  formatFullRmb:'<input type="text" name="activityFormatList[${status.index}].formatFullRmb" value="${format.formatFullRmb}"/>',
			  formatMinusRmb:'<input type="text" name="activityFormatList[${status.index}].formatMinusRmb" value="${format.formatMinusRmb}"/>',
			  formatStatus:'<select id="status_${status.index}" name="activityFormatList[${status.index}].formatStatus"><option value="1">在用</option><option value="-1">停用</option></select>'
		  }
	  });
	  $('#status_${status.index}').val(${format.formatStatus});
  </c:forEach>
  //活动商家
  <c:forEach items="${activity.activitySellerVoList}" var="seller" varStatus="status"> 
	  $("#seller_dg").datagrid("insertRow", {
		  index: ${status.index},
		  row: {
			  sellerId: '${seller.sellerId}',
			  sellerName:'<input type="hidden" name="activitySellerList[${status.index}].sellerId" value="${seller.sellerId}"/>${seller.sellerName}',
			  sellerTel: '${seller.sellerTel}'
		  }
	  });
  </c:forEach>
</c:if>
}
$(document).ready(function () {
    loadData();
});
</script>
</body>
</html>