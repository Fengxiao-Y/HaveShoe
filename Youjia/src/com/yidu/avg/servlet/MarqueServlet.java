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
import com.yidu.avg.dao.CommodityTypeDao;
import com.yidu.avg.dao.MarqueDao;
import com.yidu.avg.dao.impl.MarqueDaoImpl;
import com.yidu.avg.domain.Marque;


/**
 * 
 * 功能：servlet
 * @author d280 avenger组 罗煜霖
 * 编写日期： 2019年10月21日下午4:23:34
 * 版本：1.0
 */
@WebServlet("/MarqueServlet")
public class MarqueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String condition;
	private PrintWriter out;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MarqueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		
		String method=request.getParameter("method");
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
		//获取来自请中所传递过来的员工编号字符串
		String marIdStr=request.getParameter("marIdStr");
		//将字符串进行按","(逗号)分割的子字符串数组
		String[] marIds=marIdStr.split(",");
		
		//创建数据层操作对象
		MarqueDao marqueDao=new MarqueDaoImpl();
		
		//由于是批量删除，有可能失败，此处使用异常处理来实现
		try{
			//使用循环进行批量删除
			for(int i=0;i<marIds.length;i++){
				//获取当前子字符串
				String tmarId=marIds[i];
				//将字符串编号转换为整型的员工编号
				int marId=Integer.parseInt(tmarId);
				//执行删除操作
				marqueDao.deleteById(marId);
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
		int marId=Integer.parseInt(request.getParameter("marId"));
		String marName=request.getParameter("marName");
		int marYardage=Integer.parseInt(request.getParameter("marYardage"));
		String marIntroduce=request.getParameter("marIntroduce");
		String marUrl=request.getParameter("marUrl");
		double marPrice=Double.parseDouble(request.getParameter("marPrice"));
		double marConvert=Double.parseDouble(request.getParameter("marConvert"));
		int ctId=Integer.parseInt(request.getParameter("ctId"));
		
		//数据封装成对象
		Marque marque=new Marque(marId, marName, marYardage, marIntroduce, marUrl, marPrice, marConvert, ctId);
		
		//调用数据层对象执行添加方法
		MarqueDao marqueDao=new MarqueDaoImpl();
		int rows=marqueDao.update(marque);
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
		//int marId=Integer.parseInt(request.getParameter("marId"));
		String marName=request.getParameter("marName");
		int marYardage=Integer.parseInt(request.getParameter("marYardage"));
		String marIntroduce=request.getParameter("marIntroduce");
		String marUrl=request.getParameter("marUrl");
		double marPrice=Double.parseDouble(request.getParameter("marPrice"));
		double marConvert=Double.parseDouble(request.getParameter("marConvert"));
		int ctId=Integer.parseInt(request.getParameter("ctId"));
		
		
		//数据封装成对象
		Marque marque=new Marque(marName, marYardage, marIntroduce, marUrl, marPrice, marConvert, ctId);
		//调用数据层对象执行添加方法
		MarqueDao marqueDao=new MarqueDaoImpl();
		int rows=marqueDao.add(marque);
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
		String marName=request.getParameter("marName");
		String marYardage=request.getParameter("marYardage");
		String marConvert=request.getParameter("marConvert");
		
		//生成查询条件
		//select * from 表名 where 条件 limit n1,n2 
		//where 字段名=? and 字段名=? and 字段名=?
		String condition=" where 1=1 ";
		//对条件数据进行判断并组合成查询条件
		if(marName!=null && !marName.equals("")){
			condition=condition+" and marName like '%"+marName+"%' ";
		}
		//根据工种字段值进行判断，生成条件
		if(marYardage!=null && !marYardage.equals("")){
			condition=condition+" and marYardage like '%"+marYardage+"%' ";
		}
		
		if(marConvert!=null && !marConvert.equals("")){
			//由于deptno是int类型，首先转换类型
			int dept=Integer.parseInt(marConvert);
			//添加到条件中
			condition=condition+" and deptno="+dept+" ";
		}
		
		System.out.println("condition="+condition);
		//接收来自客户端的datagrid组件的传递过来的page和rows参数
		int rows=Integer.parseInt(request.getParameter("rows"));
		int page=Integer.parseInt(request.getParameter("page"));
		
		//调用数据层执行分页查询
		MarqueDao marqueDao=new MarqueDaoImpl();
		//获得当前页的数据集合
		List<Marque> marqueList=marqueDao.findByPage(rows, page,condition);
		//查询出emp表的总记录数
		int totalRows=marqueDao.count(condition);

		//B:方式
		//定义映射集合对象
		Map<String, Object> mapData = new HashMap<String, Object>();
		mapData.put("total", totalRows);
		mapData.put("rows", marqueList);
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
