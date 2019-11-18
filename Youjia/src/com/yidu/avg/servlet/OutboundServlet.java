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
import com.yidu.avg.dao.OutboundDao;
import com.yidu.avg.dao.impl.OutboundDaoImpl;
import com.yidu.avg.domain.Outbound;

/**
 * 
 * ���ܣ�servlet
 * @author d280 avenger�� ����
 * ��д���ڣ� 2019��10��20������5:23:27
 * �汾��1.0
 */
@WebServlet("/OutboundServlet")
public class OutboundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OutboundServlet() {
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
		String obIdStr=request.getParameter("obIdStr");
		//���ַ������а�","(����)�ָ�����ַ�������
		String[] obIds=obIdStr.split(",");
		
		//�������ݲ��������
		OutboundDao outboundDao=new OutboundDaoImpl();
		
		//����������ɾ�����п���ʧ�ܣ��˴�ʹ���쳣������ʵ��
		try{
			//ʹ��ѭ����������ɾ��
			for(int i=0;i<obIds.length;i++){
				//��ȡ��ǰ���ַ���
				String tobId=obIds[i];
				//���ַ������ת��Ϊ���͵�Ա�����
				int obId=Integer.parseInt(tobId);
				//ִ��ɾ������
				outboundDao.delete(obId);
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
		//���ճ�����id
		int obId=Integer.parseInt(request.getParameter("obId"));
		//���ճ�����ʱ��
		String obTime=request.getParameter("obTime");
		//���ճ����Ķ���id
		int soId=Integer.parseInt(request.getParameter("soId"));
		//���ճ����Ŀ������
		int odNumber=Integer.parseInt(request.getParameter("odNumber"));
		//���ճ�������Ʒ����id
		int marId=Integer.parseInt(request.getParameter("marId"));
		//���ճ����Ŀ��id
		int itId=Integer.parseInt(request.getParameter("itId"));
		
		//���ݷ�װ�ɶ���(�ѽ��յ����ݱ��浽ʵ����)
		Outbound outbound=new Outbound(obId, obTime, soId, odNumber, marId, itId);
		
		//�������ݲ����ִ����ӷ���
		OutboundDao outboundDao=new OutboundDaoImpl();
		//����һ������ֵ���������޸ķ��������ݿⷵ�ص�ֵ
		int rows=outboundDao.update(outbound);
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
		//���ճ�����ʱ��
		String obTime=request.getParameter("obTime");
		//���ճ����Ķ���id
		int soId=Integer.parseInt(request.getParameter("soId"));
		//���ճ����Ŀ������
		int odNumber=Integer.parseInt(request.getParameter("odNumber"));
		//���ճ�������Ʒ����id
		int marId=Integer.parseInt(request.getParameter("marId"));
		//���ճ����Ŀ��id
		int itId=Integer.parseInt(request.getParameter("itId"));;
		
		
		
		//���ݷ�װ�ɶ���
		Outbound outbound = new Outbound(obTime, soId, odNumber, marId, itId);
		//�������ݲ����ִ����ӷ���
		OutboundDao outboundDao = new OutboundDaoImpl();
		//����һ������ֵ����������ӷ��������ݿⷵ�ص�ֵ
		int rows=outboundDao.add(outbound);
		//�ж�����Ƿ�ɹ�
		if(rows>0){
			out.print("susses");
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
		//���ճ�����ʱ��
		String obTime=request.getParameter("obTime");
		
		//���ɲ�ѯ����
		//select * from ���� where ���� limit n1,n2 
		//where �ֶ���=? and �ֶ���=? and �ֶ���=?
		String condition=" where 1=1 ";
		//���������ݽ����жϲ���ϳɲ�ѯ����(���ʱ��Ϊ��Ϊ��)
		if(obTime!=null && !obTime.equals("")){
			condition=condition+" and obTime like '%"+obTime+"%' ";
		}
		
		//�������Կͻ��˵�datagrid����Ĵ��ݹ�����page��rows����
		int rows=Integer.parseInt(request.getParameter("rows"));
		int page=Integer.parseInt(request.getParameter("page"));
		
		//�������ݲ�ִ�з�ҳ��ѯ
		OutboundDao outboundDao=new OutboundDaoImpl();
		//��õ�ǰҳ�����ݼ���
		List<Outbound> outboundList=outboundDao.findByPage(rows, page,condition);
		//��ѯ��Outbound����ܼ�¼��
		int totalRows=outboundDao.count(condition);

		//B:��ʽ
		//����ӳ�伯�϶���
		Map<String, Object> mapData = new HashMap<String, Object>();
		mapData.put("total", totalRows);
		mapData.put("rows", outboundList);
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
