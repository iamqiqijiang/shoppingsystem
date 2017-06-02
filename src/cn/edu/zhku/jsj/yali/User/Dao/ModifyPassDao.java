package cn.edu.zhku.jsj.yali.User.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import cn.edu.zhku.jsj.yali.Util.ConnectionManager;

public class ModifyPassDao {
	public boolean insertcateinfo(String ps1,String username,String ps2) throws Exception {
		
		Connection conn = null;
		PreparedStatement ps = null;
		int rs ;

		conn = ConnectionManager.getConnection();
		
		if (conn == null) {
			throw new Exception("数据库连接不成功！");
		}
		
		String sqlQuery = "update info set password=? where username=? and password=?";
		
		ps = conn.prepareStatement(sqlQuery);
		
		ps.setString(1, ps2);
		ps.setString(2, username);
		ps.setString(3, ps1);

		rs = ps.executeUpdate();
		if(rs==1){
			return true;
		}
		return false;
	}
}
