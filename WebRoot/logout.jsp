<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
                                                       <!-- 退出登录 -->
<% 
	session.invalidate();
	out.println("<script>alert(\"退出成功！\");</script>");
	response.setHeader("Refresh","0.1;url=Home.jsp");
%>