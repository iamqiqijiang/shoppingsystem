package cn.edu.zhku.jsj.yali.Goods.Ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import junit.framework.Test;

import cn.edu.zhku.jsj.yali.Goods.Goods;
import cn.edu.zhku.jsj.yali.Goods.PageBean;
import cn.edu.zhku.jsj.yali.Goods.Service.GoodFoundService;
import cn.edu.zhku.jsj.yali.User.User;



public class GoodFoundCtrl extends HttpServlet {

	GoodFoundService gds = new GoodFoundService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PageBean<Goods> pageBean = new PageBean<Goods>();
		IPageHlep pageHelp =  new PageHlepImpl();
		Goods good = new Goods();
		
		int currentPage = pageHelp.getCurrentPage(request.getParameter("currentPage"));
		int pageSize = pageHelp.getPageSize(request.getParameter("pageSize"), 5);
		String pcName = request.getParameter("pcName");
		
		/*System.out.println(DateUtils.getDefaultDate() + " : currentPage="
				+ currentPage + ",pageSize=" + pageSize
				+ ",pcName=" + pcName);*/

		good.setgoodname(pcName);
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(pageSize);
		
		gds.controller(good,pageBean,request, response);
	}



	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doGet(request, response);
	}

}
