package com.nadee.cbtls.activity;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.Toast;

import com.nadee.cbtls.R;
import com.nadee.cbtls.dto.CompartmentDetailUpdateDTO;
import com.nadee.cbtls.dto.TrainStationScheduleDTO;
import com.nadee.cbtls.util.ApplicationConstants;
import com.nadee.cbtls.util.GPSTracker;
import com.nadee.cbtls.util.JSONParser;


public class UpdateCompartmentDetailsActivity extends Activity {

  private static String BASE_URL;
  private static final String COMPARTMENT_UPDATE_URL = "updateCompartmentDetails.json";
  TrainStationScheduleDTO selectedDTO;
  long trainStationScheduleId;
  Context context;

  ArrayList<String> crowdDensityList;
  int selectedCrowdDensityOfCompartment;
  int selectedOverallCrowdDensity;
  int compartmentNumber;
  int totalCompartments;

  CompartmentDetailUpdateDTO compartmentDetailUpdateDTO;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_update_compartment_details);
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
    setupButtons();
    setupSpinners();
    setupNumberPickers();
  }

  private void setupNumberPickers() {
    NumberPicker numberPickerCompartmentNumber = (NumberPicker) findViewById(R.id.numberPicker_compartment_number);
    NumberPicker numberPickerTotalCompartments = (NumberPicker) findViewById(R.id.numberPicker_total_compartments);
    numberPickerCompartmentNumber.setMinValue(1);
    numberPickerCompartmentNumber.setMaxValue(15);
    numberPickerCompartmentNumber.setWrapSelectorWheel(false);

    numberPickerTotalCompartments.setMinValue(1);
    numberPickerTotalCompartments.setMaxValue(15);
    numberPickerTotalCompartments.setWrapSelectorWheel(false);

  }

  private void setupButtons() {
    Button btnUpdate = (Button) findViewById(R.id.btn_update);
    btnUpdate.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        NumberPicker numberPickerCompartmentNumber = (NumberPicker) findViewById(R.id.numberPicker_compartment_number);
        NumberPicker numberPickerTotalCompartments = (NumberPicker) findViewById(R.id.numberPicker_total_compartments);
        compartmentNumber = numberPickerCompartmentNumber.getValue();
        totalCompartments = numberPickerTotalCompartments.getValue();

        compartmentDetailUpdateDTO = new CompartmentDetailUpdateDTO();
        compartmentDetailUpdateDTO.setCompartmentDensity(selectedCrowdDensityOfCompartment);
        compartmentDetailUpdateDTO.setCompartmentNumber(compartmentNumber);

        GPSTracker gpsTracker = new GPSTracker(UpdateCompartmentDetailsActivity.this);

        if (gpsTracker.getIsGPSTrackingEnabled()) {
          compartmentDetailUpdateDTO.setLatitude(gpsTracker.getLatitude());
          compartmentDetailUpdateDTO.setLongitude(gpsTracker.getLongitude());
        } else {
          gpsTracker.showSettingsAlert();
        }

        compartmentDetailUpdateDTO.setOverallDensity(selectedOverallCrowdDensity);
        compartmentDetailUpdateDTO.setSystemUserMobileDevice(loadSystemUserMobileDeviceId());
        compartmentDetailUpdateDTO.setTotalCompartments(totalCompartments);
        compartmentDetailUpdateDTO.setTrainScheduleId(selectedDTO.getTrainSchedule().getTrainScheduleId());
        compartmentDetailUpdateDTO.setTrainStationScheduleId(selectedDTO.getTrainStationScheduleId());
        new PostCompartmentDetailsUpdateJson().execute();
      }
    });

    Button btnGoBack = (Button) findViewById(R.id.btn_go_back);
    btnGoBack.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(getBaseContext(), ActiveUpdateLocationActivity.class);
        System.out.println("selectedDTO in details" + selectedDTO);
        intent.putExtra("TRAIN_SCHEDULE_SEARCH_DTO", selectedDTO);
        intent.putExtra("TRAIN_SCHEDULE_DETAIL_ID", trainStationScheduleId);
        startActivity(intent);
        UpdateCompartmentDetailsActivity.this.finish();
      }
    });

  }

  private void setupSpinners() {
    crowdDensityList = new ArrayList<String>();
    crowdDensityList.add("Low");
    crowdDensityList.add("Medium");
    crowdDensityList.add("High");
    crowdDensityList.add("Very High");

    // Locate the spinner in activity_main.xml
    Spinner spinnerCrowdDensityOfCompartment = (Spinner) findViewById(R.id.spinner_crowd_density_of_compartment);
    // Spinner adapter
    spinnerCrowdDensityOfCompartment.setAdapter(new ArrayAdapter<String>(UpdateCompartmentDetailsActivity.this,
        android.R.layout.simple_spinner_dropdown_item, crowdDensityList));
    // Spinner on item click listener
    spinnerCrowdDensityOfCompartment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long arg3) {
        selectedCrowdDensityOfCompartment = (position + 1);
      }

      @Override
      public void onNothingSelected(AdapterView<?> parent) {}
    });

    // Locate the spinner in activity_main.xml
    Spinner spinnerOverallCrowdDensity = (Spinner) findViewById(R.id.spinner_overall_crowd_density);
    // Spinner adapter
    spinnerOverallCrowdDensity.setAdapter(new ArrayAdapter<String>(UpdateCompartmentDetailsActivity.this,
        android.R.layout.simple_spinner_dropdown_item, crowdDensityList));
    // Spinner on item click listener
    spinnerOverallCrowdDensity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long arg3) {
        selectedOverallCrowdDensity = (position + 1);
      }

      @Override
      public void onNothingSelected(AdapterView<?> parent) {}
    });

  }

  private class PostCompartmentDetailsUpdateJson extends AsyncTask<String, String, JSONObject> {
    private ProgressDialog pDialog;

    @Override
    protected void onPreExecute() {
      super.onPreExecute();
      pDialog = new ProgressDialog(UpdateCompartmentDetailsActivity.this);
      pDialog.setMessage("Getting Data ...");
      pDialog.setIndeterminate(false);
      pDialog.setCancelable(true);
      pDialog.show();

    }

    @Override
    protected JSONObject doInBackground(String... args) {
      JSONParser jParser = new JSONParser();
      // Getting JSON from URL
      JSONObject json = jParser.postJSONFromUrl(BASE_URL + COMPARTMENT_UPDATE_URL, compartmentDetailUpdateDTO);
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


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.update_compartment_details, menu);
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
