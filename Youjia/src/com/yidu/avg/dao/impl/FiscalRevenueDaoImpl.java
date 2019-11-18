package com.yidu.avg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.yidu.avg.dao.FiscalRevenueDao;
import com.yidu.avg.domain.FiscalRevenue;
import com.yidu.avg.utils.JdbcUtils;
/**
 * 
 * 功能：数据层
 * @author d280 avenger组 李卫
 * 编写日期： 2019年10月18日上午10:54:27
 * 版本：1.0
 */
public class FiscalRevenueDaoImpl implements FiscalRevenueDao {

	/**
	 * 将实体类对象添加到数据库表中（一行）
	 * @param fiscalRevenue 财务收入实体类对象
	 * @return 影响的行数（1：添加成功；0：添加失败）
	 */
	@Override
	public int add(FiscalRevenue fiscalRevenue) {

		//定义一个影响行数的变量
		int rows = 0;
		//声明数据库连接对象
		Connection conn=null;
		//声明预编译语句对象
		PreparedStatement pstmt=null;
		try {
			//实例化数据库连接对象
			conn=JdbcUtils.getConnection();
			//定义SQL语句字符串
			String sql="INSERT INTO fiscaLRevenue(soId,frTime,frMoney) VALUES(?,?,?)";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			//pstmt.setInt(1, fiscalRevenue.getFrId());
			pstmt.setInt(1, fiscalRevenue.getSoId());
			
			//将字符串转换成数据库端日期数据
			pstmt.setDate(2, java.sql.Date.valueOf(fiscalRevenue.getFrTime()));
			
			pstmt.setDouble(3, fiscalRevenue.getFrMoney());

			//执行语句对象，并返回影响的行数
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}finally{
			//关闭结果集，语句对象，数据库连接对象
			JdbcUtils.close(null, pstmt, conn);
		}
		return rows;
	}

	/**
	 * 按财务收入表Id(主键) 进行删除数据
	 * @param frId
	 * @return 影响的行数（1：添加成功；0：添加失败）
	 */
	@Override
	public int deleteById(int frId) {

		//定义一个影响行数的变量
		int rows = 0;
		//声明数据库连接对象
		Connection conn = null;
		//声明预编译语句对象
		PreparedStatement pstmt = null;
		try {
			//实例化数据库连接对象
			conn=JdbcUtils.getConnection();
			//定义SQL语句字符串
			String sql="delete from fiscalRevenue where frId=?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, frId);
			//执行语句对象，并返回影响的行数
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}finally{
			//关闭结果集，语句对象，数据库连接对象
			JdbcUtils.close(null, pstmt, conn);
		}
		return rows;
	}

