package com.yidu.avg.dao;

import java.util.List;


import com.yidu.avg.domain.UserShoe;
/**
 * 
 * ���ܣ�ʵ����ӿ�
 * @author d280 avenger��
 * ��д���ڣ� 2019��10��17������3:45:57
 * �汾��1.0
 */
public interface UserShoeDao {
	/**
	 * ��ʵ���������ӵ����ݿ����(һ��)
	 * @param userShoe �û�ʵ�������
	 * @return Ӱ�������(1:��ӳɹ�;0:���ʧ��)
	 */
	public int add(UserShoe userShoe);
	/**
	 * ���û�id(����)����ɾ������
	 * @param usId
	 * @return 
	 */
	public int delete(int usId);
	/**
	 * ��ʵ���������µ����ݿ����
	 * @param userShoe 
	 * @return
	 */
	public int update(UserShoe userShoe);
	
	/**
	 * �����û�id���ҵ���Ա����Ϣ
	 * @param usId
	 * @return
	 */
	public UserShoe findById(int usId);
	
	/**
	 * ��������
	 * @return
	 */
	public List<UserShoe> findAll();
	/**
	 * ��ҳ����
	 * @param rows ÿҳ��ʾ�ļ�¼��
	 * @param page ��ǰ��ʾ��ҳ����
	 * @return ָ��ҳ������Ա����Ϣ����
	 */
	public List<UserShoe> findByPage(int rows,int page);

	/**
	 * ��������ҳ����
	 * @param rows ÿҳ��ʾ�ļ�¼��
	 * @param page ��ǰ��ʾ��ҳ����
	 * @param condition ����
	 * @return
	 */
	public List<UserShoe> findByPage(int rows,int page,String condition);

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
