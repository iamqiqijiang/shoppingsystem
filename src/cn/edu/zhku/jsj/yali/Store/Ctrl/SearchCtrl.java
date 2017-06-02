package cn.edu.zhku.jsj.yali.Store.Ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.edu.zhku.jsj.yali.Store.Service.SearchService;


import net.sf.json.JSONArray;

//店铺内实现模糊查询商品
public class SearchCtrl extends HttpServlet {

	SearchService ss=new SearchService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type","text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String shoppname=request.getParameter("shoppname");
		String gooddname=request.getParameter("gooddname");
		PrintWriter out = null;
		JSONArray list = null;
		try {
			list = ss.getappointinfo(shoppname,gooddname);
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
