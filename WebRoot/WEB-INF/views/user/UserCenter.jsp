<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/commons/attendence/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>个人中心</title>
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
<link href="${ctx}/static/css/console/user/userCenter.css"
	media="screen" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="${ctx}/static/timeline/css/history.css">
<script type="text/javascript" src="${ctx}/static/timeline/js/jquery.js"></script>
<script type="text/javascript"
	src="${ctx}/static/timeline/js/jquery.mousewheel.js"></script>
<script type="text/javascript"
	src="${ctx}/static/timeline/js/jquery.easing.js"></script>
<script type="text/javascript"
	src="${ctx}/static/timeline/js/history.js"></script>

</head>

<body>
	<%@ include file="/WEB-INF/commons/attendence/header.jsp"%>
	<div class="container container-fluid container-normal">
		<div class="row">
			<div class="col-md-5">
				<div class="user-card">
					<div class="user-pic">
						<img class="img-circle" alt=""
							src="${ctx}/static/img/user/user_default.jpeg">
					</div>
					<div class="user-profile">
						<div class="name">
							<span>姓名：傅波</span>
						</div>
						<div class="account">
							<span>学号：115034910158</span>
						</div>
						<div class="department">
							<span>部门：电院电子系</span>
						</div>
						<div class="credit">
							<span>学分：20</span>
						</div>
					</div>
				</div>

			</div>
			<div class="col-md-7">

				<div id="history">
					<div id="arrow">
						<ul>
							<li class="arrowup"></li>
							<li class="arrowdown"></li>
						</ul>
					</div>
					<div class="title">
						<h2>我的成长史</h2>
						<div id="circle">
							<div class="cmsk"></div>
							<div class="circlecontent">
								<div thisyear="2016" class="timeblock">
									<span class="numf"></span> <span class="nums"></span> <span
										class="numt"></span> <span class="numfo"></span>
									<div class="clear"></div>
								</div>
								<div class="timeyear">YEAR</div>
							</div>
							<a href="#" class="clock"></a>
						</div>
					</div>
					<div id="content">
						<ul class="list">
							<li>
								<div class="liwrap">
									<div class="lileft">
										<div class="date">
											<span class="year">2016</span> <span class="md">0807</span>
										</div>
									</div>
									<div class="point">
										<b></b>
									</div>
									<div class="liright">
										<div class="histt">
											<a href="#">课程标题</a>
										</div>
										<div class="hisct">
											<span class="glyphicon glyphicon glyphicon-star">&nbsp;2</span>
											<span>&nbsp;&nbsp;</span>
											<span class="glyphicon glyphicon-home">&nbsp;电院</span> <br>
											课程简介
										</div>
									</div>
								</div>
							</li>
							<li>
								<div class="liwrap">
									<div class="lileft">
										<div class="date">
											<span class="year">2016</span> <span class="md">0528</span>
										</div>
									</div>
									<div class="point"><b></b></div>
									<div class="liright">
										<div class="histt">
											<a href="#">课程标题</a>
										</div>
										<div class="hisct">
											<span class="glyphicon glyphicon glyphicon-star">&nbsp;2</span>
											<span>&nbsp;&nbsp;</span>
											<span class="glyphicon glyphicon-home">&nbsp;电院</span>
											<br> 课程简介
										</div>
									</div>
								</div>
							</li>
							<li>
								<div class="liwrap">
									<div class="lileft">
										<div class="date">
											<span class="year">2016</span> <span class="md">0528</span>
										</div>
									</div>
									<div class="point"><b></b></div>
									<div class="liright">
										<div class="histt">
											<a href="#">课程标题</a>
										</div>
										<div class="hisct">
											<span class="glyphicon glyphicon glyphicon-star">&nbsp;2</span>
											<span>&nbsp;&nbsp;</span>
											<span class="glyphicon glyphicon-home">&nbsp;电院</span>
											<br> 课程简介
										</div>
									</div>
								</div>
							</li>
							<li>
								<div class="liwrap">
									<div class="lileft">
										<div class="date">
											<span class="year">2016</span> <span class="md">0528</span>
										</div>
									</div>
									<div class="point"><b></b></div>
									<div class="liright">
										<div class="histt">
											<a href="#">课程标题</a>
										</div>
										<div class="hisct">
											<span class="glyphicon glyphicon glyphicon-star">&nbsp;2</span>
											<span>&nbsp;&nbsp;</span>
											<span class="glyphicon glyphicon-home">&nbsp;电院</span>
											<br> 课程简介
										</div>
									</div>
								</div>
							</li>
							<!--
						<li>
							<div class="liwrap">

								<div class="lileft">
									<div class="date">
										<span class="year">2016</span> <span class="md">0524</span>
									</div>
								</div>

								<div class="point">
									<b></b>
								</div>

								<div class="liright">
									<div class="histt">
										<a href="#">HTML5 CSS3 发展历程 上线</a>
									</div>
									<div class="hisct">虽然功能还未健全，但是我们已迫不及待的让它去接受广大用户的火眼金睛</div>
								</div>
							</div>
						</li>
						<li>
							<div class="liwrap">
								<div class="lileft">
									<div class="date">
										<span class="year">2016</span> <span class="md">0508</span>
									</div>
								</div>

								<div class="point">
									<b></b>
								</div>

								<div class="liright">
									<div class="histt">
										<a href="#">初期讨论</a>
									</div>
									<div class="hisct">在集体探讨下，发现目前的HTML5 CSS3
										发展历程已经不能满足需求，集体讨论=，这时候，韩老师之前的设计稿被端上了会议桌。</div>
								</div>
							</div>
						</li>
						<li>
							<div class="liwrap">
								<div class="lileft">
									<div class="date">
										<span class="year">2016</span> <span class="md">0701</span>
									</div>
								</div>

								<div class="point">
									<b></b>
								</div>

								<div class="liright">
									<div class="histt">
										<a href="#">灵感迸发</a>
									</div>
									<div class="hisct">某天晚上的凌晨三点一刻，预想建立这样一个功能的网站，专为网页设计师。</div>
								</div>
							</div>
						</li>
						<li>
							<div class="liwrap">

								<div class="lileft">
									<div class="date">
										<span class="year">2016</span> <span class="md">0524</span>
									</div>
								</div>

								<div class="point">
									<b></b>
								</div>

								<div class="liright">
									<div class="histt">
										<a href="#">HTML5 CSS3 发展历程 上线</a>
									</div>
									<div class="hisct">虽然功能还未健全，但是我们已迫不及待的让它去接受广大用户的火眼金睛</div>
								</div>
							</div>
						</li>
						<li>
							<div class="liwrap">
								<div class="lileft">
									<div class="date">
										<span class="year">2016</span> <span class="md">3月1日</span>
									</div>
								</div>

								<div class="point">
									<b></b>
								</div>

								<div class="liright">
									<div class="histt">
										<a href="#">初见成效</a>
									</div>
									<div class="hisct">代码笔记第一版上线</div>
								</div>
							</div>
						</li> -->
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
