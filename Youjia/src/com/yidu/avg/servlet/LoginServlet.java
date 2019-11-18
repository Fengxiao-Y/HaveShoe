package com.yidu.avg.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yidu.avg.dao.EmployeeDao;
import com.yidu.avg.dao.impl.EmployeeDaoImpl;
import com.yidu.avg.domain.Employee;

/**
 * 
 * ���ܣ�servlet
 * @author d280 avenger�� ����
 * ��д���ڣ� 2019��10��21������5:58:23
 * �汾��1.0
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 // A:�����������Ӧ���ַ�������������
        // ����������ַ���
        request.setCharacterEncoding("utf-8");
        // ������Ӧ������ַ���
        response.setCharacterEncoding("utf-8");
        // ������Ӧ����������
        response.setContentType("text/html");
        // ��ȡ����·���еĲ�������ֵ
        String methoh = request.getParameter("methoh");
        // �ж�:
        System.out.println(methoh);
        if ("login".equals(methoh)) {
        	login(request, response);
        }else if("myPIM".equals(methoh)){
        	myPIM(request,response);
        }else if("ofuPwd".equals(methoh)){
        	ofuPwd(request,response);
        }else if ("ofmyPIM".equals(methoh)){
            ofmyPIM(request, response);
        }
	}




	/**
	 * �����ж�
	 * @param request �������
	 * @param response ��Ӧ����
	 * @throws IOException IO�쳣
	 */
	private void ofuPwd(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		//����������
		PrintWriter out=response.getWriter();
		//���ܿͻ�����ľ�����
		String empPwd=request.getParameter("empPwd");
		//����session����
		HttpSession session=request.getSession();
		//����������ó�ԭ����
		String empPwds= (String) session.getAttribute("empPwd");
		//�ж�����ľ������Ƿ�һ��
		if(!empPwds.equals(empPwd)){
			//��һ�������0
			String i =  ofJson(0);
			out.write(i);	
		}else {
			//һ�������1
			out.write(ofJson(1));	
		}
	}

	/**
	 * ����
	 * @param request �������
	 * @param response ��Ӧ����
	 * @throws IOException IO�쳣
	 */
	private void myPIM(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//��Ϊjsp���ܹ�����jsp����Ҫͨ��Servlet�����з���
		response.sendRedirect("frontWeb/myPIM.jsp");
	}
	
	
	/**
	 * �޸�����
	 * @param request �������
	 * @param response ��Ӧ����
	 * @throws IOException IO�쳣
	 */
   private void ofmyPIM(HttpServletRequest request, HttpServletResponse response)
    		throws IOException {
        // ����������
        PrintWriter out = response.getWriter();
        // ����ҳ�������
        // ������
        String empPwd = request.getParameter("empPwd");
        if(empPwd==null&&empPwd.equals("")){
        	empPwd=request.getParameter("empPwd");
        }
        
        // ����session����
        HttpSession session = request.getSession();

        int empId = (Integer) session.getAttribute("empId");

        String empName = (String) session.getAttribute("empName");


    
        String empSalary = (String) session.getAttribute("empSalary");

        String empCard = (String) session.getAttribute("empCard");

        String empAddress = (String) session.getAttribute("empAddress");
        String empPhone = (String) session.getAttribute("empPhone");
        // ����users
        Employee employee=new Employee(empId, empName, empPwd, empSalary, empCard, empAddress, empPhone);
       
        // �������ݿ��������
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        // ִ�����ݿ��޸ķ���
        int rows = employeeDao.update(employee);
        System.out.println("1111");
        if (rows == 1) {
        	
            response.sendRedirect("frontWeb/index.jsp");
        }
    }

   /**
	 * ��¼
	 * @param request �������
	 * @param response ��Ӧ����
	 * @throws IOException IO�쳣
	 */
	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		//����ҳ�������
		String empName = request.getParameter("empName");
		
		String empPwd = request.getParameter("empPwd");
		//�������ݿ��������
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		//��ѯ���ݿ����Ƿ���ڴ��û�,��������򷵻�һ��Users����,����������򷵻�Ϊ��
		Employee employees =  employeeDao.oflogin(empName);
		if(employees==null){
			out.write(ofJson(0));
			return ;
		}
		//������˺ŵ��������������벻ƥ��,�򷵻�ҳ�� 1 .  ���߿ͻ��������
		if(employees.getEmpPwd().equals(empPwd)==false){
			//������󷵻�1
			out.write(ofJson(1));
			return;
		}
		//����˺ź�����ȫ����ȷ,���¼�ɹ�,�����û��ĸ�����Ϣ������session����
		HttpSession session = request.getSession();

		session.setAttribute("empName", employees.getEmpName());
		session.setAttribute("empId", employees.getEmpId());
		session.setAttribute("empPwd", employees.getEmpPwd());
		session.setAttribute("empSalary", employees.getEmpSalary());
		session.setAttribute("empCard", employees.getEmpCard());
		session.setAttribute("empAddress", employees.getEmpAddress());
		session.setAttribute("empPhone", employees.getEmpPhone());
		
		//�����˺���ȷ����2
		out.write(ofJson(2));
	}
	public String ofJson(int i){
		String json = "{\"state\":\""+i+"\"}";		
		return json;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
