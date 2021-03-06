<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>智能早教辅助系统</title>

	<!-- css -->
    <link rel="stylesheet" type="text/css" media="screen" href="css/reset.css">
    <link rel="stylesheet" type="text/css" media="screen" href="css/style.css">
    <link rel="stylesheet" type="text/css" media="screen" href="css/grid_12.css">
    <link rel="stylesheet" type="text/css" media="screen" href="css/slider.css">
    <link href='http://fonts.googleapis.com/css?family=Cabin+Sketch:400,700' rel='stylesheet' type='text/css'>
    
    <!-- js -->
    <script src="js/jquery.js"></script>
    <script src="js/jquery-1.7.min.js"></script>
    <script src="js/jquery.easing.1.3.js"></script>
    <script src="js/tms-0.4.1.js"></script>
    
    <script>
		$(document).ready(function(){				   	
			$('.slider')._TMS({
				show:0,
				pauseOnHover:true,
				prevBu:'.prev',
				nextBu:'.next',
				playBu:false,
				duration:800,
				preset:'fade',
				pagination:true,
				pagNums:false,
				slideshow:7000,
				numStatus:false,
				banners:false,
				waitBannerAnimation:false,
				progressBar:false
			})		
		});
	</script>
	
	<!--[if lt IE 8]>
       <div style=' clear: both; text-align:center; position: relative;'>
         <a href="http://windows.microsoft.com/en-US/internet-explorer/products/ie/home?ocid=ie6_countdown_bannercode">
           <img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today." />
        </a>
      </div>
    <![endif]-->
    <!--[if lt IE 9]>
   		<script type="text/javascript" src="js/html5.js"></script>
    	<link rel="stylesheet" type="text/css" media="screen" href="css/ie.css">
	<![endif]-->
    
<body>
<div class="main">
  <!--==============================header=================================-->
    <header>
        <h2 class="p2"> Magic School</h2>
        <nav>  
            <div id="slide">		
                <div class="slider">
<!--
                    <ul class="items">
                        <li><img src="images/slider-1.jpg" alt="" /></li>
                        <li><img src="images/slider-2.jpg" alt="" /></li>
                        <li><img src="images/slider-3.jpg" alt="" /></li>
                    </ul>
-->
               <video id="video" width="920" height="429" src="" controls autoplay loop></video>
                </div>	
<script type="text/javascript">
	/* var flag=1;
	var tmp;
	setInterval(
		function (){
			var url = "http://localhost:8080/TestRequestListener/hello?time="+new Date().getTime();
			//$("div").load(url);
			var senData;
			$.get(url,senData,function(a){
			//tmp=a;
			if(a!=flag){
				change(a);
				flag = a;	  						
			}

			});
	//alert(senData);
	} ,1000 );
	function change(i){
	document.getElementById('video').setAttribute("src","video"+i+".mp4");
//	console.log(i);
} */

$(document).ready(function(){
	setInterval("ask_data()", 3000);
	
	
});

function ask_data()
{ 
	 var re = $("#video").attr('src');
	 var v_name = re.split('.')[0].split('/')[1];
	 //$("#video").attr('src', "edu_video/video1.mp4");
     $.ajax({
        url : "${pageContext.request.contextPath}/Qbject_nameRequest", //后台查询验证的方法
        dataTpye : "json",
        data : {

        }, 
        type : "post",
        success : function(msg) {
        	//alert("msg:"+msg);
        	//alert("v:"+v_name);
        	if(msg != null && v_name != msg &&msg != "null")
        	{
        		var play_video = "edu_video/"+msg+".mp4";
        		//alert(play_video);
        		//$("#video").attr('src', play_video);
        		document.getElementById('video').setAttribute("src",play_video);
        	}
        	
        	//$("#msg").html(msg); 
        	//alert(v_name);
        	
        },
        error:function(){  //请求失败的回调方法
        	alert("请求失败，请重试");
        }
    });

}

</script>
                <a href="#" class="prev"></a><a href="#" class="next"></a>
            </div>
            <ul class="menu">
              <li class="current"><a href="Index.jsp">HOME</a></li>
              <li><a href="Video.jsp">teach</a></li>
              <li><a href="Schedule.jsp">Schedule</a></li>
              <li><a href="Gallery.jsp">Gallery</a></li>
              <li><a href="Contacts.jsp">Contacts</a></li>
            </ul>
         </nav>
    </header>   
  <!--==============================content================================-->
  	<!--
      <section id="content"><div class="ic">More Website Templates @ <a href="" ></a>.2019!</div>
        <div class="container_12">	
          <div class="grid_4 bot-1">
            <h2 class="top-6 p2">Teachers</h2>
            <p class="text-1 p3">Peter Stanton</p>
            <p>Consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat <a href="#" class="link">More...</a></p>
            <p class="text-1 top-2 p3">Helen Perton</p>
            <p>At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est <a href="#" class="link">More...</a></p>
            <p class="text-1 top-2 p3">Jesica Murray</p>
            <p>Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, <br>sed diam <a href="#" class="link">More...</a></p>
          </div>
          <div class="grid_8">
            <div class="block-1 top-5">
            	<div class="block-1-shadow">
                	<h2 class="clr-6 p6">A Few Words About Us</h2>
                	<p class="clr-6"><strong>青果培优项目旨在全方位培养孩子的认知能力。 通过物联网智能感官系统及网站作用，孩子穿戴智能手套等产品、观看教育动漫全身心感知触电、触火等感觉，达到教提高孩子安全意识的目的。 </strong></p>
                	<p class="clr-6">&nbsp;</p>
                    <div class="pad-3">
                    	<img src="images/page2-img1.jpg" alt="" class="img-border img-indent">
                        <div class="extra-wrap clr-6">
                          <p>&nbsp;</p>
                          <p>&nbsp;</p>
                        </div>
                    </div>
                    <h2 class="clr-6 p6">What We Offer</h2>
                  <p class="clr-6"><strong>青果培优项目旨在全方位培养孩子的认知能力。 通过物联网智能感官系统及网站作用，孩子穿戴智能手套等产品、观看教育动漫全身心感知触电、触火等感觉，达到教提高孩子安全意识的目的。</strong></p>
                    <p class="clr-6">&nbsp;</p>
                    <div class="pad-2">
               	<a href="#" class="link-2">Read More</a>
              </div>
                </div>
            </div> 
            -->    
            <!--==============================footer=================================-->
            <footer>
              <p>&nbsp;</p>
              <p>&nbsp;</p>
            </footer>	  
          </div>
          <div class="clear"></div>
        </div>
    </section>   
   </div>   
</body>
</html>