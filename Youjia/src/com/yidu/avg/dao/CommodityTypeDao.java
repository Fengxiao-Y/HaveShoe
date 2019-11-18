package com.yidu.avg.dao;

import java.util.List;

import com.yidu.avg.domain.CommodityType;

/**
 * 
 * 功能：实体类接口
 * @author d280 avenger组
 * 编写日期： 2019年10月17日下午3:23:56
 * 版本：1.0
 */
public interface CommodityTypeDao {
	/**
	 * 
	 * @param commodityType
	 * @return
	 */
   public int add(CommodityType commodityType);
 	//删除
 	public int deleteById(int ctId);
 	//修改
 	public int update(CommodityType commodityType);
 	
 	public CommodityType findById(int ctId);
 	/**
 	 * 分页查找
 	 * @param rows 每页显示记录
 	 * @param page 当前显示的码数
 	 * @return 指定页中所有商品信息集合
 	 */
 	public List<CommodityType> findByPage(int rows,int page);
 	/**
	 * 按条件分页查找
	 * @param rows 每页显示的记录数
	 * @param page 当前显示的码数
	 * @param condition 条件
	 * @return
	 */
 	public List<CommodityType> findByPage(int rows,int page,String condition);
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
