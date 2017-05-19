package cn.edu.zhku.jsj.yali.Store.Service;

import java.util.ArrayList;

import net.sf.json.JSONArray;

import cn.edu.zhku.jsj.yali.Goods.Goods;
import cn.edu.zhku.jsj.yali.Store.Dao.BackManagDao;


public class BackManagService {
		
	BackManagDao bmd=new BackManagDao();
	
	public JSONArray toJson() {
		//JSONArray jsonArray = new JSONArray();
		ArrayList<Goods> list = null;
		try {
			list = bmd.getshopinfo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray jsonArray =JSONArray.fromObject(list);
		return jsonArray;
		}
}
