<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
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
  select>option{
    width:100px;
  }
  ul li{
    float:left; 
    list-style-type:none;
    border:1px red;
  } 
  img{
    margin:8px;
    height:125px;
    width:275px;
    display:none;
  }
  .buyer_logo>img{
    margin-left:35px;
    margin-right:120px;
  }
</style>
</head>
<body>
  <form class="layui-form" style="margin-top:30px;">
    <div class="layui-form-item" >
       <div class="layui-inline">
	     <div class="layui-form-item">
		   <label class="layui-form-label">省：</label>
		   <div class="layui-input-inline">
		     <select id="province" name="provinceId"  lay-filter="province" <c:if test="${buyer.buyerId==null }">lay-verify="required"</c:if> >
		       <option value="" >请选择</option>
		       <c:forEach items="${requestScope.provice}" var="r"> 
		         <option value="${r.id }" <c:if test="${r.id==buyer.provinceId }">selected</c:if> >${r.areaName }</option>
		       </c:forEach>
		     </select>
		   </div>
		   <label class="layui-form-label">市：</label>
		   <div class="layui-input-inline">
		     <select id="city" name="cityId" lay-filter="city" <c:if test="${buyer.buyerId==null }">lay-verify="required"</c:if> >
		       <option value="" >请选择</option>
		       <c:forEach items="${requestScope.cities}" var="r"> 
		         <option value="${r.id }" <c:if test="${r.id==buyer.cityId }">selected</c:if> >${r.areaName }</option>
		       </c:forEach>
		     </select>
		   </div>
		   <label class="layui-form-label">区：</label>
		   <div class="layui-input-inline">
		     <select id="region" name="regionId" lay-filter="region" <c:if test="${buyer.buyerId==null }">lay-verify="required"</c:if> >
		       <option value="" >请选择</option>
		       <c:forEach items="${requestScope.regions}" var="r"> 
		         <option value="${r.id }" <c:if test="${r.id==buyer.regionId }">selected</c:if> >${r.areaName }</option>
		       </c:forEach>
		     </select>
		   </div>
		   <label class="layui-form-label">配送区域：</label>
		   <div class="layui-input-inline">
		     <select id="deliveryArea" name="deliveryAreaId" <c:if test="${buyer.buyerId==null }">lay-verify="required"</c:if> >
               <option value="" >请选择</option> -->
		       <c:forEach items="${requestScope.deliveryAreas}" var="r"> 
		         <option value="${r.id }" <c:if test="${r.id==buyer.deliveryAreaId }">selected</c:if> >${r.address }</option>
		       </c:forEach>
		     </select>
		   </div>
		 </div>
	   </div>
	   <div class="layui-inline">
	     <label class="layui-form-label">负责销售：</label>
	     <div class="layui-input-inline">
		   <select id="sales" name="sales" lay-filter="sales" >
		     <option value="" selected>请选择销售人员</option>
		     <c:forEach items="${requestScope.salesList}" var="item"> 
		       <option value="${item.id }" <c:if test="${buyer.saleId ==item.id}">selected</c:if>>${item.realName }</option>
		     </c:forEach>
		   </select>
		 </div>
		 <label class="layui-form-label">买家类型：</label>
	     <div class="layui-input-inline">
		   <select id="buyerType" name="buyerType"  lay-filter="buyerType" >
		     <option value="" selected>请选择买家类型</option>
		     <c:forEach items="${requestScope.buyerTypesList}" var="item"> 
		       <option value="${item.id }" <c:if test="${buyer.buyerType ==item.id}">selected</c:if>>${item.name }</option>
		     </c:forEach>
		   </select>
		 </div>
	     <label class="layui-form-label">客户级别：</label>
	     <div class="layui-input-inline">
		   <select id="buyerLevel" name="buyerLevel"  lay-filter="buyerLevel" >
		     <option value="">请选择客户级别</option>
		     <option value="1" <c:if test="${buyer.buyerLevel==1 }">selected</c:if> >A类客户</option>
		     <option value="2" <c:if test="${buyer.buyerLevel==2 }">selected</c:if> >B类客户</option>
		     <option value="3" <c:if test="${buyer.buyerLevel==3 }">selected</c:if> >C类客户</option>
		   </select>
		 </div>
		 <label class="layui-form-label">餐厅名称：</label>
	     <div class="layui-input-inline">
	       <input type="text" name="buyerName" placeholder="请输入餐厅名称" value="${buyer.buyerName }" lay-verify="required" class="layui-input" >
	     </div>
	   </div>
	   <div class="layui-inline">
	     <label class="layui-form-label">店主姓名：</label>
		 <div class="layui-input-inline">
		   <input type="text" name="bossName" placeholder="请输入店主姓名" value="${buyer.bossName }" lay-verify="required" class="layui-input" <c:if test="${buyer.buyerId!=null }">disabled="disabled"</c:if>>
		 </div>
	     <label class="layui-form-label">手&nbsp;&nbsp;机&nbsp;&nbsp;号：</label>
		 <div class="layui-input-inline">
		   <input type="tel" name="bossTel" placeholder="请输入店主姓名" value="${buyer.bossTel }" lay-verify="phone" class="layui-input" <c:if test="${buyer.buyerId!=null }">disabled="disabled"</c:if> >
		 </div>
		 <label class="layui-form-label pwd">登录密码：</label>
	     <div class="layui-input-inline">
	       <input type="password" name="password" placeholder="请输入密码" <c:if test="${buyer.buyerId==null }">lay-verify="pass"</c:if> class="layui-input" >
	     </div>
	     <label class="layui-form-label">餐厅地址：</label>
		 <div class="layui-input-inline">
		   <input type="text" name="buyerAddress" placeholder="请输入餐厅地址" value="${buyer.buyerAddress }" lay-verify="required" class="layui-input">
		 </div>
	   </div>
	   <div class="layui-inline">
	     <label class="layui-form-label">经&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;度：</label>
	     <div class="layui-input-inline">
	       <input type="text" name="lng" placeholder="请输入经度" value="${buyer.lng }" class="layui-input">
	     </div>
	     <label class="layui-form-label">纬&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;度：</label>
	     <div class="layui-input-inline">
	       <input type="text" name="lat" placeholder="请输入纬度" value="${buyer.lat }" class="layui-input">
	     </div>
	     <label class="layui-form-label">开门时间：</label>
	     <div class="layui-input-inline">
	       <input type="text" name="openTime" placeholder="请输入开门时间" value="${buyer.openTime }" class="layui-input">
	     </div>
	     <label class="layui-form-label">关门时间：</label>
	     <div class="layui-input-inline">
	       <input type="text" name="endTime" placeholder="请输入关门时间" value="${buyer.endTime }" class="layui-input">
	     </div>
	   </div>
	   <div class="layui-inline">
	     <label class="layui-form-label">买家logo：</label>
		 <div class="layui-input-inline">
		   <input type="file" name="logoImgFile" class="layui-upload-file"> 
		 </div>
		 <label class="layui-form-label">买家位置：</label>
		 <div class="layui-input-inline">
		   <input type="file" name="logoImgFile" class="layui-form-label" id="test" multiple >
		 </div>
		 <label class="layui-form-label">备注信息：</label>
	     <div class="layui-input-inline">
	       <input type="text" name="remark" class="layui-input" value="${buyer.remark }" style="width:518px;">
	     </div>
	     <div class="layui-input-inline">
	       <input type="text" name="id" value="" class="layui-input" style="display:none">
	     </div>
	   </div>
	   <div class="layui-inline">
	     <ul>
	       <li class="buyer_logo">
	         <img id="buyer_logo" src="${buyer.buyerLogo }" >
	       </li>
	       <li>
	         <img id="buyer_ad_left" src="">
	       </li>
	       <li>
	         <img id="buyer_ad_mid" src="">
	       </li>
	       <li>
	         <img id="buyer_ad_right" src="">
	       </li>
	     </ul>
	   </div>
       <div class="layui-input-block" style="margin-top:30px;margin-left:600px;">
         <button class="layui-btn" lay-submit="" lay-filter="addBuyer">确定</button>
         <button class="layui-btn" id="cancleSubmit" name="cancleSubmit" >取消</button>
       </div>
    </div>
  </form>
