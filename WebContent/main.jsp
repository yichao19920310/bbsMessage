<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			url:"doGetMList",
			data:"id="+id,
			dataType:"json",
			success:function(msg){
				var jsonArray=msg;
				$(jsonArray).each(function(index){
					var $a = $("<a></a>");
					$a.attr("href","doReadMsg?MsgId="+this.id);
					$a.text("题目:"+this.title+" 来自:"+this.sendId+" 时间:"+this.msg_Create_Date);
					$(".messageList").append($a).append("<br/>");
				});				
			}
		})
	})
	</script>
</head>
<body>
	<div id="main">
		<div class="mainbox">
			<div class="title myMessage png"></div>
			<%@include file="head.jspf"%>
			<!--错误信息  -->
			<div id="error">
				<c:if test="${sendMsg}">发送成功!</c:if>
				<c:if test="${sendMsg==false}">发送失败!</c:if>				
			</div>
			<!--短消息列表  -->
			<div class="content messageList">
				
			</div>
		</div>
	</div>
</body>
</html>
