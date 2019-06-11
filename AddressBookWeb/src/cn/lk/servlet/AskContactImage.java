package cn.lk.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lk.util.ImgBase64;

/**
 * Servlet implementation class AskContactImage
 */
public class AskContactImage extends HttpServlet {
	private static final long serialVersionUID = 10L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AskContactImage() {
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
		
		String img_path = path + "\\" + BelongUser + "+" + Phonenumber + ".jpg";
		//System.out.println(img_path);
		File img_file = new File(img_path);
		
		if(!img_file.exists())
		{
			result = "lack_img";
		}
		else
		{
			result = ImgBase64.getImgStr(img_path);
		}
		
		out.write(result);
		out.flush();
		out.close();
		
		System.out.println(result);
		
	}

}
