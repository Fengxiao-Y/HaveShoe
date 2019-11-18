package com.yidu.avg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yidu.avg.dao.CommodityTypeDao;
import com.yidu.avg.domain.CommodityType;
import com.yidu.avg.domain.Marque;
import com.yidu.avg.utils.JdbcUtils;
/**
 * 
 * ���ܣ����ݲ�
 * @author d280 avenger�� ������
 * ��д���ڣ� 2019��10��18������3:53:47
 * �汾��1.0
 */
public class CommodityTypeDaoImpl implements CommodityTypeDao {

	/**
	 * ��ʵ���������ӵ����ݿ���У�һ�У�
	 * @param CommodityType ����֧��ʵ�������
	 * @return Ӱ�������(1����ӳɹ���0�����ʧ��)
	 */
	@Override
	public int add(CommodityType commodityType) {
		//�������Ӷ���
		Connection conn=null;
		//����������
		PreparedStatement pstmt=null;
		//����һ��Ӱ�������ı���
		int row=0;
		try {  
			//ʵ�л����Ӷ���
			conn=JdbcUtils.getConnection();
			String sql="insert into commodityType(ctName) values(?)";
			//ʵ�л�������
			pstmt=conn.prepareStatement(sql);
			//pstmt.setInt(1, commodityType.getCtId());
			pstmt.setString(1, commodityType.getCtName());;
			row=pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		
		}finally{
			//�رս����
			JdbcUtils.close(null, pstmt, conn);
		}
		//����Ӱ������
		return row;
	}

	@Override
	public int deleteById(int ctId) {
		//�������Ӷ���
		Connection conn=null;
		//����������
		PreparedStatement pstmt=null;
		//System.out.println("1111");
		//����һ��Ӱ�������ı���
		int row=0;
		try {
			//ʵ�л����Ӷ���
			conn=JdbcUtils.getConnection();
			String sql="delete from commodityType where ctId=?";
			//ʵ�л�������
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, ctId);
			row=pstmt.executeUpdate();
			//System.out.println("1111");
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		
		}finally{
			//�رս����
			JdbcUtils.close(null, pstmt, conn);
		}
		//����Ӱ������
		return row;
	}

	@Override
	public int update(CommodityType commodityType) {
		//�������Ӷ���
		Connection conn=null;
		//����������
		PreparedStatement pstmt=null;
		//����һ��Ӱ�������ı���
		int row=0;
		try {
			//ʵ�л����Ӷ���
			conn=JdbcUtils.getConnection();
			//����SQLִ�����
			String sql="update commodityType set ctName=? where ctId=?";
		
			//ʵ�л�������
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, commodityType.getCtName());
			pstmt.setInt(2, commodityType.getCtId());
			row=pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		
		}finally{
			//�رս����,���������ݿ����Ӷ���
			JdbcUtils.close(null, pstmt, conn);
		}
		//����Ӱ������
		return row;	
				
	}

	@Override
	public CommodityType findById(int ctId) {
		//��һ���ն���
		CommodityType CommodityType=null;
		//�������Ӷ���
		Connection conn=null;
		//����������
		PreparedStatement pstmt=null;
		//����һ�����������
		ResultSet rs=null;
		
			try {
				//ʵ�л����Ӷ���
				conn=JdbcUtils.getConnection();
				//����SQLִ�����
				String sql="select * from CommodityType where ctId=?";
				//ʵ����Ԥ����������
				pstmt=conn.prepareStatement(sql);
				//��������ֵ
				pstmt.setInt(1, ctId);
				//ִ�������󣬲�����Ӱ�������
				rs=pstmt.executeQuery();
				if(rs.next()){
					CommodityType=new CommodityType();
					CommodityType.setCtId(rs.getInt("ctId"));
					CommodityType.setCtName(rs.getString("ctName"));
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage(),e);
			
			}finally {
				//�رս����,���������ݿ����Ӷ���
				JdbcUtils.close(rs, pstmt, conn);
			}
		
	     return CommodityType;
	}

	@Override
	public List<CommodityType> findByPage(int rows, int page) {
		List<CommodityType> CommodityTypeList=new ArrayList<CommodityType>();
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
			String sql="select * from CommodityType limit?,?";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			rs=pstmt.executeQuery();
			while(rs.next()){
				CommodityType CommodityType=new CommodityType();
				CommodityType.setCtId(rs.getInt("ctId"));
				CommodityType.setCtName(rs.getString("ctName"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}finally {
			//�رս���������������ݿ����Ӷ���
			JdbcUtils.close(rs, pstmt, conn);
		}
		//����Ӱ�������
		return CommodityTypeList;
	}

	@Override
	public List<CommodityType> findByPage(int rows, int page, String condition) {
		List<CommodityType> commodityTypeList=new ArrayList<CommodityType>();
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
			String sql="select * from CommodityType "+condition+" limit ?,?";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			rs=pstmt.executeQuery();
			while(rs.next()){
				CommodityType commodityType=new CommodityType();
				commodityType.setCtId(rs.getInt("ctId"));
				commodityType.setCtName(rs.getString("ctName"));
				commodityTypeList.add(commodityType);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}finally {
			//�رս���������������ݿ����Ӷ���
			JdbcUtils.close(rs, pstmt, conn);
		}
		//����Ӱ�������
		return commodityTypeList;
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
			String sql="select count(*) from CommodityType";
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//���������ֵ
			rs=pstmt.executeQuery();
			if(rs.next()){
				rows=rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}finally {
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
			String sql="select count(*) from CommodityType"+condition;
			//ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//���������ֵ
			rs=pstmt.executeQuery();
			if(rs.next()){
				rows=rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}finally{
			//�رս���������������ݿ����Ӷ���
			JdbcUtils.close(rs, pstmt, conn);
		}
		//����Ӱ�������
		return rows;

	}

}
