<%@page import="cn.lvb.bao.adminUser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="cn.lvb.bao.userData" %>
<%@ page import="cn.lvb.bao.adminUser" %>
<%@ page import="cn.lvb.bao.carPlateData" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8" />
    <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
    <link rel="icon" type="image/png" href="../assets/img/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>Now UI Dashboard by Creative Tim</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
    <!--     Fonts and icons     -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
    <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
    <!-- CSS Files -->
    <link href="../assets/css/bootstrap.min.css" rel="stylesheet" />
    <link href="../assets/css/now-ui-dashboard.css?v=1.0.1" rel="stylesheet" />
    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link href="../assets/demo/demo.css" rel="stylesheet" />
    
    <%
	    HttpSession se = request.getSession();
		userData ud = (userData)se.getAttribute("user");
    	adminUser au = (adminUser)se.getAttribute("adminuser");
    	String IDNumber="";
    	String userName="";
    	String realname="";
    	String Address="";
    	int deScore=-1;
    	if(ud!=null&&au==null)
    	{
    		IDNumber = ud.getIDNumber();
    		userName = ud.getUserName();
    		realname = ud.getRealname();
    		Address = ud.getAddress();
    		deScore = ud.getDeScore();
    	}
    	else if(ud==null&&au!=null)
    	{
    		IDNumber = au.getIDNumber();
    		userName = au.getUserName();
    		realname = au.getRealname();
    		Address = au.getAddress();
    		//deScore = ud.getDeScore();
    	}
    	
	
    	List<carPlateData> list_carpl = (List<carPlateData>)se.getAttribute("carPlate");
	%>
	
		
</head>
<body>

