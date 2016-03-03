<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/commons/attendence/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN">
<head>

<title>注册</title>
<%@ include file="/WEB-INF/commons/attendence/commonlib.jsp"%>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="${ctx}/static/css/activity/main.css" media="screen"
	rel="stylesheet">
<link href="${ctx}/static/css/activity/autumn.css" media="screen"
	rel="stylesheet">
<link href="${ctx}/static/css/activity/activity.css" media="screen"
	rel="stylesheet">

</head>

<body>
	<%@ include file="/WEB-INF/commons/attendence/header.jsp"%>
	<div class="container container-normal">
		<div class="es-section login-section">
			<!-- <div style="margin: auto;font-size: 20px;">
				注册
			</div> -->
			<div class="register-main">
				<form action="${ctx}/user/register" method="post" id="register-form"
					name="register-form" enctype="multipart/form-data">
					<div>
						<div class="form-group">
							<label for="inputAccount">学号/工号</label> <input type="text"
								class="form-control" id="inputAccount" name="userAccount"
								placeholder="学号/工号" check-type="required number">
						</div>
						<div class="form-group">
							<label for="inputAccount">姓名</label> <input type="text"
								class="form-control" id="inputUserName" name="userName"
								placeholder="姓名" check-type="required">
						</div>
						<div class="form-group">
							<label for="password">密码(至少6位)</label> <input type="password"
								class="form-control" id="password" name="password"
								placeholder="密码" check-type="required" minlength="6">
						</div>
						<div id="confirmPasswordDiv" class="form-group">
							<label for="passwordAgain">确认密码</label> <input type="password"
								class="form-control" id="passwordAgain"
								onchange="javascript:confirmPassword();"
								name="name_passwordAgain" placeholder="确认密码">
						</div>
						<div class="form-group">
							<label for="inputEmail1">邮箱地址</label> <input type="email"
								class="form-control" id="inputEmail1" name="email"
								placeholder="邮箱" check-type="required mail">
						</div>
						<button type="submit" id="submit"
							class="btn btn-primary btn-lg btn-block"
							style="background: #2CCCBF">注册</button>

					</div>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			//1. 简单写法：
			$("#register-form").validation();
			$("#submit")
					.on(
							'click',
							function(event) {
								// 2.最后要调用 valid()方法。
								//  valide(object,msg),提示信息显示，object位置后面增加提示信息。如不填object 则自动找最后一个button submit.
								//  valide(msg)
								if ($("#register-form").valid(this,
										'填写信息不完整或有误') == false) {
									return false;
								}
								if (document.getElementById('password').value != document
										.getElementById('passwordAgain').value) {
									$("#confirmPasswordDiv").removeClass(
											'has-success');
									$("#confirmPasswordDiv").addClass(
											'has-error');
									return false;
								} else {
								}
							});
		});
		function confirmPassword() {
			if (document.getElementById('password').value != document
					.getElementById('passwordAgain').value) {
				$("#confirmPasswordDiv").removeClass('has-success');
				$("#confirmPasswordDiv").addClass('has-error');
			} else {
				$("#confirmPasswordDiv").removeClass('has-error');
				$("#confirmPasswordDiv").addClass('has-success');
			}
		}
	</script>
</body>
</html>
