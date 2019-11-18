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
 * ���ܣ����ݲ�
 * @author d280 avenger��
 * ��д���ڣ� 2019��10��18������11:54:23
 * �汾��1.0
 */
public class OutboundDaoImpl implements OutboundDao {

	@Override
	public int add(Outbound outbound) {
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
			String sql="insert into outbound(obTime,"
					+ "soId,odNumber,marId,itId) values(?,?,?,?,?)";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
			//pstmt.setInt(1, outbound.getObId());
			//���ַ���ת������������
			pstmt.setDate(1, java.sql.Date.valueOf(outbound.getObTime()));
			pstmt.setInt(2, outbound.getSoId());
			pstmt.setInt(3, outbound.getOdNumber());
			pstmt.setInt(4, outbound.getMarId());
			pstmt.setInt(5, outbound.getItId());
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
	public int delete(int obId) {
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
			String sql="delete from outbound where obId=?";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
			pstmt.setInt(1, obId);
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
	public int update(Outbound outbound) {
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
			String sql="update outbound set obTime=?,soId=?,"
					+ "odNumber=?,marId=?,itId=? where obId=?";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
			pstmt.setInt(6, outbound.getObId());
			//���ַ���ת������������
			pstmt.setDate(1, java.sql.Date.valueOf(outbound.getObTime()));
			pstmt.setInt(2, outbound.getSoId());
			pstmt.setInt(3, outbound.getOdNumber());
			pstmt.setInt(4, outbound.getMarId());
			pstmt.setInt(5, outbound.getItId());
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

	/**
	 * 
	 */
	@Override
	public Outbound findById(int obId) {
		//��������
		Outbound outbound=null;
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
			String sql="select * from outbound where obId=?";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
			pstmt.setInt(1, obId);
			rs=pstmt.executeQuery();
			//�жϽ�������Ƿ�������
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
			//�رս���������������ݿ����Ӷ���
			JdbcUtils.close(rs, pstmt, conn);
		}
		//����Ӱ�������
		return outbound;
	}

	@Override
	public List<Outbound> findAll() {
		
		return null;
	}

	@Override
	public List<Outbound> findByPage(int rows, int page) {
		//������󼯺�
		List<Outbound> outboundList=new ArrayList<Outbound>();
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
			String sql="select * from outbound limit ?,?";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			//���������ֵ
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
			//�رս���������������ݿ����Ӷ���
			JdbcUtils.close(rs, pstmt, conn);
		}
		//����Ӱ�������
		return outboundList;
	}

	@Override
	public List<Outbound> findByPage(int rows, int page, String condition) {
		//������󼯺�
		List<Outbound> outboundList=new ArrayList<Outbound>();
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
			String sql="select * from outbound "+condition+" limit ?,? ";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
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
			//�رս���������������ݿ����Ӷ���
			JdbcUtils.close(rs, pstmt, conn);
		}
		//����Ӱ�������
		return outboundList;
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
			String sql="select count(*) from outbound";
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
			String sql="select count(*) from outbound"+condition;
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
