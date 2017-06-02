package cn.edu.zhku.jsj.yali.Store.Ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.jsj.yali.Store.Service.CateSearchService;

import net.sf.json.JSONArray;

//在category表中查找不同店铺的宝贝分类
public class CateSearchCtrl extends HttpServlet {

	CateSearchService css=new CateSearchService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type","text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String shoppname=request.getParameter("shoppname");

		PrintWriter out = null;
		JSONArray list = null;
		try {
			list = css.getappointinfo(shoppname);
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
