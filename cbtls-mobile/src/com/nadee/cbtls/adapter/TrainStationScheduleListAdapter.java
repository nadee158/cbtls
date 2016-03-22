package com.nadee.cbtls.adapter;

import java.text.SimpleDateFormat;
import java.util.List;

import com.nadee.cbtls.R;
import com.nadee.cbtls.dto.TrainStationScheduleDTO;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class TrainStationScheduleListAdapter extends ArrayAdapter<TrainStationScheduleDTO> {

	 public TrainStationScheduleListAdapter(Context context, int textViewResourceId) {
	        super(context, textViewResourceId);
	    }

	    public TrainStationScheduleListAdapter(Context context, int resource, List<TrainStationScheduleDTO> items) {
	        super(context, resource, items);
	    }

	    @Override
	    public View getView(int position, View convertView, ViewGroup parent) {

	        View v = convertView;

	        if (v == null) {
	            LayoutInflater vi;
	            vi = LayoutInflater.from(getContext());
	            v = vi.inflate(R.layout.listview_train_schedule, null);
	        }

	        TrainStationScheduleDTO scheduleDTO = getItem(position);

	        if (scheduleDTO != null) {
	        	
	            TextView arrivalTime = (TextView) v.findViewById(R.id.txt_arrival_time);
	            TextView departureTime = (TextView) v.findViewById(R.id.txt_departure_time);
	            TextView duration = (TextView) v.findViewById(R.id.txt_duration);

	            SimpleDateFormat tfHourFormat = new SimpleDateFormat("HH:mm:ss");
	            if (arrivalTime != null) {
	            	arrivalTime.setText(tfHourFormat.format(scheduleDTO.getArrivalAtDestinationTime()));
	            }

	            if (departureTime != null) {
	            	departureTime.setText(tfHourFormat.format(scheduleDTO.getDepartureTime()));
	            }

	            if (duration != null) {
	            	duration.setText(scheduleDTO.getDuration());
	            }
	        }

	        return v;
	    }

}
