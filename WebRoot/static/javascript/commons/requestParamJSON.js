
/**
 * 请求参数实体的封装
 */
RequestParamJSON = function() {

	// 请求方式信息
	this.requestHeaders = new RequestHeaders();
	// 请求参数
	this.requesetParams = new RequesetParams();
	// 返回结果头信息
	this.responseHeaders = new ResponseHeaders();
	
	this.searchMultipleComponent = new SearchMultipleComponent();
	 
};

/**
 * 参数实体体注入
 * @param tableCode
 * @param startDate
 * @param endDate
 * @param dateType
 * @return
 */
RequestParamJSON.prototype.setAllVar = function(requestHeaders, requesetParams, responseHeaders) {

	this.requestHeaders = requestHeaders;

	this.requesetParams = requesetParams;

	this.responseHeaders = responseHeaders;

};

/**
 * 注入请求信息
 * @param requestHeaders
 * @return
 */
RequestParamJSON.prototype.setRequestHeaders = function(requestHeaders) {
	
	this.requestHeaders = requestHeaders;
	
};
/**
 * 注入请求参数
 * @param requesetParams
 * @return
 */
RequestParamJSON.prototype.setRequesetParams = function(requesetParams) {

	this.requesetParams = requesetParams;

};
/**
 * 注入响应信息
 * @param responseHeaders
 * @return
 */
RequestParamJSON.prototype.setResponseHeaders = function(responseHeaders) {

	this.responseHeaders = responseHeaders;
};


RequestParamJSON.prototype.setSearchMultipleComponent = function(searchMultipleComponent) {
	this.searchMultipleComponent = searchMultipleComponent;
};
/**
 * 请求信息实体封装
 */
RequestHeaders = function() {
	
	this.requestMethod = 'POST';
	
};
/**
 * 注入请求方式
 * @param responseHeaders
 * @return
 */
RequestHeaders.prototype.setRequestMethod = function(responseHeaders) {

	this.requestMethod = responseHeaders;
};

/**
 * 组件请类型
 * @param responseHeaders
 * @return
 */
RequestHeaders.prototype.setRequestType = function(requestType) {
	this.requestType = requestType;
};



/**
 * 请求参数实体的封装
 */
RequesetParams = function() {
	
	this.componentId = null;
	// 起始日期
	this.tableCode = null;
	// 起始日期
	this.startDate = null;
	// 截止日期
	this.endDate = null;
	// 日期类型 ('D_Y':年, 'D_M':月, 'D_D':日)
	this.dateType = "D_M";
	
	this.key =null;
	
	this.whereType = null;
	this.whereCode = null;
	this.whereValue = null;
	
};
/**
 * 参数值注入
 * @param tableCode
 * @param startDate
 * @param endDate
 * @param dateType
 * @return
 */
RequesetParams.prototype.setAllVar = function(startDate, endDate, dateType) {
	
	this.startDate = startDate;

	this.endDate = endDate;

	this.dateType = dateType;

};

RequestHeaders.prototype.setRequestUrl = function(requestUrl) {

	this.requestUrl = requestUrl;
};

/**
 * 组建ID属性注入
 * @param tableCode
 * @return
 */
RequesetParams.prototype.setComponentId = function(componentId) {
	this.componentId = componentId;
	
};
/**
 * 表名属性注入
 * @param tableCode
 * @return
 */
RequesetParams.prototype.setTableCode = function(tableCode) {

	this.tableCode = tableCode;
	
};
/**
 * 起始日期属性值注入
 * @param startDate
 * @return
 */
RequesetParams.prototype.setStartDate = function(startDate) {

	this.startDate = startDate;
	
};
/**
 * 截止日期属性值注入
 * @param endDate
 * @return
 */
RequesetParams.prototype.setEndDate = function(endDate) {

	this.endDate = endDate;
	
};
/**
 * 日期属性值注入
 * @param dateType
 * @return
 */
RequesetParams.prototype.setDateType = function(dateType) {

	this.dateType = dateType;
	
};


RequesetParams.prototype.setKey = function(key) {

	this.key = key;
	
};


RequesetParams.prototype.setDateType = function(dateType) {

	this.dateType = dateType;
	
};

RequesetParams.prototype.setWhereType = function(whereType) {

	this.whereType = whereType;
	
};

RequesetParams.prototype.setWhereCode = function(whereCode) {

	this.whereCode = whereCode;
	
};

RequesetParams.prototype.setWhereValue = function(whereValue) {

	this.whereValue = whereValue;
	
};

/**
 * 响应信息实体封装
 */
ResponseHeaders = function() {
	// 响应数据格式
	this.responseContentType = 'JSON';
	
	this.responseContentRSCOrderBySign ='DESC'; 
	
	this.responseContentCode = "code";
	
	this.responseContentName = "name"; 
	
	this.responseContentInCrease = "InCrease"; 
	
	/**
	 * 结果集分组描述 结果集类型
	 **/
	this.responseContentDSType= null;
	/**
	 * 结果集分组描述 结果集类型对应ID表字段名
	 **/
	this.responseContentDSTypeIDCode= null;	
	/**
	 * 结果集分组描述 结果集类型对应name表字段名
	 **/
	this.responseContentDSTypeNameCode= null;
	
	
	this.responseContentDSCName= null; 
	
	this.responseContentDSCValue= null;
	
	this.responseContentDSCValue= null;
	
	
	
	/**
	 * SQL
	 * 结果集字段描述
	 */
	
	this.responseContentRSCType= null;
	
	this.responseContentRSCException= null;
	
	this.responseContentRSCName= null;
	
	this.responseContentRSCTop = null;
	
	this.responseContentRSCOrderBy= null;
	
	this.responseContentRSCOrderBySign = null;

};

