package cn.edu.zhku.jsj.yali.Store.Service;

import java.util.ArrayList;

import net.sf.json.JSONArray;

import cn.edu.zhku.jsj.yali.Goods.Goods;
import cn.edu.zhku.jsj.yali.Store.Dao.BackManagDao;


public class BackManagService {
		
	BackManagDao bmd=new BackManagDao();
	
	public JSONArray toJson() throws Exception{
		JSONArray jsonArray = new JSONArray();
		ArrayList<Goods> list = bmd.getshopinfo();
		jsonArray.add(list);
		return jsonArray;
		}
}
