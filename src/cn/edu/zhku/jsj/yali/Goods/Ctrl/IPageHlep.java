package cn.edu.zhku.jsj.yali.Goods.Ctrl;

public interface IPageHlep {
	
	public int getCurrentPage(String currentPage,String flag);

	public int getCurrentPage(String currentPage);
	
	public int getPageSize(String pSize,int vDefault);

}
