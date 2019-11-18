package com.yidu.avg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.yidu.avg.dao.MarqueDao;

import com.yidu.avg.domain.Marque;
import com.yidu.avg.utils.JdbcUtils;
/**
 * 
 * 功能：数据层
 * @author d280 avenger组 罗煜霖
 * 编写日期： 2019年10月18日上午9:48:46
 * 版本：1.0
 */
public class MarqueDaoImpl implements MarqueDao {



	@Override
	public int add(Marque marque) {
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
			String sql="insert into marque(marName,"
					+ "marYardage,marIntroduce,marUrl,marPrice,marConvert,"
					+ "ctId) values(?,?,?,?,?,?,?)";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值marConvert
			//pstmt.setInt(1, marque.getMarId());
			pstmt.setString(1, marque.getMarName());
			pstmt.setInt(2, marque.getMarYardage());
			pstmt.setString(3, marque.getMarIntroduce());
			pstmt.setString(4, marque.getMarUrl());
			pstmt.setDouble(5, marque.getMarprice());
			pstmt.setDouble(6, marque.getMarConvert());
			pstmt.setInt(7, marque.getCtId());
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
	public int deleteById(int marId) {
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
			String sql="delete from marque where marId=?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, marId);
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
	public int update(Marque marque) {
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
			String sql="update marque set marName=?,marYardage=?,"
					+ "marIntroduce=?,marUrl=?,marPrice=?,"
					+ "marConvert=?,ctId=? where marId=?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			
			pstmt.setString(1, marque.getMarName());
			pstmt.setInt(2, marque.getMarYardage());
			pstmt.setString(3, marque.getMarIntroduce());
			pstmt.setString(4, marque.getMarUrl());
			pstmt.setDouble(5, marque.getMarprice());
			pstmt.setDouble(6, marque.getMarConvert());
			pstmt.setInt(7, marque.getCtId());
			pstmt.setInt(8, marque.getMarId());
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
	public Marque findById(int ctId) {
		//声明对象
		Marque marque=null;
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
			String sql="select * from marque where marId=?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1,marque.getMarId());
			rs=pstmt.executeQuery();
			//判断结果集中是否有数据
			if(rs.next()){
				marque=new Marque();
				marque.setMarId(rs.getInt("marId"));
				marque.setMarName(rs.getString("marName"));
				marque.setMarYardage(rs.getInt("marYardage"));
				marque.setMarIntroduce(rs.getString("marIntroduce"));
				//SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				//marque.setMarUrl(sdf.format(rs.getDate("marUrl")));
				marque.setMarUrl(rs.getString("marUrl"));
				marque.setMarprice(rs.getDouble("marPrice"));
				marque.setMarConvert(rs.getDouble("marConvert"));
				marque.setCtId(rs.getInt("ctId"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭结果集、语句对象、数据库连接对象
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回影响的行数
		return marque;
	}

	@Override
	public List<Marque> findByPage(int rows, int page) {
		List<Marque> marqueList=new ArrayList<Marque>();
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
			String sql="select * from marque  limit ?,? ";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Marque marque=new Marque();
				marque.setMarId(rs.getInt("marId"));
				marque.setMarName(rs.getString("marName"));
				marque.setMarYardage(rs.getInt("marYardage"));
				marque.setMarIntroduce(rs.getString("marIntroduce"));
				//SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				//marque.setMarUrl(sdf.format(rs.getDate("marUrl")));
				marque.setMarUrl(rs.getString("marUrl"));
				marque.setMarprice(rs.getDouble("marPrice"));
				marque.setMarConvert(rs.getDouble("marConvert"));
				marque.setCtId(rs.getInt("ctId"));
				marqueList.add(marque);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭结果集、语句对象、数据库连接对象
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回影响的行数
		return marqueList;
	}
	@Override
	public List<Marque> findByPage(int rows, int page, String condition) {
		List<Marque> marqueList=new ArrayList<Marque>();
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
			String sql="select * from marque "+condition+" limit ?,? ";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Marque marque=new Marque();
				marque.setMarId(rs.getInt("marId"));
				marque.setMarName(rs.getString("marName"));
				marque.setMarYardage(rs.getInt("marYardage"));
				marque.setMarIntroduce(rs.getString("marIntroduce"));
				//SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				//marque.setMarUrl(sdf.format(rs.getDate("marUrl")));
				marque.setMarUrl(rs.getString("marUrl"));
				marque.setMarprice(rs.getDouble("marPrice"));
				marque.setMarConvert(rs.getDouble("marConvert"));
				marque.setCtId(rs.getInt("ctId"));
				marqueList.add(marque);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭结果集、语句对象、数据库连接对象
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回影响的行数
		return marqueList;
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
			String sql="select count(*) from marque";
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
			String sql="select count(*) from marque"+condition;
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
