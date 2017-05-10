<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="common.jsp" %>
<%@ page import="cn.edu.zhku.jsj.yali.Goods.PageBean" %>
<%@ page import="cn.edu.zhku.jsj.yali.Goods.Goods" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<script type="text/javascript" src="common_js/jquery-1.5.1.js"></script>
<script type="text/javascript" src="js/js_index.js"></script>
<style type="text/css">
body {
    margin: 0px auto;
    padding: 0px;
    text-align:center;
    width:80%;
	height:80%;
}
body{
	font-family:Verdana,Arial,Helvetica,sans-serif;
	font-size:16px;
}
#container{
	width:100%;
	height:100%;
}
#queryDiv{
	text-align:left;
	margin-top:20px;
	margin-bottom:20px;
}
#tableDiv{
	/**border:1px solid #4d9ab0;*/
	/**height:306px;*/
	padding:0;
	border:1px solid #4d9ab0;
	/**background-color:#f0f0fe;*/
}
#dataGridDiv{
	/**height:275px;*/
}
#pageToolBarDiv{
	/**background:#CCCCCC url(images/th.gif) repeat-x scroll 50% 50%;*/
	background-color:rgb(239,246,255);
	margin: 5px auto;
    padding: 0;
    width:100%;
    height:25px;
	text-align:right;
}
/**----------table-------------- */
.table_comm{
    margin: 0 auto;
    padding: 0;
    width:100%;
	/**height:80%;
  	border: 2px solid #4d9ab0;*/
  	/**border-collapse: collapse;*/
  	border-spacing:0px;
  	border-collapse: collapse;
  	text-align: center;
}
.table_comm thead tr{
	background: #CCCCCC url(images/th.gif) repeat-x scroll 50% 50%;
	height:30px;
}
.table_comm td{
	padding:5px;
   	height:30px;
   	border:1px solid #EEEEEE;
   	border-bottom:1px solid #CCCCCC;
   	/**border-right:1px solid #4d9ab0;*/
}
.table_comm thead tr th{
	/**border-right:1px solid #4d9ab0;
   	border-bottom:1px solid #4d9ab0;*/
   	border:1px solid #EEEEEE;
   	padding:5px;
}
.trcolor{
	background-color: rgb(229,236,245);
}

/**----------table end-------------- */

.hidBtn{
	background-color:#ffffff;
	border:1px solid #B7D8EE;
}
.inputText{
	text-align:center;
}
#pageToolBarDiv a{
	text-decoration:none;
	border:1px solid #B7D8EE;
	color:#0030CE;
	font-weight:bold;
	padding:2px 2px;
}
#pageToolBarDiv a:hover{
	background-color:#D2EAF6;
	boder:1px solid #B7D8EE;
	color:#0066A7;
}
#pageToolBarDiv a:visited{
	background-color:#D2EAF6;
	boder:1px solid #B7D8EE;
	color:#0066A7;
}
#pageToolBarDiv a:link{
	border:1px solid #B7D8EE;
	color:#0030CE;
}
</style>
</head>
  
<body onload="inintTable()">
<div id="container">
  <div id="content">
  	<div id="queryDiv">
  		<form id="form1" action="page.do?currentPage=1&pageSize=${page.pageSize}" method="post">
  			<fieldset>
  			<legend><label>查询</label></legend>
  			<span>型号:</span>
  			<input type="text" id="pcName" name="pcName" value="${computer.pcName}"/>
  			<input type="submit" id="submit" value="submit" />
  			</fieldset>
  		</form>
  	</div>
   	<div id="tableDiv">
   		<div id="dataGridDiv">
   		<table class="table_comm" id="tableId">
   			
   			<thead>
	   		<tr>
		   		<th>goodname</th>
		   		<th>price</th>
		   		<th>address</th>
		   		<th>salev</th>
		   		<th>shop</th>
		   		<th>num</th>
		   		<th>cate</th>
	   		</tr>
   			</thead>
   			<tbody>
   			<!-- 
   			<c:forEach var="datalist" items="${page.dataList}">
   				<tr>
   					<td>${datalist.seqid}</td>
   					<td>${datalist.pcName}</td>
   					<td>${datalist.productDate}</td>
   					<td>${datalist.price}</td>
   					<td>${datalist.pcNumber}</td>
   				</tr>
   			</c:forEach>
   			 -->
   			<%
   			PageBean<Goods> pageBean = (PageBean<Goods>)request.getAttribute("page");
   			if(pageBean!=null){
   			List<Goods> list = pageBean.getDataList();
   			int len = list.size()>pageBean.getPageSize()?list.size():pageBean.getPageSize();
   			System.out.println("len = "+len);
   			for(int i=0;i<list.size();i++){
   			%>
   			<tr>
   				<td><%=list.get(i).getgoodname()%></td>
   				<td><%=list.get(i).getPrice()%></td>
   				<td><%=list.get(i).getAddress()%></td>
   				<td><%=list.get(i).getSalesvolume()%></td>
   				<td><%=list.get(i).getShop()%></td>
   				<td><%=list.get(i).getNum()%></td>
   				<td><%=list.get(i).getCategory()%></td>
   			</tr>
   			<%
   			}//end for
   			if(len>list.size()){
   				for(int t=0;t<len-list.size();t++){
   					System.out.println("t = "+t);
   					%>
   		   			<tr>
   		   				<td></td>
   		   				<td></td>
   		   				<td></td>
   		   				<td></td>
   		   				<td></td>
   		   			</tr>
   		   			<%
   				}
   			}
   			}else{
   			for(int j=0;j<4;j++){
   			%>
   			<tr>
   				<td></td>
   				<td></td>
   				<td></td>
   				<td></td>
   				<td></td>
   			</tr>
   			<%
   			}}
   			%>
   			
   			</tbody>
   		</table>
   		</div><!-- dataGridDiv end -->
   		<div id="pageToolBarDiv">
   			<span>共</span>
   			<input type="text" id="pageCount" class="inputText" size="1"
	value="${page.pageCount}" disabled="disabled">
			<span>页</span>
   			<span>每页</span>
   			<input type="text" id="pageSize" class="inputText" size="1"
	value="${page.pageSize}" />
			<span>条</span>
   			<span>共</span>
   			<input type="text" id="recordCount" class="inputText" size="1"
	value="${page.recordCount}" disabled="disabled" />
			<span>记录;</span>
   			
   			<a id="firstPage" href="#">首页</a>
   			<a id="previousPage" href="#">前一页</a>
   			<span>第</span>
   			<input type="text" id="currentPage" class="inputText" size="1"
	value="${page.currentPage}" /> <span>页</span>
   			<input id="goPage" class="hidBtn" type="button" value="go"/>
   			<a id="nextPage" href="#">后一页</a>
   			<a id="endPage" href="#">末页</a>

   		</div><!-- pageToolBarDiv end -->
   	</div><!-- tableDiv end -->
  </div><!-- content end -->
  <div id="clean"></div>
</div><!-- container end -->
<script type="text/javascript">
senfe("tableId","#f8fbfc","#e5f1f4","#ecfbd4","#bce774");
</script>
</body>
</html>
