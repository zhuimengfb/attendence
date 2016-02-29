<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/commons/attendence/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN">
<head>

<title>登录</title>
<%@ include file="/WEB-INF/commons/attendence/commonlib.jsp"%>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="${ctx}/static/css/user/login.css" rel="stylesheet">
<link href="${ctx}/static/css/activity/main.css" media="screen"
	rel="stylesheet">
<link href="${ctx}/static/css/activity/autumn.css" media="screen"
	rel="stylesheet">
</head>

<body>
	<%@ include file="/WEB-INF/commons/attendence/header.jsp"%>
	<div class="container container-normal">
		<div class="es-section login-section">
			<!-- <div style="margin: auto;font-size: 20px;">
				登录
			</div> -->
			<div class="login-main">
				<form action="${ctx}/user/login" method="post" name="login-form" id="login-form"
					enctype="multipart/form-data">
					<div>
						<div class="form-group">
							<label for="inputAccount">学号/工号</label> <input type="text"
								class="form-control" id="inputAccount" name="userAccount"
								placeholder="学号/工号" check-type="required number">
						</div>
						<div class="form-group">
							<label for="password">密码</label> <input type="password"
								class="form-control" id="password" name="password"
								placeholder="密码" check-type="required">
						</div>
						<button type="submit" id="submit" class="btn btn-primary btn-lg btn-block"
							style="background: #2CCCBF">登录</button>
						<div>
							<span style="float:right;margin-top: 15px;">还没有账号？<a
								href="${ctx}/user/register">立即注册</a></span>
						</div>
						<div>
							<span style="float:left;margin-top: 15px;"><a href="#">Jaccount登录</a></span>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	$(function() {
		//1. 简单写法：
		$("#login-form").validation();
		$("#submit").on('click', function(event) {
			// 2.最后要调用 valid()方法。
			//  valide(object,msg),提示信息显示，object位置后面增加提示信息。如不填object 则自动找最后一个button submit.
			//  valide(msg)
			if ($("#login-form").valid(this, '填写信息不完整或有误') == false) {
				return false;
			}
			else{
			}
		});
	});
	</script>
</body>
</html>
