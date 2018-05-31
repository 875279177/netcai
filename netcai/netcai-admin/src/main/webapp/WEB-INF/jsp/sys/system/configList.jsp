<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="pv" uri="/pageTaglib"%>
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
<body class="hold-transition skin-blue sidebar-mini">
  <!-- 配送人员列表start -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>系统管理</h1>
    </section>
    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">系统配置信息</h3>
            </div>
            
            <!-- <!-- 表单start -->
            <form id="sysSystemConfigForm" class="layui-form" action="<%=request.getContextPath() %>/admin/sysSystemConfig/list" method="post" >
              <div class="col-sm-10">
                <div class="form-group" >
                  <label for="paramCode" class="col-sm-2 control-label" >参数编码</label>
                  <div class="col-xs-3">
	                <input type="text" class="form-control input-small" id="sysSystemConfigparamCode" name="paramCode" value="${sysSystemConfig.paramCode}" placeholder="请输入参数编码">
	              </div>
	              <label for="paramName" class="col-sm-2 control-label">参数名称</label>
                  <div class="col-xs-3">
	                <input type="text" class="form-control" id="sysSystemConfigparamName" name="paramName" value="${sysSystemConfig.paramName}" placeholder="请输入参数名称">
	              </div>
                </div>
              </div>
              <div class="col-sm-3 layui-form-item layui-form-btns" style="float: right;">
				   <div class="layui-input-block">
				     <button class="layui-btn" lay-submit="" lay-filter="demo1">查询</button>
				     <button type="reset" id="reset" class="layui-btn layui-btn-primary">重置</button>
				   </div>
			   </div>
            </form> 
            <!-- 增删改图标按钮组 -->
            <div class="site-demo-button" style="margin-top: 50px">
            <button data-method="setTop" class="layui-btn layui-btn-primary layui-btn-small" onclick="add()"><i class="layui-icon"></i><span>&nbsp;&nbsp;新增</span></button>
		 	
			</div>
            <!-- 表单end -->
            <!-- /.box-header -->
            <div class="layui-form" >
              <table class="layui-table table-striped">
	            <colgroup>
			      <col width="50">
			      <col width="120">
			      <col width="120">
			      <col width="120">
			      <col width="120">
			      <col width="200">
			    </colgroup>
                <thead>
	             <tr>
	                <th>参数编码</th>
	                <th>参数名称</th>
	                <th>参数值</th>
	                <th>参数描述</th>
	                <th>创建时间</th>
	                <th>操作</th>
	              </tr>
                </thead>
                <tbody>
	              <c:forEach items="${paginator.object}" var="r"> 
		   			 <tr>
					       <td>${r.paramCode}</td>
					       <td>${r.paramName}</td>
					       <td>${r.paramValue}</td>
					       <td>${r.paramDesc}</td>
					       <td><fmt:formatDate value="${r.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					       <td>
					       	<a href="#" onclick="get(${r.id})" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
			  				<a href="#" onclick="update(${r.id})" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 修改</a>
			  				<a href="#" onclick="del(${r.id})" id="del"  class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 删除</a>
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
      </div>
    </section>
  </div>
  <!-- 配送人员列表end -->
    </section>
  </div>
    <div id="content" style="display: none">
        <div class="col-sm-1"></div>
		  <div class="col-sm-10">
			  <form class="form-horizontal" action="/admin/sysSystemConfig/add" role="form"  method="post">
			   <input type="hidden" name="id" id="id" value="">
		           <fieldset>
		              <div class="form-group">
		                 <label class="col-sm-2 control-label" for="paramCode">参数编码</label>
		                 <div class="col-sm-10">
		                    <input class="form-control" id="paramCode" type="text" placeholder="参数编码"  name="paramCode"/>
		                 </div>
		              </div>
		              
		              <div class="form-group">
		                 <label class="col-sm-2 control-label" for="paramName">参数名称</label>
		                 <div class="col-sm-4">
		                    <input class="form-control" id="paramName" type="text" placeholder="参数名称"  name="paramName"/>
		                 </div>
		                 <label class="col-sm-2 control-label" for="paramValue">参数值</label>
		                 <div class="col-sm-4">
		                    <input class="form-control" id="paramValue" type="text" placeholder="参数值"  name="paramValue"/>
		                 </div>
		              </div>
		              
		              <div class="form-group">
		              <label class="col-sm-2 control-label" for="paramDesc">参数描述</label>
		                 <div class="col-sm-10">
		                   <input type="text" class="form-control"  id="paramDesc" name="paramDesc" />
		                 </div>
		             </div>
		             
		              <div class="form-group">
		            <label for="inputStatus3" class="col-sm-2 control-label">状态:</label>
		            <div class="col-sm-10">
		             	<button type="submit" class="btn btn-info pull-left" onclick="saveOrUp()">提交</button>
		            </div>
		          </div>
		           </fieldset>     
		       </form>
		  </div>
  	<div class="col-sm-2"></div>
  </div>
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
<script type="text/javascript">
function onSelectPage(currentPage)
{  
	var paramCodeOld=$("#sysSystemConfigparamCode").val();
	var paramNameOld=$("#sysSystemConfigparamName").val();
	(paramCodeOld == undefined)? paramCode = "" :paramCode = paramCodeOld;
	(paramNameOld == undefined)? paramName = "" :paramName = paramNameOld;
	window.location.href="/admin/sysSystemConfig/list?pageNum="+currentPage+"&paramCode="+paramCode+"&paramName="+paramName;
}  
</script>
<script>
//重置
$(function(){
   $("#reset").click(function(){
    $("#sysSystemConfigparamCode").attr("value","");
    $("#sysSystemConfigparamName").attr("value","");
   });
  });

