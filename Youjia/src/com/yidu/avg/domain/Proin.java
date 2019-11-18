package com.yidu.avg.domain;

import java.io.Serializable;
/**
 * 
 * ���ܣ�ʵ����
 * @author d280 avenger��
 * ��д���ڣ� 2019��10��15������6:22:51
 * �汾��1.0
 */
public class Proin implements Serializable{
	private static final long serialVersionUID = -841569269915661147L;
	//����id
	private int pId;
	//���ʱ��
	private String pTime;
	//�ɹ�������id
	private int poId;
	//��Ʒ�����������
	private int pNumber;
	//��Ʒ����id
	private int marId;
	//���id
	private int itId;
	/**
	 * Ĭ�Ϲ��췽��
	 */
	public Proin() {
		
	}
	/**
	 * ���ι��췽��
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
	 * getter/setter����
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
