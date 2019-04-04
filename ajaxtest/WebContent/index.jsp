<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax Test</title>
<script src="js/jquery.js"></script>

<script type="text/javascript">
$(document).ready(function(){
$("#btn").click(function(){ 
	
    $.ajax({
        url : "${pageContext.request.contextPath}/valiateUserName", //后台查询验证的方法
        dataTpye : "json",
        data : {
            "name" : $('#name').val(),
            "pwd" : $('#pwd').val()
        }, 
        type : "post",
        success : function(msg) {
            //根据后台返回前台的msg给提示信息加HTML
            if ("true" == msg) {
                
            	alert("success");
            } else {
                
                alert("failed");
            }
        },
        error:function(){  //请求失败的回调方法
        	alert("请求失败，请重试");
        }
    });
	});
});
</script>
</head>
<body>
	<form action="" method="POST">
		<input type="text" id="name">
		<input type="text" id="pwd">
		<input type="button" value="submit" id="btn">
	</form>
	<a href="${pageContext.request.contextPath}/DoLogin?name=admin&pwd=hello">测试链接</a>
</body>
</html>
