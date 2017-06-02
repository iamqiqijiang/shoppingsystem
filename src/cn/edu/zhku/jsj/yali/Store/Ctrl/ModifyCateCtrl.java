package cn.edu.zhku.jsj.yali.Store.Ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.jsj.yali.Store.Service.ModifyCateService;


//店铺后台宝贝分类信息修改功能
public class ModifyCateCtrl extends HttpServlet {

	ModifyCateService mcs=new ModifyCateService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String shopname =(String) request.getParameter("shop");
		String category =(String) request.getParameter("category");
		String category1 =(String) request.getParameter("category1");

		
		boolean result = false;
		try {
			result=mcs.insertshopinfo(category, shopname,category1);
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
