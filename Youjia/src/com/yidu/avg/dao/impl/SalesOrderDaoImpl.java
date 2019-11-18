package com.yidu.avg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.yidu.avg.dao.SalesOrderDao;
import com.yidu.avg.domain.SalesOrder;
import com.yidu.avg.utils.JdbcUtils;
/**
 * 
 * ���ܣ����ݲ�
 * @author d280 avenger��
 * ��д���ڣ� 2019��10��18������10:23:45
 * �汾��1.0
 */
public class SalesOrderDaoImpl implements SalesOrderDao {
	/**
	 * ��ʵ���������ӵ����ݿ����(һ��)
	 * @param salesOrder ���۶�����ʵ�������
	 * @return Ӱ�������(1:��ӳɹ�;0:���ʧ��)
	 */
	@Override
	public int add(SalesOrder salesOrder) {
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
			String sql="insert into salesOrder(soTime,"
					+ "usId,marId,counts,subtotal,spId) values(?,?,?,?,?,?)";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
			//pstmt.setInt(1, salesOrder.getSoId());
			//���ַ���ת������������
			pstmt.setDate(1, java.sql.Date.valueOf(salesOrder.getSoTime()));
			pstmt.setInt(2, salesOrder.getUsId());
			pstmt.setInt(3, salesOrder.getMarId());
			pstmt.setInt(4, salesOrder.getCounts());
			pstmt.setDouble(5, salesOrder.getSubtotal());
			pstmt.setInt(6, salesOrder.getspId());
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
	public int delete(int soId) {
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
			String sql="delete from salesOrder where soId=?";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
			pstmt.setInt(1, soId);
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
	public int update(SalesOrder salesOrder) {
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
			String sql="update salesOrder set soTime=?,usId=?,"
					+ "marId=?,counts=?,subtotal=?,"
					+ "spId=? where soId=?";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
			pstmt.setInt(7, salesOrder.getSoId());
			//���ַ���ת������������
			pstmt.setDate(1, java.sql.Date.valueOf(salesOrder.getSoTime()));
			pstmt.setInt(2, salesOrder.getUsId());
			pstmt.setInt(3, salesOrder.getMarId());
			pstmt.setInt(4, salesOrder.getCounts());
			pstmt.setDouble(5, salesOrder.getSubtotal());
			pstmt.setInt(6, salesOrder.getspId());
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
	public SalesOrder findById(int soId) {
		//��������
		SalesOrder salesOrder=null;
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
			String sql="select * from salesOrder where soId=?";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
			pstmt.setInt(1, soId);
			rs=pstmt.executeQuery();
			//�жϽ�������Ƿ�������
			if(rs.next()){
				salesOrder=new SalesOrder();
				salesOrder.setSoId(rs.getInt("soId"));
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				salesOrder.setSoTime(sdf.format(rs.getDate("soTime")));
				salesOrder.setUsId(rs.getInt("usId"));
				salesOrder.setMarId(rs.getInt("marId"));			
				salesOrder.setCounts(rs.getInt("counts"));
				salesOrder.setSubtotal(rs.getDouble("subtotal"));
				salesOrder.setspId(rs.getInt("spId"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//�رս���������������ݿ����Ӷ���
			JdbcUtils.close(rs, pstmt, conn);
		}
		//����Ӱ�������
		return salesOrder;
	}

	@Override
	public List<SalesOrder> findAll() {
		return null;
	}

	@Override
	public List<SalesOrder> findByPage(int rows, int page) {
		List<SalesOrder> salesOrderList=new ArrayList<SalesOrder>();
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
			String sql="select * from salesOrder limit ?,?";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			//���������ֵ
			rs=pstmt.executeQuery();
			while(rs.next()){
				SalesOrder salesOrder=new SalesOrder();
				salesOrder.setSoId(rs.getInt("soId"));
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				salesOrder.setSoTime(sdf.format(rs.getDate("soTime")));
				salesOrder.setUsId(rs.getInt("usId"));
				salesOrder.setMarId(rs.getInt("marId"));			
				salesOrder.setCounts(rs.getInt("counts"));
				salesOrder.setSubtotal(rs.getDouble("subtotal"));
				salesOrder.setspId(rs.getInt("spId"));
				salesOrderList.add(salesOrder);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//�رս���������������ݿ����Ӷ���
			JdbcUtils.close(rs, pstmt, conn);
		}
		//����Ӱ�������
		return salesOrderList;
	}

	@Override
	public List<SalesOrder> findByPage(int rows, int page, String condition) {
		List<SalesOrder> salesOrderList=new ArrayList<SalesOrder>();
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
			String sql="select * from salesOrder "+condition+" limit ?,? ";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			rs=pstmt.executeQuery();
			while(rs.next()){
				SalesOrder salesOrder=new SalesOrder();
				salesOrder.setSoId(rs.getInt("soId"));
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				salesOrder.setSoTime(sdf.format(rs.getDate("soTime")));
				salesOrder.setUsId(rs.getInt("usId"));
				salesOrder.setMarId(rs.getInt("marId"));			
				salesOrder.setCounts(rs.getInt("counts"));
				salesOrder.setSubtotal(rs.getDouble("subtotal"));
				salesOrder.setspId(rs.getInt("spId"));
				salesOrderList.add(salesOrder);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//�رս���������������ݿ����Ӷ���
			JdbcUtils.close(rs, pstmt, conn);
		}
		//����Ӱ�������
		return salesOrderList;
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
			String sql="select count(*) from salesOrder";
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
			String sql="select count(*) from salesOrder"+condition;
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
