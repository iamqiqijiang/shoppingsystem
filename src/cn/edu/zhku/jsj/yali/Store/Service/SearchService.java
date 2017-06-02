package cn.edu.zhku.jsj.yali.Store.Service;

import java.util.ArrayList;

import net.sf.json.JSONArray;
import cn.edu.zhku.jsj.yali.Goods.Goods;
import cn.edu.zhku.jsj.yali.Store.Dao.SearchDao;


public class SearchService {
	
	SearchDao sd = new SearchDao();
	
	public JSONArray getappointinfo(String shoppname,String gooddname) throws Exception{
		ArrayList<Goods> list = null;
		list= sd.getappointgoodsinfo(shoppname,gooddname);
		JSONArray jsonArray =JSONArray.fromObject(list);
		return jsonArray;
	}
}
