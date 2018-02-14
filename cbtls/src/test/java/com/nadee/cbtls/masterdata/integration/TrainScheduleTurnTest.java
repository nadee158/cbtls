package com.nadee.cbtls.masterdata.integration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.model.TrainSchedule;
import com.nadee.cbtls.model.TrainScheduleTurn;
import com.nadee.cbtls.model.TrainScheduleTurnLocationUpdate;
import com.nadee.cbtls.model.TrainStation;
import com.nadee.cbtls.service.TrainScheduleService;
import com.nadee.cbtls.service.TrainStationService;
import com.nadee.cbtls.service.TrainTypeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-config.xml", "/tiles.xml" })
public class TrainScheduleTurnTest {

	public static final String MONDAY_TO_FRIDAY = "MONDAY TO FRIDAY";
	public static final String SUNDAYS_AND_HOLIDAYS = "SUNDAYS AND HOLIDAYS";
	public static final String SATURDAY_AND_SUNDAY = "SATURDAY AND SUNDAY";
	public static final String DAILY = "DAILY";

	@Autowired
	private TrainScheduleService trainScheduleService;

	@Autowired
	private TrainStationService trainStationService;

	@Autowired
	private TrainTypeService trainTypeService;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	@Test
	public void testSaveSchedules() throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new File("D:\\cbtls\\MIT_SCSE_Submission\\auto_generated_graph_data.txt"));
		StringBuilder sb = new StringBuilder();
		try {
			
			sb.append("Schedule Id");
			sb.append(',');
			sb.append("Train Schedule Date");
			sb.append(',');
			sb.append("Train Schedule Turn Id");
			sb.append(',');
			sb.append("Distance");
			sb.append(',');
			sb.append("Time Diff");
			sb.append('\n');
			
			List<TrainSchedule> trainS = trainScheduleService.listAllTrainSchedules(YesNoStatus.YES);
			for (TrainSchedule trainSchedule : trainS) {
				long scheduleId = trainSchedule.getTrainScheduleId();
				List<TrainScheduleTurn> trainScheduleTurn = trainSchedule.getTrainScheduleTurns();
				if (!(trainScheduleTurn == null || trainScheduleTurn.isEmpty())) {
					TrainStation startStation = trainSchedule.getStartStation();
					double startLat = startStation.getGeoLocation().getLatitude();
					double startLong = startStation.getGeoLocation().getLongitude();
					System.out.println("startLat " + startLat);
					System.out.println("startLong " + startLong);
					for (TrainScheduleTurn trainScheduleTurn2 : trainScheduleTurn) {
						Date trainScheduleDate = trainScheduleTurn2.getTrainScheduleTurnDate();
						long trainScheduleTurnId=trainScheduleTurn2.getTrainScheduleTurnId();
						
						sb.append(scheduleId);
						sb.append(',');
						sb.append(fmt.format(trainScheduleDate));
						sb.append(',');
						sb.append(trainScheduleTurnId);
						sb.append(',');
						
						System.out.println("trainScheduleDate " + trainScheduleDate);
						if (!(trainScheduleTurn2.getTrainScheduleTurnLocationUpdates() == null
								|| trainScheduleTurn2.getTrainScheduleTurnLocationUpdates().isEmpty())) {
							for (TrainScheduleTurnLocationUpdate update : trainScheduleTurn2
									.getTrainScheduleTurnLocationUpdates()) {
								
								double destLat = update.getLatitude();
								double destLong = update.getLongitude();
								
								double distance = distance(startLat, destLat, startLong, destLong);
								long timeDiff=getTimeDiff(trainScheduleDate, update.getUpdatedTime());
								
								
								
								sb.append(distance);
								sb.append(',');
								sb.append(timeDiff);
								sb.append(',');
								
							}
						}
						
						sb.append('\n');
					}
					sb.append('\n');
					sb.append('\n');
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			pw.write(sb.toString());
			pw.close();
			pw.flush();
		}
	}

	public static double distance(double lat1, double lat2, double lon1, double lon2) {

		final int R = 6371; // Radius of the earth

		double latDistance = Math.toRadians(lat2 - lat1);
		double lonDistance = Math.toRadians(lon2 - lon1);
		double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + Math.cos(Math.toRadians(lat1))
				* Math.cos(Math.toRadians(lat2)) * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double distance = R * c * 1000; // convert to meters

		distance = Math.pow(distance, 2);

		return Math.sqrt(distance);
	}

	private static SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");


	public long getTimeDiff(Date firstDate, Date secondDate) {
		long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
		return TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS);
	}

	
}
