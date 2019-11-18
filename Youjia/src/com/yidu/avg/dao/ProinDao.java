package com.yidu.avg.dao;

import java.util.List;


import com.yidu.avg.domain.Proin;
/**
 * 
 * ���ܣ�ʵ����ӿ�
 * @author d280 avenger��
 * ��д���ڣ� 2019��10��17������4:27:54
 * �汾��1.0
 */
public interface ProinDao {
	/**
	 * ��ʵ���������ӵ����ݿ����(һ��)
	 * @param outbound ����ʵ�������
	 * @return Ӱ�������(1:��ӳɹ�;0:���ʧ��)
	 */
	public int add(Proin proin);
	/**
	 * ������id(����)����ɾ������
	 * @param pId 
	 * @return 
	 */
	public int delete(int pId);
	/**
	 * ��ʵ���������µ����ݿ����
	 * @param outbound 
	 * @return
	 */
	public int update(Proin proin);
	
	/**
	 * �������id���ҵ��������Ϣ
	 * @param pId
	 * @return
	 */
	public Proin findById(int pId);
	
	/**
	 * ��������
	 * @return
	 */
	public List<Proin> findAll();
	/**
	 * ��ҳ����
	 * @param rows ÿҳ��ʾ�ļ�¼��
	 * @param page ��ǰ��ʾ��ҳ����
	 * @return ָ��ҳ������Ա����Ϣ����
	 */
	public List<Proin> findByPage(int rows,int page);

	/**
	 * ��������ҳ����
	 * @param rows ÿҳ��ʾ�ļ�¼��
	 * @param page ��ǰ��ʾ��ҳ����
	 * @param condition ����
	 * @return
	 */
	public List<Proin> findByPage(int rows,int page,String condition);

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
