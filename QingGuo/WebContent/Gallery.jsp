<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.lk.entity.Allthings_list" %>
<%@ page import="com.lk.bussiness.Call_Allthings_list" %>
<%@ page import="com.lk.bussiness.Predict_fun" %>
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
    <script src="js/echarts.min.js"></script>
    
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
	<%
		Call_Allthings_list cal = new Call_Allthings_list();
		List<Allthings_list> list_al = cal.findAll();
        
       	String th_nameString = "";
       	String th_dataString = "";
       	
		for(Allthings_list al:list_al)
		{
			th_nameString += '\''+al.getTh_name()+'\''+',';
			th_dataString += "{value:"+al.getTh_count()+", name:"+'\''+al.getTh_name()+'\''+"},";
		}
		
		String first_interest = "";
		String interst_name = "";
		String interst_result = "";
		List<Map.Entry<String, Double>> list_interst = Predict_fun.predict();
		first_interest = list_interst.get(0).getKey();
		for(Map.Entry<String, Double> map:list_interst)
		{
			interst_name += '\''+map.getKey()+'\''+',';
			interst_result += "{value:"+map.getValue()+", name:"+'\''+map.getKey()+'\''+"},";
		}
	%>
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
        <div class="block-1" >
        	<div class="block-1-shadow" style="width: 1000px;height:400px;">
        	<div id="chart_record"  style="width: 600px;height:400px;float:left"></div>
        	
        	
        	
        	</div>
        	<div class="block-1-shadow" style="width: 1000px;height:400px;">
        	<div id="chart_interest"  style="width: 600px;height:400px;float:left"></div>
        	<div style="width: 400px;height:400px;float:right">
        		<h>您的孩子最近的兴趣：</h>
        		<div id="predict_result" style=""><%=first_interest %></div>
        	</div>
        	</div>
		</div>
		
        <script type="text/javascript">
        	
        	var myChart = echarts.init(document.getElementById('chart_record'));
        	var myChart2 = echarts.init(document.getElementById('chart_interest'));
			
        	var option = {
        			title : {
        		        text: '接触物体比例',
        		        subtext: '(v 1.0)',
        		        x:'center'
        		    },
        		    tooltip: {
        		    	
        		        trigger: 'item',
        		        formatter: "{a} <br/>{b}: {c} ({d}%)"
        		    },
        		    legend: {
        		        orient: 'vertical',
        		        x: 'left',
        		        //data:['直接访问','邮件营销','联盟广告','视频广告','搜索引擎',]
        		        data:[<%=th_nameString%>]
        		    },
        		    series: [
        		        {
        		            name:'兴趣',
        		            type:'pie',
        		            radius: ['50%', '70%'],
        		            avoidLabelOverlap: false,
        		            label: {
        		                normal: {
        		                    show: false,
        		                    position: 'center'
        		                },
        		                emphasis: {
        		                    show: true,
        		                    textStyle: {
        		                        fontSize: '30',
        		                        fontWeight: 'bold'
        		                    }
        		                }
        		            },
        		            labelLine: {
        		                normal: {
        		                    show: false
        		                }
        		            },
        		            /* data:[
        		                {value:335, name:'电脑'},
        		                {value:310, name:'手机'},
        		                {value:234, name:'足球'},
        		                
        		            ] */
        		            data:[<%=th_dataString%>]
        		        }
        		    ]
        		};
        	var option2 = {
        		    title : {
        		        text: '兴趣预测比例',
        		        subtext: 'Algorithm(v 1.0)',
        		        x:'center'
        		    },
        		    tooltip : {
        		        trigger: 'item',
        		        formatter: "{a} <br/>{b} : {c} ({d}%)"
        		    },
        		    legend: {
        		        orient: 'vertical',
        		        left: 'left',
        		        //data: ['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
        		        data: [<%= interst_name%>]
        		    },
        		    series : [
        		        {
        		            name: '兴趣',
        		            type: 'pie',
        		            radius : '55%',
        		            center: ['50%', '60%'],
        		            /*data:[
        		                {value:335, name:'直接访问'},
        		                {value:310, name:'邮件营销'},
        		                {value:234, name:'联盟广告'},
        		                {value:135, name:'视频广告'},
        		                {value:1548, name:'搜索引擎'}
        		            ],*/
        		            data:[
        		                <%= interst_result%>
        		            ],
        		            itemStyle: {
        		                emphasis: {
        		                    shadowBlur: 10,
        		                    shadowOffsetX: 0,
        		                    shadowColor: 'rgba(0, 0, 0, 0.5)'
        		                }
        		            }
        		        }
        		    ]
        		};
        	
        	myChart.setOption(option);
        	myChart2.setOption(option2);
        
        </script>
          
        <div class="clear"></div>
        </div>
    </section>    
   </div>  
</body>

<script type="text/javascript">

$(document).ready(function(){
	//alert("hello");
	//predict_interest();
	
});

function predict_interest()
{ 
	 
     $.ajax({
        url : "${pageContext.request.contextPath}/Interest_PreResult", //后台查询验证的方法
        dataTpye : "json",
        data : {

        }, 
        type : "post",
        success : function(msg) {
        	//alert("msg:"+msg);
        	
        	
        	$("#predict_result").html(msg); 
        	//alert(v_name);
        	
        },
        error:function(){  //请求失败的回调方法
        	alert("请求失败，请重试");
        }
    });

}

</script>

</html>