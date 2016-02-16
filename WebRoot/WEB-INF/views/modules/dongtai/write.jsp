<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/tags.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>Love Travel</title>
	<%@include file="/WEB-INF/views/include/header.jsp"%>
	<link rel="stylesheet" type="text/css" href="<%=mCss%>dongtai/write.css">
	<link rel="stylesheet" type="text/css" href="<%=mCss%>/index/index.css">
	<link rel="stylesheet" type="text/css" href="<%=mJs%>common/jBox/jBox.css">
</head>
<body>
	<div class="title row line-bottom">
		<div class="col-2 text-center">
			<a id="cancle" class="text">取消</a>
		</div>
		<div class="col-6 text-center">
			<span class="text title-text">发动态</span>
		</div>
		<div class="col-2 text-center">
			<a class="btn btn-default text" id="send">发送</a>
		</div>
	</div>
	<div class="row">
		<textarea class="row textarea" placeholder="秀秀新动态" id="content"></textarea>
	</div>
	<ul class="figure-list">
	</ul>
	<ul class="nav nav-li" style="display: none;" id="modal-content">
		<li class="line-bottom"><a class="select-range" range="0"><span class="icon-earth icon"></span>公开</a></li>
		<li class="line-bottom"><a class="select-range" range="1"><span class="icon-heart icon"></span>仅好友</a></li>
		<li class="line-bottom"><a class="select-range" range="2"><span class="icon-lock icon"></span>仅自己</a></li>
	</ul>
	<a class="btn btn-default" id="range" range="0"><span class="icon-earth icon"></span>公开</a>
</body>
<%@include file="/WEB-INF/views/include/js.jsp"%>
<script type="text/javascript" src="<%=mJs%>common/jBox/jBox.min.js"></script>
<script type="text/javascript" src="<%=mJs%>modules/dongtai/write.js"></script>
</html>