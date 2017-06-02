package cn.edu.zhku.jsj.yali.Store.Service;

import java.util.ArrayList;

import net.sf.json.JSONArray;
import cn.edu.zhku.jsj.yali.Goods.Goods;
import cn.edu.zhku.jsj.yali.Store.Dao.SearchCateShopDao;

public class SearchCateShopService {

	SearchCateShopDao scsd=new SearchCateShopDao();
	public JSONArray getkeeperinfo(String shoppname,String cate) throws Exception{
		ArrayList<Goods> list = null;
		list= scsd.getgoodsinfo(shoppname,cate);
		JSONArray jsonArray =JSONArray.fromObject(list);
		return jsonArray;
	}
}

