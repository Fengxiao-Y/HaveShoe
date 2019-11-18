package com.yidu.avg.pojo;

public class Marque {
	private Integer marId;
	private String marName; 
	private Integer marYardage;
	private String marIntroduce;
	private String marUrl;
	private double marPrice;
	private double marConvert; 
	private Integer ctId;
	//ÉÌÆ·×Ü¿â´æ
	private Integer stores;
	
	public Integer getMarId() {
		return marId;
	}
	public void setMarId(Integer marId) {
		this.marId = marId;
	}
	public String getMarName() {
		return marName;
	}
	public void setMarName(String marName) {
		this.marName = marName;
	}
	public Integer getMarYardage() {
		return marYardage;
	}
	public void setMarYardage(Integer marYardage) {
		this.marYardage = marYardage;
	}
	public String getMarIntroduce() {
		return marIntroduce;
	}
	public void setMarIntroduce(String marIntroduce) {
		this.marIntroduce = marIntroduce;
	}
	public String getMarUrl() {
		return marUrl;
	}
	public void setMarUrl(String marUrl) {
		this.marUrl = marUrl;
	}
	public double getMarPrice() {
		return marPrice;
	}
	public void setMarPrice(double marPrice) {
		this.marPrice = marPrice;
	}
	public double getMarConvert() {
		return marConvert;
	}
	public void setMarConvert(double marConvert) {
		this.marConvert = marConvert;
	}
	public Integer getCtId() {
		return ctId;
	}
	public void setCtId(Integer ctId) {
		this.ctId = ctId;
	}
	public Integer getStores() {
		return stores;
	}
	public void setStores(Integer stores) {
		this.stores = stores;
	}
	@Override
	public String toString() {
		return "Marque [marId=" + marId + ", marName=" + marName + ", marYardage=" + marYardage + ", marIntroduce="
				+ marIntroduce + ", marUrl=" + marUrl + ", marPrice=" + marPrice + ", marConvert=" + marConvert
				+ ", ctId=" + ctId + ", stores=" + stores + "]";
	}
	
}
