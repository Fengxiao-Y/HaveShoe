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

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.google.gson.Gson;
import com.yidu.avg.dao.FiscalRevenueDao;
import com.yidu.avg.dao.FiscalRevenueDao;
import com.yidu.avg.dao.impl.FiscalExpendDaoImpl;
import com.yidu.avg.dao.impl.FiscalRevenueDaoImpl;
import com.yidu.avg.dao.impl.FiscalRevenueDaoImpl;
import com.yidu.avg.domain.FiscalRevenue;
import com.yidu.avg.domain.FiscalRevenue;

/**
 * 
 * ���ܣ�servlet
 * @author d280 avenger�� ����
 * ��д���ڣ� 2019��10��20������3:34:22
 * �汾��1.0
 */
@WebServlet("/FiscalRevenueServlet")
public class FiscalRevenueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FiscalRevenueServlet() {
        super();
        // TODO Auto-generated constructor stub
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
	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		PrintWriter out=response.getWriter();
		//��ȡ�������������ݹ����������id����ַ���
		String frIdStr=request.getParameter("frIdStr");
		//���ַ������а�","(����)�ָ�����ַ�������
		String[] frIds=frIdStr.split(",");
		
		//�������ݲ��������
		FiscalRevenueDao FiscalRevenueDao=new FiscalRevenueDaoImpl();
		
		//����������ɾ�����п���ʧ�ܣ��˴�ʹ���쳣������ʵ��
		try{
			//ʹ��ѭ����������ɾ��
			for(int i=0;i<frIds.length;i++){
				//��ȡ��ǰ���ַ���
				String tfrId=frIds[i];
				//���ַ������ת��Ϊ���͵������id
				int frId=Integer.parseInt(tfrId);
				//ִ��ɾ������
				FiscalRevenueDao.deleteById(frId);
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
	private void update(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		PrintWriter out=response.getWriter();
		
		//�������Կͻ��˵�����
		//���ղ��������id
		int frId=Integer.parseInt(request.getParameter("frId"));
		//���ն���id
		int soId=Integer.parseInt(request.getParameter("soId"));
		//���ղ���ʱ��
		String frTime=request.getParameter("frTime");
		//����������
		double frMoney=Double.parseDouble(request.getParameter("frMoney"));
		
		//���ݷ�װ�ɶ���
		FiscalRevenue FiscalRevenue=new FiscalRevenue(frId,soId,frTime,frMoney);
		
		//�������ݲ����ִ����ӷ���
		FiscalRevenueDao FiscalRevenueDao=new FiscalRevenueDaoImpl();
		int rows=FiscalRevenueDao.update(FiscalRevenue);
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
	private void add(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		PrintWriter out=response.getWriter();
		//�������Կͻ��˵�����
		System.out.println("frId");
		//���ն�����id
		int soId=Integer.parseInt(request.getParameter("soId"));
		//���ղ���ʱ��
		String frTime=request.getParameter("frTime");
		//����������
		double frMoney=Double.parseDouble(request.getParameter("frMoney"));
		
		//���ݷ�װ�ɶ���
		FiscalRevenue fiscalRevenue=new FiscalRevenue(soId, frTime,frMoney);
		
		//�������ݲ����ִ����ӷ���
		FiscalRevenueDao FiscalRevenueDao=new FiscalRevenueDaoImpl();
		int rows=FiscalRevenueDao.add(fiscalRevenue);
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
	private void findAll(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		PrintWriter out=response.getWriter();
		//�������������е�����
		//���ղ��������id
		String frId=request.getParameter("frId");
		//���ն���id
		String soId=request.getParameter("soId");
		
		//���ɲ�ѯ����
		//select * from ���� where ���� limit n1,n2 
		//where �ֶ���=? and �ֶ���=? and �ֶ���=?
		String condition=" where 1=1 ";
		//���������ݽ����жϲ���ϳɲ�ѯ����
		if(frId!=null && !frId.equals("")){
			int frId1=Integer.parseInt(frId);
			condition=condition+" and frId like '%"+frId1+"%' ";
		}
		//���ݹ����ֶ�ֵ�����жϣ���������
		if(soId!=null && !soId.equals("")){
			int soId1=Integer.parseInt(soId);
			condition=condition+" and soId like '%"+soId1+"%' ";
		}
		
		System.out.println("condition="+condition);
		
		//�������Կͻ��˵�datagrid������ݹ�����page��rows����
		int rows =Integer.parseInt(request.getParameter("rows"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		//�������ݲ���з�ҳ��ѯ
		FiscalRevenueDao fiscalRevenueDao = new FiscalRevenueDaoImpl();
		//��ȡ��ǰҳ�����ݼ���
		List<FiscalRevenue> fiscalRevenueList = fiscalRevenueDao.findByPage(rows, page,condition);
		//��ѯ��FiscalRevenue���е��ܼ�¼��
		int totalRows = fiscalRevenueDao.count(condition);
		
		//����ӳ�伯�϶���
		Map<String, Object> mapData = new HashMap<String, Object>();
		mapData.put("total",totalRows);
		mapData.put("rows", fiscalRevenueList);
		
		//����Gson����
		Gson gson = new Gson();
		//ͨ��Gson����Map����ת����json���ݸ�ʽ
		String jsonData = gson.toJson(mapData);
		//��json����������ͻ���
		out.println(jsonData);
		//System.out.println(jsonData);
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
