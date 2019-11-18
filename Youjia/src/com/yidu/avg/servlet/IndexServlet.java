package com.yidu.avg.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.mysql.cj.api.Session;

/**
 * 
 * 功能：servlet
 * @author d280 avenger组 邓威
 * 编写日期： 2019年10月20日下午8:45:23
 * 版本：1.0
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IndexServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        if ("index".equals(methoh)) {
            index(request, response);
        } 
	}

	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("frontWeb/index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
