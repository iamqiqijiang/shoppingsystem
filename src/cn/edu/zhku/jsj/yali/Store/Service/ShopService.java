package cn.edu.zhku.jsj.yali.Store.Service;

import java.util.ArrayList;

import net.sf.json.JSONArray;

import cn.edu.zhku.jsj.yali.Goods.Goods;
import cn.edu.zhku.jsj.yali.Store.Dao.ShopDao;
import cn.edu.zhku.jsj.yali.User.User;

public class ShopService {
	
	ShopDao sd = new ShopDao();
	
	public JSONArray getkeeperinfo(String shoppname) throws Exception{
		ArrayList<Goods> list = null;
		list= sd.getgoodsinfo(shoppname);
		JSONArray jsonArray =JSONArray.fromObject(list);
		return jsonArray;
	}
}
