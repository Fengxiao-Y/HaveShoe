package com.yidu.avg.domain;

import java.io.Serializable;
/**
 * 
 * 功能：实体类
 * @author d280 avenger组
 * 编写日期： 2019年10月16日下午2:55:23
 * 版本：1.0
 */
public class Marque implements Serializable{
	//商品ID
	private int marId;
	//商品名称
	private String marName;
	//商品码数
	private int marYardage;
	//商品介绍
	private String marIntroduce;
	//商品图片路径
	private String marUrl;
	//商品原来价格
	private double marprice;
	//折后价格
	private double marConvert;
	//商品类型表Id
	private int ctId;
	
	public Marque(int marId, String marName, int marYardage, String marIntroduce, String marUrl, double marprice,
			double marConvert,int ctId) {
		this.marId = marId;
		this.marName = marName;
		this.marYardage = marYardage;
		this.marIntroduce = marIntroduce;
		this.marUrl = marUrl;
		this.marprice = marprice;
		this.marConvert = marConvert;
		this.ctId = ctId;
	}
	
	public Marque(String marName, int marYardage, String marIntroduce, String marUrl, double marprice,
			double marConvert, int ctId) {
		super();
		this.marName = marName;
		this.marYardage = marYardage;
		this.marIntroduce = marIntroduce;
		this.marUrl = marUrl;
		this.marprice = marprice;
		this.marConvert = marConvert;
		this.ctId = ctId;
	}

	public Marque() {
		super();
	}
	public int getMarId() {
		return marId;
	}
	public void setMarId(int marId) {
		this.marId = marId;
	}
	public String getMarName() {
		return marName;
	}
	public void setMarName(String marName) {
		this.marName = marName;
	}
	public int getMarYardage() {
		return marYardage;
	}
	public void setMarYardage(int marYardage) {
		this.marYardage = marYardage;
	}
	public String getMarIntroduce() {
		return marIntroduce;
	}
	public void setMarIntroduce(String marIntroduce) {
		this.marIntroduce = marIntroduce;
	}
	public String getMarUrl() {
		return marUrl;
	}
	public void setMarUrl(String marUrl) {
		this.marUrl = marUrl;
	}
	public double getMarprice() {
		return marprice;
	}
	public void setMarprice(double marprice) {
		this.marprice = marprice;
	}
	public double getMarConvert() {
		return marConvert;
	}
	public void setMarConvert(double marConvert) {
		this.marConvert = marConvert;
	}
	public int getCtId() {
		return ctId;
	}
	public void setCtId(int ctId) {
		this.ctId = ctId;
	}
	
	
}
