package cn.edu.zhku.jsj.yali.Store.Service;

import java.util.ArrayList;

import net.sf.json.JSONArray;
import cn.edu.zhku.jsj.yali.Goods.Goods;
import cn.edu.zhku.jsj.yali.Store.CateGory;
import cn.edu.zhku.jsj.yali.Store.Dao.CateSearchDao;

public class CateSearchService {
	
	CateSearchDao csd=new CateSearchDao();
	public JSONArray getappointinfo(String shoppname) throws Exception{
		ArrayList<CateGory> list = null;
		list= csd.getappointgoodsinfo(shoppname);
		JSONArray jsonArray =JSONArray.fromObject(list);
		return jsonArray;
	}
}
