package com.nadee.cbtls.activity;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.nadee.cbtls.R;
import com.nadee.cbtls.dto.ActiveTrainLocationUpdateDTO;
import com.nadee.cbtls.dto.TrainStationDTO;
import com.nadee.cbtls.dto.TrainStationScheduleDTO;
import com.nadee.cbtls.util.ApplicationConstants;
import com.nadee.cbtls.util.GPSTracker;
import com.nadee.cbtls.util.JSONParser;

public class ActiveUpdateLocationActivity extends Activity {

  private static String BASE_URL;
  private static final String TRAIN_STATION_URL = "listTrainStationsByTrainLine.json?trainLineId=";
  private static final String ACTIVE_UPDATE_TRAIN_LOCATION_URL = "activeUpdateTrainLocation.json";
  TrainStationScheduleDTO selectedDTO;
  long trainStationScheduleId;
  Context context;

  ArrayList<String> trainStationNameList;
  ArrayList<String> trainPositionList;
  ArrayList<TrainStationDTO> trainStationList;
  TrainStationDTO selecetdStation;

  int selectedLocation;

  ActiveTrainLocationUpdateDTO activeTrainLocationUpdateDTO;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_active_update_location);
    BASE_URL = getString(R.string.base_app_url);
    setTitle("Active Update Location - CBTLS");
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
  }



  private void updateTrainLocation() {
    activeTrainLocationUpdateDTO = new ActiveTrainLocationUpdateDTO();
    activeTrainLocationUpdateDTO.setLastStationId(selecetdStation.getTrainStationId());

    GPSTracker gpsTracker = new GPSTracker(ActiveUpdateLocationActivity.this);

    if (gpsTracker.getIsGPSTrackingEnabled()) {
      activeTrainLocationUpdateDTO.setLatitude(gpsTracker.getLatitude());
      activeTrainLocationUpdateDTO.setLongitude(gpsTracker.getLongitude());
    } else {
      gpsTracker.showSettingsAlert();
    }

    activeTrainLocationUpdateDTO.setLocatedType(selectedLocation);
    String systemUserMobileDeviceId = loadSystemUserMobileDeviceId();
    activeTrainLocationUpdateDTO.setSystemUserMobileDevice(systemUserMobileDeviceId);
    activeTrainLocationUpdateDTO.setTrainScheduleId(selectedDTO.getTrainSchedule().getTrainScheduleId());
    activeTrainLocationUpdateDTO.setTrainStationScheduleId(trainStationScheduleId);

    new PostActiveUpdateLocationJson().execute();

  }

  private void setupButtons() {
    Button btnUpdateOnce = (Button) findViewById(R.id.btn_update_once);
    btnUpdateOnce.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        updateTrainLocation();
      }

    });



    Button btnUpdateAndTrack = (Button) findViewById(R.id.btn_update_and_track);
    btnUpdateAndTrack.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        final Handler handler = new Handler();
        Timer timer = new Timer();
        TimerTask doAsynchronousTask = new TimerTask() {
          @Override
          public void run() {
            handler.post(new Runnable() {
              @SuppressWarnings("unchecked3")
              public void run() {
                try {
                  updateTrainLocation();
                } catch (Exception e) {
                  e.printStackTrace();
                }
              }
            });
          }
        };
        timer.schedule(doAsynchronousTask, (1000 * 60 * 5333));
      }
    });


    Button btnUpdateCompartmentDetails = (Button) findViewById(R.id.btn_update_compartment_details);
    btnUpdateCompartmentDetails.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(getBaseContext(), UpdateCompartmentDetailsActivity.class);
        System.out.println("selectedDTO in details" + selectedDTO);
        intent.putExtra("TRAIN_SCHEDULE_SEARCH_DTO", selectedDTO);
        intent.putExtra("TRAIN_SCHEDULE_DETAIL_ID", trainStationScheduleId);
        startActivity(intent);
        ActiveUpdateLocationActivity.this.finish();
      }
    });


    Button btnSetAlarmClock = (Button) findViewById(R.id.btn_set_alarm_clock);
    btnSetAlarmClock.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        setAlarmClock();
      }
    });

  }

  private void setAlarmClock() {
    Intent intent = new Intent(getBaseContext(), NotificationAlarmActivity.class);
    System.out.println("selectedDTO in details" + selectedDTO);
    intent.putExtra("TRAIN_SCHEDULE_SEARCH_DTO", selectedDTO);
    intent.putExtra("TRAIN_SCHEDULE_DETAIL_ID", trainStationScheduleId);
    startActivity(intent);
    ActiveUpdateLocationActivity.this.finish();
  }

  private void saveSystemUserMobileDeviceId(String systemUserMobileDeviceId) {
    SharedPreferences sp = getSharedPreferences("cbtls_prefs", Activity.MODE_PRIVATE);
    SharedPreferences.Editor editor = sp.edit();
    editor.putString("system_user_mobile_device_id", systemUserMobileDeviceId);
    editor.commit();
  }

  private String loadSystemUserMobileDeviceId() {
    SharedPreferences sp = getSharedPreferences("cbtls_prefs", Activity.MODE_PRIVATE);
    return sp.getString("system_user_mobile_device_id", null);
  }

  private void setupTrainLocationSpinner() {
    trainPositionList = new ArrayList<String>();
    trainPositionList.add("In the Station");
    trainPositionList.add("On the Move");
    trainPositionList.add("Stopped");

    // Locate the spinner in activity_main.xml
    Spinner trainPositionSpinner = (Spinner) findViewById(R.id.spinner_train_position);

    // Spinner adapter
    trainPositionSpinner.setAdapter(new ArrayAdapter<String>(ActiveUpdateLocationActivity.this, android.R.layout.simple_spinner_dropdown_item,
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



  private class PostActiveUpdateLocationJson extends AsyncTask<String, String, JSONObject> {
    private ProgressDialog pDialog;

    @Override
    protected void onPreExecute() {
      super.onPreExecute();
      pDialog = new ProgressDialog(ActiveUpdateLocationActivity.this);
      pDialog.setMessage("Getting Data ...");
      pDialog.setIndeterminate(false);
      pDialog.setCancelable(true);
      pDialog.show();

    }

    @Override
    protected JSONObject doInBackground(String... args) {
      trainStationNameList = new ArrayList<String>();
      trainStationList = new ArrayList<TrainStationDTO>();

      JSONParser jParser = new JSONParser();
      // Getting JSON from URL
      System.out.println("selectedTrainLineDTO.getTrainLineId() :" + selectedDTO.getTrainLineDTO().getTrainLineId());
      JSONObject json = jParser.postJSONFromUrl(BASE_URL + ACTIVE_UPDATE_TRAIN_LOCATION_URL, activeTrainLocationUpdateDTO);
      return json;
    }

    @Override
    protected void onPostExecute(JSONObject resultMapJson) {
      pDialog.dismiss();
      try {
        String result = resultMapJson.getString(ApplicationConstants.RESULT);
        Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        String systemUserMobileDeviceId = loadSystemUserMobileDeviceId();
        if (systemUserMobileDeviceId == null || systemUserMobileDeviceId.trim() == "") {
          systemUserMobileDeviceId = resultMapJson.getString(ApplicationConstants.USER_ID);
          saveSystemUserMobileDeviceId(systemUserMobileDeviceId);
        }

      } catch (JSONException e) {
        e.printStackTrace();
      }

    }
  }


  private class DownloadTrainStationJSON extends AsyncTask<String, String, JSONArray> {
    private ProgressDialog pDialog;

    @Override
    protected void onPreExecute() {
      super.onPreExecute();
      pDialog = new ProgressDialog(ActiveUpdateLocationActivity.this);
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
        trainStationSpinner.setAdapter(new ArrayAdapter<String>(ActiveUpdateLocationActivity.this, android.R.layout.simple_spinner_dropdown_item,
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


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.active_update_location, menu);
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
