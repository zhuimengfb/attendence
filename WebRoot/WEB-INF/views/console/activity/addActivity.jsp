<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/commons/attendence/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN">
<head>

<title>添加活动</title>
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

<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=2.0&ak=OUQhz79R63u7KIBy0ontWm7Y"></script>

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
			<div class="add-activity-form">
				<form action="${ctx}/console/activity/add" method="post"
					name="add-activity-form" id="add-activity-form"
					enctype="multipart/form-data">
					<div>
						<div class="form-group">
							<label for="inputTitle">活动标题</label> <input type="text"
								class="form-control" id="inputTitle" name="title"
								placeholder="活动标题" check-type="required"
								required-message="输入不能为空">
						</div>
						<div class="form-group">
							<label for="inputPlace">活动地点</label> <input type="text"
								class="form-control" id="inputPlace" name="place"
								placeholder="活动地点" check-type="required">
						</div>
						<div class="form-group">
							<label for="mapContainer">选取活动具体位置</label>
							<div id="mapContainer" style="height:400px;"></div>
						</div>
						<div class="row">
							<div class="form-group col-lg-6">
								<input type="text" class="form-control" id="inputLatitude"
									name="latitude" placeholder="纬度" check-type="required" />
							</div>
							<div class="form-group col-lg-6">
								<input type="text" class="form-control col-lg-6"
									id="inputLongitude" name="longitude" placeholder="经度"
									check-type="required" />
							</div>
						</div>
						<div class="row">
							<div class="form-group col-lg-6">
								<label for="startDate">活动起始时间</label>
								<div class='input-group date' id='datetimepicker11'>
									<span class="input-group-addon"> <span
										class="glyphicon glyphicon-calendar"> </span>
									</span> <input type='text' class="form-control" name="startDate"
										id="startDate" />
								</div>
							</div>
							<div class="form-group col-lg-6">
								<label for="endDate">活动结束时间</label>
								<div class='input-group date' id='datetimepicker12'>
									<span class="input-group-addon"> <span
										class="glyphicon glyphicon-calendar"> </span>
									</span> <input type='text' class="form-control" name="endDate"
										id="endDate" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="activityDes">活动描述</label>
							<textarea class="form-control" rows="5" cols="100"
								id="activityDes" name="activityDes" check-type="required"></textarea>
						</div>
						<div class="form-group">
							<label>活动图片</label>
							<input type="file" class="form-control" id="activityPic" name="activityPic"> 
						</div>
						<button type="submit" id="submit"
							class="btn btn-primary btn-lg btn-block"
							style="background: #2CCCBF" onclick="submit1();">添加活动</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			//1. 简单写法：
			$("#add-activity-form").validation();
			$("#submit")
					.on(
							'click',
							function(event) {
								// 2.最后要调用 valid()方法。
								//  valide(object,msg),提示信息显示，object位置后面增加提示信息。如不填object 则自动找最后一个button submit.
								//  valide(msg)
								if ($("#add-activity-form").valid(this,
										'填写信息不完整或有误') == false) {
									document.getElementById('submit').click();
									return false;
								}
								var startDate=document.getElementById('startDate').value;
								var endDate=document.getElementById('endDate').value;
								if (startDate>endDate){
									alert('活动结束时间必须大于起始时间');
									return false;
								}
							});
		});
	</script>
	<script type="text/javascript">
		$(function() {
			$('#datetimepicker11').datetimepicker({
			});
			$('#datetimepicker12').datetimepicker({

			});
		});
	</script>
	<script type="text/javascript">
		$("#activityPic").fileinput({
			'showUpload':false
		});
	</script>
	<script>
		//使用百度地图API
		//创建地图实例  
		var map = new BMap.Map("mapContainer");
		//创建一个坐标
		var point = new BMap.Point(121.443776, 31.029691);
		map.addControl(new BMap.NavigationControl());
		map.addControl(new BMap.ScaleControl());
		//地图初始化，设置中心点坐标和地图级别  
		map.centerAndZoom(point, 18);
		var marker = new BMap.Marker(point); // 创建标注   
		map.addEventListener("click", function(e) {
			document.getElementById('inputLatitude').value = e.point.lat;
			document.getElementById('inputLongitude').value = e.point.lng;
			map.removeOverlay(marker);
			marker = new BMap.Marker(e.point);
			map.addOverlay(marker); // 将标注添加到地图中
		});
	</script>
</body>
</html>
