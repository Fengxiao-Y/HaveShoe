package com.yidu.avg.domain;

import java.io.Serializable;
/**
 * 
 * ���ܣ�ʵ����
 * @author d280 avenger��
 * ��д���ڣ� 2019��10��15������1:15:57
 * �汾��1.0
 */
public class Supplier implements Serializable{
	private static final long serialVersionUID = -841569269915661147L;
	//��Ӧ��id
	private int spId;
	//��Ӧ������
	private String spName;
	//��������ϵ�绰
	private String spPhone;
	//��Ӧ�̵�ַ
	private String spAddress;
	/**
	 * Ĭ�Ϲ��췽��
	 */
	public Supplier() {
		
	}
	/**
	 * ���ι��췽��
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
	 * getter/setter����
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
