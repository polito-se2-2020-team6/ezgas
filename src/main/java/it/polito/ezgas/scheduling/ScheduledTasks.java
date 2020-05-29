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
	private DateFormat df;
	private Date now;
	private Map<Integer, User> seenUsers;

	public ScheduledTasks(UserRepository ur, GasStationRepository gsr) {
		this.userRepository = ur;
		this.gasStationRepository = gsr;
		// Wed May 13 15:29:10 UTC 2020
		this.df = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);
		seenUsers = new HashMap<>();
	}
	
	
	public void setNow(Date now) {
		this.now = now;
	}


	public void setSeenUsers(Map<Integer, User> seenUsers) {
		this.seenUsers = seenUsers;
	}

	// Every 12 hours
	/*@Scheduled(fixedRate = 1000 * 60 * 60 * 12)
	public void scheduleUpdateGasStationReportDependability() {
		this.updateGasStationsReportDependability();
	}
*/
	public int updateGasStationsReportDependability() {

		this.now = new Date();
		List<GasStation> gasStationsToUpdate = new ArrayList<>();

		gasStationRepository.findAll()
		.parallelStream()
		.filter(gs -> gs.getUser() != null)
		.forEach(gs -> {

			try {
				double newDependability = this.computeNewDependability(gs.getReportTimestamp(), gs.getUser().getUserId());
				gs.setReportDependability(newDependability);
				gasStationsToUpdate.add(gs);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});

		gasStationRepository.save(gasStationsToUpdate);
		
		seenUsers = new HashMap<>();

		return gasStationsToUpdate.size();
	}

	private double computeNewDependability(String timestamp, Integer userId) throws ParseException {
		Date reportTimestamp = this.df.parse(timestamp);
		//    obsolescence = 0 if (today - P.time_tag) > 7 days 
		//    otherwise obsolescence = 1 - (today - P.time_tag)/7
		long msecDifference = this.now.getTime() - reportTimestamp.getTime();
		double daysDifference = msecDifference / (24 * 60 * 60 * 1000.0);
		double obsolescence = daysDifference > 7 ? 0 : 1 - daysDifference / 7.0;

		User reportUser;
		if(this.seenUsers.containsKey(userId)) {
			reportUser = seenUsers.get(userId);
		} else {
			reportUser = this.userRepository.findOne(userId);
			this.seenUsers.put(userId, reportUser);
		}
		int reputation = reportUser.getReputation();

		// pr.trust_level = 50 * (U.trust_level +5)/10 + 50 * obsolescence
		double newDependability = 50*(reputation + 5) / 10 + 50 * obsolescence;
		return newDependability;
	}
}
