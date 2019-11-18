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
import com.yidu.avg.dao.UserShoeDao;
import com.yidu.avg.dao.impl.UserShoeDaoImpl;
import com.yidu.avg.domain.UserShoe;

/**
 * 
 * ���ܣ�servlet
 * @author d280 avenger�� ����
 * ��д���ڣ� 2019��10��21������6:29:25
 * �汾��1.0
 */
@WebServlet("/UserShoeServlet")
public class UserShoeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserShoeServlet() {
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
		String usIdStr=request.getParameter("usIdStr");
		//���ַ������а�","(����)�ָ�����ַ�������
		String[] usIds=usIdStr.split(",");
		
		//�������ݲ��������
		UserShoeDao userShoeDao=new UserShoeDaoImpl();
		
		//����������ɾ�����п���ʧ�ܣ��˴�ʹ���쳣������ʵ��
		try{
			//ʹ��ѭ����������ɾ��
			for(int i=0;i<usIds.length;i++){
				//��ȡ��ǰ���ַ���
				String tusId=usIds[i];
				//���ַ������ת��Ϊ���͵�Ա�����
				int usId=Integer.parseInt(tusId);
				//ִ��ɾ������
				userShoeDao.delete(usId);
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
		//int usId=Integer.parseInt(request.getParameter("usId"));
		String usName=request.getParameter("usName");
		String usPwd=request.getParameter("usPwd");
		String usSex=request.getParameter("usSex");
		String usEmail=request.getParameter("usEmail");
		String usAddress=request.getParameter("usAddress");
		String usPhone=request.getParameter("usPhone");
		String usPostal=request.getParameter("usPostal");
		
		//���ݷ�װ�ɶ���
		UserShoe userShoe=new UserShoe(usName, usPwd, usSex, usEmail, usAddress, usPhone, usPostal);
		
		//�������ݲ����ִ����ӷ���
		UserShoeDao userShoeDao=new UserShoeDaoImpl();
		int rows=userShoeDao.update(userShoe);
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
		int usId=Integer.parseInt(request.getParameter("usId"));
		String usName=request.getParameter("usName");
		String usPwd=request.getParameter("usPwd");
		String usSex=request.getParameter("usSex");
		String usEmail=request.getParameter("usEmail");
		String usAddress=request.getParameter("usAddress");
		String usPhone=request.getParameter("usPhone");
		String usPostal=request.getParameter("usPostal");
		
		
		//���ݷ�װ�ɶ���
		UserShoe userShoe=new UserShoe(usId, usName, usPwd, usSex, usEmail, usAddress, usPhone, usPostal);
		
		//�������ݲ����ִ����ӷ���
		UserShoeDao userShoeDao=new UserShoeDaoImpl();
		int rows=userShoeDao.add(userShoe);
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
		String usName=request.getParameter("usName");
		String usPhone=request.getParameter("usPhone");
		
		//���ɲ�ѯ����
		//select * from ���� where ���� limit n1,n2 
		//where �ֶ���=? and �ֶ���=? and �ֶ���=?
		String condition=" where 1=1 ";
		//���������ݽ����жϲ���ϳɲ�ѯ����
		if(usName!=null && !usName.equals("")){
			condition=condition+" and usName like '%"+usName+"%' ";
		}
		//���ݹ����ֶ�ֵ�����жϣ���������
		if(usPhone!=null && !usPhone.equals("")){
			condition=condition+" and usPhone like '%"+usPhone+"%' ";
		}
	
		
		System.out.println("condition="+condition);
		
		//�������Կͻ��˵�datagrid����Ĵ��ݹ�����page��rows����
		int rows=Integer.parseInt(request.getParameter("rows"));
		int page=Integer.parseInt(request.getParameter("page"));
		
		//�������ݲ�ִ�з�ҳ��ѯ
		UserShoeDao userShoeDao=new UserShoeDaoImpl();
		//��õ�ǰҳ�����ݼ���
		List<UserShoe> userShoeList=userShoeDao.findByPage(rows, page,condition);
		//��ѯ��emp����ܼ�¼��
		int totalRows=userShoeDao.count(condition);

		//B:��ʽ
		//����ӳ�伯�϶���
		Map<String, Object> mapData = new HashMap<String, Object>();
		mapData.put("total", totalRows);
		mapData.put("rows", userShoeList);
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
