package cn.edu.zhku.jsj.yali.Store.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import cn.edu.zhku.jsj.yali.User.User;
import cn.edu.zhku.jsj.yali.Util.ConnectionManager;

public class ShopInfoDao {
	public ArrayList<User> getshopinfo(String shopname) throws Exception {
		ArrayList<User> list = new ArrayList<User>();
		Connection conn = null;
		ResultSet rs = null;
	
		// 连接数据库
		conn = ConnectionManager.getConnection();
		if (conn == null) {
			throw new Exception("数据库连接不成功！");
		}
	
		String sqlQuery = "Select* from info where shopname=?";
		PreparedStatement pstmt=conn.prepareStatement(sqlQuery);
		pstmt.setString(1,shopname);
		rs =pstmt.executeQuery();
		while(rs.next()){
			User user = new User();
			user.setName(rs.getString("name"));
			user.setShopname(rs.getString("shopname"));
			user.setId(rs.getString("id"));
			user.setIntroduction(rs.getString("introduction"));
			list.add(user);
		}
		return list;
	}
}
