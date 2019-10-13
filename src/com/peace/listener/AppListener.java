package com.peace.listener;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class AppListener
 *
 */
@WebListener
public class AppListener implements ServletContextListener {
	private Connection connection;

    /**
     * Default constructor. 
     */
    public AppListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	try {
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection =
				       DriverManager.getConnection("jdbc:mysql://localhost/peace?" +
				                                   "user=root&password=adminadmin&serverTimezone=UTC");
			
			sce.getServletContext().setAttribute("connection", connection);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
}
