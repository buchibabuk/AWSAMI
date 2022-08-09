package com.tls.springboot.license;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DEMO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String sDate1="2022-07-15 12:23:34 PM";  
		    Date date1;
			try {
				date1 = new SimpleDateFormat("yyy-MM-dd HH:mm:ss").parse(sDate1);				date1 = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy").parse(sDate1);
				 System.out.println(sDate1+"\t"+date1);  
			
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		   
	}

}
