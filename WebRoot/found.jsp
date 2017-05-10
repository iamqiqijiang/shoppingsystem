<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  
  	<ul>
		<c:forEach items="${tests}" var="p">
			<li>用户名：${p.username}</li>
		</c:forEach>
		
	</ul>

	<c:if test="${param.cur == 1}">
		<a>首页</a>
		<a>上一页</a>
	</c:if>
	
	<c:if test="${param.cur != 1}">
		<a href="GoodFoundCtrl?cur=1">首页</a>
		<a href="GoodFoundCtrl?cur=${param.cur - 1}">上一页</a>
	</c:if>
	
	<c:if test="${param.cur == requestScope.totalPage}">
		<a>下一页</a>
		<a>尾页</a>
	</c:if>
	
	<c:if test="${param.cur != requestScope.totalPage}">
		<a href="GoodFoundCtrl?cur=${param.cur + 1}">下一页</a>
		<a href="GoodFoundCtrl?cur=${requestScope.totalPage}">尾页</a>
	</c:if>
	
	<p>
		当前第${param.cur}页       总共${requestScope.totalPage}页
	</p>
  
  </body>
</html>
