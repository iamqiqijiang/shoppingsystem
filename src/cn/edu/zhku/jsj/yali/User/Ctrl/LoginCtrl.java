package cn.edu.zhku.jsj.yali.User.Ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		boolean checkResult = false ;
		String msg = null;
		
		RequestDispatcher rd = null;
		try{
			checkResult = ls.checkUserNameAndPassword(user);
			
			if(checkResult == true){
				msg = "恭喜你，欢迎"+userName+"光临!";				
			}else{
				msg = "对不起，用户名或者密码不正确";	
				System.out.println(msg);
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			rd = request.getRequestDispatcher("/result.jsp");
			request.setAttribute("MSG", msg);
			rd.forward(request, response);
			
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
