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
 * ���ܣ����ݲ�
 * @author d280 avenger�� ����
 * ��д���ڣ� 2019��10��18������9:44:45
 * �汾��1.0
 */
public class PurchaseOrderDaoImpl implements PurchaseOrderDao {
	/**
	 * ����Ʒ״̬id(����)����ɾ������
	 * @param poId 
	 * @return 
	 */
	@Override
	public int delete(int poId) {
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
			String sql="delete from purchaseOrder where poId=?";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
			pstmt.setInt(1, poId);
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
	 * @param cust 
	 * @return
	 */
	@Override
	public int update(PurchaseOrder purchaseOrder) {
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
			String sql="update purchaseOrder set marId=?,poName=?,"
					+ "poTime=?,spId=?,poCounts=?,"
					+ "poPrice=? where poId=?";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
			pstmt.setInt(7, purchaseOrder.getPoId());
			pstmt.setInt(1, purchaseOrder.getMarId());
			pstmt.setString(2, purchaseOrder.getPoName());
			//���ַ���ת������������
			pstmt.setString(3, purchaseOrder.getPoTime());
			pstmt.setInt(4, purchaseOrder.getSpId());
			pstmt.setInt(5, purchaseOrder.getPoCounts());
			pstmt.setDouble(6, purchaseOrder.getPoPrice());
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
	 * ����Ա����Ų��ҵ���Ա����Ϣ
	 * @param empNo
	 * @return
	 */
	@Override
	public PurchaseOrder findById(int poId) {
		//��������
		PurchaseOrder purchaseOrder=null;
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
			String sql="select * from purchaseOrder where poId=?";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
			pstmt.setInt(1, poId);
			rs=pstmt.executeQuery();
			//�жϽ�������Ƿ�������
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
			//�رս���������������ݿ����Ӷ���
			JdbcUtils.close(rs, pstmt, conn);
		}
		//����Ӱ�������
		return purchaseOrder;
	}
	/**
	 * ��������
	 * @return
	 */
	@Override
	public List<PurchaseOrder> findAll() {
		return null;
	}
	/**
	 * ��ҳ����
	 * @param rows ÿҳ��ʾ�ļ�¼��
	 * @param page ��ǰ��ʾ��ҳ����
	 * @return ָ��ҳ������Ա����Ϣ����
	 */
	@Override
	public List<PurchaseOrder> findByPage(int rows, int page) {
		List<PurchaseOrder> purchaseOrderList=new ArrayList<PurchaseOrder>();
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
			String sql="select * from purchaseOrder limit ?,?";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			//���������ֵ
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
			//�رս���������������ݿ����Ӷ���
			JdbcUtils.close(rs, pstmt, conn);
		}
		//����Ӱ�������
		return purchaseOrderList;
	}
	/**
	 * ��������ҳ����
	 * @param rows ÿҳ��ʾ�ļ�¼��
	 * @param page ��ǰ��ʾ��ҳ����
	 * @param condition ����
	 * @return
	 */
	@Override
	public List<PurchaseOrder> findByPage(int rows, int page, String condition) {
		List<PurchaseOrder> purchaseOrderList=new ArrayList<PurchaseOrder>();
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
			String sql="select * from purchaseOrder "+condition+" limit ?,? ";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
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
			//�رս���������������ݿ����Ӷ���
			JdbcUtils.close(rs, pstmt, conn);
		}
		//����Ӱ�������
		return purchaseOrderList;
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
			String sql="select count(*) from purchaseOrder";
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
			String sql="select count(*) from purchaseOrder"+condition;
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
	 * ��ʵ���������ӵ����ݿ����(һ��)
	 * @param purchaseOrder �ɹ�����ʵ�������
	 * @return Ӱ�������(1:��ӳɹ�;0:���ʧ��)
	 */
	@Override
	public int add(PurchaseOrder purchaseOrder) {
		//����һ��Ӱ�������ı���
		int rows=0;
		//�������ݿ����Ӷ���
		Connection conn=null;
		//����Ԥ������
		PreparedStatement pstmt=null;
		//����һ�������
		ResultSet rs = null;
		
		try {
			//ʵ�������ݿ����Ӷ��� 
			conn=JdbcUtils.getConnection();
			//����SQL����ַ���
			String sql="insert into purchaseOrder(marId,"
					+ "poName,poTime,spId,poCounts,poPrice) values(?,?,?,?,?,?) ";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			//��������ֵ
			//pstmt.setInt(1, purchaseOrder.getPoId());
			pstmt.setInt(1, purchaseOrder.getMarId());
			pstmt.setString(2, purchaseOrder.getPoName());
			//���ַ���ת������������
			pstmt.setString(3, purchaseOrder.getPoTime());
			pstmt.setInt(4, purchaseOrder.getSpId());
			pstmt.setInt(5, purchaseOrder.getPoCounts());
			pstmt.setDouble(6, purchaseOrder.getPoPrice());
			//ִ�������󣬲�����Ӱ�������
			pstmt.executeUpdate();
			rs=pstmt.getGeneratedKeys();
			if(rs.next()){
				rows=rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//�رս���������������ݿ����Ӷ���
			JdbcUtils.close(null, pstmt, conn);
		}
		//����Ӱ�������
		return rows;
	}
}
