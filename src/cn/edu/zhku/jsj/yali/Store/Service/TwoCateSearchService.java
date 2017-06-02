package cn.edu.zhku.jsj.yali.Store.Service;

import java.util.ArrayList;

import net.sf.json.JSONArray;
import cn.edu.zhku.jsj.yali.Goods.Goods;
import cn.edu.zhku.jsj.yali.Store.Dao.TwoCateSearchDao;

public class TwoCateSearchService {

	TwoCateSearchDao tcsd=new TwoCateSearchDao();
	public JSONArray getgoodsinfo(String cate1,String cate2) throws Exception{
		ArrayList<Goods> list = null;
		list= tcsd.getappointgoodsinfo(cate1,cate2);
		JSONArray jsonArray =JSONArray.fromObject(list);
		return jsonArray;
	}
}

