package com.yidu.avg.domain;

import java.io.Serializable;

/**
 * 
 * ���ܣ����������ʵ����
 * @author ����
 * �汾��1.0
 * ���ڣ�2019��10��15�� ����9:38:37
 */
public class FiscalRevenue implements Serializable{

	private static final long serialVersionUID = 3831074018518194577L;
	//���������Id
	private int frId;
	//����id
	private int soId;
	//����ʱ��
	private String frTime;
	//������
	private double frMoney;
	
	/**
	 * Ĭ�Ϲ��췽��
	 */
	public FiscalRevenue() {
	}

	/**
	 * 
	 * @param frId���������Id
	 * @param soId ����id
	 * @param frTime ����ʱ��
	 * @param frMoney ������
	 */
	public FiscalRevenue(int frId, int soId, String frTime, double frMoney) {
		this.frId = frId;
		this.soId = soId;
		this.frTime = frTime;
		this.frMoney = frMoney;
	}

	/**
	 * 
	 * @param soId ����id
	 * @param frTime ����ʱ��
	 * @param frMoney ������
	 */
	public FiscalRevenue(int soId, String frTime, double frMoney) {
		this.soId = soId;
		this.frTime = frTime;
		this.frMoney = frMoney;
	}

	//����getter/setter����
	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}

	public int getSoId() {
		return soId;
	}

	public void setSoId(int soId) {
		this.soId = soId;
	}

	public String getFrTime() {
		return frTime;
	}

	public void setFrTime(String frTime) {
		this.frTime = frTime;
	}

	public double getFrMoney() {
		return frMoney;
	}

	public void setFrMoney(double frMoney) {
		this.frMoney = frMoney;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