	/**
	 * 将实体类对象更新到财务收入表中
	 * @param fiscalRevenue
	 * @return 影响的行数（1：添加成功；0：添加失败）
	 */
	@Override
	public int update(FiscalRevenue fiscalRevenue) {

		//定义一个影响行数的变量
		int rows=0;
		//声明数据库连接对象
		Connection conn=null;
		//声明预语句对象
		PreparedStatement pstmt=null;
		try {
			//实例化数据库连接对象 
			conn=JdbcUtils.getConnection();
			//定义SQL语句字符串
			String sql="update fiscalRevenue set soId=?,"
					+ "frTime=?,frMoney=? where frId=?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, fiscalRevenue.getSoId());
			//将字符串转换成数据库端日期数据
			pstmt.setDate(2, java.sql.Date.valueOf(fiscalRevenue.getFrTime()));
			pstmt.setDouble(3, fiscalRevenue.getFrMoney());
			pstmt.setInt(4, fiscalRevenue.getFrId());
			
			//执行语句对象，并返回影响的行数
			rows=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭结果集、语句对象、数据库连接对象
			JdbcUtils.close(null, pstmt, conn);
		}
		//返回影响的行数
		return rows;
	}

	
	/**
	 * 按财务收入表Id从数据库表中查找数据
	 * @param frId 财务收入表Id
	 * @return 返回财务实体对象
	 */
	@Override
	public FiscalRevenue findById(int frId) {
		//建立一个对象
		FiscalRevenue fiscalRevenue=null;
		//声明数据库连接对象
		Connection conn=null;
		//声明预编译语句对象
		PreparedStatement pstmt=null;
		//声明结果集对象
		ResultSet rs=null;
		try {
			//实例化数据库连接对象
			conn=JdbcUtils.getConnection();
			//定义SQL字符串
			String sql="select * from fiscalRevenue where frId=?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, frId);
			//实例化结果集对象
			rs=pstmt.executeQuery();
			//根据结果集，判断并将数据保存到对象中
			if(rs.next()){
				//建立一个对象
				fiscalRevenue=new FiscalRevenue();
				//将数据保存到对象中
				fiscalRevenue.setFrId(rs.getInt("frId"));
				fiscalRevenue.setSoId(rs.getInt("soId"));
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				fiscalRevenue.setFrTime(sdf.format(rs.getString("frTime")));
				fiscalRevenue.setFrMoney(rs.getDouble("frMoney"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭结果集，语句对象，数据库连接对象
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回一个对象
		return fiscalRevenue;
	}

	/**
	 * 从数据库表中分页查找数据
	 * @param rows 每页的数据行数
	 * @param page 当前的页数
	 * @return 指定页中的数据集合
	 */
	@Override
	public List<FiscalRevenue> findByPage(int rows, int page) {
		//定义一个集合
		List<FiscalRevenue> fiscalRevenueList=new ArrayList<FiscalRevenue>();
		//声明数据库连接对象
		Connection conn=null;
		//声明预编译语句对象
		PreparedStatement pstmt=null;
		//声明结果集对象
		ResultSet rs=null;
		try {
			//实例化数据库连接对象
			conn=JdbcUtils.getConnection();
			//定义SQL语句字符串
			String sql="select * from fiscalRevenue limit ?,?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			//实例化结果集对象
			rs=pstmt.executeQuery();
			//利用循环遍历出结果集中的数据，保存到对象中
			while(rs.next()){
				//创建一个对象
				FiscalRevenue fiscalRevenue=new FiscalRevenue();
				//将数据保存到对象中
				fiscalRevenue.setFrId(rs.getInt("frId"));
				fiscalRevenue.setSoId(rs.getInt("soId"));
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				fiscalRevenue.setFrTime(sdf.format(rs.getDate("frTime")));
				fiscalRevenue.setFrMoney(rs.getDouble("frMoney"));
				//将对象添加到集合中
				fiscalRevenueList.add(fiscalRevenue);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭结果集，语句对象，数据库连接对象
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回一个集合
		return fiscalRevenueList;
	}

	/**
	 * 从数据库表中按特定条件进行分页查找数据
	 * @param rows 每页的数据行数
	 * @param page 当前的页数
	 * @param condition 查询条件
	 * @return 指定页中的数据集合
	 */
	@Override
	public List<FiscalRevenue> findByPage(int rows, int page, String condition) {
		//定义一个集合
		List<FiscalRevenue> fiscalRevenueList=new ArrayList<FiscalRevenue>();
		//声明数据库连接对象
		Connection conn=null;
		//声明预编译语句对象
		PreparedStatement pstmt=null;
		//声明结果集对象
		ResultSet rs=null;
		try {
			//实例化数据库连接对象
			conn=JdbcUtils.getConnection();
			//定义SQL语句字符串
			String sql="select * from fiscalRevenue "+condition+" limit ?,?";
			//实例化语句对象
			pstmt=conn.prepareStatement(sql);
			//给SQL中参数赋值
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			//实例化结果集对象
			rs=pstmt.executeQuery();
			//利用循环遍历出结果集中数据，并保存到对象中
			while(rs.next()){
				//建立一个对象
				FiscalRevenue fiscalRevenue=new FiscalRevenue();
				//将数据保存到对象中
				fiscalRevenue.setFrId(rs.getInt("frId"));
				fiscalRevenue.setSoId(rs.getInt("soId"));
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				fiscalRevenue.setFrTime(sdf.format(rs.getDate("frTime")));
				fiscalRevenue.setFrMoney(rs.getDouble("frMoney"));
				//将对象添加到集合中
				fiscalRevenueList.add(fiscalRevenue);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭结果集，语句对象，数据库连接对象
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回一个集合
		return fiscalRevenueList;
	}

	/**
	 * 统计数据库表中数据总行数
	 * @return 数据总行数
	 */
	@Override
	public int count() {
		//定义一个影响行数的变量
		int rows=0;
		//声明数据库连接对象
		Connection conn=null;
		//声明预编译语句对象
		PreparedStatement pstmt=null;
		//声明结果集对象
		ResultSet rs=null;
		try {
			//实例化结果集对象
			conn=JdbcUtils.getConnection();
			//定义SQL语句字符串
			String sql="select count(*) from fiscalRevenue";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//实例化结果集对象
			rs=pstmt.executeQuery();
			//根据结果集，判断并将数据保存到对象中
			if(rs.next()){
				rows=rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭结果集，语句对象，数据库连接对象
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回影响的行数
		return rows;
	}

	/**
	 * 按特定条件统计数据库表中数据总行数
	 * @param condition 条件
	 * @return 符合条件的数据总行数
	 */
	@Override
	public int count(String condition) {
		//定义一个影响行数的变量
		int rows=0;
		//声明数据库连接对象
		Connection conn=null;
		//声明预编译语句对象
		PreparedStatement pstmt=null;
		//声明结果集对象
		ResultSet rs=null;
		try {
			//实例化数据库连接对象
			conn=JdbcUtils.getConnection();
			//定义SQL语句字符串
			String sql="select count(*) from fiscalRevenue "+condition;
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//实例化结果集对象
			rs=pstmt.executeQuery();
			//根据结果集，判断并将数据保存到对象中
			if(rs.next()){
				rows=rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭结果集，语句对象，数据库连接对象
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回影响的行数
		return rows;
	}

}
