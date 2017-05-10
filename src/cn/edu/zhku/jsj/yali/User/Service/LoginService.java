package cn.edu.zhku.jsj.yali.User.Service;

import cn.edu.zhku.jsj.yali.User.User;
import cn.edu.zhku.jsj.yali.User.Dao.LoginDao;

public class LoginService {
	public boolean checkUserNameAndPassword(User user) throws Exception{
    	
    	LoginDao ld = new LoginDao();
    	
    	boolean result = false;
    	User newUser = new User();
    	
    	newUser = ld.getUserByName(user);
    	
    	//如果返回值不为空，表示可以得到一个用户名和密码相匹配的值
    	if( newUser.getUsername() != null){
    		result = true;
    	}
    	
    	return result;
	}
}
