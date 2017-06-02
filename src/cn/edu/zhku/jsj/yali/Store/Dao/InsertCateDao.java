package cn.edu.zhku.jsj.yali.Store.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import cn.edu.zhku.jsj.yali.Goods.Goods;
import cn.edu.zhku.jsj.yali.Util.ConnectionManager;

public class InsertCateDao {
	public boolean insertcateinfo(String cate,String shopname) throws Exception {
		
		Connection conn = null;
		PreparedStatement ps = null;
		int rs ;
		
		// 连接数据库
		conn = ConnectionManager.getConnection();
		
		if (conn == null) {
			throw new Exception("数据库连接不成功！");
		}
		
		String sqlQuery = "insert into category(category,shop) value(?,?)";
		
		ps = conn.prepareStatement(sqlQuery);
		
		ps.setString(1, cate);
		ps.setString(2, shopname);

		
		rs = ps.executeUpdate();
		if(rs==1){
			return true;
		}
		return false;
	}
}
