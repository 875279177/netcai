<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="pv" uri="/pageTaglib"%>  
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName();
	String port = String.valueOf(request.getServerPort());
	if(port.equals("80")) {
		basePath += path+"/";
	} else {
		basePath += ":" + port+path+"/";
	}
%>
<!DOCTYPE html>
<html>
<head>
  <meta name="decorator" content="default"/>  
  <style type="text/css">
    button{
      margin-right:5px;
    }
     #picList { padding-left:60px; min-height:99px; width:100px;}
     #picList div.unit{margin:5px;padding:5px;*padding:4px;background:white;}
     #picList div.unit img {width:100px; height:80px;}
     #picList div.unit input { margin:0px 4px;}
     #picList div.unit div.line{width:100px;overflow:hidden;}
  </style>
</head>
<body>
  <!-- 商品信息列表start -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>添加商品信息</h1>
    </section>
    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">商品信息</h3>
            </div>
            <!-- 表单start -->
            <form id="subForm" class="form-horizontal" method="post" action="/admin/goods/saveOrUpdate" >
              <input id="goodsId" name="goodsId" value="${goods.goodsId}"  type="hidden"/> 
              <!-- 列表搜索条件start -->
              <input name="userId" value="${sellerId}"  type="hidden"/> 
              <input name="type" value="${type}"  type="hidden"/>
              <input name="sellerName" value="${sellerName}"  type="hidden"/> 
              <input name="categoryName" value="${categoryName}"  type="hidden"/> 
              <input name="searchName" value="${searchName}"  type="hidden"/> 
              <input name="searchStatus" value="${searchStatus}"  type="hidden"/> 
              <input name="pageNum" value="${pageNum}"  type="hidden"/> 
              <input name="pageSize" value="${pageSize}"  type="hidden"/> 
              <!-- 列表搜索条件end -->
              <div class="box-body">
                <div class="form-group" >
                  <label for="inputEmail3" class="col-sm-2 control-label">商品分类:</label>
                  <div class="col-xs-3">
	                <input id="categoryName" value="${goods.category.categoryName}" onclick="$('#w').window('open')" readonly="readonly" type="text" class="form-control input-small" />
  			        <input id="categoryId" name="category.categoryId" value="${goods.category.categoryId}"  type="hidden"/> 
	              </div>
                </div>
                <div class="form-group" >
                  <label for="inputEmail3" class="col-sm-2 control-label">商品名称:</label>
                  <div class="col-xs-3">
	                <input type="text" name="goodsName" value="${goods.goodsName}" class="form-control input-small" placeholder="请输入商品名称">
	              </div>
	              <label for="inputPassword3" class="col-sm-2 control-label">商品别名:</label>
                  <div class="col-xs-3">
	                <input type="text" name="goodsAs" value="${goods.goodsAs}"  class="form-control" placeholder="请输入商品别名">
	              </div>
                </div>
                <div class="form-group" >
                  <label for="inputEmail3" class="col-sm-2 control-label">商品标签:</label>
                  <div class="col-xs-3">
	                <input type="text" name="goodsLabel" value="${goods.goodsLabel}"  class="form-control input-small" placeholder="请输入商品标签">
	              </div>
	              <label for="inputPassword3" class="col-sm-2 control-label">商品品牌:</label>
                  <div class="col-xs-3">
	                <input type="text" name="goodsBrand" value="${goods.goodsBrand}"  class="form-control" placeholder="请输入商品品牌">
	              </div>
                </div>
                <div class="form-group" >
                  <label for="inputEmail3" class="col-sm-2 control-label">顺序号:</label>
                  <div class="col-xs-3">
	                <input type="text" name="goodsSeq" value="${goods.goodsSeq}"  class="form-control input-small" placeholder="请输入顺序号">
	              </div>
	              <label for="inputPassword3" class="col-sm-2 control-label">商品状态:</label>
                  <div class="col-xs-3">
	                  <select name="goodsStatus" id="goodsStatus" class="form-control select2" style="width: 100%;">
		                  <option value="1" <c:if test="${goods.goodsStatus==1}">selected</c:if>>上架</option>
		                  <option value="-1" <c:if test="${goods.goodsStatus==-1}">selected</c:if>>下架</option>
		                  <option value="-2" <c:if test="${goods.goodsStatus==-2}">selected</c:if>>下架并隐藏</option>
		              </select>
	              </div>
                </div>
                <div class="form-group" >
                  <label for="inputEmail3" class="col-sm-2 control-label">商品简述:</label>
                  <div class="col-xs-3">
	                <textarea id="goodsDesc" name="goodsDesc" rows="5" cols="53">${goods.goodsDesc}</textarea>
	              </div>
                </div>
                <div class="form-group" id="methodShow" style="display: none">
	                <label for="inputStatus3" class="col-sm-2 control-label">加工方式:</label>
	                <div class="col-sm-10" id="goodsMethod">
		                
	                </div>
	             </div>
              </div>
              <div class="box-header">
                <h3 class="box-title">商品图片</h3>
              </div>
              <div class="form-group" >
                  <label for="inputEmail3" class="col-sm-2 control-label"><input type="button" id="J_selectImage" class="btn btn-info" value="上传图片" /></label>
                  <div class="col-xs-3">
	                <span id="ProductPicCount"></span>
	              </div>
              </div>
              <div class="form-group" >
                  <div class="col-xs-3">
                     <div id="picList" style="width:100%"></div>
                  </div>
              </div>
              <div class="box-header">
                <h3 class="box-title">商品规格</h3>
              </div>
              <div class="box-body">
                <table id="dg" title="商品规格" style="height:auto">
				  <thead>
				   <tr>
				    <th data-options="field:'format_id',width:0,hidden:true"></th>
				    <th data-options="field:'format_name',width:200">描述</th>
				    <th data-options="field:'format_price',width:200">价格</th>
				    <th data-options="field:'format_num',width:200">数量</th>
				    <th data-options="field:'format_unit',width:100">单位</th>
				    <th data-options="field:'format_seq',width:100">顺序</th>
				    <th data-options="field:'format_status',width:100">状态</th>
				   </tr>
				  </thead>
				 </table>
              </div>
              <div class="box-footer">
                <button type="reset" class="btn btn-info pull-right" style="margin-right:40px;">重置</button>
                <button type="button" class="btn btn-info pull-right" onclick="saveOrUp()">提交</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </section>
  </div>

  <div id="tb" style="height:auto">
  	<a href="javascript:void(0)" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="append()">新增</a>
  	<a href="javascript:void(0)" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="removeit()">删除</a>
  </div>
  <div id="w" class="easyui-window" title="选择商品分类" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:490px;height:450px;padding:10px;">  
	  <table id="cg" style="width:390px;">  
	        <thead>  
	            <tr>  
	                <th data-options="field:'categoryName'" width="385">分类列表(双击选择)</th>  
	            </tr>  
	        </thead>  
	   </table>
  </div>
  
  <div id="outerdiv" style="position:fixed;top:0;left:0;background:rgba(0,0,0,0.7);z-index:999;width:100%;height:100%;display:none;">
    <a class="close" onclick="$('#outerdiv').fadeOut('fast');"></a>
    <div id="innerdiv" style="position:absolute;"><img id="bigimg" style="border:5px solid #fff;" src="" /></div>
  </div>
