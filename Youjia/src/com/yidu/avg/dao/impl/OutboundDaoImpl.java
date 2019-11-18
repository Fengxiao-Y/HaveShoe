package com.yidu.avg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.yidu.avg.dao.OutboundDao;
import com.yidu.avg.domain.Outbound;
import com.yidu.avg.utils.JdbcUtils;
/**
 * 
 * 功能：数据层
 * @author d280 avenger组
 * 编写日期： 2019年10月18日上午11:54:23
 * 版本：1.0
 */
public class OutboundDaoImpl implements OutboundDao {

	@Override
	public int add(Outbound outbound) {
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
			String sql="insert into outbound(obTime,"
					+ "soId,odNumber,marId,itId) values(?,?,?,?,?)";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			//pstmt.setInt(1, outbound.getObId());
			//将字符串转换成日期数据
			pstmt.setDate(1, java.sql.Date.valueOf(outbound.getObTime()));
			pstmt.setInt(2, outbound.getSoId());
			pstmt.setInt(3, outbound.getOdNumber());
			pstmt.setInt(4, outbound.getMarId());
			pstmt.setInt(5, outbound.getItId());
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
	public int delete(int obId) {
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
			String sql="delete from outbound where obId=?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, obId);
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
	public int update(Outbound outbound) {
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
			String sql="update outbound set obTime=?,soId=?,"
					+ "odNumber=?,marId=?,itId=? where obId=?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(6, outbound.getObId());
			//将字符串转换成日期数据
			pstmt.setDate(1, java.sql.Date.valueOf(outbound.getObTime()));
			pstmt.setInt(2, outbound.getSoId());
			pstmt.setInt(3, outbound.getOdNumber());
			pstmt.setInt(4, outbound.getMarId());
			pstmt.setInt(5, outbound.getItId());
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
	 * 
	 */
	@Override
	public Outbound findById(int obId) {
		//声明对象
		Outbound outbound=null;
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
			String sql="select * from outbound where obId=?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, obId);
			rs=pstmt.executeQuery();
			//判断结果集中是否有数据
			if(rs.next()){
				outbound=new Outbound();
				outbound.setObId(rs.getInt("obId"));
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				outbound.setObTime(sdf.format(rs.getDate("obTime")));
				outbound.setSoId(rs.getInt("soId"));
				outbound.setOdNumber(rs.getInt("odNumber"));
				outbound.setMarId(rs.getInt("marId"));
				outbound.setItId(rs.getInt("itId"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭结果集、语句对象、数据库连接对象
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回影响的行数
		return outbound;
	}

	@Override
	public List<Outbound> findAll() {
		
		return null;
	}

	@Override
	public List<Outbound> findByPage(int rows, int page) {
		//定义对象集合
		List<Outbound> outboundList=new ArrayList<Outbound>();
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
			String sql="select * from outbound limit ?,?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			//给结果集赋值
			rs=pstmt.executeQuery();
			while(rs.next()){
				Outbound outbound=new Outbound();
				outbound.setObId(rs.getInt("obId"));
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				outbound.setObTime(sdf.format(rs.getDate("obTime")));
				outbound.setSoId(rs.getInt("soId"));
				outbound.setOdNumber(rs.getInt("odNumber"));
				outbound.setMarId(rs.getInt("marId"));
				outbound.setItId(rs.getInt("itId"));
				outboundList.add(outbound);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭结果集、语句对象、数据库连接对象
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回影响的行数
		return outboundList;
	}

	@Override
	public List<Outbound> findByPage(int rows, int page, String condition) {
		//定义对象集合
		List<Outbound> outboundList=new ArrayList<Outbound>();
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
			String sql="select * from outbound "+condition+" limit ?,? ";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Outbound outbound=new Outbound();
				outbound.setObId(rs.getInt("obId"));
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				outbound.setObTime(sdf.format(rs.getDate("obTime")));
				outbound.setSoId(rs.getInt("soId"));
				outbound.setOdNumber(rs.getInt("odNumber"));
				outbound.setMarId(rs.getInt("marId"));
				outbound.setItId(rs.getInt("itId"));
				outboundList.add(outbound);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭结果集、语句对象、数据库连接对象
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回影响的行数
		return outboundList;
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
			String sql="select count(*) from outbound";
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
			String sql="select count(*) from outbound"+condition;
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
