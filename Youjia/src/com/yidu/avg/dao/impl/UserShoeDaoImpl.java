package com.yidu.avg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yidu.avg.dao.UserShoeDao;
import com.yidu.avg.domain.UserShoe;
import com.yidu.avg.utils.JdbcUtils;
/**
 * 
 * 功能：数据层
 * @author d280 avenger组
 * 编写日期： 2019年10月18日下午5:53:51
 * 版本：1.0
 */
public class UserShoeDaoImpl implements UserShoeDao {

	@Override
	public int add(UserShoe userShoe) {
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
			String sql="insert into userShoe(usName,"
					+ "usPwd,usSex,usEmail,usAddress,usPhone,"
					+ "usPostal) values(?,?,?,?,?,?,?)";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			//pstmt.setInt(1, userShoe.getUsId());
			pstmt.setString(1, userShoe.getUsName());
			pstmt.setString(2, userShoe.getUsPwd());
			pstmt.setString(3, userShoe.getUsSex());
			pstmt.setString(4, userShoe.getUsEmail());
			pstmt.setString(5, userShoe.getUsAddress());
			pstmt.setString(6, userShoe.getUsPhone());
			pstmt.setString(7, userShoe.getUsPostal());	
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
	public int delete(int usId) {
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
			String sql="delete from userShoe where usId=?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, usId);
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
	public int update(UserShoe userShoe) {
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
			String sql="update userShoe set usName=?,usPwd=?,"
					+ "usSex=?,usEmail=?,usAddress=?,"
					+ "usPhone=?,usPostal=? where usId=?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			
			pstmt.setString(1, userShoe.getUsName());
			pstmt.setString(2, userShoe.getUsPwd());
			pstmt.setString(3, userShoe.getUsSex());
			pstmt.setString(4, userShoe.getUsEmail());
			pstmt.setString(5, userShoe.getUsAddress());
			pstmt.setString(6, userShoe.getUsPhone());
			pstmt.setString(7, userShoe.getUsPostal());	
			pstmt.setInt(8, userShoe.getUsId());
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
	public UserShoe findById(int usId) {
		//声明对象
		UserShoe userShoe=null;
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
			String sql="select * from userShoe where usId=?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, usId);
			rs=pstmt.executeQuery();
			//判断结果集中是否有数据
			if(rs.next()){
				userShoe=new UserShoe();
				userShoe.setUsId(rs.getInt("usId"));
				userShoe.setUsName(rs.getString("usName"));
				userShoe.setUsPwd(rs.getString("usPwd"));
				userShoe.setUsSex(rs.getString("usSex"));
				userShoe.setUsEmail(rs.getString("usEmail"));
				userShoe.setUsAddress(rs.getString("usAddress"));
				userShoe.setUsPhone(rs.getString("usPhone"));
				userShoe.setUsPostal(rs.getString("usPostal"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭结果集、语句对象、数据库连接对象
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回影响的行数
		return userShoe;
	}

	@Override
	public List<UserShoe> findAll() {
		
		return null;
	}

	@Override
	public List<UserShoe> findByPage(int rows, int page) {
		List<UserShoe> userShoeList=new ArrayList<UserShoe>();
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
			String sql="select * from userShoe limit ?,?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			//给结果集赋值
			rs=pstmt.executeQuery();
			while(rs.next()){
				UserShoe userShoe=new UserShoe();
				userShoe.setUsId(rs.getInt("usId"));
				userShoe.setUsName(rs.getString("usName"));
				userShoe.setUsPwd(rs.getString("usPwd"));
				userShoe.setUsSex(rs.getString("usSex"));
				userShoe.setUsEmail(rs.getString("usEmail"));
				userShoe.setUsAddress(rs.getString("usAddress"));
				userShoe.setUsPhone(rs.getString("usPhone"));
				userShoe.setUsPostal(rs.getString("usPostal"));
				userShoeList.add(userShoe);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭结果集、语句对象、数据库连接对象
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回影响的行数
		return userShoeList;
	}

	@Override
	public List<UserShoe> findByPage(int rows, int page, String condition) {
		List<UserShoe> userShoeList=new ArrayList<UserShoe>();
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
			String sql="select * from userShoe "+condition+" limit ?,? ";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			rs=pstmt.executeQuery();
			while(rs.next()){
				UserShoe userShoe=new UserShoe();
				userShoe.setUsId(rs.getInt("usId"));
				userShoe.setUsName(rs.getString("usName"));
				userShoe.setUsPwd(rs.getString("usPwd"));
				userShoe.setUsSex(rs.getString("usSex"));
				userShoe.setUsEmail(rs.getString("usEmail"));
				userShoe.setUsAddress(rs.getString("usAddress"));
				userShoe.setUsPhone(rs.getString("usPhone"));
				userShoe.setUsPostal(rs.getString("usPostal"));
				userShoeList.add(userShoe);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭结果集、语句对象、数据库连接对象
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回影响的行数
		return userShoeList;
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
			String sql="select count(*) from userShoe";
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
			String sql="select count(*) from userShoe"+condition;
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
