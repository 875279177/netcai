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
  <!-- 菜单start -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>菜单管理</h1>
    </section>
    <!-- Main content -->
    <shiro:hasPermission name="menu:query">
	    <section class="content">
	      <div class="row">
	        <div class="col-xs-12">
	          <div class="box">
		          <div class="col-sm-12">
					  <div class="pull-left btn-group-sm">
			              <button onclick="add()" class="btn btn-success"><i class="fa fa-fw fa-plus-square"></i>新增</button>
			              <button class="btn btn-danger" onclick="deleteGrid()"><i class="fa fa-fw fa-times-circle"></i>删除</button>
				      </div>
			      </div>
				<div style="padding-top: 5px;">
					<div style="float: left;width: 24%;height: 500px;background-color: white;">
					 <table id="menuTree" title="所有菜单" style="width:400px;height:500px">
				        <thead>
				            <tr>
				                <th data-options="field:'menuName'" width="220">菜单</th>
				            </tr>
				        </thead>
				    </table>
				    </div>
				    <div id="menuShow" style="float: right;width: 75%;height: auto; background-color: white;display: none">  
				         <form id="subForm" method="post" action="<%=request.getContextPath()%>/admin/menu/saveOrUpdate" class="form-horizontal" enctype="multipart/form-data">
					        <input type="hidden" name="menuId" id="menuId" value="">
					        <input type="hidden" name="parentId" id="parentId" value="">
					        <input type="hidden" name="menuLevel" id="menuLevel" value="">
					        <div class="box-body">
					          <div class="form-group">
					            <label for="inputName3" class="col-sm-2 control-label">菜单编码:</label>
					            <div class="col-sm-10">
					              <input type="text" name="menuCode" class="form-control" id="menuCode" placeholder="请输入菜单编码">
					            </div>
					          </div>
					          <div class="form-group">
					            <label for="inputName3" class="col-sm-2 control-label">菜单名称:</label>
					            <div class="col-sm-10">
					              <input type="text" name="menuName" class="form-control" id="menuName" placeholder="请输入菜单名称">
					            </div>
					          </div>
					           <div class="form-group">
					            <label for="inputName3" class="col-sm-2 control-label">链接:</label>
					            <div class="col-sm-10">
					              <input type="text" name="menuHref" class="form-control" id="menuHref" placeholder="请输入菜单链接">
					            </div>
					          </div>
					          <div class="form-group">
					            <label for="inputName3" class="col-sm-2 control-label">图标:</label>
					            <div class="col-sm-10">
					              <input type="text" name="menuIcon" class="form-control" id="menuIcon" placeholder="请输入菜单图标">
					            </div>
					          </div>
					          <div class="form-group">
					            <label for="inputName3" class="col-sm-2 control-label">顺序号:</label>
					            <div class="col-sm-10">
					              <input type="text" name="menuSeq" class="form-control" id="menuSeq" placeholder="请输入顺序号">
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
					            <label for="inputStatus3" class="col-sm-2 control-label">资源类型:</label>
					            <div class="col-sm-10">
					              <select name="type" id="type" class="form-control select1" style="width: 100%;">
					                  <option value="1">菜单资源</option>
					                  <option value="2">查询资源</option>
					                  <option value="3">按钮资源</option>
					              </select>
					            </div>
					          </div>
					          <div class="form-group">
					            <label for="inputName3" class="col-sm-2 control-label">资源标识符:</label>
					            <div class="col-sm-10">
					              <input type="text" name="percode" class="form-control" id="percode" placeholder="请输入资源标识符">
					            </div>
					          </div>
					          <div class="form-group">
					            <label for="inputStatus3" class="col-sm-2 control-label">状态:</label>
					            <div class="col-sm-10">
					              <select name="menuStatus" id="menuStatus" class="form-control select2" style="width: 100%;">
					                  <option value="1">在用</option>
					                  <option value="-1">停用</option>
					              </select>
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
layui.use(['layer','jquery','form','element'], function(){ })
$(document).ready(function () {
	//加载菜单树
	$('#menuTree').treegrid({
	    url:'<%=request.getContextPath()%>/admin/menu/tree',
	    method:'get',          //请求方式
	    idField:'menuId',           //定义标识树节点的键名字段
	    treeField:'menuName',       //定义树节点的字段
	    fit:true,               //网格自动撑满
	    fitColumns:true,
	    onLoadSuccess:function(node, data){
	    	$(this).treegrid('collapseAll');
	    },
	    onClickRow:function(row){
	    	$('#subForm').form('clear');  
            $('#menuId').val(row.menuId);
            $('#menuCode').val(row.menuCode);
            $('#menuName').val(row.menuName);
            $('#parentId').val(row.parentId);
            $('#menuSeq').val(row.menuSeq);
            $('#menuStatus').val(row.menuStatus);
            $('#menuLevel').val(row.menuLevel);
            $('#menuHref').val(row.menuHref);
            $('#menuIcon').val(row.menuIcon);
            $('#type').val(row.type);
            $('#percode').val(row.percode);
            $('#isEnd').val(row.isEnd);
            $('#menuShow').show();

		}
	});
});
//新增数据
function add(){
	$('#subForm').form('clear');  
	var row = $('#menuTree').datagrid('getSelected'); 
    if (row){ 
    	if(row.isEnd == 1){
    		$.messager.alert('错误','末级菜单下不能再添加菜单!','error');  
    	}else{
        	$('#parentId').val(row.menuId);
        	$('#menuLevel').val(Number(row.menuLevel)+1);
    	}
    } else {
    	$('#parentId').val(0);
    	$('#menuLevel').val(1);
    }
    $('#menuStatus').val(1);
    $('#isEnd').val(2);
	$('#menuShow').show();
}
//保存、修改数据
function saveOrUp(){
	$.ajax({
	   type: 'post',
	   url: '<%=request.getContextPath()%>/admin/menu/saveOrUpdate?'+$('#subForm').serialize(),
	   dataType: 'json',
	   success: function (data) {
		  if(data == null){
			  $.messager.alert('错误','系统错误，请联系管理员!','error');  
			  return ;
		  }
		  if($('#menuId').val()==null || $('#menuId').val()==''){
			    $('#menuTree').treegrid('append',{
					parent: data.parentId,  
					data: [{
						menuId: data.menuId,
						menuCode: data.menuCode,
						menuName: data.menuName,
						parentId: data.parentId,
						menuSeq: data.menuSeq,
						menuStatus: data.menuStatus,
						menuLevel: data.menuLevel,
						menuLogo: data.menuLogo,
						menuHref: data.menuHref,
						type: data.type,
						percode: data.percode,
						menuIcon: data.menuIcon,
						isEnd: data.isEnd
					}]
				});
			    $('#menuShow').hide();
			    layer.msg("新增成功");
			    //刷新数据
			    $('#menuTree').treegrid('reload');
		  }else{
			   $('#menuTree').treegrid('update',{
					id: $('#menuId').val(),
					row: {
						menuId: data.menuId,
						menuCode: data.menuCode,
						menuName: data.menuName,
						parentId: data.parentId,
						menuSeq: data.menuSeq,
						menuStatus: data.menuStatus,
						menuLevel: data.menuLevel,
						menuLogo: data.menuLogo,
						menuHref: data.menuHref,
						type: data.type,
						percode: data.percode,
						menuIcon: data.menuIcon,
						isEnd: data.isEnd
					}
			   });
			   $('#menuShow').hide();
			   layer.msg("修改成功");
		  }
	   }
	});  
}

//删除数据
function deleteGrid(){
	var row = $('#menuTree').datagrid('getSelected');
	if(row == null || row.menuId==null){
		layer.msg("请选择需要删除的数据");
	}
	$.ajax({
		   type: 'get',
		   url: '<%=request.getContextPath()%>/admin/menu/deleteMenu',
		   data:{"menuId":row.menuId},
		   dataType: 'json',
		   success: function (data) {
			   layer.msg(data.message);
			   //刷新数据
			   $('#menuTree').treegrid('reload');
		   }
	})
}

</script>
</body>
</html>