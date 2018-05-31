<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
     <meta name="decorator" content="default"/>
    <title>车辆运行轨迹</title>
   	<style type="text/css">    
	    body, html,#allmap {width: 100%;height: 100%;overflow: hidden;margin:0;font-family:"微软雅黑";}
	</style>    
    <script src="http://api.map.baidu.com/getscript?v=2.0&ak=f3cfdbzHmFDItnR61tAxlWmSc50RVWAK&services=&t=20170926125934" type="text/javascript"></script>
</head>
<body>    
 <div id="allmap"></div>
<script type="text/javascript">
	var coords = []; //定义坐标数组
	var size = ${fn:length(coordinates)}; //当天坐标数组的长度
	if(size == '0'){
		alert("当天改配送师傅没有运行记录!");
		location.href='/admin/delivery/list';
	}
	var index = 0; //当前坐标数组变量
	<c:forEach items="${coordinates}" var="cd" varStatus="status">  
	    var coord = {lng: '',lat: ''}; //定义坐标对象
		coord.lng = '${cd.lng}';
		coord.lat = '${cd.lat}';
		coords.push(coord); //将坐标对象放入数组中
	</c:forEach>
	var startLong = coords[0].lng; //初始开始坐标
	var startLat = coords[0].lat;
	var endLong;
	var endLat;

	var linesPoints = null;
	// 百度地图API功能
	var map = new BMap.Map("allmap");    // 创建Map实例
	map.centerAndZoom(new BMap.Point(startLong,startLat), 17);  // 初始化地图,设置中心点坐标和地图级别
	map.addControl(new BMap.MapTypeControl());   //添加地图类型控件
	map.setCurrentCity("武汉");          // 设置地图显示的城市 此项是必须设置的
	map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
    setInterval(goWay,500);   //坐标轨迹定时器
    var carMk;
    var myIcon = new BMap.Icon("http://sandbox.runjs.cn/uploads/rs/101/wmbvrxnx/kache.png", new BMap.Size(37,25), {imageOffset: new BMap.Size(0, 0)});//卡车
   

   function goWay(){
       //判断最后一个坐标完了就不执行了
	   if(index >= size-1){
		   return;
	   }
	   //开始坐标
	   startLong = coords[index].lng;
	   startLat = coords[index].lat;
	   //结束坐标
	   endLong = coords[index+1].lng;
	   endLat = coords[index+1].lat;
	   drawIcon(startLong,startLat,endLong,endLat);
	   index++;
   }

   function drawRedLine(startLong,startLat,endLong,endLat){
	   var polyline = new BMap.Polyline([
		                                  new BMap.Point(startLong,startLat),//起始点的经纬度
		                                  new BMap.Point(endLong,endLat)//终止点的经纬度
		                                  ], {strokeColor:"red",//设置颜色 
		                                  strokeWeight:3, //宽度
		                                  strokeOpacity:1});//透明度
	   map.addOverlay(polyline);
   }
   
   function drawIcon(startLong,startLat,endLong,endLat){
	   if(carMk){
		   map.removeOverlay(carMk);
	   }
	   carMk = new BMap.Marker(
	               new BMap.Point(endLong,endLat),//起始点的经纬度
	              {icon:myIcon});
	   map.addOverlay(carMk);
	   drawRedLine(startLong,startLat,endLong,endLat);
   }
</script>	   
</body>
</html>

