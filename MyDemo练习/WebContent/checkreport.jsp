<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="file:///E|/MyWeb/background1.jpg" >
</head>
<body>
	<a href="/web2/emplist.html?current=1">第一页</a>
	<a href="/web2/emplist.html?current=2">第二页</a>
	<table>
	<tr>
		<td>宿舍号</td><td>设备号</td><td>设备名</td><td>报修时间</td><td>报修原因</td>
	</tr>
	<c:forEach items="${Report}" var="e">
		<tr>
			<td>${e.dorId}</td>
			<td>${e.equipId}</td>
			<td>${e.equipName}</td>
			<td>${e.reportDate}</td>
			<td>${e.reportReason}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>