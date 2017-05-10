package cn.edu.zhku.jsj.yali.Goods;

import java.util.List;
import java.io.Serializable;

public class PageBean<T> {
	private int currentPage;
	private int pageSize;
	private int pageCount;
	private int recordCount;
	private List<T> dataList;
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int recordCount) {
		if(recordCount%pageSize==0){
			this.pageCount = recordCount/pageSize;
		}else{
			this.pageCount = recordCount/pageSize+1;
		}
	}
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	public List<T> getDataList() {
		return dataList;
	}
	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
}
