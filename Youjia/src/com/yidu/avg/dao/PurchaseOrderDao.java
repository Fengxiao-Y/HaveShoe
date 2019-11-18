package com.yidu.avg.dao;

import java.io.Serializable;
import java.util.List;

import com.yidu.avg.domain.PurchaseOrder;
/**
 * 
 * ���ܣ�ʵ����ӿ�
 * @author d280 avenger��
 * ��д���ڣ� 2019��10��17������4:56:57
 * �汾��1.0
 */
public interface PurchaseOrderDao {


	/**
	 * ���ͻ����(����)����ɾ������
	 * @param cid 
	 * @return 
	 */
	public int delete(int poId);
	/**
	 * ��ʵ���������µ����ݿ����
	 * @param cust 
	 * @return
	 */
	public int update(PurchaseOrder purchaseOrder);
	
	/**
	 * ����Ա����Ų��ҵ���Ա����Ϣ
	 * @param empNo
	 * @return
	 */
	public PurchaseOrder findById(int poId);
	
	/**
	 * ��������
	 * @return
	 */
	public List<PurchaseOrder> findAll();
	/**
	 * ��ҳ����
	 * @param rows ÿҳ��ʾ�ļ�¼��
	 * @param page ��ǰ��ʾ��ҳ����
	 * @return ָ��ҳ������Ա����Ϣ����
	 */
	public List<PurchaseOrder> findByPage(int rows,int page);

	/**
	 * ��������ҳ����
	 * @param rows ÿҳ��ʾ�ļ�¼��
	 * @param page ��ǰ��ʾ��ҳ����
	 * @param condition ����
	 * @return
	 */
	public List<PurchaseOrder> findByPage(int rows,int page,String condition);

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
	/**
	 * ��ʵ���������ӵ����ݿ����(һ��)
	 * @param cust �ͻ�ʵ�������
	 * @return Ӱ�������(1:��ӳɹ�;0:���ʧ��)
	 */
	public int add(PurchaseOrder purchaseOrder);
	
	
}
