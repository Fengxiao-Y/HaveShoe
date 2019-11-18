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
import com.yidu.avg.dao.InventoryDao;
import com.yidu.avg.dao.ProinDao;
import com.yidu.avg.dao.PurchaseOrderDao;
import com.yidu.avg.dao.impl.FiscalExpendDaoImpl;
import com.yidu.avg.dao.impl.InventoryDaoImpl;
import com.yidu.avg.dao.impl.ProinDaoImpl;
import com.yidu.avg.dao.impl.PurchaseOrderDaoImpl;
import com.yidu.avg.domain.FiscalExpend;
import com.yidu.avg.domain.Inventory;
import com.yidu.avg.domain.Proin;
import com.yidu.avg.domain.PurchaseOrder;

/**
 * 
 * 功能：server
 * @author d280 avenger组 邓威
 * 编写日期： 2019年10月24日下午19:12:46
 * 版本：1.0
 */
@WebServlet("/PurchaseOrderServlet")
public class PurchaseOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchaseOrderServlet() {
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
		System.out.println("method:"+method);
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
		//获取来自请中所传递过来的物品状态id字符串
		String poIdStr=request.getParameter("poIdStr");
		//将字符串进行按","(逗号)分割的子字符串数组
		String[] poIds=poIdStr.split(",");
		
		//创建数据层操作对象
		PurchaseOrderDao purchaseOrderDao=new PurchaseOrderDaoImpl();
		
		//由于是批量删除，有可能失败，此处使用异常处理来实现
		try{
			//使用循环进行批量删除
			for(int i=0;i<poIds.length;i++){
				//获取当前子字符串
				String tpoId=poIds[i];
				//将字符串编号转换为整型的员工编号
				int poId=Integer.parseInt(tpoId);
				//执行删除操作
				purchaseOrderDao.delete(poId);
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
		int poId=Integer.parseInt(request.getParameter("poId"));
		int marId=Integer.parseInt(request.getParameter("marId"));
		String poName=request.getParameter("poName");
		String poTime=request.getParameter("poTime");
		int spId=Integer.parseInt(request.getParameter("spId"));
		int poCounts=Integer.parseInt(request.getParameter("poCounts"));
		double poPrice=Double.parseDouble(request.getParameter("poPrice"));
		
		//数据封装成对象
		PurchaseOrder purchaseOrder=new PurchaseOrder(poId, marId, poName, poTime, spId, poCounts, poPrice);
		
		//调用数据层对象执行添加方法
		PurchaseOrderDao purchaseOrderDao=new PurchaseOrderDaoImpl();
		int rows=purchaseOrderDao.update(purchaseOrder);
		//判断添加是否成功
		if(rows>0){
			out.print("success");
		}else{
			out.print("failure");
		}
		
		out.close();
		
	}
	/**
	 * 增加
	 * @param request 请求对象
	 * @param response 响应对象
	 * @throws IOException IO异常
	 */
	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		//接收来自客户端的数据
		//int poId=Integer.parseInt(request.getParameter("poId"));
		int marId=Integer.parseInt(request.getParameter("marId"));
		String poName=request.getParameter("poName");
		String poTime=request.getParameter("poTime");
		int spId=Integer.parseInt(request.getParameter("spId"));
		int poCounts=Integer.parseInt(request.getParameter("poCounts"));
		double poPrice=Double.parseDouble(request.getParameter("poPrice"));
		int itId=Integer.parseInt(request.getParameter("itId"));

		//数据封装成对象
		PurchaseOrder purchaseOrder=new PurchaseOrder(marId, poName, poTime, spId, poCounts, poPrice);
		//调用数据层对象执行添加方法
		PurchaseOrderDao purchaseOrderDao=new PurchaseOrderDaoImpl();
		
		int rows=purchaseOrderDao.add(purchaseOrder);
		//判断添加是否成功
		if(rows>0){
			//根据数量和单价得到支出的总价
			double purchaseprice=poCounts*poPrice;
			//添加成功,调用支出表的方法
			FiscalExpend fed=new FiscalExpend(rows, poTime, 1,purchaseprice);
			//调用ADD方法给支出表增加一条记录
			FiscalExpendDao feDao=new FiscalExpendDaoImpl();
			//添加数据
			feDao.add(fed);
			//封装数据
			Proin pp=new Proin(poTime, rows, poCounts, marId, itId);
			//调用入库表的方法
			ProinDao ppDao=new ProinDaoImpl();
			//调用add方法添加
			ppDao.add(pp);
			//调用库存表的数据层方法
			InventoryDao invendao = new InventoryDaoImpl();
			//找到库存的里的数量
			int tt=invendao.findcountById(itId);
			int dd=tt+poCounts;
			//调用ADD方法将数据添加到库层表中
			invendao.updateinNumber(dd,itId);	
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
		String poName=request.getParameter("poName");
		String poTime=request.getParameter("poTime");
		
		//生成查询条件
		String condition=" where 1=1 ";
		//对条件数据进行判断并组合成查询条件
		if(poName!=null && !poName.equals("")){
			condition=condition+" and poName like '%"+poName+"%' ";
		}
		//根据购买时间字段值进行判断，生成条件
		if(poTime!=null && !poTime.equals("")){
			condition=condition+" and poTime like '%"+poTime+"%' ";
		}
		
		//接收来自客户端的datagrid组件的传递过来的page和rows参数
		int rows=Integer.parseInt(request.getParameter("rows"));
		int page=Integer.parseInt(request.getParameter("page"));
		
		//调用数据层执行分页查询
		PurchaseOrderDao purchaseOrderDao=new PurchaseOrderDaoImpl();
		//获得当前页的数据集合
		List<PurchaseOrder> purchaseOrderList=purchaseOrderDao.findByPage(rows, page, condition);
		//查询出purchaseOrder表的总记录数
		int totalRows=purchaseOrderDao.count(condition);
		//定义映射集合对象
		Map<String, Object> mapData = new HashMap<String, Object>();
		mapData.put("total", totalRows);
		mapData.put("rows", purchaseOrderList);
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
