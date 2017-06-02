package cn.edu.zhku.jsj.yali.Store.Service;

import java.util.ArrayList;

import net.sf.json.JSONArray;
import cn.edu.zhku.jsj.yali.Goods.Goods;
import cn.edu.zhku.jsj.yali.Store.Dao.SearchShopDao;

public class SearchShopService {

	SearchShopDao ssd=new SearchShopDao();
	public JSONArray getkeeperinfo(String shoppname) throws Exception{
		ArrayList<Goods> list = null;
		list= ssd.getgoodsinfo(shoppname);
		JSONArray jsonArray =JSONArray.fromObject(list);
		return jsonArray;
	}
}