</body>
<script src="/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/js/jquery.formPlugin.js"></script>
<script type="text/javascript" src="/js/jquery.form.js"></script>
<script type="text/javascript">
layui.use(['form', 'jquery', 'layedit', 'laydate','upload'], function(){
	  var $ = layui.jquery,form = layui.form(),layer = layui.layer,
	  layedit = layui.layedit,laydate = layui.laydate;
	  //自定义验证
	  form.verify({
	     //验证手机号
	     phone: [/^1[34578]\d{9}$/, '请输入正确的手机号'],
	     //验证密码
	     pass:[/^[\w]{6,12}$/,'请输入6-12位密码(由字母和数字组成)']
	  }); 
	  //关闭弹窗
	  $("#cancleSubmit").click(function(){
		  var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
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
		    		$("#buyer_logo").attr("src",imgUrl);
		    		$("#buyer_logo").show();
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
		    		if($("#buyer_ad_left").attr("src")==""){
		    			$("#buyer_ad_left").attr("src",imgUrl);
		    			$("#buyer_ad_left").show();
		    		}else if($("#buyer_ad_mid").attr("src")==""){
		    			$("#buyer_ad_mid").attr("src",imgUrl);
		    			$("#buyer_ad_mid").show();
		    		}else{
		    			$("#buyer_ad_right").attr("src",imgUrl);
		    			$("#buyer_ad_right").show();
		    		}
		    		
		    	}
		    }
	  });
  	  //加载所选省下的所有市
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
 	  //加载所选市下的所有区
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
	  //加载所选区下的所有配送区域
      form.on('select(region)', function(data){
         $.getJSON("<%=request.getContextPath()%>/admin/deliveryArea/getDeliveryAreas?areaId="+data.value, function(data){
             var optionstring = "";
             $.each(data.object, function(i,item){
                 optionstring += "<option value=\"" + item.id + "\" >" + item.address + "</option>";
             });
             $("#deliveryArea").html('<option value=""></option>' + optionstring);
             form.render('select'); //重新渲染
         });
      });
	  //监听提交
	  form.on('submit(addBuyer)', function(data){
		  var msg = "修改数据成功";
		  //获取选中数据的id(点击修改按钮时)
		  var id=$("input[name='id']").val();

		  //获取图片路径
		  var buyerLogo = $("#buyer_logo").attr("src");
		  //新增数据时买家logo必须上传
		  if(id == null || id == ''){
			  msg = "新增数据成功";
		  }
		  var buyerImages="";
		  if($("#buyer_ad_left").attr("src")!=""){
			  buyerImages += $("#buyer_ad_left").attr("src");
		  }
		  if($("#buyer_ad_mid").attr("src")!=""){
			  buyerImages +="," + $("#buyer_ad_mid").attr("src");
		  }
		  if($("#buyer_ad_right").attr("src")!=""){
			  buyerImages +="," + $("#buyer_ad_right").attr("src");
		  }
		  //获取传递的参数
		  var requestData={
					          "buyerId":id,
							  "provinceId":data.field.provinceId,
							  "cityId":data.field.cityId,
							  "regionId":data.field.regionId,
							  "buyerName":data.field.buyerName,
							  "buyerAddress":data.field.buyerAddress,
							  "bossName":data.field.bossName,
							  "bossTel":data.field.bossTel,
							  "buyerLevel":data.field.buyerLevel,
							  "buyerType":data.field.buyerType,
							  "saleId":data.field.sales,
							  "buyerLogo":buyerLogo,
							  "buyerImages":buyerImages,
							  "lng":data.field.lng,
							  "lat":data.field.lat,
							  "password":data.field.password, 
							  "openTime":data.field.openTime,
							  "endTime":data.field.endTime,
							  "deliveryAreaId":data.field.deliveryAreaId,
							  "remark":data.field.remark
			              };
	      $.ajax({
	    	  type:"POST",
	    	  url:"<%=request.getContextPath()%>/admin/buyer/insertAndUpdate",
	    	  data:requestData,
	    	  async:false,
	    	  success:function(result){
	    		  var code=result.code;
	    		  if(code=="200"){
	    			  alert(msg);
	    		  }else{
	    			  alert(result.message);
	    		  }
	    		  var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
    			  parent.layer.close(index);//关闭父页面的弹窗
    			  window.location.href="/admin/buyer/list?pageSize=25";
	    	  }
	      });
	  });
});
</script>
</html>