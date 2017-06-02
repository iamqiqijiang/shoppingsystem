package cn.edu.zhku.jsj.yali.User.Ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import cn.edu.zhku.jsj.yali.User.Service.LoginService;
import cn.edu.zhku.jsj.yali.User.User;

public class LoginCtrl extends HttpServlet {

	LoginService ls = new LoginService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设定输入编码格式
		request.setCharacterEncoding("utf-8");
		//设定输出编码格式
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
        //		获得jsp页面参数
		String userName = (String)request.getParameter("username");
		String userPassword =(String) request.getParameter("password");
		
		//打包处理，形成一个user对象，以便于后面传递参数使用
		User user  = new User();
		user.setUsername(userName);
		user.setPassword(userPassword);
		
		String msg = null;
		HttpSession session = request.getSession();
		
		RequestDispatcher rd = null;
		try{
			User user1 = ls.checkUserNameAndPassword(user);
			if(user1.getCate().equals("管理员")){
				session.setAttribute("loginusername",userName);
				session.setAttribute("logincate",user1.getCate());
				session.setAttribute("shopname",user1.getShopname());
				JOptionPane.showMessageDialog(null, "管理员登录！");
				response.sendRedirect("/Shoppingsystem/backstage.jsp");
			}else if(user1.getUsername() != null){
				session.setAttribute("loginusername",userName);
				session.setAttribute("logincate",user1.getCate());
				session.setAttribute("shopname",user1.getShopname());
				JOptionPane.showMessageDialog(null, "登陆成功！");
				response.sendRedirect("/Shoppingsystem/Home.jsp");
			}else{
				JOptionPane.showMessageDialog(null, "对不起，用户名或密码不正确！");
				response.sendRedirect("/Shoppingsystem/login.jsp");
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
