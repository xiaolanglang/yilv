<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/tags.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>用户登录</title>
	<%@include file="/WEB-INF/views/include/header.jsp"%>
	<link rel="stylesheet" type="text/css" href="<%=mJs%>common/jBox/jBox.css">
	<link rel="stylesheet" type="text/css" href="<%=mCss %>mine/login.css">
</head>
<body>
	<div class="contain width">
		<div id="top" class="select width">
			<div class="width zhanghao selected col-5">帐号登录</div>
			<div class="col-5 dongtai" id="dongtai">动态密码登录</div>
		</div>
		<div class="form">
			<form id="form1" action="<%=basePath %>login" method="post">
				<input type="hidden" name="rememberMe" value="true">
				<div class="form-bk">
					<div class="form-group row">
						<input type="text" class="form-control input-border-none" placeholder="手机号" name="username">
						<span class="glyphicon glyphicon-user icon"></span>
					</div>
					<div class="line-top width"></div>
					<div class="form-group row">
						<input type="password" class="form-control input-border-none" placeholder="密码" name="password">
						<span class="icon-lock icon"></span>
					</div>
				</div>
				<div class="form-group row">
					<a href="##" class="find">找回密码</a>
				</div>
				<div class="form-group row">
					<input id="submit" type="submit" class="form-control input-border-none" value="登录">
				</div>
				<div class="form-group row">
					<input id="add" type="button" class="form-control input-border-none add" value="注册新用户">
				</div>
			</form>
			<form id="form2" action="<%=basePath %>register" method="post" style="display: none">
				<div class="form-bk">
					<div class="form-group row">
						<input id="username" type="text" class="form-control input-border-none" placeholder="请输入用户名,登录时使用" name="username">
						<span class="glyphicon glyphicon-user icon"></span>
					</div>
					<div class="line-top width"></div>
					<div class="form-group row">
						<input id="password" type="password" class="form-control input-border-none" placeholder="请输入密码" name="password">
						<span class="glyphicon glyphicon-lock icon"></span>
					</div>
					<div class="line-top width"></div>
					<div class="form-group row">
						<input id="confirmpassword" type="password" class="form-control input-border-none" placeholder="请确认密码">
						<span class="glyphicon glyphicon-lock icon"></span>
					</div>
					<div class="line-top width"></div>
					<div class="form-group row">
						<input id="phone" type="text" class="form-control input-border-none" placeholder="请输入手机号" name="phone">
						<span class="glyphicon glyphicon-phone icon"></span>
					</div>
					<div class="line-top width"></div>
					<div class="form-group row">
						<input id="nickname" type="text" class="form-control input-border-none" placeholder="昵称" name="nickname">
						<span class="glyphicon glyphicon-heart icon"></span>
					</div>
					<div class="line-top width"></div>
				</div>
				<div class="form-group row" style="margin-top: 60px;">
					<input id="register" type="submit" class="form-control input-border-none add" value="注册并登录">
					<input id="back" type="button" class="form-control input-border-none add" value="返回">
				</div>
			</form>
		</div>
	</div>
</body>
	<%@include file="/WEB-INF/views/include/js.jsp"%>
	<script type="text/javascript" src="<%=mJs%>common/jBox/jBox.min.js"></script>
	<script type="text/javascript" src="<%=mJs%>common/jquery.form.min.js"></script>
	<script type="text/javascript" src="<%=mJs%>modules/mine/login/login.js"></script>
</html>