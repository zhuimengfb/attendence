<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/commons/attendence/taglibs.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN">
<head>

<title>课程首页</title>
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
	
	<script>
	
	function attendence(courseId){
		if (document.getElementById('session_is_login').value!='LOGIN_OK'){
			$('#myModal').modal('show');
			return;
		}
		$.post("http://"+window.location.host+"/attendence/course/attendence",
				{userId:document.getElementById('userId').value,activityId:activityId,latitude:userLatitude,longitude:userLongitude},
				function (data,textStatus){
					if (data=='success'){
						alert("报名成功!");
						document.getElementById(activityId).style.background="#585150";
						document.getElementById(activityId).innerHTML = "已报名";
						document.getElementById(activityId).disabled=true;
					}
					if (data=='attendenceAlready'){
						alert("您已报名，请勿重复操作！");
					}
					if (textStatus=='fail'){
						alert("报名失败，请重新报名！");
					}
				},"text");
		return;
	}
	function gotoLogin(){
		 var locationHost=window.location.host;
		 var loginLocation="http://"+locationHost+"/attendence/user/login";
		 window.location.href=loginLocation; 
	}
</script>
	
</head>

<body>

	<input type="hidden" id="session_is_login"
		value="${sessionScope.SESSION_IS_LOGIN}" />
	<input type="hidden" id="session_user_id"
		value="${sessionScope.SESSION_USER_INFO.id}">
	<%@ include file="/WEB-INF/commons/attendence/header.jsp"%>
	<div class="container container-normal">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-autumn panel-autumn-primary">
					<div class="panel-heading panel-heading-important">
						<h2 class="panel-title">最新课程</h2>
						<!-- <a class="pull-right more-autumn-primary"
							href="#">More&gt;</a> -->
					</div>
					<div class="panel-body">
						<div class="activity-list">
							<div class="row">
								<c:forEach items="${courseInfos}" var="courseInfo"
									varStatus="status">
									<div class="col-lg-3 col-md-4 col-sm-6">
										<div class="activity-item">
											<div class="activity-img" style="height: 150px;">
												<a href="#" target="_blank"> <img
													src="/course/${courseInfo.picAddress}" alt="title"
													class="img-responsive" data-echo="#" />
												</a>
											</div>
											<div class="activity-info">
												<div class="title">
													<a class="link-dark" href="#" target="_blank">
														${courseInfo.title} </a>
												</div>
												<%-- <div class="pre-text">
												<span>${activityInfo.activityDes}</span>
											</div> --%>
												<div class="metas clearfix">
													<div>
														<span class="glyphicon glyphicon-time"></span> <span>&nbsp;<fmt:formatDate
																value="${courseInfo.startDate}" type="both" /> ~ <fmt:formatDate
																value="${courseInfo.endDate}" type="time" /></span>
													</div>
													<div>
														<span class="glyphicon glyphicon-map-marker"></span> <span>&nbsp;${courseInfo.place}</span>
														<%-- <span class="attendence"><button
																id="${activityInfo.id}" class="btn"
																style="color:#ffffff;background-color:#2CCCBF;"
																onclick="attendence('${courseInfo.id}');">报名</button></span> --%>
													</div>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">提示</h4>
				</div>
				<div class="modal-body">您还没有登录，请前往登录！</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭
					</button>
					<button type="button" class="btn"
						style="color:#ffffff;background-color:#2CCCBF;"
						onclick="gotoLogin();">前往登录</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
</body>
</html>
