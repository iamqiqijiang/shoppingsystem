package cn.edu.zhku.jsj.yali.User.Service;

import cn.edu.zhku.jsj.yali.User.Dao.ModifyPassDao;

public class ModifyPassService {

	ModifyPassDao mpd=new ModifyPassDao();
	public boolean insertshopinfo(String ps1,String username,String ps2) throws Exception{
    	boolean result = false;
    	result = mpd.insertcateinfo(ps1,username,ps2);
    	return result;
	}
}
