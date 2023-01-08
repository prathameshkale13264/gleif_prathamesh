package com.clearstream.lei.scheduler;

import java.net.URISyntaxException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class jobScheduler 
{	
	@Scheduled(cron = "0/3 * * * * ?")
	public void jobSchedule() throws URISyntaxException
	{
		try
		{
			com.clearstream.lei.controller.LeiController.goldenCopyDownload();
			System.out.println("Golden Copy Downloaded");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
