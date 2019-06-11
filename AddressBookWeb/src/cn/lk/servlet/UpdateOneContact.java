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
 * Servlet implementation class UpdateOneContact
 */
public class UpdateOneContact extends HttpServlet {
	private static final long serialVersionUID = 9L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateOneContact() {
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
		String old_Name = request.getParameter("old_Name");
		String old_Phonenumber = request.getParameter("old_Phonenumber");
		String old_BelongUser = request.getParameter("old_BelongUser");
		String old_Address = request.getParameter("old_Address");
		
		String new_Name = request.getParameter("new_Name");
		String new_Phonenumber = request.getParameter("new_Phonenumber");
		String new_BelongUser = request.getParameter("new_BelongUser");
		String new_Address = request.getParameter("new_Address");
		
		System.out.println(new_Name);
		
		ContactMsg old_contactMsg = CallContactMsg.findSingleDetails(old_BelongUser, old_Phonenumber);
		if(old_contactMsg == null)
		{
			result = "lack_error";
		}
		else
		{
			ContactMsg contactcheck = CallContactMsg.findSingleDetails(new_BelongUser, new_Phonenumber);
			
			if(contactcheck == null)
			{
				ContactMsg new_contactMsg = new ContactMsg(new_Name, new_Phonenumber, new_Address, new_BelongUser);
				CallContactMsg.updateOneContact(old_contactMsg, new_contactMsg);
				result = "update_success";
			}
			else 
			{
				if(!old_Phonenumber.equals(new_Phonenumber))
				{
					result = "repeat_error";
				}
				else
				{
					ContactMsg new_contactMsg = new ContactMsg(new_Name, new_Phonenumber, new_Address, new_BelongUser);
					CallContactMsg.updateOneContact(old_contactMsg, new_contactMsg);
					result = "update_success";
				}
			}
		}
		
		out.write(result);
		out.flush();
		out.close();
		
		System.out.println(result);
		
	}

}
