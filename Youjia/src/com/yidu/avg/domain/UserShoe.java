package com.yidu.avg.domain;

import java.io.Serializable;
/**
 * 
 * ���ܣ�ʵ����
 * @author d280 avenger��
 * ��д���ڣ� 2019��10��15������3:27:23
 * �汾��1.0
 */
public class UserShoe implements Serializable{
	private static final long serialVersionUID = -841569269915661147L;
	//�û�id
	private int usId;
	//�û���
	private String usName;
	//�û�����
	private String usPwd;
	//�û��Ա�
	private String usSex;
	//�û�����
	private String usEmail;
	//��ַ
	private String usAddress;
	//�绰
	private String usPhone;
	//��������
	private String usPostal;
	/**
	 * Ĭ�Ϲ��췽��
	 */
	public UserShoe() {
		
	}
	/**
	 * ���ι��췽��
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
	 * getter/setter����
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
