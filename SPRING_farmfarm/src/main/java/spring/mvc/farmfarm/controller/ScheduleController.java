package spring.mvc.farmfarm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import spring.mvc.farmfarm.service.MemberService;

@Controller
@Component
public class ScheduleController {
	@Autowired
	MemberService mem_service;
	
	@Scheduled(cron = "0 * * * * *")
	public void scheduleRun() {
		System.out.println("scheduleRun");		

		mem_service.scheduleRun();
		// System.out.println("스케줄 실행 : " + dateFormat.format(calendar.getTime()));
		//logger.info("스케줄 실행 : " + dateFormat.format(calendar.getTime()));
		// System.out.println("Request " + getCurrentRequest());
	}
}
