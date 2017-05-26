<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<html>
  <head>
  	<style type="text/css">
  		body
	        {
	            margin: 0px;
			}
	</style>
  	<%@ include file="Navigation.jsp" %>
  </head>
  
  <body style="background-image: url(images/white-black.jpg);">
  	<div style="position:absolute; left: 46px; top: 283px;">
	   <h2 align="center">登录</h2>
	   <form action="./servlet/LoginCtrl" method="post">
	     <table align="center">
	   		<tr><td>用户名：</td><td><input type="text" name="username" autocomplete="off"></td></tr>
	   		<tr><td>密码：</td><td><input type="password" name="password" autocomplete="off"></td></tr>
	   		<tr><td colspan="2" align="center"><input type="submit" value="登录"><input type="button" value="注册" onClick="window.location.href='reg.jsp'"></td></tr>
	   	 </table>
	   </form>
   	</div>
  </body>
</html>
