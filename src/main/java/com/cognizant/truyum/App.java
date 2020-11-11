package com.cognizant.truyum;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, IOException, SQLException
    {
        ApplicationContext app = new ClassPathXmlApplicationContext("sspring.xml");
        List<MenuItem> menuItems=(List<MenuItem>) app.getBean("menuItems");
        for(MenuItem item : menuItems)
        {
        	System.out.println(item);
        }
        MenuItemService ms = (MenuItemService) app.getBean("MenuItemService");
        List<MenuItem> ls = ms.getMenuItemListAdmin();
        for(MenuItem item : ls)
        {
        	System.out.println(item);
        }
        
        
        
}
}
