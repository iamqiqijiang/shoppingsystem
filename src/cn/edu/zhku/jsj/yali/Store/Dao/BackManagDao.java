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
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		// 连接数据库
		conn = ConnectionManager.getConnection();

		if (conn == null) {
			throw new Exception("数据库连接不成功！");
		}

		String sqlQuery = "Select* from goodlist where num=?";
		
		PreparedStatement pstmt=conn.prepareStatement(sqlQuery);
    	pstmt.setString(1,"10");
    	rs =pstmt.executeQuery();
		
		while(rs.next()){
			Goods goods = new Goods();
			goods.setgoodname(rs.getString("goodname"));
			goods.setPrice((int) rs.getLong("price"));
			goods.setAddress(rs.getString("address"));
			goods.setSalesvolume((int) rs.getLong("salesvolume"));
			goods.setShop(rs.getString("shop"));
			goods.setNum((int) rs.getLong("num"));
			goods.setCategory(rs.getString("category"));
			list.add(goods);
		}
		return list;
	}
}
