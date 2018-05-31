<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增配送人员</title>
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
 <form id="sellerFrom" class="layui-form" action="" style="margin-top:30px;">
    <div class="layui-form-item" >
    <input type="text" id="sellerId" name="sellerId" style="display:none;" value="${from.sellerId}" class="layui-input">
       <div class="layui-inline">
	     <div class="layui-form-item">
		   <label class="layui-form-label">区域选择</label>
		   <div class="layui-input-inline">
		     <select id="province" name="provinceId"  lay-filter="province">
		       <option value="" name="unselect">请选择省</option>
		     </select>
		   </div>
		   <div class="layui-input-inline">
		     <select id="city" name="cityId" lay-filter="city">
		       <option value="">请选择市</option>
		     </select>
		   </div>
		   <div class="layui-input-inline">
		     <select id="region" name="regions" lay-filter="regions" multiple="multiple">
		       <option value="">请选择县/区</option>
		     </select>
		   </div>
		 </div>
	   </div>
	   <div class="layui-inline">
	     <label class="layui-form-label">详细地址</label>
		 <div class="layui-input-inline">
		   <input type="text" name="sellerAddress" placeholder="请输入地址" value="${from.sellerAddress}" lay-verify="required" class="layui-input">
		 </div>
		 <label class="layui-form-label">店铺名称</label>
	     <div class="layui-input-inline">
	       <input type="text" name="sellerName" placeholder="请输入店铺名称" value="${from.sellerName}" lay-verify="required" class="layui-input">
	     </div>
	     <label class="layui-form-label">店铺别名</label>
	     <div class="layui-input-inline">
	       <input type="text" name="sellerAlias" placeholder="请输入店铺别名" value="${from.sellerAlias}"  class="layui-input">
	     </div>
	   </div>
	   <div class="layui-inline">
	   	<label class="layui-form-label">真实姓名</label>
	     <div class="layui-input-inline">
	       <input type="text" name="trueName" placeholder="请输入姓名" value="${from.users.trueName}" lay-verify="required" class="layui-input">
	     </div>
	   	<label class="layui-form-label">密码</label>
	     <div class="layui-input-inline">
	       <input type="text" name="password" placeholder="请输入6位数字密码"  lay-verify="password" class="layui-input">
	     </div>
	   </div>
	     <label class="layui-form-label">联系方式</label>
	     <div class="layui-input-inline">
	       <input type="text" name="sellerAccount" placeholder="请输入手机号码" value="${from.sellerAccount}" lay-verify="sellerAccount" class="layui-input">
	     </div>
	   <div class="layui-inline">
	   	<label class="layui-form-label">卖家等级</label>
	     <div class="layui-input-inline">
	       <input type="text" name="sellerRank" placeholder="请输入卖家等级" value="${from.sellerRank}" lay-verify="sellerRank" class="layui-input">
	     </div>
	     <label class="layui-form-label">卖家评分</label>
	     <div class="layui-input-inline">
	       <input type="text" name="sellerGrade" placeholder="请输入卖家评分" value="${from.sellerGrade}" lay-verify="sellerGrade" class="layui-input" >
	     </div>
	     <label class="layui-form-label">备注信息</label>
	     <div class="layui-input-inline">
	       <input type="text" name="remark" lay-verify="" autocomplete="off" value="${from.remark}" class="layui-input" >
	     </div>
	 </div>
	 
	 
	 	<div class="layui-inline">
	     <label class="layui-form-label">卖家类型</label>
	     <div class="layui-input-inline">
	     	<select id="sellerType" name="sellerType" lay-verify="required">
		         <option value="1" <c:if test="${from.sellerType==1}">selected</c:if>>自营</option>
	          	 <option value="2" <c:if test="${from.sellerType==2}">selected</c:if>>加盟</option>
		         <option value="3" <c:if test="${from.sellerType==3}">selected</c:if>>合作</option>
		     </select>
	     </div>
	     <label class="layui-form-label">上传卖家logo</label>
		 <div class="layui-input-inline">
		   <input type="file" name="logoImgFile" class="layui-upload-file"> 
		 </div>
	   <div class="layui-inline" >
	     <ul>
	       <li class="seller_logo">
		       <div style="width: 300px;height: 150px;">
		         <img id="seller_logo" src="${from.sellerLogo }" display="block">
		       </div>
	       </li>
	     </ul>
	   </div>
	   </div>
     <div class="layui-input-block" style="margin-top:30px;margin-left:324px;">
        <button class="layui-btn"  lay-submit="" lay-filter="addData">确定</button>
       <button class="layui-btn" id="cancleSubmit" name="cancleSubmit" >取消</button>
     </div>
  </form>
