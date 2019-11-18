package com.yidu.avg.domain;

import java.io.Serializable;
/**
 * 
 * ���ܣ�ʵ����
 * @author d280 avenger��
 * ��д���ڣ� 2019��10��16������2:55:23
 * �汾��1.0
 */
public class Marque implements Serializable{
	//��ƷID
	private int marId;
	//��Ʒ����
	private String marName;
	//��Ʒ����
	private int marYardage;
	//��Ʒ����
	private String marIntroduce;
	//��ƷͼƬ·��
	private String marUrl;
	//��Ʒԭ���۸�
	private double marprice;
	//�ۺ�۸�
	private double marConvert;
	//��Ʒ���ͱ�Id
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
