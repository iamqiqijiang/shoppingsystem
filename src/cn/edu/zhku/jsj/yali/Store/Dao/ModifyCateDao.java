package cn.edu.zhku.jsj.yali.Store.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import cn.edu.zhku.jsj.yali.Goods.Goods;
import cn.edu.zhku.jsj.yali.Util.ConnectionManager;

public class ModifyCateDao {
	public boolean insertcateinfo(String cate,String shopname,String cate1) throws Exception {
		
		Connection conn = null;
		PreparedStatement ps = null;
		int rs ;

		conn = ConnectionManager.getConnection();
		
		if (conn == null) {
			throw new Exception("数据库连接不成功！");
		}
		
		String sqlQuery = "update category set category=? where shop=? and category=?";
		
		ps = conn.prepareStatement(sqlQuery);
		
		ps.setString(1, cate);
		ps.setString(2, shopname);
		ps.setString(3, cate1);

		rs = ps.executeUpdate();
		if(rs==1){
			return true;
		}
		return false;
	}
}
