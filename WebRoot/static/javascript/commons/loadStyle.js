//标志位
var reinitFlag=false;
var loadheight;
var loadwidth;

function loadStyle() {
	/**
	 * 初始化
	 */
	reinitContentHeight();
	if(reinitFlag)
		window.onresize=reinitContentHeight;
	
	 //点击展开隐藏内容
   $("a.tj_open").toggle(function(){
      $(this).css({"background":"url(../../imgaes/link_sdtj2.gif) 92% 45% no-repeat"});
      $(this).parent().parent().parent().parent().find(".show_box").show();
  },function(){
      $(this).css({"background":"url(../../imgaes/link_sdtj.png) 0 0 no-repeat"});
      $(this).parent().parent().parent().parent().find(".show_box").hide();
  }); 
	//内容选项切换
   $("h6.tb1 span").click(function(){
	  changeTab($(this)); 
//      $(this).parent().find("span").removeClass("default"); 
//      $(this).parent().parent().find(".layer").removeClass("default"); 
//      $(this).addClass("default"); 						  
//      var ss = $(this).attr("rel");
//      $(this).parent().parent().find(".layer."+ ss).addClass("default"); 
  });
	//内容选项切换2
   $(".time_b1s a,.time_b1s a").click(function(){
      $(this).parent().find("a").removeClass("current");
      // $(this).parent().parent().parent().parent().find(".rate").removeClass("current"); 
      $(this).addClass("current"); 						  
      // var ss = $(this).attr("rel");
      // $(this).parent().parent().parent().parent().find(".rate."+ ss).addClass("current"); 
  });
}

$(function(){
	$('.time_b1 span').click(function(){
		$(this).addClass('current').siblings().removeClass('current');
	})
   
});

function changeTab(object){
	object.parent().find("span").removeClass("default"); 
	object.parent().parent().find(".layer").removeClass("default"); 
	object.addClass("default"); 						  
    var ss = object.attr("rel");
    object.parent().parent().find(".layer."+ ss).addClass("default");
}

/**
 * 设置首页高度
 */
function reinitContentHeight(){
	var winHeight=$(window.parent).height();
	var winWidth=$(window.parent).width();
	var height=((winHeight<625?625:winHeight)-155)*0.7;
	var width=((winWidth<890?890:winWidth)-155);
	
	loadheight = ((winHeight<625?625:winHeight)-155);
	loadwidth = ((winWidth<890?890:winWidth)-155-20);
	
	$(".main_box table div").each(function(){
		var id=$(this).attr("id");
		if(id!=null&&id.toLowerCase().indexOf("chart")!=-1){
			if ($(this).parent().attr('class') != null){
				$(this).parent().parent().height(height);
				$(this).height(height-25);		
			} else {
				$(this).height(height);		
			}
		}	
		if(id!=null&&id.toLowerCase().indexOf("linedatagrid")!=-1){
			if ($(this).parent().parent().attr('class') != null){
				$(this).parent().parent().height(height);
				$(this).height(height-25);	
				$(this).css("width",width*0.6 -226);
			} else {
				$(this).height(height);
			}
		}	
	});
}