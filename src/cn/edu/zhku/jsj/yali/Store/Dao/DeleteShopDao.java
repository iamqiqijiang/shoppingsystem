package cn.edu.zhku.jsj.yali.Store.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;


import cn.edu.zhku.jsj.yali.Util.ConnectionManager;

public class DeleteShopDao {
public boolean deleShopinfo(String goodname) throws Exception {
		
		Connection conn = null;
		PreparedStatement ps = null;
		int rs ;
		
		// 连接数据库
		conn = ConnectionManager.getConnection();
		
		if (conn == null) {
			throw new Exception("数据库连接不成功！");
		}
		
		String sqlQuery = "delete from goodlist where goodname=?";
		
		ps = conn.prepareStatement(sqlQuery);
		
		
		ps.setString(1, goodname);

		
		rs = ps.executeUpdate();
		if(rs==1){
			return true;
		}
		return false;
	}
}
