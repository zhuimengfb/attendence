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
<script src="http://api.map.baidu.com/api?v=1.2" type="text/javascript"></script>
<!-- <script src="http://api.map.baidu.com/api?v=2.0&ak=OUQhz79R63u7KIBy0ontWm7Y" type="text/javascript"></script> -->
<script>
	//用户的位置信息
	var userLongitude;
	var userLatitude;
	var getCorrectLocation = false;
	function getLocation() {
		var options = {
			enableHighAccuracy : true,
			maximumAge : 1000
		};
		if (navigator.geolocation) {
			//浏览器支持geolocation
			navigator.geolocation.getCurrentPosition(onSuccess, onError,
					options);
		} else {
			//浏览器不支持geolocation
			alert("您的浏览器不支持位置查询，请更换浏览器");
		}
	}

	//成功时
	function onSuccess(position) {
		getCorrectLocation = true;
		//返回用户位置
		//经度
		var longitude = position.coords.longitude;
		//纬度
		var latitude = position.coords.latitude;
		userLongitude = longitude + 0.010984687519;
		userLatitude = latitude + 0.00420731687912;  
		/* userLongitude = longitude ;
		userLatitude = latitude ;  */
		//使用百度地图API
		//创建地图实例  
		/* var map = new BMap.Map("container");
		//创建一个坐标
		var point = new BMap.Point(longitude, latitude);
		//地图初始化，设置中心点坐标和地图级别  
		map.centerAndZoom(point, 15); */
		//alert(1);
	}

	//失败时
	function onError(error) {
		switch (error.code) {
		case 1:
			alert("位置服务被拒绝");
			break;
		case 2:
			alert("暂时获取不到位置信息");
			break;
		case 3:
			alert("获取信息超时");
			break;
		case 4:
			alert("未知错误");
			break;
		}
	}
	window.onload = getLocation;
	var EARTH_RADIUS = 6378137.0;    //单位M
    var PI = Math.PI;
    
    function getRad(d){
        return d*PI/180.0;
    }
    
    /**
     * caculate the great circle distance
     * @param {Object} lat1
     * @param {Object} lng1
     * @param {Object} lat2
     * @param {Object} lng2
     */
    function getGreatCircleDistance(lat1,lng1,lat2,lng2){
        var radLat1 = getRad(lat1);
        var radLat2 = getRad(lat2);
        
        var a = radLat1 - radLat2;
        var b = getRad(lng1) - getRad(lng2);
        
        var s = 2*Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) + Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
        s = s*EARTH_RADIUS;
        s = Math.round(s*10000)/10000.0;
                
        return s;
    }
	function attendence(latitude,longitude,activityId){
		if (userLatitude==null){
			alert("请打开GPS,连接到无线网络进行定位或稍等片刻！");
			getLocation();
			return;
		}
		var distance=getGreatCircleDistance(latitude,longitude,userLatitude,userLongitude);
		//alert(latitude+","+userLatitude+","+longitude+","+userLongitude);
		//alert(distance);
		//return;
		if (document.getElementById('session_is_login').value!='LOGIN_OK'){
			$('#myModal').modal('show');
			return;
		}
		if (distance>100){
			alert("请到活动地点进行签到，或者打开GPS,连接到无线网络进行精确定位！");
			return;
		}
		$.post("http://"+window.location.host+"/attendence/activity/attendence",
				{userId:document.getElementById('userId').value,activityId:activityId,latitude:userLatitude,longitude:userLongitude},
				function (data,textStatus){
					if (data=='success'){
						alert("签到成功!");
						document.getElementById(activityId).style.background="#585150";
						document.getElementById(activityId).innerHTML = "已签到";
						document.getElementById(activityId).disabled=true;
					}
					if (data=='attendenceAlready'){
						alert("您已签到，请勿重复操作！");
					}
					if (textStatus=='fail'){
						alert("签到失败，请重新签到！");
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

	<input type="hidden" id="session_is_login" value="${sessionScope.SESSION_IS_LOGIN}"/>
	<input type="hidden" id="session_user_id" value="${sessionScope.SESSION_USER_INFO.id}">
	<%@ include file="/WEB-INF/commons/attendence/header.jsp"%>
	<div class="container container-normal">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-autumn panel-autumn-primary">
					<div class="panel-heading panel-heading-important">
						<h2 class="panel-title">最新活动</h2>
						<!-- <a class="pull-right more-autumn-primary"
							href="#">More&gt;</a> -->
					</div>
					<div class="panel-body">
						<div class="activity-list">
							<div class="row">
								<c:forEach items="${activityInfos}" var="activityInfo" varStatus="status">
								<div class="col-lg-3 col-md-4 col-sm-6">
									<div class="activity-item">
										<div class="activity-img" style="height: 150px;">
											<a href="#" target="_blank"> <img
												src="/activity/${activityInfo.activityPicAddress}"
												alt="title" class="img-responsive" data-echo="#" />
											</a>
										</div>
										<div class="activity-info">
											<div class="title">
												<a class="link-dark" href="#" target="_blank"> ${activityInfo.title} </a>
											</div>
											<%-- <div class="pre-text">
												<span>${activityInfo.activityDes}</span>
											</div> --%>
											<div class="metas clearfix">
												<div>
												<span class="glyphicon glyphicon-time"></span> <span>&nbsp;<fmt:formatDate value="${activityInfo.startDate}"
								type="both" /> ~ <fmt:formatDate value="${activityInfo.endDate}"
								type="time" /></span>
								</div>
								<div>
												<span class="glyphicon glyphicon-map-marker"></span> <span>&nbsp;${activityInfo.place}</span>
												<c:if test="${activityInfo.reserve.indexOf('complete')==-1 && activityInfo.reserve.indexOf('attendence')==-1}">
												<span class="attendence"><button id="${activityInfo.id}" class="btn" style="color:#ffffff;background-color:#2CCCBF;" onclick="attendence('${activityInfo.latitude}','${activityInfo.longitude}','${activityInfo.id}');">签到</button></span>
												</c:if>
												<c:if test="${activityInfo.reserve.indexOf('complete')!=-1 && activityInfo.reserve.indexOf('attendence')==-1}">
												<span class="attendence"><button id="${activityInfo.id}" class="btn" style="color:#ffffff;background-color:#585150;" disabled="true">活动已结束</button></span>
												</c:if>
												<c:if test="${activityInfo.reserve.indexOf('complete')!=-1 && activityInfo.reserve.indexOf('attendence')!=-1}">
												<span class="attendence"><button id="${activityInfo.id}" class="btn" style="color:#ffffff;background-color:#585150;" disabled="true">已签到</button></span>
												</c:if>
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
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title" id="myModalLabel">
               提示
            </h4>
         </div>
         <div class="modal-body">
            您还没有登录，请前往登录！
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">关闭
            </button>
            <button type="button" class="btn" style="color:#ffffff;background-color:#2CCCBF;" onclick="gotoLogin();">
               前往登录
            </button>
         </div>
      </div><!-- /.modal-content -->
</div><!-- /.modal -->
</div>
</body>
</html>
