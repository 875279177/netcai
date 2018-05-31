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
  <meta name="decorator" content="default"/>
  <style type="text/css">
    .inner p{
       font-size:19px;
    }
    .inner h3{
      font-size:24px;
    }
    table th{
      background:#ffffff;
    }
	table tr:nth-child(odd){
	  background:#F0F0F0;
	}
	.col-lg-7 {
      width: 1120px; 
    }
  </style>
</head>
<body>
     <div class="content-wrapper">
     <section class="content-header">
       <h1>每日汇总</h1>
     </section>
     <section class="content">
       <div class="row">
         <div class="col-lg-3 col-xs-6">
           <div class="small-box bg-aqua">
             <div class="inner">
               <p>今日订单：${todayOrderCount } &nbsp;今日营业额：${todayOrderAmount }</p>
               <p>总订单：${totalCount } &nbsp;总营收金额：${totalAmount }</p>
             </div>
             <a href="/admin/index/orderList" class="small-box-footer">查看今日详细<i class="fa fa-arrow-circle-right"></i></a>
             <a href="/admin/orderInfo/list" class="small-box-footer">查看所有详情<i class="fa fa-arrow-circle-right"></i></a>
           </div>
         </div>
         <div class="col-lg-3 col-xs-6">
           <div class="small-box bg-yellow">
             <div class="inner">
               <h3>今日注册买家：${todayBuyercount }</h3>
               <p>注册买家：${totalBuyerCount }</p>
             </div>
             <a href="/admin/index/buyers" class="small-box-footer">查看今日详细<i class="fa fa-arrow-circle-right"></i></a>
             <a href="/admin/buyer/list" class="small-box-footer">查看所有详情<i class="fa fa-arrow-circle-right"></i></a>
           </div>
         </div>
         <div class="col-lg-3 col-xs-6">
           <div class="small-box bg-red">
             <div class="inner">
               <h3>实时营收：${realTimeOrderAmount }</h3>
               <p>实时下单买家：${realTimeOrderCount }</p>
             </div>
             <a href="/admin/index/todayOrders" class="small-box-footer">查看今日详细<i class="fa fa-arrow-circle-right"></i></a>
             <a href="/admin/orderInfo/list" class="small-box-footer">查看所有详情<i class="fa fa-arrow-circle-right"></i></a>
           </div>
         </div>
         <div class="col-lg-3 col-xs-6">
           <div class="small-box bg-purple">
             <div class="inner">
               <h3>今日下单买家：${order_buyerCount }</h3>
               <p>空降A：${newBuyerNum }</p>
             </div>
             <a href="/admin/index/ordersBybuyer" class="small-box-footer">查看今日详细<i class="fa fa-arrow-circle-right"></i></a>
             <a href="/admin/reportDay/list" class="small-box-footer">查看所有详情<i class="fa fa-arrow-circle-right"></i></a>
           </div>
         </div>
       </div>
       <div class="row">
         <section class="col-lg-7 connectedSortable" >
           <div class="nav-tabs-custom">
             <ul id="ul_mychart" class="nav nav-tabs pull-left">
               <li id="amountChart" >
                 <a href="#myChart" data-toggle="tab"><i class="fa fa-fw fa-line-chart"></i>营业额统计</a>
               </li>
               <li id="orderNumChart">
                 <a href="#myChart" data-toggle="tab"><i class="fa fa-fw fa-line-chart"></i>订单统计</a>
               </li>
               <li id="percentageChart">
                 <a href="#myChart" data-toggle="tab"><i class="fa fa-fw fa-line-chart"></i> 抽成金额统计</a>
               </li>
               <li id="buyerChart">
                 <a href="#myChart" data-toggle="tab"><i class="fa fa-fw fa-line-chart"></i> 注册买家统计</a>
               </li>
             </ul>
             <div class="chart tab-pane" style="margin:15px;font-size:16px;color:#00F;">
                 <label for="timeType" >时间类型选择：</label>
                 <input type="radio" id="dayType" name="timeType" value="0" style="margin-left:15px;" checked="checked" /><label for="dayType">按天统计</label>
                 <input type="radio" id="monthType" name="timeType" value="1" style="margin-left:15px;"><label for="monthType">按月统计</label>
             </div>
             <div class="tab-content no-padding">
               <div class="chart tab-pane active" id="myChart" style="position: relative;height:450px;"></div>
             </div>
           </div>
         </section>
         <section class="col-lg-7 connectedSortable">
           <div class="nav-tabs-custom">
             <ul class="nav nav-tabs pull-left">
               <li class="pull-left header"><i class="fa fa-inbox"></i> 最近一周Top10</li>
               <li id="li_buyers" class="active"><a href="#mytable" data-toggle="tab">买家消费</a></li>
               <li id="li_incomes"><a href="#mytable" data-toggle="tab">卖家收入</a></li>
               <li id="li_goods"><a href="#mytable" data-toggle="tab">热卖菜品</a></li>
               <li id="li_sales"><a href="#mytable" data-toggle="tab">销售业绩</a></li>
               <li id="li_widelyBuyers"><a href="#mytable" data-toggle="tab">订单项最多买家</a></li>
             </ul>
             <div class="tab-content no-padding">
               <div class="chart tab-pane active" id="mytable" style="position: relative;height:430px;">
	             <table id="table_topTen_buyers" class="layui-table" lay-skin="row">
	               <thead>
		             <tr>
		               <th>餐馆名称</th>
		               <th>餐馆类型</th>
		               <th>消费金额</th>
		               <th>下单数量</th>
		             </tr>
		           </thead>
	               <tbody id="tbody_topTen_buyers"></tbody>
	             </table>
	             <table id="table_topTen_incomes" class="layui-table" lay-skin="row" style="display:none">
	               <thead>
		             <tr>
		               <th>卖家名称</th>
		               <th>收入金额</th>
		               <th>接单数量</th>
		               <th>评分</th>
		             </tr>
		           </thead>
	               <tbody id="tbody_topTen_incomes"></tbody>
	           </table>
	             <table id="table_topTen_goods" class="layui-table" lay-skin="row" style="display:none">
	               <thead>
		             <tr>
		               <th>商品</th>
		               <th>商品规格</th>
		               <th>销售量</th>
		               <th>销售额</th>
		             </tr>
		           </thead>
	               <tbody id="tbody_topTen_goods"></tbody>
	             </table>
	             <table id="table_topTen_sales" class="layui-table" lay-skin="row" style="display:none">
	               <thead>
		             <tr>
		               <th>姓名</th>
		               <th>手机号</th>
		               <th>入驻卖家</th>
		               <th>入职时间</th>
		             </tr>
		           </thead>
	               <tbody id="tbody_topTen_sales"></tbody>
	             </table>
	             <table id="table_topTen_widelyBuyers" class="layui-table" lay-skin="row" style="display:none">
	               <thead>
		             <tr>
		               <th>餐馆名称</th>
		               <th>餐馆类型</th>
		               <th>订单号</th>
		               <th>商品种类</th>
		             </tr>
		           </thead>
	               <tbody id="tbody_topTen_widelyBuyers"></tbody>
	             </table>
	           </div>
             </div>
           </div>
         </section>
       </div>
     </div>

