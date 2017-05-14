package cn.edu.zhku.jsj.yali.Store.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import cn.edu.zhku.jsj.yali.Goods.Goods;
import cn.edu.zhku.jsj.yali.User.User;
import cn.edu.zhku.jsj.yali.Util.ConnectionManager;

public class BackManagDao {
	public ArrayList<Goods> getshopinfo() throws Exception {
		ArrayList<Goods> list = new ArrayList<Goods>();
		Goods goods = new Goods();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		// 连接数据库
		conn = ConnectionManager.getConnection();

		if (conn == null) {
			throw new Exception("数据库连接不成功！");
		}

		String sqlQuery = "Select* from goodlist";
		Statement stmt=(Statement) conn.createStatement();
		rs = stmt.executeQuery(sqlQuery);
		
		while(rs.next()){
			goods.setgoodname(rs.getString("goodname"));
			goods.setPrice(rs.getInt("price"));
			goods.setAddress(rs.getString("address"));
			goods.setSalesvolume(rs.getInt("salesvolume"));
			goods.setShop(rs.getString("shop"));
			goods.setNum(rs.getInt("num"));
			goods.setCategory(rs.getString("category"));
			list.add(goods);
		}
		return list;
	}
}
