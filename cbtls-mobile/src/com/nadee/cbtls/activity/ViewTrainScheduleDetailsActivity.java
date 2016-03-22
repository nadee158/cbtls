package com.nadee.cbtls.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.nadee.cbtls.R;
import com.nadee.cbtls.dto.TrainStationScheduleDTO;

public class ViewTrainScheduleDetailsActivity extends Activity {

	TrainStationScheduleDTO selectedDTO;
	long trainStationScheduleId;
	Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_train_schedule_details);
		setTitle("Train Schedule Details - CBTLS");
		Bundle extras = getIntent().getExtras();
		context = this;
		if (extras != null) {
			selectedDTO = (TrainStationScheduleDTO) extras
					.get("TRAIN_SCHEDULE_DETAIL");
			trainStationScheduleId = (Long) extras
					.get("TRAIN_SCHEDULE_DETAIL_ID");

		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_train_schedule_details, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
