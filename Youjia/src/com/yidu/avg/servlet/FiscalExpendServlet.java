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
import com.yidu.avg.dao.FiscalExpendDao;
import com.yidu.avg.dao.impl.FiscalExpendDaoImpl;
import com.yidu.avg.domain.FiscalExpend;



/**
 * 
 * 功能：server
 * @author d280 avenger组 李卫
 * 编写日期： 2019年10月20日下午2:22:46
 * 版本：1.0
 */
@WebServlet("/FiscalExpendServlet")
public class FiscalExpendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FiscalExpendServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		 // A:设置请求和响应的字符集及内容类型
        // 设置请求的字符集
		request.setCharacterEncoding("utf-8");
		// 设置响应对象的字符集
		response.setContentType("text/html");
		// 设置响应的内容类型
		response.setCharacterEncoding("utf-8");
		
		// 获取请求路径中的操作参数值
		String method=request.getParameter("method");
		// 判断:
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
	 * 删除
	 * @param request 请求对象
	 * @param response 响应对象
	 * @throws IOException IO异常
	 * @throws ServletException Servlet异常
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		//获取来自请中所传递过来的员工编号字符串
		String feIdStr=request.getParameter("feIdStr");
		//将字符串进行按","(逗号)分割的子字符串数组
		String[] feIds=feIdStr.split(",");
		
		//创建数据层操作对象
		FiscalExpendDao fiscalExpendDao=new FiscalExpendDaoImpl();

		//由于是批量删除，有可能失败，此处使用异常处理来实现
		try{
			//使用循环进行批量删除
			for(int i=0;i<feIds.length;i++){
				//获取当前子字符串
				String tfeId=feIds[i];
				//将字符串编号转换为整型的员工编号
				int feId=Integer.parseInt(tfeId);
				//执行删除操作
				fiscalExpendDao.deleteById(feId);
			}
			out.print("success");
		}catch(Exception e){
			out.print("failure");
		}
		
		//关闭输出对象
		out.close();
	}

	/**
	 * 修改
	 * @param request 请求对象
	 * @param response 响应对象
	 * @throws IOException IO异常
	 * @throws ServletException Servlet异常
	 */
	private void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		//接收来自客户端的数据
		//接收财务支出表Id
		int feId=Integer.parseInt(request.getParameter("feId"));
		//接收采购id
		int poId=Integer.parseInt(request.getParameter("poId"));
		//接收操作时间
		String feTime=request.getParameter("feTime");
		//接收员工id
		int empId=Integer.parseInt(request.getParameter("empId"));
		//接收支出金额
		double feMoney =Double.parseDouble(request.getParameter("feMoney"));
		
		//数据封装成对象
		FiscalExpend fiscalExpend= new FiscalExpend(feId, poId, feTime, empId,feMoney);
		
		//调用数据层对象执行添加方法
		FiscalExpendDao fiscalExpendDao=new FiscalExpendDaoImpl();
		int rows=fiscalExpendDao.update(fiscalExpend);
		//判断添加是否成功
		if(rows>0){
			out.print("success");
		}else{
			out.print("failure");
		}
		
		out.close();
	}

	/**
	 * 添加
	 * @param request 请求对象
	 * @param response 响应对象
	 * @throws IOException IO异常
	 * @throws ServletException Servlet异常
	 */
	private void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		//接收来自客户端的数据
		//接收采购Id
		int poId=Integer.parseInt(request.getParameter("poId"));
		//接收操作时间
		String feTime=request.getParameter("feTime");
		System.out.println("shijian:"+feTime);
		//接收员工id
		int empId=Integer.parseInt(request.getParameter("empId"));
		//接收支出金额
		double feMoney =Double.parseDouble(request.getParameter("feMoney"));
		
		//数据封装成对象
		FiscalExpend fiscalExpend= new FiscalExpend(poId, feTime, empId,feMoney);
		//调用数据层对象执行添加方法
		FiscalExpendDao fiscalExpendDao=new FiscalExpendDaoImpl();
		int rows=fiscalExpendDao.add(fiscalExpend);
		//判断添加是否成功
		if(rows>0){
			out.print("success");
		}else{
			out.print("failure");
		}
		
		out.close();
	}

	/**
	 * 条件查询
	 * @param request 请求对象
	 * @param response 响应对象
	 * @throws IOException IO异常
	 * @throws ServletException Servlet异常
	 */
	private void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		//得到来自请求中的财务支出表Id数据
		String feId=request.getParameter("feId");
	
		
		//生成查询条件
		//select * from 表名 where 条件 limit n1,n2 
		//where 字段名=? and 字段名=? and 字段名=?
		String condition=" where 1=1 ";
		//对条件数据进行判断并组合成查询条件
		if(feId!=null && !feId.equals("")){
			condition=condition+" and feId like '%"+feId+"%' ";
		}
		
		
		
		//接收来自客户端的datagrid组件的传递过来的page和rows参数
		int rows=Integer.parseInt(request.getParameter("rows"));
		int page=Integer.parseInt(request.getParameter("page"));
		
		//调用数据层执行分页查询
		FiscalExpendDao fiscalExpendDao=new FiscalExpendDaoImpl();
		//获得当前页的数据集合
		List<FiscalExpend> fiscalExpendList=fiscalExpendDao.findByPage(rows, page);
		//查询出FiscalExpend表的总记录数
		int totalRows=fiscalExpendDao.count();

		//B:方式
		//定义映射集合对象
		Map<String, Object> mapData = new HashMap<String, Object>();
		mapData.put("total", totalRows);
		mapData.put("rows", fiscalExpendList);
		//定义Gson对象
		Gson gson = new Gson();
		//通过Gson对象将Map集合转换成json数据格式
		String jsonData = gson.toJson(mapData);
		//将json数据输出到客户端
		out.println(jsonData);
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
