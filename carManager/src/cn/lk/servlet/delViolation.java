package cn.lk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.lk.bean.call_violationDataDB;
import cn.lvb.bao.violationData;

/**
 * Servlet implementation class delViolation
 */
public class delViolation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delViolation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/heml;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String delID = request.getParameter("delID");
		//out.print(Integer.parseInt(delID));
		
		call_violationDataDB cv = new call_violationDataDB();
		try {
			cv.delByVioID(Integer.parseInt(delID));
			
			HttpSession session = request.getSession();
			
			List<violationData> allVio = cv.findAll();
			session.setAttribute("allviolation", allVio);
			
			//out.print("del succ");
			response.sendRedirect("/carManager/Main/content/adminVio.jsp?delmessage=success");
			
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
