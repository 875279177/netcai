<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="pv" uri="/pageTaglib"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title></title>
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="/libs/font-awesome.min.css">
  <link rel="stylesheet" href="/libs/ionicons.min.css">
  <link rel="stylesheet" href="/dist/css/AdminLTE.min.css">
  <link rel="stylesheet" href="/dist/css/skins/_all-skins.min.css">
  <link rel="stylesheet" href="/plugins/iCheck/flat/blue.css">
  <link rel="stylesheet" href="/plugins/morris/morris.css">
  <link rel="stylesheet" href="/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
  <link rel="stylesheet" href="/plugins/datepicker/datepicker3.css">
  <link rel="stylesheet" href="/plugins/daterangepicker/daterangepicker.css">
  <link rel="stylesheet" href="/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
  <link rel="stylesheet" href="/plugins/datatables/dataTables.bootstrap.css">
  <link rel="stylesheet" href="/layui/lay/css/layui.css"  media="all">
</head>
<body>
<div class="row">
  <div class="col-sm-1"></div>
  <div class="col-sm-10">
 <div class="layui-form"  style="margin-top:40px;">
              <table class="layui-table table-striped table-hover table-boedered" >
                <tbody>
                	<tr >
			   			 <td rowspan="10" style="width: 150px"><b>提现基础信息</b></td>
	                 </tr>
	                 
		   			 <tr>
				       <td><b>姓名</b></td>
				       <td>${w.users.trueName}</td>
				        <td><b>所属类型/店铺</b></td>
				       <td>
				       		<c:if test="${w.users.type==1}">买家</c:if>
						    <c:if test="${w.users.type==2}">卖家</c:if>/${w.shopName}
				       </td>
		             </tr>
		             
		             <tr>
				       <td><b>申请时间</b></td>
				       <td><fmt:formatDate value="${w.withdrawApplyTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
				       <td><b>申请流水号</b></td>
				       <td>${w.withdrawOrder}</td>
		             </tr>
		             
		             <tr>
				       <td><b>提现银行</b></td>
				       <td>${w.withdrawalBank.bankName}</td>
				       <td><b>卡号</b></td>
				       <td>${w.withdrawalBank.bankNumber}</td>
		             </tr>
		             
		             <tr>
				       <td><b>交易状态</b></td>
				       <td>
			       		  <c:if test="${w.status==-1}">审批不通过</c:if>
						  <c:if test="${w.status==1}">申请提现</c:if>
						  <c:if test="${w.status==2}">审批通过</c:if>
						  <c:if test="${w.status==3}">交易完成</c:if>
				       </td>
				       <td><b>交易金额</b></td>
				       <td>${w.withdrawApplyTotal}</td>
		             </tr>
		             <tr>
				       <td><b>实际提现金额</b></td>
				       <td>${w.withdrawRealityTotal}</td>
				       <td><b>提现手续费</b></td>
				       <td>${w.withdrawCharge}</td>
		             </tr>
                </tbody>
              </table>
    </div>
    
    <div class="layui-form"  style="margin-top:40px;">
    
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
		  <legend>提现详情</legend>
		</fieldset> 
		<ul class="layui-timeline">
		<c:forEach items="${withdrawalLogs}" var="r"> 
		  <li class="layui-timeline-item">
		    <i class="layui-icon layui-timeline-axis"></i>
		    <div class="layui-timeline-content layui-text">
		      <div class="layui-timeline-title">
			      <b>
					  <fmt:formatDate value="${r.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
					  ${r.users.trueName}  
					  <c:choose>
					  	<c:when test="${r.status == -1}">审批不通过</c:when>
					  	<c:when test="${r.status == 1}">申请提现</c:when>
					  	<c:when test="${r.status == 2}">审批通过</c:when>
					  	<c:when test="${r.status == 3}">交易完成</c:when>
					  	<c:otherwise>
					  	</c:otherwise>
					  </c:choose> 
					  ${r.remark}
	     			</b>
		      </div>
		    </div>
		  </li>
		  </c:forEach>
		</ul>
    </div>
    
    <div id="withdrawalFrom" class="layui-form"  >
       <form id="withdrawal" class="layui-form" action="" method="post" >
      	 	<input type="hidden"  name="id"  lay-verify="id" value="${w.id}" >
      	 	<input type="hidden"  name="uid" lay-verify="uid" value="${w.uid}" >
      	 	<input type="hidden"  name="withdrawApplyTotal"  value="${w.withdrawApplyTotal}" >
      	 	<input type="hidden"  name="withdrawCharge"  value="${w.withdrawCharge}" >
       		<input type="hidden"  name="withdrawOrder" lay-verify="withdrawOrder" value="${w.withdrawOrder}" >
      	 	<div class="col-sm-12">
	       		<div class="col-sm-6">
	       		<c:if test="${w.status==1 || w.status==2}">
		       		<div class="layui-form-item" style="float: left ;">
		             	<div class="layui-form-item">  
			             	<input id="remark" name="remark"  class="layui-input" type="text" autocomplete="off" placeholder="请输入留言" >  
		             	 </div> 
		             </div>
		        </c:if>
	             </div>
	             
	             <div class="col-sm-6">
			         <c:choose>
			         	<c:when test="${w.status==1}">
				         <div class="layui-form-item">
					         	<select name="status" id="status">
								         <option value="2" >审批通过</option>
								         <option value="-1" >不通过</option>
							      </select>
						  </div>
			         	</c:when>
			         	<c:when test="${w.status==2}">
				         <div class="layui-form-item">
					         	<select name="status" >
								         <option value="3" >交易完成</option>
							      </select>
						  </div>
			         	</c:when>
			         	<c:otherwise>
			         	</c:otherwise>
			         </c:choose>
				</div>
			  </div>
			  
			  <div class="col-sm-12">
				  <c:if test="${w.status==1 || w.status==2}">
					   <div class="layui-input-block" style="margin-top:30px;margin-left:324px;">
					        <button class="layui-btn" id="addData" >确定</button>
					       <button class="layui-btn" id="cancleSubmit" >取消</button>
					     </div>
				  </c:if>
			  </div>
        </form> 
    </div>
    
  </div>
  <div class="col-sm-1"></div>
</div>

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
<script type="text/javascript" src="/js/jquery.formPlugin.js"></script>
<script type="text/javascript" src="/js/jquery.form.js"></script>
<script type="text/javascript">
layui.use(['form', 'layedit', 'laydate'], function(){
	  var form = layui.form
	  ,layer = layui.layer
	  ,layedit = layui.layedit
	  ,laydate = layui.laydate;
	  var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	  
	//关闭弹窗
	  $("#cancleSubmit").click(function(){
		  parent.layer.close(index);//关闭父页面的弹窗
		  return false;
	  })
	  
	  //提交
	  $("#addData").click(function(){
		 $("#addData").attr('disabled',"true");
		 $("#addData").css("background","#C0C0C0");

		 console.log(1);
		 var status = $('#status').val();
		 var remark = $('#remark').val();
		 if(status == -1 || status == "-1"){
			 if(remark == null || remark =="undefined" || remark ==""){
		 		layer.alert('请填写不通过原因!', {
		 			  skin: 'layui-layer-molv' //样式类名
		 			  ,closeBtn: 0,
		 			 time: 2000
		 			});
				  return false;
			 }
		 }
		  var options={
					url:"/admin/withdrawal/updateStatus",
					dataType:"json",
					cache: false,
					type:"post",
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
				}
		  $("#withdrawal").ajaxSubmit(options);
	  })
});
</script>
</body>
</html>