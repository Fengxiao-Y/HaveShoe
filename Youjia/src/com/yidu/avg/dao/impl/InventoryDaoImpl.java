package com.yidu.avg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;
import com.yidu.avg.dao.InventoryDao;
import com.yidu.avg.domain.Inventory;
import com.yidu.avg.utils.JdbcUtils;
/**
 * 
 * 功能：数据层
 * @author d280 avenger组 王翌
 * 编写日期： 2019年10月18日上午10:55:23
 * 版本：1.0
 */
public class InventoryDaoImpl implements InventoryDao {

	@Override
	public int add(Inventory inventory) {
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
			String sql="insert into inventory(itNumber,"
					+ "ctId) values(?,?)";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			//pstmt.setInt(1, inventory.getItId());
			pstmt.setInt(1, inventory.getItNumber());
			pstmt.setInt(2, inventory.getCtId());
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
	public int delete(int itId) {
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
			String sql="delete from inventory where itId=?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, itId);
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
	public int update(Inventory inventory) {
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
			String sql="update inventory set itNumber=?,ctId=? where itId=?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, inventory.getItNumber());
			pstmt.setInt(2, inventory.getCtId());
			pstmt.setInt(3, inventory.getItId());
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
	public Inventory findById(int itId) {
		//声明对象
		Inventory inventory=null;
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
			String sql="select * from inventory where itId=?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, itId);
			rs=pstmt.executeQuery();
			//判断结果集中是否有数据
			if(rs.next()){
				inventory=new Inventory();
				inventory.setItId(rs.getInt("itId"));
				inventory.setItNumber(rs.getInt("itNumber"));
				inventory.setCtId(rs.getInt("ctId"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭结果集、语句对象、数据库连接对象
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回影响的行数
		return inventory;
	}

	@Override
	public List<Inventory> findAll() {
		
		return null;
	}

	@Override
	public List<Inventory> findByPage(int rows, int page) {
		List<Inventory> inventoryList=new ArrayList<Inventory>();
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
			String sql="select * from inventory limit ?,?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			//给结果集赋值
			rs=pstmt.executeQuery();
			while(rs.next()){
				Inventory inventory=new Inventory();
				inventory.setItId(rs.getInt("itId"));
				inventory.setItNumber(rs.getInt("itNumber"));
				inventory.setCtId(rs.getInt("ctId"));
				inventoryList.add(inventory);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭结果集、语句对象、数据库连接对象
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回影响的行数
		return inventoryList;
	}

	@Override
	public List<Inventory> findByPage(int rows, int page, String condition) {
		List<Inventory> inventoryList=new ArrayList<Inventory>();
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
			String sql="select * from inventory "+condition+" limit ?,? ";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Inventory inventory=new Inventory();
				inventory.setItId(rs.getInt("itId"));
				inventory.setItNumber(rs.getInt("itNumber"));
				inventory.setCtId(rs.getInt("ctId"));
				inventoryList.add(inventory);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭结果集、语句对象、数据库连接对象
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回影响的行数
		return inventoryList;
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
			String sql="select count(*) from inventory";
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
			String sql="select count(*) from inventory"+condition;
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
	public int findcountById(int itId) {
		//声明对象
		Inventory inventory=null;
		//声明数据库连接对象
		Connection conn=null;
		//声明预语句对象
		PreparedStatement pstmt=null;
		//声明结果集
		ResultSet rs=null;
		
		int itNumber =0;
		try {
			//实例化数据库连接对象 
			conn=JdbcUtils.getConnection();
			//定义SQL语句字符串
			String sql="select itNumber from inventory where itId=?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, itId);
			
			rs=pstmt.executeQuery();
			//判断结果集中是否有数据
			if(rs.next()){
				itNumber =rs.getInt("itNumber");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭结果集、语句对象、数据库连接对象
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回影响的行数
		return itNumber;
	}
	@Override
	public int updateinNumber(int itNumber,int idId) {
		//定义一个影响行数的变量
		int rows=0;
		//声明数据库连接对象
		Connection conn=null;
		//声明语句对象
		PreparedStatement pstmt=null;
		//声明一个结果集对象
		ResultSet rs =null;
		//定义一个变量
		int count=0;
		try {
			//实例化数据库连接对象 
			conn=JdbcUtils.getConnection();
			//定义SQL语句字符串
			String sql="update inventory set itNumber=? where itId=?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, itNumber);
			pstmt.setInt(2, idId);
			//执行语句对象，并返回影响的行数
			rows =pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭结果集、语句对象、数据库连接对象
			JdbcUtils.close(null, pstmt, conn);
		}
		//返回影响的行数
		return rows;
	}
}
