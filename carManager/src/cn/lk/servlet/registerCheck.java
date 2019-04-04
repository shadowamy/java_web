package cn.lk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lk.bean.call_userDataDB;
import cn.lvb.bao.userData;

/**
 * Servlet implementation class registerCheck
 */
public class registerCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerCheck() {
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

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String passwordCon = request.getParameter("passwordCon");
		String realname = request.getParameter("realname");
		String idnum = request.getParameter("idnum");
		String address = request.getParameter("address");
		
		/*out.print("success\n");
		out.print(username+'\n');
		out.print(password+'\n');
		out.print(passwordCon+'\n');
		out.print(realname+'\n');
		out.print(idnum+'\n');
		out.print(address+'\n');*/
		
		if(username.equals("")||password.equals("")||passwordCon.equals("")||realname.equals("")||idnum.equals("")||address.equals(""))
		{
			out.print("null_error");
		}
		else
		{
			call_userDataDB calu = new call_userDataDB();
			userData ud = null;
			try {
				ud = calu.findByUsername(username);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(ud!=null)
			{
				out.print("user_error");
			}
			else
			{
				if(!password.equals(passwordCon))
				{
					out.print("pass_error");
				}
				else
				{
					userData ud_new = new userData(idnum, username, password, realname, address, 0);
					try {
						calu.insertUserdata(ud_new);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					out.print("success");
				}
			}
		}
		
		/*call_userDataDB calu = new call_userDataDB();
		userData ud = new userData(idnum, username, password, realname, address, 0);
		try {
			
			calu.insertUserdata(ud);
			
			//response.sendRedirect("/carManager/Login/login.jsp");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}

}
