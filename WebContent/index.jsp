<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>学士后 短消息平台</title>
<link type="text/css" rel="stylesheet" href="css/sms.css" />
<script type="text/javascript" src="scripts/jquery.js"></script>
<script type="text/javascript">
	function login(){
		$.ajax({
			type:"post",
			url:"doLogin",
			data:$("form").serialize(),
			async:false,
			dataType:"text",
			success:function(msg){
				if(msg=="OK"){
					alert("登录成功!");
					location.href="main.jsp";
				}else{
					alert("登录失败!");
					$("form")[0].reset();
				}
			}
		})
	}
</script>
</head>
<body>
	<div id="loginTitle" class="png"></div>
	<div id="loginForm" class="userForm png">
		<form action="doLogin" method="post">
			<dl>
				<div id="error">欢迎</div>
				<dt>用户名：</dt>
				<dd>
					<input type="text" name="username" />
				</dd>
				<dt>密 码：</dt>
				<dd>
					<input type="password" name="password" />
				</dd>
			</dl>
			<div class="buttons">
				<input class="btn-login png" type="button" name="submit" value=" " onclick="login()"/>
				<input class="btn-reg png" type="button" name="register" value=" " onclick="location.href='register.jsp'">
			</div>
		</form>
	</div>
</body>
</html>

