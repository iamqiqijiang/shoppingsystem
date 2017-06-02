package cn.edu.zhku.jsj.yali.Store.Service;

import java.util.ArrayList;

import net.sf.json.JSONArray;
import cn.edu.zhku.jsj.yali.Goods.Goods;
import cn.edu.zhku.jsj.yali.Store.Dao.SearchOneDao;

public class SearchOneService {

	SearchOneDao sod=new SearchOneDao();
	public JSONArray getgoodsinfo(String good) throws Exception{
		ArrayList<Goods> list = null;
		list= sod.getappointgoodsinfo(good);
		JSONArray jsonArray =JSONArray.fromObject(list);
		return jsonArray;
	}
}
