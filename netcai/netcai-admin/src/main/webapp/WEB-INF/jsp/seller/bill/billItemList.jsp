<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>账单详情</title>
<link rel="stylesheet" href="/layui/css/layui.css"  media="all">
<script type="text/javascript" src="/js/jquery-1.9.1.min.js"></script>
<script src="/layui/layui.js" charset="utf-8"></script>
</head>
<body>
  <div class="layui-form" >
    <table class="layui-table" lay-skin="row">
      <thead>
	    <tr>
	      <th>商铺名称</th>
	      <th>收入时间</th>
	      <th>每日收入</th>
	    </tr>
      </thead>
      <tbody>
        <c:forEach items="${requestScope.billItems}" var="r"> 
		  <tr>
		    <td>${r.sellerName}</td>
		    <td><fmt:formatDate value="${r.period }" pattern="yyyy-MM-dd"/></td>
		    <td>${r.money}</td>
		  </tr>
		</c:forEach>
      </tbody>
	</table>
  </div>
</body>
</html>