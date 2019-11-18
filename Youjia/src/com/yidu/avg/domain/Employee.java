package com.yidu.avg.domain;

import java.io.Serializable;
/**
 * 
 * ���ܣ�ʵ����
 * @author d280 avenger��
 * ��д���ڣ� 2019��10��15������5:23:33
 * �汾��1.0
 */
public class Employee implements Serializable{
    //Ա��ID
	private int empId;
	//Ա���û���
	private String empName;
	//Ա������
	private String empPwd;
	//нˮ
	private String empSalary;
	//���֤
	private String empCard;
	//��ַ
	private String empAddress;
	//�绰����
	private String empPhone;
	/**
	 * Ĭ�Ϲ��췽��
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
     * get/set����
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
