package com.nadee.cbtls.activity;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Spinner;

import com.nadee.cbtls.R;
import com.nadee.cbtls.dto.TrainStationDTO;
import com.nadee.cbtls.dto.TrainStationScheduleDTO;
import com.nadee.cbtls.util.JSONParser;


public class NotificationAlarmActivity extends Activity {

  private static String BASE_URL;
  private static final String TRAIN_STATION_URL = "listTrainStationsByTrainLine.json?trainLineId=";
  private static final String PASSIVE_UPDATE_TRAIN_LOCATION_URL = "passiveUpdateTrainLocation.json";
  TrainStationScheduleDTO selectedDTO;
  long trainStationScheduleId;
  Context context;

  ArrayList<String> trainStationNameList;
  ArrayList<String> trainPositionList;
  ArrayList<TrainStationDTO> trainStationList;
  TrainStationDTO selecetdStation;

  int selectedLocation;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_notification_alarm);
    BASE_URL = getString(R.string.base_app_url);
    Bundle extras = getIntent().getExtras();
    context = this;
    if (extras != null) {
      System.out.println("TRAIN_SCHEDULE_DETAIL_ID :" + extras.get("TRAIN_SCHEDULE_DETAIL_ID"));
      System.out.println("TRAIN_SCHEDULE_DETAIL :" + extras.get("TRAIN_SCHEDULE_SEARCH_DTO"));
      selectedDTO = (TrainStationScheduleDTO) extras.get("TRAIN_SCHEDULE_SEARCH_DTO");
      trainStationScheduleId = (Long) extras.get("TRAIN_SCHEDULE_DETAIL_ID");
    }
    new DownloadTrainStationJSON().execute();
    setupTrainLocationSpinner();
    setupButtons();
    setupNumberPickers();
  }

  private void setupNumberPickers() {
    NumberPicker numberPickerCompartmentNumber = (NumberPicker) findViewById(R.id.numberPicker_compartment_number);
    numberPickerCompartmentNumber.setMinValue(1);
    numberPickerCompartmentNumber.setMaxValue(15);
    numberPickerCompartmentNumber.setWrapSelectorWheel(false);
  }

  private void setupTrainLocationSpinner() {
    trainPositionList = new ArrayList<String>();
    trainPositionList.add("Set Distance to Ring Alarm");
    trainPositionList.add("Ring Alarm Before 1 Station");
    trainPositionList.add("Ring Alarm at the Station");

    // Locate the spinner in activity_main.xml
    Spinner trainPositionSpinner = (Spinner) findViewById(R.id.spinner_alarm_setting);

    // Spinner adapter
    trainPositionSpinner.setAdapter(new ArrayAdapter<String>(NotificationAlarmActivity.this, android.R.layout.simple_spinner_dropdown_item,
        trainPositionList));


    // Spinner on item click listener
    trainPositionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

      @Override
      public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long arg3) {
        selectedLocation = (position + 1);
      }

      @Override
      public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
      }
    });

  }

  private void setupButtons() {

    Button btnUpdateOnce = (Button) findViewById(R.id.btn_set_alarm);
    btnUpdateOnce.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {}
    });

    Button btnUpdateGoBack = (Button) findViewById(R.id.btn_go_back);
    btnUpdateGoBack.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(getBaseContext(), ViewTrainScheduleDetailsActivity.class);
        System.out.println("selectedDTO in details" + selectedDTO);
        intent.putExtra("TRAIN_SCHEDULE_DETAIL", selectedDTO);
        intent.putExtra("TRAIN_SCHEDULE_DETAIL_ID", trainStationScheduleId);
        startActivity(intent);
        NotificationAlarmActivity.this.finish();
      }
    });
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.notification_alarm, menu);
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

  private class DownloadTrainStationJSON extends AsyncTask<String, String, JSONArray> {
    private ProgressDialog pDialog;

    @Override
    protected void onPreExecute() {
      super.onPreExecute();
      pDialog = new ProgressDialog(NotificationAlarmActivity.this);
      pDialog.setMessage("Getting Data ...");
      pDialog.setIndeterminate(false);
      pDialog.setCancelable(true);
      pDialog.show();

    }

    @Override
    protected JSONArray doInBackground(String... args) {
      trainStationNameList = new ArrayList<String>();
      trainStationList = new ArrayList<TrainStationDTO>();

      JSONParser jParser = new JSONParser();
      // Getting JSON from URL
      System.out.println("getTrainLineId() :" + selectedDTO.getTrainLineDTO().getTrainLineId());
      JSONArray json = jParser.getJSONArrayFromUrl(BASE_URL + TRAIN_STATION_URL + selectedDTO.getTrainLineDTO().getTrainLineId());
      return json;
    }

    @Override
    protected void onPostExecute(JSONArray trainStationJson) {
      pDialog.dismiss();
      try {
        for (int i = 0; i < trainStationJson.length(); i++) {

          JSONObject trainStation = trainStationJson.getJSONObject(i);
          // trainStationCode,trainStationName,trainStationId
          // Storing JSON item in a Variable
          long trainStationId = Long.parseLong(trainStation.getString("trainStationId"));
          String trainStationName = trainStation.getString("trainStationName");
          String trainStationCode = trainStation.getString("trainStationCode");

          TrainStationDTO trainStationDTO = new TrainStationDTO();
          trainStationDTO.setTrainStationCode(trainStationCode);
          trainStationDTO.setTrainStationName(trainStationName);
          trainStationDTO.setTrainStationId(trainStationId);
          trainStationList.add(trainStationDTO);

          trainStationNameList.add(trainStationName);

        }

        // Locate the spinner in activity_main.xml
        Spinner trainStationSpinner = (Spinner) findViewById(R.id.spinner_station);

        // Spinner adapter
        trainStationSpinner.setAdapter(new ArrayAdapter<String>(NotificationAlarmActivity.this, android.R.layout.simple_spinner_dropdown_item,
            trainStationNameList));


        // Spinner on item click listener
        trainStationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

          @Override
          public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long arg3) {
            selecetdStation = trainStationList.get(position);
          }

          @Override
          public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
          }
        });

      } catch (JSONException e) {
        e.printStackTrace();
      }

    }
  }
}