<script src="/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="/js/jquery-ui.min.js"></script>
<script>
  $.widget.bridge('uibutton', $.ui.button);
</script>
<script src="/bootstrap/js/bootstrap.min.js"></script>
<script src="/js/raphael-min.js"></script>
<script src="/plugins/sparkline/jquery.sparkline.min.js"></script>
<script src="/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script src="/js/moment.min.js"></script>
<script src="/plugins/daterangepicker/daterangepicker.js"></script>
<script src="/plugins/datepicker/bootstrap-datepicker.js"></script>
<script src="/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script src="/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="/plugins/fastclick/fastclick.js"></script>
<script src="/dist/js/app.min.js"></script>
<script src="/dist/js/demo.js"></script>
<script src="/layer/layer.js"></script>
<script src="/echart/www/js/echarts.js"></script>
<script src="/echart/asset/js/codemirror.js"></script>
<script src="/echart/asset/js/javascript.js"></script>
<script type="text/javascript">
$(function(){
	//加载获取消费前十的买家的数据
	getBuyerCost();
	
	var dayArray = [GetDayStr(6),GetDayStr(5),GetDayStr(4),GetDayStr(3),GetDayStr(2),GetDayStr(1),GetDayStr(0)];
	var monthArray = [GetMonthStr(6),GetMonthStr(5),GetMonthStr(4),GetMonthStr(3),GetMonthStr(2),GetMonthStr(1),GetMonthStr(0)];
	// 路径配置
    require.config({
        paths: {
            echarts: 'http://echarts.baidu.com/build/dist'
        }
    });
    // 使用
    require([
              'echarts',
              'echarts/chart/line', // 使用折线图就加载bar模块，按需加载
              'echarts/chart/bar'
            ],
        function (ec) {
            // 基于准备好的dom，初始化echarts图表
            var myChart = ec.init(document.getElementById('myChart'));
            $("#amountChart").addClass("active");
            //页面加载时默认加载订单数量统计图
            var timeType= "";
            var requestUrl = "<%=request.getContextPath()%>/admin/index/getOrderAmount";
           	var text = "营业额";
           	var formatter = "{value} (元)";
           	getStatisticsCharts(timeType,requestUrl,text,formatter);
            
            //统计区域下的营业额
            $("#amountChart").click(function(){
            	$("#amountChart").addClass("active");
            	$("#orderNumChart").removeClass("active");
            	$("#percentageChart").removeClass("active");
            	$("#buyerChart").removeClass("active");
            	$("#sellerChart").removeClass("active");
            	timeType = $("input:radio:checked").val();
            	requestUrl = "<%=request.getContextPath()%>/admin/index/getOrderAmount";
            	text = "营业额";
            	formatter = "{value} (元)";
            	getStatisticsCharts(timeType,requestUrl,text,formatter);
            });
            
            //统计区域下的订单数量
            $("#orderNumChart").click(function(){
            	$("#orderNumChart").addClass("active");
            	$("#amountChart").removeClass("active");
            	$("#percentageChart").removeClass("active");
            	$("#buyerChart").removeClass("active");
            	$("#sellerChart").removeClass("active");
            	timeType = $("input:radio:checked").val();
            	requestUrl = "<%=request.getContextPath()%>/admin/index/getOrderNum";
            	text = "订单数量";
            	formatter = "{value} (单)";
            	getStatisticsCharts(timeType,requestUrl,text,formatter);
            });
            
            //统计区域下平台抽点总金额
            $("#percentageChart").click(function(){
            	$("#percentageChart").addClass("active");
            	$("#amountChart").removeClass("active");
            	$("#orderNumChart").removeClass("active");
            	$("#buyerChart").removeClass("active");
            	$("#sellerChart").removeClass("active");
            	timeType = $("input:radio:checked").val();
            	requestUrl = "<%=request.getContextPath()%>/admin/orderPercentage/getPercentageAmount";
            	text = "抽成金额";
            	formatter = "{value} (元)";
            	getStatisticsCharts(timeType,requestUrl,text,formatter);
            });
            
            //统计区域下的买家数量
            $("#buyerChart").click(function(){
            	$("#buyerChart").addClass("active");
            	$("#amountChart").removeClass("active");
            	$("#orderNumChart").removeClass("active");
            	$("#percentageChart").removeClass("active");
            	$("#sellerChart").removeClass("active");
            	timeType = $("input:radio:checked").val();
            	requestUrl = "<%=request.getContextPath()%>/admin/index/getBuyerCount";
            	text = "买家数量";
            	formatter = "{value} (个)";
            	getStatisticsCharts(timeType,requestUrl,text,formatter);
            });
            
            //单选框选中事件
            $('input[type=radio][name=timeType]').change(function() {
            	timeType = $("input:radio:checked").val();
            	var li_text = $("#ul_mychart li.active").text();
            	if(li_text.indexOf("营业额")!=-1){
            		requestUrl = "<%=request.getContextPath()%>/admin/index/getOrderAmount";
                	text = "营业额";
                	formatter = "{value} (元)";
                	getStatisticsCharts(timeType,requestUrl,text,formatter);
            	}else if(li_text.indexOf("订单")!=-1){
            		requestUrl = "<%=request.getContextPath()%>/admin/index/getOrderNum";
                	text = "订单数量";
                	formatter = "{value} (单)";
                	getStatisticsCharts(timeType,requestUrl,text,formatter);
            	}else if(li_text.indexOf("抽成金额")!=-1){
            		requestUrl = "<%=request.getContextPath()%>/admin/orderPercentage/getPercentageAmount";
                	text = "抽成金额";
                	formatter = "{value} (元)";
                	getStatisticsCharts(timeType,requestUrl,text,formatter);
            	}else if(li_text.indexOf("买家")!=-1){
            		requestUrl = "<%=request.getContextPath()%>/admin/index/getBuyerCount";
                	text = "买家数量";
                	formatter = "{value} (个)";
                	getStatisticsCharts(timeType,requestUrl,text,formatter);
            	}
            });
            
            //表格统计数量
            function getStatisticsCharts(timeType,requestUrl,text,formatter){
            	var timeArray;
            	var title;
            	//请求路径拼接参数
            	requestUrl += "?timeType="+timeType;
            	// 异步加载数据
            	$.get(requestUrl).done(function (data) {
            		if(timeType == 0){
            			timeArray = dayArray;
            			title='最近一周'+ text;
            		}else if(timeType == 1){
            			timeArray = monthArray;
            			title='最近七个月' + text;
            		}
            		var countResult = data.object;
            		var regionNames = [];
            		var series=[];
           		    for(var key in countResult){
           		    	regionNames.push(key);
           		        series.push({
           		            name: key,
           		            type: 'line',
           		            stack: key,
           		            data:countResult[key],
           		            itemStyle : { normal: {label : {show: true}}}
           		        });
           		    }
            	    // 填入数据
            	    myChart.setOption({
            	    	title : {
                 	        text: title
                 	    },
                 	    tooltip : {
                 	        trigger: 'axis'
                 	    },
                 	    legend: {
                 	        data:regionNames
                 	    },
                 	    toolbox: {
                 	        show : true,
                 	        feature : {
                 	            dataView : {show: true, readOnly: false},
                 	            magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
                 	            restore : {show: true},
                 	            saveAsImage : {show: true}
                 	        }
                 	    },
                 	    calculable:true,
                 	    xAxis : [{
                     	            type : 'category',
                     	            boundaryGap : false,
                     	            data : timeArray
                 	            }],
                 	    yAxis : [{
            	           	        type : 'value',
            	           	        splitNumber : "8",
            	           	        axisLabel : {formatter: formatter }//y轴单位
                 	            }],
                 	    series : series
            	    });
            	});
            	
            }
            
        })
})

