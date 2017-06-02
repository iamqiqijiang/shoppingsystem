package cn.edu.zhku.jsj.yali.Store.Ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.jsj.yali.Store.Service.InsertInofService;
import cn.edu.zhku.jsj.yali.User.User;


//
public class InsertInofCtrl extends HttpServlet {

	InsertInofService iis=new InsertInofService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				
				String name = (String)request.getParameter("name");
				String shopname =(String) request.getParameter("shopname");
				String id =(String) request.getParameter("id");
				String introduction =(String) request.getParameter("introduction");

				
				User user  = new User();
				user.setName(name);
				user.setShopname(shopname);
				user.setId(id);
				user.setIntroduction(introduction);
				boolean result = false;
				try {
					result=iis.insertinfo(user);
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
