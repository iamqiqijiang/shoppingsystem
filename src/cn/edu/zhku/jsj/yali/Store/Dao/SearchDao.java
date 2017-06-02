package cn.edu.zhku.jsj.yali.Store.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import cn.edu.zhku.jsj.yali.Goods.Goods;
import cn.edu.zhku.jsj.yali.Util.ConnectionManager;

public class SearchDao {
	public ArrayList<Goods> getappointgoodsinfo(String shoppname,String gooddname) throws Exception {
		ArrayList<Goods> list = new ArrayList<Goods>();
		Connection conn = null;
		ResultSet rs = null;
	
		// 连接数据库
		conn = ConnectionManager.getConnection();
		if (conn == null) {
			throw new Exception("数据库连接不成功！");
		}
	
		String sqlQuery = "Select* from goodlist where shop=? and goodname like '%"+gooddname+"%' or category like '%"+gooddname+"%'";
		PreparedStatement pstmt=conn.prepareStatement(sqlQuery);
		pstmt.setString(1,shoppname);
		rs =pstmt.executeQuery();
		while(rs.next()){
			Goods goods = new Goods();
			goods.setgoodname(rs.getString("goodname"));
			goods.setPrice((int) rs.getLong("price"));
			goods.setAddress(rs.getString("address"));
			goods.setSalesvolume((int) rs.getLong("salesvolume"));
			goods.setId(rs.getString("id"));
			list.add(goods);
		}
		return list;
	}
}
