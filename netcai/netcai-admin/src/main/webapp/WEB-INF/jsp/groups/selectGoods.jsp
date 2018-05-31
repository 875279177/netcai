<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增团购活动</title>
<link rel="stylesheet" href="/layui/css/layui.css" media="all">
<style type="text/css">
.layui-input-inline {
	margin-left: 8px;
}

.layui-input-inline {
	padding: 5px;
}

select {
	width: 10px;
}

img {
	margin: 8px;
	height: 150px;
	width: 300px;
	display: none;
}
</style>
</head>
<body>
	<form id="sellerFrom" class="layui-form" style="margin-top: 30px;">
		<div class="layui-form-item">
			<input type="hidden" class="layui-input" name="groupsId" value="${r.id }">
			<div class="layui-inline">
		        <div class="layui-form-item">
				    <label class="layui-form-label">商品选择</label>
				    <div class="layui-input-inline">
					    <select id="seller" name="sellerId"  lay-filter="seller">
					        <option value="" name="unselect">请选择商家</option>
					    </select>
				    </div>
				    <div class="layui-input-inline">
					    <select id="goods" name="goodsId" lay-filter="goods">
					        <option value="">请选择商品</option>
					    </select>
				    </div>
				    <div class="layui-input-inline">
					    <select id="format" name="formatId" lay-filter="format" multiple="multiple">
					        <option value="">请选择规格</option>
					    </select>
				    </div>
			    </div>
		    </div>
			<div class="layui-inline">
				<label class="layui-form-label">商品团购价：</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" name="groupPrice" placeholder="请输入商品团购价" lay-verify="count">
				</div>
				<label class="layui-form-label">团购数量：</label>
				<div class="layui-input-inline" >
					<input type="text" name="count" class="layui-input" lay-verify="count">
				</div>
				<input type="hidden" name="groupsId" value="${groupsId }">
			</div>
			<div class="layui-input-block" style="margin-top: 30px; margin-left: 324px;">
				<button class="layui-btn" lay-submit="" lay-filter="addData">确定</button>
				<button class="layui-btn" id="cancleSubmit">取消</button>
			</div>
	</form>
</body>
<script type="text/javascript" src="/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/layui/layui.js"></script>
<script type="text/javascript" src="/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="/js/jquery.formPlugin.js"></script>
<script type="text/javascript" src="/js/jquery.form.js"></script>
<script type="text/javascript" src="/bootstrap/js/layui-mz-min.js"></script>
<script type="text/javascript" src="/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript">
layui.use(['form', 'jquery', 'layedit', 'laydate','upload'], function(){
	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	var $ = layui.jquery,form = layui.form(),layer = layui.layer,layedit = layui.layedit,laydate = layui.laydate;
	//自定义验证规则
	form.verify({
	    count: [/^[1-9]{1}\d{0,2}/, '请输入正确的数量'],
	});
	
	//加载所有商家下拉选
	$.getJSON("<%=request.getContextPath()%>/admin/seller/getsellers", function(data){
        var optionstring = "";
        $.each(data.object, function(i,item){
            optionstring += "<option value=\"" + item.sellerId + "\" >" + item.sellerName + "</option>";
        });
        $("#seller").html('<option value=""></option>' + optionstring);
        form.render('select'); //重新渲染
    });
    
	//加载所选商家下所有商品
	form.on('select(seller)', function(data){
        $.getJSON("<%=request.getContextPath()%>/admin/goods/selectBySeller?sellerId="+data.value, function(data){
            var optionstring = "";
            $.each(data.object, function(i,item){
                optionstring += "<option value=\"" + item.goodsId + "\" >" + item.goodsName + "</option>";
            });
            $("#goods").html('<option value=""></option>' + optionstring);
            form.render('select'); //重新渲染
        });
    });
	
	//加载所选商品下所有规格
	form.on('select(goods)', function(data){
        $.getJSON("<%=request.getContextPath()%>/admin/goods/selecGoodsFormates?goodsId="+data.value, function(data){
            var optionstring = "";
            $.each(data.object, function(i,item){
                optionstring += "<option value=\"" + item.formatId + "\" >" + item.formatName + "</option>";
            });
            $("#format").html('<option value=""></option>' + optionstring);
            form.render('select'); //重新渲染
            layui.selMeltiple($);
        });
    });
	
	//关闭弹窗
	$("#cancleSubmit").click(function(){
		var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		parent.layer.close(index);//关闭父页面的弹窗
		return false;
	})
	  
	//监听提交
	form.on('submit(addData)', function(data){
		var groupPrice =data.field.groupPrice;
		if(groupPrice>999){
			layer.msg('你输入的团购价过大', {time: 2500});
			return false;
		}
		var count =data.field.count;
		if(count>9999){
			layer.msg('你输入的团购数量过大', {time: 2500});
			return false;
		}
		//获取选中的规格id
        var formatIds= $('input[name="formatId"]').val();
		var requestData={
				          "id":data.field.groupsId,
						  "goodsId":data.field.goodsId,
						  "formatIds":formatIds,
						  "groupPrice":groupPrice,
						  "count":count
		                };
	    $.ajax({
	    	type:"POST",
	    	url:"<%=request.getContextPath()%>/admin/groupsItem/addGroupsItems",
			data : requestData,
			dataType: 'json',
			success : function(result) {
				var msg=result.message;
    			parent.layer.msg(msg, {shade: 0.3} ,{time: 3500});
    			var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
    			parent.layer.close(index);//关闭父页面的弹窗
    			//刷新页面
    			parent.location.reload();
			},
			error: function(result){
				var msg=result.message;
    			parent.layer.msg(msg, {shade: 0.3} ,{time: 3500});
				var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
    			parent.layer.close(index);//关闭父页面的弹窗
    			//刷新页面
    			parent.location.reload();
			}
		});
    });

});
</script>
</html>