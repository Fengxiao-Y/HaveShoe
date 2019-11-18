package com.yidu.avg.dao;

import java.util.List;

import com.yidu.avg.domain.Shopping;

/**
 * 
 * ���ܣ�ʵ����ӿ�
 * @author d280 avenger��
 * ��д���ڣ� 2019��10��15������3:23:57
 * �汾��1.0
 */
public interface ShoppingDao {
	/**
	 * ��ʵ���������ӵ����ݿ����(һ��)
	 * @param cust �ͻ�ʵ�������
	 * @return Ӱ�������(1:��ӳɹ�;0:���ʧ��)
	 */
	public int add(Shopping shopping);
	/**
	 * ���ͻ����(����)����ɾ������
	 * @param cid 
	 * @return 
	 */
	public int delete(int spId);
	/**
	 * ��ʵ���������µ����ݿ����
	 * @param cust 
	 * @return
	 */
	public int update(Shopping shopping);
	
	/**
	 * ����Ա����Ų��ҵ���Ա����Ϣ
	 * @param empNo
	 * @return
	 */
	public Shopping findById(int spId);
	
	/**
	 * ��������
	 * @return
	 */
	public List<Shopping> findAll();
	/**
	 * ��ҳ����
	 * @param rows ÿҳ��ʾ�ļ�¼��
	 * @param page ��ǰ��ʾ��ҳ����
	 * @return ָ��ҳ������Ա����Ϣ����
	 */
	public List<Shopping> findByPage(int rows,int page);

	/**
	 * ��������ҳ����
	 * @param rows ÿҳ��ʾ�ļ�¼��
	 * @param page ��ǰ��ʾ��ҳ����
	 * @param condition ����
	 * @return
	 */
	public List<Shopping> findByPage(int rows,int page,String condition);

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
