package cn.edu.zhku.jsj.yali.User.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.ResultSet;

import cn.edu.zhku.jsj.yali.Util.ConnectionManager;

public class RechargeDao {
	public boolean insertcateinfo(String username,int money) throws Exception {
		RechargeDao rd=new RechargeDao();
		Connection conn = null;
		PreparedStatement ps = null;
		int rs ;

		conn = ConnectionManager.getConnection();
		
		int money1=rd.getmoney(username);
		int money2=money+money1;
		
		if (conn == null) {
			throw new Exception("数据库连接不成功！");
		}
		
		String sqlQuery = "update info set money=? where username=?";
		ps = conn.prepareStatement(sqlQuery);
		
		ps.setInt(1, money2);
		ps.setString(2, username);

		rs = ps.executeUpdate();
		if(rs==1){
			return true;
		}
		return false;
	}
	
	public int getmoney(String username) throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs ;
		int money = 0;
		
		conn = ConnectionManager.getConnection();
		if (conn == null) {
			throw new Exception("数据库连接不成功！");
		}
		
		String sqlQuery = "select * from info where username=?";
		
		ps = conn.prepareStatement(sqlQuery);
		ps.setString(1, username);

		rs = (ResultSet) ps.executeQuery();
		if(rs.next()){
			money = rs.getInt("money");
		}
		return money;
		
	}
	
}
