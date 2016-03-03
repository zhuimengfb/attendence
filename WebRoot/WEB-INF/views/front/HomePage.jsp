<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/commons/attendence/taglibs.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN">
<head>

<title>活动首页</title>
<%@ include file="/WEB-INF/commons/attendence/commonlib.jsp"%>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="${ctx}/static/css/activity/autumn.css" media="screen"
	rel="stylesheet">
<link href="${ctx}/static/css/activity/activity.css" media="screen"
	rel="stylesheet">
<link href="${ctx}/static/swiper/css/swiper.min.css" rel="stylesheet">
<link href="${ctx}/static/css/front/front.css" rel="stylesheet">
</head>


<body>
	<script type="text/javascript"
		src="${ctx}/static/swiper/js/swiper.min.js"></script>
	<input type="hidden" id="session_is_login"
		value="${sessionScope.SESSION_IS_LOGIN}" />
	<input type="hidden" id="session_user_id"
		value="${sessionScope.SESSION_USER_INFO.id}">
	<%@ include file="/WEB-INF/commons/attendence/header.jsp"%>
	
	<div class="container container-normal container-front">
		<div class="banner">
		<div class="swiper-container">
			<div class="swiper-wrapper">
				<div class="swiper-slide">
					<img class="swiper-slide-img" alt="" src="${ctx}/static/img/front-banner/1.jpg">
				</div>
				<div class="swiper-slide">
					<img class="swiper-slide-img" alt="" src="${ctx}/static/img/front-banner/2.jpg">
				</div>
				<div class="swiper-slide">
					<img class="swiper-slide-img" alt="" src="${ctx}/static/img/front-banner/3.jpg">
				</div>
			</div>
			<!-- 如果需要分页器 -->
			<div class="swiper-pagination"></div>

			<!-- 如果需要导航按钮 -->
			<div class="swiper-button-prev"></div>
			<div class="swiper-button-next"></div>
		</div>
	</div>
		<div class="row"></div>
	</div>
	<script type="text/javascript">
		var mySwiper = new Swiper('.swiper-container', {
			direction : 'horizontal',
			loop : true,
			effect : 'fade',
			autoplay:3000,
			// 如果需要分页器
			pagination : '.swiper-pagination',

			// 如果需要前进后退按钮
			nextButton : '.swiper-button-next',
			prevButton : '.swiper-button-prev',

		});
	</script>
</body>
</html>
