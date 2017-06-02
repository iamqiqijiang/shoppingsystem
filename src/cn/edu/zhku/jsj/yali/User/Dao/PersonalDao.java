package cn.edu.zhku.jsj.yali.User.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import cn.edu.zhku.jsj.yali.User.User;
import cn.edu.zhku.jsj.yali.Util.ConnectionManager;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class PersonalDao {

	public ArrayList<User> getuserinfo(String username) throws Exception {
		ArrayList<User> list = new ArrayList<User>();
		Connection conn = null;
		ResultSet rs = null;

	
		// 连接数据库
		conn = ConnectionManager.getConnection();
		if (conn == null) {
			throw new Exception("数据库连接不成功！");
		}
	
		String sqlQuery = "Select* from info where username=?";
		PreparedStatement pstmt=(PreparedStatement) conn.prepareStatement(sqlQuery);
		pstmt.setString(1,username);
		rs =pstmt.executeQuery();
		while(rs.next()){
			User user = new User();
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setSex(rs.getString("sex"));
			user.setCate(rs.getString("cate"));
			user.setName(rs.getString("name"));
			user.setPhone(rs.getString("phone"));
			user.setAddress(rs.getString("address"));
			user.setEmail(rs.getString("email"));
			user.setShopname(rs.getString("shopname"));
			user.setId(rs.getString("id"));
			user.setIntroduction(rs.getString("introduction"));
			user.setMoney(rs.getInt("money"));
			list.add(user);
		}
		return list;
	}
}
