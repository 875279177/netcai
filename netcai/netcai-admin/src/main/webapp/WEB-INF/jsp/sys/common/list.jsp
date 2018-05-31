<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="pv" uri="/pageTaglib"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html>
<html>
<head>
  <meta name="decorator" content="default"/>
  <style type="text/css">
    button{
      margin-right:5px;
    }
  </style>
</head>
<body>
  <!-- 配送人员列表start -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>常用清单管理</h1>
    </section>
    <!-- Main content -->
    <shiro:hasPermission name="sysCommon:query">
	    <section class="content">
	      <div class="row">
	        <div class="col-xs-12">
	          <div class="box box-info">
	            <!-- 表单start -->
	            <form id="submitForm" class="layui-form" action="<%=request.getContextPath() %>/admin/sysCommon/list" method="post" >
	              <input type="hidden" name="pageNum" id="pageNum" value="${paginator.currentPage}">
	              <input type="hidden" name="pageSize" id="pageSize" value="${paginator.pageRecord}">
	              <div class="box-body">
	              <div class="col-sm-12">
	                <div class="form-group" >
	                 <label for="areaId" class="col-sm-1 control-label">区域</label>
	                 <div class="col-xs-2">
	                   <select id="areaId" name="areaId" class="form-control" >
						   <option value="" >全部</option>
					   </select>
	                 </div>
	                	<label for="sellerName" class="col-sm-1 control-label">卖家店铺</label>
		                 <div class="col-xs-2">
		                   <input type="text" class="form-control" id="sellerName" name="goods.seller.sellerName" placeholder="请输入卖家店铺名称" value="${sysCommonVo.goods.seller.sellerName}">
		                 </div>
		              <label for="buyerTypeId" class="col-sm-1 control-label">买家类型</label>
	                 <div class="col-xs-2">
	                   <select id="buyerTypeId" name="buyerTypeId" class="form-control" >
						   <option value="" >全部</option>
					   </select>
	                 </div>
	                 
	                </div>
	              </div>
	              <div class="form-footer">
					<button type="submit" class="btn btn-info pull-left" onclick="saveOrUp()">提交</button>
		            <button type="reset" id="reset" class="btn btn-info pull-left" style="margin-left:6px;">重置</button>
				</div>
	            </div>
	            </form> 
	            <!-- 增删改图标按钮组 -->
	            <div class="site-demo-button">
	               <button onclick="add()" class="btn btn-success btn-xs"><i class="layui-icon"></i><span>&nbsp;&nbsp;新增</span></button>
	               <button type="button" class="btn btn-primary" id="dels" 
				    data-complete-text="Loading finished" >删除
				</button>
				</div>
	            <!-- 表单end -->
	            <!-- /.box-header -->
	            <div class="layui-form" >
	              <table id="contentTable" class="layui-table table-striped">
	                <thead>
		             <tr>
		             	<th><input type="checkbox"  lay-skin="primary" lay-filter="allChoose"></th>
		                <th>所在区域</th>
		                <th>买家类型</th>
		                <th>商品名称</th>
		                <th>卖家店铺</th>
		                <th>操作</th>
		              </tr>
	                </thead>
	                <tbody>
		              <c:forEach items="${paginator.object}" var="r"> 
			   			 <tr>
			   			 		<td><input type="checkbox" id="${r.scId}" lay-skin="primary" class="i-checks"></td>
						       <td>${r.areaName}</td>
						       <td>${r.buyerType}</td>
						       <td>${r.goods.goodsName}</td>
						       <td>${r.goods.seller.sellerName}</td>
						       <td>
					  			  <a href="#" onclick="del(${r.scId})" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i>删除</a>
					       	   </td>
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
	        </div>
	      </div>
	    </section>
    </shiro:hasPermission>
  </div>
<input type="hidden" id="areaIdVO" value="${sysCommonVo.areaId}"/>
<input type="hidden" id="buyerTypeVO" value="${sysCommonVo.buyerTypeId}"/>
<script src="/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="/bootstrap/js/bootstrap.min.js"></script>
<script src="/bootstrap/js/bootstrap-datetimepicker.js"></script>
<script src="/bootstrap/js/bootstrap-editable.js"></script>
<script src="/js/raphael-min.js"></script>
<script src="/plugins/sparkline/jquery.sparkline.min.js"></script>
<script src="/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script src="/plugins/knob/jquery.knob.js"></script>
<script src="/js/moment.min.js"></script>
<script src="/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script src="/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="/plugins/fastclick/fastclick.js"></script>
<script src="/dist/js/app.min.js"></script>
<script src="/dist/js/demo.js"></script>
<script src="/js/jquery-ui.min.js"></script>
<script src="/layui/layui.js" charset="utf-8"></script>
<script src="/bootstrap/js/layui-mz-min.js" charset="utf-8"></script>
<script charset="utf-8" src="/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
//分页
function onSelectPage(currentPage,pageSize){  
	$('#pageNum').val(currentPage);
	$('#pageSize').val(pageSize);
	$('#submitForm').submit();
} 
</script>
<script>

