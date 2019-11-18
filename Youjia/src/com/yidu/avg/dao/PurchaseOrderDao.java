package com.yidu.avg.dao;

import java.io.Serializable;
import java.util.List;

import com.yidu.avg.domain.PurchaseOrder;
/**
 * 
 * 功能：实体类接口
 * @author d280 avenger组
 * 编写日期： 2019年10月17日下午4:56:57
 * 版本：1.0
 */
public interface PurchaseOrderDao {


	/**
	 * 按客户编号(主键)进行删除数据
	 * @param cid 
	 * @return 
	 */
	public int delete(int poId);
	/**
	 * 将实体类对象更新到数据库表中
	 * @param cust 
	 * @return
	 */
	public int update(PurchaseOrder purchaseOrder);
	
	/**
	 * 根据员工编号查找单个员工信息
	 * @param empNo
	 * @return
	 */
	public PurchaseOrder findById(int poId);
	
	/**
	 * 查找所有
	 * @return
	 */
	public List<PurchaseOrder> findAll();
	/**
	 * 分页查找
	 * @param rows 每页显示的记录数
	 * @param page 当前显示的页码数
	 * @return 指定页中所有员工信息集合
	 */
	public List<PurchaseOrder> findByPage(int rows,int page);

	/**
	 * 按条件分页查找
	 * @param rows 每页显示的记录数
	 * @param page 当前显示的页码数
	 * @param condition 条件
	 * @return
	 */
	public List<PurchaseOrder> findByPage(int rows,int page,String condition);

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
	/**
	 * 将实体类对象添加到数据库表中(一行)
	 * @param cust 客户实体类对象
	 * @return 影响的行数(1:添加成功;0:添加失败)
	 */
	public int add(PurchaseOrder purchaseOrder);
	
	
}
