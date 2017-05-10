package cn.edu.zhku.jsj.yali.User.Service;

import cn.edu.zhku.jsj.yali.User.User;
import cn.edu.zhku.jsj.yali.User.Dao.RegDao;

public class RegService {
	public boolean insertinfo(User user) throws Exception{
    	RegDao ld = new RegDao();
    	boolean result = false;
    	result = ld.insertUserinfo(user);
    	return result;
	}
}
