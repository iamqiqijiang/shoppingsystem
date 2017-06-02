package cn.edu.zhku.jsj.yali.User.Service;

import cn.edu.zhku.jsj.yali.Goods.Goods;
import cn.edu.zhku.jsj.yali.User.Dao.StartShopDao;

public class StartShopService {

	StartShopDao ssd=new StartShopDao();
	public boolean insertshopinfo(String username,String shopname,String id,String introduction,String cate) throws Exception{
    	boolean result = false;
    	result = ssd.insertShopinfo(username,shopname,id,introduction,cate);
    	return result;
	}
}
