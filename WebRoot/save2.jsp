<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="Navigation.jsp" %>
<style type="text/css">
  		body
	        {
	            margin: 0px;
			}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单</title>
</head>
<body style="text-align: center">
	<h1>以下是订单</h1>
	<table border="1" width="80%" bordercolor="blue">
		<tr>
			<td>编号</td>
			<td>书名</td>
			<td>价格</td>
			<td>地址</td>
			<td>销量</td>
			<td>店名</td>
			<td>类别</td>
			<td>数量</td>
		</tr>
		<c:forEach var="me" items="${cart.map}">
			<tr>
				<td>${me.key}</td>
				<td>${me.value.book.goodname}</td>
				<td>${me.value.book.price}</td>
				<td>${me.value.book.address}</td>
				<td>${me.value.book.salesvolume}</td>
				<td>${me.value.book.shop}</td>
				<td>${me.value.book.category}</td>
				<td>${me.value.quantity}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>