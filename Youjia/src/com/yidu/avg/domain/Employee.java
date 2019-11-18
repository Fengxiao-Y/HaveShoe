package com.yidu.avg.domain;

import java.io.Serializable;
/**
 * 
 * 功能：实体类
 * @author d280 avenger组
 * 编写日期： 2019年10月15日下午5:23:33
 * 版本：1.0
 */
public class Employee implements Serializable{
    //员工ID
	private int empId;
	//员工用户名
	private String empName;
	//员工密码
	private String empPwd;
	//薪水
	private String empSalary;
	//身份证
	private String empCard;
	//地址
	private String empAddress;
	//电话号码
	private String empPhone;
	/**
	 * 默认构造方法
	 */
	public Employee() {
		
	}

	
	
    public Employee(String empName, String empPwd, String empSalary, String empCard, String empAddress,
			String empPhone) {
		super();
		this.empName = empName;
		this.empPwd = empPwd;
		this.empSalary = empSalary;
		this.empCard = empCard;
		this.empAddress = empAddress;
		this.empPhone = empPhone;
	}



	public Employee(int empId, String empName, String empPwd, String empSalary, String empCard, String empAddress,
			String empPhone) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empPwd = empPwd;
		this.empSalary = empSalary;
		this.empCard = empCard;
		this.empAddress = empAddress;
		this.empPhone = empPhone;
	}
	/**
     * get/set方法
     * @return
     */
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpPwd() {
		return empPwd;
	}

	public void setEmpPwd(String empPwd) {
		this.empPwd = empPwd;
	}

	public String getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(String empSalary) {
		this.empSalary = empSalary;
	}

	public String getEmpCard() {
		return empCard;
	}

	public void setEmpCard(String empCard) {
		this.empCard = empCard;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public String getEmpPhone() {
		return empPhone;
	}

	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}
	
	
}
