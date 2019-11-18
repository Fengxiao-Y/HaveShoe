package com.yidu.avg.domain;

import java.io.Serializable;
/**
 * 
 * 功能：实体类
 * @author d280 avenger组
 * 编写日期： 2019年10月15日下午6:22:51
 * 版本：1.0
 */
public class Proin implements Serializable{
	private static final long serialVersionUID = -841569269915661147L;
	//入库表id
	private int pId;
	//入库时间
	private String pTime;
	//采购订单表id
	private int poId;
	//商品类型入库数量
	private int pNumber;
	//商品类型id
	private int marId;
	//库存id
	private int itId;
	/**
	 * 默认构造方法
	 */
	public Proin() {
		
	}
	/**
	 * 带参构造方法
	 * @param pId
	 * @param pTime
	 * @param poId
	 * @param pNumber
	 * @param marId
	 * @param itId
	 */
	public Proin(int pId, String pTime, int poId, int pNumber, int marId, int itId) {
		super();
		this.pId = pId;
		this.pTime = pTime;
		this.poId = poId;
		this.pNumber = pNumber;
		this.marId = marId;
		this.itId = itId;
	}
	
	public Proin(String pTime, int poId, int pNumber, int marId, int itId) {
		super();
		this.pTime = pTime;
		this.poId = poId;
		this.pNumber = pNumber;
		this.marId = marId;
		this.itId = itId;
	}
	/**
	 * getter/setter方法
	 * @return
	 */
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpTime() {
		return pTime;
	}
	public void setpTime(String pTime) {
		this.pTime = pTime;
	}
	public int getPoId() {
		return poId;
	}
	public void setPoId(int poId) {
		this.poId = poId;
	}
	public int getpNumber() {
		return pNumber;
	}
	public void setpNumber(int pNumber) {
		this.pNumber = pNumber;
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
