package com.yidu.avg.server.model;

public class CarModel {
	
	private Integer id; 
	private String username;
	private String shoeName;
	private double price;
	private Integer store;
	private String marUrl;
	private Integer shoeSize;
	private Integer stores;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getShoeName() {
		return shoeName;
	}
	public void setShoeName(String shoeName) {
		this.shoeName = shoeName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Integer getStore() {
		return store;
	}
	public void setStore(Integer store) {
		this.store = store;
	}
	public String getMarUrl() {
		return marUrl;
	}
	public void setMarUrl(String marUrl) {
		this.marUrl = marUrl;
	}
	public Integer getShoeSize() {
		return shoeSize;
	}
	public void setShoeSize(Integer shoeSize) {
		this.shoeSize = shoeSize;
	}
	public Integer getStores() {
		return stores;
	}
	public void setStores(Integer stores) {
		this.stores = stores;
	}
	@Override
	public String toString() {
		return "CarModel [id=" + id + ", username=" + username + ", shoeName=" + shoeName + ", price=" + price
				+ ", store=" + store + ", marUrl=" + marUrl + ", shoeSize=" + shoeSize + ", stores=" + stores + "]";
	}
	
	
	
}
