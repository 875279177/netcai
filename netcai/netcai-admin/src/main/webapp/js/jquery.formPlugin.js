// 等待DOM加载
function ajaxSubmit(myForm, timeout) {
	if (timeout == null)
		timeout = 3000;
	$(function() {
		// 绑定"#myForm"，然后加入回调函数
		$(myForm).ajaxForm(function(data) {
			if (data.code == "200") {
				layer.msg(data.message, {
					icon : 1,
					time : timeout,
				});
				
				setTimeout(function() {
					var url = data.object.url;
					if (url)
					{
						window.location = url;
						return;
					}
				}, 2000);
				
			} else {
				layer.msg(data.message, {
					icon : 2,
					time : timeout
				});
			}
		});
	});
}