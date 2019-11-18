package com.yidu.avg.domain;

import java.io.Serializable;
/**
 * 
 * 功能：
 * @author d280 avenger组
 * 编写日期： 2019年10月17日下午1:22:58
 * 版本：1.0
 */
public class FiscalExpend implements Serializable {

	
	private static final long serialVersionUID = -6526173960757615574L;
	//财务支出表id
	private int feId;
	//采购id
	private int poId;
	//操作时间
	private String feTime;
	
	//操作员（员工id）
	private int empId;
	//支出
	private double feMoney;
	/**
	 * 默认构造方法
	 */
	public FiscalExpend() {
	}

	/**
	 * 带参构造方法
	 * @param feId 财务支出表id
	 * @param poId 采购id
	 * @param feTime 操作时间
	 * @param empId 操作员（员工id）
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

	//生成getter/setter方法
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
