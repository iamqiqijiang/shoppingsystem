package cn.edu.zhku.jsj.yali.Store.Ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.jsj.yali.Store.Service.HomeService;

import net.sf.json.JSONArray;


//主页面显示所有商品信息
public class HomeCtrl extends HttpServlet {

	HomeService hs=new HomeService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type","text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = null;
		JSONArray list = null;
		try {
			list = hs.getgoodsinfo();
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
