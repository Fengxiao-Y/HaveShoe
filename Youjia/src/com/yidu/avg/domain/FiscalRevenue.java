package com.yidu.avg.domain;

import java.io.Serializable;

/**
 * 
 * 功能：财务收入表实体类
 * @author 李卫
 * 版本：1.0
 * 日期：2019年10月15日 上午9:38:37
 */
public class FiscalRevenue implements Serializable{

	private static final long serialVersionUID = 3831074018518194577L;
	//财务收入表Id
	private int frId;
	//订单id
	private int soId;
	//操作时间
	private String frTime;
	//收入金额
	private double frMoney;
	
	/**
	 * 默认构造方法
	 */
	public FiscalRevenue() {
	}

	/**
	 * 
	 * @param frId财务收入表Id
	 * @param soId 订单id
	 * @param frTime 操作时间
	 * @param frMoney 收入金额
	 */
	public FiscalRevenue(int frId, int soId, String frTime, double frMoney) {
		this.frId = frId;
		this.soId = soId;
		this.frTime = frTime;
		this.frMoney = frMoney;
	}

	/**
	 * 
	 * @param soId 订单id
	 * @param frTime 操作时间
	 * @param frMoney 收入金额
	 */
	public FiscalRevenue(int soId, String frTime, double frMoney) {
		this.soId = soId;
		this.frTime = frTime;
		this.frMoney = frMoney;
	}

	//生成getter/setter方法
	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}

	public int getSoId() {
		return soId;
	}

	public void setSoId(int soId) {
		this.soId = soId;
	}

	public String getFrTime() {
		return frTime;
	}

	public void setFrTime(String frTime) {
		this.frTime = frTime;
	}

	public double getFrMoney() {
		return frMoney;
	}

	public void setFrMoney(double frMoney) {
		this.frMoney = frMoney;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