<script src="/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="/bootstrap/js/bootstrap.min.js"></script>
<script src="/js/raphael-min.js"></script>
<script src="/dist/js/app.min.js"></script>
<script charset="utf-8" src="/kindeditor/kindeditor-all.js"></script>
<script charset="utf-8" src="/kindeditor/lang/zh-CN.js"></script>
<script charset="utf-8" src="/kindeditor/plugins/code/prettify.js"></script>
<script type="text/javascript" src="/jquery-easyui-1.5.2/jquery.easyui.min.js" charset="utf-8"></script>
<script type="text/javascript" src="/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<script type="text/javascript">
$("#dg").datagrid({
	url:'',
	toolbar:"#tb",
	fitColumns:"true",
	singleSelect : true,
	rownumbers:true
});
//声明变量
var unitOption = '';
var index = ${fn:length(goods.formatList)};
var picList,productPicCount = null;
var _sort = ${fn:length(goods.pictureList)};
var uploadCount = ${fn:length(goods.pictureList)};
$(document).ready(function () {
     picList = $("#picList");
     productPicCount = 5;
     updateUploadtxt();
     //取得所有在用的商品分类
     $('#cg').treegrid({
     	url:'<%=request.getContextPath()%>/admin/sellercategory/tree?userId=${sellerId}',
     	method:'get',
     	idField: 'categoryId',  
     	treeField: 'categoryName',
     	onDblClickRow:function(){
     		var selected = $('#cg').treegrid('getSelected');
         	if (selected){
         		if(selected.isEnd == 1){
     	    		$("#categoryId").val(selected.categoryId);
     	    		$("#categoryName").val(selected.categoryName);
     	    		$('#w').window('close');
     	    		$("#categoryName").removeClass('validatebox-invalid');
     	    		//取得商品分类的加工方式
     	    		getGoodsMethod(selected.categoryId);
         		} else {
         			$.messager.alert('错误','只有末级分类下才可以添加商品!','error');  
         		}
            }
     	}
     });
     //取得所有在用的计量单位
     $.ajax({
        type: 'get',
        url: '/admin/unit/getAllUnitByStatus',
        async: false,
        dataType: 'json',
        success: function (data) {
     	  for(var i=0;i<data.unitList.length;i++){
     		  unitOption += '<option value="'+data.unitList[i].unitId+'">'+data.unitList[i].unitName+'</option>';
     	  }
        }
     });
     loadData();
});
var editor;
KindEditor.ready(function(K) {
	   editor = K.editor({
			uploadJson : '<%=request.getContextPath()%>/admin/upload',
			allowFileManager : true,
			imageUploadLimit: productPicCount-uploadCount
		});
		K('#J_selectImage').click(function() {
			if(productPicCount-uploadCount==0){
				$.messager.alert('错误','您最多只能上传5张图片！','error');  
				return;
			}
			editor.loadPlugin('multiimage', function() {
				editor.plugin.multiImageDialog({
					clickFn : function(urlList) {
						K.each(urlList, function(i, data) {
							 var _rowHtml = '<div id="picItem_0" class="unit border"><input type="hidden" name="pictureList['+_sort+'].picUrl" value="'+data.url.replace("~/", "")+'" />\
                                                <img id="uploadUrl" src="'+data.url.replace("~/", "")+'" onclick="imgShow($(this))"/>\
                                                <div class="line txtL">\
                                                    <span>排序</span><input id="sortText" name="pictureList['+_sort+'].picSeq" type="text" class="ui-text" style="width:20px;" value="'+_sort+'" title="'+_sort+'" onblur="setSort(this,'+_sort+');" />\
                                                    <br/>\
                                                    <a class="ui-icon14" href="javascript:void(0);" onclick="removeItem('+_sort+');" title="删除">删除<i class="icon14 icon14-delete"></i></a>\
                                                </div>\
                                            </div>';
                            
                            picList.append(_rowHtml);
                            _sort++;
						});
						uploadCount = uploadCount+urlList.length;
						editor.imageUploadLimit = productPicCount-uploadCount;
						updateUploadtxt();
						editor.hideDialog();
					}
				});
			});
		});
});
var ajaxUpdateing = false;//判断是否正在进行异步更新
function updateItem(obj, divId) {
    if (!ajaxUpdateing) {
        var currentDiv = null;
        var _sortObj = $(obj);
        if (divId != undefined) {
            if (_sortObj.val() != "" && _sortObj.attr("title") != _sortObj.val()) {
                currentDiv = $("#picItem_" + divId);
                ajaxUpdateing = true;
            }
        }
        if (currentDiv != null) {
                var _serverId = currentDiv.attr("tabindex");
                //异步提交开始
                $.ajax({
                    type: "POST",
                    url: "<%=basePath%>/admin/goods/updatePictureSeq?picId="+_serverId+"&picSeq="+_sortObj.val(),
                    dataType: 'json',
                    complete:function(){
                        ajaxUpdateing = false;
                    },
                    success: function (result) {
                        if (result.object==1) {
                            setSort(_sortObj, currentDiv);
                        }else {
                            $.messager.alert('错误','更新失败！','error');  
                        }
                    },
                    error: function (status) {
                    	$.messager.alert('错误','更新失败！','error');  
                    }
                });
            
        }
    }
}

