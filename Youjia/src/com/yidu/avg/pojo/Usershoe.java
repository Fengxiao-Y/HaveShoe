package com.yidu.avg.pojo;

import java.io.Serializable;

public class Usershoe implements Serializable {
	private static final long serialVersionUID = 1L;
	private int usId;
	private String usName;
	private String usPwd;
	private String usSex;
	private String usEmail;
	private String usAddress;
	private String usPhone;
	private String usPostal;
	
	/**
	 * 默认构造方法
	 */
	public Usershoe() {
	
	}
	
	
	public Usershoe(String usName, String usEmail, String usPhone) {
		super();
		this.usName = usName;
		this.usEmail = usEmail;
		this.usPhone = usPhone;
	}


	/**
	 * 默认带参方法
	 * @param usName 用户名
	 * @param usPwd 用户密码
	 * @param usSex 用户性别
	 * @param usEmail 用户邮箱
	 * @param usAddress 用户地址
	 * @param usPhone 用户电话
	 * @param usPostal 邮编
	 */
	public Usershoe(String usName, String usPwd, String usSex, String usEmail, String usAddress,
			String usPhone, String usPostal) {
		this.usName = usName;
		this.usPwd = usPwd;
		this.usSex = usSex;
		this.usEmail = usEmail;
		this.usAddress = usAddress;
		this.usPhone = usPhone;
		this.usPostal = usPostal;
	}

	public Usershoe(String usName, String usPwd) {
		
		this.usName = usName;
		this.usPwd = usPwd;
	}
	
	
	@Override
	public String toString() {
		return "Usershoe [usId=" + usId + ", usName=" + usName + ", usPwd=" + usPwd + ", usSex=" + usSex + ", usEmail="
				+ usEmail + ", usAddress=" + usAddress + ", usPhone=" + usPhone + ", usPostal=" + usPostal + "]";
	}
	/**
	 * 默认带参方法
	 * @param usId 用户id
	 * @param usName 用户名
	 * @param usPwd 用户密码
	 * @param usSex 用户性别
	 * @param usEmail 用户邮箱
	 * @param usAddress 用户地址
	 * @param usPhone 用户电话
	 * @param usPostal 邮编
	 */
	public Usershoe(int usId, String usName, String usPwd, String usSex, String usEmail, String usAddress,
			String usPhone, String usPostal) {
		this.usId = usId;
		this.usName = usName;
		this.usPwd = usPwd;
		this.usSex = usSex;
		this.usEmail = usEmail;
		this.usAddress = usAddress;
		this.usPhone = usPhone;
		this.usPostal = usPostal;
	}

	/**
	 * 自动生成getter和setter方法
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
	
	
	
}
