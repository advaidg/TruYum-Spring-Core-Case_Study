package com.cognizant.truyum.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 
 * @author Advaid Gireesan
 *
 */
public class DateUtil {
	/**
	 * 
	 * @param date
	 * @return
	 */
	public  Date convertToDate(final String date) 
	{Date dateObj = new Date();
		try {
		final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		  
		
			dateObj = formatter.parse(date);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}  
		  return dateObj;
	}
	
}