function getSort(){
    return picList.find("div.unit").length +1;
}
function setSort(obj, divId) {
    var currentDiv = null;
    if (divId != undefined) {
        var _sortObj = $(obj);
        if (_sortObj.val() != "" && _sortObj.attr("title") != _sortObj.val()) {
            _sortObj.attr("title", _sortObj.val());
            currentDiv = $("#picItem_" + divId);
        }
    }
    if (currentDiv != null) {
        //将当前这个设置为半透明
        currentDiv.find("img").animate({ opacity: 0.3 });
        //排序主代码
        var picItem = picList.find("div.unit:visible").toArray().sort(function (a, b) {
            return parseInt($(a).find("#sortText").val()) - parseInt($(b).find("#sortText").val())
        });
        $(picItem).appendTo(picList);
        //将当前这个设置为不透明
        currentDiv.find("img").animate({ opacity: 1 });            
    }
}

//移出Item,不删除数据
function removeItem(divId) {
    if (divId != undefined) {
        $.messager.confirm('确认','是否确认删除?删除后无法恢复！',function(r){
            if (r){
                var currentDiv = $("#picItem_" + divId);
                if (currentDiv != null) {
                    var picId = currentDiv.attr("tabindex");
                	if(undefined==picId){
                		currentDiv.remove();
                        uploadCount--;
                        editor.imageUploadLimit = productPicCount-uploadCount;
                        updateUploadtxt();
                        return;
                	}
                    var picUrl = currentDiv.attr("taburl");
                    //异步提交开始
                    $.ajax({
                        type: "POST",
                        url: "<%=basePath%>/admin/goods/deleteGoodsPicture?picId="+picId+"&picUrl="+picUrl,
                        dataType: 'json',
                        cache:false,
                        complete:function(){
                            ajaxUpdateing = false;
                        },
                        success: function (result) {
                            if (result.object > 0) {
                            	currentDiv.remove();
                                uploadCount--;
                                editor.imageUploadLimit = productPicCount-uploadCount;
                                updateUploadtxt();
                            }else {
                                $.messager.alert('错误','删除失败！','error');  
                            }
                        },
                        error: function (status) {
                        	$.messager.alert('错误','删除失败！','error');  
                        }
                    });
                
              } else {
                  currentDiv.remove();
                  uploadCount--;
                  editor.imageUploadLimit = productPicCount-uploadCount;
                  updateUploadtxt();
              }
            }
        });
    }else{
        $.messager.alert('错误','数据有误，无法删除，请联系管理员！','error');  
    }
}

