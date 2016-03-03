<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true"%>
<%@ include file="/WEB-INF/commons/attendence/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<nav class="navbar navbar-default navbar-fixed-top site-navbar" style="background:#2CCCBF">
<div class="container-fluid">
	<input type="hidden" value="${sessionScope.SESSION_USER_INFO.id}" id="userId">
	<div class="row">
		<div class="col-xs-12">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only"></span>  <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" style="margin-left: 30px;" href="${ctx}/front" style=""><img alt=""
					src="${ctx}/static/img/common/pencil.png"></a>
				<ul class="nav navbar-nav navbar-left">
					<li id="activity">
						<a href="${ctx}/activity/list">
							<span style="color:#ffffff;font-size:16px; ">最新活动</span>
						</a>
					</li>
					<li id="course">
						<a href="${ctx}/course/list">
							<span style="color:#fff;font-size:16px; ">最新课堂</span>
						</a>
					</li>
					<li id="news">
						<a href="${ctx}/news/list">
							<span style="color:#fff;font-size:16px; ">最新资讯</span>
						</a>
					</li>
				</ul>
			</div>
			<c:if test="${sessionScope.SESSION_IS_LOGIN!='LOGIN_OK'}">
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right" style="margin-right:30px;">
					<li id="login">
						<a href="${ctx}/user/login">
							<span style="color:#fff;font-size:16px; ">登录</span>
						</a>
					</li>
					<li id="register">
						<a href="${ctx}/user/register">
							<span style="color:#fff;font-size:16px;">注册</span>
						</a>
					</li>
				</ul>
			</div>
			</c:if>
			<c:if test="${sessionScope.SESSION_IS_LOGIN=='LOGIN_OK'}">
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right" style="margin-right:30px;">
					<li id="userCenter">
						<a href="#">
							<span style="color:#fff;font-size:16px;;margin-right:30px; ">${sessionScope.SESSION_USER_INFO.userName}</span>
						</a>
					</li>
				</ul>
			</div>
			</c:if>
		</div>
	</div>
</div>
</nav>
