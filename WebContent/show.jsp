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
				<ul>
					<c:forEach items="${mList}" var="m">						
							<li class="${m.state==0?'unReaded':''}">
								题目:${m.title} 来自:${m.sendUser} 时间:${m.msg_Create_Date}
								<em><a href="readMsg.jsp?MsgId=${m.id}" style="color:#ff0000">查看</a></em>
							</li>
					</c:forEach>
				</ul>
			</div>
			<!--分页-->
			<div class="page-spliter">
				<a href="doGetMList?page=${pager.prevPage}">上一页</a>
				<c:forEach items="${pager.groupList}" var="i">
					<c:if test="${i==pager.currentPage}">
						${i}
					</c:if>
					<c:if test="${i!=pager.currentPage}">
						<a href="doGetMList?page=${i}">${i}</a>
					</c:if>
				</c:forEach>
				<a href="doGetMList?page=${pager.nextPage}">下一页</a>
			</div>
		</div>
	</div>
</body>
</html>
