package com.yidu.avg.dao;

import java.util.List;

import com.yidu.avg.domain.FiscalExpend;
/**
 * 
 * ���ܣ�ʵ����ӿ�
 * @author d280 avenger��
 * ��д���ڣ� 2019��10��17������1:13:09
 * �汾��1.0
 */
public interface FiscalExpendDao {

	/**
	 * ��ʵ���������ӵ����ݿ���У�һ�У�
	 * @param fiscalExpend ����֧��ʵ�������
	 * @return Ӱ�������(1����ӳɹ���0�����ʧ��)
	 */
	public int add(FiscalExpend fiscalExpend);
	
	/**
	 * �����������Id(����) ����ɾ������
	 * @param feId 
	 * @return Ӱ���������1����ӳɹ���0�����ʧ�ܣ�
	 */
	public int deleteById(int feId);
	
	/**
	 * ��ʵ���������µ������������
	 * @param fiscalExpend
	 * @return Ӱ���������1����ӳɹ���0�����ʧ�ܣ�
	 */
	public int update(FiscalExpend fiscalExpend);
	
	/**
	 * �����������Id�����ݿ���в�������
	 * @param feId ����֧����Id
	 * @return ���ز���ʵ�����
	 */
	public FiscalExpend findById(int feId);
	
	/**
	 * �����ݿ���з�ҳ��������
	 * @param rows ÿҳ����������
	 * @param page ��ǰ��ҳ��
	 * @return ָ��ҳ�е����ݼ���
	 */
	public List<FiscalExpend> findByPage(int rows, int page);
	
	/**
	 * �����ݿ���а��ض��������з�ҳ��������
	 * @param rows ÿҳ����������
	 * @param page ��ǰ��ҳ��
	 * @param condition ��ѯ����
	 * @return ָ��ҳ�е����ݼ���
	 */
	public List<FiscalExpend> findByPage(int rows, int page, String condition);
	
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
	public int count(String condition);
	
}
