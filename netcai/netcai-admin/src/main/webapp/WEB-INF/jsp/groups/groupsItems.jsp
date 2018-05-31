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
<link rel="stylesheet" href="/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/bootstrap/css/bootstrapValidator.css">
<link rel="stylesheet" href="/bootstrap/css/bootstrap-editable.css">
</head>
<body>
	<table class="table table-bordered table-striped table-hover " >
		<thead style="border-collapse:collapse;">
			<tr style="height:60px;">
				<th>商品名称</th>
			    <th>规格名称</th>
			    <th>团购价格</th>
			    <th>团购数量</th>
			    <th>商品原价</th>
			    <th>状态</th>
			    <th>创建时间</th>
			    <th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${groupsItems}" var="r">
				<tr>
					<td>${r.goodsName}</td>
					<td>${r.formatName}</td>
					<td>
					    <a href="#" id="${r.id},0" class="updateValue">${r.price }</a>
						/<c:if test="${r.formatNum>1}"><span>${r.formatNum}</span></c:if>
						<span>${r.unitName}</span>
					</td>
					<td><a href="#" id="${r.id},1" class="updateValue">${r.count }</a></td>
					<td>
						${r.formatPrice}
						/<c:if test="${r.formatNum>1}"><span>${r.formatNum}</span></c:if>
						<span>${r.unitName}</span>
						</td>
					<td>
					    <c:if test="${r.status == -1}">停用</c:if>
					    <c:if test="${r.status == 1}">在用</c:if>
				    </td>
					<td><fmt:formatDate value="${r.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td>
					    <c:if test="${r.status == -1}">
					    	<button class="btn btn-success" onclick="enabledItem(${r.id});"><i class="fa fa-edit"></i>启用</button>
					    </c:if>
						<c:if test="${r.status == 1}">
					    	<button class="btn btn-success" onclick="disabledItem(${r.id});"><i class="fa fa-edit"></i>禁用</button>
					    </c:if>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
</body>
    <script src="/js/jquery-1.9.1.min.js"></script>
	<script src="/bootstrap/js/bootstrap.min.js"></script>
	<script src="/bootstrap/js/bootstrap.js"></script>
	<script src="/bootstrap/js/bootstrapValidator.js"></script>
	<script src="/plugins/datepicker/bootstrap-datepicker.js"></script>
	<script src="/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
	<script src="/plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<script src="/plugins/fastclick/fastclick.js"></script>
	<script src="/bootstrap/js/bootstrap-editable.js"></script>
	<script src="/js/moment.min.js"></script>
	<script src="/dist/js/app.min.js"></script>
    <script src="/dist/js/demo.js"></script>
	<script src="/layui/layui.js" charset="utf-8"></script>
	<script src="/js/jquery.validate.min.js" charset="utf-8"></script>
	<script src="/js/layuiUtil.js" charset="utf-8"></script>
	<script type="text/javascript">
	//加载layui组件
	layui.use(['form', 'jquery','layedit', 'laydate'], function(){
		   var form = layui.form(),layer = layui.layer,$ = layui.jquery,
		       layedit = layui.layedit,laydate = layui.laydate;
	});
	//修改数据
	$(function () {
	    $('.updateValue').editable({
	        type: "text",                //编辑框的类型。支持text|textarea|select|date|checklist等
	        title: "修改",                //编辑框的标题
	        disabled: false,            //是否禁用编辑
	        emptytext: "空文本",          //空值的默认文本
	        mode: "popup",              //编辑框的模式：支持popup和inline两种模式，默认是popup
	        validate: function (value) { //字段验证
	        	arr = $(this).attr('id').split(",");
	        	var reg = new RegExp(/^[0-9]+([.]{1}[0-9]+){0,1}$/); 
		        var itemId = arr[0];
		        var type = arr[1];
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
	            var requestData;
	            if(type == 0){
	            	requestData={"itemId":itemId,"groupPrice":value};
	            }else if(type == 1){
	            	requestData={"itemId":itemId,"count":value};
	            }
	            $.ajax({
	      		    type: 'POST',
	      		    url: '/admin/groupsItem/update',
	      		    data:requestData,
	      		    dataType: 'json',
	      		    success: function (data) {
	      			    layer.msg(data.message, {icon: 6},{time:3500});
	      			    //刷新页面
	      			    location.reload();
	      		    }
	      	    });
	        }
	    });
	});
	
	//禁用
	function disabledItem(id){
		$.ajax({
  		    type: 'POST',
  		    url: '/admin/groupsItem/disabled',
  		    data:{"id":id},
  		    dataType: 'json',
  		    success: function (data) {
  			    layer.msg(data.message, {icon: 6},{time:3500});
  			    //刷新页面
  			    location.reload();
  		    }
  	    });
	}
	
	//启用
	function enabledItem(id){
		$.ajax({
  		    type: 'POST',
  		    url: '/admin/groupsItem/enabled',
  		    data:{"id":id},
  		    dataType: 'json',
  		    success: function (data) {
  			    layer.msg(data.message, {icon: 6},{time:3500});
  			    //刷新页面
  			    location.reload();
  		    }
  	    });
	}
	</script>
</html>