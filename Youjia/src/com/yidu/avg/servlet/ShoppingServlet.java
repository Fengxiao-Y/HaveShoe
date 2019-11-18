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
import com.yidu.avg.dao.ShoppingDao;
import com.yidu.avg.dao.impl.ShoppingDaoImpl;
import com.yidu.avg.domain.Shopping;

/**
 * 
 * ���ܣ�server
 * @author d280 avenger�� ����
 * ��д���ڣ� 2019��10��23������4:02:00
 * �汾��1.0
 */
@WebServlet("/ShoppingServlet")
public class ShoppingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
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
	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		//��ȡ�������������ݹ�����Ա������ַ���
		String spIdStr=request.getParameter("spIdStr");
		//���ַ������а�","(����)�ָ�����ַ�������
		String[] spIds=spIdStr.split(",");
		
		//�������ݲ��������
		ShoppingDao shoppingDao=new ShoppingDaoImpl();
		
		//����������ɾ�����п���ʧ�ܣ��˴�ʹ���쳣������ʵ��
		try{
			//ʹ��ѭ����������ɾ��
			for(int i=0;i<spIds.length;i++){
				//��ȡ��ǰ���ַ���
				String tspId=spIds[i];
				//���ַ������ת��Ϊ���͵�Ա�����
				int spId=Integer.parseInt(tspId);
				//ִ��ɾ������
				shoppingDao.delete(spId);
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
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		//�������Կͻ��˵�����
		int spId=Integer.parseInt(request.getParameter("spId"));
		int marId=Integer.parseInt(request.getParameter("marId"));
		int spNum=Integer.parseInt(request.getParameter("spNum"));
		double spCount=Double.parseDouble(request.getParameter("spCount"));
	
		
		//���ݷ�װ�ɶ���
		Shopping shopping=new Shopping(spId,marId, spNum, spCount);
		
		//�������ݲ����ִ����ӷ���
		ShoppingDao shoppingDao=new ShoppingDaoImpl();
		int rows=shoppingDao.update(shopping);
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
	private void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		//�������Կͻ��˵�����
		//int spId=Integer.parseInt(request.getParameter("spId"));
		int marId=Integer.parseInt(request.getParameter("marId"));
		int spNum=Integer.parseInt(request.getParameter("spNum"));
		double spCount=Double.parseDouble(request.getParameter("spCount"));
		
		
		//���ݷ�װ�ɶ���
		Shopping shopping=new Shopping(marId, spNum, spCount);
		
		//�������ݲ����ִ����ӷ���
		ShoppingDao shoppingDao=new ShoppingDaoImpl();
		int rows=shoppingDao.add(shopping);
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
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		//�õ����������е���������
		String marId=request.getParameter("marId");
		String spNum=request.getParameter("spNum");
		String spCount=request.getParameter("spCount");
		
		//���ɲ�ѯ����
		//select * from ���� where ���� limit n1,n2 
		//where �ֶ���=? and �ֶ���=? and �ֶ���=?
		String condition=" where 1=1 ";
		//���������ݽ����жϲ���ϳɲ�ѯ����
		
		if(marId!=null && !marId.equals("")){
			//����deptno��int���ͣ�����ת������
			int mar=Integer.parseInt(marId);
			//��ӵ�������
			condition=condition+" and marId="+mar+" ";
		}
		if(spNum!=null && !spNum.equals("")){
			//����deptno��int���ͣ�����ת������
			int spn=Integer.parseInt(spNum);
			//��ӵ�������
			condition=condition+" and spNum="+spn+" ";
		}
		if(spCount!=null && !spCount.equals("")){
			//����deptno��int���ͣ�����ת������
			int spc=Integer.parseInt(spCount);
			//��ӵ�������
			condition=condition+" and spCount="+spc+" ";
		}
		
		System.out.println("condition="+condition);
		
		//�������Կͻ��˵�datagrid����Ĵ��ݹ�����page��rows����
		int rows=Integer.parseInt(request.getParameter("rows"));
		int page=Integer.parseInt(request.getParameter("page"));
		
		//�������ݲ�ִ�з�ҳ��ѯ
		ShoppingDao shoppingDao=new ShoppingDaoImpl();
		//��õ�ǰҳ�����ݼ���
		List<Shopping> shoppingList=shoppingDao.findByPage(rows, page,condition);
		//��ѯ��emp����ܼ�¼��
		int totalRows=shoppingDao.count(condition);

		//B:��ʽ
		//����ӳ�伯�϶���
		Map<String, Object> mapData = new HashMap<String, Object>();
		mapData.put("total", totalRows);
		mapData.put("rows", shoppingList);
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
