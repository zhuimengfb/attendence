/*********************************************************************************************/
/*********************************全局工具方法*************************************************/
/*********************************************************************************************/

function retrieveData(url,param,callback) {
	$.post(url, param, callback, 'json');
}

function searchDS(url,param,callback) {
	$.post(ctx+'/'+url, param, callback, 'json');
}


/**
 * 格式化日期
 * @param format 日期格式,如 yyyy-MM-dd
 * @returns	{String}
 */
Date.prototype.format = function(format) // author: meizz
{ 
  var o = { 
    "M+" : this.getMonth()+1, // month
    "d+" : this.getDate(),    // day
    "h+" : this.getHours(),   // hour
    "m+" : this.getMinutes(), // minute
    "s+" : this.getSeconds(), // second
    "q+" : Math.floor((this.getMonth()+3)/3),  // quarter
    "S" : this.getMilliseconds() // millisecond
  }; 
  if(/(y+)/.test(format)) format=format.replace(RegExp.$1, 
    (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
  for(var k in o)if(new RegExp("("+ k +")").test(format)) 
    format = format.replace(RegExp.$1, 
      RegExp.$1.length==1 ? o[k] : 
        ("00"+ o[k]).substr((""+ o[k]).length)); 
  return format; 
}; 

function formatDate(datetime) {

    var data = new Date(datetime);  
    var year = data.getFullYear();  //获取年
    var month = data.getMonth() + 1;    //获取月
    var day = data.getDate(); //获取日
    var hours = data.getHours(); 
    var minutes = data.getMinutes();
    var seconds = data.getSeconds();
    
    //var date = year + "年" + month + "月" + day + "日" + " " + hours + ":" + minutes;
    
    var date = year + "-" + month + "-" + day;
    
    return date;
}
function formatDateCourse(datetime) {

    var data = new Date(datetime);  
    var year = data.getFullYear();  //获取年
    var month = data.getMonth() + 1;    //获取月
    var day = data.getDate(); //获取日
    var hours = data.getHours(); 
    var minutes = data.getMinutes();
    var seconds = data.getSeconds();
    
    
    //var date = year + "-" + month + "-" + day;
    var today = new Array('周日','周一','周二','周三','周四','周五','周六');  
    var week = today[data.getDay()];  
    var date = year + "年" + month + "月" + day + "日" + " " + week;
    
    return date;
}
function formatDateCourseDes(datetime) {
	//alert(datetime);
    var data = new Date(datetime);  
    var year = data.getFullYear();  //获取年
    var month = data.getMonth() + 1;    //获取月
    var day = data.getDate()-1; //获取日
    //alert(data);
   var hours = data.getHours()+10; 
   if(hours==33){
	   hours=09;
   }
    var minutes = data.getMinutes();
    var seconds = data.getSeconds();
    if(minutes=="0"){
    	minutes="00";
    }
    if(day=="21"){
    	day="22";
    }
    var date = year + "年" + month + "月" + day+"日" + hours + ":" + minutes ;
    return date;
}
function formatDateCourseEnd(datetime) {
	//alert(datetime);
    var data = new Date(datetime);  
    var year = data.getFullYear();  //获取年
    var month = data.getMonth() + 1;    //获取月
    var day = data.getDate()-1; //获取日
    //alert(data);
   var hours = data.getHours()+10; 
    var minutes = data.getMinutes();
    var seconds = data.getSeconds();
    if(minutes=="0"){
    	minutes="00";
    }
    return hours+":"+minutes;
}

function formatDate1(datetime) {

    var data = new Date(datetime);  
    var year = data.getFullYear();  //获取年
    var month = data.getMonth() + 1;    //获取月
    var day = data.getDate(); //获取日
    var hours = data.getHours(); 
    var minutes = data.getMinutes();
    var seconds = data.getSeconds();
    
    //var date = year + "年" + month + "月" + day + "日" + " " + hours + ":" + minutes;
    
    var date = year + "-" + month + "-" + day+" " + hours + ":" + minutes + ":" + seconds;
    
    return date;
}





/**
 * 日期增加月份数
 * @param date	日期,{Date}类型
 * @param amount	增加的月份数,数值类型
 * @returns {Date}
 */
Date.prototype.addMonth=function(amount){
	this.setMonth(this.getMonth()+amount);
	return this;
}

/**
 * 日期格式化
 * @param fmt
 * @returns
 */
Date.prototype.format=function(fmt) {         
    var o = {         
    "M+" : this.getMonth()+1, //月份         
    "d+" : this.getDate(), //日         
    "h+" : this.getHours()%12 == 0 ? 12 : this.getHours()%12, //小时         
    "H+" : this.getHours(), //小时         
    "m+" : this.getMinutes(), //分         
    "s+" : this.getSeconds(), //秒         
    "q+" : Math.floor((this.getMonth()+3)/3), //季度         
    "S" : this.getMilliseconds() //毫秒         
    };         
    var week = {         
    "0" : "/u65e5",         
    "1" : "/u4e00",         
    "2" : "/u4e8c",         
    "3" : "/u4e09",         
    "4" : "/u56db",         
    "5" : "/u4e94",         
    "6" : "/u516d"        
    };         
    if(/(y+)/.test(fmt)){         
        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));         
    }         
    if(/(E+)/.test(fmt)){         
        fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "/u661f/u671f" : "/u5468") : "")+week[this.getDay()+""]);         
    }         
    for(var k in o){         
        if(new RegExp("("+ k +")").test(fmt)){         
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));         
        }         
    }         
    return fmt;         
} 

