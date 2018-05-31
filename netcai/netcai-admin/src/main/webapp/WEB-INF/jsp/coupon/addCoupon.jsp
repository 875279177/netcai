<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
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
		<div class="layui-form-item" >
	 		<div class="layui-inline">
	            <div class="layui-form-item" >
			     <label class="layui-form-label">选择区域：</label>
			     <div class="layui-input-block">
			     <c:forEach items="${areas}" var="area">
				      <input type="checkbox" id = "${area.id}" name="areaIds"  title="${area.areaName}" value="${area.id}" lay-filter="areaName">
			     </c:forEach>
				 </div>
			   </div>
		   </div>
		</div>	 
	
	   <div class="layui-form-item" > 
		   <div class="layui-inline">
	            <div class="layui-form-item" >
				 <label class="layui-form-label">选择类型：</label>
				     <div class="col-sm-10">
					     <div class="layui-input-block" style="width: 220px">
			                   <select id="type" name="type" class="col-sm-1 form-control" >
								   <option value="1" >满减</option>
							   </select>
						 </div>
					 </div>
				 </div>
		   </div>
		</div> 
	
		<div class="layui-form-item" > 
			 <div class="layui-inline">
	            <div class="layui-form-item" >
			     <div class="col-sm-10">
				     <div class="layui-input-block" style="width: 220px">
		                   <input type="number" name="fullMoney" placeholder="请输入消费金额"  lay-verify="fullMoney" class="layui-input">
					 </div>
				 </div>
				 </div>
		   </div>
		
			<div class="layui-inline">
	            <div class="layui-form-item" >
			     <div class="col-sm-10">
				     <div class="layui-input-block" style="width: 220px">
				     		<input type="text" name="name" placeholder="请输入优惠券名称"  lay-verify="required" class="layui-input">
					 </div>
				 </div>
				 </div>
		   </div>
		</div> 
	
		<div class="layui-form-item" > 
			 <div class="layui-inline">
	            <div class="layui-form-item" >
			     <div class="col-sm-10">
				     <div class="layui-input-block" style="width: 220px">
		                   <input type="text" id="startTime" name="startTime" placeholder="请输入优惠券开始时间"  lay-verify="required" class="layui-input">
					 </div>
				 </div>
				 </div>
		   </div>
			<div class="layui-inline">
	            <div class="layui-form-item" >
			     <div class="col-sm-10">
				     <div class="layui-input-block" style="width: 220px">
				     		<input type="text" id="endTime" name="endTime" placeholder="请输入优惠券结束时间"  lay-verify="required" class="layui-input">
					 </div>
				 </div>
				 </div>
		   </div>
	   </div>
   
	   <div class="layui-form-item" > 
			<div class="layui-inline">
	            <div class="layui-form-item" >
			     <div class="col-sm-10">
				     <div class="layui-input-block" style="width: 220px">
		                   <input type="number" name="money" placeholder="请输入券金额"  lay-verify="money" class="layui-input">
					 </div>
				 </div>
				 </div>
		   </div>
			<div class="layui-inline">
	            <div class="layui-form-item" >
			     <div class="col-sm-10">
				     <div class="layui-input-block" style="width: 220px">
				     		<input type="text" name="remarks" placeholder="请输入优惠券说明"  lay-verify="required" class="layui-input">
					 </div>
				 </div>
				 </div>
		   </div>
	   </div>
	   
	   <div class="layui-form-item" > 
	   	 <div class="layui-inline">
	     <label class="layui-form-label">上传图片：</label>
		 <div class="layui-input-inline">
		   <input type="file" name="logoImgFile" class="layui-upload-file"> 
		 </div>
		  </div>
	   <div class="layui-inline" >
	     <ul>
	       <li class="img">
		       <div style="width: 300px;height: 150px;">
		         <img id="img" src="${from.sellerLogo }" display="block">
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
<script src="/bootstrap/js/bootstrap.min.js"></script>
<script src="/js/raphael-min.js"></script>
<script src="/plugins/sparkline/jquery.sparkline.min.js"></script>
<script src="/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script src="/plugins/knob/jquery.knob.js"></script>
<script src="/js/moment.min.js"></script>
<script src="/plugins/daterangepicker/daterangepicker.js"></script>
<script src="/plugins/datepicker/bootstrap-datepicker.js"></script>
<script src="/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script src="/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="/plugins/fastclick/fastclick.js"></script>
<script src="/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script src="/dist/js/app.min.js"></script>
<script src="/dist/js/demo.js"></script>
<script src="/js/jquery-ui.min.js"></script>
<script src="/layui/layui.js" charset="utf-8"></script>
<script src="/js/jquery.validate.min.js" charset="utf-8"></script>
<script src="/js/layuiUtil.js" charset="utf-8"></script>
<script src="/My97DatePicker/WdatePicker.js"></script>

<script type="text/javascript" src="/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="/js/jquery.formPlugin.js"></script>
<script type="text/javascript" src="/js/jquery.form.js"></script>
<script type="text/javascript">

//初始化时间选择器
$("#startTime").bind("click focus", function () {
    var endtimeTf = $dp.$('endTime');
    WdatePicker({
        maxDate: '#F{$dp.$D(\'startTime\')}',
        dateFmt: "yyyy-MM-dd HH:mm:ss",
        onpicked: function () { endtimeTf.focus(); }
    });
});
$("#endTime").bind("click focus", function () {
    WdatePicker({
        minDate: '#F{$dp.$D(\'startTime\')}',
        dateFmt: "yyyy-MM-dd HH:mm:ss"
    });
});

layui.use(['form', 'jquery', 'layedit', 'laydate','upload'], function(){
	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	  var $ = layui.jquery,form = layui.form(),
	  layer = layui.layer,
	  layedit = layui.layedit,
	  laydate = layui.laydate;
	
	  form.verify({
		  fullMoney: [/^(0|[1-9][0-9]*)$/, '请输入正确的金额']
		  ,money: [/^(0|[1-9][0-9]*)$/, '请输入正确的金额']
		  });
	
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
		    		$("#img").attr("src",imgUrl);
		    		$("#img").show();
		    	}
		   }
	     });
	  });
	  
	  //监听checkbox复选
	  var regionIds = new Array();
    $("input[name='areaIds'][checked]").each(function () {
    	regionIds.push(this.value);
      })
	form.on('checkbox(areaName)', function(data){
		  if(data.elem.checked){
			  regionIds.push(data.value);
		  }else{
		  for (var i = 0; i < regionIds.length; i++) {
			    if (regionIds[i] == data.value) {
			    	regionIds.splice(i,1);
			    };
			  }
		  }
		}); 
		//监听提交
	  form.on('submit(addData)', function(data){
		//获取图片路径
		  var img = $("#img").attr("src");
		if(regionIds.length<1){
			alert("请选择区域！");
			return false;
		}  
		
		  var requestData={
				          "type":data.field.type,
						  "name":data.field.name,
						  "img":img,
						  "regionIds":regionIds,
						  "createTimeStart":data.field.startTime,
						  "createTimeStop":data.field.endTime,
						  "money":data.field.money,
						  "status":data.field.status,
						  "remarks":data.field.remarks,
						  "createTime":data.field.createTime,
						  "fullMoney":data.field.fullMoney
		              };
	      $.ajax({
	    	  type:"POST",
	    	  url:"<%=request.getContextPath()%>/admin/coupon/add",
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
	$("#img").css("display","block");
});
</script>
</html>