package cn.edu.zhku.jsj.yali.Store.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import cn.edu.zhku.jsj.yali.Goods.Goods;
import cn.edu.zhku.jsj.yali.Util.ConnectionManager;

public class SearchOneDao {
	public ArrayList<Goods> getappointgoodsinfo(String good) throws Exception {
		ArrayList<Goods> list = new ArrayList<Goods>();
		Connection conn = null;
		ResultSet rs = null;
	
		// 连接数据库
		conn = ConnectionManager.getConnection();
		if (conn == null) {
			throw new Exception("数据库连接不成功！");
		}
	
		String sqlQuery = "Select* from goodlist where goodname like '%"+good+"%' or category like '%"+good+"%'";
		Statement stmt=(Statement) conn.createStatement();
		rs =stmt.executeQuery(sqlQuery);
		while(rs.next()){
			Goods goods = new Goods();
			goods.setgoodname(rs.getString("goodname"));
			goods.setPrice((int) rs.getLong("price"));
			goods.setAddress(rs.getString("address"));
			goods.setShop(rs.getString("shop"));
			goods.setSalesvolume((int) rs.getLong("salesvolume"));
			goods.setCategory(rs.getString("category"));
			goods.setId(rs.getString("id"));
			list.add(goods);
		}
		return list;
	}
}
