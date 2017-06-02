<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<head>
 	<style type="text/css">
		.x{
			color:#000000;
		}
		div.x{
			background-image: url(images/white.jpg);
			font-size:19px;
			color:#000000;
		}
	</style>
</head>
<%
	String n=(String)session.getAttribute("loginusername");
	String m=(String)session.getAttribute("logincate");
	String l=(String)session.getAttribute("shopname");
	if(n==null){
	%>
		<div align="left" class="x">
			<a href="login.jsp" class="x">亲，请登录</a> | <a href="reg.jsp" class="x">欢迎注册</a>
		</div>
	<% 
	}else if(m.equals("顾客")){
	%>
		<div align="left" class="x">
			<a class="x"><%=n%>,欢迎!</a> | <a href="Home.jsp" class="x">首页</a>| <a href="personal.jsp?user=<%=n%>" class="x">个人中心</a>| <a href="listcart.jsp" class="x">购物车</a>| <a href="save2.jsp" class="x">我的订单</a>| <a href="startshop.jsp" class="x">我要开店</a> | <a href="javascript:if (confirm('是否退出登录?')){ window.location.href='logout.jsp';}else{};" class="x">退出登录</a>
		</div>
	<%
	}else if(m.equals("店主")){
	%>
		<div align="left" class="x">
			<a class="x"><%=n%>,欢迎!</a>| <a href="Home.jsp" class="x">首页</a>| <a href="personal.jsp?user=<%=n%>" class="x">个人中心</a> | <a href="listcart.jsp" class="x">购物车</a> | <a href="save2.jsp" class="x">我的订单</a>|<a href="shop.jsp?shoppname=<%=l%>" class="x">我的店铺</a> | <a href="storectrl.jsp?shoppname=<%=l%>" class="x">店铺后台</a> |<a href="javascript:if (confirm('是否退出登录?')){ window.location.href='logout.jsp';}else{};" class="x">退出登录</a>
		</div>
	<%
	}else if(m.equals("管理员")){
	%>
		<div align="left" class="x">
			<a class="x"><%=n%>,欢迎!</a>| <a href="Home.jsp" class="x">首页</a>| <a href="backstage.jsp" class="x">管理员后台</a>  |<a href="javascript:if (confirm('是否退出登录?')){ window.location.href='logout.jsp';}else{};" class="x">退出登录</a>
		</div>
	<%
	}
%>
