package cn.edu.zhku.jsj.yali.Store.Service;


import cn.edu.zhku.jsj.yali.Store.Dao.DeleteShopDao;

public class DeleteShopService {

	DeleteShopDao dsd=new DeleteShopDao();
	public boolean deleshopinfo(String goodname) throws Exception{
    	boolean result = false;
    	result = dsd.deleShopinfo(goodname);
    	return result;
	}
}
