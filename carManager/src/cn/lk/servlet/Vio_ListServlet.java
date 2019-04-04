package cn.lk.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lk.bean.call_violationDataDB;
import cn.lvb.bao.Paging;
import cn.lvb.bao.violationData;

/**
 * Servlet implementation class Vio_ListServlet
 */
public class Vio_ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vio_ListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		violationData vd = new violationData();
		
		call_violationDataDB cv = new call_violationDataDB();
		
		int page=0;
        //�õ��������ĵ�ǰҳ
        String str_page=    request.getParameter("page");
        
		try {
			List<violationData> list = cv.findAll();
			
			Paging paging=new Paging();
	        paging.setList(list);//�����ݿ�õ����ݴ����list����
	        paging.setCount();//��������
	        paging.setPagesize(5);//һ��ҳ������ݶ�����
	        paging.setPagenumber();//�ܵ�ҳ����
	        paging.setEndpage();//���һҳ
	        paging.setIndexpage(1);//��һҳ
	        if (str_page!=null) {
	            //��ҳת�������ж����С
	            int pag=Integer.parseInt(str_page);
	            //�������㣬����������pagֵ������ǰҳpage
	            if (pag>=0) {
	                page=pag;
	                //���С�����ֵʱ�򣬽��䴫������ֵ��1�ڸ�ֵ����ǰҳ������һֱ�����һҳ
	                if (pag>(paging.getPagenumber()-1)) {
	                    page=pag-1;
	                }
	            }
	        }
	        
	        paging.setPage(page);//����ȷ�ϵ�ǰҳ
	        List<violationData> list_page =new ArrayList<>();
	        //����ǰҳ��ֵ�����µ�list_page�����У�list������ȫ�������ۺϣ���i�������еļ������ݸ�list_page
	        for (int i = paging.getPage()*paging.getPagesize(); i <(paging.getPage()+1)*paging.getPagesize()&&i<list.size(); i++) {
	            list_page.add(list.get(i));
	        }
	        //��paging�������������������У��Ա����ҳ�����
	        request.setAttribute("paging", paging);
	        request.setAttribute("list", list_page);
	        request.getRequestDispatcher("/carManager/").forward(request, response);
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
