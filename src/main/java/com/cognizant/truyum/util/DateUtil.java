package com.cognizant.truyum.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public  Date convertToDate(String date) 
	{Date dateObj = new Date();
		try {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		  
		
			dateObj = formatter.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		  return dateObj;
	}
	
}
