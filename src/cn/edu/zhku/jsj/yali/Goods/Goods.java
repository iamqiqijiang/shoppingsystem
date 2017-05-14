package cn.edu.zhku.jsj.yali.Goods;


public class Goods {
	private String goodname;           //商品名
	private int price;                 //价格
	private String address;      		//地址 ַ
	private int salesvolume;           //销量
	private String shop;               //店名
	private int num;                   //数量
	private String category;           //类别
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getgoodname() {
		return goodname;
	}
	public void setgoodname(String goodname) {
		this.goodname = goodname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getSalesvolume() {
		return salesvolume;
	}
	public void setSalesvolume(int salesvolume) {
		this.salesvolume = salesvolume;
	}
	public String getShop() {
		return shop;
	}
	public void setShop(String shop) {
		this.shop = shop;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
}
