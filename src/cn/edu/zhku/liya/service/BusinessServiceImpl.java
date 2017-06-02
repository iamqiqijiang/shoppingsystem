package cn.edu.zhku.liya.service;


import java.util.List;

import cn.edu.zhku.liya.dao.BookDao;
import cn.edu.zhku.liya.dao.BookDaoImpl;
import cn.edu.zhku.liya.domain.Book;
import cn.edu.zhku.liya.domain.Cart;
import cn.edu.zhku.liya.domain.CartItem;



public class BusinessServiceImpl implements BusinessService {

	BookDao dao=new BookDaoImpl();
	@Override
	public List<Book> getAllBook() {
		
		return dao.getAll();
	}
	
	
	@Override
	public void deleteCartItem(String sid, Cart cart) {
		
		cart.getMap().remove(sid);
	}


	@Override
	public Book findBook(String id) {
		
		return dao.find(id);
	}


	@Override
	public void clearCart(Cart cart) {
		cart.getMap().clear();
		
	}


	@Override
	public void changeQuantity(String sid, String quantity, Cart cart) {
		CartItem item=cart.getMap().get(sid);
		item.setQuantity(Integer.parseInt(quantity));
		
	}
	
	

}
