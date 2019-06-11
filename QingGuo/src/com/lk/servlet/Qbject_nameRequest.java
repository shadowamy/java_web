package com.lk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Qbject_nameRequest
 */
public class Qbject_nameRequest extends HttpServlet{
	private static final long serialVersionUID = 1L;
       
	private static String devId;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Qbject_nameRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		/*response.setContentType("text/heml;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String key = request.getParameter("key");
		out.print(key);
		out.print("hello");*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setCharacterEncoding("utf-8");
	    request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String key = request.getParameter("key");
		
		//System.out.println("obj_request: "+key);
		
		request.setAttribute("devName", key);
		//request.setAttribute("k", v);
		//request.removeAttribute("k");
		out.print(devId);
		
	}

	public static void setdevID(String id)
	{
		devId = id;
	}
}