</body>
<script src="/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="/js/jquery.formPlugin.js"></script>
<script type="text/javascript" src="/js/jquery.form.js"></script>
<script src="/bootstrap/js/layui-mz-min.js" charset="utf-8"></script>
<script type="text/javascript">
layui.use(['form', 'jquery', 'layedit', 'laydate','upload'], function(){
	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	  var $ = layui.jquery,form = layui.form(),
	  layer = layui.layer,
	  layedit = layui.layedit,
	  laydate = layui.laydate;
		//获取选中数据的id(点击修改按钮时)
		  var sellerId=$("#sellerId").val();
	  //自定义验证
	  if(sellerId=="" || sellerId ==null || sellerId ==undefined){
		  form.verify({
		  sellerAccount: [/^1[34578]\d{9}$/, '请输入正确的手机号']
		  ,password: [/(.+){6,12}$/, '密码必须6到12位']
		  });
	  }else{
		  form.verify({
		  sellerAccount: [/^1[34578]\d{9}$/, '请输入正确的手机号']
		  });
	  }
	//关闭弹窗
	  $("#cancleSubmit").click(function(){
		  parent.layer.close(index);//关闭父页面的弹窗
		  return false;
	  })
	  
	//上传logo
	  layui.use('upload', function(){
		 layui.upload({
		   url: '<%=request.getContextPath()%>/admin/uploadImgs', //上传接口
		   success: function(res){ //上传成功后的回调
			    var code = res.code;
		    	if(code == "200"){
		    		layer.msg("上传图片成功", {icon: 1,time: 1200});
		    		var imgUrl = res.object[0];
		    		//将上传图片显示
		    		$("#seller_logo").attr("src",imgUrl);
		    		$("#seller_logo").show();
		    	}
		   }
	     });
	  });
	  //上传图片
	  layui.upload({
		    url: '<%=request.getContextPath()%>/admin/uploadImgs',//上传接口
		    elem: '#test', //指定原始元素，默认直接查找class="layui-upload-file"
		    success: function(res){
		    	var code = res.code;
		    	if(code == "200"){
		    		layer.msg("上传图片成功", {icon: 1,time: 1200});
		    		var imgUrl = res.object[0];
		    		//将上传图片显示
		    		if($("#seller_ad_left").attr("src")==""){
		    			$("#seller_ad_left").attr("src",imgUrl);
		    			$("#seller_ad_left").show();
		    		}else if($("#seller_ad_mid").attr("src")==""){
		    			$("#seller_ad_mid").attr("src",imgUrl);
		    			$("#seller_ad_mid").show();
		    		}else{
		    			$("#seller_ad_right").attr("src",imgUrl);
		    			$("#seller_ad_right").show();
		    		}
		    		
		    	}
		    }
	  });
	  
	  //加载所有省下拉选
	  $.getJSON("<%=request.getContextPath()%>/admin/province/list", function(data){
         var optionstring = "";
         $.each(data.object, function(i,item){
             optionstring += "<option value=\"" + item.id + "\" >" + item.areaName + "</option>";
         });
         $("#province").html('<option value=""></option>' + optionstring);
         form.render('select'); //重新渲染
   	    if(sellerId !="" || sellerId != null || sellerId != undefined){
   				  form.render('select'); //重新渲染
   			  }
      });
      
	  //加载所选省下得所有市
	  form.on('select(province)', function(data){
          $.getJSON("<%=request.getContextPath()%>/admin/city/list?provinceId="+data.value, function(data){
              var optionstring = "";
              $.each(data.object, function(i,item){
                  optionstring += "<option value=\"" + item.id + "\" >" + item.areaName + "</option>";
              });
              $("#city").html('<option value=""></option>' + optionstring);
              form.render('select'); //重新渲染
          });
      });
	  //加载所选市下得所有区
	  form.on('select(city)', function(data){
          $.getJSON("<%=request.getContextPath()%>/admin/region/list?cityId="+data.value, function(data){
              var optionstring = "";
              $.each(data.object, function(i,item){
                  optionstring += "<option value=\"" + item.id + "\" >" + item.areaName + "</option>";
              });
              $("#region").html('<option value=""></option>' + optionstring);
              form.render('select'); //重新渲染
              layui.selMeltiple($);
          });
      });
	var regions ="";
// 	//获取所选区下的市场
// 	  form.on('select(region)', function(data){
// 		  alert(22);
// 		  console.log(data.value); //得到被选中的值
// 		  regions = data.value;
// 		});  
	
		//监听提交
	  form.on('submit(addData)', function(data){
		  var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		//获取图片路径
		  var sellerLogo = $("#seller_logo").attr("src");
		  var regions = data.field.regions;
		  //验证选择市场;
		  if(sellerId== "" || sellerId ==null || sellerId == undefined){
			  if(regions ==''|| regions == null || regions ==undefined){
				  alert("选择区域!");
				  return false;
			  }
		  }
		  
		  var requestData={
				          "regions":data.field.regions,
				          "sellerId":data.field.sellerId,
				          "sellerType":data.field.sellerType,
						  "sellerAddress":data.field.sellerAddress,
						  "sellerLogo":sellerLogo,
						  "sellerName":data.field.sellerName,
						  "sellerAlias":data.field.sellerAlias,
						  "trueName":data.field.trueName,
						  "sellerAccount":data.field.sellerAccount,
						  "sellerRank":data.field.sellerRank,
						  "sellerGrade":data.field.sellerGrade,
						  "password":data.field.password,
						  "remark":data.field.remark
		              };
	      $.ajax({
	    	  type:"POST",
	    	  url:"<%=request.getContextPath()%>/admin/seller/add",
	    	  data:requestData,
	    	  async:false,
	    	  cache: false,
	    	  success:function(result){
	    			alert(result.message);
    			  parent.layer.close(index);//关闭父页面的弹窗
    			  parent.location.reload();
	    	  },error:function(){
	    		  layer.msg("更新数据异常", {icon: 1,time: 1200},function(){
	    			  console.log(index);
	    			  parent.layer.close(index);//关闭父页面的弹窗
    			  });
	    	  }
	      });
	  });
	  
	});
	
	$(function(){
		$("#seller_logo").css("display","block");
	});
</script>
</html>