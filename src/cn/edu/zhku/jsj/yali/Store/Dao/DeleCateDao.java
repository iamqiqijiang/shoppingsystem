package cn.edu.zhku.jsj.yali.Store.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import cn.edu.zhku.jsj.yali.Util.ConnectionManager;

public class DeleCateDao {
public boolean delecateinfo(String cate) throws Exception {
		
		Connection conn = null;
		PreparedStatement ps = null;
		int rs ;
		
		// 连接数据库
		conn = ConnectionManager.getConnection();
		
		if (conn == null) {
			throw new Exception("数据库连接不成功！");
		}
		
		String sqlQuery = "delete from category where category=?";
		
		ps = conn.prepareStatement(sqlQuery);
		
		ps.setString(1, cate);

		
		rs = ps.executeUpdate();
		if(rs==1){
			return true;
		}
		return false;
	}
}
