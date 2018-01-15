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
					var $li = $("<li></li>");
					$li.attr("class",(this.state==0)?"unReaded":"");
					$li.html("题目:"+this.title+" 来自:"+this.sendUser+
							" 时间:"+this.msg_Create_Date+"<em><a href='doReadMsg?MsgId="+this.id+"'>查看</a></em>");
					$(".messageList ul").append($li);
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
				<ul></ul>
			</div>
		</div>
	</div>
</body>
</html>
