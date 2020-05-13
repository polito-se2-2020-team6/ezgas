package it.polito.ezgas.scheduling;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

	@Scheduled(fixedRate = 1000)
	public void reportUpdateGasStationReportValues() {
		System.out.println("Hello, world!");
	}
}
