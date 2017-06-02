package cn.edu.zhku.liya.controller;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.liya.domain.Book;
import cn.edu.zhku.liya.domain.Cart;
import cn.edu.zhku.liya.service.BusinessServiceImpl;


/**
 * Servlet implementation class BuyServlet
 */
@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BusinessServiceImpl service=new BusinessServiceImpl();
    public BuyServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取要买的书
				String sid=request.getParameter("id");
				Book book =service.findBook(sid);
				//2.得到购物车
				Cart cart=(Cart)request.getSession().getAttribute("cart");
				if(cart==null){
					cart=new Cart();
					request.getSession().setAttribute("cart", cart);
				}
				//3.把数添加到购物车中
				cart.add(book);
				response.sendRedirect("./ListCartServlet");
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
