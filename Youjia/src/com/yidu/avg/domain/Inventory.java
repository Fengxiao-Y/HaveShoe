package com.yidu.avg.domain;

import java.io.Serializable;
/**
 * 
 * ���ܣ�ʵ����
 * @author d280 avenger��
 * ��д���ڣ� 2019��10��15������2:14:57
 * �汾��1.0
 */
public class Inventory implements Serializable{
	private static final long serialVersionUID = -841569269915661147L;
	//���id
	private int itId;
	//�������
	private int itNumber;
	//��Ʒ����
	private int ctId;
	/**
	 * Ĭ�Ϲ��췽��
	 */
	public Inventory() {
		
	}
	/**
	 * ���ι��췽��
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
	 * getter/setter����
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
