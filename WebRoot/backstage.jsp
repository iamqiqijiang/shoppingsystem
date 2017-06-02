<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

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
	<script src="jquery.min.js"></script>
	<script language="JavaScript" type="text/javascript">
		$(document).ready(function () {
			  $.ajax({
			    timeout: 3000,
			    async: false,
			    type: "POST",
			    url: "./servlet/BackStageCtrl",
			    //dataType:"json",
			    data: {
			    },
			    success: function (data) {
				    $("#a").empty();
					var d =$.parseJSON(data);
					var html1 ="<table><tr><th colspan='2' width='340px'>账号信息</th></tr><tr><th width='220px'>账号</th><th width='120px'>操作</th></tr></table>" ;
					$("#a").append(html1);
			      	for (var i = 0; i < d.length; i++) {
			       		var html ="<table><tr><td width='220px' align='center'>"+d[i].username+"</td><td width='120px' align='center'><a href='#' onclick='triggera(\""+d[i].username+"\")'>删除</a></td></tr></table>" ;
						$("#a").append(html);
			      }
			    }
			  });
			});
			
		 function triggera(username){
	            $.ajax({
				    timeout: 3000,
				    async: false,
				    type: "POST",
				    url: "./servlet/DeleUserCtrl",
				    //dataType:"json",
				    data: {
				      username: username,
				    },
				    success: function (data) {
					  alert("删除成功！");
					  window.location.reload();
				    }
			  });
	         }
	</script>
  </head>
  
  <body>
    <div class="a" id="a"></div>
  </body>
</html>
