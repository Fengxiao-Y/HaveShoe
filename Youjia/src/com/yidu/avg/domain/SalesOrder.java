package com.yidu.avg.domain;

import java.io.Serializable;
/**
 * 
 * ���ܣ�ʵ����
 * @author d280 avenger��
 * ��д���ڣ� 2019��10��15������3:43:23
 * �汾��1.0
 */
public class SalesOrder implements Serializable{
	private static final long serialVersionUID = -841569269915661147L;
	//����id
	private int soId;
	//��������ʱ��
	private String soTime;
	//�ͻ���id
	private int usId;
	//��Ʒ����
	private int marId;
	//��Ʒ����
	private int counts;
	//��Ʒ�۸�
	private double subtotal;
	//���ﳵid
	private int spId;
	/**
	 * Ĭ�Ϲ��췽��
	 */
	public SalesOrder() {
		
	}
	/**
	 * ���ι��췽��
	 * @param soId
	 * @param soTime
	 * @param usId
	 * @param marId
	 * @param counts
	 * @param subtotal
	 * @param spId
	 */
	public SalesOrder(int soId, String soTime, int usId, int marId, int counts, double subtotal, int spId) {
		super();
		this.soId = soId;
		this.soTime = soTime;
		this.usId = usId;
		this.marId = marId;
		this.counts = counts;
		this.subtotal = subtotal;
		this.spId = spId;
	}
	
	public SalesOrder(String soTime, int usId, int marId, int counts, double subtotal, int spId) {
		super();
		this.soTime = soTime;
		this.usId = usId;
		this.marId = marId;
		this.counts = counts;
		this.subtotal = subtotal;
		this.spId = spId;
	}
	/**
	 * getter/setter����
	 * @return
	 */
	public int getSoId() {
		return soId;
	}
	public void setSoId(int soId) {
		this.soId = soId;
	}
	public String getSoTime() {
		return soTime;
	}
	public void setSoTime(String soTime) {
		this.soTime = soTime;
	}
	public int getUsId() {
		return usId;
	}
	public void setUsId(int usId) {
		this.usId = usId;
	}
	public int getMarId() {
		return marId;
	}
	public void setMarId(int marId) {
		this.marId = marId;
	}
	public int getCounts() {
		return counts;
	}
	public void setCounts(int counts) {
		this.counts = counts;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public int getspId() {
		return spId;
	}
	public void setspId(int spId) {
		this.spId = spId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
