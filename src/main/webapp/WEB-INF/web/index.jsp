<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body style="font-size:30px;">
${sessionScope.user.username}登录成功！|

<div align="right">
<a href="${pageContext.request.contextPath}/user/exit.do" >退出</a>
</div>

<br>
<a href="${pageContext.request.contextPath}/user/showInfo.do">显示个人信息</a>
</body>
</html>







