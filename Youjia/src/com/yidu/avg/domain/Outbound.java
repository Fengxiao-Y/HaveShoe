package com.yidu.avg.domain;

import java.io.Serializable;
/**
 * 
 * ���ܣ�ʵ����
 * @author d280 avenger��
 * ��д���ڣ� 2019��10��14������3:13:23
 * �汾��1.0
 */
public class Outbound implements Serializable{
	private static final long serialVersionUID = -841569269915661147L;
	//�����id
	private int obId;
	//����ʱ��
	private String obTime;
	//����id
	private int soId;
	//��Ʒ��������
	private int odNumber;
	//��Ʒ����id
	private int marId;
	//���id
	private int itId;
	/**
	 * Ĭ�Ϲ��췽��
	 */
	public Outbound() {
		
	}
	/**
	 * ���ι��췽��
	 * @param obId
	 * @param obTime
	 * @param soId
	 * @param odNumber
	 * @param marId
	 * @param itId
	 */
	public Outbound(int obId, String obTime, int soId, int odNumber, int marId, int itId) {
		super();
		this.obId = obId;
		this.obTime = obTime;
		this.soId = soId;
		this.odNumber = odNumber;
		this.marId = marId;
		this.itId = itId;
	}
	
	public Outbound(String obTime, int soId, int odNumber, int marId, int itId) {
		super();
		this.obTime = obTime;
		this.soId = soId;
		this.odNumber = odNumber;
		this.marId = marId;
		this.itId = itId;
	}
	/**
	 * getter/setter����
	 * @return
	 */
	public int getObId() {
		return obId;
	}
	public void setObId(int obId) {
		this.obId = obId;
	}
	public String getObTime() {
		return obTime;
	}
	public void setObTime(String obTime) {
		this.obTime = obTime;
	}
	public int getSoId() {
		return soId;
	}
	public void setSoId(int soId) {
		this.soId = soId;
	}
	public int getOdNumber() {
		return odNumber;
	}
	public void setOdNumber(int odNumber) {
		this.odNumber = odNumber;
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
