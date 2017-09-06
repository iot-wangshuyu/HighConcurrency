<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
<!-- 静态包含，两个页面合并成一个，一个servlet -->
<%@include file="common/head.jsp"%>
<title>秒杀列表页</title>

</head>
<body>
	<!-- 页面显示部分 -->
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading text-center">
				<h2>秒杀列表</h2>
				<div class="panel-body">
					<table class="table table-hover">
						<thead>
							<tr>
								<td>名称</td>
								<td>库存</td>
								<td>开始时间</td>
								<td>结束时间</td>
								<td>详情</td>
							</tr>

						</thead>
						<tbody>
							<c:foreach var="sk" items="${list}">
								<tr>
									<td>${sk.name}</td>
									<td>${sk.number}</td>
									<td><fmt:formatDate value="${sk.startTime}"
											pattern="yyyy-MM-dd HH:mm:ss" /></td>
									<td><fmt:formatDate value="${sk.endTime}"
											pattern="yyyy-MM-dd HH:mm:ss" /></td>
									<td><a class="btn btn-info"
										href="/seckill/${seckillId}/detail" target="_blank">link</a></td>
							</c:foreach>
						</tbody>
					</table>
				</div>
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