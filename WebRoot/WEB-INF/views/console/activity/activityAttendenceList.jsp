<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/commons/attendence/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>签到情况</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
    <%@ include file="/WEB-INF/commons/attendence/consoleHeader.jsp"%>

	<div class="container container-normal" style="margin-top: 60px;">
	<table class="table table-striped">
				<tr>
					<td>序号</td>
					<td>姓名</td>
					<td>学号</td>
					<td>签到时间</td>
				</tr>
			</table>
	</div>
  </body>
</html>