<div class="wrapper ">
        <div class="sidebar" data-color="blue">
            <!--
        Tip 1: You can change the color of the sidebar using: data-color="blue | green | orange | red | yellow"
    -->
            <div class="logo">
                <a href="#" class="simple-text logo-mini">
                    CT
                </a>
                <a href="#" class="simple-text logo-normal">
                    Creative Tim
                </a>
            </div>
            <div class="sidebar-wrapper">
                <ul class="nav">
                    <li>
                        <a href="index.jsp">
                            <i class="now-ui-icons design_app"></i>
                            <p>主页</p>
                        </a>
                    </li>
                    <li>
                        <a href="applyLicense.jsp">
                            <i class="now-ui-icons education_atom"></i>
                            <p>驾照申领</p>
                        </a>
                    </li>
                    <li>
                        <a href="applyCarNum.jsp">
                            <i class="now-ui-icons location_map-big"></i>
                            <p>车牌号申领</p>
                        </a>
                    </li>
                    <li>
                        <a href="changeLicense.jsp">
                            <i class="now-ui-icons ui-1_bell-53"></i>
                            <p>驾照更换</p>
                        </a>
                    </li>
                    <%if(ud!=null&&au==null) {%>
                    <li>
                        <a href="violation.jsp">
                            <i class="now-ui-icons design_bullet-list-67"></i>
                            <p>违章处理</p>
                        </a>
                    </li>
                    <% }%>
                    <%if(ud==null&&au!=null){ %>
                    	<li>
                        <a href="adminVio.jsp">
                            <i class="now-ui-icons design_bullet-list-67"></i>
                            <p>违章处理(admin)</p>
                        </a>
                    </li>
                    <%} %>
                    
                </ul>
            </div>
        </div>
        <div class="main-panel">
            <!-- Navbar -->
            <nav class="navbar navbar-expand-lg navbar-transparent  navbar-absolute bg-primary fixed-top">
                <div class="container-fluid">
                    <div class="navbar-wrapper">
                        <div class="navbar-toggle">
                            <button type="button" class="navbar-toggler">
                                <span class="navbar-toggler-bar bar1"></span>
                                <span class="navbar-toggler-bar bar2"></span>
                                <span class="navbar-toggler-bar bar3"></span>
                            </button>
                        </div>
                        <a class="navbar-brand" href="#pablo">User Profile</a>
                    </div>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-bar navbar-kebab"></span>
                        <span class="navbar-toggler-bar navbar-kebab"></span>
                        <span class="navbar-toggler-bar navbar-kebab"></span>
                    </button>
                    <div class="collapse navbar-collapse justify-content-end" id="navigation">
                        <form>
                            <div class="input-group no-border">
                                <input type="text" value="" class="form-control" placeholder="Search...">
                                <span class="input-group-addon">
                                    <i class="now-ui-icons ui-1_zoom-bold"></i>
                                </span>
                            </div>
                        </form>
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link" href="#pablo">
                                    <i class="now-ui-icons media-2_sound-wave"></i>
                                    <p>
                                        <span class="d-lg-none d-md-block">Stats</span>
                                    </p>
                                </a>
                            </li>
                            
                            
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="now-ui-icons users_single-02"></i>
                                    <p>
                                        <span class="d-lg-none d-md-block">Some Actions</span>
                                    </p>
                                </a>
                                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
                                
                                    <a class="dropdown-item" href="#">您好，<%=userName %></a>
                                    <a class="dropdown-item" href="/carManager/Logout">Logout</a>
                                    
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <!-- End Navbar -->
            <div class="panel-header panel-header-sm">
            </div>
            <div class="content">
                <div class="row">
                    <div class="col-md-8">
                        <div class="card">
                            <div class="card-header">
                                <h5 class="title">个人信息</h5>
                            </div>
                            <div class="card-body">
                                <form>
                                    <div class="row">
                                        <div class="col-md-5 pr-1">
                                            <div class="form-group">
                                                <label>身份证号</label>
                                                <input type="text" class="form-control" disabled="" placeholder="Idnumber" value='<%=IDNumber %>'>
                                            </div>
                                        </div>
                                        <div class="col-md-3 px-1">
                                            <div class="form-group">
                                                <label>用户名</label>
                                                <input type="text" class="form-control" disabled="" placeholder="Username" value='<%=userName %>'>
                                            </div>
                                        </div>
                                        
                                    </div>
                                    <div class="row">
                                        
                                        <div class="col-md-6 pr-1">
                                            <div class="form-group">
                                                <label>姓    名</label>
                                                <input type="text" class="form-control" disabled="" placeholder="Name" value='<%=realname %>' >
                                            </div>
                                        </div>
                                        
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label>住 址</label>
                                                <input type="text" class="form-control" disabled="" placeholder="Home Address" value='<%=Address %>'>
                                            </div>
                                        </div>
                                    </div>
                                    <%if(deScore!=-1) {%>
                                    <div class="row">
                                        <div class="col-md-4 pr-1">
                                            <div class="form-group">
                                                <label>扣除分数</label>
                                                <input type="text" class="form-control" disabled="" placeholder="Grade" value=<%=deScore %>>
                                            </div>
                                        </div>
                                        
                                    </div>
                                    <%} %>
                                   
                                    
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card card-user">
                            <div class="image">
                                <!--<img src="../assets/img//bg5.jpg" alt="...">-->
                            </div>
                            <div class="card-body">
                                <div class="author">
                                    <a href="#">
                                       <!--<img class="avatar border-gray" src="../assets/img//mike.jpg" alt="...">-->
                                        <%if(deScore!=-1){ %>
                                    		<h5 class="title">拥有车辆</h5>
                                    	<%} %>
                                    	<%if(deScore==-1){ %>
                                    		<h5 class="title">管理员</h5>
                                    	<%} %>
                                    </a>
                                    <!--<p class="description">
                                        michael24
                                    </p> -->
                                </div>
                                <p class="description text-center">
                                	<%if(list_carpl!=null){ %>
                                		<%for(carPlateData cp:list_carpl){ %>
                                			<%=cp.getCarNumber() %>
                                			<br>
                                		<%} %>
                                	<%} %>
                                    <!--"Lamborghini Mercy
                                    <br> Your chick she so thirsty
                                    <br> I'm in that two seat Lambo"  -->
                                </p>
                            </div>
                            <hr>
                            <!--<div class="button-container">
                                <button href="#" class="btn btn-neutral btn-icon btn-round btn-lg">
                                    <i class="fab fa-facebook-f"></i>
                                </button>
                                <button href="#" class="btn btn-neutral btn-icon btn-round btn-lg">
                                    <i class="fab fa-twitter"></i>
                                </button>
                                <button href="#" class="btn btn-neutral btn-icon btn-round btn-lg">
                                    <i class="fab fa-google-plus-g"></i>
                                </button>
                            </div>  -->
                        </div>
                    </div>
                </div>
            </div>
            <footer class="footer">
                <div class="container-fluid">
                    <nav>
                        <ul>
                            <li>
                                <a href="#">
                                    Creative Tim
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    About Us
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    Blog
                                </a>
                            </li>
                        </ul>
                    </nav>
                    
                </div>
            </footer>
        </div>
    </div>

</body>

<!--   Core JS Files   -->
<script src="../assets/js/core/jquery.min.js"></script>
<script src="../assets/js/core/popper.min.js"></script>
<script src="../assets/js/core/bootstrap.min.js"></script>
<script src="../assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
<!--  Google Maps Plugin    -->

<!-- Chart JS -->
<script src="../assets/js/plugins/chartjs.min.js"></script>
<!--  Notifications Plugin    -->
<script src="../assets/js/plugins/bootstrap-notify.js"></script>
<!-- Control Center for Now Ui Dashboard: parallax effects, scripts for the example pages etc -->
<script src="../assets/js/now-ui-dashboard.js?v=1.0.1"></script>
<!-- Now Ui Dashboard DEMO methods, don't include it in your project! -->
<script src="../assets/demo/demo.js"></script>

</html>