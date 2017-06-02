package cn.edu.zhku.jsj.yali.User.Ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.jsj.yali.User.Service.ModifyPassService;

public class ModifyPassCtrl extends HttpServlet {

	ModifyPassService mps=new ModifyPassService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String ps1 =(String) request.getParameter("ps1");
		String username =(String) request.getParameter("username");
		String ps2 =(String) request.getParameter("ps2");

		
		boolean result = false;
		try {
			result=mps.insertshopinfo(ps1,username,ps2);
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
