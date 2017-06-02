<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>商品页面</title>
<style type="text/css">
/*清除默认样式*/
* {
	margin: 0;
	padding: 0;
}

/*设置头部div*/
.header { /*设置一个宽度*/
	width: 1000px;
	/*设置一个高度*/
	height: 50px;
	/*设置一个背景颜色*/
	background-color: red;
	/*设置居中*/
	margin: 0 auto;
}

/*设置一个content*/
.content { /*设置一个宽度*/
	width: 1000px;
	/*设置一个高度*/
	height: 400px;
	/*设置一个背景颜色*/
	background-color: white;
	/*居中*/
	margin: 10px auto;
}
</style>

</head>

<body style="text-align: center">
	<div class="header">
		<h2>商品总览</h2>
	</div>
	<div class="content">
		<div class="center">
			<table border="1" width="80%">

				<tr>
					<td>编号</td>
					<td>书名</td>
					<td>价格</td>
					<td>地址</td>
					<td>销量</td>
					<td>店名</td>
					<td>数量</td>
					<td>类别</td>
					<td>操作</td>
				</tr>
				<c:forEach var="book" items="${books}">
					<tr>
						<td>${book.id}</td>
						<td>${book.goodname}</td>
						<td>${book.price}</td>
						<td>${book.address}</td>
						<td>${book.salesvolume}</td>
						<td>${book.shop}</td>
						<td>${book.num}</td>
						<td>${book.category}</td>
						<td><a
							href="${pageContext.request.contextPath}/BuyServlet?id=${book.id}">加入购物车</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>
</html>