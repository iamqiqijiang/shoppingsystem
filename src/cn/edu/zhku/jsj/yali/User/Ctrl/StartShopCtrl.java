package cn.edu.zhku.jsj.yali.User.Ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import cn.edu.zhku.jsj.yali.Goods.Goods;
import cn.edu.zhku.jsj.yali.User.Service.StartShopService;

//开店功能
public class StartShopCtrl extends HttpServlet {

	StartShopService sss=new StartShopService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String shopname = (String)request.getParameter("shopname");
		String id =(String) request.getParameter("id");
		HttpSession session=request.getSession();
		String username =(String) session.getAttribute("loginusername");
		String introduction =(String) request.getParameter("into");
		String cate="店主";
		
		boolean result = false;
		try {
			result=sss.insertshopinfo(username,shopname,id,introduction,cate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "开店成功，恭喜你成为一名伟大的店主！");
		response.sendRedirect("/Shoppingsystem/personal.jsp?user="+username);
		session.setAttribute("logincate",cate);
		session.setAttribute("shopname",shopname);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
