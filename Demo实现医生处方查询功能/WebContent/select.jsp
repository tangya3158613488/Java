<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import = "com.Demo1.model.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>医院处方查询</title>
</head>
<style type="text/css">
body {
	background-color: #FFF;
}
</style>
</head>

<body>
<div align="center">
<form id="form1" name="pym" method="post" action="/Demo1/doctor">
  <table width="504" border="1">
    <tr>
      <td colspan="2" bgcolor="#0099FF"><div align="center">**医院医生处方查询</div></td>
    </tr>
    <tr>
      <td width="205" bgcolor="#FFFFFF">医生姓名（请输入拼音码）</td>
      <td width="283" bgcolor="#FFFFFF">
        <label for="textfield"></label>
        <input type="text" name="pym" id="textfield" />
     </td>
    </tr>
    <tr>
      <td colspan="2" bgcolor="#FFFFFF">
        <input type="submit" name="button" id="button" value="查询" />
      </td>
    </tr>
  </table>
   </form>
</div>
<p align="center">&nbsp;</p>

<%
	Doctor doc = (Doctor)request.getAttribute("doctor"); 
	List<Chufang> list = (List<Chufang>)request.getAttribute("clist");
	
	if(list != null){
%>
	<table>
		<tr>
			<td>处方单号</td>
			<td>生成日期</td>
			<td>金额</td>
			<td>审核</td>
		</tr>
		<%
			double total = 0;
			for(int i=0;i<list.size();i++){
				Chufang c = list.get(i);
				total+=c.getMoney();
		%>
		<tr>
			<td><%= c.getChufangID() %></td>
			<td><%= c.getChufangDate() %></td>
			<td><%= c.getMoney() %></td>
			<td>
				<% if(c.getIsVerify()==0){%>
					<input type="submit" value="审核"/>
				<%} else{%>
					<input type="submit" value="审核" disabled="disabled"/>
				<%} %>
			</td>
		</tr>
		<%} %>
		
		<tr>
			<td>医生姓名：<%=doc.getDname() %></td><td></td><td></td><td>处方总金额：<%= total %></td>
		</tr>
	</table>
<%} %>



</body>
</html>