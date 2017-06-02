package cn.edu.zhku.jsj.yali.User.Service;

import cn.edu.zhku.jsj.yali.User.Dao.DeleUserDao;

public class DeleUserService {

	DeleUserDao dud=new DeleUserDao();
	public boolean delecateinfo(String user) throws Exception{
    	boolean result = false;
    	result = dud.delecateinfo(user);
    	return result;
	}
}
