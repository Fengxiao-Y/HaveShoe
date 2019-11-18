package com.yidu.avg.domain;

import java.io.Serializable;
/**
 * 
 * 功能：实体类
 * @author d280 avenger组
 * 编写日期： 2019年10月15日下午3:43:23
 * 版本：1.0
 */
public class SalesOrder implements Serializable{
	private static final long serialVersionUID = -841569269915661147L;
	//订单id
	private int soId;
	//订单生成时间
	private String soTime;
	//客户表id
	private int usId;
	//商品类型
	private int marId;
	//商品数量
	private int counts;
	//商品价格
	private double subtotal;
	//购物车id
	private int spId;
	/**
	 * 默认构造方法
	 */
	public SalesOrder() {
		
	}
	/**
	 * 带参构造方法
	 * @param soId
	 * @param soTime
	 * @param usId
	 * @param marId
	 * @param counts
	 * @param subtotal
	 * @param spId
	 */
	public SalesOrder(int soId, String soTime, int usId, int marId, int counts, double subtotal, int spId) {
		super();
		this.soId = soId;
		this.soTime = soTime;
		this.usId = usId;
		this.marId = marId;
		this.counts = counts;
		this.subtotal = subtotal;
		this.spId = spId;
	}
	
	public SalesOrder(String soTime, int usId, int marId, int counts, double subtotal, int spId) {
		super();
		this.soTime = soTime;
		this.usId = usId;
		this.marId = marId;
		this.counts = counts;
		this.subtotal = subtotal;
		this.spId = spId;
	}
	/**
	 * getter/setter方法
	 * @return
	 */
	public int getSoId() {
		return soId;
	}
	public void setSoId(int soId) {
		this.soId = soId;
	}
	public String getSoTime() {
		return soTime;
	}
	public void setSoTime(String soTime) {
		this.soTime = soTime;
	}
	public int getUsId() {
		return usId;
	}
	public void setUsId(int usId) {
		this.usId = usId;
	}
	public int getMarId() {
		return marId;
	}
	public void setMarId(int marId) {
		this.marId = marId;
	}
	public int getCounts() {
		return counts;
	}
	public void setCounts(int counts) {
		this.counts = counts;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public int getspId() {
		return spId;
	}
	public void setspId(int spId) {
		this.spId = spId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
