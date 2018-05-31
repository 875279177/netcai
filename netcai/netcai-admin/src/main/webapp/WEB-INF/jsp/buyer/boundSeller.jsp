<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选择拒看卖家</title>
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
    height:100px;
    width:190px;
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
  <input type="hidden" name="buyerId" id="buyerId" value="${buyerId}" >
    	<div class="layui-form-item" >
	     <label class="layui-form-label">选择卖家：</label>
	     <div class="layui-input-block">
	     <c:forEach items="${sellers}" var="seller">
		      <input type="radio" id = "${seller.sellerId}" <c:if test="${seller.select == 1}">checked ="checked"</c:if>  name="sellerIds" lay-verify="required"  title="${seller.sellerName}" value="${seller.sellerId}">
	     </c:forEach>
		 </div>
	   </div>
       <div class="layui-input-block" style="margin-top:30px;margin-left:455px;">
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
	     phone: [/^1[34578]\d{9}$/, '请输入正确的手机号']
	  }); 
	  //关闭弹窗
	  $("#cancleSubmit").click(function(){
		  var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		  parent.layer.close(index);//关闭父页面的弹窗
		  return ;
	  })
	  //监听提交
	  form.on('submit(addBuyer)', function(data){
		  var sellerId = $('input:radio:checked').val();
		  
		  if(sellerId == null || sellerId == '' ||sellerId == undefined){
			  layer.msg("请选择一个卖家绑定！");
			  return false;
		  }
		 var buyerId = $("#buyerId").val();
	      $.ajax({
	    	  type:"POST",
	    	  url:"<%=request.getContextPath()%>/admin/buyerSellerRelation/boundSeller",
	    	  data:{"sellerId":sellerId,"buyerId":buyerId},
	    	  async:false,
	    	  cache: false,
	    	  success:function(result){
	    		  var code=result.code;
	    		  var message=result.message;
	    		  alert(message);
	    		  if(code == '200' || code == '201'){
	    			  var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	    			  parent.layer.close(index);//关闭父页面的弹窗
	    		  }
	    	  },error:function(){
	    		  layer.msg("更新数据异常", {icon: 1,time: 1200},function(){
	    			  console.log(index);
	    			  parent.layer.close(index);//关闭父页面的弹窗
    			  });
	    	  }
	      });
	  });
	  
	  
});
</script>
</html>