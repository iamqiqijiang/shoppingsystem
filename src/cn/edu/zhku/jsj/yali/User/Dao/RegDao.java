package cn.edu.zhku.jsj.yali.User.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import cn.edu.zhku.jsj.yali.Util.ConnectionManager;
import cn.edu.zhku.jsj.yali.User.User;

public class RegDao {
	public boolean insertUserinfo(User user) throws Exception {
		User newUser = new User();
		
		Connection conn = null;
		PreparedStatement ps = null;
		int rs ;
		
		// 连接数据库
		conn = ConnectionManager.getConnection();
		
		if (conn == null) {
			throw new Exception("数据库连接不成功！");
		}
		
		String sqlQuery = "insert into info(username, password,sex,phone,email,name,address,cate,shopname,id) value(?,?,?,?,?,?,?,?,?,?)";
		
		ps = conn.prepareStatement(sqlQuery);
		
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getSex());
		ps.setString(4, user.getPhone());
		ps.setString(5, user.getEmail());
		ps.setString(6, user.getName());
		ps.setString(7, user.getAddress());
		ps.setString(8, user.getCate());
		ps.setString(9, user.getShopname());
		ps.setString(10, user.getId());
		
		rs = ps.executeUpdate();
		if(rs==1){
			return true;
		}
		return false;
	}
}
