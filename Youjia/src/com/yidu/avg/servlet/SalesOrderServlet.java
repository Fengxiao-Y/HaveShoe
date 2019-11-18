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
import com.yidu.avg.dao.SalesOrderDao;
import com.yidu.avg.dao.impl.SalesOrderDaoImpl;
import com.yidu.avg.domain.SalesOrder;

/**
 * 
 * ���ܣ�servlet
 * @author d280 avenger�� ����
 * ��д���ڣ� 2019��10��23������5:27:14
 * �汾��1.0
 */
@WebServlet("/SalesOrderServlet")
public class SalesOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalesOrderServlet() {
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
		String soIdStr=request.getParameter("soIdStr");
		//���ַ������а�","(����)�ָ�����ַ�������
		String[] soIds=soIdStr.split(",");
		
		//�������ݲ��������
		SalesOrderDao salesOrderDao=new SalesOrderDaoImpl();
		
		//����������ɾ�����п���ʧ�ܣ��˴�ʹ���쳣������ʵ��
		try{
			//ʹ��ѭ����������ɾ��
			for(int i=0;i<soIds.length;i++){
				//��ȡ��ǰ���ַ���
				String tsoId=soIds[i];
				//���ַ������ת��Ϊ���͵�Ա�����
				int soId=Integer.parseInt(tsoId);
				//ִ��ɾ������
				salesOrderDao.delete(soId);
			}
			out.print("success");
		}catch(Exception e){
			out.print("failure");
		}
		
		//�ر��������
		out.close();
		
	}

	/**
	 * 	
	 * @param request �������
	 * @param response ��Ӧ����
	 * @throws IOException IO�쳣
	 */
	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		//�������Կͻ��˵�����
		int soId=Integer.parseInt(request.getParameter("soId"));
		String soTime=request.getParameter("soTime");
		int usId=Integer.parseInt(request.getParameter("usId"));
		int marId=Integer.parseInt(request.getParameter("marId"));
		int counts=Integer.parseInt(request.getParameter("counts"));
		double subtotal=Double.parseDouble(request.getParameter("subtotal"));
		int spId=Integer.parseInt(request.getParameter("spId"));
		
		//���ݷ�װ�ɶ���
		SalesOrder salesOrder=new SalesOrder(soId, soTime, usId, marId, counts, subtotal, spId);
		
		//�������ݲ����ִ����ӷ���
		SalesOrderDao salesOrderDao=new SalesOrderDaoImpl();
		int rows=salesOrderDao.update(salesOrder);
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
		//int soId=Integer.parseInt(request.getParameter("soId"));
		String soTime=request.getParameter("soTime");
		int usId=Integer.parseInt(request.getParameter("usId"));
		int marId=Integer.parseInt(request.getParameter("marId"));
		int counts=Integer.parseInt(request.getParameter("counts"));
		double subtotal=Double.parseDouble(request.getParameter("subtotal"));
		int spId=Integer.parseInt(request.getParameter("spId"));
		
		
		//���ݷ�װ�ɶ���
		SalesOrder salesOrder=new SalesOrder(soTime, usId, marId, counts, subtotal, spId);
		//�������ݲ����ִ����ӷ���
		SalesOrderDao salesOrderDao=new SalesOrderDaoImpl();
		int rows=salesOrderDao.add(salesOrder);
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
		String soTime=request.getParameter("soTime");
		
		//���ɲ�ѯ����
		//select * from ���� where ���� limit n1,n2 
		//where �ֶ���=? and �ֶ���=? and �ֶ���=?
		String condition=" where 1=1 ";
		//���������ݽ����жϲ���ϳɲ�ѯ����
		if(soTime!=null && !soTime.equals("")){
			condition=condition+" and soTime like '%"+soTime+"%' ";
		}
		
		System.out.println("condition="+condition);
		
		//�������Կͻ��˵�datagrid����Ĵ��ݹ�����page��rows����
		int rows=Integer.parseInt(request.getParameter("rows"));
		int page=Integer.parseInt(request.getParameter("page"));
		
		//�������ݲ�ִ�з�ҳ��ѯ
		SalesOrderDao salesOrderDao=new SalesOrderDaoImpl();
		//��õ�ǰҳ�����ݼ���
		List<SalesOrder> salesOrderList=salesOrderDao.findByPage(rows, page,condition);
		//��ѯ��emp����ܼ�¼��
		int totalRows=salesOrderDao.count(condition);

		//B:��ʽ
		//����ӳ�伯�϶���
		Map<String, Object> mapData = new HashMap<String, Object>();
		mapData.put("total", totalRows);
		mapData.put("rows", salesOrderList);
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
