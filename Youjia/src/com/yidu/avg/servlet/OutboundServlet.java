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
import com.yidu.avg.dao.OutboundDao;
import com.yidu.avg.dao.impl.OutboundDaoImpl;
import com.yidu.avg.domain.Outbound;

/**
 * 
 * 功能：servlet
 * @author d280 avenger组 王翌
 * 编写日期： 2019年10月20日下午5:23:27
 * 版本：1.0
 */
@WebServlet("/OutboundServlet")
public class OutboundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OutboundServlet() {
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
		String obIdStr=request.getParameter("obIdStr");
		//将字符串进行按","(逗号)分割的子字符串数组
		String[] obIds=obIdStr.split(",");
		
		//创建数据层操作对象
		OutboundDao outboundDao=new OutboundDaoImpl();
		
		//由于是批量删除，有可能失败，此处使用异常处理来实现
		try{
			//使用循环进行批量删除
			for(int i=0;i<obIds.length;i++){
				//获取当前子字符串
				String tobId=obIds[i];
				//将字符串编号转换为整型的员工编号
				int obId=Integer.parseInt(tobId);
				//执行删除操作
				outboundDao.delete(obId);
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
		//接收出库表的id
		int obId=Integer.parseInt(request.getParameter("obId"));
		//接收出库表的时间
		String obTime=request.getParameter("obTime");
		//接收出库表的订单id
		int soId=Integer.parseInt(request.getParameter("soId"));
		//接收出库表的库存数量
		int odNumber=Integer.parseInt(request.getParameter("odNumber"));
		//接收出库表的商品类型id
		int marId=Integer.parseInt(request.getParameter("marId"));
		//接收出库表的库存id
		int itId=Integer.parseInt(request.getParameter("itId"));
		
		//数据封装成对象(把接收的数据保存到实体类)
		Outbound outbound=new Outbound(obId, obTime, soId, odNumber, marId, itId);
		
		//调用数据层对象执行添加方法
		OutboundDao outboundDao=new OutboundDaoImpl();
		//定义一个返回值变量接收修改方法从数据库返回的值
		int rows=outboundDao.update(outbound);
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
		//接收出库表的时间
		String obTime=request.getParameter("obTime");
		//接收出库表的订单id
		int soId=Integer.parseInt(request.getParameter("soId"));
		//接收出库表的库存数量
		int odNumber=Integer.parseInt(request.getParameter("odNumber"));
		//接收出库表的商品类型id
		int marId=Integer.parseInt(request.getParameter("marId"));
		//接收出库表的库存id
		int itId=Integer.parseInt(request.getParameter("itId"));;
		
		
		
		//数据封装成对象
		Outbound outbound = new Outbound(obTime, soId, odNumber, marId, itId);
		//调用数据层对象执行添加方法
		OutboundDao outboundDao = new OutboundDaoImpl();
		//定义一个返回值变量接收添加方法从数据库返回的值
		int rows=outboundDao.add(outbound);
		//判断添加是否成功
		if(rows>0){
			out.print("susses");
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
		//接收出库表的时间
		String obTime=request.getParameter("obTime");
		
		//生成查询条件
		//select * from 表名 where 条件 limit n1,n2 
		//where 字段名=? and 字段名=? and 字段名=?
		String condition=" where 1=1 ";
		//对条件数据进行判断并组合成查询条件(如果时间为不为空)
		if(obTime!=null && !obTime.equals("")){
			condition=condition+" and obTime like '%"+obTime+"%' ";
		}
		
		//接收来自客户端的datagrid组件的传递过来的page和rows参数
		int rows=Integer.parseInt(request.getParameter("rows"));
		int page=Integer.parseInt(request.getParameter("page"));
		
		//调用数据层执行分页查询
		OutboundDao outboundDao=new OutboundDaoImpl();
		//获得当前页的数据集合
		List<Outbound> outboundList=outboundDao.findByPage(rows, page,condition);
		//查询出Outbound表的总记录数
		int totalRows=outboundDao.count(condition);

		//B:方式
		//定义映射集合对象
		Map<String, Object> mapData = new HashMap<String, Object>();
		mapData.put("total", totalRows);
		mapData.put("rows", outboundList);
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
