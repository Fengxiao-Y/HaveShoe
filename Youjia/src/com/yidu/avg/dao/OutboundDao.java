package com.yidu.avg.dao;

import java.util.List;

import com.yidu.avg.domain.Outbound;
/**
 * 
 * ���ܣ�ʵ����ӿ�
 * @author d280 avenger��
 * ��д���ڣ� 2019��10��17������5:24:23
 * �汾��1.0
 */
public interface OutboundDao {
	/**
	 * ��ʵ���������ӵ����ݿ����(һ��)
	 * @param outbound ����ʵ�������
	 * @return Ӱ�������(1:��ӳɹ�;0:���ʧ��)
	 */
	public int add(Outbound outbound);
	/**
	 * �������id(����)����ɾ������
	 * @param obId 
	 * @return 
	 */
	public int delete(int obId);
	/**
	 * ��ʵ���������µ����ݿ����
	 * @param outbound 
	 * @return
	 */
	public int update(Outbound outbound);
	
	/**
	 * ����Ա����Ų��ҵ���Ա����Ϣ
	 * @param obId
	 * @return
	 */
	public Outbound findById(int obId);
	
	/**
	 * ��������
	 * @return
	 */
	public List<Outbound> findAll();
	/**
	 * ��ҳ����
	 * @param rows ÿҳ��ʾ�ļ�¼��
	 * @param page ��ǰ��ʾ��ҳ����
	 * @return ָ��ҳ������Ա����Ϣ����
	 */
	public List<Outbound> findByPage(int rows,int page);

	/**
	 * ��������ҳ����
	 * @param rows ÿҳ��ʾ�ļ�¼��
	 * @param page ��ǰ��ʾ��ҳ����
	 * @param condition ����
	 * @return
	 */
	public List<Outbound> findByPage(int rows,int page,String condition);

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
