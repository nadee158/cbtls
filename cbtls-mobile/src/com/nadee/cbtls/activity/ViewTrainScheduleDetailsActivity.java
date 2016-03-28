package com.nadee.cbtls.activity;

import java.text.SimpleDateFormat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

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
      selectedDTO = (TrainStationScheduleDTO) extras.get("TRAIN_SCHEDULE_DETAIL");
      trainStationScheduleId = (Long) extras.get("TRAIN_SCHEDULE_DETAIL_ID");
      setupTextViews();
      setupButtons();

    }
  }

  private void setupButtons() {
    Button btn_active_update = (Button) findViewById(R.id.btn_active_update);
    btn_active_update.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(getBaseContext(), ActiveUpdateLocationActivity.class);
        intent.putExtra("TRAIN_SCHEDULE_SEARCH_DTO", selectedDTO);
        startActivity(intent);
        ViewTrainScheduleDetailsActivity.this.finish();
      }
    });

    Button btn_passive_update = (Button) findViewById(R.id.btn_passive_update);
    btn_passive_update.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {

      }
    });

    Button btn_view_train_location = (Button) findViewById(R.id.btn_view_train_location);
    btn_view_train_location.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {

      }
    });

    Button btn_view_analysis_of_train = (Button) findViewById(R.id.btn_view_analysis_of_train);
    btn_view_analysis_of_train.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {

      }
    });

    Button btn_add_to_favourites = (Button) findViewById(R.id.btn_add_to_favourites);
    btn_add_to_favourites.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {

      }
    });

    Button btn_search_again = (Button) findViewById(R.id.btn_search_again);
    btn_search_again.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {

      }
    });
  }

  private void setupTextViews() {

    TextView textView_TrainDetails = (TextView) findViewById(R.id.textView_TrainDetails);
    String textTrainDetails =
        "Train no. " + selectedDTO.getTrainSchedule().getTrainNumber() + " From "
            + selectedDTO.getTrainSchedule().getStartStation().getTrainStationName() + " to "
            + selectedDTO.getTrainSchedule().getEndStation().getTrainStationName();
    textView_TrainDetails.setText(textTrainDetails);

    TextView textView_StartStation = (TextView) findViewById(R.id.textView_StartStation);
    textView_StartStation.setText(selectedDTO.getFromTrainStation().getTrainStationName());

    TextView textView_DestinationStation = (TextView) findViewById(R.id.textView_DestinationStation);
    textView_DestinationStation.setText(selectedDTO.getToTrainStation().getTrainStationName());

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm a");

    TextView textView_EtaStartStation = (TextView) findViewById(R.id.textView_EtaStartStation);
    textView_EtaStartStation.setText(simpleDateFormat.format(selectedDTO.getArrivalTime()));

    TextView textView_EtaEndStation = (TextView) findViewById(R.id.textView_EtaEndStation);
    textView_EtaEndStation.setText(simpleDateFormat.format(selectedDTO.getArrivalAtDestinationTime()));

    TextView textView_TotalDistance = (TextView) findViewById(R.id.textView_TotalDistance);
    textView_TotalDistance.setText(selectedDTO.getDistance() + " km");

    TextView textView_TotalDuration = (TextView) findViewById(R.id.textView_TotalDuration);
    textView_TotalDuration.setText(selectedDTO.getDuration());

    TextView textView_TrainType = (TextView) findViewById(R.id.textView_TrainType);
    textView_TrainType.setText(selectedDTO.getTrainSchedule().getTrainType());

    TextView textView_trainFreqency = (TextView) findViewById(R.id.textView_trainFreqency);
    textView_trainFreqency.setText(selectedDTO.getTrainSchedule().getTrainFrequency());
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
