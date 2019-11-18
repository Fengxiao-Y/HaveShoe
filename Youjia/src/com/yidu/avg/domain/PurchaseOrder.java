package com.yidu.avg.domain;

import java.io.Serializable;
/**
 * 
 * ���ܣ�ʵ����
 * @author d280 avenger��
 * ��д���ڣ� 2019��10��15������5:22:19
 * �汾��1.0
 */
public class PurchaseOrder implements Serializable{

	private static final long serialVersionUID = -841569269915661147L;
	//��Ʒ״̬id
	private int poId;
	//��Ʒ����id
	private int marId;
	//�����������ˣ�
	private String poName;
	//����ʱ��
	private String poTime;
	//��Ӧ��id
	private int spId;
	//�ɹ�����
	private int poCounts;
	//��Ʒ�ɹ��۸�
	private double poPrice;
	/**
	 * Ĭ�Ϲ��췽��
	 */
	public PurchaseOrder() {
		
	}
	/**
	 * ���ι��췽��
	 * @param poId ��Ʒ״̬id����
	 * @param marId ��Ʒ����id�������
	 * @param poName �����������ˣ�
	 * @param poTime ����ʱ��
	 * @param spId ��Ӧ��id�������
	 * @param poCounts �ɹ�����
	 * @param poPrice ��Ʒ�ɹ��۸�
	 */
	public PurchaseOrder(int poId, int marId, String poName, String poTime, int spId, int poCounts, double poPrice) {
		super();
		this.poId = poId;
		this.marId = marId;
		this.poName = poName;
		this.poTime = poTime;
		this.spId = spId;
		this.poCounts = poCounts;
		this.poPrice = poPrice;
	}
	
	public PurchaseOrder(int marId, String poName, String poTime, int spId, int poCounts, double poPrice) {
		super();
		this.marId = marId;
		this.poName = poName;
		this.poTime = poTime;
		this.spId = spId;
		this.poCounts = poCounts;
		this.poPrice = poPrice;
	}
	/**
	 * getter/setter����
	 * @return
	 */
	public int getPoId() {
		return poId;
	}
	public void setPoId(int poId) {
		this.poId = poId;
	}
	public int getMarId() {
		return marId;
	}
	public void setMarId(int marId) {
		this.marId = marId;
	}
	public String getPoName() {
		return poName;
	}
	public void setPoName(String poName) {
		this.poName = poName;
	}
	public String getPoTime() {
		return poTime;
	}
	public void setPoTime(String poTime) {
		this.poTime = poTime;
	}
	public int getSpId() {
		return spId;
	}
	public void setSpId(int spId) {
		this.spId = spId;
	}
	public int getPoCounts() {
		return poCounts;
	}
	public void setPoCounts(int poCounts) {
		this.poCounts = poCounts;
	}
	public double getPoPrice() {
		return poPrice;
	}
	public void setPoPrice(double poPrice) {
		this.poPrice = poPrice;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
