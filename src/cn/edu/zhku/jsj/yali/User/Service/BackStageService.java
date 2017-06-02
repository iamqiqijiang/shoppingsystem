package cn.edu.zhku.jsj.yali.User.Service;

import java.util.ArrayList;

import net.sf.json.JSONArray;
import cn.edu.zhku.jsj.yali.User.User;
import cn.edu.zhku.jsj.yali.User.Dao.BackStageDao;

public class BackStageService {

	BackStageDao bsd=new BackStageDao();
	public JSONArray getshopinfo() throws Exception{
		ArrayList<User> list = null;
		list= bsd.getgoodsinfo();
		JSONArray jsonArray =JSONArray.fromObject(list);
		return jsonArray;
	}
}
