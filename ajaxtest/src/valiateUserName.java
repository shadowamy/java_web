

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class valiateUserName
 */

public class valiateUserName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public valiateUserName() {
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
		String path = request.getContextPath();
		response.setContentType("text/html;charset=utf-8");
		//response.setContentType("application/text; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		System.out.println("in servlet");
		PrintWriter out = response.getWriter();
		String name = (String)request.getParameter("name");
		String password = (String)request.getParameter("pwd");
            if(name.equals(password)){
		        out.print("true");
            }
            else{
                out.println("false");
            }
		    System.out.print("cross");


	}

}
