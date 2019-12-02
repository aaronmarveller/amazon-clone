<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body style="font-size:30px;">
${error}<br>
<form action="${pageContext.request.contextPath}/user/login.do" method="get">
	账号：<input type="text" name="username"/><br>
	密码：<input type="password" name="pwd"/><br>
	<input type="submit" value="登录">
</form>
</body>
</html>












