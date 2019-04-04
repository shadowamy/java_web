<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>Home</title>
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
<!-- Custom Theme files -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<meta name="keywords" content="Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<!--Google Fonts-->
<link href='http://fonts.useso.com/css?family=Roboto:500,900italic,900,400italic,100,700italic,300,700,500italic,100italic,300italic,400' rel='stylesheet' type='text/css'>
<link href='http://fonts.useso.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
<!--Google Fonts-->

</head>
<body>

<div class="login">
	<h2>驾驶员综合管理平台</h2>
	<div class="login-top">
		<h1>登陆</h1>
		<form action="/carManager/loginCheck" method="post" >
			<input type="text" required="required" name="username" value="User Id"  onfocus="this.value = ''" >
			<input type="password" required="required" name="password" value="password"  onfocus="this.value = ''" >
			<div class="forgot">
	    		<a href="#">忘记密码</a>
	    		<input type="submit" value="登陆" onClick="myCheck();">
	    	</div>
	    </form>
	    
	</div>
	<div class="login-bottom">
		<h3>新用户 &nbsp;<a href="register.jsp">注册</a></h3>
	</div>
</div>	

</body>
</html>