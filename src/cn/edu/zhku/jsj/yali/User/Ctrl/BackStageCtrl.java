package cn.edu.zhku.jsj.yali.User.Ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.jsj.yali.User.Service.BackStageService;

import net.sf.json.JSONArray;

public class BackStageCtrl extends HttpServlet {

	BackStageService bss=new BackStageService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type","text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = null;
		JSONArray list = null;
		try {
			list = bss.getshopinfo();
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
