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
	.layui-form-label {
		width: 100px;
	}
	
	.layui-input-block {
		width: auto;
		height: auto;
	}
	
	table th {
		background: #ffffff;
	}
	
	table tr:nth-child(odd) {
		background: #F0F0F0;
	}
	
	.col-sm-2 {
		width: 10%;
	}
	
	.form-footer {
		margin-right: 800px;
		float: right;
	}
	
	.btn-select {
		margin-right: 10px;
	}
  </style>
</head>
<body class="hold-transition skin-blue sidebar-mini">
  <!-- 广告信息列表start -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) --> 
    <section class="content-header">
      <h1>常见问题</h1>
    </section>
    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
	        <div class="box box-info" >
	           <!-- form start -->
	           <form  id="form_submit" class="form-horizontal layui-form" action="/admin/problem/list">
	             <input type="hidden" name="pageNum" id="pageNum" value="${paginator.currentPage}">
              <input type="hidden" name="pageSize" id="pageSize" value="${paginator.pageRecord}">
	              <div class="box-body">
	               <div class="col-sm-12">
		               <div class="form-group">
		                 <label for="question" class="col-sm-1 control-label">问题</label>
		                 <div class="col-xs-2" style="width: 200px">
		                   <input type="text" class="form-control" id="question" name="question" value="${problem.question}" placeholder="请输入问题">
		                 </div>
						 <label for="type" class="col-sm-1 control-label">类型</label>
						 <div class="col-xs-2" style="width: 200px">
						   <select id="type" name="type" class="form-control" >
							 <option value="" selected>全部</option>
							 <option value="1" <c:if test="${problem.type == 1}">selected</c:if>>买家</option>
							 <option value="2" <c:if test="${problem.type == 2}">selected</c:if>>卖家</option>
						   </select>
						 </div>
		               </div>
	               </div>
	               <div class="form-footer">
						<button type="submit" class="btn btn-info pull-left" >提交</button>
			            <button type="reset" id="reset" class="btn btn-info pull-left" style="margin-left:6px;">重置</button>
					</div>
				</div>
	           </form>
	           <!-- form end -->
	        </div>
	        
	        <!-- 增删改图标按钮组 -->
            <div class="site-demo-button" style="margin-top: 100px">
               <button onclick="add()" class="btn btn-success btn-xs"><i class="layui-icon"></i><span>&nbsp;&nbsp;新增</span></button>
			</button>
			<!-- 表格列表start -->
            <div class="box">
	           <div class="box-body">
	             <table id="example1" class="table table-bordered table-striped">
	               <thead>
		              <tr>
		                <th>问题</th>
		                <th>答案</th>
		                <th>分类标示</th>
		                <th>状态</th>
		                <th>类型</th>
		                <th>创建时间</th>
		                <th style="width: 160px">操作</th>
		              </tr>
	               </thead>
	               <tbody>
	               <c:forEach items="${paginator.object}" var="r"> 
		   			 <tr>
				       <td>${r.question}</td>
				       <td>${r.answer}</td>
				       <td>${r.classify}</td>
				       <td>
				         <c:if test="${r.status==1 }">显示</c:if>
				         <c:if test="${r.status==-1 }">隐藏</c:if>
				       </td>
				       <td>
				         <c:if test="${r.type==1 }">买家</c:if>
				         <c:if test="${r.type==2 }">卖家</c:if>
				       </td>
				       <td><fmt:formatDate value="${r.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				       <td>
				         <div class="site-demo-button" >
						       <button onclick="update(${r.id })"  class="layui-btn layui-btn-warm layui-btn-small"><span>&nbsp;&nbsp;修改</span></button>
						 </div>
				       </td>
		             </tr>
				   </c:forEach>
                  </tbody>
	             </table>
	           </div>
	        </div>
            <!-- 表格列表end -->
            <div class="box-footer clearfix">
              <ul class="pagination pagination-sm no-margin pull-left">
              	 <pv:showPaging pageVo="${paginator}" />
              </ul>
            </div>
          </div>
        </div>
      </div>
    </section>
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
<script src="/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script src="/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="/plugins/fastclick/fastclick.js"></script>
<script src="/dist/js/app.min.js"></script>
<script src="/dist/js/demo.js"></script>
<script src="/js/jquery-ui.min.js"></script>
<script src="/layer/layer.js"></script>
<script src="/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript">
function onSelectPage(currentPage,pageSize)
{  
	$('#pageNum').val(currentPage);
	$('#pageSize').val(pageSize);
	$('#form_submit').submit();
} 

//新增;
function add(){
	layer.open({
        type: 2, 
        title: '新增',
        area: ['1200px', '800px'],
        shade: 0.5,
        content: '/admin/problem/toFrom',
        zIndex: layer.zIndex, //重点1
        cache: false,
      });
}

//修改;
function update(id){
	layer.open({
        type: 2, 
        title: '修改',
        area: ['1200px', '800px'],
        shade: 0.5,
        content: '/admin/problem/toFrom?id='+id,
        zIndex: layer.zIndex, //重点1
        cache: false,
      });
}

//重置
$(function(){
   $("#reset").click(function(){
	   window.location.href="/admin/problem/list";
   });
  });
</script>
<script>
   //新增数据弹窗
   layui.use(['layer','jquery','form','element'], function(){ //独立版的layer无需执行这一句
	   var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句  
	});
</script>
</body>
</html>