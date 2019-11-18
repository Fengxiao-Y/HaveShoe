package com.yidu.avg.dao;

import java.util.List;

import com.yidu.avg.domain.Employee;


/**
 * 
 * ���ܣ�ʵ����ӿ�
 * @author d280 avenger��
 * ��д���ڣ� 2019��10��17������2:25:59
 * �汾��1.0
 */
public interface EmployeeDao {
	public Employee oflogin(String empName);

	/**
	 * ��ʵ���������ӵ����ݿ����
	 * @param employee
	 * @return
	 */
	public int add(Employee employee);
	
	
	
	/**
	 * ��Ա����ţ�������ɾ������
	 * @param empId
	 * @return
	 */
	public int delete(int empId);
	
	/**
	 * ��ʵ���������µ����ݿ����
	 * @param employee
	 * @return
	 */
	public int update(Employee employee);
	
	/**
	 * ��Ա����Ŵ����ݿ���������
	 * @param unumber
	 * @return
	 */
	public Employee findById(String unumber);
	
	/**
	 * �����ݿ���з�ҳ��������
	 * @param rows
	 * @param page
	 * @return
	 */
	public List<Employee> findByPage(int rows,int page);
	
	/**
	 * �����ݿ���а��ض��������з�ҳ��������
	 * @param rows
	 * @param page
	 * @param condition
	 * @return
	 */
	public List<Employee> findByPage(int rows,int page,String condition);

	/**
	 * ͳ�����ݿ��������������
	 * @return
	 */
	public int count();
	
	/**
	 * ���ض�����ͳ�����ݿ��������������
	 * @param condition
	 * @return
	 */
	public int count(String condition);
	
	int ofusers(String empName);
}
