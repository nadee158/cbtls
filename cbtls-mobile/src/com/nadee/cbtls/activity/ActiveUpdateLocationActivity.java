package com.nadee.cbtls.activity;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.nadee.cbtls.R;
import com.nadee.cbtls.dto.TrainStationDTO;
import com.nadee.cbtls.dto.TrainStationScheduleDTO;
import com.nadee.cbtls.util.JSONParser;

public class ActiveUpdateLocationActivity extends Activity {

  private static String BASE_URL;
  private static final String TRAIN_STATION_URL = "listTrainStationsByTrainLine.json?trainLineId=";
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
    setContentView(R.layout.activity_active_update_location);
    BASE_URL = getString(R.string.base_app_url);
    setTitle("Active Update Location - CBTLS");
    Bundle extras = getIntent().getExtras();
    context = this;
    if (extras != null) {
      selectedDTO = (TrainStationScheduleDTO) extras.get("TRAIN_SCHEDULE_DETAIL");
      trainStationScheduleId = (Long) extras.get("TRAIN_SCHEDULE_DETAIL_ID");
    }
    new DownloadTrainStationJSON().execute();
    setupTrainLocationSpinner();
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
      System.out.println("selectedTrainLineDTO.getTrainLineId() :" + selectedDTO.getTrainLineDTO().getTrainLineId());
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
}
