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
import com.yidu.avg.dao.EmployeeDao;
import com.yidu.avg.dao.impl.EmployeeDaoImpl;
import com.yidu.avg.domain.Employee;



/**
 * 
 * ���ܣ�servlet
 * @author d280 avenger�� ��Ĭ��
 * ��д���ڣ� 2019��10��20������5:52:33
 * �汾��1.0
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
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
		String empIdStr=request.getParameter("empIdStr");
		//���ַ������а�","(����)�ָ�����ַ�������
		String[] empIds=empIdStr.split(",");
		
		//�������ݲ��������
		EmployeeDao employeeDao=new EmployeeDaoImpl();
		
		//����������ɾ�����п���ʧ�ܣ��˴�ʹ���쳣������ʵ��
		try{
			//ʹ��ѭ����������ɾ��
			for(int i=0;i<empIds.length;i++){
				//��ȡ��ǰ���ַ���
				String tempId=empIds[i];
				//���ַ������ת��Ϊ���͵�Ա�����
				int empId=Integer.parseInt(tempId);
				//ִ��ɾ������
				employeeDao.delete(empId);
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
		int empId=Integer.parseInt(request.getParameter("empId"));
		String empName=request.getParameter("empName");
		String empPwd=request.getParameter("empPwd");
		String empSalary=request.getParameter("empSalary");
		String empCard=request.getParameter("empCard");
		String empAddress=request.getParameter("empAddress");
		String empPhone=request.getParameter("empPhone");
	
		
		//���ݷ�װ�ɶ���
		Employee employee=new Employee(empId,empName, empPwd, empSalary, empCard, empAddress, empPhone);
		
		//�������ݲ����ִ����ӷ���
		EmployeeDao employeeDao=new EmployeeDaoImpl();
		int rows=employeeDao.update(employee);
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
		//int empId=Integer.parseInt(request.getParameter("empId"));
		String empName=request.getParameter("empName");
		String empPwd=request.getParameter("empPwd");
		String empSalary=request.getParameter("empSalary");
		String empCard=request.getParameter("empCard");
		String empAddress=request.getParameter("empAddress");
		String empPhone=request.getParameter("empPhone");
	
		
		//���ݷ�װ�ɶ���
		Employee employee=new Employee(empName, empPwd, empSalary, empCard, empAddress, empPhone);
		//�������ݲ����ִ����ӷ���
		EmployeeDao employeeDao=new EmployeeDaoImpl();
		int rows=employeeDao.add(employee);
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
		String empName=request.getParameter("empName");
		String empPhone=request.getParameter("empPhone");
	
		
		//���ɲ�ѯ����
		//select * from ���� where ���� limit n1,n2 
		//where �ֶ���=? and �ֶ���=? and �ֶ���=?
		String condition=" where 1=1 ";
		//���������ݽ����жϲ���ϳɲ�ѯ����
		if(empName!=null && !empName.equals("")){
			condition=condition+" and empName like '%"+empName+"%' ";
		}
		//���ݹ����ֶ�ֵ�����жϣ���������
		if(empPhone!=null && !empPhone.equals("")){
			condition=condition+" and empPhone like '%"+empPhone+"%' ";
		}
		
		
		
		System.out.println("condition="+condition);
		
		//�������Կͻ��˵�datagrid����Ĵ��ݹ�����page��rows����
		int rows=Integer.parseInt(request.getParameter("rows"));
		int page=Integer.parseInt(request.getParameter("page"));
		
		//�������ݲ�ִ�з�ҳ��ѯ
		EmployeeDao employeeDao=new EmployeeDaoImpl();
		//��õ�ǰҳ�����ݼ���
		List<Employee> employeeList=employeeDao.findByPage(rows, page,condition);
		//��ѯ��emp����ܼ�¼��
		int totalRows=employeeDao.count(condition);
		
		//B:��ʽ
		//����ӳ�伯�϶���
		Map<String, Object> mapData = new HashMap<String, Object>();
		mapData.put("total", totalRows);
		mapData.put("rows", employeeList);
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
