package cn.lk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lk.util.ImgBase64;

/**
 * Servlet implementation class AddContactImage
 */
public class AddContactImage extends HttpServlet {
	private static final long serialVersionUID = 11L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddContactImage() {
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
		
		String path = "D:\\java_web\\AddressBookWeb\\WebContent\\ImageHub";
		response.setContentType("text/heml;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String result = "";
		
		request.setCharacterEncoding("utf-8");
		String Phonenumber = request.getParameter("Phonenumber");
		String BelongUser = request.getParameter("BelongUser");
		String Imgstr = request.getParameter("Imgstr");
		
		//System.out.println(Imgstr);
		
		String img_path = path + "\\" + BelongUser + "+" + Phonenumber + ".jpg";
		
		boolean flag = ImgBase64.generateImage(Imgstr, img_path);
		
		if(flag)
		{
			result = "img_success";
		}
		else
		{
			result = "img_fail";
		}
		
		out.write(result);
		out.flush();
		out.close();
		
		System.out.println(result);
		
	}

}
