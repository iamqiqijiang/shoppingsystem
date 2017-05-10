package cn.edu.zhku.jsj.yali.Goods.Ctrl;


class PageHlepImpl implements IPageHlep{

	public int getCurrentPage(String currPage,String flag) {
		int currentPage;	
		if(currPage==""||currPage==null||Integer.parseInt(currPage)<1){
			currentPage = 1;
		}else{
			currentPage = Integer.parseInt(currPage);
		}
		return currentPage;
	}

	public int getCurrentPage(String currPage) {
			
		int currentPage = Integer.parseInt(currPage);
		return currentPage;
	}

	public int getPageSize(String pSize,int defaultPageSize) {
		System.out.println("pSize="+pSize);
		int pageSize;
		if (pSize == "" || pSize == null) {
			pageSize = defaultPageSize;
		} else {
			pageSize = Integer.parseInt(pSize);
		}
		return pageSize;
	}


}
