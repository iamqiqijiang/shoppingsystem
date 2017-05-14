package cn.edu.zhku.jsj.yali.User.Ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import cn.edu.zhku.jsj.yali.User.User;
import cn.edu.zhku.jsj.yali.User.Service.RegService;

public class RegCtrl extends HttpServlet {
	
	RegService rs = new RegService();

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
		String userPassword1 =(String) request.getParameter("password1");
		String sex =(String) request.getParameter("sex");
		String phone =(String) request.getParameter("phone");
		String email =(String) request.getParameter("email");
		String name =(String) request.getParameter("name");
		String province =(String) request.getParameter("province");
		String city =(String) request.getParameter("city");
		String address =(String) request.getParameter("address");
		String addressall =province+city+address;
		String cate =(String) request.getParameter("cate");
		String shopname =(String) request.getParameter("shopname");
		String id =(String) request.getParameter("id");
		
		//打包处理，形成一个user对象，以便于后面传递参数使用
		User user  = new User();
		user.setUsername(userName);
		user.setPassword(userPassword);
		user.setSex(sex);
		user.setPhone(phone);
		user.setEmail(email);
		user.setName(name);
		user.setAddress(addressall);
		user.setCate(cate);
		user.setShopname(shopname);
		user.setId(id);
		
		boolean checkResult = false ;
		String msg = null;
		
		RequestDispatcher rd = null;
		try{
			checkResult =rs.insertinfo(user);
			
			if(checkResult == true){
				msg = "注册成功!";				
			}else{
				msg = "对不起，注册失败";	
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
