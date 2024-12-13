package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility
{

		public int  getRandomNo()
		{
			Random random=new Random();
			int rannum = random.nextInt(5000);
			return rannum;
		}
		
		public String getsystemDateYYYYDDMM()
		{
			Date date=new Date();
			SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
			String newdate = sim.format(date);
			return newdate;
			
		}
		
		public String getRequiredDateYYYYDDMM(int days)
		{
			Date date=new Date();
			
			SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
			
			sim.format(date);
					Calendar cal = sim.getCalendar();
					cal.add(Calendar.DAY_OF_MONTH, days);
					String reqdate=sim.format(cal.getTime());
					return reqdate;
			
			
		}
}

