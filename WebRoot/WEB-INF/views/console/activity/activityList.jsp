<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/commons/attendence/taglibs.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>活动管理</title>
<%@ include file="/WEB-INF/commons/attendence/commonlib.jsp"%>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<%@ include file="/WEB-INF/commons/attendence/consoleHeader.jsp"%>

	<div class="container container-normal" style="margin-top: 60px;">
		<ul class="nav nav-tabs">
			<li role="presentation" class="active"><a href="${ctx}/console/activity/list">我的活动</a></li>
			<li role="presentation" class="dropdown" style="float: right;"><a
				class="dropdown-toggle" data-toggle="dropdown" href="#"
				role="button" aria-haspopup="true" aria-expanded="false">
					操作 <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="${ctx}/console/activity/add">发布活动</a></li>
				</ul>
			</li>
		</ul>
		<div class="table-responsive" style="margin-top: 20px;">
			<table class="table table-striped" style="text-align:center;">
				<tr>
					<td>序号</td>
					<td>活动名称</td>
					<td>活动时间</td>
					<td>地点</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${activityList}" var="activityList"
					varStatus="status">
					<tr>
						<td>${status.index + 1}</td>
						<td><a
							href="${ctx}/console/activity/${activityList.id}/edit">${activityList.title}</a></td>
						<td><fmt:formatDate value="${activityList.startDate}"
								type="both" /> ~ <fmt:formatDate value="${activityList.endDate}"
								type="both" /></td>
						<td>${activityList.place}</td>
						<td><a
							href="${ctx}/console/activity/${activityList.id}/attendence">签到情况</a></td>
					</tr>
				</c:forEach>
			</table>
			<div style="float: right">
				<nav>
				<ul class="pagination">
					<li><a href="#" aria-label="Previous"> <span
							aria-hidden="true">&laquo;</span>
					</a></li>
					<li><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#" aria-label="Next"> <span
							aria-hidden="true">&raquo;</span>
					</a></li>

				</ul>

				</nav>
				<span style="float: right">共多少页</span>
			</div>
		</div>
	</div>
</body>
</html>
