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
 * ���ܣ����ݲ�
 * @author d280 avenger�� ����
 * ��д���ڣ� 2019��10��18������10:56:46
 * �汾��1.0
 */
public class FiscalExpendDaoImpl implements FiscalExpendDao {

	/**
	 * ��ʵ���������ӵ����ݿ���У�һ�У�
	 * @param fiscalExpend ����֧��ʵ�������
	 * @return Ӱ�������(1����ӳɹ���0�����ʧ��)
	 */
	@Override
	public int add(FiscalExpend fiscalExpend) {

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
			String sql="insert into fiscalExpend(poId,feTime,empId,feMoney)"
					+ " values(?,?,?,?)";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
			//pstmt.setInt(1, fiscalExpend.getFeId());
			pstmt.setInt(1, fiscalExpend.getPoId());
			//���ַ���ת�������ݿ����������
			pstmt.setString(2, fiscalExpend.getFeTime());
			pstmt.setInt(3, fiscalExpend.getEmpId());
			pstmt.setDouble(4, fiscalExpend.getFeMoney());
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
	 * @param feId 
	 * @return Ӱ���������1����ӳɹ���0�����ʧ�ܣ�
	 */
	@Override
	public int deleteById(int feId) {
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
			String sql="delete from fiscalExpend where feId=?";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
			pstmt.setInt(1, feId);
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
	 * @param fiscalExpend
	 * @return Ӱ���������1����ӳɹ���0�����ʧ�ܣ�
	 */
	@Override
	public int update(FiscalExpend fiscalExpend) {
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
			String sql="update fiscalExpend set poId=?,"
					+ "feTime=?,empId=?,feMoney=? where feId=?";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
			pstmt.setInt(1, fiscalExpend.getPoId());
			//���ַ���ת�������ݿ����������
			pstmt.setString(2, fiscalExpend.getFeTime());
			pstmt.setInt(3, fiscalExpend.getEmpId());
			pstmt.setDouble(4, fiscalExpend.getFeMoney());
			pstmt.setInt(5, fiscalExpend.getFeId());
			
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
	 * @param feId ����֧����Id
	 * @return ���ز���ʵ�����
	 */
	@Override
	public FiscalExpend findById(int feId) {
		//����һ������
		FiscalExpend fiscalExpend=null;
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
			String sql="select * from FiscalExpend where feId=?";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
			pstmt.setInt(1, feId);
			//ʵ�������������
			rs=pstmt.executeQuery();
			//���ݽ�������жϲ������ݱ��浽������
			if(rs.next()){
				//����һ������
				fiscalExpend=new FiscalExpend();
				//�����ݱ��浽������
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
			//�رս���������������ݿ����Ӷ���
			JdbcUtils.close(rs, pstmt, conn);
		}
		//����һ������
		return fiscalExpend;
	}

	/**
	 * �����ݿ���з�ҳ��������
	 * @param rows ÿҳ����������
	 * @param page ��ǰ��ҳ��
	 * @return ָ��ҳ�е����ݼ���
	 */
	@Override
	public List<FiscalExpend> findByPage(int rows, int page) {
		//����һ������
		List<FiscalExpend> fiscalExpendList=new ArrayList<FiscalExpend>();
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
			String sql="select * from fiscalExpend limit ?,?";
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
				FiscalExpend fiscalExpend=new FiscalExpend();
				//�����ݱ��浽������
				fiscalExpend.setFeId(rs.getInt("feId"));
				fiscalExpend.setPoId(rs.getInt("poId"));
				//SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				fiscalExpend.setFeTime(rs.getString("feTime"));
				fiscalExpend.setFeMoney(rs.getDouble("feMoney"));
				fiscalExpend.setEmpId(rs.getInt("empId"));
				//��������ӵ�������
				fiscalExpendList.add(fiscalExpend);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//�رս���������������ݿ����Ӷ���
			JdbcUtils.close(rs, pstmt, conn);
		}
		//����һ������
		return fiscalExpendList;
	}

	/**
	 * �����ݿ���а��ض��������з�ҳ��������
	 * @param rows ÿҳ����������
	 * @param page ��ǰ��ҳ��
	 * @param condition ��ѯ����
	 * @return ָ��ҳ�е����ݼ���
	 */
	@Override
	public List<FiscalExpend> findByPage(int rows, int page, String condition) {
		//����һ������
		List<FiscalExpend> fiscalExpendList=new ArrayList<FiscalExpend>();
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
			String sql="select * from fiscalExpend "+condition+" limit ?,?";
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
				FiscalExpend fiscalExpend=new FiscalExpend();
				//�����ݱ��浽������
				fiscalExpend.setFeId(rs.getInt("feId"));
				fiscalExpend.setPoId(rs.getInt("poId"));
				
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				
				fiscalExpend.setFeTime(rs.getString("feTime"));
				fiscalExpend.setFeMoney(rs.getDouble("feMoney"));
				fiscalExpend.setEmpId(rs.getInt("empId"));
				//��������ӵ�������
				fiscalExpendList.add(fiscalExpend);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//�رս���������������ݿ����Ӷ���
			JdbcUtils.close(rs, pstmt, conn);
		}
		//����һ������
		return fiscalExpendList;
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
			String sql="select count(*) from fiscalExpend";
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
			String sql="select count(*) from cust "+condition;
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
