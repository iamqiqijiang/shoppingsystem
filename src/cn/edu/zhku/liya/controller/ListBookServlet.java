package cn.edu.zhku.liya.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.liya.domain.Book;
import cn.edu.zhku.liya.service.BusinessService;
import cn.edu.zhku.liya.service.BusinessServiceImpl;


/**
 * Servlet implementation class ListBookServlet
 */
@WebServlet("/ListBookServlet")
public class ListBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BusinessService service = new BusinessServiceImpl();

	public ListBookServlet() {
		super();
	}

	public void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Book> list = service.getAllBook();
		request.setAttribute("books", list);
		request.getRequestDispatcher("/listbook.jsp").forward(request,
				response);
		/*request.getRequestDispatcher("../listbook.jsp").forward(request,
				response);*/
	}

	public void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
