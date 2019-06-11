package cn.lk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.lk.dao.CallContactMsg;
import cn.lk.entity.ContactMsg;

/**
 * Servlet implementation class SingleContactDetails
 */
public class SingleContactDetails extends HttpServlet {
	private static final long serialVersionUID = 8L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SingleContactDetails() {
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
		
		ContactMsg contactMsg = null;
		
		String result = "";
		String BelongUser = request.getParameter("BelongUser");
		String Phonenumber = request.getParameter("Phonenumber");
		
		contactMsg = CallContactMsg.findSingleDetails(BelongUser, Phonenumber);
		
		if(contactMsg == null)
		{
			result = "lack_error";
		}
		else
		{
			result = JSON.toJSONString(contactMsg);
		}
		
		out.write(result);
		out.flush();
		out.close();
		
		System.out.println(result);
		
	}

}
