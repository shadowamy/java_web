package cn.lk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lk.dao.CallUser;
import cn.lk.entity.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 7L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		String Username = request.getParameter("Username");
		String Password = request.getParameter("Password");
		
		User user = CallUser.findByUsername(Username);
		if(user == null)
		{
			result = "Lack_error";
		}
		else
		{
			String pwd = user.getPassword();
			if(!pwd.equals(Password))
			{
				result = "Pwd_error";
			}
			else
			{
				result = "Login_Success";
			}
		}
		
		out.write(result);
		out.flush();
		out.close();
		
		System.out.println(result);
	}

}
