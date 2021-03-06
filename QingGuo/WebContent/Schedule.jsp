<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.lk.entity.Things_record" %>
<%@ page import="com.lk.bussiness.Call_Things_records" %>
<%@ page import="java.util.*" %>
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
	<script type="text/javascript">
	$(document).ready(function(){
		$("#lessd").hide();
	});
	function More() {
        $("#resText").css("height","auto");
        $("#lessd").show();
        $("#mored").hide();
    }
    function Less() {
        $("#resText").css("height","330px");
        $("#lessd").hide();
        $("#mored").show();
    }	
	
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
	
	<%
		Call_Things_records ctr = new Call_Things_records();
		List<Things_record> list_re = ctr.findAll();
	%>
</head>
<body>
<div class="main">
  <!--==============================header=================================-->
    <header>
        <h2 class="p2"> Magic School</h2>
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
            <h2 class="top-6 p6">About Schedule</h2>
            <p class="clr-7 p7"><strong>At vero eos et accusam et justo duo dolores et ea rebum.</strong></p>
            <p class="p7">Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor. Loremsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy.</p>
            <p>Eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum <br>dolor sit amet  <a href="#" class="link">More...</a></p>
          </div>
          <div class="grid_8">
            <div class="block-1 top-5">
            	<div class="block-1-shadow">
                	<h2 class="clr-6 p6">Schedule</h2>

                    <h2 class="clr-6 p6">Events Schedule</h2>
                    <div class="wrap">
                    	<div id="resText" style="height: 330px;">
                            
                            <%
                            	if(list_re!=null)
                            	{
                            	for(Things_record tr:list_re)
                            	{
                            %>
                            	<div class="p4">
                                	<p><strong><%=tr.getRe_time() %></strong></p>
                                	<p>您的孩子接触了<strong><%=tr.getRe_name() %></strong>，对此产生了兴趣。</p>
                            	</div>	
                            	
                            <%
                            	}
                            	}
                            %>
                        </div>
                        
                    </div>
                    <div class="pad-2" id="mored">
						<a id="more" href = "javascript:void(0);" onclick ="More()" class="link-2">More Events</a>
					</div>
                     <div class="pad-2" id="lessd">
						<a id="less" href = "javascript:void(0);" onclick ="Less()" class="link-2" >Retract</a>
				    </div>
                </div>
            </div>
            <!--==============================footer=================================-->
            <footer>
                <p>© 2017 Art School</p>
            </footer>	  
          </div>
          <div class="clear"></div>
        </div>
    </section>    
   </div>
</body>
</html>