package com.yidu.avg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.yidu.avg.dao.InventoryDao;
import com.yidu.avg.dao.impl.InventoryDaoImpl;
import com.yidu.avg.domain.Inventory;

/**
 * 
 * ���ܣ�server
 * @author d280 avenger�� ����
 * ��д���ڣ� 2019��10��19������16:44:46
 * �汾��1.0
 */
@WebServlet("/InventoryServlet")
public class InventoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InventoryServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // A:�����������Ӧ���ַ�������������
        // ����������ַ���
		request.setCharacterEncoding("utf-8");
		// ������Ӧ������ַ���
		response.setContentType("text/html");
		// ������Ӧ����������
		response.setCharacterEncoding("utf-8");
		
		// ��ȡ����·���еĲ�������ֵ
		String method=request.getParameter("method");
		
		// �ж�:
		if("findAll".equals(method)){
			this.findAll(request,response);
		}else if("add".equals(method)){
			this.add(request,response);
		}else if("update".equals(method)){
			this.update(request,response);
		}else if("delete".equals(method)){
			this.delete(request,response);
		}
	}

	/**
	 * ɾ��
	 * @param request �������
	 * @param response ��Ӧ����
	 * @throws IOException IO�쳣
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		//��ȡ�������������ݹ�����Ա������ַ���
		String itIdStr=request.getParameter("itIdStr");
		//���ַ������а�","(����)�ָ�����ַ�������
		String[] itIds=itIdStr.split(",");
		
		//�������ݲ��������
		InventoryDao inventoryDao=new InventoryDaoImpl();
		
		//����������ɾ�����п���ʧ�ܣ��˴�ʹ���쳣������ʵ��
		try{
			//ʹ��ѭ����������ɾ��
			for(int i=0;i<itIds.length;i++){
				//��ȡ��ǰ���ַ���
				String titId=itIds[i];
				//���ַ������ת��Ϊ���͵�Ա�����
				int itId=Integer.parseInt(titId);
				//ִ��ɾ������
				inventoryDao.delete(itId);
			}
			out.print("success");
		}catch(Exception e){
			out.print("failure");
		}
		
		//�ر��������
		out.close();
		
	}

	/**
	 * �޸�
	 * @param request �������
	 * @param response ��Ӧ����
	 * @throws IOException IO�쳣
	 */
	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		
		//�������Կͻ��˵�����
		//���տ���Ŀ��id
		int itId=Integer.parseInt(request.getParameter("itId"));
		//���տ���Ŀ������
		int itNumber=Integer.parseInt(request.getParameter("itNumber"));
		//���տ������Ʒ����
		int ctId=Integer.parseInt(request.getParameter("ctId"));
		
		//���ݷ�װ�ɶ���
		Inventory inventory=new Inventory(itId, itNumber, ctId);
		
		//�������ݲ����ִ����ӷ���
		InventoryDao inventoryDao=new InventoryDaoImpl();
		//����һ������ֵ���������޸ķ��������ݿⷵ�ص�ֵ
		int rows=inventoryDao.update(inventory);
		//�ж�����Ƿ�ɹ�
		if(rows>0){
			out.print("success");
		}else{
			out.print("failure");
		}
		
		out.close();
		
	}

	/**
	 * ���
	 * @param request �������
	 * @param response ��Ӧ����
	 * @throws IOException IO�쳣
	 */
	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		//�������Կͻ��˵�����
		//���տ���Ŀ������
		int itNumber=Integer.parseInt(request.getParameter("itNumber"));
		//���տ������Ʒ����
		int ctId=Integer.parseInt(request.getParameter("ctId"));
		
		
		//���ݷ�װ�ɶ���
		Inventory inventory=new Inventory(itNumber, ctId);
		//�������ݲ����ִ����ӷ���
		InventoryDao inventoryDao=new InventoryDaoImpl();
		//����һ������ֵ����������ӷ��������ݿⷵ�ص�ֵ
		int rows=inventoryDao.add(inventory);
		//�ж�����Ƿ�ɹ�
		if(rows>0){
			out.print("success");
		}else{
			out.print("failure");
		}
		
		out.close();
		
	}

	/**
	 * ������ѯ
	 * @param request �������
	 * @param response ��Ӧ����
	 * @throws IOException IO�쳣
	 */
	private void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		
		//�õ����������е���������
		//���տ���Ŀ������
		String itNumber=request.getParameter("itNumber");
		
		//���ɲ�ѯ����
		//select * from ���� where ���� limit n1,n2 
		//where �ֶ���=? and �ֶ���=? and �ֶ���=?
		String condition=" where 1=1 ";
		//���������ݽ����жϲ���ϳɲ�ѯ��
		if(itNumber!=null && !itNumber.equals("")){
			condition=condition+" and itNumber like '%"+itNumber+"%' ";
		}
		
		//�������Կͻ��˵�datagrid����Ĵ��ݹ�����page��rows����
		int rows=Integer.parseInt(request.getParameter("rows"));
		int page=Integer.parseInt(request.getParameter("page"));
		
		//�������ݲ�ִ�з�ҳ��ѯ
		InventoryDao inventoryDao=new InventoryDaoImpl();
		//��õ�ǰҳ�����ݼ���
		List<Inventory> inventoryList=inventoryDao.findByPage(rows, page,condition);
		//��ѯ��inventory����ܼ�¼��
		int totalRows=inventoryDao.count(condition);

		//B:��ʽ
		//����ӳ�伯�϶���
		Map<String, Object> mapData = new HashMap<String, Object>();
		mapData.put("total", totalRows);
		mapData.put("rows", inventoryList);
		//����Gson����
		Gson gson = new Gson();
		//ͨ��Gson����Map����ת����json���ݸ�ʽ
		String jsonData = gson.toJson(mapData);
		//��json����������ͻ���
		out.println(jsonData);
		System.out.println(jsonData);
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
