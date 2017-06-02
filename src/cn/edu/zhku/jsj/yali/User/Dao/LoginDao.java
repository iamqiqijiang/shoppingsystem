package cn.edu.zhku.jsj.yali.User.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.edu.zhku.jsj.yali.Util.ConnectionManager;
import cn.edu.zhku.jsj.yali.User.User;

public class LoginDao {
	public User getUserByName(User user) throws Exception {
		User newUser = new User();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		// 连接数据库
		conn = ConnectionManager.getConnection();

		if (conn == null) {
			throw new Exception("数据库连接不成功！");
		}

		String sqlQuery = "Select username,password,cate,shopname from info where username = ? && password = ?";
		
		ps = conn.prepareStatement(sqlQuery);

		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());

		rs = ps.executeQuery();
		
		boolean result = rs.next();

		if (result == true) {
			String userName = rs.getString("username");
			String userPassword = rs.getString("password");
			String cate = rs.getString("cate");
			String shop = rs.getString("shopname");
			newUser.setUsername(userName);
			newUser.setPassword(userPassword);
			newUser.setCate(cate);
			newUser.setShopname(shop);
		}
		return newUser;
	}
}
