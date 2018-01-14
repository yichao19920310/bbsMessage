<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>海文 在线短信平台</title>
<link type="text/css" rel="stylesheet" href="css/sms.css" />
<script type="text/javascript" src="scripts/jquery.js"></script>
<script type="text/javascript">
	$(function(){
		var id = ${user.id};
		$.ajax({
			type:"post",
			url:"doGetUList",
			data:"id="+id,
			dataType:"json",
			success:function(msg){		
				var mList=msg;				
				$(mList).each(function(index){
					var $opt = $("<option></option>");
					$opt.val(this.id);
					$opt.text(this.username);
					$("#toUser").append($opt);
				});
			}
		})
	})
</script>
</head>
<body>
	<form action="doSendMsg" method="post">
		<div id="main">
			<div class="mainbox">
				<%@include file="head.jspf"%>
				<div class="content">
					<div class="message">

						<div class="tmenu">
							<ul class="clearfix">
								<li>发送给： <select name="toUser" id="toUser">
										<%-- <c:forEach items="${uList}" var="u">
											<option value="${u.id}">${u.username}</option>
										</c:forEach> --%>
								</select>
								</li>
								<li>标题：<input type="text" name="title" id="title" /></li>
							</ul>
						</div>
						<div class="view">
							<textarea name="content" id="content"></textarea>
							<div class="send">
								<input type="submit" name="submit" value=" " />
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>
