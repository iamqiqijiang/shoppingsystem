package cn.edu.zhku.jsj.yali.Store.Service;

import cn.edu.zhku.jsj.yali.Goods.Goods;
import cn.edu.zhku.jsj.yali.Store.Dao.ModifyShopDao;

public class ModifyShopService {

	ModifyShopDao msd=new ModifyShopDao();
	public boolean insertshopinfo(Goods good) throws Exception{
    	boolean result = false;
    	result = msd.insertShopinfo(good);
    	return result;
	}
}
