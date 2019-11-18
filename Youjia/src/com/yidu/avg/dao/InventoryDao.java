package com.yidu.avg.dao;

import java.util.List;

import com.yidu.avg.domain.Inventory;
/**
 * 
 * ���ܣ�ʵ����ӿ�
 * @author d280 avenger��
 * ��д���ڣ� 2019��10��17������7:23:03
 * �汾��1.0
 */
public interface InventoryDao {
	/**
	 * ��ʵ���������ӵ����ݿ����(һ��)
	 * @param cust �ͻ�ʵ�������
	 * @return Ӱ�������(1:��ӳɹ�;0:���ʧ��)
	 */
	public int add(Inventory inventory);
	/**
	 * �����id(����)����ɾ������
	 * @param itId
	 * @return 
	 */
	public int delete(int itId);
	/**
	 * ��ʵ���������µ����ݿ����
	 * @param cust 
	 * @return
	 */
	public int update(Inventory inventory);
	
	/**
	 * ���ݿ��id���ҵ���Ա����Ϣ
	 * @param itId
	 * @return
	 */
	public Inventory findById(int itId);
	
	/**
	 * ��������
	 * @return
	 */
	public List<Inventory> findAll();
	/**
	 * ��ҳ����
	 * @param rows ÿҳ��ʾ�ļ�¼��
	 * @param page ��ǰ��ʾ��ҳ����
	 * @return ָ��ҳ������Ա����Ϣ����
	 */
	public List<Inventory> findByPage(int rows,int page);
	
	/**
	 * �޸Ĵ������Ĳ���
	 * @param itNumber
	 * @return
	 */
	public int updateinNumber(int itNumber,int idId);
	
	public int findcountById(int itId);
	/**
	 * ��������ҳ����
	 * @param rows ÿҳ��ʾ�ļ�¼��
	 * @param page ��ǰ��ʾ��ҳ����
	 * @param condition ����
	 * @return
	 */
	public List<Inventory> findByPage(int rows,int page,String condition);

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
