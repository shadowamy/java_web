package cn.lk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lk.bean.call_userDataDB;
import cn.lvb.bao.userData;

/**
 * Servlet implementation class registerAjax
 */
public class registerAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/heml;charset=utf-8");
		PrintWriter out = response.getWriter();
		String result = null;

		String username = request.getParameter("username");
		
		call_userDataDB calu = new call_userDataDB();
		try {
			
			userData ud = calu.findByUsername(username);
			if(ud != null)
			{
				result = "<font color = 'red'>用户名已经存在</font>";
			}
			else
			{
				result = "<font color = 'green'>用户名可以使用</font>";
			}
			
			out.print(result);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
