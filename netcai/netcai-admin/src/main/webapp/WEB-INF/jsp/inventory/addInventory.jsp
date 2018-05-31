<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="pv" uri="/pageTaglib"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增广告信息</title>
<%@include file="/WEB-INF/jsp/decorators/meta.jsp" %>  
<script type="text/javascript" src="/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/js/jquery.formPlugin.js"></script>
<script type="text/javascript" src="/js/jquery.form.js"></script>
<style type="text/css">
  .layui-inline{
    width:100%;
  }
  .layui-form-label{
    margin-left:75px; 
    width:100px; 
  }
  .layui-input-inline>p{
    padding-left:65px;
    padding-top:5px;
    font-family:微软雅黑;
    font-weight:bold;
    text-align:bottom;
  }
  table th{
    background:#ffffff;
  }
  table tr:nth-child(odd){
	background:#F0F0F0;
  }
  .form-footer{
	margin-right:75px;
	margin-bottom:10px;
	float:right;
  }
  .btn-select{
	margin-right:20px;
  }
  .control-label{
    width:120px;
    padding:8px 25px;
  }
</style>
<script type="text/javascript">
</script>
</head>
<body>
   <div class="box box-info">
     <form class="layui-form" style="margin-top:30px;">
       <div class="layui-form-item">
         <label class="layui-form-label">区域：</label>
	     <div class="layui-input-inline">
	       <p></p>
	       <input type="text" name="regionId" value="" class="layui-input" style="display:none;">
	     </div>
	     <div class="layui-input-inline">
	       <input type="text" name="id" value="" class="layui-input" style="display:none;">
	     </div>
	     <label class="layui-form-label">餐厅类型：</label>
		 <div class="layui-input-inline checkbox-buyerType">
		   <c:forEach items="${buyerTypeList }" var="r">
			 <input type="checkbox" name="buyerTypeId" lay-skin="primary" value="${r.id}" title="${r.name }" lay-filter="buyerType" >
		   </c:forEach>
		 </div>
	   </div>
	   <div class="box-body" >
	     <form id="subForm" class="form-horizontal" method="post" action="" >
             <div class="form-group" >
               <label for="sellerName" class="col-sm-2 control-label">商家名称：</label>
               <div class="col-xs-2">
                 <input type="text" name="sellerName" value="${goods.sellerName}" class="form-control" placeholder="请输入商家名称"> 
               </div>
               <label class="col-sm-2 control-label">商品名称：</label>
               <div class="col-xs-2">
                 <input type="text" name="goodsName" value="${goods.searchName}" class="form-control" placeholder="请输入商品名称">
               </div>
             </div>
            <div class="form-footer" >
	          <button type="submit" class="btn btn-info pull-left btn-select">查询</button>
	          <button type="reset" class="btn btn-info pull-left">重置</button>
	        </div>
         </form>
		 <div class="layui-form" >
           <table class="layui-table">
             <thead>
               <tr>
                 <th><input type="checkbox" lay-skin="primary" lay-filter="allChoose"/></th>
                 <th>商家名称</th>
                 <th>分类</th>
                 <th>名称</th>
                 <th>别名</th>
                 <th>标签</th>
                 <th>品牌</th>
                 <th>状态</th>
                 <th>创建时间</th>
               </tr>
             </thead>
             <tbody>
               <c:forEach items="${paginator.object}" var="r"> 
	  			 <tr>
	  			   <td>
	  			     <input type="checkbox" name="goodsIds" value="${r.sellerId},${r.goodsId}" lay-skin="primary">
	  			   </td>
	  			   <td>${r.sellerName}</td>
	  			   <td>${r.categoryName}</td>
			       <td>${r.goodsName}</td>
			       <td>${r.goodsAs}</td>
			       <td>${r.goodsLabel}</td>
			       <td>${r.goodsBrand}</td>
			       <td>
			       	  <c:if test="${r.goodsStatus==1}">上架</c:if>
					  <c:if test="${r.goodsStatus==-1}">下架</c:if>
			       </td>
			       <td><fmt:formatDate value="${r.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	             </tr>
		       </c:forEach>
             </tbody>
           </table>
         </div>
         <div class="box-footer clearfix">
           <ul class="pagination pagination-sm no-margin pull-left">
             <pv:showPaging pageVo="${paginator}" />
           </ul>
         </div>
	   </div>
	   <div class="layui-input-block" style="margin-top:30px;margin-left:475px;">
         <button class="layui-btn" name="commit" lay-submit="" lay-filter="addData">确定</button>
         <button class="layui-btn" name="cancleSubmit" >取消</button>
       </div>
     </form>
   </div>
</body>
<script src="/js/jquery-ui.min.js"></script>
<script src="/layui/layui.js"></script>
<script type="text/javascript">
//当前页码查询数据
function onSelectPage(currentPage)
{  
	var sellerName=$("input[name='sellerName']").val();
	var goodsName=$("input[name='goodsName']").val();
	var url="/admin/inventory/addInventory?pageNum="+currentPage;
	if(sellerName!=null && sellerName!=''){
		url+="&sellerName="+sellerName;
	}
    if(goodsName!=null && goodsName!=''){
    	url+="&goodsName="+goodsName;
	}
	window.location.href=url;
}
</script>
<script type="text/javascript">
//提交表单数据
layui.use(['form', 'jquery', 'layedit', 'laydate','upload'], function(){
	  var $ = layui.jquery,form = layui.form(),layer = layui.layer,
	  layedit = layui.layedit,laydate = layui.laydate;
	  form.verify({
	  });
	  //全选
	  form.on('checkbox(allChoose)', function(data){
	    var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]');
	    child.each(function(index, item){
	      item.checked = data.elem.checked;
	    });
	    form.render('checkbox');
	  });
	  //监听表单提交
	  form.on('submit(addData)', function(data){
		  //获取买家类型id
		  var buyerType = "";
		  $("input[name='buyerTypeId']:checked").each(function(){
			  buyerType += $(this).val()+",";
	      });
		  //获取商品id
		  var goodsIds = "";
		  $("input[name='goodsIds']:checked").each(function(){
			  goodsIds += $(this).val()+";";
	      });
		  //获取选中数据的regionId
		  var regionId=$("input[name='regionId']").val();
		  //获取传递的参数
		  var requestData={
				          "buyerTypeIds":buyerType,
				          "regionId":regionId,
						  "goodsIds":goodsIds
		              };
	      $.ajax({
	    	  type:"POST",
	    	  url:"<%=request.getContextPath()%>/admin/inventory/insert",
	    	  data:requestData,
	    	  dataType:"json",
	    	  success:function(result){
	    		  var code=result.code;
	    		  var msg=result.message;
	    		  if(code=="200" || code=="201"){
	    			  layer.msg(msg, {icon: 1,time: 1200},function(){
	    				  var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		    			  parent.layer.close(index);//关闭父页面的弹窗
		    			  //刷新页面
		    			  parent.location.reload();
	    			  });
	    			  
	    		  }
	    	  },
	      });
	  });
})
</script>
</html>