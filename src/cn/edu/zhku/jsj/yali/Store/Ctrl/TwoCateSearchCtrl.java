package cn.edu.zhku.jsj.yali.Store.Ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.jsj.yali.Store.Service.TwoCateSearchService;

import net.sf.json.JSONArray;

public class TwoCateSearchCtrl extends HttpServlet {

	TwoCateSearchService tcss=new TwoCateSearchService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type","text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String cate1=request.getParameter("cate1");
		String cate2=request.getParameter("cate2");
		
		PrintWriter out = null;
		JSONArray list = null;
		try {
			list = tcss.getgoodsinfo(cate1,cate2);
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
