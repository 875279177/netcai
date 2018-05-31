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
			<input type="hidden" class="layui-input" name="groupsId" value="${groups.id }">
			<div class="layui-inline">
				<label class="layui-form-label">区域选择：</label>
					<div class="layui-input-inline">
						<select id="region" name="regionIds" multiple="multiple" lay-verify="required">
							<option value="">请选择区</option>
						</select>
					</div>
				<label class="layui-form-label">开始时间：</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input " name="beginTime" lay-verify="required" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',readOnly:true})" placeholder="请输入开始时间" value="<fmt:formatDate value='${groups.beginTime }' pattern='yyyy-MM-dd HH:mm:ss'/>">
				</div>
				<label class="layui-form-label">结束时间：</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" name="endTime" lay-verify="required" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',readOnly:true})" placeholder="请输入结束时间"value="<fmt:formatDate value='${groups.endTime }' pattern='yyyy-MM-dd HH:mm:ss'/>">
				</div>
			</div>
			<div class="layui-inline">
			    <label class="layui-form-label">标题：</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" name="title" placeholder="请输入标题" value="${groups.title }" >
				</div>
				<label class="layui-form-label">参团最小金额：</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" name="minGroupsAmount" lay-verify="count" placeholder="请输入卖家评分" value="${groups.minGroupsAmount }">
				</div>
				<label class="layui-form-label">团购总金额：</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" name="groupsAmount" lay-verify="count" value="${groups.groupsAmount }" >
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">最大买家数：</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" name="maxNumber" value="${groups.maxNumber }" lay-verify="count">
				</div>
				<label class="layui-form-label">备注信息：</label>
				<div class="layui-input-inline" >
					<input type="text" class="layui-input" name="remarks" value="${groups.remarks }">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">上传logo</label>
				<div class="layui-input-inline">
					<input type="file" name="logoImgFile" class="layui-upload-file">
				</div>
				<div class="layui-inline">
					<ul>
						<li>
							<div style="width: 300px; height: 150px;">
								<img id="logo" src="${groups.logo }" display="block">
							</div>
						</li>
					</ul>
				</div>
			</div>
			<div class="layui-input-block" style="margin-top: 30px; margin-left: 324px;">
				<button class="layui-btn" lay-submit="" lay-filter="addData">确定</button>
				<button class="layui-btn" id="cancleSubmit" name="cancleSubmit">取消</button>
			</div>
	</form>
</body>
<script type="text/javascript" src="/plugins/jQuery/jquery-2.2.3.min.js"></script>
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
	//加载区域下拉选
	$.getJSON("<%=request.getContextPath()%>/admin/region/Alllist", function(data){
        var optionstring = "";
        $.each(data.object, function(i,item){
            optionstring += "<option value=\"" + item.id + "\" >" + item.areaName + "</option>";
        });
        $("#region").html('<option value=""></option>' + optionstring);
        form.render('select'); //重新渲染
        layui.selMeltiple($);
    });
	
	//上传logo
	layui.use('upload', function(){
		layui.upload({
		    url: '<%=request.getContextPath()%>/admin/uploadImgs', //上传接口
		    success: function(res){ //上传成功后的回调
			    var code = res.code;
		    	if(code == "200"){
		    		layer.msg("上传图片成功", {icon: 1,time: 1200});
		    		var imgUrl = res.object[0];
		    		if(null != imgUrl && ''!= imgUrl){
		    			//将上传图片显示
			    		$("#logo").attr("src",imgUrl);
			    		$("#logo").show();
		    		}
		    	}
		    }
	    });
	});
	
	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	//关闭弹窗
	$("#cancleSubmit").click(function(){
		parent.layer.close(index);//关闭父页面的弹窗
		return false;
	})
	
	//监听提交
	form.on('submit(addData)', function(data){
		var groupsAmount =data.field.groupsAmount;
		if(groupsAmount>99999){
			layer.msg('你输入的团购金额过大', {time: 2500});
			return false;
		}
		var minGroupsAmount = data.field.minGroupsAmount;
		if(minGroupsAmount>999){
			layer.msg('你输入参团金额过大', {time: 2500});
			return false;
		}
		var maxNumber = data.field.maxNumber;
		if(maxNumber>999){
			layer.msg('你输入买家数过大', {time: 2500});
			return false;
		}
		//获取图片路径
		var logo = $("#logo").attr("src");
		if(null == logo || "" == logo){
			logo = "";
		}
		var remarks = data.field.remarks;
		if(null == remarks || "" == remarks){
			remarks = "";
		}
		var requestData={
				          "id":data.field.groupsId,
				          "regionIds":data.field.regionIds,
				          "beginTimeStr":data.field.beginTime,
						  "endTimeStr":data.field.endTime,
						  "logo":logo,
						  "title":data.field.title,
						  "maxNumber":maxNumber,
						  "minGroupsAmount":minGroupsAmount,
						  "groupsAmount":groupsAmount,
						  "remarks":data.field.remarks
		                };
	    $.ajax({
	    	type:"POST",
	    	url:"<%=request.getContextPath()%>/admin/groups/insertAndUpdate",
			data : requestData,
			dataType:"json",
			success : function(result) {
				var msg=result.message;
    			parent.layer.msg(msg, {shade: 0.3} ,{time: 3500});
    			parent.layer.close(index);//关闭父页面的弹窗
    			//刷新页面
    			parent.location.reload();
			},
			error: function(){
				var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
    			parent.layer.close(index);//关闭父页面的弹窗
    			//刷新页面
    			parent.location.reload();
			}
		});
	});

});

$(function(){
	$("#logo").css("display","block");
})
</script>
</html>