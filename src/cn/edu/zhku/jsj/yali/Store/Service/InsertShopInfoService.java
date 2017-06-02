package cn.edu.zhku.jsj.yali.Store.Service;

import cn.edu.zhku.jsj.yali.Goods.Goods;
import cn.edu.zhku.jsj.yali.Store.Dao.InsertShopInfoDao;


public class InsertShopInfoService {
	
	InsertShopInfoDao isi=new InsertShopInfoDao();
	public boolean insertshopinfo(Goods good) throws Exception{
    	boolean result = false;
    	result = isi.insertShopinfo(good);
    	return result;
	}
}
