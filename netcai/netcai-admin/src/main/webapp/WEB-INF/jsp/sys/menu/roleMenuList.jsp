<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  <!-- 角色菜单start -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>设置角色菜单</h1>
    </section>
    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
			<div style="padding-top: 5px;">
				<div style="float: left;width: 45%;height: 600px;background-color: white;">
				 <table id="menuTree" title="请选择菜单" style="width:400px;height:500px">
			        <thead>
			            <tr>
			                <th data-options="field:'menuName'" width="320">菜单</th>
			                <th data-options="field:'selected'" width="200" align="center" formatter="formatcheckbox">选择</th>
			            </tr>
			        </thead>
			     </table>
			    </div>
			    <div style="float: right;width: 50%;height: 600px; background-color: white;">  
                 <table id="rmTree" title="已选菜单" style="width:400px;height:500px">
			        <thead>
			            <tr>
			                <th data-options="field:'menuName'" width="320">菜单</th>
			            </tr>
			        </thead>
			     </table>
			    </div>    
			</div>
          </div>
        </div>
      </div>
    </section>
  </div>
  <!-- 所有菜单按钮 -->
  <div id="c_tb" style="height:auto">
  	<a href="javascript:void(0)" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="saveOrUpdate()">保存</a>
  </div>

<script src="/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="/bootstrap/js/bootstrap.min.js"></script>
<script src="/js/jquery-ui.min.js"></script>
<script src="/layui/layui.js"></script>
<script src="/dist/js/app.min.js"></script>
<script type="text/javascript" src="/jquery-easyui-1.5.2/jquery.easyui.min.js" charset="utf-8"></script>
<script type="text/javascript" src="/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<script type="text/javascript" charset="utf-8">
$(document).ready(function () {
	//加载菜单树
	$('#menuTree').treegrid({
		url:'<%=request.getContextPath()%>/admin/menu/tree',
	    method:'get',          //请求方式
	    idField:'menuId',           //定义标识树节点的键名字段
	    treeField:'menuName',       //定义树节点的字段
	    toolbar:"#c_tb",
	    fit:true,               //网格自动撑满
	    onLoadSuccess:function(node, data){
	    	onLoad();  //加载已选择的数据
	    }
	});
	//加载菜单树
	$('#rmTree').treegrid({
	    url:'<%=request.getContextPath()%>/admin/menu/tree?roleId=${roleId}',
	    method:'get',          //请求方式
	    idField:'menuId',           //定义标识树节点的键名字段
	    treeField:'menuName',       //定义树节点的字段
	    fit:true               //网格自动撑满
	});
});
//勾选checkbox
function show(checkid) {
    var s = '#check_' + checkid;
    /*选子节点*/
    var nodes = $("#menuTree").treegrid("getChildren", checkid);
    for (i = 0; i < nodes.length; i++) {
    	//当父节点被选中，则其孩子都被选中
        $(('#check_' + nodes[i].menuId))[0].checked = $(s)[0].checked;
    }
    //选上级节点
    if ($(s)[0].checked) {
    	//如果子节点选中，则父节点选中
        var parent = $("#menuTree").treegrid("getParent", checkid);
        for(var i=0;i<parent.children.length;i++){
        	var is_checked = $(('#check_' + parent.children[i].menuId))[0].checked;
        	if(is_checked && $(('#check_' + parent.menuId))[0]!=undefined){
                $(('#check_' + parent.menuId))[0].checked = true;
                break;
        	}
        }
    }
}
function formatcheckbox(val, row) {
    return "<input value='" + row.menuId + "' type='checkbox' onclick=show('" + row.menuId + "') id='check_" + row.menuId + "' />";
}
//获取选中的结点
function getSelected() {
    var idList = "";
    $("input:checked").each(function() {
        var id = $(this).attr("id");
        if (id.indexOf("check_") > -1) {
            idList += id.replace("check_", '') + ',';
        }
    });
    if(idList!=""){
    	idList = idList.substring(0,idList.length-1);
    }
    return idList;
}
//保存、修改数据
function saveOrUpdate(){
	var menuIds = getSelected();
	$.ajax({
	  type: 'post',
	  url: '/admin/menu/saveRoleMenu?roleId=${roleId}&menuIds='+menuIds,
	  dataType: 'json',
	  success: function (data) {
		  if(data.code==200){
			  $.messager.alert('提示','更新成功!');  
			  window.location.reload();
		  }else{
			  $.messager.alert('错误','更新失败!','error');  
		  }
	  }
   });
}
function onLoad(){
	<c:forEach items="${menuList}" var="menu" varStatus="status"> 
	   $(('#check_${menu.menuId}')).attr("checked",true);
	</c:forEach>
}
</script>
</body>
</html>