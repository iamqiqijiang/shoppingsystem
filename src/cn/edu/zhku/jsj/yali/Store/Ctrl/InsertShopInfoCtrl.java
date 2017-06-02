package cn.edu.zhku.jsj.yali.Store.Ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.jsj.yali.Goods.Goods;
import cn.edu.zhku.jsj.yali.Store.Service.InsertShopInfoService;

public class InsertShopInfoCtrl extends HttpServlet {

	InsertShopInfoService isis=new InsertShopInfoService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String goodname = (String)request.getParameter("goodname");
		String address =(String) request.getParameter("address");
		String price =(String) request.getParameter("price");
		String salevol =(String) request.getParameter("salevol");
		String num =(String) request.getParameter("num");
		String shopname =(String) request.getParameter("shopname");
		String category =(String) request.getParameter("category");
		String id =(String) request.getParameter("id");

		int price1=Integer.parseInt(price);
		int salevol1=Integer.parseInt(salevol);
		int num1=Integer.parseInt(num);
		
		Goods good  = new Goods();
		good.setgoodname(goodname);
		good.setAddress(address);
		good.setPrice(price1);
		good.setSalesvolume(salevol1);
		good.setNum(num1);
		good.setShop(shopname);
		good.setCategory(category);
		good.setId(id);
		
		boolean result = false;
		try {
			result=isis.insertshopinfo(good);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int a = 0;
		if(result==true){
			a=1;
		}
		out = response.getWriter();
		out.write(a);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
