<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="cn.lvb.bao.violationData" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<%@ page import="cn.lvb.bao.userData" %>
<%@ page import="cn.lvb.bao.adminUser" %>
<%@ page import="cn.lk.bean.call_violationDataDB" %>   
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

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
    
    <style> 
		.imgdiv img{ width:40px; height:40px;float:right}
		.imgdiv_del img{width:20px; height:20px;float:left} 
		.imgdiv_cha img{width:20px; height:20px;float:right}
	</style> 
    
   	
    <%
    	HttpSession se = request.getSession();
    	adminUser au = (adminUser)se.getAttribute("adminuser");
    	List<violationData> list_vio = (List<violationData>)se.getAttribute("allviolation");   	
    	//call_violationDataDB cv = new call_violationDataDB();
		//List<violationData> list_vio = cv.findByIDNumber(ud.getIDNumber());
    %>
    <%
    	String addmessage = request.getParameter("addmessage");
    	if(addmessage!=null)
    	{
    		if(addmessage.equals("success")){
    %>
	    	<script type="text/javascript">
	    	alert("添加成功!");
	    	</script>
    <%		} 
    	}%>
    	
    <%
    	String delmessage = request.getParameter("delmessage");
    	if(delmessage!=null)
    	{
    		if(delmessage.equals("success")){
    %>
	    	<script type="text/javascript">
	    	alert("删除成功!");
	    	</script>
    <%		} 
    	}%>
    	
    <%
    	String updatemessage = request.getParameter("updatemessage");
    	if(updatemessage!=null)
    	{
    		if(updatemessage.equals("success")){
    %>
	    	<script type="text/javascript">
	    	alert("修改成功!");
	    	</script>
    <%		} 
    	}%>
    
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
                    <li>
                        <a href="adminVio.jsp">
                            <i class="now-ui-icons design_bullet-list-67"></i>
                            <p>违章处理(admin)</p>
                        </a>
                    </li>
                    
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
                        <a class="navbar-brand" href="#pablo">Table List</a>
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
                                
                                    <a class="dropdown-item" href="#">您好，<%=au.getUserName() %></a>
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
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header">
                            	
                                <h4 class="card-title" style="float:left"> 违章记录</h4>
                                <div class="imgdiv"><a href="../../Action/addVio.jsp"><img alt="" src="../assets/img/add.jpg"></a></div>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead class=" text-primary">
                                            <th>
                                                	车牌号
                                            </th>
                                            <th>
                                                                                              违章时间
                                            </th>
                                            <th>
                                                	处罚金额
                                            </th>
                                            <th>
                                                	违章内容
                                            </th>
                                            <th>
                                                	身份证号
                                            </th>
                                            <th>
                                                	扣除分数
                                            </th>
                                            <th>
                                                	处理状态
                                            </th>
                                            <th>
                                                	操 作
                                            </th>
                                        </thead>
                                        <tbody>
                                        	<% if(list_vio!=null) {%>
                                        		<%for(violationData vd:list_vio) {%>
                                        		<form action="/carManager/dealViolation" method="post">
                                        		<tr>
                                        			 <input type="text" name="dealvioID" id="dealvioID" value='<%=vd.getVioID() %>' style="display:none"> 
                                   
	                                                <td>
	                                                    <%=vd.getCarNumber() %>
	                                                </td>
	                                                <td>
	                                                	<%
	                                                		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	                                                		String viotime = sdf.format(vd.getVioTime());
	                                                	%>
	                                                    <%=viotime %>
	                                                </td>
	                                                <td>
	                                                    <%=vd.getPenalty() %>
	                                                </td>
	                                                <td>
	                                                    <%=vd.getVioContent() %>
	                                                </td>
	                                                <td>
	                                                    <%=vd.getIDNumber() %>
	                                                </td>
	                                                <td>
	                                                    <%=vd.getVioScore() %>
	                                                </td>
	                                                <td>
	                                                    <%=vd.getVioStatus() %>
	                                                </td>
	                                                <td>
	                                                    <div class="imgdiv_del"><a href="/carManager/delViolation?delID=<%=vd.getVioID() %>" onclick="return confirm('确定将此记录删除?')"><img alt="" src="../assets/img/del.png"></a></div>
	                                                    <div class="imgdiv_cha"><a href="/carManager/Action/updateVio.jsp?updateID=<%=vd.getVioID() %>" onclick="return confirm('确定修改该违章记录?')"><img alt="" src="../assets/img/change.jpg"></a></div>
	                                                </td>
                                           		 </tr>
                                           		 </form>
                                        		<%} %>
                                        	<%} %>
                                           
                                            
                                        </tbody>
                                    </table>
                                </div>
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