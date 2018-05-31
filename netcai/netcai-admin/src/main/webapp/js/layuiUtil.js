/**
 * 弹出方法(调用此方法前前必须先引入layui.js和layui.css)
 * title 标题
 * width 宽
 * height 高
 * content 内容
 * author:chenlei
 */
function popup(title,width,height,content){
	layui.use('layer', function(){
		var layer = layui.layer; //独立版的layer无需执行这一句  
		layer.open({
			  type: 1,
			  title: title, //标题
			  area: [width, height], //宽高
			  content: content  //内容
		 });
	});
}
