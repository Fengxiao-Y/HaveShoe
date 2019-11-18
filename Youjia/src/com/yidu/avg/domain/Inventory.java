package com.yidu.avg.domain;

import java.io.Serializable;
/**
 * 
 * 功能：实体类
 * @author d280 avenger组
 * 编写日期： 2019年10月15日下午2:14:57
 * 版本：1.0
 */
public class Inventory implements Serializable{
	private static final long serialVersionUID = -841569269915661147L;
	//库存id
	private int itId;
	//库存数量
	private int itNumber;
	//商品种类
	private int ctId;
	/**
	 * 默认构造方法
	 */
	public Inventory() {
		
	}
	/**
	 * 带参构造方法
	 * @param itId
	 * @param itNumber
	 * @param ctId
	 */
	public Inventory(int itId, int itNumber, int ctId) {
		super();
		this.itId = itId;
		this.itNumber = itNumber;
		this.ctId = ctId;
	}
	
	public Inventory(int itNumber, int ctId) {
		super();
		this.itNumber = itNumber;
		this.ctId = ctId;
	}
	/**
	 * getter/setter方法
	 * @return
	 */
	public int getItId() {
		return itId;
	}
	public void setItId(int itId) {
		this.itId = itId;
	}
	public int getItNumber() {
		return itNumber;
	}
	public void setItNumber(int itNumber) {
		this.itNumber = itNumber;
	}
	public int getCtId() {
		return ctId;
	}
	public void setCtId(int ctId) {
		this.ctId = ctId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
