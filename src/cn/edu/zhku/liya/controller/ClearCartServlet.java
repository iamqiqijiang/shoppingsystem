package cn.edu.zhku.liya.controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.liya.domain.Cart;
import cn.edu.zhku.liya.service.BusinessService;
import cn.edu.zhku.liya.service.BusinessServiceImpl;



/**
 * Servlet implementation class ClearCartServlet
 */
@WebServlet("/ClearCartServlet")
public class ClearCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BusinessService service=new BusinessServiceImpl(); 
    public ClearCartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cart cart=(Cart) request.getSession().getAttribute("cart");
		service.clearCart(cart);
		request.getRequestDispatcher("/listcart.jsp").forward(request,
				response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