/*****************************************************************************/
/************************************String方法start*****************************/
/**
 * 字符串替换,过滤了一些特殊字符
 * @param s1	原始字符串
 * @param s2	需要替换的字符串
 * @returns		{String}
 */
String.prototype.replaceAll = function(s1, s2) {
	var r = new RegExp(s1.replace(/([\(\)\[\]\{\}\^\$\+\-\*\?\.\"\'\|\/\\])/g,
			"\\$1"), "ig");
	return this.replace(r, s2);
};

/**
 * 去掉字符串两端的空格
 * @returns
 */
String.prototype.trim = function() {
	return this.replace(/(^\s*)|(\s*$)/g, "");
};

/**
 * 去掉字符串左端的空格
 * @returns
 */
String.prototype.ltrim = function() {
	return this.replace(/(^\s*)/g, "");
};

/**
 * 去掉字符串右端的空格
 * @returns
 */
String.prototype.rtrim = function() {
	return this.replace(/(\s*$)/g, "");
};
/************************************String方法end******************************/
/*****************************************************************************/


/*****************************************************************************/
/************************************css方法start*****************************/
/**
 * 隐藏div块
 * @param id	div的id
 */
function hideDiv(id) {
	if ($("#" + id) != null) {
		$("#" + id).css('display', 'none');
	}
}
/**
 * 显示div块
 * @param id	div的id
 */
function showDiv(id) {
	if ($("#" + id) != null) {
		$("#" + id).css('display', 'block');
	}
}


/**
 * 生成fusionchart报表
 * @param chartName		报表flash名称
 * @param chartData		xml数据
 * @param chartId		报表id
 * 		在处理的时候增加了一段随机数,防止快速点击后Fusionchart内存中生成重复id的报表.
 * @param renderDiv		显示报表的div
 */
function drawChart(chartName, chartData, chartId, renderDiv) {
	//chartData = chartData.replaceAll("JavaScript:check_excel_date(this)","JavaScript:basecheck_excel_date(\""+renderDiv+"\")");
	if(chartData!=null){
		var chart = new FusionCharts(resourceCharts + "/statics/Charts/"
				+ chartName + ".swf", chartId+getRandomNumber(), "100%", "100%", "0", "1");
		chart.setXMLData(chartData);
		chart.render(renderDiv);
	}
}

function getRandomNumber(){
	return Math.round(Math.random()*1000);
}
$(document).ready(function() {
	$("#alertfb").slideDown(1000);
	setTimeout(function () {
		$("#alertfb").slideUp(1000);
    }, 5000);
});