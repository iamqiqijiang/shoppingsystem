package cn.edu.zhku.liya.ui;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListCartServlet
 */
@WebServlet("/ListCartServlet")
public class ListCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ListCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/listcart.jsp").forward(request,
				response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}

