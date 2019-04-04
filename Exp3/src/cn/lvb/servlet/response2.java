package cn.lvb.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class response2
 */
@WebServlet("/response2")
public class response2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public response2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		//PrintWriter out = response.getWriter();
		//out.print("hello\n");
		test3(request, response);
		//test2(request, response);
		//test1(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	private void test3(HttpServletRequest request, HttpServletResponse response) throws IOException
		{
	
		//通知浏览器不要缓存
		response.setHeader("Expires", "-1");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
				
				int width = 120;
				int height = 25;
				//创建一副内存图像：BufferedImage
				BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
				//得到属于该图片的画笔：Graphics
				Graphics g = image.getGraphics();
					//画边框
				g.setColor(Color.BLUE);
				g.drawRect(0, 0, width, height);
					//填充背景色
				g.setColor(Color.YELLOW);
				g.fillRect(1, 1, width-2, height-2);
					//画干扰线
				g.setColor(Color.GRAY);
				
				Random r = new Random();
				for(int i=0;i<10;i++)
					g.drawLine(r.nextInt(width), r.nextInt(height), r.nextInt(width), r.nextInt(height));
				
					//随机数字
				g.setColor(Color.RED);
				g.setFont(new Font("宋体", Font.BOLD|Font.ITALIC, 20));
				int x = 23;
				for(int i=0;i<4;i++){
					g.drawString(r.nextInt(10)+"", x, 20);
					x+=20;
				}
				//输出到浏览器的页面上:ImageIO
				ImageIO.write(image, "jpg", response.getOutputStream());
				
	}
	private void test2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String filePath = getServletContext().getRealPath("/1.jpg");
		
		//通知客户端以下载的方式打开
		String filename = "郁金香.jpg";
		
		
		
		response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(filename,"UTF-8"));//中文文件名此处要进行URL编码
		
		response.setHeader("Content-Type", "application/octet-stream");//通知客户端正文的类型
		InputStream in = new FileInputStream(filePath);
		OutputStream out = response.getOutputStream();
		int len = -1;
		byte b[] = new byte[1024];
		while((len=in.read(b))!=-1){
			out.write(b, 0, len);
		}
		in.close();
		out.close();
	}
	
	private void test1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String filePath = getServletContext().getRealPath("/1.jpg");
		
		//通知客户端以下载的方式打开
		response.setHeader("Content-Disposition", "attachment;filename=1.jpg");
		response.setHeader("Content-Type", "application/octet-stream");//通知客户端正文的类型
		InputStream in = new FileInputStream(filePath);
		OutputStream out = response.getOutputStream();
		int len = -1;
		byte b[] = new byte[1024];
		while((len=in.read(b))!=-1){
			out.write(b, 0, len);
		}
		in.close();
		out.close();
	}
}
