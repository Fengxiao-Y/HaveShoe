package com.yidu.avg.dao;

import java.util.List;

import com.yidu.avg.domain.CommodityType;

/**
 * 
 * ���ܣ�ʵ����ӿ�
 * @author d280 avenger��
 * ��д���ڣ� 2019��10��17������3:23:56
 * �汾��1.0
 */
public interface CommodityTypeDao {
	/**
	 * 
	 * @param commodityType
	 * @return
	 */
   public int add(CommodityType commodityType);
 	//ɾ��
 	public int deleteById(int ctId);
 	//�޸�
 	public int update(CommodityType commodityType);
 	
 	public CommodityType findById(int ctId);
 	/**
 	 * ��ҳ����
 	 * @param rows ÿҳ��ʾ��¼
 	 * @param page ��ǰ��ʾ������
 	 * @return ָ��ҳ��������Ʒ��Ϣ����
 	 */
 	public List<CommodityType> findByPage(int rows,int page);
 	/**
	 * ��������ҳ����
	 * @param rows ÿҳ��ʾ�ļ�¼��
	 * @param page ��ǰ��ʾ������
	 * @param condition ����
	 * @return
	 */
 	public List<CommodityType> findByPage(int rows,int page,String condition);
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
