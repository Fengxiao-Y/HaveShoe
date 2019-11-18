package com.yidu.avg.domain;
/**
 * 
 * 功能：实体类
 * @author d280 avenger组
 * 编写日期： 2019年10月15日下午3:23:57
 * 版本：1.0
 */
public class CommodityType {
   //商品种类
   private int ctId;
   //商品类型、
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
