package cn.edu.zhku.jsj.yali.Store.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import cn.edu.zhku.jsj.yali.Goods.Goods;
import cn.edu.zhku.jsj.yali.Util.ConnectionManager;

public class ModifyShopDao {
	public boolean insertShopinfo(Goods good) throws Exception {
		
		Connection conn = null;
		PreparedStatement ps = null;
		int rs ;
		
		// 连接数据库
		conn = ConnectionManager.getConnection();
		
		if (conn == null) {
			throw new Exception("数据库连接不成功！");
		}
		
		String sqlQuery = "update goodlist set price=?,address=?,salesvolume=?,num=?,category=?,id=? where shop=? and goodname=?";
		
		ps = conn.prepareStatement(sqlQuery);
		
		
		ps.setInt(1, good.getPrice());
		ps.setString(2, good.getAddress());
		ps.setInt(3, good.getSalesvolume());
		ps.setInt(4, good.getNum());
		ps.setString(5, good.getCategory());
		ps.setString(6, good.getId());
		ps.setString(7, good.getShop());
		ps.setString(8, good.getgoodname());
		
		rs = ps.executeUpdate();
		if(rs==1){
			return true;
		}
		return false;
	}
}
