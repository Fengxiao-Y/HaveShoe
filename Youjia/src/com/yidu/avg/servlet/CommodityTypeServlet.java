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
import com.yidu.avg.dao.CommodityTypeDao;
import com.yidu.avg.dao.impl.CommodityTypeDaoImpl;
import com.yidu.avg.domain.CommodityType;


/**
 * 
 * ���ܣ�servlet
 * @author d280 avenger��  ������
 * ��д���ڣ� 2019��10��20������3:53:44
 * �汾��1.0
 */
@WebServlet("/CommodityTypeServlet")
public class CommodityTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommodityTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		String ctIdStr=request.getParameter("ctIdStr");
		//���ַ������а�","(����)�ָ�����ַ�������
		String[] ctIds=ctIdStr.split(",");
		
		//�������ݲ��������
		CommodityTypeDao commodityTypeDao=new CommodityTypeDaoImpl();
		
		//����������ɾ�����п���ʧ�ܣ��˴�ʹ���쳣������ʵ��
		try{
			//ʹ��ѭ����������ɾ��
			for(int i=0;i<ctIds.length;i++){
				//��ȡ��ǰ���ַ���
				String tctId=ctIds[i];
				//���ַ������ת��Ϊ���͵�Ա�����
				int ctId=Integer.parseInt(tctId);
				//ִ��ɾ������
				commodityTypeDao.deleteById(ctId);
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
		int ctId=Integer.parseInt(request.getParameter("ctId"));
		String ctName=request.getParameter("ctName");
		//���ݷ�װ�ɶ���
		CommodityType commodityType=new CommodityType(ctId, ctName);
		
		//�������ݲ����ִ����ӷ���
		CommodityTypeDao commodityTypeDao=new CommodityTypeDaoImpl();
		int rows=commodityTypeDao.update(commodityType);
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
		//int ctId=Integer.parseInt(request.getParameter("ctId"));
		String ctName=request.getParameter("ctName");
		
		//���ݷ�װ�ɶ���
		CommodityType commodityType=new CommodityType(ctName);
		//�������ݲ����ִ����ӷ���
		CommodityTypeDao commodityTypeDao=new CommodityTypeDaoImpl();
		int rows=commodityTypeDao.add(commodityType);
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
		
		String ctId=request.getParameter("ctId");
		String ctName=request.getParameter("ctName");
		
		//���ɲ�ѯ����
		//select * from ���� where ���� limit n1,n2 
		//where �ֶ���=? and �ֶ���=? and �ֶ���=?
		String condition=" where 1=1 ";
		//���������ݽ����жϲ���ϳɲ�ѯ����
		if(ctId!=null && !ctId.equals("")){
			condition=condition+" and ctId like '%"+ctId+"%' ";
		}
		//���ݹ����ֶ�ֵ�����жϣ���������
		if(ctName!=null && !ctName.equals("")){
			condition=condition+" and ctName like '%"+ctName+"%' ";
		}
		
		System.out.println("condition="+condition);
		
		//�������Կͻ��˵�datagrid����Ĵ��ݹ�����page��rows����
		int rows=Integer.parseInt(request.getParameter("rows"));
		int page=Integer.parseInt(request.getParameter("page"));
		
		//�������ݲ�ִ�з�ҳ��ѯ
		CommodityTypeDao commodityTypeDao=new CommodityTypeDaoImpl();
		//��õ�ǰҳ�����ݼ���
		List<CommodityType> commodityTypeList=commodityTypeDao.findByPage(rows, page,condition);
		//��ѯ��emp����ܼ�¼��
		int totalRows=commodityTypeDao.count(condition);

		//B:��ʽ
		//����ӳ�伯�϶���
		Map<String, Object> mapData = new HashMap<String, Object>();
		mapData.put("total", totalRows);
		mapData.put("rows", commodityTypeList);
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
