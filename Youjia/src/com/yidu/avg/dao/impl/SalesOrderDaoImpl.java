package com.yidu.avg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.yidu.avg.dao.SalesOrderDao;
import com.yidu.avg.domain.SalesOrder;
import com.yidu.avg.utils.JdbcUtils;
/**
 * 
 * 功能：数据层
 * @author d280 avenger组
 * 编写日期： 2019年10月18日上午10:23:45
 * 版本：1.0
 */
public class SalesOrderDaoImpl implements SalesOrderDao {
	/**
	 * 将实体类对象添加到数据库表中(一行)
	 * @param salesOrder 销售订单表实体类对象
	 * @return 影响的行数(1:添加成功;0:添加失败)
	 */
	@Override
	public int add(SalesOrder salesOrder) {
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
			String sql="insert into salesOrder(soTime,"
					+ "usId,marId,counts,subtotal,spId) values(?,?,?,?,?,?)";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			//pstmt.setInt(1, salesOrder.getSoId());
			//将字符串转换成日期数据
			pstmt.setDate(1, java.sql.Date.valueOf(salesOrder.getSoTime()));
			pstmt.setInt(2, salesOrder.getUsId());
			pstmt.setInt(3, salesOrder.getMarId());
			pstmt.setInt(4, salesOrder.getCounts());
			pstmt.setDouble(5, salesOrder.getSubtotal());
			pstmt.setInt(6, salesOrder.getspId());
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

	@Override
	public int delete(int soId) {
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
			String sql="delete from salesOrder where soId=?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, soId);
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

	@Override
	public int update(SalesOrder salesOrder) {
		//定义一个影响行数的变量
		int rows=0;
		//声明数据库连接对象
		Connection conn=null;
		//声明语句对象
		PreparedStatement pstmt=null;
		try {
			//实例化数据库连接对象 
			conn=JdbcUtils.getConnection();
			//定义SQL语句字符串
			String sql="update salesOrder set soTime=?,usId=?,"
					+ "marId=?,counts=?,subtotal=?,"
					+ "spId=? where soId=?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(7, salesOrder.getSoId());
			//将字符串转换成日期数据
			pstmt.setDate(1, java.sql.Date.valueOf(salesOrder.getSoTime()));
			pstmt.setInt(2, salesOrder.getUsId());
			pstmt.setInt(3, salesOrder.getMarId());
			pstmt.setInt(4, salesOrder.getCounts());
			pstmt.setDouble(5, salesOrder.getSubtotal());
			pstmt.setInt(6, salesOrder.getspId());
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

	@Override
	public SalesOrder findById(int soId) {
		//声明对象
		SalesOrder salesOrder=null;
		//声明数据库连接对象
		Connection conn=null;
		//声明预语句对象
		PreparedStatement pstmt=null;
		//声明结果集
		ResultSet rs=null;
		try {
			//实例化数据库连接对象 
			conn=JdbcUtils.getConnection();
			//定义SQL语句字符串
			String sql="select * from salesOrder where soId=?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, soId);
			rs=pstmt.executeQuery();
			//判断结果集中是否有数据
			if(rs.next()){
				salesOrder=new SalesOrder();
				salesOrder.setSoId(rs.getInt("soId"));
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				salesOrder.setSoTime(sdf.format(rs.getDate("soTime")));
				salesOrder.setUsId(rs.getInt("usId"));
				salesOrder.setMarId(rs.getInt("marId"));			
				salesOrder.setCounts(rs.getInt("counts"));
				salesOrder.setSubtotal(rs.getDouble("subtotal"));
				salesOrder.setspId(rs.getInt("spId"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭结果集、语句对象、数据库连接对象
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回影响的行数
		return salesOrder;
	}

	@Override
	public List<SalesOrder> findAll() {
		return null;
	}

	@Override
	public List<SalesOrder> findByPage(int rows, int page) {
		List<SalesOrder> salesOrderList=new ArrayList<SalesOrder>();
		//声明数据库连接对象
		Connection conn=null;
		//声明预语句对象
		PreparedStatement pstmt=null;
		//声明结果集
		ResultSet rs=null;
		try {
			//实例化数据库连接对象 
			conn=JdbcUtils.getConnection();
			//定义SQL语句字符串
			String sql="select * from salesOrder limit ?,?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			//给结果集赋值
			rs=pstmt.executeQuery();
			while(rs.next()){
				SalesOrder salesOrder=new SalesOrder();
				salesOrder.setSoId(rs.getInt("soId"));
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				salesOrder.setSoTime(sdf.format(rs.getDate("soTime")));
				salesOrder.setUsId(rs.getInt("usId"));
				salesOrder.setMarId(rs.getInt("marId"));			
				salesOrder.setCounts(rs.getInt("counts"));
				salesOrder.setSubtotal(rs.getDouble("subtotal"));
				salesOrder.setspId(rs.getInt("spId"));
				salesOrderList.add(salesOrder);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭结果集、语句对象、数据库连接对象
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回影响的行数
		return salesOrderList;
	}

	@Override
	public List<SalesOrder> findByPage(int rows, int page, String condition) {
		List<SalesOrder> salesOrderList=new ArrayList<SalesOrder>();
		//声明数据库连接对象
		Connection conn=null;
		//声明预语句对象
		PreparedStatement pstmt=null;
		//声明结果集
		ResultSet rs=null;
		try {
			//实例化数据库连接对象 
			conn=JdbcUtils.getConnection();
			//定义SQL语句字符串
			String sql="select * from salesOrder "+condition+" limit ?,? ";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			rs=pstmt.executeQuery();
			while(rs.next()){
				SalesOrder salesOrder=new SalesOrder();
				salesOrder.setSoId(rs.getInt("soId"));
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				salesOrder.setSoTime(sdf.format(rs.getDate("soTime")));
				salesOrder.setUsId(rs.getInt("usId"));
				salesOrder.setMarId(rs.getInt("marId"));			
				salesOrder.setCounts(rs.getInt("counts"));
				salesOrder.setSubtotal(rs.getDouble("subtotal"));
				salesOrder.setspId(rs.getInt("spId"));
				salesOrderList.add(salesOrder);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭结果集、语句对象、数据库连接对象
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回影响的行数
		return salesOrderList;
	}

	@Override
	public int count() {
		//定义一个影响行数的变量
		int rows=0;
		//声明数据库连接对象
		Connection conn=null;
		//声明预语句对象
		PreparedStatement pstmt=null;
		//声明结果集
		ResultSet rs=null;
		try {
			//实例化数据库连接对象 
			conn=JdbcUtils.getConnection();
			//定义SQL语句字符串
			String sql="select count(*) from salesOrder";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给结果集赋值
			rs=pstmt.executeQuery();
			if(rs.next()){
				rows=rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭结果集、语句对象、数据库连接对象
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回影响的行数
		return rows;
	}

	@Override
	public int count(String condition) {
		//定义一个影响行数的变量
		int rows=0;
		//声明数据库连接对象
		Connection conn=null;
		//声明预语句对象
		PreparedStatement pstmt=null;
		//声明结果集
		ResultSet rs=null;
		try {
			//实例化数据库连接对象 
			conn=JdbcUtils.getConnection();
			//定义SQL语句字符串
			String sql="select count(*) from salesOrder"+condition;
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给结果集赋值
			rs=pstmt.executeQuery();
			if(rs.next()){
				rows=rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭结果集、语句对象、数据库连接对象
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回影响的行数
		return rows;
	}

}
