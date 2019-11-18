package com.yidu.avg.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * 
 * ���ܣ�servlet
 * @author d280 avenger�� ����
 * ��д���ڣ� 2019��10��20������3:13:19
 * �汾��1.0
 */
@WebServlet("/HeadServlet")
public class HeadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public HeadServlet() {
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
        String methoh = request.getParameter("method");
        // �ж�:
        if ("findAdd".equals(methoh)) {
        	findAdd(request, response);
        } 
	}

	private void findAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
