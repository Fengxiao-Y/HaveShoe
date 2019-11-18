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
import com.yidu.avg.dao.FiscalExpendDao;
import com.yidu.avg.dao.InventoryDao;
import com.yidu.avg.dao.ProinDao;
import com.yidu.avg.dao.PurchaseOrderDao;
import com.yidu.avg.dao.impl.FiscalExpendDaoImpl;
import com.yidu.avg.dao.impl.InventoryDaoImpl;
import com.yidu.avg.dao.impl.ProinDaoImpl;
import com.yidu.avg.dao.impl.PurchaseOrderDaoImpl;
import com.yidu.avg.domain.FiscalExpend;
import com.yidu.avg.domain.Inventory;
import com.yidu.avg.domain.Proin;
import com.yidu.avg.domain.PurchaseOrder;

/**
 * 
 * ���ܣ�server
 * @author d280 avenger�� ����
 * ��д���ڣ� 2019��10��24������19:12:46
 * �汾��1.0
 */
@WebServlet("/PurchaseOrderServlet")
public class PurchaseOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchaseOrderServlet() {
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
		System.out.println("method:"+method);
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
		//��ȡ�������������ݹ�������Ʒ״̬id�ַ���
		String poIdStr=request.getParameter("poIdStr");
		//���ַ������а�","(����)�ָ�����ַ�������
		String[] poIds=poIdStr.split(",");
		
		//�������ݲ��������
		PurchaseOrderDao purchaseOrderDao=new PurchaseOrderDaoImpl();
		
		//����������ɾ�����п���ʧ�ܣ��˴�ʹ���쳣������ʵ��
		try{
			//ʹ��ѭ����������ɾ��
			for(int i=0;i<poIds.length;i++){
				//��ȡ��ǰ���ַ���
				String tpoId=poIds[i];
				//���ַ������ת��Ϊ���͵�Ա�����
				int poId=Integer.parseInt(tpoId);
				//ִ��ɾ������
				purchaseOrderDao.delete(poId);
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
		int poId=Integer.parseInt(request.getParameter("poId"));
		int marId=Integer.parseInt(request.getParameter("marId"));
		String poName=request.getParameter("poName");
		String poTime=request.getParameter("poTime");
		int spId=Integer.parseInt(request.getParameter("spId"));
		int poCounts=Integer.parseInt(request.getParameter("poCounts"));
		double poPrice=Double.parseDouble(request.getParameter("poPrice"));
		
		//���ݷ�װ�ɶ���
		PurchaseOrder purchaseOrder=new PurchaseOrder(poId, marId, poName, poTime, spId, poCounts, poPrice);
		
		//�������ݲ����ִ����ӷ���
		PurchaseOrderDao purchaseOrderDao=new PurchaseOrderDaoImpl();
		int rows=purchaseOrderDao.update(purchaseOrder);
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
		//int poId=Integer.parseInt(request.getParameter("poId"));
		int marId=Integer.parseInt(request.getParameter("marId"));
		String poName=request.getParameter("poName");
		String poTime=request.getParameter("poTime");
		int spId=Integer.parseInt(request.getParameter("spId"));
		int poCounts=Integer.parseInt(request.getParameter("poCounts"));
		double poPrice=Double.parseDouble(request.getParameter("poPrice"));
		int itId=Integer.parseInt(request.getParameter("itId"));

		//���ݷ�װ�ɶ���
		PurchaseOrder purchaseOrder=new PurchaseOrder(marId, poName, poTime, spId, poCounts, poPrice);
		//�������ݲ����ִ����ӷ���
		PurchaseOrderDao purchaseOrderDao=new PurchaseOrderDaoImpl();
		
		int rows=purchaseOrderDao.add(purchaseOrder);
		//�ж�����Ƿ�ɹ�
		if(rows>0){
			//���������͵��۵õ�֧�����ܼ�
			double purchaseprice=poCounts*poPrice;
			//��ӳɹ�,����֧����ķ���
			FiscalExpend fed=new FiscalExpend(rows, poTime, 1,purchaseprice);
			//����ADD������֧��������һ����¼
			FiscalExpendDao feDao=new FiscalExpendDaoImpl();
			//�������
			feDao.add(fed);
			//��װ����
			Proin pp=new Proin(poTime, rows, poCounts, marId, itId);
			//��������ķ���
			ProinDao ppDao=new ProinDaoImpl();
			//����add�������
			ppDao.add(pp);
			//���ÿ�������ݲ㷽��
			InventoryDao invendao = new InventoryDaoImpl();
			//�ҵ������������
			int tt=invendao.findcountById(itId);
			int dd=tt+poCounts;
			//����ADD������������ӵ�������
			invendao.updateinNumber(dd,itId);	
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
		String poName=request.getParameter("poName");
		String poTime=request.getParameter("poTime");
		
		//���ɲ�ѯ����
		String condition=" where 1=1 ";
		//���������ݽ����жϲ���ϳɲ�ѯ����
		if(poName!=null && !poName.equals("")){
			condition=condition+" and poName like '%"+poName+"%' ";
		}
		//���ݹ���ʱ���ֶ�ֵ�����жϣ���������
		if(poTime!=null && !poTime.equals("")){
			condition=condition+" and poTime like '%"+poTime+"%' ";
		}
		
		//�������Կͻ��˵�datagrid����Ĵ��ݹ�����page��rows����
		int rows=Integer.parseInt(request.getParameter("rows"));
		int page=Integer.parseInt(request.getParameter("page"));
		
		//�������ݲ�ִ�з�ҳ��ѯ
		PurchaseOrderDao purchaseOrderDao=new PurchaseOrderDaoImpl();
		//��õ�ǰҳ�����ݼ���
		List<PurchaseOrder> purchaseOrderList=purchaseOrderDao.findByPage(rows, page, condition);
		//��ѯ��purchaseOrder����ܼ�¼��
		int totalRows=purchaseOrderDao.count(condition);
		//����ӳ�伯�϶���
		Map<String, Object> mapData = new HashMap<String, Object>();
		mapData.put("total", totalRows);
		mapData.put("rows", purchaseOrderList);
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
