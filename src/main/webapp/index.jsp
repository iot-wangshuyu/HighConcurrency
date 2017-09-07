<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="WEB-INF/jsp/common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
<!-- 静态包含，两个页面合并成一个，一个servlet -->
<%@include file="WEB-INF/jsp/common/head.jsp"%>
<title>秒杀首页</title>

</head>
<body>
	<!-- 页面显示部分 -->
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading text-center">
				<a class="btn btn-info"
					href="<%=basePath%>seckill" target="_blank">进入秒杀列表</a>
			</div>
		</div>

	</div>



</body>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>