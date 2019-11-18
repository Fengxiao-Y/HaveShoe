package com.yidu.avg.domain;

import java.io.Serializable;
/**
 * 
 * 功能：实体类
 * @author d280 avenger组
 * 编写日期： 2019年10月15日下午5:22:19
 * 版本：1.0
 */
public class PurchaseOrder implements Serializable{

	private static final long serialVersionUID = -841569269915661147L;
	//物品状态id
	private int poId;
	//物品类型id
	private int marId;
	//姓名（经手人）
	private String poName;
	//购买时间
	private String poTime;
	//供应商id
	private int spId;
	//采购数量
	private int poCounts;
	//物品采购价格
	private double poPrice;
	/**
	 * 默认构造方法
	 */
	public PurchaseOrder() {
		
	}
	/**
	 * 带参构造方法
	 * @param poId 物品状态id自增
	 * @param marId 物品类型id（外键）
	 * @param poName 姓名（经手人）
	 * @param poTime 购买时间
	 * @param spId 供应商id（外键）
	 * @param poCounts 采购数量
	 * @param poPrice 物品采购价格
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
	 * getter/setter方法
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
