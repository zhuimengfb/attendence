<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/commons/attendence/taglibs.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>已选课程学员</title>
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
		<input type="hidden" name="currentPage" id="currentPage" value="${currentPage}">
		<ul class="nav nav-tabs">
		<%-- 	<li role="presentation"><a href="${ctx}/console/activity/list">我的活动</a></li>
			<li role="presentation" class="active"><a href="${ctx}/console/course/list">我的课程</a></li> --%>
			<li role="presentation" class="dropdown" style="float: right;"><a
				class="dropdown-toggle" data-toggle="dropdown" href="#"
				role="button" aria-haspopup="true" aria-expanded="false">
					操作 <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="${ctx}/console/course/addMember">添加学员</a></li>
				</ul>
			</li>
		</ul>
		<div class="table-responsive" style="margin-top: 20px;">
			<table class="table table-striped" style="text-align:center;">
				<tr>
					<td>序号</td>
					<td>姓名</td>
					<td>学号</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${courseMemberList}" var="courseMemberList"
					varStatus="status">
					<tr>
						<td>${status.index + 1}</td>
						<td>${courseMemberList.name}</td>
						<td>${courseMemberList.account}</td>
						<td><span><a
							href="${ctx}/console/course/${courseMemberList.id}/removeMember">删除</a></span>
							</td>
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
