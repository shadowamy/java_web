<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>

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
        <h1><a href="index.html"><img src="images/logo.png" alt=""></a></h1>
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
    <section id="content"><div class="ic">More Website Templates @ <a href="" >张丰彦</a>.2017!</div>
        <div class="container_12">	
          <div class="grid_4 bot-1">
            <h2 class="top-6">Contact Us</h2>
            <div class="map">
              <iframe src="http://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=Brooklyn,+New+York,+NY,+United+States&amp;aq=0&amp;sll=37.0625,-95.677068&amp;sspn=61.282355,146.513672&amp;ie=UTF8&amp;hq=&amp;hnear=Brooklyn,+Kings,+New+York&amp;ll=40.649974,-73.950005&amp;spn=0.01628,0.025663&amp;z=14&amp;iwloc=A&amp;output=embed"></iframe>
            </div>
            <dl>
                <dt>8901 Marmora Road, <br>Glasgow, D04 89GR.</dt>
                <dd><span>Telephone: </span>+1 800 603 6035</dd>
                <dd><span>E-mail: </span><a href="#" class="link">mail@demolink.org</a></dd>
            </dl> 
          </div>
          <div class="grid_8">
            <div class="block-1 top-5">
            	<div class="block-1-shadow">
                	<h2 class="clr-6">Contact Form</h2>
                    <form id="form" method="post" >
                      <fieldset>
                        <label><strong>Name:</strong><input type="text" value=""><strong class="clear"></strong></label>
                        <label><strong>Email:</strong><input type="text" value=""><strong class="clear"></strong></label>
                        <label><strong>Phone:</strong><input type="text" value=""><strong class="clear"></strong></label>
                        <label><strong>Message:</strong><textarea></textarea><strong class="clear"></strong></label>
                        <strong class="clear"></strong>
                        <div class="btns pad-2"><a href="#" class="link-2">Clear</a><a href="#" class="link-2" onClick="document.getElementById('form').submit()">Send</a></div>
                      </fieldset>  
                    </form> 
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