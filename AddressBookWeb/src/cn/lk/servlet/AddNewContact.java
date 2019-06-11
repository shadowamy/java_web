package cn.lk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lk.dao.CallContactMsg;
import cn.lk.entity.ContactMsg;

/**
 * Servlet implementation class AddNewContact
 */
public class AddNewContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewContact() {
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
		String Name = request.getParameter("Name");
		String Phonenumber = request.getParameter("Phonenumber");
		String BelongUser = request.getParameter("BelongUser");
		String Address = request.getParameter("Address");
		
		ContactMsg contactMsg = CallContactMsg.findSingleDetails(BelongUser, Phonenumber);
		if(contactMsg!=null)
		{
			result = "repeat_error";
		}
		else
		{
			ContactMsg add_contactMsg = new ContactMsg(Name, Phonenumber, Address, BelongUser);
			CallContactMsg.addOneContact(add_contactMsg);
			result = "add_one_success";
		}
		
		out.write(result);
		out.flush();
		out.close();
		
		System.out.println(result);
	}

}
