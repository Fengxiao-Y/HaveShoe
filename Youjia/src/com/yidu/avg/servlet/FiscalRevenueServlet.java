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

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.google.gson.Gson;
import com.yidu.avg.dao.FiscalRevenueDao;
import com.yidu.avg.dao.FiscalRevenueDao;
import com.yidu.avg.dao.impl.FiscalExpendDaoImpl;
import com.yidu.avg.dao.impl.FiscalRevenueDaoImpl;
import com.yidu.avg.dao.impl.FiscalRevenueDaoImpl;
import com.yidu.avg.domain.FiscalRevenue;
import com.yidu.avg.domain.FiscalRevenue;

/**
 * 
 * 功能：servlet
 * @author d280 avenger组 李卫
 * 编写日期： 2019年10月20日下午3:34:22
 * 版本：1.0
 */
@WebServlet("/FiscalRevenueServlet")
public class FiscalRevenueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FiscalRevenueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		PrintWriter out=response.getWriter();
		//获取来自请中所传递过来的收入表id编号字符串
		String frIdStr=request.getParameter("frIdStr");
		//将字符串进行按","(逗号)分割的子字符串数组
		String[] frIds=frIdStr.split(",");
		
		//创建数据层操作对象
		FiscalRevenueDao FiscalRevenueDao=new FiscalRevenueDaoImpl();
		
		//由于是批量删除，有可能失败，此处使用异常处理来实现
		try{
			//使用循环进行批量删除
			for(int i=0;i<frIds.length;i++){
				//获取当前子字符串
				String tfrId=frIds[i];
				//将字符串编号转换为整型的收入表id
				int frId=Integer.parseInt(tfrId);
				//执行删除操作
				FiscalRevenueDao.deleteById(frId);
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
	 */
	private void update(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		PrintWriter out=response.getWriter();
		
		//接收来自客户端的数据
		//接收财务表收入id
		int frId=Integer.parseInt(request.getParameter("frId"));
		//接收订单id
		int soId=Integer.parseInt(request.getParameter("soId"));
		//接收操作时间
		String frTime=request.getParameter("frTime");
		//接收收入金额
		double frMoney=Double.parseDouble(request.getParameter("frMoney"));
		
		//数据封装成对象
		FiscalRevenue FiscalRevenue=new FiscalRevenue(frId,soId,frTime,frMoney);
		
		//调用数据层对象执行添加方法
		FiscalRevenueDao FiscalRevenueDao=new FiscalRevenueDaoImpl();
		int rows=FiscalRevenueDao.update(FiscalRevenue);
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
	 */
	private void add(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		PrintWriter out=response.getWriter();
		//接收来自客户端的数据
		System.out.println("frId");
		//接收订单表id
		int soId=Integer.parseInt(request.getParameter("soId"));
		//接收操作时间
		String frTime=request.getParameter("frTime");
		//接收收入金额
		double frMoney=Double.parseDouble(request.getParameter("frMoney"));
		
		//数据封装成对象
		FiscalRevenue fiscalRevenue=new FiscalRevenue(soId, frTime,frMoney);
		
		//调用数据层对象执行添加方法
		FiscalRevenueDao FiscalRevenueDao=new FiscalRevenueDaoImpl();
		int rows=FiscalRevenueDao.add(fiscalRevenue);
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
	 */
	private void findAll(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		PrintWriter out=response.getWriter();
		//接收来自请求中的数据
		//接收财务收入表id
		String frId=request.getParameter("frId");
		//接收订单id
		String soId=request.getParameter("soId");
		
		//生成查询条件
		//select * from 表名 where 条件 limit n1,n2 
		//where 字段名=? and 字段名=? and 字段名=?
		String condition=" where 1=1 ";
		//对条件数据进行判断并组合成查询条件
		if(frId!=null && !frId.equals("")){
			int frId1=Integer.parseInt(frId);
			condition=condition+" and frId like '%"+frId1+"%' ";
		}
		//根据工种字段值进行判断，生成条件
		if(soId!=null && !soId.equals("")){
			int soId1=Integer.parseInt(soId);
			condition=condition+" and soId like '%"+soId1+"%' ";
		}
		
		System.out.println("condition="+condition);
		
		//接收来自客户端的datagrid组件传递过来的page和rows参数
		int rows =Integer.parseInt(request.getParameter("rows"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		//调用数据层进行分页查询
		FiscalRevenueDao fiscalRevenueDao = new FiscalRevenueDaoImpl();
		//获取当前页的数据集合
		List<FiscalRevenue> fiscalRevenueList = fiscalRevenueDao.findByPage(rows, page,condition);
		//查询出FiscalRevenue表中的总记录数
		int totalRows = fiscalRevenueDao.count(condition);
		
		//定义映射集合对象
		Map<String, Object> mapData = new HashMap<String, Object>();
		mapData.put("total",totalRows);
		mapData.put("rows", fiscalRevenueList);
		
		//定义Gson对象
		Gson gson = new Gson();
		//通过Gson对象将Map集合转换成json数据格式
		String jsonData = gson.toJson(mapData);
		//将json数据输出到客户端
		out.println(jsonData);
		//System.out.println(jsonData);
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
