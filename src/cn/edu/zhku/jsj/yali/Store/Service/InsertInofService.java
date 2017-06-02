package cn.edu.zhku.jsj.yali.Store.Service;

import cn.edu.zhku.jsj.yali.Store.Dao.InsertInofDao;
import cn.edu.zhku.jsj.yali.User.User;


public class InsertInofService {
	public boolean insertinfo(User user) throws Exception{
		InsertInofDao iid = new InsertInofDao();
    	boolean result = false;
    	result = iid.insertUserinfo(user);
    	return result;
	}
}
