<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="pv" uri="/pageTaglib"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta name="decorator" content="default" />
<style type="text/css">
button {
	margin-right: 5px;
}

.layui-form-label {
	width: 100px;
}

.layui-table .layui-form-checkbox[lay-skin=primary] {
	margin: 0;
}
</style>
</head>
<body>
	<!-- 商品信息列表start -->
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>商品信息管理</h1>
		</section>
		<!-- Main content -->
		<shiro:hasPermission name="goods:query">
			<section class="content">
				<div class="row">
					<div class="col-xs-12">
						<div class="box">
							<div class="box-header">
								<h3 class="box-title">商品信息</h3>
							</div>
							<!-- 表单start -->
							<form id="searchForm" class="form-horizontal" method="post"
								action="/admin/goods/list">
								<input type="hidden" id="sellerId" name="sellerId"
									value="${sgv.sellerId}"> <input type="hidden"
									name="type" value="${sgv.type}"> <input type="hidden"
									name="pageNum" id="pageNum" value="${paginator.currentPage}">
								<input type="hidden" name="pageSize" id="pageSize"
									value="${paginator.pageRecord}">
								<div class="box-body">
									<div class="form-group">
										<label class="col-sm-2 control-label">商家名称</label>
										<div class="col-xs-3">
											<c:choose>
												<c:when test="${sgv.type == 0}">
													<input type="text" id="sellerName" name="sellerName"
														value="${sgv.sellerName}" class="form-control input-small"
														placeholder="请输入商家名称">
												</c:when>
												<c:otherwise>
													<input type="text" id="sellerName"
														value="${sgv.sellerName}" class="form-control input-small"
														placeholder="请输入商家名称" readonly="readonly">
												</c:otherwise>
											</c:choose>
										</div>
										<label class="col-sm-2 control-label">商品分类</label>
										<div class="col-xs-3">
											<input type="text" name="categoryName"
												value="${sgv.categoryName}" class="form-control input-small"
												placeholder="请输入商品分类名称">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">商品名称</label>
										<div class="col-xs-3">
											<input type="text" name="searchName"
												value="${sgv.searchName}" class="form-control input-small"
												placeholder="请输入商品名称">
										</div>
										<label class="col-sm-2 control-label">商品状态</label>
										<div class="col-xs-3">
											<select name="searchStatus" id="searchStatus"
												class="form-control select2" style="width: 100%;">
												<option value="">全部</option>
												<option value="1"
													<c:if test="${sgv.searchStatus==1}">selected</c:if>>上架</option>
												<option value="-1"
													<c:if test="${sgv.searchStatus==-1}">selected</c:if>>下架</option>
												<option value="-2"
													<c:if test="${sgv.searchStatus==-2}">selected</c:if>>下架并隐藏</option>
											</select>
										</div>
									</div>
								</div>
								<div class="box-footer">
									<button type="reset" id="reset" class="btn btn-info pull-right"
										style="margin-right: 40px;">重置</button>
									<button type="submit" class="btn btn-info pull-right">查询</button>
									<button type="button" class="btn btn-info pull-right"
										onclick="exportExcel()">导出</button>
								</div>
							</form>
							<!-- 表单end -->
							<div class="site-demo-button">
								<shiro:hasPermission name="goods:insert">
									<c:if test="${sgv.type == 1}">
										<button data-method="setTop" class="layui-btn layui-btn-small"
											onclick="add()">
											<i class="layui-icon"></i><span>&nbsp;&nbsp;新增</span>
										</button>
									</c:if>
								</shiro:hasPermission>
								<shiro:hasPermission name="goods:copy">
									<button data-method="setTop" class="layui-btn layui-btn-small"
										onclick="copy()">
										<i class="layui-icon"></i><span>&nbsp;&nbsp;复制</span>
									</button>
								</shiro:hasPermission>
								<shiro:hasPermission name="goods:upAndDown">
									<button data-method="setTop" class="layui-btn layui-btn-small"
										onclick="upStatus(1,'上架')">
										<i class="layui-icon"></i><span>&nbsp;&nbsp;上架</span>
									</button>
									<button data-method="setTop" class="layui-btn layui-btn-small"
										onclick="upStatus(-1,'下架')">
										<i class="layui-icon"></i><span>&nbsp;&nbsp;下架</span>
									</button>
									<button data-method="setTop" class="layui-btn layui-btn-small"
										onclick="upStatus(-2,'隐藏')">
										<i class="layui-icon"></i><span>&nbsp;&nbsp;下架并隐藏</span>
									</button>
								</shiro:hasPermission>
							</div>
							<!-- /.box-header -->
							<div class="layui-form">
								<table class="layui-table">
									<thead>
										<tr>
											<th><input type="checkbox" lay-skin="primary"
												lay-filter="allChoose" /></th>
											<th>商家名称</th>
											<th>商家手机</th>
											<th>分类</th>
											<th>名称</th>
											<th>别名</th>
											<th>标签</th>
											<th>品牌</th>
											<th>顺序号
												<button data-method="setTop" class="layui-btn layui-btn-small" onclick="upSeq()">
													<i class="layui-icon"></i><span>&nbsp;&nbsp;调整</span>
												</button>
											</th>
											<th>状态</th>
											<th>创建时间</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${paginator.object}" var="r">
											<tr>
												<td><input type="checkbox" name="goodsIds" value="${r.goodsId}" lay-skin="primary"></td>
												<td>${r.sellerName}</td>
												<td>${r.sellerAccount}</td>
												<td>${r.categoryName}</td>
												<td>${r.goodsName}</td>
												<td>${r.goodsAs}</td>
												<td>${r.goodsLabel}</td>
												<td>${r.goodsBrand}</td>
												<td><input name="seqs" id="${r.goodsId}" value="${r.goodsSeq}" /></td>
												<td>
												    <c:if test="${r.goodsStatus==1}">上架</c:if> 
												    <c:if test="${r.goodsStatus==-1}">下架</c:if> 
												    <c:if test="${r.goodsStatus==-2}">下架并隐藏</c:if>
											    </td>
												<td><fmt:formatDate value="${r.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
												<td>
												    <shiro:hasPermission name="goods:update">
														<div class="site-demo-button">
															<button data-method="setTop" class="layui-btn layui-btn-normal layui-btn-small" onclick="update(${r.goodsId},${r.sellerId})">
																<i class="layui-icon"></i><span>&nbsp;&nbsp;修改</span>
															</button>
															<button data-method="setTop" class="layui-btn layui-btn-normal layui-btn-small" onclick="del(${r.goodsId})">
																<i class="layui-icon"></i><span>&nbsp;&nbsp;删除</span>
															</button>
														</div>
													</shiro:hasPermission>
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
	<div id="w" class="easyui-window" title="选择商家"
		data-options="modal:true,closed:true,iconCls:'icon-save'"
		style="width: 700px; height: 600px; padding: 10px;">
		<form id="subForm" class="form-horizontal" action="">
			<div class="box-body">
				<div class="form-group">
					<label class="col-sm-2 control-label">区域:</label>
					<div class="col-xs-3">
						<select id="areaId" name="areaId" class="form-control">
							<option value="">全部</option>
						</select>
					</div>
					<label class="col-sm-2 control-label">名称:</label>
					<div class="col-xs-3">
						<input type="text" name="sellerName"
							class="form-control input-small" placeholder="请输入店铺名称">
					</div>
				</div>
			</div>
			<div class="box-footer">
				<button type="reset" class="btn btn-info pull-right"
					style="margin-right: 40px;" onclick="selectSeller()">确定</button>
				<button type="button" class="btn btn-info pull-right"
					onclick="searchSeller()">查询</button>
			</div>
		</form>
		<table id="cg" style="height: 360px; width: 620px;">
		</table>
	</div>
	<script src="/plugins/jQuery/jquery-2.2.3.min.js"></script>
	<script src="/bootstrap/js/bootstrap.min.js"></script>
	<script src="/js/jquery-ui.min.js"></script>
	<script src="/layui/layui.js"></script>
	<script src="/dist/js/app.min.js"></script>
	<script type="text/javascript" src="/jquery-easyui-1.5.2/jquery.easyui.min.js" charset="utf-8"></script>
	<script type="text/javascript" src="/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
	<script type="text/javascript">
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
		//分页
		function onSelectPage(currentPage,pageSize){  
			$('#pageNum').val(currentPage);
			$('#pageSize').val(pageSize);
			$('#searchForm').submit();
		}
		
		//重置
		$(function(){
		 $("#reset").click(function(){
			   window.location.href="/admin/goods/list";
		 });
		 var url='/admin/region/Alllist'; 
		 jQuery.ajax({ 
		   type:'post', 
		   url:url, 
		   async:false,
		   success:function (date){
			   var areaList = date.object;  
		       if(areaList != null && areaList.length > 0){
		         for(var i = 0; i< areaList.length; i++){
		            if(areaList[i].id == areaId){
		         	   $("<option value='"+areaList[i].id+"' selected>"+areaList[i].areaName+"</option>").appendTo("#areaId");
		            }else {
		            $("<option value='"+areaList[i].id+"'>"+areaList[i].areaName+"</option>").appendTo("#areaId");  
					}
		         }  
		       } 
		   } 
		 }); 
		});
		//新增
		function add(){
			window.location.href="/admin/goods/addOrEdit?"+$('#searchForm').serialize();
		}
		//修改
		function update(goodsId,sellerId){
			$('#sellerId').val(sellerId);
			window.location.href="/admin/goods/addOrEdit?goodsId="+goodsId+"&"+$('#searchForm').serialize();
		}
		//导出
		function exportExcel(){
			window.location.href="/admin/goods/export?"+$('#searchForm').serialize();
		}
		//搜索商家
		function searchSeller(){
			$("#cg").datagrid({
				url:'/admin/seller/search?'+$('#subForm').serialize(),
			    rownumbers: true,
			    columns:[[
			        { field: 'sellerId',width:'50', title: '商家ID' },
			        { field: 'sellerName',width:'200', title: '店铺名称' },
			        { field: 'sellerTel',width:'100', title: '手机号' }
			    ]],
			    fitColumns:"true",
			    singleSelect: true,
			    selectOnCheck: true,
			    checkOnSelect: true
			});	
		}
		//选定商家
		function selectSeller(){
			var row = $('#cg').datagrid('getSelected');
			if(row){
				var goodsIds = "";
				$("input[name='goodsIds']:checked").each(function(){
					goodsIds += $(this).val()+",";
				})
				if(goodsIds != ""){
					goodsIds = goodsIds.substring(0,goodsIds.length-1);
				}
			    $.ajax({
				  type: 'post',
				  url: '/admin/goods/copyGoods?goodsIds='+goodsIds+"&sellerId="+row.sellerId,
				  dataType: 'json',
				  success: function (data) {
					  if(data.code==200){
						  $.messager.alert('温馨提示','复制成功！');  
					  }else{
						  $.messager.alert('错误','复制失败！','error');  
					  }
				  }
			    });
			}else{
				$.messager.alert('错误','请选择商家！','error');  
				return;
			}
			$('#w').window('close');
		}
		//复制
		function copy(){
			var check_sizes = $("input[name='goodsIds']:checked").length;
			if(check_sizes < 1){
				$.messager.alert('错误','请选择您要复制的商品！','error');  
			}
			searchSeller();
			$('#w').window('open');
		}
		//删除
		function del(goodsId){
			$.messager.confirm("提示", "确定要删除么?", function (r) {
		        if (r) {
		            $.ajax({
		                type: "POST",
		                url: "/admin/goods/deleteGoods?goodsId="+goodsId,
		                datatype: "json",   
		                success: function (data) {
		                    if (data.code == 200) {
		                        $.messager.alert("提示", data.message);
		                    	if(data.object == 0){
		                    		window.location.reload();
		                    	}
		                    }else{
		                    	$.messager.alert('错误','系统错误，请联系管理员！','error');  
		                    }
		                },
		                complete: function (XMLHttpRequest, textStatus) {
		                },
		                error: function () {
		                }
		            });
		        }
		    });
		}
		//上架、下架
		function upStatus(type,name){
			var goodsIds = "";
			$("input[name='goodsIds']:checked").each(function(){
				goodsIds += $(this).val()+",";
			})
			if(goodsIds != ""){
				goodsIds = goodsIds.substring(0,goodsIds.length-1);
			}
			if(goodsIds == ""){
				$.messager.alert('错误','请选择您要'+name+'的商品！','error');
				return;
			}
			$.messager.confirm("提示", "确定要"+name+"这些商品么?", function (r) {
		        if (r) {
		            $.ajax({
		                type: "POST",
		                url: "/admin/goods/updateGoodsStatus?goodsIds="+goodsIds+"&goodsStatus="+type,
		                datatype: "json",   
		                success: function (data) {
		                    if (data.code == 200) {
		                        $.messager.alert("提示", name+"成功！");
		                    	window.location.reload();
		                    }else{
		                    	$.messager.alert('错误','系统错误，请联系管理员！','error');  
		                    }
		                },
		                complete: function (XMLHttpRequest, textStatus) {
		                },
		                error: function () {
		                }
		            });
		        }
		    });
		}
		function upSeq(){
			var seqs = "";
			$("input[name='seqs']").each(function(){
				seqs += $(this).attr("id")+"_"+$(this).val()+",";
			})
			if(seqs != ""){
				seqs = seqs.substring(0,seqs.length-1);
			}
			$.messager.confirm("提示", "确定要调整这些商品的顺序么?", function (r) {
		        if (r) {
		            $.ajax({
		                type: "POST",
		                url: "/admin/goods/updateGoodsSeq?seqs="+seqs,
		                datatype: "json",   
		                success: function (data) {
		                    if (data.code == 200) {
		                        $.messager.alert("提示", "顺序调整成功！");
		                    	window.location.reload();
		                    }else{
		                    	$.messager.alert('错误','系统错误，请联系管理员！','error');  
		                    }
		                },
		                complete: function (XMLHttpRequest, textStatus) {
		                },
		                error: function () {
		                }
		            });
		        }
		    });
		}
	</script>
</body>
</html>