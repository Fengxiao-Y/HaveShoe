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
 * 功能：servlet
 * @author d280 avenger组 邓威
 * 编写日期： 2019年10月20日下午3:13:19
 * 版本：1.0
 */
@WebServlet("/HeadServlet")
public class HeadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public HeadServlet() {
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
        String methoh = request.getParameter("method");
        // 判断:
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
