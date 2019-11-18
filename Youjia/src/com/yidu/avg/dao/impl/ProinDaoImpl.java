package com.yidu.avg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.yidu.avg.dao.ProinDao;
import com.yidu.avg.domain.Proin;
import com.yidu.avg.utils.JdbcUtils;
/**
 * 
 * 功能：数据层
 * @author d280 avenger组 邓威
 * 编写日期： 2019年10月18日下午11:57:11
 * 版本：1.0
 */
public class ProinDaoImpl implements ProinDao {
	/**
	 * 将实体类对象添加到数据库表中(一行)
	 * @param outbound 出库实体类对象
	 * @return 影响的行数(1:添加成功;0:添加失败)
	 */
	@Override
	public int add(Proin proin) {
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
			String sql="insert into proin(pTime,"
					+ "poId,pNumber,marId,itId) values(?,?,?,?,?)";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			//pstmt.setInt(1, proin.getpId());
			//将字符串转换成日期数据
			pstmt.setString(1, proin.getpTime());
			//pstmt.setTimestamp(1, java.sql.Date.valueOf(proin.getpTime()));
			//pstmt.setTime(1, java.sql.Time.valueOf(proin.getpTime()));
			pstmt.setInt(2, proin.getPoId());
			pstmt.setInt(3, proin.getpNumber());
			pstmt.setInt(4, proin.getMarId());
			pstmt.setInt(5, proin.getItId());
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
	 * 按入库表id(主键)进行删除数据
	 * @param pId 
	 * @return 
	 */
	@Override
	public int delete(int pId) {
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
			String sql="delete from proin where pId=?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, pId);
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
	 * 将实体类对象更新到数据库表中
	 * @param outbound 
	 * @return
	 */
	@Override
	public int update(Proin proin) {
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
			String sql="update proin set pTime=?,"
					+ "poId=?,pNumber=?,marId=?,"
					+ "itId=? where pId=?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			//将字符串转换成日期数据
			pstmt.setString(1, proin.getpTime());
			pstmt.setInt(2, proin.getPoId());
			pstmt.setInt(3, proin.getpNumber());
			pstmt.setInt(4, proin.getMarId());
			pstmt.setInt(5, proin.getItId());
			pstmt.setInt(6, proin.getpId());
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
	 * 根据入库id查找单个入库信息
	 * @param pId
	 * @return
	 */
	@Override
	public Proin findById(int pId) {
		//声明对象
		Proin proin=null;
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
			String sql="select * from proin where pId=?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, pId);
			rs=pstmt.executeQuery();
			//判断结果集中是否有数据
			if(rs.next()){
				proin=new Proin();
				proin.setpId(rs.getInt("pId"));
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				//proin.setpTime(sdf.format(rs.getDate("pTime")));
				proin.setpTime(sdf.format(rs.getTimestamp("pTime")));
				
				proin.setPoId(rs.getInt("poId"));
				proin.setpNumber(rs.getInt("pNumber"));
				proin.setMarId(rs.getInt("marId"));
				proin.setItId(rs.getInt("itId"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭结果集、语句对象、数据库连接对象
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回影响的行数
		return proin;
	}
	/**
	 * 查找所有
	 * @return
	 */
	@Override
	public List<Proin> findAll() {
		return null;
	}
	/**
	 * 分页查找
	 * @param rows 每页显示的记录数
	 * @param page 当前显示的页码数
	 * @return 指定页中所有员工信息集合
	 */
	@Override
	public List<Proin> findByPage(int rows, int page) {
		List<Proin> proinList=new ArrayList<Proin>();
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
			String sql="select * from proin limit ?,?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			//给结果集赋值
			rs=pstmt.executeQuery();
			while(rs.next()){
				Proin proin=new Proin();
				proin.setpId(rs.getInt("pId"));
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				proin.setpTime(sdf.format(rs.getDate("pTime")));
				proin.setPoId(rs.getInt("poId"));
				proin.setpNumber(rs.getInt("pNumber"));
				proin.setMarId(rs.getInt("marId"));
				proin.setItId(rs.getInt("itId"));
				proinList.add(proin);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭结果集、语句对象、数据库连接对象
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回影响的行数
		return proinList;
	}
	/**
	 * 按条件分页查找
	 * @param rows 每页显示的记录数
	 * @param page 当前显示的页码数
	 * @param condition 条件
	 * @return
	 */
	@Override
	public List<Proin> findByPage(int rows, int page, String condition) {
		List<Proin> proinList=new ArrayList<Proin>();
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
			String sql="select * from proin "+condition+" limit ?,? ";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Proin proin=new Proin();
				proin.setpId(rs.getInt("pId"));
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				proin.setpTime(sdf.format(rs.getDate("pTime")));
				proin.setPoId(rs.getInt("poId"));
				proin.setpNumber(rs.getInt("pNumber"));
				proin.setMarId(rs.getInt("marId"));
				proin.setItId(rs.getInt("itId"));
				proinList.add(proin);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭结果集、语句对象、数据库连接对象
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回影响的行数
		return proinList;
	}
	/**
	 * 统计记录数
	 * @return 表中所有记录行数
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
			String sql="select count(*) from proin";
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
	 * 统计符合条件的记录数
	 * @param condition 条件
	 * @return
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
			String sql="select count(*) from proin"+condition;
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
