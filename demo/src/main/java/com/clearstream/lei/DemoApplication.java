package com.clearstream.lei;

import java.net.URISyntaxException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import com.clearstream.lei.scheduler.jobScheduler;

@SpringBootApplication
@EnableScheduling
public class DemoApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("Hi,Application has been started.");
		try
		{
			jobScheduler jobScheduler = new jobScheduler();
			jobScheduler.jobSchedule();
		}
		catch(URISyntaxException e)
		{
			e.printStackTrace();
		}
	}
}
