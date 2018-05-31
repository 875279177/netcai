<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html>
<html>
<head>
  <meta name="decorator" content="default"/> 
  <style type="text/css">
    button{
      margin-right:5px;
    }
    .layui-form-label{
      width:100px;
    }
  </style>
</head>
<body>
  <!-- 商品分类start -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>商品分类管理</h1>
    </section>
    <!-- Main content -->
    <shiro:hasPermission name="category:query">
	    <section class="content">
	      <div class="row">
	        <div class="col-xs-12">
	          <div class="box">
	            <div class="site-demo-button" >
				   <button data-method="setTop" class="layui-btn layui-btn-small" onclick="add()"><i class="layui-icon"></i><span>&nbsp;&nbsp;新增</span></button>
				</div>
				<div style="padding-top: 5px;">
					<div style="float: left;width: 24%;height: 500px;background-color: white;">
					 <table id="categoryTree" title="所有分类" style="width:400px;height:500px">
				        <thead>
				            <tr>
				                <th data-options="field:'fullName'" width="220">分类</th>
				            </tr>
				        </thead>
				    </table>
				    </div>
				    <div id="categoryShow" style="float: right;width: 75%;height: auto; background-color: white;display: none">  
				         <form id="subForm" method="post" action="<%=request.getContextPath()%>/admin/category/saveOrUpdate" class="form-horizontal" enctype="multipart/form-data">
					        <input type="hidden" name="categoryId" id="categoryId" value="">
					        <input type="hidden" name="parentId" id="parentId" value="">
					        <input type="hidden" name="categoryLevel" id="categoryLevel" value="">
					        <div class="box-body">
					          <div class="form-group">
					            <label for="inputName3" class="col-sm-2 control-label">分类编码:</label>
					            <div class="col-sm-10">
					              <input type="text" name="categoryCode" class="form-control" id="categoryCode" placeholder="请输入分类编码">
					            </div>
					          </div>
					          <div class="form-group">
					            <label for="inputName3" class="col-sm-2 control-label">分类名称:</label>
					            <div class="col-sm-10">
					              <input type="text" name="categoryName" class="form-control" id="categoryName" placeholder="请输入分类名称">
					            </div>
					          </div>
					          <div class="form-group">
					            <label for="inputName3" class="col-sm-2 control-label">顺序号:</label>
					            <div class="col-sm-10">
					              <input type="text" name="categorySeq" class="form-control" id="categorySeq" placeholder="请输入顺序号">
					            </div>
					          </div>
					          <div class="form-group">
					            <label for="inputStatus3" class="col-sm-2 control-label">是否末级:</label>
					            <div class="col-sm-10">
					              <select name="isEnd" id="isEnd" class="form-control select2" style="width: 100%;">
					                  <option value="1">是</option>
					                  <option value="2">否</option>
					              </select>
					            </div>
					          </div>
					          <div class="form-group">
					            <label for="inputName3" class="col-sm-2 control-label">数量向上浮动:</label>
					            <div class="col-sm-10">
					              <input type="text" name="upNumber" class="form-control" id="upNumber" placeholder="请输入向上浮动的数量">
					            </div>
					          </div>
					          <div class="form-group">
					            <label for="inputName3" class="col-sm-2 control-label">数量向下浮动:</label>
					            <div class="col-sm-10">
					              <input type="text" name="downNumber" class="form-control" id="downNumber" placeholder="请输入向下浮动的数量">
					            </div>
					          </div>
					          <div class="form-group">
					            <label for="inputName3" class="col-sm-2 control-label">销售提成:</label>
					            <div class="col-sm-10">
					              <input type="text" name="salePercentage" class="form-control" id="salePercentage" placeholder="请输入销售提成">
					            </div>
					          </div>
					          <div class="form-group">
					            <label for="inputName3" class="col-sm-2 control-label">平台抽点:</label>
					            <div class="col-sm-10">
					              <input type="text" name="platformPercentage" class="form-control" id="platformPercentage" placeholder="请输入平台抽点">
					            </div>
					          </div>
					          <div class="form-group">
					            <label for="inputStatus3" class="col-sm-2 control-label">状态:</label>
					            <div class="col-sm-10">
					              <select name="categoryStatus" id="categoryStatus" class="form-control select2" style="width: 100%;">
					                  <option value="1">在用</option>
					                  <option value="-1">停用</option>
					              </select>
					            </div>
					          </div>
					          <!-- checkbox -->
				              <div class="form-group">
				                <label for="inputStatus3" class="col-sm-2 control-label">加工方式:</label>
				                <div class="col-sm-10" id="processMethod">
					                
				                </div>
				              </div>
				              <div class="form-group">
				              		<div class="col-sm-2" >
				              			<input type="hidden" name="categoryLogo" id="categoryLogo" value="">
			               			 </div>	
			               			 <div class="col-sm-5" >
				                    	<div>
				                    		<img  id="allImgUrl"/>
				                    	</div>
			               			 </div>
							  </div>
				              <div class="form-group">
				                    <label for="txt_file" class="col-sm-2 control-label">上传图标:</label>
				                    <div class="col-sm-5" >
				                    	<input type="file" onchange="uploadPic()" class="file" id="logoImgFile" name="logoImgFile" accept="image/*" multiple> 
			               			 </div>
							  </div>
					        </div>
					        <div class="box-footer">
					          <button type="button" class="btn btn-info pull-left " onclick="saveOrUp()">提交</button>
					        </div>
					      </form>
				    </div>    
				</div>
	          </div>
	        </div>
	      </div>
	    </section>
    </shiro:hasPermission>
  </div>
