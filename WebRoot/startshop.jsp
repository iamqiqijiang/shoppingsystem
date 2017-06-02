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
	   <h2 align="center">我要开店！！！！</h2>
	   <form action="./servlet/StartShopCtrl" method="post">
	     <table align="center">
	   		<tr><td>店铺名：</td><td><input type="text" name="shopname" autocomplete="off"></td></tr>
	   		<tr><td>身份证号：</td><td><input type="text" name="id" autocomplete="off"></td></tr>
	   		<tr><td>店铺简介：</td><td><textarea name="into"></textarea></td></tr>
	   		<tr><td colspan="2" align="center"><input type="submit" value="开店"></td></tr>
	   	 </table>
	   </form>
   	</div>
  </body>
</html>