/* 提交表单数据 */
function checkForm(){
	  alert("提交数据");
}

function add(){
	 $("#id").attr("value", "");
	  $("#paramCode").attr("value","");
	  $("#paramName").attr("value", "");
	  $("#paramValue").attr("value", "");
	  $("#paramDesc").attr("value", "");
	popup('新增系统配置','800px','350px',$('#content').html());
}


//修改数据
function update(id){
	  $.ajax({
		  type: 'POST',
		  url: '/admin/sysSystemConfig/getById?id='+id,
		  dataType: 'json',
		  success: function (data) {
			  $("#id").attr("value", data.id);
			  $("#paramCode").attr("value", data.paramCode);
			  $("#paramName").attr("value", data.paramName);
			  $("#paramValue").attr("value", data.paramValue);
			  $("#paramDesc").attr("value", data.paramDesc);
			  popup('修改系统配置','800px','350px',$('#content').html());
		  }
	  });
}

//保存、修改数据
function saveOrUp(){
	  $('#subForm').validate({ 		
			submitHandler: function (form) {
				$('#subForm').submit();
			}
		});
}

/* 删除 */
function del(id) {
	if(confirm("真的要删除吗?")){
		$.ajax({  
            url:"/admin/sysSystemConfig/delete",
            data:{"id":id},
            dataType:"json",  
            success:function(){  
                alert("删除成功！"); 
                window.location.reload();
            }  
        }); 
		  }
		  else{
		   return;
		  }
}

/* 查看 */
function get(id) {
    //iframe层
    layer.open({
        type: 2,
        title: '添加系统参数',
        shadeClose: true,
        shade: 0.8,
        area: ['770px', '320px'],
        content: "<%=request.getContextPath()%>/admin/sysSystemConfig/toAdd?id="+id
    }); 
}

layui.use('form', function(){
	  var $ = layui.jquery, form = layui.form();
	  
	  //全选
	  form.on('checkbox(allChoose)', function(data){
	    var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]');
	    child.each(function(index, item){
	      item.checked = data.elem.checked;
	    });
	    form.render('checkbox');
	  });
	  
});
</script>
</body>
</html>