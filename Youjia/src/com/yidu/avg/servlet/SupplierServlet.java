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
import com.yidu.avg.dao.SupplierDao;
import com.yidu.avg.dao.impl.SupplierDaoImpl;
import com.yidu.avg.domain.Supplier;

/**
 * 
 * ���ܣ�servlet
 * @author d280 avenger�� ����
 * ��д���ڣ� 2019��10��22������7:21:56
 * �汾��1.0
 */
@WebServlet("/SupplierServlet")
public class SupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		
		String method=request.getParameter("method");
		System.out.println("method:"+method);
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
		String spIdStr=request.getParameter("spIdStr");
		//���ַ������а�","(����)�ָ�����ַ�������
		String[] spIds=spIdStr.split(",");
		
		//�������ݲ��������
		SupplierDao supplierDao=new SupplierDaoImpl();
		
		//����������ɾ�����п���ʧ�ܣ��˴�ʹ���쳣������ʵ��
		try{
			//ʹ��ѭ����������ɾ��
			for(int i=0;i<spIds.length;i++){
				//��ȡ��ǰ���ַ���
				String tspId=spIds[i];
				//���ַ������ת��Ϊ���͵�Ա�����
				int spId=Integer.parseInt(tspId);
				//ִ��ɾ������
				supplierDao.delete(spId);
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
		int spId=Integer.parseInt(request.getParameter("spId"));
		String spName=request.getParameter("spName");
		String spPhone=request.getParameter("spPhone");
		String spAddress=request.getParameter("spAddress");
		
		//���ݷ�װ�ɶ���
		Supplier supplier=new Supplier(spId, spName, spPhone, spAddress);
		
		//�������ݲ����ִ����ӷ���
		SupplierDao supplierDao=new SupplierDaoImpl();
		int rows=supplierDao.update(supplier);
		//�ж�����Ƿ�ɹ�
		if(rows>0){
			out.print("success");
		}else{
			out.print("failure");
		}
		
		out.close();
		
	}
	
	/**
	 * ����
	 * @param request �������
	 * @param response ��Ӧ����
	 * @throws IOException IO�쳣
	 */
	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		//�������Կͻ��˵�����
		//int spId=Integer.parseInt(request.getParameter("spId"));
		String spName=request.getParameter("spName");
		String spPhone=request.getParameter("spPhone");
		String spAddress=request.getParameter("spAddress");
		
		
		//���ݷ�װ�ɶ���
		Supplier supplier=new Supplier(spName, spPhone, spAddress);
		//�������ݲ����ִ����ӷ���
		SupplierDao supplierDao=new SupplierDaoImpl();
		int rows=supplierDao.add(supplier);
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
		String spName=request.getParameter("spName");
		String spPhone=request.getParameter("spPhone");
		
		//���ɲ�ѯ����
		//select * from ���� where ���� limit n1,n2 
		//where �ֶ���=? and �ֶ���=? and �ֶ���=?
		String condition=" where 1=1 ";
		//���������ݽ����жϲ���ϳɲ�ѯ����
		if(spName!=null && !spName.equals("")){
			condition=condition+" and spName like '%"+spName+"%' ";
		}
		//���ݹ�Ӧ�������ֶ�ֵ�����жϣ���������
		if(spPhone!=null && !spPhone.equals("")){
			condition=condition+" and spPhone like '%"+spPhone+"%' ";
		}
		
		System.out.println("condition="+condition);
		
		//�������Կͻ��˵�datagrid����Ĵ��ݹ�����page��rows����
		int rows=Integer.parseInt(request.getParameter("rows"));
		int page=Integer.parseInt(request.getParameter("page"));
		
		//�������ݲ�ִ�з�ҳ��ѯ
		SupplierDao supplierDao=new SupplierDaoImpl();
		//��õ�ǰҳ�����ݼ���
		List<Supplier> supplierList=supplierDao.findByPage(rows, page,condition);
		//��ѯ��emp����ܼ�¼��
		int totalRows=supplierDao.count(condition);

		//B:��ʽ
		//����ӳ�伯�϶���
		Map<String, Object> mapData = new HashMap<String, Object>();
		mapData.put("total", totalRows);
		mapData.put("rows", supplierList);
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
