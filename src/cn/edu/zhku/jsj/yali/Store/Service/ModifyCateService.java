package cn.edu.zhku.jsj.yali.Store.Service;


import cn.edu.zhku.jsj.yali.Store.Dao.ModifyCateDao;

public class ModifyCateService {

	ModifyCateDao mcd=new ModifyCateDao();
	public boolean insertshopinfo(String cate,String shopname,String cate1) throws Exception{
    	boolean result = false;
    	result = mcd.insertcateinfo(cate, shopname,cate1);
    	return result;
	}
}
