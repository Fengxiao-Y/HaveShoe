package com.yidu.avg.dao;

import java.util.List;

import com.yidu.avg.domain.Employee;


/**
 * 
 * 功能：实体类接口
 * @author d280 avenger组
 * 编写日期： 2019年10月17日下午2:25:59
 * 版本：1.0
 */
public interface EmployeeDao {
	public Employee oflogin(String empName);

	/**
	 * 将实体类对象添加到数据库表中
	 * @param employee
	 * @return
	 */
	public int add(Employee employee);
	
	
	
	/**
	 * 按员工编号（主键）删除数据
	 * @param empId
	 * @return
	 */
	public int delete(int empId);
	
	/**
	 * 将实体类对象更新到数据库表中
	 * @param employee
	 * @return
	 */
	public int update(Employee employee);
	
	/**
	 * 按员工编号从数据库表查找数据
	 * @param unumber
	 * @return
	 */
	public Employee findById(String unumber);
	
	/**
	 * 从数据库表中分页查找数据
	 * @param rows
	 * @param page
	 * @return
	 */
	public List<Employee> findByPage(int rows,int page);
	
	/**
	 * 从数据库表中按特定条件进行分页查找数据
	 * @param rows
	 * @param page
	 * @param condition
	 * @return
	 */
	public List<Employee> findByPage(int rows,int page,String condition);

	/**
	 * 统计数据库表中数据总行数
	 * @return
	 */
	public int count();
	
	/**
	 * 按特定条件统计数据库表中数据总行数
	 * @param condition
	 * @return
	 */
	public int count(String condition);
	
	int ofusers(String empName);
}
