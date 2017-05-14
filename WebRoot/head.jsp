<%
	String n=(String)session.getAttribute("loginusername");
	if(n==null){
	%>
		<div align="center">
		<a href="login.jsp">登录</a> | <a href="reg.jsp">注册</a>
		</div>
	<% 
	}else{
	%>
		<div align="center">
		<a class="f"><%=n%></a> | <a href="show_1.jsp">管理</a> | <a href="logout.jsp">退出登录</a>
		</div>
	<%
	}
%>
