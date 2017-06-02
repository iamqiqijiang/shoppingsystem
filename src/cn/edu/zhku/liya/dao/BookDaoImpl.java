package cn.edu.zhku.liya.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import cn.edu.zhku.liya.domain.Book;
import cn.edu.zhku.liya.utils.DBManager;


public class BookDaoImpl implements BookDao{
	@Override
	public Book find(String id) {
		Connection conn = null;
		PreparedStatement pt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConn();
			String sql = "select * from goodlist where id=?";
			pt = conn.prepareStatement(sql);
			
			pt.setString(1, id);
			
			rs = pt.executeQuery();
			//Book b = null;
			if(rs.next()){
				Book b = new Book();
				b.setId(rs.getString("id"));
				b.setGoodname(rs.getString("goodname"));
				b.setPrice(rs.getInt("price"));
				b.setAddress(rs.getString("address"));
				b.setSalesvolume(rs.getInt("salesvolume"));
				b.setShop(rs.getString("shop"));
				b.setNum(rs.getInt("num"));
				b.setCategory(rs.getString("category"));
				return b;
				
			}
			return null;
			

		} catch (Exception e) {
			throw new RuntimeException(e);

		} finally {
			DBManager.closeAll(conn, pt, rs);
		}
	}

	@Override
	public List<Book> getAll() {
		Connection conn = null;
		PreparedStatement pt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConn();
			String sql = "select id,goodname,price,address,salesvolume,shop,num,category from goodlist";
			pt = conn.prepareStatement(sql);
			rs = pt.executeQuery();

			List<Book> list = new ArrayList<Book>();

			while (rs.next()) {
				Book b = new Book();
				b.setId(rs.getString("id"));
				b.setGoodname(rs.getString("goodname"));
				b.setPrice(rs.getInt("price"));
				b.setAddress(rs.getString("address"));
				b.setSalesvolume(rs.getInt("salesvolume"));
				b.setShop(rs.getString("shop"));
				b.setNum(rs.getInt("num"));
				b.setCategory(rs.getString("category"));

				list.add(b);

			}
			return list;

		} catch (Exception e) {
			throw new RuntimeException(e);

		} finally {
			DBManager.closeAll(conn, pt, rs);
		}

	}

}




