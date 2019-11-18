package com.yidu.avg.dao;

import java.util.List;

import com.yidu.avg.domain.Marque;
/**
 * 
 * ���ܣ�ʵ����ӿ�
 * @author d280 avenger��
 * ��д���ڣ� 2019��10��17������1:23:45
 * �汾��1.0
 */
public interface MarqueDao {
	//��
	public int add(Marque marque);
	//ɾ
	public int deleteById(int marId);
 	//�޸�
 	public int update(Marque marque);
 	//��
 	public Marque findById(int ctId);
 	/**
 	 * ��ҳ����
 	 * @param rows ÿҳ��ʾ��¼
 	 * @param page ��ǰ��ʾ������
 	 * @return ָ��ҳ��������Ʒ��Ϣ����
 	 */
 	public List<Marque> findByPage(int rows,int page);
 	/**
	 * ��������ҳ����
	 * @param rows ÿҳ��ʾ�ļ�¼��
	 * @param page ��ǰ��ʾ������
	 * @param condition ����
	 * @return
	 */
 	public List<Marque> findByPage(int rows,int page,String condition);
 	/**
	 * ͳ�Ƽ�¼��
	 * @return �������м�¼����
	 */
 	public int count();
 	/**
 	 * ���ض���������ͳ������
	 * @param condition ����
	 * @return �������з������������ݼ�¼����
 	 */
 	public int count(String condition);
}
