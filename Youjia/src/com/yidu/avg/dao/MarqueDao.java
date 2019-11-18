package com.yidu.avg.dao;

import java.util.List;

import com.yidu.avg.domain.Marque;
/**
 * 
 * 功能：实体类接口
 * @author d280 avenger组
 * 编写日期： 2019年10月17日下午1:23:45
 * 版本：1.0
 */
public interface MarqueDao {
	//增
	public int add(Marque marque);
	//删
	public int deleteById(int marId);
 	//修改
 	public int update(Marque marque);
 	//查
 	public Marque findById(int ctId);
 	/**
 	 * 分页查找
 	 * @param rows 每页显示记录
 	 * @param page 当前显示的码数
 	 * @return 指定页中所有商品信息集合
 	 */
 	public List<Marque> findByPage(int rows,int page);
 	/**
	 * 按条件分页查找
	 * @param rows 每页显示的记录数
	 * @param page 当前显示的码数
	 * @param condition 条件
	 * @return
	 */
 	public List<Marque> findByPage(int rows,int page,String condition);
 	/**
	 * 统计记录数
	 * @return 表中所有记录行数
	 */
 	public int count();
 	/**
 	 * 按特定条件进行统计数据
	 * @param condition 条件
	 * @return 标中所有符合条件的数据记录行数
 	 */
 	public int count(String condition);
}
