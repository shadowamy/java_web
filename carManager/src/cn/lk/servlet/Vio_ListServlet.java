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
        //得到传过来的当前页
        String str_page=    request.getParameter("page");
        
		try {
			List<violationData> list = cv.findAll();
			
			Paging paging=new Paging();
	        paging.setList(list);//从数据库得到数据存入的list集合
	        paging.setCount();//数据总数
	        paging.setPagesize(5);//一个页面的数据多少条
	        paging.setPagenumber();//总的页面数
	        paging.setEndpage();//最后一页
	        paging.setIndexpage(1);//第一页
	        if (str_page!=null) {
	            //将页转换整型判断其大小
	            int pag=Integer.parseInt(str_page);
	            //当大于零，将传过来的pag值赋给当前页page
	            if (pag>=0) {
	                page=pag;
	                //如果小于最大值时则，将其传过来的值减1在赋值给当前页，让其一直在最后一页
	                if (pag>(paging.getPagenumber()-1)) {
	                    page=pag-1;
	                }
	            }
	        }
	        
	        paging.setPage(page);//最终确认当前页
	        List<violationData> list_page =new ArrayList<>();
	        //将当前页的值传给新的list_page集合中，list集合是全部数据综合，用i调用其中的几条数据给list_page
	        for (int i = paging.getPage()*paging.getPagesize(); i <(paging.getPage()+1)*paging.getPagesize()&&i<list.size(); i++) {
	            list_page.add(list.get(i));
	        }
	        //将paging对象其设置在作用域中，以便后面页面调用
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
