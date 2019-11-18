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
 * ���ܣ�servlet
 * @author d280 avenger�� ����
 * ��д���ڣ� 2019��10��20������8:45:23
 * �汾��1.0
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IndexServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
