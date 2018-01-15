<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>海文 在线短信平台</title>
<link type="text/css" rel="stylesheet" href="css/sms.css" />
<script type="text/javascript" src="scripts/jquery.js"></script>
<script type="text/javascript">
	
	var flag = false;
	$(function(){
		
		$("#ip_username").change(function(){
			$.ajax({
				type:"get",
				url:"doCheckU",
				data:"username="+$("#ip_username").val(),
				success:function(msg){
					$("#error").text(msg);
					if("用户名可注册."==msg){
						$("#error").css("color","black");
						//$("#btn_sub").prop("type","submit").attr("onclick","none");
						flag = true;
						//$("#btn_sub").show();
					}else{
						$("#error").css("color","red");
						//$("#btn_sub").prop("type","button").attr("onclick","notAllow()");
						//$("#btn_sub").hide();
						flag = false;
					}
				}
			});
		});
	});
	function regist(){
		if(flag){
			$.ajax({
				type:"post",
				url:"doRegister",
				data:$("form").serialize(),
				success:function(msg){
					if(msg=="OK"){
						alert("注册成功!");
						location.href="index.jsp";
					}else{
						alert("注册失败!");
						location.href="register.jsp";
					}
				}
			});
		}else{
			alert("无法注册,请更改用户名!");
		}
		
	};
</script>
</head>

<body>
	<div id="regTitle" class="png"></div>
	<div id="regForm" class="userForm png">

		<form action="doRegister" method="post">
			<dl>
				<div id="error">提示信息</div>
				<dt>用 户 名：</dt>
				<dd>
					<input type="text" name="username" id="ip_username"/>
				</dd>
				<dt>密 码：</dt>
				<dd>
					<input type="password" name="password" />
				</dd>
				<dt>确认密码：</dt>
				<dd>
					<input type="password" name="affirm" />
				</dd>
				<dt>邮 箱：</dt>
				<dd>
					<input type="text" name="email" />
				</dd>
			</dl>
			<div class="buttons">
				<input class="btn-reg png" type="button" name="register" value=" " id="btn_sub" onclick="regist()"/><input
					class="btn-reset png" type="reset" name="reset" value=" " />
			</div>
			<div class="goback">
				<a href="index.jsp" class="png">返回登录页</a>
			</div>
		</form>
	</div>
</body>
</html>
