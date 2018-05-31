<%@ page contentType="text/html;charset=UTF-8"%>  
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
    <title>  
        <sitemesh:title default="网菜网后台管理系统"></sitemesh:title>
    </title>  
    <%@include file="/WEB-INF/jsp/decorators/meta.jsp" %>  
    <sitemesh:head/>  
</head>  
<body class="hold-transition skin-blue sidebar-mini">  
	<jsp:include page="/WEB-INF/jsp/decorators/header.jsp" />  
	<div class="wrapper"> 
	    <jsp:include page="/WEB-INF/jsp/decorators/left.jsp" />   
	    <sitemesh:body/>  
	    <jsp:include page="/WEB-INF/jsp/decorators/bottom.jsp" />   
	</div>  
</body>  
</html>  