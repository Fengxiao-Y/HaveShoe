package com.yidu.avg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.yidu.avg.dao.FiscalExpendDao;
import com.yidu.avg.domain.FiscalExpend;
import com.yidu.avg.utils.JdbcUtils;
/**
 * 
 * 功能：数据层
 * @author d280 avenger组 李卫
 * 编写日期： 2019年10月18日上午10:56:46
 * 版本：1.0
 */
public class FiscalExpendDaoImpl implements FiscalExpendDao {

	/**
	 * 将实体类对象添加到数据库表中（一行）
	 * @param fiscalExpend 财务支出实体类对象
	 * @return 影响的行数(1：添加成功，0：添加失败)
	 */
	@Override
	public int add(FiscalExpend fiscalExpend) {

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
			String sql="insert into fiscalExpend(poId,feTime,empId,feMoney)"
					+ " values(?,?,?,?)";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			//pstmt.setInt(1, fiscalExpend.getFeId());
			pstmt.setInt(1, fiscalExpend.getPoId());
			//将字符串转换成数据库端日期数据
			pstmt.setString(2, fiscalExpend.getFeTime());
			pstmt.setInt(3, fiscalExpend.getEmpId());
			pstmt.setDouble(4, fiscalExpend.getFeMoney());
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
	 * @param feId 
	 * @return 影响的行数（1：添加成功；0：添加失败）
	 */
	@Override
	public int deleteById(int feId) {
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
			String sql="delete from fiscalExpend where feId=?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, feId);
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
	 * @param fiscalExpend
	 * @return 影响的行数（1：添加成功；0：添加失败）
	 */
	@Override
	public int update(FiscalExpend fiscalExpend) {
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
			String sql="update fiscalExpend set poId=?,"
					+ "feTime=?,empId=?,feMoney=? where feId=?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, fiscalExpend.getPoId());
			//将字符串转换成数据库端日期数据
			pstmt.setString(2, fiscalExpend.getFeTime());
			pstmt.setInt(3, fiscalExpend.getEmpId());
			pstmt.setDouble(4, fiscalExpend.getFeMoney());
			pstmt.setInt(5, fiscalExpend.getFeId());
			
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
	 * @param feId 财务支出表Id
	 * @return 返回财务实体对象
	 */
	@Override
	public FiscalExpend findById(int feId) {
		//建立一个对象
		FiscalExpend fiscalExpend=null;
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
			String sql="select * from FiscalExpend where feId=?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, feId);
			//实例化结果集对象
			rs=pstmt.executeQuery();
			//根据结果集，判断并将数据保存到对象中
			if(rs.next()){
				//建立一个对象
				fiscalExpend=new FiscalExpend();
				//将数据保存到对象中
				fiscalExpend.setFeId(rs.getInt("feId"));
				fiscalExpend.setPoId(rs.getInt("poId"));
				//SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				fiscalExpend.setFeTime(rs.getString("feTime"));
				fiscalExpend.setFeMoney(rs.getDouble("feMoney"));
				fiscalExpend.setEmpId(rs.getInt("empId"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭结果集，语句对象，数据库连接对象
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回一个对象
		return fiscalExpend;
	}

	/**
	 * 从数据库表中分页查找数据
	 * @param rows 每页的数据行数
	 * @param page 当前的页数
	 * @return 指定页中的数据集合
	 */
	@Override
	public List<FiscalExpend> findByPage(int rows, int page) {
		//定义一个集合
		List<FiscalExpend> fiscalExpendList=new ArrayList<FiscalExpend>();
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
			String sql="select * from fiscalExpend limit ?,?";
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
				FiscalExpend fiscalExpend=new FiscalExpend();
				//将数据保存到对象中
				fiscalExpend.setFeId(rs.getInt("feId"));
				fiscalExpend.setPoId(rs.getInt("poId"));
				//SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				fiscalExpend.setFeTime(rs.getString("feTime"));
				fiscalExpend.setFeMoney(rs.getDouble("feMoney"));
				fiscalExpend.setEmpId(rs.getInt("empId"));
				//将对象添加到集合中
				fiscalExpendList.add(fiscalExpend);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭结果集，语句对象，数据库连接对象
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回一个集合
		return fiscalExpendList;
	}

	/**
	 * 从数据库表中按特定条件进行分页查找数据
	 * @param rows 每页的数据行数
	 * @param page 当前的页数
	 * @param condition 查询条件
	 * @return 指定页中的数据集合
	 */
	@Override
	public List<FiscalExpend> findByPage(int rows, int page, String condition) {
		//定义一个集合
		List<FiscalExpend> fiscalExpendList=new ArrayList<FiscalExpend>();
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
			String sql="select * from fiscalExpend "+condition+" limit ?,?";
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
				FiscalExpend fiscalExpend=new FiscalExpend();
				//将数据保存到对象中
				fiscalExpend.setFeId(rs.getInt("feId"));
				fiscalExpend.setPoId(rs.getInt("poId"));
				
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				
				fiscalExpend.setFeTime(rs.getString("feTime"));
				fiscalExpend.setFeMoney(rs.getDouble("feMoney"));
				fiscalExpend.setEmpId(rs.getInt("empId"));
				//将对象添加到集合中
				fiscalExpendList.add(fiscalExpend);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭结果集，语句对象，数据库连接对象
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回一个集合
		return fiscalExpendList;
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
			String sql="select count(*) from fiscalExpend";
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
			String sql="select count(*) from cust "+condition;
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
