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

import cn.lk.bean.call_userDataDB;
import cn.lk.bean.call_violationDataDB;
import cn.lvb.bao.userData;
import cn.lvb.bao.violationData;

/**
 * Servlet implementation class dealViolation
 */
public class dealViolation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dealViolation() {
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
		HttpSession session = request.getSession();
		
		String dealvioID = request.getParameter("dealvioID");
		int vioID = Integer.valueOf(dealvioID);
		//out.print(dealvioID);
		if(dealvioID!=null)
		{
			call_violationDataDB cv = new call_violationDataDB();
			try {
				
				violationData vioData = cv.findByvioID(dealvioID);
				int will_sub_Score = vioData.getVioScore();
				
				String personID = vioData.getIDNumber();
				call_userDataDB cu = new call_userDataDB();
				userData usdata = cu.findByidNum(personID);
				int now_Score = usdata.getDeScore();
				int will_Score;
				if(now_Score+will_sub_Score>12)
				{
					will_Score = 12;
				}
				else
				{
					will_Score = now_Score+will_sub_Score;
				}
				cu.update_deScore(personID, will_Score);
				cv.update_vioStatus(vioID, "“—¥¶¿Ì");
				
				//violationData vioData_after = cv.findByvioID(dealvioID);
				userData usdata_after = cu.findByidNum(personID);
				List<violationData> vioData_after = cv.findByIDNumber(usdata_after.getIDNumber());
				
				session.setAttribute("user", usdata_after);
				session.setAttribute("violation", vioData_after);
				
				response.sendRedirect("/carManager/Main/content/violation.jsp");
				//response.sendRedirect("/carManager/loginCheck");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
