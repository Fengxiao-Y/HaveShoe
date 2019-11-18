package com.yidu.avg.domain;

import java.io.Serializable;

/**
 * 
 * ���ܣ�����ʵ����
 * @author d280 avenger��
 * ��д���ڣ� 2019��10��15������3:15:49
 * �汾��1.0
 */
public class Shopping implements Serializable {
	private static final long serialVersionUID = -6672904910191510139L;
	//���ﳵID
	private int spId;
	//��Ʒ����
	private int marId;
	//��Ʒ����
	private int spNum;
	//��ƷС��
	private double spCount;
	/**
	 * ����������Ĭ�Ϲ��췽��
	 */
	public Shopping() {
		super();
	}
	/**
	 * ��������Ĭ�Ϲ��췽��
	 * @param spid ���ﳵID
	 * @param marId ��Ʒ����
	 * @param spNum ��Ʒ����
	 * @param spCont ��ƷС��
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
	 * setter/getter����
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
