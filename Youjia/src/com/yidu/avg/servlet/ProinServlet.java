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
import com.yidu.avg.dao.ProinDao;
import com.yidu.avg.dao.impl.InventoryDaoImpl;
import com.yidu.avg.dao.impl.ProinDaoImpl;
import com.yidu.avg.domain.Inventory;
import com.yidu.avg.domain.Proin;

/**
 * 
 * ���ܣ�server
 * @author d280 avenger�� ����
 * ��д���ڣ� 2019��10��25������15:32:46
 * �汾��1.0
 */
@WebServlet("/ProinServlet")
public class ProinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProinServlet() {
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
		//��ȡ�������������ݹ�����Ա������ַ���
		String pIdStr=request.getParameter("pIdStr");
		//���ַ������а�","(����)�ָ�����ַ�������
		String[] pIds=pIdStr.split(",");
		//�������ݲ��������
		ProinDao proinDao=new ProinDaoImpl();	
		//����������ɾ�����п���ʧ�ܣ��˴�ʹ���쳣������ʵ��
		try{
			//ʹ��ѭ����������ɾ��
			for(int i=0;i<pIds.length;i++){
				//��ȡ��ǰ���ַ���
				String tpId=pIds[i];
				//���ַ������ת��Ϊ���͵�Ա�����
				int pId=Integer.parseInt(tpId);
				//ִ��ɾ������
				proinDao.delete(pId);
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
		int pId=Integer.parseInt(request.getParameter("pId"));
		String pTime=request.getParameter("pTime");
		int poId=Integer.parseInt(request.getParameter("poId"));
		int pNumber=Integer.parseInt(request.getParameter("pNumber"));
		int marId=Integer.parseInt(request.getParameter("marId"));
		int itId=Integer.parseInt(request.getParameter("itId"));
		
		//���ݷ�װ�ɶ���
		Proin proin=new Proin(pId, pTime, poId, pNumber, marId, itId);
		
		//�������ݲ����ִ����ӷ���
		ProinDao proinDao=new ProinDaoImpl();
		int rows=proinDao.update(proin);
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
		//int pId=Integer.parseInt(request.getParameter("pId"));
		String pTime=request.getParameter("pTime");
		int poId=Integer.parseInt(request.getParameter("poId"));
		int pNumber=Integer.parseInt(request.getParameter("pNumber"));
		int marId=Integer.parseInt(request.getParameter("marId"));
		int itId=Integer.parseInt(request.getParameter("itId"));
		
		//���ݷ�װ�ɶ���
		Proin proin=new Proin(pTime, poId, pNumber, marId, itId);
		
		//�������ݲ����ִ����ӷ���
		ProinDao proinDao=new ProinDaoImpl();
		int rows=proinDao.add(proin);
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
		String pTime=request.getParameter("pTime");
		//���ɲ�ѯ����
		//select * from ���� where ���� limit n1,n2 
		//where �ֶ���=? and �ֶ���=? and �ֶ���=?
		String condition=" where 1=1 ";
		//���������ݽ����жϲ���ϳɲ�ѯ����
		if(pTime!=null && !pTime.equals("")){
			condition=condition+" and pTime like '%"+pTime+"%' ";
		}	
		System.out.println("condition="+condition);
		
		//�������Կͻ��˵�datagrid����Ĵ��ݹ�����page��rows����
		int rows=Integer.parseInt(request.getParameter("rows"));
		int page=Integer.parseInt(request.getParameter("page"));
		
		//�������ݲ�ִ�з�ҳ��ѯ
		ProinDao proinDao=new ProinDaoImpl();
		//��õ�ǰҳ�����ݼ���
		List<Proin> proinList=proinDao.findByPage(rows, page,condition);
		//��ѯ��emp����ܼ�¼��
		int totalRows=proinDao.count(condition);

		//����ӳ�伯�϶���
		Map<String, Object> mapData = new HashMap<String, Object>();
		mapData.put("total", totalRows);
		mapData.put("rows", proinList);
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