//买家消费表格切换
$("#li_buyers").click(function(){
	getBuyerCost();
});
//获取消费前十的买家
function getBuyerCost(){
	$("#mytable table").hide();
	//获取数据
	$.ajax({
        type: "GET",
        url: "<%=request.getContextPath()%>/admin/index/getTopTenCost",
        dataType: "json",
        success: function(data){
        	var list = data.object;
        	$("#tbody_topTen_buyers").html("");
        	var tbodyHtml = "";
        	for(var i=0;i<list.length;i++){
        		tbodyHtml +='<tr>'+
        		              '<td>'+list[i].buyerName+'</td>'+
        		              '<td>'+list[i].typeName+'</td>'+
        		              '<td>'+list[i].amount+'</td>'+
        		              '<td>'+list[i].count+'</td>'+
        		            '</tr>';
        	}
		    //添加html
			$("#tbody_topTen_buyers").append(tbodyHtml);
        }
    });
	$("#table_topTen_buyers").show();
}
//卖家收入表格切换
$("#li_incomes").click(function(){
	$("#mytable table").hide();
	//获取数据
	$.ajax({
        type: "GET",
        url: "<%=request.getContextPath()%>/admin/index/topTenIncomes",
        dataType: "json",
        success: function(data){
        	var list = data.object;
        	$("#tbody_topTen_incomes").html("");
        	var tbodyHtml = "";
        	for(var i=0;i<list.length;i++){
        		tbodyHtml +='<tr>'+
        		              '<td>'+list[i].sellerName+'</td>'+
        		              '<td>'+list[i].amount+'</td>'+
        		              '<td>'+list[i].count+'</td>'+
        		              '<td>'+list[i].grade+'</td>'+
        		            '</tr>';
        	}
		    //添加html
			$("#tbody_topTen_incomes").append(tbodyHtml);
        }
    });
	$("#table_topTen_incomes").show();
});
//热卖菜品表格切换
$("#li_goods").click(function(){
	$("#mytable table").hide();
	//获取数据
	$.ajax({
        type: "GET",
        url: "<%=request.getContextPath()%>/admin/index/topTenGoods",
        dataType: "json",
        success: function(data){
        	var list = data.object;
        	$("#tbody_topTen_goods").html("");
        	var tbodyHtml = "";
        	for(var i=0;i<list.length;i++){
        		tbodyHtml +='<tr>'+
        		              '<td>'+list[i].goodsName+'</td>'+
        		              '<td>'+list[i].formatName+'</td>'+
        		              '<td>'+list[i].num+'</td>'+
        		              '<td>'+list[i].amount+'</td>'+
        		            '</tr>';
        	}
		    //添加html
			$("#tbody_topTen_goods").append(tbodyHtml);
        }
    });
	$("#table_topTen_goods").show();
});
//销售业绩表格切换
$("#li_sales").click(function(){
	$("#mytable table").hide();
	//获取数据
	$.ajax({
        type: "GET",
        url: "<%=request.getContextPath()%>/admin/index/topTenSales",
        dataType: "json",
        success: function(data){
        	var list = data.object;
        	$("#tbody_topTen_sales").html("");
        	var tbodyHtml = "";
        	for(var i=0;i<list.length;i++){
        		tbodyHtml +='<tr>'+
        		              '<td>'+list[i].name+'</td>'+
        		              '<td>'+list[i].phone+'</td>'+
        		              '<td>'+list[i].count+'</td>'+
        		              '<td>'+list[i].createTime+'</td>'+
        		            '</tr>';
        	}
		    //添加html
			$("#tbody_topTen_sales").append(tbodyHtml);
        }
    });
	$("#table_topTen_sales").show();
});
//订单项买家表格切换
$("#li_widelyBuyers").click(function(){
	$("#mytable table").hide();
	//获取数据
	$.ajax({
        type: "GET",
        url: "<%=request.getContextPath()%>/admin/index/topTenWidelyBuyers",
        dataType: "json",
        success: function(data){
        	var list = data.object;
        	$("#tbody_topTen_widelyBuyers").html("");
        	var tbodyHtml = "";
        	for(var i=0;i<list.length;i++){
        		tbodyHtml +='<tr>'+
        		              '<td>'+list[i].buyerName+'</td>'+
        		              '<td>'+list[i].typeName+'</td>'+
        		              '<td>'+list[i].orderNum+'</td>'+
        		              '<td>'+list[i].count+'</td>'+
        		            '</tr>';
        	}
		    //添加html
			$("#tbody_topTen_widelyBuyers").append(tbodyHtml);
        }
    });
	$("#table_topTen_widelyBuyers").show();
});
//获取n个月后的时间日期(年月)
function GetMonthStr(n) { 
	var dd = new Date(); 
	var date_str='';
	var y = dd.getFullYear();
	date_str += y;
	var m = dd.getMonth()+1-n;//获取当前月份的日期 
	if(m<10){
		date_str += '-0'+m
	}else{
		date_str += '-'+m
	}
	return date_str; 
} 
//获取n天后的时间日期(年月日)
function GetDayStr(n) { 
	var dd = new Date(); 
	dd.setDate(dd.getDate()-n);//获取n天后的日期 
	var date_str='';
	var y = dd.getFullYear();
	date_str += y;
	var m = dd.getMonth()+1;//获取当前月份的日期 
	if(m<10){
		date_str += '-0'+m
	}else{
		date_str += '-'+m
	}
	var d = dd.getDate();
	if(d<10){
		date_str += '-0'+d
	}else{
		date_str += '-'+d
	}
	return date_str; 
} 

$("#mybatisCache").click(function()
{
	$.ajax({
    	type: "POST",
        url: "<%=request.getContextPath()%>/admin/mybatis/clear",
        asynch:false,
        cache:false,
        success: function(data)
        {
        	var msg=data.message;
        	layer.msg(msg, {icon: 1,time:1500}); 
        },
        error:function()
        {
        	alert("系统错误");
        }
    });
})
</script>
</body>
</html>