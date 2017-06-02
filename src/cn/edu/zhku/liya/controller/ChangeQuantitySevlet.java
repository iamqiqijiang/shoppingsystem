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
 * Servlet implementation class ChangeQuantitySevlet
 */
@WebServlet("/ChangeQuantitySevlet")
public class ChangeQuantitySevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ChangeQuantitySevlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("id");
		String quantity = request.getParameter("quantity");
		Cart cart = (Cart) request.getSession().getAttribute("cart");

		System.out.println(sid);
		System.out.println(quantity);
		System.out.println(cart);
		BusinessService service = new BusinessServiceImpl();
		service.changeQuantity(sid,quantity,cart);
		request.getRequestDispatcher("/listcart.jsp")
				.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
