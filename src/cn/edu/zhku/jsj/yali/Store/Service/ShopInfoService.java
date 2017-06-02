package cn.edu.zhku.jsj.yali.Store.Service;

import java.util.ArrayList;

import net.sf.json.JSONArray;
import cn.edu.zhku.jsj.yali.Store.Dao.ShopInfoDao;
import cn.edu.zhku.jsj.yali.User.User;

public class ShopInfoService {
	
	ShopInfoDao sid=new ShopInfoDao();
	public JSONArray getshopinfo(String shopname) throws Exception{
		ArrayList<User> list = null;
		list= sid.getshopinfo(shopname);
		JSONArray jsonArray =JSONArray.fromObject(list);
		return jsonArray;
	}
}
