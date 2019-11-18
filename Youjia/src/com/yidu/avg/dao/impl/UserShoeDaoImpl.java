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
 * ���ܣ����ݲ�
 * @author d280 avenger��
 * ��д���ڣ� 2019��10��18������5:53:51
 * �汾��1.0
 */
public class UserShoeDaoImpl implements UserShoeDao {

	@Override
	public int add(UserShoe userShoe) {
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
			String sql="insert into userShoe(usName,"
					+ "usPwd,usSex,usEmail,usAddress,usPhone,"
					+ "usPostal) values(?,?,?,?,?,?,?)";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
			//pstmt.setInt(1, userShoe.getUsId());
			pstmt.setString(1, userShoe.getUsName());
			pstmt.setString(2, userShoe.getUsPwd());
			pstmt.setString(3, userShoe.getUsSex());
			pstmt.setString(4, userShoe.getUsEmail());
			pstmt.setString(5, userShoe.getUsAddress());
			pstmt.setString(6, userShoe.getUsPhone());
			pstmt.setString(7, userShoe.getUsPostal());	
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
	public int delete(int usId) {
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
			String sql="delete from userShoe where usId=?";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
			pstmt.setInt(1, usId);
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
	public int update(UserShoe userShoe) {
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
			String sql="update userShoe set usName=?,usPwd=?,"
					+ "usSex=?,usEmail=?,usAddress=?,"
					+ "usPhone=?,usPostal=? where usId=?";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
			
			pstmt.setString(1, userShoe.getUsName());
			pstmt.setString(2, userShoe.getUsPwd());
			pstmt.setString(3, userShoe.getUsSex());
			pstmt.setString(4, userShoe.getUsEmail());
			pstmt.setString(5, userShoe.getUsAddress());
			pstmt.setString(6, userShoe.getUsPhone());
			pstmt.setString(7, userShoe.getUsPostal());	
			pstmt.setInt(8, userShoe.getUsId());
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
	public UserShoe findById(int usId) {
		//��������
		UserShoe userShoe=null;
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
			String sql="select * from userShoe where usId=?";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
			pstmt.setInt(1, usId);
			rs=pstmt.executeQuery();
			//�жϽ�������Ƿ�������
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
			//�رս���������������ݿ����Ӷ���
			JdbcUtils.close(rs, pstmt, conn);
		}
		//����Ӱ�������
		return userShoe;
	}

	@Override
	public List<UserShoe> findAll() {
		
		return null;
	}

	@Override
	public List<UserShoe> findByPage(int rows, int page) {
		List<UserShoe> userShoeList=new ArrayList<UserShoe>();
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
			String sql="select * from userShoe limit ?,?";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			//���������ֵ
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
			//�رս���������������ݿ����Ӷ���
			JdbcUtils.close(rs, pstmt, conn);
		}
		//����Ӱ�������
		return userShoeList;
	}

	@Override
	public List<UserShoe> findByPage(int rows, int page, String condition) {
		List<UserShoe> userShoeList=new ArrayList<UserShoe>();
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
			String sql="select * from userShoe "+condition+" limit ?,? ";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
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
			//�رս���������������ݿ����Ӷ���
			JdbcUtils.close(rs, pstmt, conn);
		}
		//����Ӱ�������
		return userShoeList;
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
			String sql="select count(*) from userShoe";
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
			String sql="select count(*) from userShoe"+condition;
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

}
