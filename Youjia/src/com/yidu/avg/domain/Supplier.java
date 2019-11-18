package com.yidu.avg.domain;

import java.io.Serializable;
/**
 * 
 * 功能：实体类
 * @author d280 avenger组
 * 编写日期： 2019年10月15日下午1:15:57
 * 版本：1.0
 */
public class Supplier implements Serializable{
	private static final long serialVersionUID = -841569269915661147L;
	//供应商id
	private int spId;
	//供应商名称
	private String spName;
	//供货商联系电话
	private String spPhone;
	//供应商地址
	private String spAddress;
	/**
	 * 默认构造方法
	 */
	public Supplier() {
		
	}
	/**
	 * 带参构造方法
	 * @param spId
	 * @param spName
	 * @param spPhone
	 * @param spAddress
	 */
	public Supplier(int spId, String spName, String spPhone, String spAddress) {
		super();
		this.spId = spId;
		this.spName = spName;
		this.spPhone = spPhone;
		this.spAddress = spAddress;
	}
	
	public Supplier(String spName, String spPhone, String spAddress) {
		super();
		this.spName = spName;
		this.spPhone = spPhone;
		this.spAddress = spAddress;
	}
	/**
	 * getter/setter方法
	 * @return
	 */
	public int getSpId() {
		return spId;
	}
	public void setSpId(int spId) {
		this.spId = spId;
	}
	public String getSpName() {
		return spName;
	}
	public void setSpName(String spName) {
		this.spName = spName;
	}
	public String getSpPhone() {
		return spPhone;
	}
	public void setSpPhone(String spPhone) {
		this.spPhone = spPhone;
	}
	public String getSpAddress() {
		return spAddress;
	}
	public void setSpAddress(String spAddress) {
		this.spAddress = spAddress;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
