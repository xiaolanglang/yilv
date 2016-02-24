<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/tags.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>Love Travel</title>
	<%@include file="/WEB-INF/views/include/header.jsp"%>
	<link rel="stylesheet" type="text/css" href="<%=mCss%>mine/index.css">
</head>
<body>
	<div class="top width img-line">
		<img src="<%=mImg%>mine/bk.png" class="width bk">
		<div class="head">
			<c:choose>
				<c:when test="${user != null }">
					<a href="javascript:void(0)" class="highlight-none">
						<img src="<%=mImg%>mine/human.png" class="img">
					</a>
					<p>您好,${user.nickname}</p>
				</c:when>
				<c:otherwise>
					<a href="<%=basePath %>login" class="highlight-none">
						<img src="<%=mImg%>mine/human.png" class="img">
					</a>
					<p>点击登录，体验更多精彩</p>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<div class="column">
		<ul class="nav">
			<li class="line-bottom">
				<img src="<%=mImg%>mine/order.png">
				<a href="##" class="text-center"><span class="text">我的好友</span></a>
			</li>
			<li class="line-bottom">
				<img src="<%=mImg%>mine/order.png">
				<a href="##" class="text-center"><span class="text">新朋友</span></a>
			</li>
			<li class="line-bottom">
				<img src="<%=mImg%>mine/order.png">
				<a href="##" class="text-center"><span class="text">我的收藏</span></a>
			</li>
			<li class="line-bottom">
				<img src="<%=mImg%>mine/order.png">
				<a href="##" class="text-center"><span class="text">账户安全</span></a>
			</li>
			<li class="line-bottom">
				<img src="<%=mImg%>mine/order.png">
				<a href="##" class="text-center"><span class="text">设置</span></a>
			</li>
		</ul>
	</div>
	<c:if test="${user != null }">
		<div class="loginout width" id="loginout">
			退出登录
		</div>
	</c:if>
</body>
<script type="text/javascript" src="<%=mJs%>common/zepto.js"></script>
<script type="text/javascript" src="<%=mJs%>modules/common/lt.js"></script>
<script type="text/javascript" src="<%=mJs%>modules/mine/index/index.js"></script>
</html>