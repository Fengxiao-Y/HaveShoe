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
 * ���ܣ����ݲ�
 * @author d280 avenger�� ������
 * ��д���ڣ� 2019��10��18������9:48:46
 * �汾��1.0
 */
public class MarqueDaoImpl implements MarqueDao {



	@Override
	public int add(Marque marque) {
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
			String sql="insert into marque(marName,"
					+ "marYardage,marIntroduce,marUrl,marPrice,marConvert,"
					+ "ctId) values(?,?,?,?,?,?,?)";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵmarConvert
			//pstmt.setInt(1, marque.getMarId());
			pstmt.setString(1, marque.getMarName());
			pstmt.setInt(2, marque.getMarYardage());
			pstmt.setString(3, marque.getMarIntroduce());
			pstmt.setString(4, marque.getMarUrl());
			pstmt.setDouble(5, marque.getMarprice());
			pstmt.setDouble(6, marque.getMarConvert());
			pstmt.setInt(7, marque.getCtId());
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
	public int deleteById(int marId) {
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
			String sql="delete from marque where marId=?";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
			pstmt.setInt(1, marId);
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
	public int update(Marque marque) {
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
			String sql="update marque set marName=?,marYardage=?,"
					+ "marIntroduce=?,marUrl=?,marPrice=?,"
					+ "marConvert=?,ctId=? where marId=?";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
			
			pstmt.setString(1, marque.getMarName());
			pstmt.setInt(2, marque.getMarYardage());
			pstmt.setString(3, marque.getMarIntroduce());
			pstmt.setString(4, marque.getMarUrl());
			pstmt.setDouble(5, marque.getMarprice());
			pstmt.setDouble(6, marque.getMarConvert());
			pstmt.setInt(7, marque.getCtId());
			pstmt.setInt(8, marque.getMarId());
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
	public Marque findById(int ctId) {
		//��������
		Marque marque=null;
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
			String sql="select * from marque where marId=?";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
			pstmt.setInt(1,marque.getMarId());
			rs=pstmt.executeQuery();
			//�жϽ�������Ƿ�������
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
			//�رս���������������ݿ����Ӷ���
			JdbcUtils.close(rs, pstmt, conn);
		}
		//����Ӱ�������
		return marque;
	}

	@Override
	public List<Marque> findByPage(int rows, int page) {
		List<Marque> marqueList=new ArrayList<Marque>();
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
			String sql="select * from marque  limit ?,? ";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
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
			//�رս���������������ݿ����Ӷ���
			JdbcUtils.close(rs, pstmt, conn);
		}
		//����Ӱ�������
		return marqueList;
	}
	@Override
	public List<Marque> findByPage(int rows, int page, String condition) {
		List<Marque> marqueList=new ArrayList<Marque>();
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
			String sql="select * from marque "+condition+" limit ?,? ";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
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
			//�رս���������������ݿ����Ӷ���
			JdbcUtils.close(rs, pstmt, conn);
		}
		//����Ӱ�������
		return marqueList;
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
			String sql="select count(*) from marque";
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
			String sql="select count(*) from marque"+condition;
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
