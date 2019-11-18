package com.yidu.avg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yidu.avg.dao.CommodityTypeDao;
import com.yidu.avg.domain.CommodityType;
import com.yidu.avg.domain.Marque;
import com.yidu.avg.utils.JdbcUtils;
/**
 * 
 * 功能：数据层
 * @author d280 avenger组 罗煜霖
 * 编写日期： 2019年10月18日下午3:53:47
 * 版本：1.0
 */
public class CommodityTypeDaoImpl implements CommodityTypeDao {

	/**
	 * 将实体类对象添加到数据库表中（一行）
	 * @param CommodityType 财务支出实体类对象
	 * @return 影响的行数(1：添加成功，0：添加失败)
	 */
	@Override
	public int add(CommodityType commodityType) {
		//声明链接对象
		Connection conn=null;
		//声明语句对象
		PreparedStatement pstmt=null;
		//定义一个影响行数的变量
		int row=0;
		try {  
			//实列化连接对象
			conn=JdbcUtils.getConnection();
			String sql="insert into commodityType(ctName) values(?)";
			//实列化语句对象
			pstmt=conn.prepareStatement(sql);
			//pstmt.setInt(1, commodityType.getCtId());
			pstmt.setString(1, commodityType.getCtName());;
			row=pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		
		}finally{
			//关闭结果集
			JdbcUtils.close(null, pstmt, conn);
		}
		//返回影响行数
		return row;
	}

	@Override
	public int deleteById(int ctId) {
		//声明链接对象
		Connection conn=null;
		//声明语句对象
		PreparedStatement pstmt=null;
		//System.out.println("1111");
		//定义一个影响行数的变量
		int row=0;
		try {
			//实列化连接对象
			conn=JdbcUtils.getConnection();
			String sql="delete from commodityType where ctId=?";
			//实列化语句对象
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, ctId);
			row=pstmt.executeUpdate();
			//System.out.println("1111");
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		
		}finally{
			//关闭结果集
			JdbcUtils.close(null, pstmt, conn);
		}
		//返回影响行数
		return row;
	}

	@Override
	public int update(CommodityType commodityType) {
		//声明链接对象
		Connection conn=null;
		//声明语句对象
		PreparedStatement pstmt=null;
		//定义一个影响行数的变量
		int row=0;
		try {
			//实列化连接对象
			conn=JdbcUtils.getConnection();
			//编译SQL执行语句
			String sql="update commodityType set ctName=? where ctId=?";
		
			//实列化语句对象
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, commodityType.getCtName());
			pstmt.setInt(2, commodityType.getCtId());
			row=pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		
		}finally{
			//关闭结果集,语句对象，数据库链接对象
			JdbcUtils.close(null, pstmt, conn);
		}
		//返回影响行数
		return row;	
				
	}

	@Override
	public CommodityType findById(int ctId) {
		//建一个空对象
		CommodityType CommodityType=null;
		//声明链接对象
		Connection conn=null;
		//声明语句对象
		PreparedStatement pstmt=null;
		//声明一个结果集对象
		ResultSet rs=null;
		
			try {
				//实列化连接对象
				conn=JdbcUtils.getConnection();
				//编译SQL执行语句
				String sql="select * from CommodityType where ctId=?";
				//实例化预编译语句对象
				pstmt=conn.prepareStatement(sql);
				//给参数赋值
				pstmt.setInt(1, ctId);
				//执行语句对象，并返回影响的行数
				rs=pstmt.executeQuery();
				if(rs.next()){
					CommodityType=new CommodityType();
					CommodityType.setCtId(rs.getInt("ctId"));
					CommodityType.setCtName(rs.getString("ctName"));
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage(),e);
			
			}finally {
				//关闭结果集,语句对象，数据库链接对象
				JdbcUtils.close(rs, pstmt, conn);
			}
		
	     return CommodityType;
	}

	@Override
	public List<CommodityType> findByPage(int rows, int page) {
		List<CommodityType> CommodityTypeList=new ArrayList<CommodityType>();
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
			String sql="select * from CommodityType limit?,?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			rs=pstmt.executeQuery();
			while(rs.next()){
				CommodityType CommodityType=new CommodityType();
				CommodityType.setCtId(rs.getInt("ctId"));
				CommodityType.setCtName(rs.getString("ctName"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}finally {
			//关闭结果集、语句对象、数据库连接对象
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回影响的行数
		return CommodityTypeList;
	}

	@Override
	public List<CommodityType> findByPage(int rows, int page, String condition) {
		List<CommodityType> commodityTypeList=new ArrayList<CommodityType>();
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
			String sql="select * from CommodityType "+condition+" limit ?,?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			rs=pstmt.executeQuery();
			while(rs.next()){
				CommodityType commodityType=new CommodityType();
				commodityType.setCtId(rs.getInt("ctId"));
				commodityType.setCtName(rs.getString("ctName"));
				commodityTypeList.add(commodityType);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}finally {
			//关闭结果集、语句对象、数据库连接对象
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回影响的行数
		return commodityTypeList;
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
			String sql="select count(*) from CommodityType";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给结果集赋值
			rs=pstmt.executeQuery();
			if(rs.next()){
				rows=rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}finally {
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
			String sql="select count(*) from CommodityType"+condition;
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给结果集赋值
			rs=pstmt.executeQuery();
			if(rs.next()){
				rows=rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}finally{
			//关闭结果集、语句对象、数据库连接对象
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回影响的行数
		return rows;

	}

}
