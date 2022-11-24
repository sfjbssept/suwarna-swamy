package com.aws.deploy;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int i = 0;
//		i = i+1;
		i++;
		System.out.println(i);
		
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
		Calendar cal = Calendar.getInstance();
		System.out.println(sdf.format(cal.getTime()));
		
		
		LocalDateTime ldf = LocalDateTime.now();
		LocalDateTime ldf2 = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss",Locale.ENGLISH);
//		Date dt = ldf.now();
		
		System.out.println(dtf.parse(""));
		 
		String format = dtf.format(ldf);
		System.out.println(format);
		
		
		
		
		System.out.println(ldf.compareTo(ldf2));
//		System.out.println(ldf.now());
//		System.out.println(ldf.toLocalDate());
//		
		Calendar cal1 = Calendar.getInstance();
		Date dt = cal1.getTime(); 
//		System.out.println(dt.getTime());
//		

	}

}
