package cn.edu.zhku.jsj.yali.Store.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import cn.edu.zhku.jsj.yali.Goods.Goods;
import cn.edu.zhku.jsj.yali.Store.CateGory;
import cn.edu.zhku.jsj.yali.Util.ConnectionManager;

public class CateSearchDao {
	public ArrayList<CateGory> getappointgoodsinfo(String shoppname) throws Exception {
		ArrayList<CateGory> list = new ArrayList<CateGory>();
		Connection conn = null;
		ResultSet rs = null;
	
		// 连接数据库
		conn = ConnectionManager.getConnection();
		if (conn == null) {
			throw new Exception("数据库连接不成功！");
		}
	
		String sqlQuery = "Select* from category where shop=?";
		PreparedStatement pstmt=conn.prepareStatement(sqlQuery);
		pstmt.setString(1,shoppname);
		rs =pstmt.executeQuery();
		while(rs.next()){
			CateGory cate=new CateGory();
			cate.setCate(rs.getString("category"));
			list.add(cate);
		}
		return list;
	}
}
