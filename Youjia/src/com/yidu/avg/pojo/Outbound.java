package com.yidu.avg.pojo;

import java.io.Serializable;

public class Outbound{
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
	@Override
	public String toString() {
		return "Outbound [obId=" + obId + ", obTime=" + obTime + ", soId=" + soId + ", odNumber=" + odNumber
				+ ", marId=" + marId + ", itId=" + itId + "]";
	}
	
}
