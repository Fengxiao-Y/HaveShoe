package com.yidu.avg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.yidu.avg.dao.EmployeeDao;
import com.yidu.avg.domain.Employee;
import com.yidu.avg.utils.JdbcUtils;

/**
 * 
 * 功能：数据层
 * @author d280 avenger组 曾默涵
 * 编写日期： 2019年10月18日上午11:53:56
 * 版本：1.0
 */

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public int add(Employee employee) {
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
			String sql="insert into employee(empName,"
					+ "empPwd,empSalary,empCard,empAddress,empPhone) values(?,?,?,?,?,?)";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			//pstmt.setInt(1, employee.getEmpId());
			pstmt.setString(1, employee.getEmpName());
			pstmt.setString(2, employee.getEmpPwd());
			pstmt.setString(3, employee.getEmpSalary());
			pstmt.setString(4, employee.getEmpCard());
			pstmt.setString(5, employee.getEmpAddress());
			pstmt.setString(6, employee.getEmpPhone());
			
			
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
	public int delete(int empId) {
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
			String sql="delete from employee where empId=?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, empId);
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
	public int update(Employee employee) {
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
			String sql="update employee set empName=?,empPwd=?,"
					+ "empSalary=?,empCard=?,empAddress=?,"
					+ "empPhone=? where empId=?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			
			pstmt.setString(1, employee.getEmpName());
			pstmt.setString(2, employee.getEmpPwd());
			pstmt.setString(3, employee.getEmpSalary());
			pstmt.setString(4, employee.getEmpCard());
			pstmt.setString(5, employee.getEmpAddress());
			pstmt.setString(6, employee.getEmpPhone());
			pstmt.setInt(7, employee.getEmpId());
			
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
	public Employee findById(String empId) {
		//声明对象
		Employee employee=null;
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
			String sql="select * from employee where empNo=?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setString(1, empId);
			rs=pstmt.executeQuery();
			//判断结果集中是否有数据
			if(rs.next()){
				employee=new Employee();
				employee.setEmpId(rs.getInt("empId"));
				employee.setEmpName(rs.getString("empName"));
				employee.setEmpPwd(rs.getString("empPwd"));
				employee.setEmpSalary(rs.getString("empSalary"));
				employee.setEmpCard(rs.getString("empCard"));
				employee.setEmpAddress(rs.getString("empAddress"));
				employee.setEmpPhone(rs.getString("empPhone"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭结果集、语句对象、数据库连接对象
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回影响的行数
		return employee;
	}
	@Override
	public List<Employee> findByPage(int rows, int page) {
		List<Employee> employeeList=new ArrayList<Employee>();
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
			String sql="select * from employee limit ?,?";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			//给结果集赋值
			rs=pstmt.executeQuery();
			while(rs.next()){
				Employee employee=new Employee();
				employee.setEmpId(rs.getInt("empId"));
				employee.setEmpName(rs.getString("empName"));
				employee.setEmpPwd(rs.getString("empPwd"));
				employee.setEmpSalary(rs.getString("empSalary"));
				employee.setEmpCard(rs.getString("empCard"));
				employee.setEmpAddress(rs.getString("empAddress"));
				employee.setEmpPhone(rs.getString("empPhone"));
				employeeList.add(employee);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭结果集、语句对象、数据库连接对象
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回影响的行数
		return employeeList;
	}

	@Override
	public List<Employee> findByPage(int rows, int page, String condition) {
		List<Employee> employeeList=new ArrayList<Employee>();
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
			String sql="select * from employee "+condition+" limit ?,? ";
			//实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Employee employee=new Employee();
				employee.setEmpId(rs.getInt("empId"));
				employee.setEmpName(rs.getString("empName"));
				employee.setEmpPwd(rs.getString("empPwd"));
				employee.setEmpSalary(rs.getString("empSalary"));
				employee.setEmpCard(rs.getString("empCard"));
				employee.setEmpAddress(rs.getString("empAddress"));
				employee.setEmpPhone(rs.getString("empPhone"));
				employeeList.add(employee);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭结果集、语句对象、数据库连接对象
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回影响的行数
		return employeeList;
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
			String sql="select count(*) from employee";
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
			String sql="select count(*) from employee"+condition;
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
	
	public Employee oflogin(String empName){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Employee employee = null;
		try {
			conn=JdbcUtils.getConnection();
			String sql = "select * from employee where empName=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, empName);
			rs=pstmt.executeQuery();			
			if(rs.next()){
				employee = new Employee();
				employee.setEmpId(rs.getInt("empId"));
				employee.setEmpName(rs.getString("empName"));
				employee.setEmpPwd(rs.getString("empPwd"));
				employee.setEmpSalary(rs.getString("empSalary"));
				employee.setEmpCard(rs.getString("empCard"));
				employee.setEmpAddress(rs.getString("empAddress"));
				employee.setEmpPhone(rs.getString("empPhone"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
            JdbcUtils.close(rs, pstmt, conn);
        }
		return employee;				
	}
	
	@Override
    public int ofusers(String empName) {
        // 声明数据库连接对象
        Connection conn = null;
        // 声明语句对象
        PreparedStatement pstmt = null;
        // 声明结果集对象
        ResultSet rs = null;
        int rows = 0;
        try {
            // 1:实例化连接对象
            conn = JdbcUtils.getConnection();
            // 编写SQL语句
            String sql = "select * from employee where empName=?";
            // 实例化预编译语句对象
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, empName);
            // 3:执行语句对象，得到结果集对象
            rs = pstmt.executeQuery();
            if (rs.next() == false) {
                rows = 1;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            JdbcUtils.close(rs, pstmt, conn);
        }
        return rows;
    }
	
	

}
