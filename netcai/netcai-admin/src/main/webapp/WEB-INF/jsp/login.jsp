<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>武汉网菜网业务支撑运营平台</title>
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="/libs/font-awesome.min.css">
  <link rel="stylesheet" href="/libs/ionicons.min.css">
  <link rel="stylesheet" href="/dist/css/AdminLTE.min.css">
  <link rel="stylesheet" href="/plugins/iCheck/square/blue.css">
  <link rel="stylesheet" href="/layer/skin/default/layer.css">
  <style>
   .foot-wrap{
		background-color: #B9C1CE;
		margin-top:80px;
	}
  </style>
  <script src="/plugins/jQuery/jquery-2.2.3.min.js"></script>
  <script src="/bootstrap/js/bootstrap.min.js"></script>
  <script src="/js/jquery.validate.min.js"></script>
  <script src="/js/jquery.form.js"></script>
  <script src="/js/jquery.formPlugin.js"></script>
  <script src="/layer/layer.js"></script>
  <!--[if lt IE 9]>
  <script src="/js/html5shiv.min.js"></script>
  <script src="/js/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition login-page">
<div class="login-box">
  <div class="login-logo">
    <span style="font-size:20px;">网菜网业务运营平台</span>
  </div>
  <div class="login-box-body">
    <p class="login-box-msg">登陆系统</p>
    <form id="loginForm" action="/admin/checkLogin" method="post" autocomplete="off">
      <div class="form-group has-feedback">
        <input type="text" name="username" id="username" class="form-control" placeholder="账号" maxlength="16">
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" name="password" id="password" class="form-control" placeholder="密码" maxlength="16">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="row">
        <div class="col-xs-8">
        </div>
        <div class="col-xs-4">
          <button type="submit" class="btn btn-primary btn-block btn-flat">登陆</button>
        </div>
      </div>
    </form>
  </div>
</div>
<footer class="container-fluid foot-wrap">
        <p align="center" style="margin-top: 20px;color:#878B91;">
                                武汉网菜网科技有限公司 Copyright © 2016 - 2017 All Rights Reserved.
        </p>
</footer>
</body>
</html>