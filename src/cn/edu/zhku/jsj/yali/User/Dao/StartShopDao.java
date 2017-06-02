package cn.edu.zhku.jsj.yali.User.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import cn.edu.zhku.jsj.yali.Goods.Goods;
import cn.edu.zhku.jsj.yali.Util.ConnectionManager;

public class StartShopDao {
public boolean insertShopinfo(String username,String shopname,String id,String introduction,String cate) throws Exception {
		
		Connection conn = null;
		PreparedStatement ps = null;
		int rs ;
		
		// 连接数据库
		conn = ConnectionManager.getConnection();
		
		if (conn == null) {
			throw new Exception("数据库连接不成功！");
		}
		
		String sqlQuery = "update info set shopname=?,id=?,introduction=?,cate=? where username=?";
		
		ps = conn.prepareStatement(sqlQuery);
		
		ps.setString(1, shopname);
		ps.setString(2, id);
		ps.setString(3, introduction);
		ps.setString(4, cate);
		ps.setString(5, username);
		
		rs = ps.executeUpdate();
		if(rs==1){
			return true;
		}
		return false;
	}
}
