package cn.edu.zhku.jsj.yali.Filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.jsj.yali.Util.ConnectionManager;

public class ShopkeeperFilter implements Filter {

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
			HttpServletRequest request = (HttpServletRequest)arg0;  
		    HttpServletResponse response = (HttpServletResponse)arg1; 
		    String shoppname=request.getParameter("shoppname");
		    String shopkeeper = null;
		    try {
				shopkeeper=getshopkeeperinfo(shoppname);
			} catch (Exception e) {
				e.printStackTrace();
			}
		    request.setAttribute("shopkeeper",shopkeeper);
		    arg2.doFilter(request,response);
	}
	public String getshopkeeperinfo(String shoppname) throws Exception {
		Connection conn = null;
		ResultSet rs = null;
		String shopkeeper=null;
		
		// 连接数据库
		conn = ConnectionManager.getConnection();
		if (conn == null) {
			throw new Exception("数据库连接不成功！");
		}
		String sqlQuery = "Select* from info where shopname=?";
		PreparedStatement pstmt=conn.prepareStatement(sqlQuery);
		
		pstmt.setString(1,shoppname);
		rs =pstmt.executeQuery();
		boolean result = rs.next();

		if (result == true) {
			shopkeeper=rs.getString("name");
			}
		return shopkeeper;
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	public void destroy() {
		// TODO Auto-generated method stub

	}
}
