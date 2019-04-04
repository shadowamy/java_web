package cn.lk.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.lvb.bao.adminUser;
import cn.lvb.bao.userData;

/**
 * Servlet Filter implementation class nonLogFilter
 */
public class nonLogFilter implements Filter {

    /**
     * Default constructor. 
     */
    public nonLogFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		//chain.doFilter(request, response);
		
		HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        HttpSession session = servletRequest.getSession();
        
        // ����û������URI
        String path = servletRequest.getRequestURI();
        
        userData user = (userData)session.getAttribute("user");
        adminUser adm = (adminUser)session.getAttribute("adminuser");
        
        // ��½ҳ���������
        if(path.indexOf("/carManager/Login/login.jsp") > -1)
        {
            chain.doFilter(servletRequest, servletResponse);
            return;
        }
        
        // ע��ҳ���������
        if(path.indexOf("/carManager/Login/register.jsp") > -1)
        {
            chain.doFilter(servletRequest, servletResponse);
            return;
        }
        
        if(path.indexOf("/carManager/Action/addVio.jsp") > -1)
        {
        	if(adm == null)
        	{
        		servletResponse.sendRedirect("/carManager/Login/login.jsp");
        	}
        	else
        	{
        		chain.doFilter(servletRequest, servletResponse);
        	}
        	return;
        }
        
        if(path.indexOf("/carManager/Action/updateVio.jsp") > -1)
        {
        	if(adm == null)
        	{
        		servletResponse.sendRedirect("/carManager/Login/login.jsp");
        	}
        	else
        	{
        		chain.doFilter(servletRequest, servletResponse);
        	}
        	return;
        }
        
        if(path.indexOf("/carManager/Main/content/adminVio.jsp") > -1)
        {
        	if(adm == null)
        	{
        		servletResponse.sendRedirect("/carManager/Login/login.jsp");
        	}
        	else
        	{
        		chain.doFilter(servletRequest, servletResponse);
        	}
            return;
        }
        
        if (user == null&&adm == null) 
        {
            // ��ת����½ҳ��
            servletResponse.sendRedirect("/carManager/Login/login.jsp");
        } 
        
        else 
        {
            // �Ѿ���½,�����˴�����
            chain.doFilter(request, response);
        }
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
