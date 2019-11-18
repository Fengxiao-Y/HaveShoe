package com.yidu.avg.pojo;

import java.io.Serializable;

public class Outbound{
	//出库表id
	private int obId;
	//出库时间
	private String obTime;
	//订单id
	private int soId;
	//商品出库数量
	private int odNumber;
	//商品类型id
	private int marId;
	//库存id   
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
