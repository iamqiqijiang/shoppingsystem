package cn.edu.zhku.jsj.yali.User.Service;

import cn.edu.zhku.jsj.yali.User.Dao.RechargeDao;

public class RechargeService {

	RechargeDao rd=new RechargeDao();
	public boolean insertshopinfo(String username,int money) throws Exception{
    	boolean result = false;
    	result = rd.insertcateinfo(username,money);
    	return result;
	}
}
