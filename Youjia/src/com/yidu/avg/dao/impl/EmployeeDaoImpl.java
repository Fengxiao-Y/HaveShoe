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
 * ���ܣ����ݲ�
 * @author d280 avenger�� ��Ĭ��
 * ��д���ڣ� 2019��10��18������11:53:56
 * �汾��1.0
 */

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public int add(Employee employee) {
		//����һ��Ӱ�������ı���
		int rows=0;
		//�������ݿ����Ӷ���
		Connection conn=null;
		//����Ԥ������
		PreparedStatement pstmt=null;
		try {
			//ʵ�������ݿ����Ӷ��� 
			conn=JdbcUtils.getConnection();
			//����SQL����ַ���
			String sql="insert into employee(empName,"
					+ "empPwd,empSalary,empCard,empAddress,empPhone) values(?,?,?,?,?,?)";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
			//pstmt.setInt(1, employee.getEmpId());
			pstmt.setString(1, employee.getEmpName());
			pstmt.setString(2, employee.getEmpPwd());
			pstmt.setString(3, employee.getEmpSalary());
			pstmt.setString(4, employee.getEmpCard());
			pstmt.setString(5, employee.getEmpAddress());
			pstmt.setString(6, employee.getEmpPhone());
			
			
			//ִ�������󣬲�����Ӱ�������
			rows=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//�رս���������������ݿ����Ӷ���
			JdbcUtils.close(null, pstmt, conn);
		}
		//����Ӱ�������
		return rows;
	}
	
	

	@Override
	public int delete(int empId) {
		//����һ��Ӱ�������ı���
		int rows=0;
		//�������ݿ����Ӷ���
		Connection conn=null;
		//����Ԥ������
		PreparedStatement pstmt=null;
		try {
			//ʵ�������ݿ����Ӷ��� 
			conn=JdbcUtils.getConnection();
			//����SQL����ַ���
			String sql="delete from employee where empId=?";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
			pstmt.setInt(1, empId);
			//ִ�������󣬲�����Ӱ�������
			rows=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//�رս���������������ݿ����Ӷ���
			JdbcUtils.close(null, pstmt, conn);
		}
		//����Ӱ�������
		return rows;
	}


	@Override
	public int update(Employee employee) {
		//����һ��Ӱ�������ı���
		int rows=0;
		//�������ݿ����Ӷ���
		Connection conn=null;
		//����������
		PreparedStatement pstmt=null;
		try {
			//ʵ�������ݿ����Ӷ��� 
			conn=JdbcUtils.getConnection();
			//����SQL����ַ���
			String sql="update employee set empName=?,empPwd=?,"
					+ "empSalary=?,empCard=?,empAddress=?,"
					+ "empPhone=? where empId=?";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
			
			pstmt.setString(1, employee.getEmpName());
			pstmt.setString(2, employee.getEmpPwd());
			pstmt.setString(3, employee.getEmpSalary());
			pstmt.setString(4, employee.getEmpCard());
			pstmt.setString(5, employee.getEmpAddress());
			pstmt.setString(6, employee.getEmpPhone());
			pstmt.setInt(7, employee.getEmpId());
			
			//ִ�������󣬲�����Ӱ�������
			rows=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//�رս���������������ݿ����Ӷ���
			JdbcUtils.close(null, pstmt, conn);
		}
		//����Ӱ�������
		return rows;
	}
	@Override
	public Employee findById(String empId) {
		//��������
		Employee employee=null;
		//�������ݿ����Ӷ���
		Connection conn=null;
		//����Ԥ������
		PreparedStatement pstmt=null;
		//���������
		ResultSet rs=null;
		try {
			//ʵ�������ݿ����Ӷ��� 
			conn=JdbcUtils.getConnection();
			//����SQL����ַ���
			String sql="select * from employee where empNo=?";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
			pstmt.setString(1, empId);
			rs=pstmt.executeQuery();
			//�жϽ�������Ƿ�������
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
			//�رս���������������ݿ����Ӷ���
			JdbcUtils.close(rs, pstmt, conn);
		}
		//����Ӱ�������
		return employee;
	}
	@Override
	public List<Employee> findByPage(int rows, int page) {
		List<Employee> employeeList=new ArrayList<Employee>();
		//�������ݿ����Ӷ���
		Connection conn=null;
		//����Ԥ������
		PreparedStatement pstmt=null;
		//���������
		ResultSet rs=null;
		try {
			//ʵ�������ݿ����Ӷ��� 
			conn=JdbcUtils.getConnection();
			//����SQL����ַ���
			String sql="select * from employee limit ?,?";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			//���������ֵ
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
			//�رս���������������ݿ����Ӷ���
			JdbcUtils.close(rs, pstmt, conn);
		}
		//����Ӱ�������
		return employeeList;
	}

	@Override
	public List<Employee> findByPage(int rows, int page, String condition) {
		List<Employee> employeeList=new ArrayList<Employee>();
		//�������ݿ����Ӷ���
		Connection conn=null;
		//����Ԥ������
		PreparedStatement pstmt=null;
		//���������
		ResultSet rs=null;
		try {
			//ʵ�������ݿ����Ӷ��� 
			conn=JdbcUtils.getConnection();
			//����SQL����ַ���
			String sql="select * from employee "+condition+" limit ?,? ";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
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
			//�رս���������������ݿ����Ӷ���
			JdbcUtils.close(rs, pstmt, conn);
		}
		//����Ӱ�������
		return employeeList;
	}

	@Override
	public int count() {
		//����һ��Ӱ�������ı���
		int rows=0;
		//�������ݿ����Ӷ���
		Connection conn=null;
		//����Ԥ������
		PreparedStatement pstmt=null;
		//���������
		ResultSet rs=null;
		try {
			//ʵ�������ݿ����Ӷ��� 
			conn=JdbcUtils.getConnection();
			//����SQL����ַ���
			String sql="select count(*) from employee";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//���������ֵ
			rs=pstmt.executeQuery();
			if(rs.next()){
				rows=rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//�رս���������������ݿ����Ӷ���
			JdbcUtils.close(rs, pstmt, conn);
		}
		//����Ӱ�������
		return rows;
	}


	@Override
	public int count(String condition) {
		//����һ��Ӱ�������ı���
		int rows=0;
		//�������ݿ����Ӷ���
		Connection conn=null;
		//����Ԥ������
		PreparedStatement pstmt=null;
		//���������
		ResultSet rs=null;
		try {
			//ʵ�������ݿ����Ӷ��� 
			conn=JdbcUtils.getConnection();
			//����SQL����ַ���
			String sql="select count(*) from employee"+condition;
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//���������ֵ
			rs=pstmt.executeQuery();
			if(rs.next()){
				rows=rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//�رս���������������ݿ����Ӷ���
			JdbcUtils.close(rs, pstmt, conn);
		}
		//����Ӱ�������
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
        // �������ݿ����Ӷ���
        Connection conn = null;
        // ����������
        PreparedStatement pstmt = null;
        // �������������
        ResultSet rs = null;
        int rows = 0;
        try {
            // 1:ʵ�������Ӷ���
            conn = JdbcUtils.getConnection();
            // ��дSQL���
            String sql = "select * from employee where empName=?";
            // ʵ����Ԥ����������
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, empName);
            // 3:ִ�������󣬵õ����������
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
