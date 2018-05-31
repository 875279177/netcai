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
      <h1>添加特价商品</h1>
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
	                <input name="activityTitle" value="${activity.activityTitle}" type="text" class="form-control input-small" />
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
              <div class="box-header">
                <h3 class="box-title">活动商品</h3>
              </div>
              <div class="box-body">
                <table id="goods_dg" title="活动商品" style="height:auto">
				  <thead>
				   <tr>
				    <th data-options="field:'sellerName',width:200">商家名称</th>
				    <th data-options="field:'goodsName',width:200">商品名称</th>
				    <th data-options="field:'formatName',width:200">规则</th>
				    <th data-options="field:'oldPrice',width:200">原价</th>
				    <th data-options="field:'unitName',width:100">单位</th>
				    <th data-options="field:'newPrice',width:200">活动价</th>
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

  <!-- 活动商家按钮 -->
  <div id="seller_tb" style="height:auto;display: none">
  	<a href="javascript:void(0)" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="appendSeller()">新增</a>
  	<a href="javascript:void(0)" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="removeitSeller()">删除</a>
  </div>
  <!-- 活动商品按钮 -->
  <div id="goods_tb" style="height:auto;display: none">
  	<a href="javascript:void(0)" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="appendGoods()">新增</a>
  	<a href="javascript:void(0)" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="removeitGoods()">删除</a>
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
  
  <div id="g" class="easyui-window" title="选择商品" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:600px;height:550px;padding:10px;">  
      <form id="goodsForm" class="form-horizontal" action="" >
        <input name="activityId" value="${activity.activityId}"  type="hidden"/> 
        <input type="hidden" id="userIds" name="userIds">
        <div class="box-body">
          <div class="form-group" >
            <label class="col-sm-2 control-label">名称:</label>
            <div class="col-xs-3">
               <input type="text" id="goodsName" name="goodsName" class="form-control input-small" placeholder="请输入商品名称">
            </div>
            <label class="col-sm-2 control-label">规则:</label>
            <div class="col-xs-3">
               <input type="text" id="formatName" name="formatName" class="form-control input-small" placeholder="请输入规则名称">
            </div>
          </div>
        </div>
        <div class="box-footer">
          <button type="reset" class="btn btn-info pull-right" style="margin-right:40px;" onclick="selectGoods()">确定</button>
          <button type="button" class="btn btn-info pull-right" onclick="searchGoods()">查询</button>
        </div>
      </form>
	  <table id="gg" style="height:360px;width:560px;">   
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
//初始化活动商家
$("#seller_dg").datagrid({
	url:'',
	width: '100%',
	toolbar:"#seller_tb",
	fitColumns:"true",
	singleSelect : true,
	rownumbers:true
});
//初始化活动商品
$("#goods_dg").datagrid({
	url:'',
	toolbar:"#goods_tb",
	fitColumns:"true",
	singleSelect : true,
	rownumbers:true
});	
//活动商家行数
var seller_index = ${fn:length(activity.activitySellerVoList)};
//活动商品行数
var goods_index = ${fn:length(activity.activityGoodsVoList)};
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
//取得已选择的商家
function getSellerIds(){
	var items = $('#seller_dg').datagrid('getData');
	var userIds = '';
	$.each(items.rows, function(index, item){
		userIds += item.sellerId + ",";
    }); 
	if (userIds != ''){
		userIds = userIds.substring(0,userIds.length-1);
	}
	return userIds;
}
//搜索商品
function searchGoods(){
	var userIds = getSellerIds();
	$('#userIds').val(userIds);
	$("#gg").datagrid({
		url:'/admin/goods/search?'+$('#goodsForm').serialize(),
	    rownumbers: true,
	    columns:[[
	        { field:'ck',checkbox:true }, 
	        { field: 'sellerName',width:'100', title: '商家名称' },
	        { field: 'goodsName',width:'100', title: '商品名称' },
	        { field: 'formatName',width:'100', title: '规则名称' },
	        { field: 'unitName',width:'50', title: '单位' },
	        { field: 'formatPrice',width:'100', title: '原价' }
	    ]],
	    fitColumns:"true",
	    singleSelect: false,
	    selectOnCheck: true,
	    checkOnSelect: true
	});	
}
//选定商品
function selectGoods(){
	var checkedItems = $('#gg').datagrid('getChecked');
	var names = [];
	var newPrice = '<input type="text" name="activityGoodsList['+goods_index+'].activityPrice"/>';
	$.each(checkedItems, function(index, item){
		$("#goods_dg").datagrid("insertRow", {
			  index: goods_index,
			  row: {
				  sellerName: item.sellerName,
				  goodsName:'<input type="hidden" name="activityGoodsList['+goods_index+'].goodsId" value="'+item.goodsId+'"/>'+item.goodsName,
				  formatName: '<input type="hidden" name="activityGoodsList['+goods_index+'].goodsFormartId" value="'+item.formatId+'"/>'+item.formatName,
				  unitName: item.unitName,
				  oldPrice: item.formatPrice,
				  newPrice: newPrice
			  }
		  });
		  goods_index++;
	}); 
	$('#g').window('close');
}
//添加商品
function appendGoods(){
	var sellerData = $('#seller_dg').datagrid('getData');
	if (sellerData.rows.length <=0){
		$.messager.alert('错误','请选择活动商家!','error');  
		return;
	}
	searchGoods();
	$('#g').window('open');
}
//删除活动商品行
function removeitGoods(){
  var sindex = $('#goods_dg').datagrid('getRowIndex', $('#goods_dg').datagrid('getSelected'));
  $('#goods_dg').datagrid('deleteRow', sindex);
  goods_index--;
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
	  //活动商品
	  <c:forEach items="${activity.activityGoodsVoList}" var="goods" varStatus="status"> 
		  $("#goods_dg").datagrid("insertRow", {
			  index: ${status.index},
			  row: {
				  sellerName: '${goods.goodsSellerName}',
				  goodsName:'<input type="hidden" name="activityGoodsList[${status.index}].goodsId" value="${goods.goodsId}"/>${goods.goodsName}',
				  formatName: '<input type="hidden" name="activityGoodsList[${status.index}].goodsFormartId" value="${goods.goodsFormartId}"/>${goods.formatName}',
				  unitName: '${goods.unitName}',
				  oldPrice: '${goods.formatPrice}',
				  newPrice: '<input type="text" name="activityGoodsList[${status.index}].activityPrice" value="${goods.activityPrice}"/>'
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