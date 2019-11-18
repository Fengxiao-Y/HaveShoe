package com.yidu.avg.domain;

import java.io.Serializable;
/**
 * 
 * 功能：实体类
 * @author d280 avenger组
 * 编写日期： 2019年10月15日下午3:27:23
 * 版本：1.0
 */
public class UserShoe implements Serializable{
	private static final long serialVersionUID = -841569269915661147L;
	//用户id
	private int usId;
	//用户名
	private String usName;
	//用户密码
	private String usPwd;
	//用户性别
	private String usSex;
	//用户邮箱
	private String usEmail;
	//地址
	private String usAddress;
	//电话
	private String usPhone;
	//邮政编码
	private String usPostal;
	/**
	 * 默认构造方法
	 */
	public UserShoe() {
		
	}
	/**
	 * 带参构造方法
	 * @param usId
	 * @param usName
	 * @param usPwd
	 * @param usSex
	 * @param usEmail
	 * @param usAddress
	 * @param usPhone
	 * @param usPostal
	 */
	public UserShoe(int usId, String usName, String usPwd, String usSex, String usEmail, String usAddress,
			String usPhone, String usPostal) {
		super();
		this.usId = usId;
		this.usName = usName;
		this.usPwd = usPwd;
		this.usSex = usSex;
		this.usEmail = usEmail;
		this.usAddress = usAddress;
		this.usPhone = usPhone;
		this.usPostal = usPostal;
	}
	
	public UserShoe(String usName, String usPwd, String usSex, String usEmail, String usAddress, String usPhone,
			String usPostal) {
		super();
		this.usName = usName;
		this.usPwd = usPwd;
		this.usSex = usSex;
		this.usEmail = usEmail;
		this.usAddress = usAddress;
		this.usPhone = usPhone;
		this.usPostal = usPostal;
	}
	/**
	 * getter/setter方法
	 * @return
	 */
	public int getUsId() {
		return usId;
	}
	public void setUsId(int usId) {
		this.usId = usId;
	}
	public String getUsName() {
		return usName;
	}
	public void setUsName(String usName) {
		this.usName = usName;
	}
	public String getUsPwd() {
		return usPwd;
	}
	public void setUsPwd(String usPwd) {
		this.usPwd = usPwd;
	}
	public String getUsSex() {
		return usSex;
	}
	public void setUsSex(String usSex) {
		this.usSex = usSex;
	}
	public String getUsEmail() {
		return usEmail;
	}
	public void setUsEmail(String usEmail) {
		this.usEmail = usEmail;
	}
	public String getUsAddress() {
		return usAddress;
	}
	public void setUsAddress(String usAddress) {
		this.usAddress = usAddress;
	}
	public String getUsPhone() {
		return usPhone;
	}
	public void setUsPhone(String usPhone) {
		this.usPhone = usPhone;
	}
	public String getUsPostal() {
		return usPostal;
	}
	public void setUsPostal(String usPostal) {
		this.usPostal = usPostal;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
