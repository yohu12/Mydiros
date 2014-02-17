package com.diros.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeConvert {
	public static String timeToString(Date date)
	{
		String strDate=null;
		if(date !=null)
		{
			SimpleDateFormat sdf  =   new  SimpleDateFormat( "yyyy-MM-dd HH:mm:ss " );
			strDate=sdf.format(date);
		}
		return strDate;
	}
}
