package cn.edu.zhku.jsj.yali.Store.Service;

import cn.edu.zhku.jsj.yali.Store.Dao.DeleCateDao;

public class DeleCateService {
	
	DeleCateDao dcd =new DeleCateDao();
	public boolean delecateinfo(String cate) throws Exception{
    	boolean result = false;
    	result = dcd.delecateinfo(cate);
    	return result;
	}
}
