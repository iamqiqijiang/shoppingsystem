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
 * Servlet implementation class DeleteItemServlet
 */
@WebServlet("/DeleteItemServlet")
public class DeleteItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//调服务类里边的方法从购物项里删除想要删除的书
		BusinessService service=new BusinessServiceImpl();
    public DeleteItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取到购物项
				String sid=request.getParameter("id");
				Cart cart=(Cart)request.getSession().getAttribute("cart");
				
				
				service.deleteCartItem(sid,cart);
				request.getRequestDispatcher("/listcart.jsp").forward(request,
						response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
