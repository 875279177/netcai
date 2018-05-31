<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	     <div class="layui-form-item">
           <label for="areaId" class="layui-form-label">区域：</label>
           <div class="layui-input-inline">
             <select id="areaId" name="areaId"  >
		   <option value="" >全部</option>
	   		</select>
           </div>
          <label for="buyerTypeId" class="layui-form-label">买家类型：</label>
            <div class="layui-input-inline">
              <select id="buyerTypeId" name="buyerTypeId" >
   				<option value="" >全部</option>
	   			</select>
              </div>
            </div>
		 </div>
	 
     <div class="layui-input-block" style="margin-top:30px;margin-left:324px;">
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
		  var areaId = $("#areaId").val();
		  var areaName = $("#areaId option:selected").text();
		  
		  var buyerTypeId = $("#buyerTypeId").val();
		  var buyerType = $("#buyerTypeId option:selected").text();
          
		  
		  if(areaId==null || areaId == '' || areaId == undefined){
			  alert('区域未填!');
			  return false;
		  }
		  if(areaName==null || areaName == '' || areaName == undefined){
			  alert('区域未填!'); 
			  return false;
		  }
		  if(buyerTypeId==null || buyerTypeId == '' || buyerTypeId == undefined){
			  alert("买家类型未填!");
			  return false;
		  }
		  if(buyerType==null || buyerType == '' || buyerType  == undefined){
			  alert("买家类型未填!");
			  return false;
		  }
		  parent.layer.close(index);//关闭父页面的弹窗
		  parent.location.href="/admin/sysCommon/toAdd?areaId="+areaId+"&areaName="+areaName+"&buyerTypeId="+buyerTypeId+"&buyerType="+buyerType;
	  }

//获取区域信息;
$(document).ready(function(){ 
	loadregion(); 
	}); 
	
function loadregion(){
	  var url='/admin/region/Alllist'; 
	  jQuery.ajax({ 
	    type:'post', 
	    url:url, 
	    async:false,
	    success:function (date){
 	   var list = date.object;  
       if(list != null && list.length > 0){
           for(var i = 0; i< list.length; i++){
               $("<option value='"+list[i].id+"'>"+list[i].areaName+"</option>").appendTo("#areaId");  
           }  
       } 
	    } 
	  }); 
	}
	
//获取买家类型;
$(document).ready(function(){ 
	loadtype(); 
	}); 
	
function loadtype(){
	  var url='/admin/type/list';
	  jQuery.ajax({
	    type:'post', 
	    url:url, 
	    async:false,
	    success:function (date){
 	   var list = date.object;  
       if(list != null && list.length > 0){
           for(var i = 0; i< list.length; i++){
               $("<option value='"+list[i].id+"'>"+list[i].name+"</option>").appendTo("#buyerTypeId");  
           }  
       } 
	    } 
	  }); 
	}
</script>
</html>