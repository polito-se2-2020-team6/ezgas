package it.polito.ezgas.scheduling;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import it.polito.ezgas.entity.GasStation;
import it.polito.ezgas.entity.User;
import it.polito.ezgas.repository.GasStationRepository;
import it.polito.ezgas.repository.UserRepository;

@Component
public class ScheduledTasks {
	
	private UserRepository userRepository;
	private GasStationRepository gasStationRepository;
	
	public ScheduledTasks(UserRepository ur, GasStationRepository gsr) {
		this.userRepository = ur;
		this.gasStationRepository = gsr;
	}

	// Every 12 hours
	@Scheduled(fixedRate = 1000 * 60 * 60 * 12)
	public void scheduleUpdateGasStationReportDependability() {
		System.out.println("Hello, world!");
	}
	
	private int updateGasStationsReportDependability() {
		
		//Wed May 13 15:29:10 UTC 2020
		 DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);
		 Date now = new Date();
		 List<GasStation> gasStationsToUpdate = new ArrayList<>();
		 Map<Integer, User> seenUsers = new HashMap<>();
		
		gasStationRepository.findAll()
			.parallelStream()
			.filter(gs -> gs.getUser() != null)
			.forEach(gs -> {
				
				try {
					Date reportTimestamp = df.parse(gs.getReportTimestamp());
					//    obsolescence = 0 if (today - P.time_tag) > 7 days 
					//    otherwise obsolescence = 1 - (today - P.time_tag)/7
					long msecDifference = now.getTime() - reportTimestamp.getTime();
					int daysDifference = (int)(msecDifference / (24 * 60 * 60 * 1000));
					double obsolescence = daysDifference > 7 ? 0 : 1 - daysDifference / 7;
					
					User reportUser;
					if(seenUsers.containsKey(gs.getUser().getUserId())) {
						reportUser = seenUsers.get(gs.getUser().getUserId());
					} else {
						reportUser = this.userRepository.findOne(gs.getUser().getUserId());
						seenUsers.put(gs.getUser().getUserId(), reportUser);
					}
					int reputation = reportUser.getReputation();
					
					// pr.trust_level = 50 * (U.trust_level +5)/10 + 50 * obsolescence
					double newDependability = (reputation + 5) / 10 + 50 * obsolescence;
					
					gs.setReportDependability(newDependability);
					
					gasStationsToUpdate.add(gs);
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			});
		
		gasStationRepository.save(gasStationsToUpdate);
		
		return gasStationsToUpdate.size();
	}
}
