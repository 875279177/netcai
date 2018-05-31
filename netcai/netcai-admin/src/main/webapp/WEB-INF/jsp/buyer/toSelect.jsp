<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="pv" uri="/pageTaglib"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增</title>
<link rel="stylesheet" href="/layui/css/layui.css"  media="all">
<style type="text/css">
  .layui-input-inline{
    margin-left:8px;
  }
  .layui-input-inline{
    padding:5px;
  }
  select{
    width:10px;
  }
  img{
    margin:8px;
    height:150px;
    width:300px;
    display:none;
  }
</style>
</head>
<body>
 <form id="submitFrom" class="layui-form" action="" style="margin-top:30px;">
	      <div class="layui-inline">
		      <label class="layui-form-label" style="width: 150px">买家店铺名称</label>
		      <div class="layui-input-inline">
		        <select name="buyer" lay-verify="required" lay-search="">
		          <option value="">直接选择或搜索选择</option>
		          <c:forEach items="${list}" var="r">
			          <option value="${r.buyerId},${r.regionId}">${r.buyerName}</option>
		          </c:forEach>
		        </select>
		      </div>
		    </div>
     	<div class="layui-input-block" style="margin-top:300px;margin-left: 320px">
        <button class="layui-btn"  lay-submit="" onclick="add()">确定</button>
       <button class="layui-btn" id="cancleSubmit" name="cancleSubmit" >取消</button>
     </div>
  </form>
</body>
<script src="/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="/js/jquery.formPlugin.js"></script>
<script type="text/javascript" src="/js/jquery.form.js"></script>
<script type="text/javascript">
layui.use(['form', 'jquery', 'layedit', 'laydate','upload'], function(){
	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	  var $ = layui.jquery,form = layui.form(),
	  layer = layui.layer,
	  layedit = layui.layedit,
	  laydate = layui.laydate;
	
	//关闭弹窗
	  $("#cancleSubmit").click(function(){
		  parent.layer.close(index);//关闭父页面的弹窗
		  return false;
	  })
});
	 function add(){
		  var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		  
		  var arr = $(".layui-this").attr('lay-value').split(",");
		  
		  var buyerId = arr[0];
		  
		  var regionId = arr[1];
		  
		  var buyerName = $(".layui-this").text();

		  parent.layer.close(index);//关闭父页面的弹窗
		  parent.location.href="/admin/buyerCommon/toAdd?buyerId="+buyerId+"&regionId="+regionId+"&buyerName="+buyerName;
	  } 
</script>
</html>