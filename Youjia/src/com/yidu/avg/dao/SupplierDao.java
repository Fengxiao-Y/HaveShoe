package com.yidu.avg.dao;

import java.util.List;

import com.yidu.avg.domain.Supplier;
/**
 * 
 * ���ܣ�ʵ����ӿ�
 * @author d280 avenger��
 * ��д���ڣ� 2019��10��17������5:47:46
 * �汾��1.0
 */
public interface SupplierDao {
	/**
	 * ��ʵ���������ӵ����ݿ����(һ��)
	 * @param supplier �ͻ�ʵ�������
	 * @return Ӱ�������(1:��ӳɹ�;0:���ʧ��)
	 */
	public int add(Supplier supplier);
	/**
	 * ���ͻ����(����)����ɾ������
	 * @param spId
	 * @return 
	 */
	public int delete(int spId);
	/**
	 * ��ʵ���������µ����ݿ����
	 * @param supplier 
	 * @return
	 */
	public int update(Supplier supplier);
	
	/**
	 * ���ݹ�Ӧ��id���ҵ�����Ӧ����Ϣ
	 * @param spId
	 * @return
	 */
	public Supplier findById(int spId);
	
	/**
	 * ��������
	 * @return
	 */
	public List<Supplier> findAll();
	/**
	 * ��ҳ����
	 * @param rows ÿҳ��ʾ�ļ�¼��
	 * @param page ��ǰ��ʾ��ҳ����
	 * @return ָ��ҳ������Ա����Ϣ����
	 */
	public List<Supplier> findByPage(int rows,int page);

	/**
	 * ��������ҳ����
	 * @param rows ÿҳ��ʾ�ļ�¼��
	 * @param page ��ǰ��ʾ��ҳ����
	 * @param condition ����
	 * @return
	 */
	public List<Supplier> findByPage(int rows,int page,String condition);

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
