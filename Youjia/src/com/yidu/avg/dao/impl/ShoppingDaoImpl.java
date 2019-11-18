package com.yidu.avg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.yidu.avg.dao.ShoppingDao;
import com.yidu.avg.domain.Shopping;
import com.yidu.avg.utils.JdbcUtils;
/**
 * 
 * 功能：表格jdbc操作
 * @author d280 avenger组 罗煜霖
 * 编写日期： 2019年10月18日下午3:26:26
 * 版本：1.0
 */
public class ShoppingDaoImpl implements ShoppingDao {
	/**
	 * 将实体类对象添加到数据库表中(一行)
	 * @param shopping 客户实体类对象
	 * @return 影响的行数(1:添加成功;0:添加失败)
	 */
	@Override
	public int add(Shopping shopping) {
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
			String sql="insert into shopping(marId,spNum,spCount) values(?,?,?)";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			//pstmt.setInt(1, shopping.getspId());
			pstmt.setInt(1, shopping.getMarId());
			pstmt.setInt(2, shopping.getSpNum());
			pstmt.setDouble(3, shopping.getSpCount());
		
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
	 * 将实体类对象从数据库表中删除(一行)
	 * @param shopping 客户实体类对象
	 * @return 影响的行数(1:添加成功;0:添加失败)
	 */
	@Override
	public int delete(int spId) {
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
			String sql="delete from shopping where spId=?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, spId);
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
	 * 将数据库表中的数据修改(一行)
	 * @param shopping 客户实体类对象
	 * @return 影响的行数(1:添加成功;0:添加失败)
	 */
	@Override
	public int update(Shopping shopping) {
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
			String sql="update shopping set marId=?,spNum=?,spCount=? "
					+ "  where spId=?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, shopping.getMarId());
			pstmt.setInt(2, shopping.getSpNum());
			pstmt.setDouble(3, shopping.getSpCount());
			pstmt.setInt(4, shopping.getspId());
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
	 * 在数据库表中查询(一行)
	 * @param shopping 客户实体类对象
	 * @return 影响的行数(1:添加成功;0:添加失败)
	 */
	@Override
	public Shopping findById(int spId) {
		//声明对象
		Shopping shopping=null;
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
			String sql="select * from shopping where spId=?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, spId);
			rs=pstmt.executeQuery();
			//判断结果集中是否有数据
			if(rs.next()){
				shopping=new Shopping();
				shopping.setspId(rs.getInt("spId"));
				shopping.setMarId(rs.getInt("marId"));
				shopping.setSpNum(rs.getInt("spNum"));
				shopping.setSpCount(rs.getDouble("spcount"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭结果集、语句对象、数据库连接对象
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回影响的行数
		return shopping;
	}

	@Override
	public List<Shopping> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 分页
	 * @param shopping 客户实体类对象
	 * @return 影响的行数(1:添加成功;0:添加失败)
	 */
	@Override
	public List<Shopping> findByPage(int rows, int page) {
		List<Shopping> shopList=new ArrayList<Shopping>();
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
			String sql="select * from shopping limit ?,?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			//给结果集赋值
			rs=pstmt.executeQuery();
			while(rs.next()){
				Shopping shopping=new Shopping();
				shopping.setspId(rs.getInt("spId"));
				shopping.setMarId(rs.getInt("marId"));
				shopping.setSpNum(rs.getInt("spNum"));
				shopping.setSpCount(rs.getDouble("spcount"));
				shopList.add(shopping);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭结果集、语句对象、数据库连接对象
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回影响的行数
		return shopList;
	}

	/**
	 * 条件查询
	 * @param shopping 客户实体类对象
	 * @return 影响的行数(1:添加成功;0:添加失败)
	 */
	@Override
	public List<Shopping> findByPage(int rows, int page, String condition) {
		List<Shopping> shopList=new ArrayList<Shopping>();
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
			String sql="select * from shopping "+condition+" limit ?,?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			//给结果集赋值
			rs=pstmt.executeQuery();
			while(rs.next()){
				Shopping shopping=new Shopping();
				shopping.setspId(rs.getInt("spId"));
				shopping.setMarId(rs.getInt("marId"));
				shopping.setSpNum(rs.getInt("spNum"));
				shopping.setSpCount(rs.getDouble("spcount"));
				shopList.add(shopping);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭结果集、语句对象、数据库连接对象
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回影响的行数
		return shopList;
	}

	/**
	 * 数据库表信息总行数
	 * @param shopping 客户实体类对象
	 * @return 影响的行数(1:添加成功;0:添加失败)
	 */
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
			String sql="select count(*) from shopping";
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
	
	/**
	 * 数据库表信息总行数(添加条件)
	 * @param shopping 客户实体类对象
	 * @return 影响的行数(1:添加成功;0:添加失败)
	 */
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
			String sql="select count(*) from shopping"+condition;
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
