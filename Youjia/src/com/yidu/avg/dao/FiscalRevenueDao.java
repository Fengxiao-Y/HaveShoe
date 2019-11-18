package com.yidu.avg.dao;

import java.util.List;

import com.yidu.avg.domain.FiscalRevenue;
/**
 * 
 * ���ܣ�ʵ����ӿ�
 * @author d280 avenger��
 * ��д���ڣ� 2019��10��17������4:26:45
 * �汾��1.0
 */
public interface FiscalRevenueDao {
	
	/**
	 * ��ʵ���������ӵ����ݿ���У�һ�У�
	 * @param fiscalRevenue ��������ʵ�������
	 * @return Ӱ���������1����ӳɹ���0�����ʧ�ܣ�
	 */
	public int add(FiscalRevenue fiscalRevenue);
	
	/**
	 * �����������Id(����) ����ɾ������
	 * @param frId
	 * @return Ӱ���������1����ӳɹ���0�����ʧ�ܣ�
	 */
	public int deleteById(int frId);
	
	/**
	 * ��ʵ���������µ������������
	 * @param fiscalRevenue
	 * @return Ӱ���������1����ӳɹ���0�����ʧ�ܣ�
	 */
	public int update(FiscalRevenue fiscalRevenue);
	
	/**
	 * �����������Id�����ݿ���в�������
	 * @param frId ���������Id
	 * @return ���ز���ʵ�����
	 */
	public FiscalRevenue findById(int frId);
	
	/**
	 * �����ݿ���з�ҳ��������
	 * @param rows ÿҳ����������
	 * @param page ��ǰ��ҳ��
	 * @return ָ��ҳ�е����ݼ���
	 */
	public List<FiscalRevenue> findByPage(int rows,int page);
	
	/**
	 * �����ݿ���а��ض��������з�ҳ��������
	 * @param rows ÿҳ����������
	 * @param page ��ǰ��ҳ��
	 * @param condition ��ѯ����
	 * @return ָ��ҳ�е����ݼ���
	 */
	public List<FiscalRevenue> findByPage(int rows,int page,String condition);
	
	/**
	 * ͳ�����ݿ��������������
	 * @return ����������
	 */
	public int count();
	
	/**
	 * ���ض�����ͳ�����ݿ��������������
	 * @param condition ����
	 * @return ��������������������
	 */
	public int  count(String condition);
}
