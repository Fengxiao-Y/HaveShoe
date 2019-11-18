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
 * ���ܣ�servlet
 * @author d280 avenger�� ������
 * ��д���ڣ� 2019��10��21������4:23:34
 * �汾��1.0
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
	 * ɾ��
	 * @param request �������
	 * @param response ��Ӧ����
	 * @throws IOException IO�쳣
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		PrintWriter out=response.getWriter();
		//��ȡ�������������ݹ�����Ա������ַ���
		String marIdStr=request.getParameter("marIdStr");
		//���ַ������а�","(����)�ָ�����ַ�������
		String[] marIds=marIdStr.split(",");
		
		//�������ݲ��������
		MarqueDao marqueDao=new MarqueDaoImpl();
		
		//����������ɾ�����п���ʧ�ܣ��˴�ʹ���쳣������ʵ��
		try{
			//ʹ��ѭ����������ɾ��
			for(int i=0;i<marIds.length;i++){
				//��ȡ��ǰ���ַ���
				String tmarId=marIds[i];
				//���ַ������ת��Ϊ���͵�Ա�����
				int marId=Integer.parseInt(tmarId);
				//ִ��ɾ������
				marqueDao.deleteById(marId);
			}
			out.print("success");
		}catch(Exception e){
			out.print("failure");
		}
		
		//�ر��������
		out.close();
	}

	/**
	 * �޸�
	 * @param request �������
	 * @param response ��Ӧ����
	 * @throws IOException IO�쳣
	 */
	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
      PrintWriter out=response.getWriter();
		
		//�������Կͻ��˵�����
		int marId=Integer.parseInt(request.getParameter("marId"));
		String marName=request.getParameter("marName");
		int marYardage=Integer.parseInt(request.getParameter("marYardage"));
		String marIntroduce=request.getParameter("marIntroduce");
		String marUrl=request.getParameter("marUrl");
		double marPrice=Double.parseDouble(request.getParameter("marPrice"));
		double marConvert=Double.parseDouble(request.getParameter("marConvert"));
		int ctId=Integer.parseInt(request.getParameter("ctId"));
		
		//���ݷ�װ�ɶ���
		Marque marque=new Marque(marId, marName, marYardage, marIntroduce, marUrl, marPrice, marConvert, ctId);
		
		//�������ݲ����ִ����ӷ���
		MarqueDao marqueDao=new MarqueDaoImpl();
		int rows=marqueDao.update(marque);
		//�ж�����Ƿ�ɹ�
		if(rows>0){
			out.print("success");
		}else{
			out.print("failure");
		}
		
		out.close();
	}

	/**
	 * ���
	 * @param request �������
	 * @param response ��Ӧ����
	 * @throws IOException IO�쳣
	 */
	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		//�������Կͻ��˵�����
		//int marId=Integer.parseInt(request.getParameter("marId"));
		String marName=request.getParameter("marName");
		int marYardage=Integer.parseInt(request.getParameter("marYardage"));
		String marIntroduce=request.getParameter("marIntroduce");
		String marUrl=request.getParameter("marUrl");
		double marPrice=Double.parseDouble(request.getParameter("marPrice"));
		double marConvert=Double.parseDouble(request.getParameter("marConvert"));
		int ctId=Integer.parseInt(request.getParameter("ctId"));
		
		
		//���ݷ�װ�ɶ���
		Marque marque=new Marque(marName, marYardage, marIntroduce, marUrl, marPrice, marConvert, ctId);
		//�������ݲ����ִ����ӷ���
		MarqueDao marqueDao=new MarqueDaoImpl();
		int rows=marqueDao.add(marque);
		//�ж�����Ƿ�ɹ�
		if(rows>0){
			out.print("success");
		}else{
			out.print("failure");
		}
		
		out.close();
		}

	/**
	 * ������ѯ
	 * @param request �������
	 * @param response ��Ӧ����
	 * @throws IOException IO�쳣
	 */
	private void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
      PrintWriter out=response.getWriter();
		
		//�õ����������е���������
		String marName=request.getParameter("marName");
		String marYardage=request.getParameter("marYardage");
		String marConvert=request.getParameter("marConvert");
		
		//���ɲ�ѯ����
		//select * from ���� where ���� limit n1,n2 
		//where �ֶ���=? and �ֶ���=? and �ֶ���=?
		String condition=" where 1=1 ";
		//���������ݽ����жϲ���ϳɲ�ѯ����
		if(marName!=null && !marName.equals("")){
			condition=condition+" and marName like '%"+marName+"%' ";
		}
		//���ݹ����ֶ�ֵ�����жϣ���������
		if(marYardage!=null && !marYardage.equals("")){
			condition=condition+" and marYardage like '%"+marYardage+"%' ";
		}
		
		if(marConvert!=null && !marConvert.equals("")){
			//����deptno��int���ͣ�����ת������
			int dept=Integer.parseInt(marConvert);
			//��ӵ�������
			condition=condition+" and deptno="+dept+" ";
		}
		
		System.out.println("condition="+condition);
		//�������Կͻ��˵�datagrid����Ĵ��ݹ�����page��rows����
		int rows=Integer.parseInt(request.getParameter("rows"));
		int page=Integer.parseInt(request.getParameter("page"));
		
		//�������ݲ�ִ�з�ҳ��ѯ
		MarqueDao marqueDao=new MarqueDaoImpl();
		//��õ�ǰҳ�����ݼ���
		List<Marque> marqueList=marqueDao.findByPage(rows, page,condition);
		//��ѯ��emp����ܼ�¼��
		int totalRows=marqueDao.count(condition);

		//B:��ʽ
		//����ӳ�伯�϶���
		Map<String, Object> mapData = new HashMap<String, Object>();
		mapData.put("total", totalRows);
		mapData.put("rows", marqueList);
		//����Gson����
		Gson gson = new Gson();
		//ͨ��Gson����Map����ת����json���ݸ�ʽ
		String jsonData = gson.toJson(mapData);
		//��json����������ͻ���
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
