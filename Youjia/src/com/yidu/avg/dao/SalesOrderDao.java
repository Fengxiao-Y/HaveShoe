package com.yidu.avg.dao;

import java.util.List;

import com.yidu.avg.domain.SalesOrder;
/**
 * 
 * 功能：实体类接口
 * @author d280 avenger组
 * 编写日期： 2019年10月17日下午6:10:34
 * 版本：1.0
 */
public interface SalesOrderDao {
	/**
	 * 将实体类对象添加到数据库表中(一行)
	 * @param cust 客户实体类对象
	 * @return 影响的行数(1:添加成功;0:添加失败)
	 */
	public int add(SalesOrder salesOrder);
	/**
	 * 按订单id(主键)进行删除数据
	 * @param soId
	 * @return 
	 */
	public int delete(int soId);
	/**
	 * 将实体类对象更新到数据库表中
	 * @param salesOrder 
	 * @return
	 */
	public int update(SalesOrder salesOrder);
	
	/**
	 * 根据订单id查找单个员工信息
	 * @param soId
	 * @return
	 */
	public SalesOrder findById(int soId);
	
	/**
	 * 查找所有
	 * @return
	 */
	public List<SalesOrder> findAll();
	/**
	 * 分页查找
	 * @param rows 每页显示的记录数
	 * @param page 当前显示的页码数
	 * @return 指定页中所有员工信息集合
	 */
	public List<SalesOrder> findByPage(int rows,int page);

	/**
	 * 按条件分页查找
	 * @param rows 每页显示的记录数
	 * @param page 当前显示的页码数
	 * @param condition 条件
	 * @return
	 */
	public List<SalesOrder> findByPage(int rows,int page,String condition);

	/**
	 * 统计记录数
	 * @return 表中所有记录行数
	 */
	public int count();
	
	/**
	 * 统计符合条件的记录数
	 * @param condition 条件
	 * @return
	 */
	public int count(String condition);
}
