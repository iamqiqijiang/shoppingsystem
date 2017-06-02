package cn.edu.zhku.jsj.yali.Store.Ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.jsj.yali.Store.Service.DeleCateService;

public class DeleCateCtrl extends HttpServlet {

	DeleCateService dcs=new DeleCateService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String cate = (String)request.getParameter("cate");

		boolean result = false;
		try {
			result=dcs.delecateinfo(cate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int a = 0;
		if(result==true){
			a=1;
		}
		out = response.getWriter();
		out.write(a);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
