package cn.edu.zhku.jsj.yali.Store.Ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.jsj.yali.Store.Service.SearchCateShopService;

import net.sf.json.JSONArray;


//标签栏点击时搜索相应的商品显示出来
public class SearchCateShopCtrl extends HttpServlet {

	SearchCateShopService scss=new SearchCateShopService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type","text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String shoppname=request.getParameter("shoppname");
		String cate=request.getParameter("cate");
		

		PrintWriter out = null;
		JSONArray list = null;
		try {
			list = scss.getkeeperinfo(shoppname,cate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		out = response.getWriter();
		out.write(list.toString());
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
