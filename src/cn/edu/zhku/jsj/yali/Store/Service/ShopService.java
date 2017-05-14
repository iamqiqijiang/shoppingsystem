package cn.edu.zhku.jsj.yali.Store.Service;

import java.util.*;

import com.sun.net.httpserver.HttpContext;

public class ShopService {
	public String toJson(List<String> str)
    {
        StringBuilder json = new StringBuilder();

        if (str == null)
        {
            return "null";

        }

        json.append("[");
        foreach (var item in str)
        {
            json.append("{\"Name\":\"");
            json.Append(item);
            json.append("\"},");
        }

        return json.toString().substring(0, json.toString().lastIndexOf(",")) + "]";
    }


    /*得到并关联仓库(select标签)*/

    public void ProcessRequest(HttpContext context)
    {

        SubinventoryDC subinventorydc = new SubinventoryDC();

        List<String> list=new ArrayList<String>(); 

        list = subinventorydc.getAllSubinventory();

        String json = toJson(list);

        context.Response.ContentType = "text/plain";

        context.Response.Write(json);
    }
}
