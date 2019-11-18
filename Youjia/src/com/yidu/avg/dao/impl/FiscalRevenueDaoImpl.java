package com.yidu.avg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.yidu.avg.dao.FiscalRevenueDao;
import com.yidu.avg.domain.FiscalRevenue;
import com.yidu.avg.utils.JdbcUtils;
/**
 * 
 * ���ܣ����ݲ�
 * @author d280 avenger�� ����
 * ��д���ڣ� 2019��10��18������10:54:27
 * �汾��1.0
 */
public class FiscalRevenueDaoImpl implements FiscalRevenueDao {

	/**
	 * ��ʵ���������ӵ����ݿ���У�һ�У�
	 * @param fiscalRevenue ��������ʵ�������
	 * @return Ӱ���������1����ӳɹ���0�����ʧ�ܣ�
	 */
	@Override
	public int add(FiscalRevenue fiscalRevenue) {

		//����һ��Ӱ�������ı���
		int rows = 0;
		//�������ݿ����Ӷ���
		Connection conn=null;
		//����Ԥ����������
		PreparedStatement pstmt=null;
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����SQL����ַ���
			String sql="INSERT INTO fiscaLRevenue(soId,frTime,frMoney) VALUES(?,?,?)";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
			//pstmt.setInt(1, fiscalRevenue.getFrId());
			pstmt.setInt(1, fiscalRevenue.getSoId());
			
			//���ַ���ת�������ݿ����������
			pstmt.setDate(2, java.sql.Date.valueOf(fiscalRevenue.getFrTime()));
			
			pstmt.setDouble(3, fiscalRevenue.getFrMoney());

			//ִ�������󣬲�����Ӱ�������
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}finally{
			//�رս���������������ݿ����Ӷ���
			JdbcUtils.close(null, pstmt, conn);
		}
		return rows;
	}

	/**
	 * �����������Id(����) ����ɾ������
	 * @param frId
	 * @return Ӱ���������1����ӳɹ���0�����ʧ�ܣ�
	 */
	@Override
	public int deleteById(int frId) {

		//����һ��Ӱ�������ı���
		int rows = 0;
		//�������ݿ����Ӷ���
		Connection conn = null;
		//����Ԥ����������
		PreparedStatement pstmt = null;
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����SQL����ַ���
			String sql="delete from fiscalRevenue where frId=?";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
			pstmt.setInt(1, frId);
			//ִ�������󣬲�����Ӱ�������
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}finally{
			//�رս���������������ݿ����Ӷ���
			JdbcUtils.close(null, pstmt, conn);
		}
		return rows;
	}

	/**
	 * ��ʵ���������µ������������
	 * @param fiscalRevenue
	 * @return Ӱ���������1����ӳɹ���0�����ʧ�ܣ�
	 */
	@Override
	public int update(FiscalRevenue fiscalRevenue) {

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
			String sql="update fiscalRevenue set soId=?,"
					+ "frTime=?,frMoney=? where frId=?";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
			pstmt.setInt(1, fiscalRevenue.getSoId());
			//���ַ���ת�������ݿ����������
			pstmt.setDate(2, java.sql.Date.valueOf(fiscalRevenue.getFrTime()));
			pstmt.setDouble(3, fiscalRevenue.getFrMoney());
			pstmt.setInt(4, fiscalRevenue.getFrId());
			
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
	 * �����������Id�����ݿ���в�������
	 * @param frId ���������Id
	 * @return ���ز���ʵ�����
	 */
	@Override
	public FiscalRevenue findById(int frId) {
		//����һ������
		FiscalRevenue fiscalRevenue=null;
		//�������ݿ����Ӷ���
		Connection conn=null;
		//����Ԥ����������
		PreparedStatement pstmt=null;
		//�������������
		ResultSet rs=null;
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����SQL�ַ���
			String sql="select * from fiscalRevenue where frId=?";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
			pstmt.setInt(1, frId);
			//ʵ�������������
			rs=pstmt.executeQuery();
			//���ݽ�������жϲ������ݱ��浽������
			if(rs.next()){
				//����һ������
				fiscalRevenue=new FiscalRevenue();
				//�����ݱ��浽������
				fiscalRevenue.setFrId(rs.getInt("frId"));
				fiscalRevenue.setSoId(rs.getInt("soId"));
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				fiscalRevenue.setFrTime(sdf.format(rs.getString("frTime")));
				fiscalRevenue.setFrMoney(rs.getDouble("frMoney"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//�رս���������������ݿ����Ӷ���
			JdbcUtils.close(rs, pstmt, conn);
		}
		//����һ������
		return fiscalRevenue;
	}

	/**
	 * �����ݿ���з�ҳ��������
	 * @param rows ÿҳ����������
	 * @param page ��ǰ��ҳ��
	 * @return ָ��ҳ�е����ݼ���
	 */
	@Override
	public List<FiscalRevenue> findByPage(int rows, int page) {
		//����һ������
		List<FiscalRevenue> fiscalRevenueList=new ArrayList<FiscalRevenue>();
		//�������ݿ����Ӷ���
		Connection conn=null;
		//����Ԥ����������
		PreparedStatement pstmt=null;
		//�������������
		ResultSet rs=null;
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����SQL����ַ���
			String sql="select * from fiscalRevenue limit ?,?";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			//ʵ�������������
			rs=pstmt.executeQuery();
			//����ѭ��������������е����ݣ����浽������
			while(rs.next()){
				//����һ������
				FiscalRevenue fiscalRevenue=new FiscalRevenue();
				//�����ݱ��浽������
				fiscalRevenue.setFrId(rs.getInt("frId"));
				fiscalRevenue.setSoId(rs.getInt("soId"));
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				fiscalRevenue.setFrTime(sdf.format(rs.getDate("frTime")));
				fiscalRevenue.setFrMoney(rs.getDouble("frMoney"));
				//��������ӵ�������
				fiscalRevenueList.add(fiscalRevenue);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//�رս���������������ݿ����Ӷ���
			JdbcUtils.close(rs, pstmt, conn);
		}
		//����һ������
		return fiscalRevenueList;
	}

	/**
	 * �����ݿ���а��ض��������з�ҳ��������
	 * @param rows ÿҳ����������
	 * @param page ��ǰ��ҳ��
	 * @param condition ��ѯ����
	 * @return ָ��ҳ�е����ݼ���
	 */
	@Override
	public List<FiscalRevenue> findByPage(int rows, int page, String condition) {
		//����һ������
		List<FiscalRevenue> fiscalRevenueList=new ArrayList<FiscalRevenue>();
		//�������ݿ����Ӷ���
		Connection conn=null;
		//����Ԥ����������
		PreparedStatement pstmt=null;
		//�������������
		ResultSet rs=null;
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����SQL����ַ���
			String sql="select * from fiscalRevenue "+condition+" limit ?,?";
			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//��SQL�в�����ֵ
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			//ʵ�������������
			rs=pstmt.executeQuery();
			//����ѭ������������������ݣ������浽������
			while(rs.next()){
				//����һ������
				FiscalRevenue fiscalRevenue=new FiscalRevenue();
				//�����ݱ��浽������
				fiscalRevenue.setFrId(rs.getInt("frId"));
				fiscalRevenue.setSoId(rs.getInt("soId"));
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				fiscalRevenue.setFrTime(sdf.format(rs.getDate("frTime")));
				fiscalRevenue.setFrMoney(rs.getDouble("frMoney"));
				//��������ӵ�������
				fiscalRevenueList.add(fiscalRevenue);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//�رս���������������ݿ����Ӷ���
			JdbcUtils.close(rs, pstmt, conn);
		}
		//����һ������
		return fiscalRevenueList;
	}

	/**
	 * ͳ�����ݿ��������������
	 * @return ����������
	 */
	@Override
	public int count() {
		//����һ��Ӱ�������ı���
		int rows=0;
		//�������ݿ����Ӷ���
		Connection conn=null;
		//����Ԥ����������
		PreparedStatement pstmt=null;
		//�������������
		ResultSet rs=null;
		try {
			//ʵ�������������
			conn=JdbcUtils.getConnection();
			//����SQL����ַ���
			String sql="select count(*) from fiscalRevenue";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//ʵ�������������
			rs=pstmt.executeQuery();
			//���ݽ�������жϲ������ݱ��浽������
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
	 * ���ض�����ͳ�����ݿ��������������
	 * @param condition ����
	 * @return ��������������������
	 */
	@Override
	public int count(String condition) {
		//����һ��Ӱ�������ı���
		int rows=0;
		//�������ݿ����Ӷ���
		Connection conn=null;
		//����Ԥ����������
		PreparedStatement pstmt=null;
		//�������������
		ResultSet rs=null;
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����SQL����ַ���
			String sql="select count(*) from fiscalRevenue "+condition;
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//ʵ�������������
			rs=pstmt.executeQuery();
			//���ݽ�������жϲ������ݱ��浽������
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
