<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>学士后 短消息平台</title>
<link type="text/css" rel="stylesheet" href="css/sms.css" />

</head>
<body>
	<div id="loginTitle" class="png"></div>
	<div id="loginForm" class="userForm png">
		<form action="doLogin" method="post">
			<dl>
				<div id="error">显示登录失败等错误信息</div>
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
				<input class="btn-login png" type="submit" name="submit" value=" " />
				<input class="btn-reg png" type="button" name="register" value=" " onclick="location.href='register.jsp'">
			</div>
		</form>
	</div>
</body>
</html>