/**
 * 响应内容格式注入
 * @param responseContentDSType
 * @return
 */
//Dimensions Column --> DSC 
ResponseHeaders.prototype.setResponseContentDSType = function(responseContentDSType) {
	
	this.responseContentDSType = responseContentDSType;
	
};

ResponseHeaders.prototype.setResponseContentDSTypeIDCode = function(responseContentDSTypeIDCode) {
	this.responseContentDSTypeIDCode = responseContentDSTypeIDCode;	
};
ResponseHeaders.prototype.setResponseContentDSTypeNameCode = function(responseContentDSTypeNameCode) {
	this.responseContentDSTypeNameCode = responseContentDSTypeNameCode;	
};
/**
 * 响应字段信息
 * @param responseContentDSCName
 * @return
 */

ResponseHeaders.prototype.setResponseContentCode = function(responseContentCode) {

	this.responseContentCode = responseContentCode;
	
};

ResponseHeaders.prototype.setResponseContentName = function(responseContentName) {

	this.responseContentName = responseContentName;
	
};

ResponseHeaders.prototype.setResponseContentInCrease = function(responseContentInCrease) {

	this.responseContentInCrease = responseContentInCrease;
	
};



ResponseHeaders.prototype.setResponseContentDSCName = function(responseContentDSCName) {

	this.responseContentDSCName = responseContentDSCName;
	
};

ResponseHeaders.prototype.setResponseContentDSCValue = function(responseContentDSCValue) {

	this.responseContentDSCValue = responseContentDSCValue;
	
};
//Result Set Column --> RSC
ResponseHeaders.prototype.setResponseContentRSCName = function(responseContentRSCName) {

	this.responseContentRSCName = responseContentRSCName;
	
};
/**
 * 相应信息数目注入
 * @param responseContentRSCTop
 * @return
 */
ResponseHeaders.prototype.setResponseContentRSCTop = function(responseContentRSCTop) {

	this.responseContentRSCTop = responseContentRSCTop;
	
};
/**
 * 排序字段注入
 * @param responseContentRSCOrderBy
 * @return
 */
ResponseHeaders.prototype.setResponseContentRSCOrderBy = function(responseContentRSCOrderBy) {

	this.responseContentRSCOrderBy = responseContentRSCOrderBy;
	
};
/**
 * 排序方式注入
 * @param responseContentRSCOrderBySign
 * @return
 */
ResponseHeaders.prototype.setResponseContentRSCOrderBySign = function(responseContentRSCOrderBySign) {

	this.responseContentRSCOrderBySign = responseContentRSCOrderBySign;
	
};


SearchMultipleComponent = function() {
	this.componentParam = null;
}

SearchMultipleComponent.prototype.setComponentParam = function(componentParam) {

	this.componentParam = componentParam;
	
};


/*
 * 日期类型
 * 
 */
if(typeof DateType == "undefined"){
	
	//'D_Y':年, 'D_M':月, 'D_D':日
	
    var DateType = {
        Y: "D_Y",
        M: "D_M",
        D: "D_D"
    };
};


/*
 * 日期输出格式化
 * 
 */
if(typeof DateFormat == "undefined"){
	
	//'D_Y':年, 'D_M':月, 'D_D':日
	
    var DateFormat = {
    	D_Y: "%Y",
    	D_M: "%m/%Y",
    	D_D: "%m/%d/%Y"
    };
};

// Order by flag
if(typeof OrderBySign == "undefined"){
    var OrderBySign = { 
        DESC: "DESC",
        ASC: "ASC"
    };
};

// requesetParams Model Data
if(typeof RP_MData == "undefined"){
    var RP_MData = {
    	TableCode: {
    		dw_treatment_population_comp:"dw_treatment_population_comp",
    		dw_treatment_fee_comp:'dw_treatment_fee_comp',
    		dw_operation_population_comp:'dw_operation_population_comp'	
        },
        WhereType : {
        	division :  "division",
        	zy :  "zy",
        	hospital_level : "hospital_level",
        	exception : "exception"
        }
    };
}
//RequestHeaders Model Data
if(typeof R_HData == "undefined"){
    var R_HData = {
    	requestType: {
    		MultipleComponent:"MultipleComponent"
        }
    };
}
// responseHeaders Model Data
if(typeof RPH_DSC_MData == "undefined"){
    var RPH_DSC_MData = {
    	ResponseContentDSType: {
    		statistic_day:"statistic_day",
    		tb_hdm_medical_institution_yg: "tb_hdm_medical_institution_yg",
    		tb_hdm_treatment_type:"tb_hdm_treatment_type",
    		tb_hdm_age:"tb_hdm_age",
    		tb_hdm_sex:"tb_hdm_sex",
    		tb_hdm_cardtype:"tb_hdm_cardtype",
    		tb_volap_ccd:"tb_volap_ccd",
    		tb_hdm_department:"tb_hdm_department"
        }
	    ,
	    ResponseContentDSTypeIDCode : {
	    	tb_hdm_medical_institution_yg_administrative_division : "administrative_division" ,
	    	tb_hdm_medical_institution_yg_division : "division"
	    },
	    responseContentDSTypeIDName : {
	    	tb_hdm_medical_institution_yg_administrative_division_name : "administrative_division_name",
	    	tb_hdm_medical_institution_yg_division_name : "division_name"
	    }
    };
}