function updateUploadtxt(){  
    //剩余数量
    var _difLength= productPicCount-uploadCount;
    $('#ProductPicCount').html("还可以上传<font color=red>" + _difLength + "</font>张图片");
}
//取得商品分类的加工方式
function getGoodsMethod(categoryId){
	$.ajax({
	   type: 'get',
	   url: '/admin/processmethod/getMethodByCategoryId?categoryId='+categoryId,   	   
	   dataType: 'json',
	   success: function (data) {
		  var goodsMethodHtml = '';
		  for(var i=0;i<data.object.length;i++){
			  goodsMethodHtml += '<label><input name="methodList" id="method_'+data.object[i].methodId+'" value="'+data.object[i].methodId+'" type="checkbox">'+data.object[i].methodName+'</label>';
		  }
		  if(goodsMethodHtml != ''){
			  $('#goodsMethod').html(goodsMethodHtml);
			  $('#methodShow').show();
			  //修改商品的时候才会调用
			  <c:forEach items="${goods.methodList}" var="method" varStatus="status"> 
			     $('#method_${method.methodId}').prop("checked",true);
			  </c:forEach>
		  }
	   }
	});
}
//添加行
function append(){
  var unitList = '<select name="formatList['+index+'].unitId">'+unitOption+'</select>';
  $("#dg").datagrid("insertRow", {
	  index: index,
	  row: {
		  format_id:'0',
		  format_name:'<input type="text" name="formatList['+index+'].formatName" />',
		  format_price:'<input type="text" name="formatList['+index+'].formatPrice"/>',
		  format_num:'<input type="text" id="formatNum_'+index+'" name="formatList['+index+'].formatNum" value="1"/>',
		  format_seq:'<input type="text" name="formatList['+index+'].formatSeq" value="'+index+'"/>',
		  format_unit:unitList,
		  format_status:'<select name="formatList['+index+'].formatStatus"><option value="1">上架</option><option value="-1">下架</option><option value="-2">不显示</option></select>'
	  }
  });
  index++;
}
//删除行
function removeit(){
  var row = $('#dg').datagrid('getSelected');
  if(!row){
	  $.messager.alert('错误','请选择您要删除的规格！','error');  
	  return;
  }
  var index = $('#dg').datagrid('getRowIndex', row);
  if(row.format_id == 0){
	 //直接删除
	 $('#dg').datagrid('deleteRow', index); 
	 index--;
  }else{
	 //数据库
  	 $.messager.confirm("提示", "确定要删除该规格么?", function (r) {
          if (r) {
              $.ajax({
                  type: "POST",
                  url: "/admin/goods/deleteGoodsFormat?formatId="+row.format_id,
                  datatype: "json",   
                  success: function (data) {
                      if (data.code == 200) {
                          $.messager.alert("提示", data.message);
                      	  if(data.object == 0){
                      	     $('#dg').datagrid('deleteRow', index);
                      	     index--;
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
}
//保存、修改数据
function saveOrUp(){
  var categoryId = $('#categoryId').val();
  if(categoryId == null || categoryId == ''){
	  $.messager.alert('错误','请选择商品分类！','error'); 
	  return;
  } 
  var a = 0,b=0,c=0;
  var patrn = /^\d+(\.\d+)?$/;
  $("input[id^='formatNum_']").each(function(){
	   a++;
	   var num = $(this).val();
	   if(null==num || ""==num){
		   b = a;
		   return false;
	   }
	   if(!patrn.exec(num)){
		   c = a;
		   return false;
	   }
  })
  if(b!=0){
	  $.messager.alert('错误','第'+a+'行规格数量为空！','error'); 
	  return;
  }
  if(c!=0){
	  $.messager.alert('错误','第'+a+'行规格数量格式不对！','error'); 
	  return;
  }
  $('#subForm').submit();
}
function imgShow(_this){
	var src = _this.attr("src");
	$("#bigimg").attr("src", src);
	$("<img/>").attr("src", src).load(function(){
		var windowW = $(window).width();
		var windowH = $(window).height();
		var realWidth = this.width;
		var realHeight = this.height;
		var imgWidth, imgHeight;
		var scale = 0.8;
		
		if(realHeight>windowH*scale) {
			imgHeight = windowH*scale;
			imgWidth = imgHeight/realHeight*realWidth;
			if(imgWidth>windowW*scale) {
				imgWidth = windowW*scale;
			}
		} else if(realWidth>windowW*scale) {
			imgWidth = windowW*scale;
			imgHeight = imgWidth/realWidth*realHeight;
		} else {
			imgWidth = realWidth;
			imgHeight = realHeight;
		}
		$("#bigimg").css("width",imgWidth);
		
		var w = (windowW-imgWidth)/2;
		var h = (windowH-imgHeight)/2;
		$("#innerdiv").css({"top":h, "left":w});
		$("#outerdiv").fadeIn("fast");
	});
	$("#outerdiv").click(function(){
		$(this).fadeOut("fast");
	});
}
function loadData(){
//修改数据时初始化数据
<c:if test="${goods != null}">
  //加工方式
  getGoodsMethod(${goods.category.categoryId});
  //商品图片
  var picdiv = '';
  <c:forEach items="${goods.pictureList}" var="pic" varStatus="status"> 
    picdiv+='<div id="picItem_${status.index}" class="unit border" tabindex="${pic.picId}" taburl="${pic.picUrl}" >';
  	picdiv +='<img id="uploadUrl" src="${pic.picUrl}" onclick="imgShow($(this))"/>';
  	   picdiv +='<div id="SortAndRemovePanel" runat="server" class="line txtL">';
  	       picdiv +='<input type="hidden" name="pictureList[${status.index}].picUrl" value="${pic.picUrl}"/>';
  	       picdiv +='<span>排序</span><input id="sortText" name="pictureList[${status.index}].picSeq" type="text" class="ui-text" style="width:20px;" onblur="updateItem(this,${status.index})" value="${pic.picSeq}" title="${pic.picSeq}"/>';
  	       picdiv +='<br/>';
  	       picdiv +=' <a class="ui-icon14" href="javascript:void(0);" onclick="removeItem(${status.index})" title="删除">删除<i class="icon14 icon14-delete"></i></a>';
  	   picdiv +='</div>';
  	picdiv +='</div>';    
  </c:forEach>
  $('#picList').html(picdiv);
  //商品规格
  var unitList;
  <c:forEach items="${goods.formatList}" var="format" varStatus="status"> 
      unitList = '<select name="formatList[${status.index}].unitId" id="unit_${status.index}">'+unitOption+'</select>';
	  $("#dg").datagrid("insertRow", {
		  index: ${status.index},
		  row: {
			  format_id:'${format.formatId}',
			  format_name:'<input type="hidden" name="formatList[${status.index}].formatId" value="${format.formatId}"/><input type="text" name="formatList[${status.index}].formatName" value="${format.formatName}"/>',
			  format_price:'<input type="hidden" name="formatList[${status.index}].oldPrice" value="${format.formatPrice}"/><input type="text" name="formatList[${status.index}].formatPrice" value="${format.formatPrice}"/>',
			  format_num:'<input type="text" id="formatNum_${status.index}" name="formatList[${status.index}].formatNum" value="${format.formatNum}"/>',
			  format_seq:'<input type="text" name="formatList[${status.index}].formatSeq" value="${format.formatSeq}"/>',
			  format_unit:unitList,
			  format_status:'<select name="formatList[${status.index}].formatStatus" id="status_${status.index}"><option value="1">上架</option><option value="-1">下架</option><option value="-2">不显示</option></select>'
		  }
	  });
	  $('#unit_${status.index}').val(${format.unitId});
	  $('#status_${status.index}').val(${format.formatStatus});
  </c:forEach>
</c:if>
}
</script>
</body>
</html>