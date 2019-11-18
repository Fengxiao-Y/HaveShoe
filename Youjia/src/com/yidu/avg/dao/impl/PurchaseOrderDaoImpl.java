 package com.yidu.avg.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.yidu.avg.dao.PurchaseOrderDao;
import com.yidu.avg.domain.PurchaseOrder;
import com.yidu.avg.utils.JdbcUtils;
/**
 * 
 * 功能：数据层
 * @author d280 avenger组 邓威
 * 编写日期： 2019年10月18日上午9:44:45
 * 版本：1.0
 */
public class PurchaseOrderDaoImpl implements PurchaseOrderDao {
	/**
	 * 按物品状态id(主键)进行删除数据
	 * @param poId 
	 * @return 
	 */
	@Override
	public int delete(int poId) {
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
			String sql="delete from purchaseOrder where poId=?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, poId);
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
	 * @param cust 
	 * @return
	 */
	@Override
	public int update(PurchaseOrder purchaseOrder) {
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
			String sql="update purchaseOrder set marId=?,poName=?,"
					+ "poTime=?,spId=?,poCounts=?,"
					+ "poPrice=? where poId=?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(7, purchaseOrder.getPoId());
			pstmt.setInt(1, purchaseOrder.getMarId());
			pstmt.setString(2, purchaseOrder.getPoName());
			//将字符串转换成日期数据
			pstmt.setString(3, purchaseOrder.getPoTime());
			pstmt.setInt(4, purchaseOrder.getSpId());
			pstmt.setInt(5, purchaseOrder.getPoCounts());
			pstmt.setDouble(6, purchaseOrder.getPoPrice());
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
	 * 根据员工编号查找单个员工信息
	 * @param empNo
	 * @return
	 */
	@Override
	public PurchaseOrder findById(int poId) {
		//声明对象
		PurchaseOrder purchaseOrder=null;
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
			String sql="select * from purchaseOrder where poId=?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, poId);
			rs=pstmt.executeQuery();
			//判断结果集中是否有数据
			if(rs.next()){
				purchaseOrder=new PurchaseOrder();
				purchaseOrder.setPoId(rs.getInt("poId"));
				purchaseOrder.setMarId(rs.getInt("marId"));
				purchaseOrder.setPoName(rs.getString("poName"));	
				//SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				purchaseOrder.setPoTime(rs.getString("poTime"));
				purchaseOrder.setSpId(rs.getInt("spId"));
				purchaseOrder.setPoCounts(rs.getInt("poCounts"));
				purchaseOrder.setPoPrice(rs.getDouble("poPrice"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭结果集、语句对象、数据库连接对象
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回影响的行数
		return purchaseOrder;
	}
	/**
	 * 查找所有
	 * @return
	 */
	@Override
	public List<PurchaseOrder> findAll() {
		return null;
	}
	/**
	 * 分页查找
	 * @param rows 每页显示的记录数
	 * @param page 当前显示的页码数
	 * @return 指定页中所有员工信息集合
	 */
	@Override
	public List<PurchaseOrder> findByPage(int rows, int page) {
		List<PurchaseOrder> purchaseOrderList=new ArrayList<PurchaseOrder>();
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
			String sql="select * from purchaseOrder limit ?,?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			//给结果集赋值
			rs=pstmt.executeQuery();
			while(rs.next()){
				PurchaseOrder purchaseOrder=new PurchaseOrder();
				purchaseOrder.setPoId(rs.getInt("poId"));
				purchaseOrder.setMarId(rs.getInt("marId"));
				purchaseOrder.setPoName(rs.getString("poName"));	
				//SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				purchaseOrder.setPoTime(rs.getString("poTime"));
				purchaseOrder.setSpId(rs.getInt("spId"));
				purchaseOrder.setPoCounts(rs.getInt("poCounts"));
				purchaseOrder.setPoPrice(rs.getDouble("poPrice"));
				purchaseOrderList.add(purchaseOrder);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭结果集、语句对象、数据库连接对象
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回影响的行数
		return purchaseOrderList;
	}
	/**
	 * 按条件分页查找
	 * @param rows 每页显示的记录数
	 * @param page 当前显示的页码数
	 * @param condition 条件
	 * @return
	 */
	@Override
	public List<PurchaseOrder> findByPage(int rows, int page, String condition) {
		List<PurchaseOrder> purchaseOrderList=new ArrayList<PurchaseOrder>();
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
			String sql="select * from purchaseOrder "+condition+" limit ?,? ";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			rs=pstmt.executeQuery();
			while(rs.next()){
				PurchaseOrder purchaseOrder=new PurchaseOrder();
				purchaseOrder=new PurchaseOrder();
				purchaseOrder.setPoId(rs.getInt("poId"));
				purchaseOrder.setMarId(rs.getInt("marId"));
				purchaseOrder.setPoName(rs.getString("poName"));	
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				purchaseOrder.setPoTime(rs.getString("poTime"));
				purchaseOrder.setSpId(rs.getInt("spId"));
				purchaseOrder.setPoCounts(rs.getInt("poCounts"));
				purchaseOrder.setPoPrice(rs.getDouble("poPrice"));
				purchaseOrderList.add(purchaseOrder);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭结果集、语句对象、数据库连接对象
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回影响的行数
		return purchaseOrderList;
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
			String sql="select count(*) from purchaseOrder";
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
			String sql="select count(*) from purchaseOrder"+condition;
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
	 * 将实体类对象添加到数据库表中(一行)
	 * @param purchaseOrder 采购订单实体类对象
	 * @return 影响的行数(1:添加成功;0:添加失败)
	 */
	@Override
	public int add(PurchaseOrder purchaseOrder) {
		//定义一个影响行数的变量
		int rows=0;
		//声明数据库连接对象
		Connection conn=null;
		//声明预语句对象
		PreparedStatement pstmt=null;
		//声明一个结果集
		ResultSet rs = null;
		
		try {
			//实例化数据库连接对象 
			conn=JdbcUtils.getConnection();
			//定义SQL语句字符串
			String sql="insert into purchaseOrder(marId,"
					+ "poName,poTime,spId,poCounts,poPrice) values(?,?,?,?,?,?) ";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			//给参数赋值
			//pstmt.setInt(1, purchaseOrder.getPoId());
			pstmt.setInt(1, purchaseOrder.getMarId());
			pstmt.setString(2, purchaseOrder.getPoName());
			//将字符串转换成日期数据
			pstmt.setString(3, purchaseOrder.getPoTime());
			pstmt.setInt(4, purchaseOrder.getSpId());
			pstmt.setInt(5, purchaseOrder.getPoCounts());
			pstmt.setDouble(6, purchaseOrder.getPoPrice());
			//执行语句对象，并返回影响的行数
			pstmt.executeUpdate();
			rs=pstmt.getGeneratedKeys();
			if(rs.next()){
				rows=rs.getInt(1);
			}
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
