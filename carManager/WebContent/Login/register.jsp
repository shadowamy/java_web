<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>
	<link rel="stylesheet" media="screen" href="css/css.css" />
		
</head>
<body>


	<form id="msform" action="" method="post">
		<!-- progressbar -->
		<ul id="progressbar" >
			<li class="active">账户信息</li>
			<li>详细信息</li>
			
		</ul>
		<!-- fieldsets -->
		<fieldset>
			<h2 class="fs-title">建立你的账户</h2>
			<h3 class="fs-subtitle">This is step 1</h3>
			<input type="text" id="username" name="username" placeholder="用户名*" />
			<br>
			<div id = "msg"></div>
			<br>
			<input type="password" id="password" name="password" placeholder="密码*" />
			<input type="password" id="passwordCon" name="passwordCon" placeholder="确认密码*" />
			<input type="button" name="next" class="next action-button" value="下一步" />
		</fieldset>
		
		<fieldset>
			<h2 class="fs-title">详细信息</h2>
			<h3 class="fs-subtitle">We will never sell it</h3>
			<input type="text" id="realname" name="realname" placeholder="姓名*" />
			<input type="text" id="idnum" name="idnum" placeholder="身份证号*" />
			<textarea id="address" name="address" placeholder="地址*"></textarea>
			<input type="button" name="previous" class="previous action-button" value="前一步" />
			<input type="submit" id="subbtn" class="submit action-button" value="注册" onclick="return Cmd();"/>
		</fieldset>
	</form>
	
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#username").blur(function(){ 
			var val = $(this).val();
			if(val!="")
			{
			     $.ajax({
			        url : "${pageContext.request.contextPath}/registerAjax", //后台查询验证的方法
			        dataTpye : "json",
			        data : {
			            "username" : $('#username').val()
	
			        }, 
			        type : "post",
			        success : function(msg) {
			           
			        	$("#msg").html(msg); 
			        	
			        },
			        error:function(){  //请求失败的回调方法
			        	alert("请求失败，请重试");
			        }
			    });
			}
		  }); 
			
		});
	</script>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$("#subbtn").click(function(){ 

			   $.ajax({
			        url : "${pageContext.request.contextPath}/registerCheck", //后台查询验证的方法
			        dataTpye : "json",
			        data : {
			            "username" : $('#username').val(),
			            "password" : $('#password').val(),
			            "passwordCon" : $('#passwordCon').val(),
			            "realname" : $('#realname').val(),
			            "idnum" : $('#idnum').val(),
			            "address" : $('#address').val()
	
			        }, 
			        type : "post",
			        success : function(msg) {
			        	//alert(msg);
			        	//$("#msg").html(msg); 
			        	if(msg=="null_error")
			        	{
			        		alert("请填写所有必填选项");
			        	}
			        	else if(msg=="user_error")
			        	{
			        		alert("用户名已存在");
			        	}
			        	else if(msg=="pass_error")
			        	{
			        		alert("请检查两次输入密码是否一致");
			        	}
			        	else if(msg=="success")
			        	{
			        		alert("注册成功");
			        		window.location.href='login.jsp';
			        	}
			        },
			        error:function(){  //请求失败的回调方法
			        	alert("请求失败，请重试");
			        }
			    });
			
		  }); 
			
		});
	</script>

	
	<script src="js/jquery-1.9.1.min.js" type="text/javascript"></script>
	<script src="js/jquery.easing.min.js" type="text/javascript"></script>
	<script src="js/jQuery.time.js" type="text/javascript"></script>
	
	<br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br>
</body>
</html>