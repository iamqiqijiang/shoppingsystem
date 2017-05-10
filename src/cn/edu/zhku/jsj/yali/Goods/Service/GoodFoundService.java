package cn.edu.zhku.jsj.yali.Goods.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cn.edu.zhku.jsj.yali.Goods.Goods;
import cn.edu.zhku.jsj.yali.Goods.PageBean;
import cn.edu.zhku.jsj.yali.Goods.Dao.GoodFoundDao;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class GoodFoundService {
	
	GoodFoundDao gfd=new GoodFoundDao();
	
	public PageBean<Goods> queryAll(PageBean<Goods> page,String pcName){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from goodlist where goodname=?";
		int currentPage = page.getCurrentPage();
		int pageSize = page.getPageSize();
		int startRow = (currentPage-1)*pageSize;
		List<Goods> dataList = new ArrayList<Goods>();
		try {
			conn = (Connection) gfd.getConn();
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, pcName);
			rs = (ResultSet) ps.executeQuery();
			int reg = 1;
			while (rs.next() && reg <= (startRow + pageSize)) {
				
				if (reg > startRow) {
					Goods good = new Goods();
					good.setgoodname(rs.getString("goodname"));
					good.setPrice(rs.getInt("price"));
					good.setAddress(rs.getString("address"));
					good.setSalesvolume(rs.getInt("salesvolume"));
					good.setShop(rs.getString("shop"));
					good.setNum(rs.getInt("num"));
					good.setCategory(rs.getString("category"));
					dataList.add(good);
				}
				reg++;
				
			}
			page.setDataList(dataList);
			int count = this.getCount(pcName);
			page.setRecordCount(count);
			page.setPageCount(count);		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return page;
	}
	public int getCount(String goodName){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select count(*) from goodlist where goodname=?";
		int count = 0;
		try {
			conn = (Connection) gfd.getConn();
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, goodName);
			rs = (ResultSet) ps.executeQuery();
			while(rs.next()){
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public static void controller(Goods good,PageBean<Goods> page,HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		
		GoodFoundService action = new GoodFoundService();
		PageBean<Goods> pageBean = action.queryAll(page,good.getgoodname());

		req.setAttribute("page", pageBean);
		req.setAttribute("computer", good);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
		dispatcher.forward(req, resp);
	}
}


