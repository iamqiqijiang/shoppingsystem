package cn.edu.zhku.jsj.yali.Store.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import cn.edu.zhku.jsj.yali.Goods.Goods;
import cn.edu.zhku.jsj.yali.Util.ConnectionManager;

public class InsertShopInfoDao {
	public boolean insertShopinfo(Goods good) throws Exception {
		
		Connection conn = null;
		PreparedStatement ps = null;
		int rs ;
		
		// 连接数据库
		conn = ConnectionManager.getConnection();
		
		if (conn == null) {
			throw new Exception("数据库连接不成功！");
		}
		
		String sqlQuery = "insert into goodlist(goodname, price,address,salesvolume,shop,num,category,id) value(?,?,?,?,?,?,?,?)";
		
		ps = conn.prepareStatement(sqlQuery);
		
		ps.setString(1, good.getgoodname());
		ps.setInt(2, good.getPrice());
		ps.setString(3, good.getAddress());
		ps.setInt(4, good.getSalesvolume());
		ps.setString(5, good.getShop());
		ps.setInt(6, good.getNum());
		ps.setString(7, good.getCategory());
		ps.setString(8, good.getId());
		
		rs = ps.executeUpdate();
		if(rs==1){
			return true;
		}
		return false;
	}
}
