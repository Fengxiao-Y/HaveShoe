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
 * 功能：servlet
 * @author d280 avenger组 邓威
 * 编写日期： 2019年10月21日下午5:58:23
 * 版本：1.0
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 // A:设置请求和响应的字符集及内容类型
        // 设置请求的字符集
        request.setCharacterEncoding("utf-8");
        // 设置响应对象的字符集
        response.setCharacterEncoding("utf-8");
        // 设置响应的内容类型
        response.setContentType("text/html");
        // 获取请求路径中的操作参数值
        String methoh = request.getParameter("methoh");
        // 判断:
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
	 * 密码判断
	 * @param request 请求对象
	 * @param response 响应对象
	 * @throws IOException IO异常
	 */
	private void ofuPwd(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		//定义输出语句
		PrintWriter out=response.getWriter();
		//接受客户输入的旧密码
		String empPwd=request.getParameter("empPwd");
		//创建session对象
		HttpSession session=request.getSession();
		//从域对象中拿出原密码
		String empPwds= (String) session.getAttribute("empPwd");
		//判断输入的旧密码是否一样
		if(!empPwds.equals(empPwd)){
			//不一样就输出0
			String i =  ofJson(0);
			out.write(i);	
		}else {
			//一样就输出1
			out.write(ofJson(1));	
		}
	}

	/**
	 * 访问
	 * @param request 请求对象
	 * @param response 响应对象
	 * @throws IOException IO异常
	 */
	private void myPIM(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//因为jsp不能够访问jsp所有要通过Servlet来进行访问
		response.sendRedirect("frontWeb/myPIM.jsp");
	}
	
	
	/**
	 * 修改密码
	 * @param request 请求对象
	 * @param response 响应对象
	 * @throws IOException IO异常
	 */
   private void ofmyPIM(HttpServletRequest request, HttpServletResponse response)
    		throws IOException {
        // 定义输出语句
        PrintWriter out = response.getWriter();
        // 从网页获得数据
        // 新密码
        String empPwd = request.getParameter("empPwd");
        if(empPwd==null&&empPwd.equals("")){
        	empPwd=request.getParameter("empPwd");
        }
        
        // 创建session对象
        HttpSession session = request.getSession();

        int empId = (Integer) session.getAttribute("empId");

        String empName = (String) session.getAttribute("empName");


    
        String empSalary = (String) session.getAttribute("empSalary");

        String empCard = (String) session.getAttribute("empCard");

        String empAddress = (String) session.getAttribute("empAddress");
        String empPhone = (String) session.getAttribute("empPhone");
        // 创建users
        Employee employee=new Employee(empId, empName, empPwd, empSalary, empCard, empAddress, empPhone);
       
        // 创建数据库操作对象
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        // 执行数据库修改方法
        int rows = employeeDao.update(employee);
        System.out.println("1111");
        if (rows == 1) {
        	
            response.sendRedirect("frontWeb/index.jsp");
        }
    }

   /**
	 * 登录
	 * @param request 请求对象
	 * @param response 响应对象
	 * @throws IOException IO异常
	 */
	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		//从网页获得数据
		String empName = request.getParameter("empName");
		
		String empPwd = request.getParameter("empPwd");
		//创建数据库操作对象
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		//查询数据库中是否存在此用户,如果存在则返回一个Users对象,如果不存在则返回为空
		Employee employees =  employeeDao.oflogin(empName);
		if(employees==null){
			out.write(ofJson(0));
			return ;
		}
		//如果此账号的密码和输入的密码不匹配,则返回页面 1 .  告诉客户密码错误
		if(employees.getEmpPwd().equals(empPwd)==false){
			//密码错误返回1
			out.write(ofJson(1));
			return;
		}
		//如果账号和密码全部正确,则登录成功,并将用户的个人信息保存至session里面
		HttpSession session = request.getSession();

		session.setAttribute("empName", employees.getEmpName());
		session.setAttribute("empId", employees.getEmpId());
		session.setAttribute("empPwd", employees.getEmpPwd());
		session.setAttribute("empSalary", employees.getEmpSalary());
		session.setAttribute("empCard", employees.getEmpCard());
		session.setAttribute("empAddress", employees.getEmpAddress());
		session.setAttribute("empPhone", employees.getEmpPhone());
		
		//密码账号正确返回2
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
