package com.nadee.cbtls.adapter;

import java.text.SimpleDateFormat;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.nadee.cbtls.R;
import com.nadee.cbtls.activity.ViewTrainScheduleDetailsActivity;
import com.nadee.cbtls.dto.TrainStationScheduleDTO;

public class TrainStationScheduleListAdapter extends
		ArrayAdapter<TrainStationScheduleDTO> {

	public TrainStationScheduleListAdapter(Context context,
			int textViewResourceId) {
		super(context, textViewResourceId);
	}

	public TrainStationScheduleListAdapter(Context context, int resource,
			List<TrainStationScheduleDTO> items) {
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

		final TrainStationScheduleDTO scheduleDTO = getItem(position);

		if (scheduleDTO != null) {

			TextView arrivalTime = (TextView) v
					.findViewById(R.id.txt_arrival_time);
			TextView departureTime = (TextView) v
					.findViewById(R.id.txt_departure_time);
			TextView duration = (TextView) v.findViewById(R.id.txt_duration);

			TextView arrivalAtDestination = (TextView) v
					.findViewById(R.id.txt_arrival_at_destination);

			Button button = (Button) v.findViewById(R.id.btn_select);

			SimpleDateFormat tfHourFormat = new SimpleDateFormat("HH:mm:ss");
			System.out
					.println("tfHourFormat.format(scheduleDTO.getArrivalAtDestinationTime()) "
							+ tfHourFormat.format(scheduleDTO
									.getArrivalAtDestinationTime()));
			System.out
					.println("tfHourFormat.format(scheduleDTO.getDepartureTime()) "
							+ tfHourFormat.format(scheduleDTO
									.getDepartureTime()));
			if (arrivalTime != null) {

				arrivalTime.setText(tfHourFormat.format(scheduleDTO
						.getArrivalTime()));
			}

			arrivalAtDestination.setText(tfHourFormat.format(scheduleDTO
					.getArrivalAtDestinationTime()));

			if (departureTime != null) {

				departureTime.setText(tfHourFormat.format(scheduleDTO
						.getDepartureTime()));
			}

			if (duration != null) {
				duration.setText(scheduleDTO.getDuration());
			}

			button.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Intent intent = new Intent(v.getContext(),
							ViewTrainScheduleDetailsActivity.class);
					intent.putExtra("TRAIN_SCHEDULE_DETAIL_ID",
							scheduleDTO.getTrainStationScheduleId());
					intent.putExtra("TRAIN_SCHEDULE_DETAIL", scheduleDTO);
					v.getContext().startActivity(intent);
				}

			});
		}

		return v;
	}

}
