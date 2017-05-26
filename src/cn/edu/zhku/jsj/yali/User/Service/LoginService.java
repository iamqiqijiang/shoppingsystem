package cn.edu.zhku.jsj.yali.User.Service;

import cn.edu.zhku.jsj.yali.User.User;
import cn.edu.zhku.jsj.yali.User.Dao.LoginDao;

public class LoginService {
	public User checkUserNameAndPassword(User user) throws Exception{
    	
    	LoginDao ld = new LoginDao();
    	
    	User newUser = new User();
    	
    	newUser = ld.getUserByName(user);
    	return newUser;
	}
}
