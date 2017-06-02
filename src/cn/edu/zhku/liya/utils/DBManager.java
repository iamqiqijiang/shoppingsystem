package cn.edu.zhku.liya.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBManager {
	
	

	//连接数据库操作
		public static Connection getConn() {
			Connection conn = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "");
			} catch (ClassNotFoundException e) {
				System.out.println("加载失败");
				e.printStackTrace();
			}catch(SQLException e){
				System.out.println("链接失败");
				e.printStackTrace();
			}
			return conn;
		}
		public static int executeSQL(String sql,String[]params){
			int result=0;
			Connection conn=DBManager.getConn();
			PreparedStatement pst=null;
			try {
				pst=conn.prepareStatement(sql);
				if(params!=null){
					for(int i=0;i<params.length;i++){
						pst.setString(i+1, params[i]);
					}
				}
				result=pst.executeUpdate();
			} catch (SQLException e) {
				System.out.println("操作失败");
				e.printStackTrace();
			}finally{
				DBManager.closeAll(conn,pst,null);
			}
			return result;
		}
		public static void closeAll(Connection conn,Statement st,ResultSet rs){
			try {
				if(rs!=null) rs.close();
				if(st!=null) st.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

}

