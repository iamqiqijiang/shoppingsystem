<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
    
    <title>结果页面</title>    

  </head>
  
  <body>
  <h1 algin="center"> 结果页面</h1>
  <hr>
      <% String msg = (String)request.getAttribute("MSG"); %>
      <%= msg %>
   <hr>
      <a href="../index.jsp" > 返回</a>
  </body>
</html>