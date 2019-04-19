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
    
</head>
<body>
	<div class="main">
  	<!--==============================header=================================-->
    <header>
        <h1><a href="index.html">
          <blockquote>
            <h2 class="p2"> Magic School</h2>
          </blockquote>
        </a></h1>
        <nav>  
            <div id="slide">		
                <div class="slider">
                    <ul class="items">
                        <li><img src="images/slider-1.jpg" alt="" /></li>
                        <li><img src="images/slider-2.jpg" alt="" /></li>
                        <li><img src="images/slider-3.jpg" alt="" /></li>
                    </ul>
                </div>	
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
    <section id="content"><div class="ic">More Website Templates @ <a href="" ></a>2019!</div>
        <div class="container_12">	
          <div class="grid_4 bot-1">
            <div class="art"></div>
            <h2 class="top-1 p2"> characteristic </h2>
            <p class="text-1 p3">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</p>
            
            <p class="text-1 top-2 p3">&nbsp;&nbsp;&nbsp;&nbsp;幼儿期是智力发展的关键时期，根据儿童学习模式的特点分析，绝大部分知识是在玩耍中学到的。我们针对上述情况，开发了一套激发儿童学习兴趣、提高儿童认知能力的早教系统。<br/>&nbsp;&nbsp;&nbsp;&nbsp;本系统由摄像头模块，语音模块，树莓派，云服务器等模块组成。<br/>&nbsp;&nbsp;&nbsp;&nbsp;本系统的核心是利用摄像头捕捉物体关键信息，基于树莓派与pc端对图像进行处理，将所得数据上传至云服务器以科学的算法进行分析，得出儿童的兴趣，与儿童进行交互，向家长反馈儿童的学习情况。</p>
            <p>&nbsp;</p>
            <a href="#" class="link-1 top-3">News Archive</a>
          </div>
          <div class="grid_8">
          	<div class="pad-1">
          	  <h2 class="p2">Welcome to Magic School</h2>
          	  <p class="text-1">青果培优，孩子无忧 为了孩子的成长，我们一直在努力<br>
       	      </p>
          	</div> 
            <div class="block-1">
            	<div class="block-1-shadow">
                	<h2 class="clr-6 p4">Our Gallery</h2>
                    <div class="box-1">
                    	<a href="#" class="img-border"><img src="images/img1.jpg" alt=""></a>
                    	<p class="text-2">小明 &nbsp;6岁</p>
                    </div>
                    <div class="box-1 last">
                    	<a href="#" class="img-border"><img src="images/img2.jpg" alt=""></a>
                    	<p class="text-2">玛丽 10岁</p>
                    </div>
                    <div class="clear p5"></div>
                    <div class="box-1">
                    	<a href="#" class="img-border"><img src="images/img3.jpg" alt=""></a>
                    	<p class="text-2">小华 &nbsp;12岁</p>
                    </div>
                    <div class="box-1 last">
                    	<a href="#" class="img-border"><img src="images/img4.jpg" alt=""></a>
                    	<p class="text-2">汤姆 &nbsp;8岁</p>
                    </div>
                    <div class="clear"></div>
                    <div class="pad-2">
                    	<a href="#" class="link-2">Full Gallery</a>
                    </div>
                </div>
            </div>
            <!--==============================footer=================================-->
            <footer>
               
            </footer>	  
          </div>
          <div class="clear"></div>
        </div>
    </section>    
	</div>
</body>
</html>