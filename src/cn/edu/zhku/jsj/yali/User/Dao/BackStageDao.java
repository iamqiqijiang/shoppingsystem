package cn.edu.zhku.jsj.yali.User.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import cn.edu.zhku.jsj.yali.Goods.Goods;
import cn.edu.zhku.jsj.yali.User.User;
import cn.edu.zhku.jsj.yali.Util.ConnectionManager;

public class BackStageDao {
	public ArrayList<User> getgoodsinfo() throws Exception {
		ArrayList<User> list = new ArrayList<User>();
		Connection conn = null;
		ResultSet rs = null;
	
		// 连接数据库
		conn = ConnectionManager.getConnection();
		if (conn == null) {
			throw new Exception("数据库连接不成功！");
		}
	
		String sqlQuery = "Select* from info";
		Statement stmt=(Statement) conn.createStatement();
		rs =stmt.executeQuery(sqlQuery);
		while(rs.next()){
			User user = new User();
			user.setUsername(rs.getString("username"));
			list.add(user);
		}
		return list;
	}
}