var pageNum = $('#pageNum').val();
var pageSize =  $('#pageSize').val();

//重置
$(function(){
   $("#reset").click(function(){
	   window.location.href="/admin/sysCommon/list";
   });
  });

//删除
function del(scId) {
    layer.msg('确定删除?', {
       time: 0 //不自动关闭
      ,icon: 5
      ,btn: ['确定','取消']
    ,btn1: function(index){
        	  $.ajax({  
		            url:"/admin/sysCommon/delete",
		            data:{"scId":scId},
		            dataType:"json",  
		            success:function(data){ 
		            	var code = data.code;
		            	var message = data.message;
		            	layer.msg(message, {icon: 6});
				        layer.close(index);
		                location.href="/admin/sysCommon/list?pageNum="+pageNum+"&pageSize="+pageSize;
		            }  
		        });
      }
    ,btn2: function(index){
        layer.close(index);
      }
    });
}

//批量删除
$(function() { 
    $("#dels").click(function(){
		  var bcIds = new Array();
		  $("#contentTable tbody tr td input.i-checks:checkbox").each(function(){
		    if(true == $(this).is(':checked')){
		    	bcIds.push($(this).attr("id"));
		    }
		  });
		  if(bcIds.length<1){
				top.layer.alert('请至少选择一条数据!', {icon: 0, title:'警告'});
				return;
			  }
 		//询问框
	    layer.msg('确定删除?', {
	       time: 0 //不自动关闭
	      ,icon: 5
	      ,btn: ['确定','取消']
	    ,btn1: function(index){
	        	  $.ajax({  
			            url:"/admin/sysCommon/deleteBatch",
			            data:{"ids":bcIds},
			            dataType:"json",  
			            success:function(data){ 
			            	var code = data.code;
			            	var message = data.message;
			            	layer.msg(message, {icon: 6});
					        layer.close(index);
					        location.reload();
			            }  
			        });
	      }
	    ,btn2: function(index){
	        layer.close(index);
	      }
	    });
	});
});

layui.use(['form', 'jquery','layedit', 'laydate'], function(){
	   var form = layui.form(),layer = layui.layer,$ = layui.jquery,
	       layedit = layui.layedit,laydate = layui.laydate;
	   $ = layui.jquery;
	   layui.selMeltiple($);
	 //全选
	   form.on('checkbox(allChoose)', function(data){
	     var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]');
	     child.each(function(index, item){
	       item.checked = data.elem.checked;
	     });
	     form.render('checkbox');
	   });
	   //监听指定开关
	   form.on('switch(switchTest)', function(data){
	       layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
	           offset: '6px'
	       });
	   });
});

//新增数据弹窗
layui.use('layer', function(){ //独立版的layer无需执行这一句
	   var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句  
	  $('.site-demo-button .layui-btn').on('click', function(){
	    var othis = $(this), method = othis.data('method');
	    active[method] ? active[method].call(this, othis) : '';
	  });
	});
	
//新增;
function add(){
	layer.open({
        type: 2, 
        title: '新增',
        area: ['700px', '500px'],
        shade: 0.5,
        content: '/admin/sysCommon/toSelect',
        zIndex: layer.zIndex, //重点1
        cache: false,
      });
}
//获取区域信息;
$(document).ready(function(){ 
	loadregion(); 
	}); 
	
var areaId = $('#areaIdVO').val();
function loadregion(){
	if(areaId == null || areaId == '' ||areaId == undefined){
		areaId = 0;
	}
	  var url='/admin/region/Alllist'; 
	  jQuery.ajax({ 
	    type:'post', 
	    url:url, 
	    async:false,
	    success:function (date){
   	   var list = date.object;  
         if(list != null && list.length > 0){
             for(var i = 0; i< list.length; i++){
                 if(list[i].id == areaId){
              	   $("<option value='"+list[i].id+"' selected>"+list[i].areaName+"</option>").appendTo("#areaId");
                 }else {
                 $("<option value='"+list[i].id+"'>"+list[i].areaName+"</option>").appendTo("#areaId");  
				}
             }  
         } 
	    } 
	  }); 
	}
	
//获取买家类型;
$(document).ready(function(){ 
	loadtype(); 
	}); 
	
var buyerTypeId = $('#buyerTypeVO').val();
function loadtype(){
	if(buyerTypeId == null || buyerTypeId == '' ||buyerTypeId == undefined){
		buyerTypeId = 0;
	}
	  var url='/admin/type/list';
	  jQuery.ajax({
	    type:'post', 
	    url:url, 
	    async:false,
	    success:function (date){
   	   var list = date.object;  
         if(list != null && list.length > 0){
             for(var i = 0; i< list.length; i++){
                 if(list[i].id == buyerTypeId){
              	   $("<option value='"+list[i].id+"' selected>"+list[i].name+"</option>").appendTo("#buyerTypeId");
                 }else {
                 $("<option value='"+list[i].id+"'>"+list[i].name+"</option>").appendTo("#buyerTypeId");  
				}
             }  
         } 
	    } 
	  }); 
	}
</script>
</body>
</html>