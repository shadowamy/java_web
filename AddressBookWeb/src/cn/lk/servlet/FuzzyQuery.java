package cn.lk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.lk.dao.CallContactMsg;
import cn.lk.entity.ContactMsg;

/**
 * Servlet implementation class FuzzyQuery
 */
public class FuzzyQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FuzzyQuery() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		response.setContentType("text/heml;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String result = "";
		
		request.setCharacterEncoding("utf-8");
		String BelongUser = request.getParameter("BelongUser");
		String EnterStr = request.getParameter("EnterStr");
		
		List<ContactMsg> list = null;
		list = CallContactMsg.fuzzyQuery(BelongUser, EnterStr);
		
		result = JSON.toJSONString(list);
		
		out.write(result);
		out.flush();
		out.close();
		
		System.out.println(result);
		
	}

}
