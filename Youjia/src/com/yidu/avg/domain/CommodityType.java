package com.yidu.avg.domain;
/**
 * 
 * ���ܣ�ʵ����
 * @author d280 avenger��
 * ��д���ڣ� 2019��10��15������3:23:57
 * �汾��1.0
 */
public class CommodityType {
   //��Ʒ����
   private int ctId;
   //��Ʒ���͡�
   private String ctName;
  
public CommodityType(int ctId, String ctName) {
	super();
	this.ctId = ctId;
	this.ctName = ctName;
}

public CommodityType(String ctName) {
	super();
	this.ctName = ctName;
}

public CommodityType() {
	super();
}


public int getCtId() {
	return ctId;
}
public void setCtId(int ctId) {
	this.ctId = ctId;
}
public String getCtName() {
	return ctName;
}
public void setCtName(String ctName) {
	this.ctName = ctName;
}
 

}
