package com.lk.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

import com.lk.servlet.Qbject_nameRequest;

/**
 * Application Lifecycle Listener implementation class setDevId_Listener
 *
 */
public class setDevId_Listener implements ServletRequestAttributeListener {

    /**
     * Default constructor. 
     */
    public setDevId_Listener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestAttributeListener#attributeRemoved(ServletRequestAttributeEvent)
     */
    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletRequestAttributeListener#attributeAdded(ServletRequestAttributeEvent)
     */
    public void attributeAdded(ServletRequestAttributeEvent srae)  { 
         // TODO Auto-generated method stub
    	
    	String devName = (String)srae.getServletRequest().getAttribute("devName");
    	//System.out.println(k);
    	Qbject_nameRequest.setdevID(devName);
    	
    }

	/**
     * @see ServletRequestAttributeListener#attributeReplaced(ServletRequestAttributeEvent)
     */
    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
         // TODO Auto-generated method stub
    }
	
}
