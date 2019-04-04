package cn.lk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.lk.bean.call_violationDataDB;
import cn.lvb.bao.violationData;

/**
 * Servlet implementation class updateViolation
 */
public class updateViolation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateViolation() {
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
		
		String vioid_str = request.getParameter("updateID");
		
		String idNumber = request.getParameter("idNumber");
		String Penalty_str = request.getParameter("Penalty");
		String carNumber = request.getParameter("carNumber");
		String vioScore_str = request.getParameter("vioScore");
		String vioTime_str = request.getParameter("vioTime");
		String vioStatus = request.getParameter("vioStatus");
		String vioContent = request.getParameter("vioContent");
		
		/*out.print(vioid+"\n");
		out.print(idNumber+"\n");
		out.print(Penalty_str+"\n");
		out.print(carNumber+"\n");
		out.print(vioScore_str+"\n");
		out.print(vioTime_str+"\n");
		out.print(vioStatus+"\n");
		out.print(vioContent+"\n");*/
		
		int vioid = Integer.parseInt(vioid_str);
		double Penalty = Double.parseDouble(Penalty_str);
		int vioScore = Integer.parseInt(vioScore_str);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			Date vioTime = sdf.parse(vioTime_str);
			call_violationDataDB cv = new call_violationDataDB();
			try {
				cv.update_All(vioid, carNumber, vioTime, vioContent, Penalty, vioScore, vioStatus, idNumber);
				
				HttpSession session = request.getSession();
				
				List<violationData> allVio = cv.findAll();
				session.setAttribute("allviolation", allVio);
				response.sendRedirect("/carManager/Main/content/adminVio.jsp?updatemessage=success");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ParseException e) {
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
