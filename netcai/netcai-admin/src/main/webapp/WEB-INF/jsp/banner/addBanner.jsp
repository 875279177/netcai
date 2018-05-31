<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增广告信息</title>
<link rel="stylesheet" href="/layui/css/layui.css"  media="all">
<script type="text/javascript" src="/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/js/jquery.formPlugin.js"></script>
<script type="text/javascript" src="/js/jquery.form.js"></script>
<style type="text/css">
  .layui-input-inline{
    margin-left:30px;
  }
  .layui-input-inline{
    padding:5px;
  }
</style>
<script type="text/javascript">
</script>
</head>
<body>
 <form id="saleForm" class="layui-form" action="" style="margin-top:30px;">
     <div class="layui-form-item" >
       <div class="layui-inline">
	     <div class="layui-form-item">
		   <label class="layui-form-label">区域选择</label>
		   <div class="layui-input-inline">
		     <select id="province" name="provinceId"  lay-filter="province" >
		       <option value="" name="">请选择省</option>
		     </select>
		   </div>
		   <div class="layui-input-inline">
		     <select id="city" name="cityId" lay-filter="city">
		       <option value="">请选择市</option>
		     </select>
		   </div>
		   <div class="layui-input-inline">
		     <select id="region" name="regionId" style="width:50px;">
		       <option value="">请选择县/区</option>
		     </select>
		   </div>
		 </div>
	   </div>
	   <div class="layui-inline">
	     <label class="layui-form-label">主&nbsp;&nbsp;&nbsp;&nbsp;题：</label>
	     <div class="layui-input-inline">
	       <input type="text" name="title" placeholder="请输入主题" lay-verify="required" class="layui-input" value="${banner.title }">
	     </div>
	     <label class="layui-form-label">链接地址：</label>
	     <div class="layui-input-inline">
	       <input type="text" name=bannerIds placeholder="请输入链接地址" lay-verify="required" class="layui-input" value="${banner.bannerIds }">
	     </div>
		 <div class="layui-input-inline">
		   <input type="text" name="id" style="display:none;" class="layui-input" value="${banner.id }">
		 </div>
	   </div>
	   <div class="layui-inline">
	       <label class="layui-form-label">上传图片：</label>
		   <div class="layui-input-inline">
		     <input type="file" name="logoImgFile" class="layui-upload-file" id="test">
		   </div>
		   <div class="layui-input-inline">
		     <img id="img_url" src="${banner.url }" height="150" width="300" style="display:none">
		 </div>
	   </div>
	 </div>
	 <div class="layui-input-block" style="margin-top:30px;margin-left:324px;">
       <button class="layui-btn" name="commit" lay-submit="" lay-filter="addData">确定</button>
       <button class="layui-btn" name="cancleSubmit" >取消</button>
     </div>
  </form>
</body>
<script src="/layui/layui.js" charset="utf-8"></script>
<script src="/js/jquery-ui.min.js"></script>
<script type="text/javascript">
$(function(){
	//修改时图片回显
	var imgUrl = $("img").attr("src");
	if(imgUrl!=null && imgUrl!=''){
		$("img").show();
	}
})
//提交表单数据
layui.use(['form', 'jquery', 'layedit', 'laydate','upload'], function(){
	  var $ = layui.jquery,form = layui.form(),layer = layui.layer,
	  layedit = layui.layedit,laydate = layui.laydate;
	  form.verify({
	  });
	//加载所有省下拉选
	  $.getJSON("<%=request.getContextPath()%>/admin/province/list", function(data){
         var optionstring = "";
         $.each(data.object, function(i,item){
             optionstring += "<option value=\"" + item.id + "\" >" + item.areaName + "</option>";
         });
         $("#province").html('<option value=""></option>' + optionstring);
         form.render('select'); //重新渲染
   	     //加载所选省下得所有市
	 	 form.on('select(province)', function(data){
	         $.getJSON("<%=request.getContextPath()%>/admin/city/list?provinceId="+data.value, function(data){
	             var optionstring = "";
	             $.each(data.object, function(i,item){
	                 optionstring += "<option value=\"" + item.id + "\" >" + item.areaName + "</option>";
	             });
	             $("#city").html('<option value=""></option>' + optionstring);
	             form.render('select'); //重新渲染
	             //加载所选市下得所有区
	       	     form.on('select(city)', function(data){
	                 $.getJSON("<%=request.getContextPath()%>/admin/region/list?cityId="+data.value, function(data){
	                     var optionstring = "";
	                     $.each(data.object, function(i,item){
	                         optionstring += "<option value=\"" + item.id + "\" >" + item.areaName + "</option>";
	                     });
	                     $("#region").html('<option value=""></option>' + optionstring);
	                     form.render('select'); //重新渲染
	                     
	                 });
	             });
	         });
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
		    		$("img").attr("src",imgUrl);
		    		$("img").show();
		    	}
		    }
	  });
	  //监听表单提交
	  form.on('submit(addData)', function(data){
		  var imgUrl = $("img").attr("src");
		  //获取选中数据的id(点击修改按钮时)
		  var id=$("input[name='id']").val();
		  var msg;
		  if(id == null){
			  msg = "新增数据成功";
			  if(imgUrl == null || imgUrl == ""){
				  alert("请上传图片")
				  return;
			  }
		  }else{
			  msg = "更新数据成功";
		  }
		  //获取传递的参数
		  var requestData={
				          "id":id,
				          "provinceId":data.field.provinceId,
				          "cityId":data.field.cityId,
				          "regionId":data.field.regionId,
						  "title":data.field.title,
						  "bannerIds":data.field.bannerIds,
						  "url":imgUrl
		              };
	      $.ajax({
	    	  type:"POST",
	    	  url:"<%=request.getContextPath()%>/admin/banner/insertAndUpdate",
	    	  data:requestData,
	    	  dataType:"json",
	    	  async:false,
	    	  success:function(result){
	    		  var code=result.code;
	    		  if(code=="200" || code=="201"){
	    			  alert(msg);
	    			  var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	    			  parent.layer.close(index);//关闭父页面的弹窗
	    			  //刷新页面
	    			  parent.location.reload(); 
	    		  }
	    	  }
	      });
	  });
})
</script>
</html>