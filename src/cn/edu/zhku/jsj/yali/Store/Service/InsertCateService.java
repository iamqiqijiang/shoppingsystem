package cn.edu.zhku.jsj.yali.Store.Service;


import cn.edu.zhku.jsj.yali.Store.Dao.InsertCateDao;


public class InsertCateService {

	InsertCateDao icd=new InsertCateDao();
	public boolean insertcateinfo(String cate,String shopname) throws Exception{
    	boolean result = false;
    	result = icd.insertcateinfo(cate, shopname);
    	return result;
	}
}

