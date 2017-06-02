package cn.edu.zhku.jsj.yali.User.Service;

import java.util.ArrayList;

import net.sf.json.JSONArray;
import cn.edu.zhku.jsj.yali.User.User;
import cn.edu.zhku.jsj.yali.User.Dao.PersonalDao;

public class PersonalService {

	PersonalDao pd=new PersonalDao();
	public JSONArray getuserinfo(String username) throws Exception{
		ArrayList<User> list = null;
		list= pd.getuserinfo(username);
		JSONArray jsonArray =JSONArray.fromObject(list);
		return jsonArray;
	}
}
