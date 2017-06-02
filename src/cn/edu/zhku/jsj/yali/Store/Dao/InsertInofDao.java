package cn.edu.zhku.jsj.yali.Store.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import cn.edu.zhku.jsj.yali.User.User;
import cn.edu.zhku.jsj.yali.Util.ConnectionManager;

public class InsertInofDao {

	public boolean insertUserinfo(User user) throws Exception {
		
		Connection conn = null;
		PreparedStatement ps = null;
		int rs ;
		
		// 连接数据库
		conn = ConnectionManager.getConnection();
		
		if (conn == null) {
			throw new Exception("数据库连接不成功！");
		}
		
		String sqlQuery = "update info set shopname=?,introduction=? where name=?";
		
		ps = conn.prepareStatement(sqlQuery);
		
		ps.setString(1, user.getShopname());
		ps.setString(2, user.getIntroduction());
		ps.setString(3, user.getName());
		
		rs = ps.executeUpdate();
		if(rs==1){
			return true;
		}
		return false;
	}

}
