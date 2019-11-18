package com.yidu.avg.server.model;

public class OrderDetailsModel {

	// �����id
	private int obId;
	// ����ʱ��
	private String obTime;
	// ����id
	private int soId;
	// ��Ʒ��������
	private int odNumber;
	// ��Ʒ����id
	private int marId;

	private String fName;

	private String fState;
	// time
	private String countTime;

	private double fPrice;

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

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getfState() {
		return fState;
	}

	public void setfState(String fState) {
		this.fState = fState;
	}

	public String getCountTime() {
		return countTime;
	}

	public void setCountTime(String countTime) {
		this.countTime = countTime;
	}

	public double getfPrice() {
		return fPrice;
	}

	public void setfPrice(double fPrice) {
		this.fPrice = fPrice;
	}

	@Override
	public String toString() {
		return "OrderDetailsModel [obId=" + obId + ", obTime=" + obTime + ", soId=" + soId + ", odNumber=" + odNumber
				+ ", marId=" + marId + ", fName=" + fName + ", fState=" + fState + ", countTime=" + countTime
				+ ", fPrice=" + fPrice + "]";
	}

}
