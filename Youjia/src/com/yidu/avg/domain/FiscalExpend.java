package com.yidu.avg.domain;

import java.io.Serializable;
/**
 * 
 * ���ܣ�
 * @author d280 avenger��
 * ��д���ڣ� 2019��10��17������1:22:58
 * �汾��1.0
 */
public class FiscalExpend implements Serializable {

	
	private static final long serialVersionUID = -6526173960757615574L;
	//����֧����id
	private int feId;
	//�ɹ�id
	private int poId;
	//����ʱ��
	private String feTime;
	
	//����Ա��Ա��id��
	private int empId;
	//֧��
	private double feMoney;
	/**
	 * Ĭ�Ϲ��췽��
	 */
	public FiscalExpend() {
	}

	/**
	 * ���ι��췽��
	 * @param feId ����֧����id
	 * @param poId �ɹ�id
	 * @param feTime ����ʱ��
	 * @param empId ����Ա��Ա��id��
	 */


	public FiscalExpend(int feId, int poId, String feTime, int empId, double feMoney) {
		super();
		this.feId = feId;
		this.poId = poId;
		this.feTime = feTime;
		this.empId = empId;
		this.feMoney = feMoney;
	}
	

	public FiscalExpend(int poId, String feTime, int empId, double feMoney) {
		super();
		this.poId = poId;
		this.feTime = feTime;
		this.empId = empId;
		this.feMoney = feMoney;
	}

	//����getter/setter����
	public int getFeId() {
		return feId;
	}

	public int getPoId() {
		return poId;
	}

	public String getFeTime() {
		return feTime;
	}

	public int getEmpId() {
		return empId;
	}

	public double getFeMoney() {
		return feMoney;
	}

	public void setFeId(int feId) {
		this.feId = feId;
	}

	public void setPoId(int poId) {
		this.poId = poId;
	}

	public void setFeTime(String feTime) {
		this.feTime = feTime;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public void setFeMoney(double feMoney) {
		this.feMoney = feMoney;
	}


	
	
}
