package com.yidu.avg.dao;

import java.util.List;

import com.yidu.avg.domain.SalesOrder;
/**
 * 
 * ���ܣ�ʵ����ӿ�
 * @author d280 avenger��
 * ��д���ڣ� 2019��10��17������6:10:34
 * �汾��1.0
 */
public interface SalesOrderDao {
	/**
	 * ��ʵ���������ӵ����ݿ����(һ��)
	 * @param cust �ͻ�ʵ�������
	 * @return Ӱ�������(1:��ӳɹ�;0:���ʧ��)
	 */
	public int add(SalesOrder salesOrder);
	/**
	 * ������id(����)����ɾ������
	 * @param soId
	 * @return 
	 */
	public int delete(int soId);
	/**
	 * ��ʵ���������µ����ݿ����
	 * @param salesOrder 
	 * @return
	 */
	public int update(SalesOrder salesOrder);
	
	/**
	 * ���ݶ���id���ҵ���Ա����Ϣ
	 * @param soId
	 * @return
	 */
	public SalesOrder findById(int soId);
	
	/**
	 * ��������
	 * @return
	 */
	public List<SalesOrder> findAll();
	/**
	 * ��ҳ����
	 * @param rows ÿҳ��ʾ�ļ�¼��
	 * @param page ��ǰ��ʾ��ҳ����
	 * @return ָ��ҳ������Ա����Ϣ����
	 */
	public List<SalesOrder> findByPage(int rows,int page);

	/**
	 * ��������ҳ����
	 * @param rows ÿҳ��ʾ�ļ�¼��
	 * @param page ��ǰ��ʾ��ҳ����
	 * @param condition ����
	 * @return
	 */
	public List<SalesOrder> findByPage(int rows,int page,String condition);

	/**
	 * ͳ�Ƽ�¼��
	 * @return �������м�¼����
	 */
	public int count();
	
	/**
	 * ͳ�Ʒ��������ļ�¼��
	 * @param condition ����
	 * @return
	 */
	public int count(String condition);
}
