package com.yidu.avg.domain;

import java.io.Serializable;
/**
 * 
 * 功能：实体类
 * @author d280 avenger组
 * 编写日期： 2019年10月14日下午3:13:23
 * 版本：1.0
 */
public class Outbound implements Serializable{
	private static final long serialVersionUID = -841569269915661147L;
	//出库表id
	private int obId;
	//出库时间
	private String obTime;
	//订单id
	private int soId;
	//商品出库数量
	private int odNumber;
	//商品类型id
	private int marId;
	//库存id
	private int itId;
	/**
	 * 默认构造方法
	 */
	public Outbound() {
		
	}
	/**
	 * 带参构造方法
	 * @param obId
	 * @param obTime
	 * @param soId
	 * @param odNumber
	 * @param marId
	 * @param itId
	 */
	public Outbound(int obId, String obTime, int soId, int odNumber, int marId, int itId) {
		super();
		this.obId = obId;
		this.obTime = obTime;
		this.soId = soId;
		this.odNumber = odNumber;
		this.marId = marId;
		this.itId = itId;
	}
	
	public Outbound(String obTime, int soId, int odNumber, int marId, int itId) {
		super();
		this.obTime = obTime;
		this.soId = soId;
		this.odNumber = odNumber;
		this.marId = marId;
		this.itId = itId;
	}
	/**
	 * getter/setter方法
	 * @return
	 */
	public int getObId() {
		return obId;
	}
	public void setObId(int obId) {
		this.obId = obId;
	}
	public String getObTime() {
		return obTime;
	}
	public void setObTime(String obTime) {
		this.obTime = obTime;
	}
	public int getSoId() {
		return soId;
	}
	public void setSoId(int soId) {
		this.soId = soId;
	}
	public int getOdNumber() {
		return odNumber;
	}
	public void setOdNumber(int odNumber) {
		this.odNumber = odNumber;
	}
	public int getMarId() {
		return marId;
	}
	public void setMarId(int marId) {
		this.marId = marId;
	}
	public int getItId() {
		return itId;
	}
	public void setItId(int itId) {
		this.itId = itId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