<script src="/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="/bootstrap/js/bootstrap.min.js"></script>
<script src="/bootstrap/js/fileinput.js"></script>
<script src="/js/jquery-ui.min.js"></script>
<script src="/js/jquery.form.js"></script>
<script src="/layui/layui.js"></script>
<script src="/dist/js/app.min.js"></script>
<script type="text/javascript" src="/jquery-easyui-1.5.2/jquery.easyui.min.js" charset="utf-8"></script>
<script type="text/javascript" src="/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<script type="text/javascript" charset="utf-8">
//上传图片
function uploadPic(){
	var options={
		url:"/admin/uploadImgs",
		dataType:"json",
		type:"post",
		success:function(data){
			layer.msg(data.message);
			//回调两个路径
			//URL
			$("#allImgUrl").attr("src",data.object[0]);
			//path
			$("#categoryLogo").val(data.object[0]);
		}
	}
	
	$("#subForm").ajaxSubmit(options);
}


$(document).ready(function () {
	$("#logoImgFile").fileinput({  
		   language: 'zh',  
		   uploadUrl: "upload", //上传后台操作的方法  
		   uploadAsync: true, //设置上传同步异步 此为同步  
		   maxFileSize: 200,  
		   allowedFileExtensions: ['jpg'] //限制上传文件后缀  
		});//初始化 后 上传插件的样子  
	//取得所有的加工方式
	$.ajax({
	   type: 'get',
	   url: '/admin/processmethod/getAllMethodByStatus',
	   dataType: 'json',
	   success: function (data) {
		  var processMethodHtml = '';
		  for(var i=0;i<data.object.length;i++){
			  processMethodHtml += '<label><input name="methodIds" id="method_'+data.object[i].methodId+'" value="'+data.object[i].methodId+'" type="checkbox">'+data.object[i].methodName+'</label>';
		  }
		  $('#processMethod').html(processMethodHtml);
	   }
	});
	//加载商品分类树
	$('#categoryTree').treegrid({
	    url:'<%=request.getContextPath()%>/admin/category/tree',
	    method:'get',          //请求方式
	    idField:'categoryId',           //定义标识树节点的键名字段
	    treeField:'fullName',       //定义树节点的字段
	    fit:true,               //网格自动撑满
	    fitColumns:true,
	    onLoadSuccess:function(node, data){
	    	$(this).treegrid('collapseAll');
	    },
	    onClickRow:function(row){
	    	$('#subForm').form('clear');  
            $('#categoryId').val(row.categoryId);
            $('#categoryCode').val(row.categoryCode);
            $('#categoryLogo').val(row.categoryLogo);
            $('#allImgUrl').attr("src",row.categoryLogo);
            $('#categoryName').val(row.categoryName);
            $('#parentId').val(row.parentId);
            $('#categorySeq').val(row.categorySeq);
            $('#categoryStatus').val(row.categoryStatus);
            $('#categoryLevel').val(row.categoryLevel);
            $('#upNumber').val(row.upNumber);
            $('#downNumber').val(row.downNumber);
            $('#salePercentage').val(row.salePercentage);
            $('#platformPercentage').val(row.platformPercentage);
            $('#isEnd').val(row.isEnd);
            $('#categoryShow').show();
            //取得商品分类的加工方式
            getMethodByCategoryId(row.categoryId);
		}
	});
});
//取得商品分类的加工方式
function getMethodByCategoryId(categoryId){
	$.ajax({
	   type: 'get',
	   url: '/admin/processmethod/getMethodByCategoryId?categoryId='+categoryId,
	   dataType: 'json',
	   success: function (data) {
		  for(var i=0;i<data.object.length;i++){
			  $('#method_'+data.object[i].methodId).prop("checked",true); 
		  }
	   }
	});
}
//新增数据
function add(){
	$('#subForm').form('clear');  
	var row = $('#categoryTree').datagrid('getSelected');  
    if (row){ 
    	if(row.isEnd == 1){
    		$.messager.alert('错误','末级分类下不能再添加分类!','error');  
    	}else{
        	$('#parentId').val(row.categoryId);
        	$('#categoryLevel').val(Number(row.categoryLevel)+1);
    	}
    } else {
    	$('#parentId').val(0);
    	$('#categoryLevel').val(1);
    }
    $('#categoryImg').val('');
    $('#allImgUrl').attr("src",'');
    $('#categoryStatus').val(1);
    $('#isEnd').val(2);
	$('#categoryShow').show();
}
//保存、修改数据
function saveOrUp(){
	$.ajax({
	   type: 'post',
	   url: '<%=request.getContextPath()%>/admin/category/saveOrUpdate?'+$('#subForm').serialize(),
	   dataType: 'json',
	   success: function (data) {
		  if(data == null){
			  $.messager.alert('错误','系统错误，请联系管理员!','error');  
			  return ;
		  }
		  if($('#categoryId').val()==null || $('#categoryId').val()==''){
			    $('#categoryTree').treegrid('append',{
					parent: data.parentId,  
					data: [{
						categoryId: data.categoryId,
						fullName: '['+data.categoryCode+']'+data.categoryName,
						categoryCode: data.categoryCode,
						categoryName: data.categoryName,
						parentId: data.parentId,
						categorySeq: data.categorySeq,
						categoryStatus: data.categoryStatus,
						categoryLevel: data.categoryLevel,
						categoryLogo: data.categoryLogo,
						upNumber: data.upNumber,
						downNumber: data.downNumber,
						salePercentage: data.salePercentage,
						platformPercentage: data.platformPercentage,
						isEnd: data.isEnd
					}]
				});
	            $('#allImgUrl').attr("src",data.categoryLogo);
			    $('#categoryShow').hide();
		  }else{
			   $('#categoryTree').treegrid('update',{
					id: $('#categoryId').val(),
					row: {
						categoryId: data.categoryId,
						fullName: '['+data.categoryCode+']'+data.categoryName,
						categoryCode: data.categoryCode,
						categoryName: data.categoryName,
						parentId: data.parentId,
						categorySeq: data.categorySeq,
						categoryStatus: data.categoryStatus,
						categoryLevel: data.categoryLevel,
						categoryLogo: data.categoryLogo,
						upNumber: data.upNumber,
						downNumber: data.downNumber,
						salePercentage: data.salePercentage,
						platformPercentage: data.platformPercentage,
						isEnd: data.isEnd
					}
			   });
			   $('#allImgUrl').attr("src",data.categoryLogo);
			   $('#categoryShow').hide();
		  }
	   }
	});  
}
layui.use(['layer','jquery','form','element'], function(){ 
})
</script>
</body>
</html>