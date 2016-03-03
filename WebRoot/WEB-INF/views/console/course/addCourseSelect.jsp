<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/commons/attendence/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN">
<head>

<title>添加学员</title>
<%@ include file="/WEB-INF/commons/attendence/commonlib.jsp"%>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<%-- <link href="${ctx}/static/css/user/login.css" rel="stylesheet">
<link href="${ctx}/static/css/activity/main.css" media="screen"
	rel="stylesheet">
<link href="${ctx}/static/css/activity/autumn.css" media="screen"
	rel="stylesheet"> --%>

<!-- <link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/css/materialize.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/js/materialize.min.js"></script> -->
<link href="${ctx}/static/css/console/activity/addActivity.css"
	media="screen" rel="stylesheet">
</head>

<body>
	<%@ include file="/WEB-INF/commons/attendence/consoleHeader.jsp"%>
	<div class="container container-normal">
		<div class="es-section login-section">
			<!-- <div style="margin: auto;font-size: 20px;">
				登录
			</div> -->
			<div class="add-course-form">
				<form action="${ctx}/console/course/addMember" method="post"
					name="add-courseMember-form" id="add-courseMember-form"
					enctype="multipart/form-data">
					<div>
						<!-- <div class="form-group">
							<label for="inputTitle">培训课程标题</label> <input type="text"
								class="form-control" id="inputTitle" name="title"
								placeholder="培训课程标题" check-type="required"
								required-message="输入不能为空">
						</div>
						<div class="form-group">
							<label for="inputPlace">课程地点</label> <input type="text"
								class="form-control" id="inputPlace" name="place"
								placeholder="课程地点" check-type="required">
						</div>
						<div class="form-group">
							<label for="inputCredit">课程学分</label> <input type="text"
								class="form-control" id="inputCredit" name="credit"
								placeholder="课程学分" check-type="required number">
						</div>
						<div class="form-group">
							<label for="inputDepartment">授课部门</label> <input type="text"
								class="form-control" id="inputDepartment" name="department"
								placeholder="授课部门" check-type="required">
						</div>
						
							
						<div class="form-group">
							<label for="activityDes">课程描述</label>
							<textarea class="form-control" rows="5" cols="100"
								id="activityDes" name="description" check-type="required"></textarea>
						</div> -->
						<div class="form-group">
							<label>学员表格Excel</label>
							<input type="file" class="form-control" id="excel" name="excel"> 
						</div>
						<!-- <div class="row">
							<div class="form-group col-lg-6">
								<label for="startDate">课程起始时间</label>
								<div class='input-group date' id='datetimepicker11'>
									<span class="input-group-addon"> <span
										class="glyphicon glyphicon-calendar"> </span>
									</span> <input type='text' class="form-control" name="startDate"
										id="startDate" />
								</div>
							</div>
							<div class="form-group col-lg-6">
								<label for="endDate">课程结束时间</label>
								<div class='input-group date' id='datetimepicker12'>
									<span class="input-group-addon"> <span
										class="glyphicon glyphicon-calendar"> </span>
									</span> <input type='text' class="form-control" name="endDate"
										id="endDate" />
								</div>
							</div>
							<script type="text/javascript">
		$(function() {
			$('#datetimepicker11').datetimepicker({
			});
			$('#datetimepicker12').datetimepicker({

			});
		});
	</script>
						</div> -->
						<button type="submit" id="submit"
							class="btn btn-primary btn-lg btn-block"
							style="background: #2CCCBF" onclick="submit1();">添加</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			//1. 简单写法：
			$("#add-courseMember-form").validation();
			$("#submit")
					.on(
							'click',
							function(event) {
								// 2.最后要调用 valid()方法。
								//  valide(object,msg),提示信息显示，object位置后面增加提示信息。如不填object 则自动找最后一个button submit.
								//  valide(msg)
								if ($("#add-courseMember-form").valid(this,
										'填写信息不完整或有误') == false) {
									return false;
								} else {
								}
							});
		});
	</script>
	<script type="text/javascript">
		$("#excel").fileinput({
			'showUpload':false
		});
	</script>
</body>
</html>
