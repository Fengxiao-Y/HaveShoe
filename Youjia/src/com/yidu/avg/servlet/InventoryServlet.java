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
import com.yidu.avg.dao.InventoryDao;
import com.yidu.avg.dao.impl.InventoryDaoImpl;
import com.yidu.avg.domain.Inventory;

/**
 * 
 * 功能：server
 * @author d280 avenger组 王翌
 * 编写日期： 2019年10月19日下午16:44:46
 * 版本：1.0
 */
@WebServlet("/InventoryServlet")
public class InventoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InventoryServlet() {
        super();
       
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
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		//获取来自请中所传递过来的员工编号字符串
		String itIdStr=request.getParameter("itIdStr");
		//将字符串进行按","(逗号)分割的子字符串数组
		String[] itIds=itIdStr.split(",");
		
		//创建数据层操作对象
		InventoryDao inventoryDao=new InventoryDaoImpl();
		
		//由于是批量删除，有可能失败，此处使用异常处理来实现
		try{
			//使用循环进行批量删除
			for(int i=0;i<itIds.length;i++){
				//获取当前子字符串
				String titId=itIds[i];
				//将字符串编号转换为整型的员工编号
				int itId=Integer.parseInt(titId);
				//执行删除操作
				inventoryDao.delete(itId);
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
	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		
		//接收来自客户端的数据
		//接收库存表的库存id
		int itId=Integer.parseInt(request.getParameter("itId"));
		//接收库存表的库存数量
		int itNumber=Integer.parseInt(request.getParameter("itNumber"));
		//接收库存表的商品种类
		int ctId=Integer.parseInt(request.getParameter("ctId"));
		
		//数据封装成对象
		Inventory inventory=new Inventory(itId, itNumber, ctId);
		
		//调用数据层对象执行添加方法
		InventoryDao inventoryDao=new InventoryDaoImpl();
		//定义一个返回值变量接收修改方法从数据库返回的值
		int rows=inventoryDao.update(inventory);
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
	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		//接收来自客户端的数据
		//接收库存表的库存数量
		int itNumber=Integer.parseInt(request.getParameter("itNumber"));
		//接收库存表的商品种类
		int ctId=Integer.parseInt(request.getParameter("ctId"));
		
		
		//数据封装成对象
		Inventory inventory=new Inventory(itNumber, ctId);
		//调用数据层对象执行添加方法
		InventoryDao inventoryDao=new InventoryDaoImpl();
		//定义一个返回值变量接收添加方法从数据库返回的值
		int rows=inventoryDao.add(inventory);
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
	private void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		
		//得到来自请求中的条件数据
		//接收库存表的库存数量
		String itNumber=request.getParameter("itNumber");
		
		//生成查询条件
		//select * from 表名 where 条件 limit n1,n2 
		//where 字段名=? and 字段名=? and 字段名=?
		String condition=" where 1=1 ";
		//对条件数据进行判断并组合成查询条
		if(itNumber!=null && !itNumber.equals("")){
			condition=condition+" and itNumber like '%"+itNumber+"%' ";
		}
		
		//接收来自客户端的datagrid组件的传递过来的page和rows参数
		int rows=Integer.parseInt(request.getParameter("rows"));
		int page=Integer.parseInt(request.getParameter("page"));
		
		//调用数据层执行分页查询
		InventoryDao inventoryDao=new InventoryDaoImpl();
		//获得当前页的数据集合
		List<Inventory> inventoryList=inventoryDao.findByPage(rows, page,condition);
		//查询出inventory表的总记录数
		int totalRows=inventoryDao.count(condition);

		//B:方式
		//定义映射集合对象
		Map<String, Object> mapData = new HashMap<String, Object>();
		mapData.put("total", totalRows);
		mapData.put("rows", inventoryList);
		//定义Gson对象
		Gson gson = new Gson();
		//通过Gson对象将Map集合转换成json数据格式
		String jsonData = gson.toJson(mapData);
		//将json数据输出到客户端
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
