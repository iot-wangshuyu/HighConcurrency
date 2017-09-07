<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
<!-- 静态包含，两个页面合并成一个，一个servlet -->
<%@include file="common/head.jsp"%>
<title>秒杀详情页</title>

</head>
<body>
	<!-- 页面显示部分 -->
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading text-center">
				<div class="panel-heading">
					<h2>${sk.name}</h2>
				</div>
				<div class="panel-body">
				<h2 class="text-danger">
			    <!-- 显示time图标 -->
			    <span class="glyphicon gluphicon-time"></span>
			     <!-- 显示倒计时-->
			     <span class="glyphicon" id="seckill-box"></span>
				</h2>
				
				</div>
			</div>

		</div>
	</div>
	
	<!-- 登录弹出框，输入电话号码 -->
	<div id="killPhoneModal" class="modal fade">
	  <div class="modal-dialog">
	     <div class="modal-content">
	        <div class="modal-header">
	           <h3 class="modal-title text-center">
	              <span class="glyphicon glyphicon-phone"></span>
	           </h3>
	        
	        </div> 
	        
	        <div class="modal-body">
	           <div class="row">
	               <div  class="col-xs-8 col-xs-offset-2">
	                   <input type="text" name="killPhone" id="killPhone" placeholder="填写手机号"/>
	               
	               </div>
	           </div>
	        
	        </div>
	        
	        <div class="modal-footer">
	        <!-- 验证信息 -->
	        <span id="killPhoneMessage" class="glyphicon"></span>
	        <button type="button" id="killPhoneBtn" class="btn">
	           <span class="glyphicon glyphicon-phone"></span>
	           Submit
	        
	        </button>
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