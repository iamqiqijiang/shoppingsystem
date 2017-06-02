<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ include file="Navigation.jsp" %>
<style type="text/css">
  		body
	        {
	            margin: 0px;
			}
</style>
<title>购物显示页面</title>
<script type="text/javascript">
    	
    function changequantity(input,id,oldvalue){
           //得到修改的数量
          var quantity = input.value;
          
          //判断是否是正整数
          if(quantity<0 || quantity!=parseInt(quantity)){
                 alert("请输入正整数！！");
                 input.value=oldvalue;
                 return;
          }
           var  b = window.confirm("确定要将数量修改为："+quantity);
           if(b){
				window.location.href="${pageContext.request.contextPath}/ChangeQuantitySevlet?id="+id+"&quantity="+quantity;           
           }
       
       }
    
    </script>



</head>

<body style="text-align: center">
	<h1>您的购物车</h1>
	<h2>您购买了如下商品</h2>
	<c:if test="${empty cart.map}">
		<font color="red">您的购物车还是空的哦！！</font>
		<br />
		<img src="./images/55.jpg" width="350" height="350" />
    您可以
    <a href="Home.jsp">点击此处进入购买页面</a>
	</c:if>
	<c:if test="${!empty cart.map}">
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
				<td>小计</td>
				<td>操作</td>
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
					<td><input type="text" name="quantity"
						value="${me.value.quantity}"
						onchange="changequantity(this,${me.key},${me.value.quantity})" />
						确定修改数量</td>
					<td>${me.value.price}￥</td>

					<td><a
						href="${pageContext.request.contextPath}/DeleteItemServlet?id=${me.key}">删除</a>

					</td>

				</tr>

			</c:forEach>
			<tr>
				<td colspan="3">总价(totalprice)</td>
				<td colspan="1">${cart.price }￥</td>
				<td><a
					href="${pageContext.request.contextPath}/ClearCartServlet">清空购物车</a>
				</td>
				<td><a href="save.jsp">下订单</a></td>
			</tr>

		</table>
		<a href="Home.jsp">返回继续购物</a>
	</c:if>
</body>
</html>