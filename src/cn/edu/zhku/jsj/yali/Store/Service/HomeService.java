package cn.edu.zhku.jsj.yali.Store.Service;

import java.util.ArrayList;

import net.sf.json.JSONArray;
import cn.edu.zhku.jsj.yali.Goods.Goods;
import cn.edu.zhku.jsj.yali.Store.Dao.HomeDao;

public class HomeService {

	HomeDao hd=new HomeDao();
	public JSONArray getgoodsinfo() throws Exception{
		ArrayList<Goods> list = null;
		list= hd.getgoodsinfo();
		JSONArray jsonArray =JSONArray.fromObject(list);
		return jsonArray;
	}
}
