<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div id = "msg"></div>
<video id="video" width="920" height="429" src="123" controls autoplay loop></video>

</body>

<script type="text/javascript" src="js/jquery.js"></script>
<script src="js/jquery-1.7.min.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	//setInterval("ask_data()", 3000);
	alert("hello");
	
});

function ask_data()
{ 
	 var re = $("#video").attr('src');
     $.ajax({
        url : "${pageContext.request.contextPath}/Qbject_nameRequest", //后台查询验证的方法
        dataTpye : "json",
        data : {

        }, 
        type : "post",
        success : function(msg) {
           
        	$("#msg").html(msg); 
        	alert(re);
        	
        },
        error:function(){  //请求失败的回调方法
        	alert("请求失败，请重试");
        }
    });

}
</script>

</html>