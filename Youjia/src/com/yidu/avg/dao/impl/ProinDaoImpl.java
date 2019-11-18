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
 * ���ܣ����ݲ�
 * @author d280 avenger�� ����
 * ��д���ڣ� 2019��10��18������11:57:11
 * �汾��1.0
 */
public class ProinDaoImpl implements ProinDao {
	/**
	 * ��ʵ���������ӵ����ݿ����(һ��)
	 * @param outbound ����ʵ�������
	 * @return Ӱ�������(1:��ӳɹ�;0:���ʧ��)
	 */
	@Override
	public int add(Proin proin) {
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
			String sql="insert into proin(pTime,"
					+ "poId,pNumber,marId,itId) values(?,?,?,?,?)";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
			//pstmt.setInt(1, proin.getpId());
			//���ַ���ת������������
			pstmt.setString(1, proin.getpTime());
			//pstmt.setTimestamp(1, java.sql.Date.valueOf(proin.getpTime()));
			//pstmt.setTime(1, java.sql.Time.valueOf(proin.getpTime()));
			pstmt.setInt(2, proin.getPoId());
			pstmt.setInt(3, proin.getpNumber());
			pstmt.setInt(4, proin.getMarId());
			pstmt.setInt(5, proin.getItId());
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
	 * ������id(����)����ɾ������
	 * @param pId 
	 * @return 
	 */
	@Override
	public int delete(int pId) {
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
			String sql="delete from proin where pId=?";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
			pstmt.setInt(1, pId);
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
	 * ��ʵ���������µ����ݿ����
	 * @param outbound 
	 * @return
	 */
	@Override
	public int update(Proin proin) {
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
			String sql="update proin set pTime=?,"
					+ "poId=?,pNumber=?,marId=?,"
					+ "itId=? where pId=?";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
			//���ַ���ת������������
			pstmt.setString(1, proin.getpTime());
			pstmt.setInt(2, proin.getPoId());
			pstmt.setInt(3, proin.getpNumber());
			pstmt.setInt(4, proin.getMarId());
			pstmt.setInt(5, proin.getItId());
			pstmt.setInt(6, proin.getpId());
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
	 * �������id���ҵ��������Ϣ
	 * @param pId
	 * @return
	 */
	@Override
	public Proin findById(int pId) {
		//��������
		Proin proin=null;
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
			String sql="select * from proin where pId=?";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
			pstmt.setInt(1, pId);
			rs=pstmt.executeQuery();
			//�жϽ�������Ƿ�������
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
			//�رս���������������ݿ����Ӷ���
			JdbcUtils.close(rs, pstmt, conn);
		}
		//����Ӱ�������
		return proin;
	}
	/**
	 * ��������
	 * @return
	 */
	@Override
	public List<Proin> findAll() {
		return null;
	}
	/**
	 * ��ҳ����
	 * @param rows ÿҳ��ʾ�ļ�¼��
	 * @param page ��ǰ��ʾ��ҳ����
	 * @return ָ��ҳ������Ա����Ϣ����
	 */
	@Override
	public List<Proin> findByPage(int rows, int page) {
		List<Proin> proinList=new ArrayList<Proin>();
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
			String sql="select * from proin limit ?,?";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			//���������ֵ
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
			//�رս���������������ݿ����Ӷ���
			JdbcUtils.close(rs, pstmt, conn);
		}
		//����Ӱ�������
		return proinList;
	}
	/**
	 * ��������ҳ����
	 * @param rows ÿҳ��ʾ�ļ�¼��
	 * @param page ��ǰ��ʾ��ҳ����
	 * @param condition ����
	 * @return
	 */
	@Override
	public List<Proin> findByPage(int rows, int page, String condition) {
		List<Proin> proinList=new ArrayList<Proin>();
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
			String sql="select * from proin "+condition+" limit ?,? ";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
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
			//�رս���������������ݿ����Ӷ���
			JdbcUtils.close(rs, pstmt, conn);
		}
		//����Ӱ�������
		return proinList;
	}
	/**
	 * ͳ�Ƽ�¼��
	 * @return �������м�¼����
	 */
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
			String sql="select count(*) from proin";
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
	/**
	 * ͳ�Ʒ��������ļ�¼��
	 * @param condition ����
	 * @return
	 */
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
			String sql="select count(*) from proin"+condition;
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
