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

import cn.lk.bean.call_adminuserDataDB;
import cn.lk.bean.call_carPlateDataDB;
import cn.lk.bean.call_userDataDB;
import cn.lk.bean.call_violationDataDB;
import cn.lvb.bao.adminUser;
import cn.lvb.bao.carPlateData;
import cn.lvb.bao.userData;
import cn.lvb.bao.violationData;

/**
 * Servlet implementation class loginCheck
 */
public class loginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginCheck() {
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

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		call_userDataDB calu = new call_userDataDB();
		call_adminuserDataDB cala = new call_adminuserDataDB();
		try {
			
			userData ud = calu.findByUsername(username);
			adminUser au = cala.findByUsername(username);
			
			if(ud == null&&au == null)
			{
				out.print("请先注册，3秒后跳转到登陆界面");
				response.setHeader("Refresh", "3;URL=/carManager/Login/login.jsp");
			}
			
			else if(ud!=null)
			{
				if(ud.getPassword().equals(password))
				{
					
					//set user
					HttpSession session = request.getSession();
					
					session.removeAttribute("adminuser");
					session.setAttribute("user", ud);
					
					//set violation
					call_violationDataDB cv = new call_violationDataDB();
					List<violationData> list_vio = cv.findByIDNumber(ud.getIDNumber());
					session.setAttribute("violation", list_vio);
					
					//set carPlate
					call_carPlateDataDB cc = new call_carPlateDataDB();
					List<carPlateData> list_carpl = cc.findByLicenseID(ud.getIDNumber());
					session.setAttribute("carPlate", list_carpl);
					
					response.sendRedirect("/carManager/Main/content/index.jsp");
				}
				else
				{
					out.print("用户名或密码错误，3秒后跳转到登陆界面");
					response.setHeader("Refresh", "3;URL=/carManager/Login/login.jsp");
				}
			}
			
			else if(au!=null)
			{
				if(au.getPassword().equals(password))
				{
					HttpSession session = request.getSession();
					
					session.removeAttribute("user");
					session.setAttribute("adminuser", au);
					
					call_violationDataDB cv = new call_violationDataDB();
					List<violationData> allVio = cv.findAll();
					session.setAttribute("allviolation", allVio);
					
					response.sendRedirect("/carManager/Main/content/index.jsp");
				}
				
				else
				{
					out.print("用户名或密码错误，3秒后跳转到登陆界面");
					response.setHeader("Refresh", "3;URL=/carManager/Login/login.jsp");
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
