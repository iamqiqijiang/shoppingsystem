<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
   <h2 align="center">登录</h2>
   <form action="./servlet/LoginCtrl" method="post">
     <table align="center">
   		<tr><td>用户名：</td><td><input type="text" name="username" autocomplete="off"></td></tr>
   		<tr><td>密码：</td><td><input type="password" name="password" autocomplete="off"></td></tr>
   		<tr><td><input type="submit" value="登录"></td><td><input type="button" value="注册" onclick="window.location.href='reg.jsp'"></td></tr>
   	 </table>
   </form>
  </body>
</html>
