<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 动态连接，要在lib中导入jstl和standard包 -->    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<link rel="stylesheet" href="css/listStu.css"/>
</head>
<body>

<font face="华文行楷" color="orange" size=4>
<h1 align="center">------同学录------</h1>
</font>


<font face="华文彩云" color="green">
<div align="left">
<a href="/web5/sort.jsp"> 返回</a> 
<a href="/web5/select.html">查找</a> 
<a href="/web5/insert.html">插入</a>
</div>
<br>
</font>

	<font face="黑体" >
	<table >
	<tr>
	<td>id</td><td>姓名</td><td>性别</td><td>出生日期</td><td>班级</td><td>电话号码</td><td>qq号</td>
	<td>家庭住址</td><td>操作</td><td>操作</td>
	</tr>

	<c:forEach items="${stus}" var="e">
	<tr>
	<td>${e.id}</td><td>${e.name}</td>
	<td>${e.gender}</td><td>${e.birth}</td>
	<td>${e.classes}</td><td>${e.phone}</td>
	<td>${e.qq}</td><td>${e.address}</td>
    <td><a href="toedit.html?id=${e.id}">更新</a></td>
    <td><a href="studelete.html?id=${e.id}">删除</a></td>
    <tr>
	</c:forEach>
	</table>
	
<table height=450>	
<tr ><td align="left" width=20 >留言板</td>
<c:forEach items="${stus}" var="e">
<td>${e.message}</td>
</c:forEach>
</tr>
</table>
</font>

<font face="华文行楷">
<br>
<div align="center">
<a href="/web5/stulist.html?current=1">第一页</a>
<a href="/web5/stulist.html?current=2">第二页</a>
<a href="/web5/stulist.html?current=3">第三页</a>
<a href="/web5/stulist.html?current=4">第四页</a>
<a href="/web5/stulist.html?current=5">第五页</a>
<a href="/web5/stulist.html?current=6">第六页</a>
</div>
</font>


</body>
</html>