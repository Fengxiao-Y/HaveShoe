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
 * ���ܣ�server
 * @author d280 avenger�� ����
 * ��д���ڣ� 2019��10��20������2:22:46
 * �汾��1.0
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
		 // A:�����������Ӧ���ַ�������������
        // ����������ַ���
		request.setCharacterEncoding("utf-8");
		// ������Ӧ������ַ���
		response.setContentType("text/html");
		// ������Ӧ����������
		response.setCharacterEncoding("utf-8");
		
		// ��ȡ����·���еĲ�������ֵ
		String method=request.getParameter("method");
		// �ж�:
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
	 * @throws ServletException Servlet�쳣
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		//��ȡ�������������ݹ�����Ա������ַ���
		String feIdStr=request.getParameter("feIdStr");
		//���ַ������а�","(����)�ָ�����ַ�������
		String[] feIds=feIdStr.split(",");
		
		//�������ݲ��������
		FiscalExpendDao fiscalExpendDao=new FiscalExpendDaoImpl();

		//����������ɾ�����п���ʧ�ܣ��˴�ʹ���쳣������ʵ��
		try{
			//ʹ��ѭ����������ɾ��
			for(int i=0;i<feIds.length;i++){
				//��ȡ��ǰ���ַ���
				String tfeId=feIds[i];
				//���ַ������ת��Ϊ���͵�Ա�����
				int feId=Integer.parseInt(tfeId);
				//ִ��ɾ������
				fiscalExpendDao.deleteById(feId);
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
	 * @throws ServletException Servlet�쳣
	 */
	private void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		//�������Կͻ��˵�����
		//���ղ���֧����Id
		int feId=Integer.parseInt(request.getParameter("feId"));
		//���ղɹ�id
		int poId=Integer.parseInt(request.getParameter("poId"));
		//���ղ���ʱ��
		String feTime=request.getParameter("feTime");
		//����Ա��id
		int empId=Integer.parseInt(request.getParameter("empId"));
		//����֧�����
		double feMoney =Double.parseDouble(request.getParameter("feMoney"));
		
		//���ݷ�װ�ɶ���
		FiscalExpend fiscalExpend= new FiscalExpend(feId, poId, feTime, empId,feMoney);
		
		//�������ݲ����ִ����ӷ���
		FiscalExpendDao fiscalExpendDao=new FiscalExpendDaoImpl();
		int rows=fiscalExpendDao.update(fiscalExpend);
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
	 * @throws ServletException Servlet�쳣
	 */
	private void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		//�������Կͻ��˵�����
		//���ղɹ�Id
		int poId=Integer.parseInt(request.getParameter("poId"));
		//���ղ���ʱ��
		String feTime=request.getParameter("feTime");
		System.out.println("shijian:"+feTime);
		//����Ա��id
		int empId=Integer.parseInt(request.getParameter("empId"));
		//����֧�����
		double feMoney =Double.parseDouble(request.getParameter("feMoney"));
		
		//���ݷ�װ�ɶ���
		FiscalExpend fiscalExpend= new FiscalExpend(poId, feTime, empId,feMoney);
		//�������ݲ����ִ����ӷ���
		FiscalExpendDao fiscalExpendDao=new FiscalExpendDaoImpl();
		int rows=fiscalExpendDao.add(fiscalExpend);
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
	 * @throws ServletException Servlet�쳣
	 */
	private void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		//�õ����������еĲ���֧����Id����
		String feId=request.getParameter("feId");
	
		
		//���ɲ�ѯ����
		//select * from ���� where ���� limit n1,n2 
		//where �ֶ���=? and �ֶ���=? and �ֶ���=?
		String condition=" where 1=1 ";
		//���������ݽ����жϲ���ϳɲ�ѯ����
		if(feId!=null && !feId.equals("")){
			condition=condition+" and feId like '%"+feId+"%' ";
		}
		
		
		
		//�������Կͻ��˵�datagrid����Ĵ��ݹ�����page��rows����
		int rows=Integer.parseInt(request.getParameter("rows"));
		int page=Integer.parseInt(request.getParameter("page"));
		
		//�������ݲ�ִ�з�ҳ��ѯ
		FiscalExpendDao fiscalExpendDao=new FiscalExpendDaoImpl();
		//��õ�ǰҳ�����ݼ���
		List<FiscalExpend> fiscalExpendList=fiscalExpendDao.findByPage(rows, page);
		//��ѯ��FiscalExpend����ܼ�¼��
		int totalRows=fiscalExpendDao.count();

		//B:��ʽ
		//����ӳ�伯�϶���
		Map<String, Object> mapData = new HashMap<String, Object>();
		mapData.put("total", totalRows);
		mapData.put("rows", fiscalExpendList);
		//����Gson����
		Gson gson = new Gson();
		//ͨ��Gson����Map����ת����json���ݸ�ʽ
		String jsonData = gson.toJson(mapData);
		//��json����������ͻ���
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
