package com.yidu.avg.domain;

import java.io.Serializable;

/**
 * 
 * 功能：创建实体类
 * @author d280 avenger组
 * 编写日期： 2019年10月15日下午3:15:49
 * 版本：1.0
 */
public class Shopping implements Serializable {
	private static final long serialVersionUID = -6672904910191510139L;
	//购物车ID
	private int spId;
	//商品类型
	private int marId;
	//商品数量
	private int spNum;
	//商品小计
	private double spCount;
	/**
	 * 不带参数的默认构造方法
	 */
	public Shopping() {
		super();
	}
	/**
	 * 带参数的默认构造方法
	 * @param spid 购物车ID
	 * @param marId 商品类型
	 * @param spNum 商品数量
	 * @param spCont 商品小计
	 */
	public Shopping(int spId, int marId, int spNum, double spCount) {
		super();
		this.spId = spId;
		this.marId = marId;
		this.spNum = spNum;
		this.spCount = spCount;
	}
	
	public Shopping(int marId, int spNum, double spCount) {
		super();
		this.marId = marId;
		this.spNum = spNum;
		this.spCount = spCount;
	}
	/**
	 * setter/getter方法
	 * @return
	 */
	public int getspId() {
		return spId;
	}
	public void setspId(int spId) {
		this.spId = spId;
	}
	public int getMarId() {
		return marId;
	}
	public void setMarId(int marId) {
		this.marId = marId;
	}
	public int getSpNum() {
		return spNum;
	}
	public void setSpNum(int spNum) {
		this.spNum = spNum;
	}
	public double getSpCount() {
		return spCount;
	}
	public void setSpCount(double spCount) {
		this.spCount = spCount;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
