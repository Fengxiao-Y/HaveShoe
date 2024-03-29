package com.yidu.avg.dao;

import java.util.List;

import com.yidu.avg.domain.FiscalRevenue;
/**
 * 
 * 功能：实体类接口
 * @author d280 avenger组
 * 编写日期： 2019年10月17日下午4:26:45
 * 版本：1.0
 */
public interface FiscalRevenueDao {
	
	/**
	 * 将实体类对象添加到数据库表中（一行）
	 * @param fiscalRevenue 财务收入实体类对象
	 * @return 影响的行数（1：添加成功；0：添加失败）
	 */
	public int add(FiscalRevenue fiscalRevenue);
	
	/**
	 * 按财务收入表Id(主键) 进行删除数据
	 * @param frId
	 * @return 影响的行数（1：添加成功；0：添加失败）
	 */
	public int deleteById(int frId);
	
	/**
	 * 将实体类对象更新到财务收入表中
	 * @param fiscalRevenue
	 * @return 影响的行数（1：添加成功；0：添加失败）
	 */
	public int update(FiscalRevenue fiscalRevenue);
	
	/**
	 * 按财务收入表Id从数据库表中查找数据
	 * @param frId 财务收入表Id
	 * @return 返回财务实体对象
	 */
	public FiscalRevenue findById(int frId);
	
	/**
	 * 从数据库表中分页查找数据
	 * @param rows 每页的数据行数
	 * @param page 当前的页数
	 * @return 指定页中的数据集合
	 */
	public List<FiscalRevenue> findByPage(int rows,int page);
	
	/**
	 * 从数据库表中按特定条件进行分页查找数据
	 * @param rows 每页的数据行数
	 * @param page 当前的页数
	 * @param condition 查询条件
	 * @return 指定页中的数据集合
	 */
	public List<FiscalRevenue> findByPage(int rows,int page,String condition);
	
	/**
	 * 统计数据库表中数据总行数
	 * @return 数据总行数
	 */
	public int count();
	
	/**
	 * 按特定条件统计数据库表中数据总行数
	 * @param condition 条件
	 * @return 符合条件的数据总行数
	 */
	public int  count(String condition);
}
