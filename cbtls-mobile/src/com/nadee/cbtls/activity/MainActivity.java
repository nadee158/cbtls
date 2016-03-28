package com.nadee.cbtls.activity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.nadee.cbtls.R;
import com.nadee.cbtls.dto.TrainLineDTO;
import com.nadee.cbtls.dto.TrainScheduleSearchDTO;
import com.nadee.cbtls.dto.TrainStationDTO;
import com.nadee.cbtls.util.JSONParser;

public class MainActivity extends FragmentActivity {

  private Context context;

  private static String BASE_URL;
  private static final String TRAIN_LINE_URL = "listTrainLines.json";
  private static final String TRAIN_STATION_URL = "listTrainStationsByTrainLine.json?trainLineId=";

  ArrayList<String> trainLineNameList;
  ArrayList<TrainLineDTO> trainLines;
  TrainLineDTO selectedTrainLineDTO;

  ArrayList<String> trainStationNameList;
  ArrayList<TrainStationDTO> trainStationList;
  TrainStationDTO selecetdFromStation;
  TrainStationDTO selecetdToStation;

  // in HH:mm:ss
  SimpleDateFormat tfHourFormat = new SimpleDateFormat("HH:mm:ss");
  // in dd/MM/yyyy
  SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

  String selectedFromTime;
  String selectedToTime;

  String selectedDate;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    BASE_URL = getString(R.string.base_app_url);
    setTitle("Search Trains - CBTLS");
    context = this;
    initializeControllers();
    // Download JSON file AsyncTask
    new DownloadTrainLineJSON().execute();
  }

  private void searchTrainSchedule(TrainScheduleSearchDTO trainScheduleSearchDTO) {
    Intent intent = new Intent(getBaseContext(), ViewTrainSchedulesActivity.class);
    intent.putExtra("TRAIN_SCHEDULE_SEARCH_DTO", trainScheduleSearchDTO);
    startActivity(intent);
    this.finish();
  }

  private void initializeControllers() {
    Button nextTrain = (Button) findViewById(R.id.btn_next_train);
    nextTrain.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        if (!(selectedTrainLineDTO == null)) {
          if (!(selecetdFromStation == null || selecetdToStation == null)) {
            if (!(selecetdFromStation.getTrainStationId() == selecetdToStation.getTrainStationId())) {
              TrainScheduleSearchDTO trainScheduleSearchDTO = new TrainScheduleSearchDTO();
              trainScheduleSearchDTO.setTrainLineId(selectedTrainLineDTO.getTrainLineId());
              trainScheduleSearchDTO.setFromStationId(selecetdFromStation.getTrainStationId());
              trainScheduleSearchDTO.setToStationId(selecetdToStation.getTrainStationId());
              trainScheduleSearchDTO.setFromTime(tfHourFormat.format(Calendar.getInstance().getTime()));
              trainScheduleSearchDTO.setToTime("23:59:59");
              trainScheduleSearchDTO.setSearchedDate(dateFormat.format(Calendar.getInstance().getTime()));
              trainScheduleSearchDTO.setSearchTypeId(1);
              trainScheduleSearchDTO.setSearchTypeText("Next Train");
              trainScheduleSearchDTO.setFromStationName(selecetdFromStation.getTrainStationName());
              trainScheduleSearchDTO.setToStationName(selecetdToStation.getTrainStationName());
              searchTrainSchedule(trainScheduleSearchDTO);
            } else {
              Toast.makeText(context, "From and to stations can't be the same!", Toast.LENGTH_SHORT).show();
            }
          } else {
            Toast.makeText(context, "Please select from and to stations!", Toast.LENGTH_SHORT).show();
          }
        } else {
          Toast.makeText(context, "Please select a train line!", Toast.LENGTH_SHORT).show();
        }
      }
    });

    Button todaySchedule = (Button) findViewById(R.id.btn_today_schedule);
    todaySchedule.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        if (!(selectedTrainLineDTO == null)) {
          if (!(selecetdFromStation == null || selecetdToStation == null)) {
            if (!(selecetdFromStation.getTrainStationId() == selecetdToStation.getTrainStationId())) {
              TrainScheduleSearchDTO trainScheduleSearchDTO = new TrainScheduleSearchDTO();
              trainScheduleSearchDTO.setTrainLineId(selectedTrainLineDTO.getTrainLineId());
              trainScheduleSearchDTO.setFromStationId(selecetdFromStation.getTrainStationId());
              trainScheduleSearchDTO.setToStationId(selecetdToStation.getTrainStationId());
              trainScheduleSearchDTO.setFromTime("00:00:00");
              trainScheduleSearchDTO.setToTime("23:59:59");
              trainScheduleSearchDTO.setSearchedDate(dateFormat.format(Calendar.getInstance().getTime()));
              trainScheduleSearchDTO.setSearchTypeId(2);
              trainScheduleSearchDTO.setSearchTypeText("Today's Schedule");
              trainScheduleSearchDTO.setFromStationName(selecetdFromStation.getTrainStationName());
              trainScheduleSearchDTO.setToStationName(selecetdToStation.getTrainStationName());
              searchTrainSchedule(trainScheduleSearchDTO);
            } else {
              Toast.makeText(context, "From and to stations can't be the same!", Toast.LENGTH_SHORT).show();
            }
          } else {
            Toast.makeText(context, "Please select from and to stations!", Toast.LENGTH_SHORT).show();
          }
        } else {
          Toast.makeText(context, "Please select a train line!", Toast.LENGTH_SHORT).show();
        }
      }
    });

    Button searchSchedule = (Button) findViewById(R.id.btn_search);
    searchSchedule.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        if (!(selectedTrainLineDTO == null)) {
          if (!(selecetdFromStation == null || selecetdToStation == null)) {
            if (!(selecetdFromStation.getTrainStationId() == selecetdToStation.getTrainStationId())) {
              if (!(selectedFromTime == null || selectedToTime == null || selectedDate == null)) {
                TrainScheduleSearchDTO trainScheduleSearchDTO = new TrainScheduleSearchDTO();
                trainScheduleSearchDTO.setTrainLineId(selectedTrainLineDTO.getTrainLineId());
                trainScheduleSearchDTO.setFromStationId(selecetdFromStation.getTrainStationId());
                trainScheduleSearchDTO.setToStationId(selecetdToStation.getTrainStationId());
                trainScheduleSearchDTO.setFromTime(selectedFromTime);
                trainScheduleSearchDTO.setToTime(selectedToTime);
                trainScheduleSearchDTO.setSearchedDate(selectedDate);
                trainScheduleSearchDTO.setSearchTypeId(3);
                trainScheduleSearchDTO.setSearchTypeText("Advanced Search");
                trainScheduleSearchDTO.setFromStationName(selecetdFromStation.getTrainStationName());
                trainScheduleSearchDTO.setToStationName(selecetdToStation.getTrainStationName());
                searchTrainSchedule(trainScheduleSearchDTO);
              } else {
                Toast.makeText(context, "Please select from time, to time, and date!", Toast.LENGTH_SHORT).show();
              }

            } else {
              Toast.makeText(context, "From and to stations can't be the same!", Toast.LENGTH_SHORT).show();
            }
          } else {
            Toast.makeText(context, "Please select from and to stations!", Toast.LENGTH_SHORT).show();
          }
        } else {
          Toast.makeText(context, "Please select a train line!", Toast.LENGTH_SHORT).show();
        }
      }
    });

    Button pickADate = (Button) findViewById(R.id.btn_pick_a_date);
    pickADate.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        showDatePickerDialog(v);
      }
    });

    Button fromTime = (Button) findViewById(R.id.btn_from_time);
    fromTime.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        showFromTimePicker(v);
      }
    });

    Button toTime = (Button) findViewById(R.id.btn_to_time);
    toTime.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        showToTimePicker(v);
      }
    });

    Button showAdvancedFilter = (Button) findViewById(R.id.btn_advanced_filter);
    showAdvancedFilter.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        showHideAdvancedFilter(v);
      }
    });

  }

  private void showHideAdvancedFilter(View v) {
    LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout_Advanced_Filter);
    Button showAdvancedFilter = (Button) v;
    if (linearLayout.getVisibility() == View.VISIBLE) {
      linearLayout.setVisibility(View.GONE);
      showAdvancedFilter.setText(R.string.show_advanced_filter);
    } else {
      linearLayout.setVisibility(View.VISIBLE);
      showAdvancedFilter.setText(R.string.hide_advanced_filter);
    }

  }

  public void showToTimePicker(View v) {
    Date date = Calendar.getInstance().getTime();
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    TimePickerDialog d = new TimePickerDialog(this, timeToSetListener, cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE), false);
    d.show();
  }

  private TimePickerDialog.OnTimeSetListener timeToSetListener = new TimePickerDialog.OnTimeSetListener() {
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
      selectedToTime = String.format("%02d:%02d:%02d", hourOfDay, minute, 0);
      // Toast.makeText(context, selectedToTime,
      // Toast.LENGTH_LONG).show();
    }
  };

  public void showFromTimePicker(View v) {
    Date date = Calendar.getInstance().getTime();
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    TimePickerDialog d = new TimePickerDialog(this, timeFromSetListener, cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE), false);
    d.show();
  }

  private TimePickerDialog.OnTimeSetListener timeFromSetListener = new TimePickerDialog.OnTimeSetListener() {
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
      selectedFromTime = String.format("%02d:%02d:%02d", hourOfDay, minute, 0);
      // Toast.makeText(context, selectedFromTime,
      // Toast.LENGTH_LONG).show();
    }
  };

  public void showDatePickerDialog(View v) {
    Date date = Calendar.getInstance().getTime();
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    DatePickerDialog d =
        new DatePickerDialog(this, datePickerListener, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
    d.show();
  }

  private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {

    // when dialog box is closed, below method will be called.
    public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
      // in dd/MM/yyyy
      selectedDate = String.format("%02d/%02d/%04d", selectedDay, selectedMonth, selectedYear);
      // Toast.makeText(context, selectedDate, Toast.LENGTH_LONG).show();

    }
  };

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
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

  private class DownloadTrainLineJSON extends AsyncTask<String, String, JSONArray> {
    private ProgressDialog pDialog;

    @Override
    protected void onPreExecute() {
      super.onPreExecute();
      pDialog = new ProgressDialog(MainActivity.this);
      pDialog.setMessage("Getting Data ...");
      pDialog.setIndeterminate(false);
      pDialog.setCancelable(true);
      pDialog.show();

    }

    @Override
    protected JSONArray doInBackground(String... args) {
      trainLineNameList = new ArrayList<String>();
      trainLines = new ArrayList<TrainLineDTO>();

      JSONParser jParser = new JSONParser();
      // Getting JSON from URL
      JSONArray json = jParser.getJSONArrayFromUrl(BASE_URL + TRAIN_LINE_URL);
      return json;
    }

    @Override
    protected void onPostExecute(JSONArray trainLinesJson) {
      pDialog.dismiss();
      try {
        for (int i = 0; i < trainLinesJson.length(); i++) {

          JSONObject trainLine = trainLinesJson.getJSONObject(i);
          // trainLineId":1,"trainLineName":"Colombo - Badulla
          // Storing JSON item in a Variable
          long trainLineId = Long.parseLong(trainLine.getString("trainLineId"));
          String trainLineName = trainLine.getString("trainLineName");

          TrainLineDTO trainLineDTO = new TrainLineDTO();
          trainLineDTO.setTrainLineId(trainLineId);
          trainLineDTO.setTrainLineName(trainLineName);
          trainLines.add(trainLineDTO);

          trainLineNameList.add(trainLineName);

        }

        // Locate the spinner in activity_main.xml
        Spinner trainLineSpinner = (Spinner) findViewById(R.id.spinner_train_line);

        // Spinner adapter
        trainLineSpinner.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, trainLineNameList));

        // Spinner on item click listener
        trainLineSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

          @Override
          public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long arg3) {
            selectedTrainLineDTO = trainLines.get(position);
            new DownloadTrainStationJSON().execute();
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

  private class DownloadTrainStationJSON extends AsyncTask<String, String, JSONArray> {
    private ProgressDialog pDialog;

    @Override
    protected void onPreExecute() {
      super.onPreExecute();
      pDialog = new ProgressDialog(MainActivity.this);
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
      System.out.println("selectedTrainLineDTO.getTrainLineId() :" + selectedTrainLineDTO.getTrainLineId());
      JSONArray json = jParser.getJSONArrayFromUrl(BASE_URL + TRAIN_STATION_URL + selectedTrainLineDTO.getTrainLineId());
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
        Spinner fromTrainStationSpinner = (Spinner) findViewById(R.id.spinner_from_station);
        Spinner toTrainStationSpinner = (Spinner) findViewById(R.id.spinner_to_station);

        // Spinner adapter
        fromTrainStationSpinner.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item,
            trainStationNameList));

        toTrainStationSpinner.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item,
            trainStationNameList));

        // Spinner on item click listener
        fromTrainStationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

          @Override
          public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long arg3) {
            selecetdFromStation = trainStationList.get(position);
          }

          @Override
          public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
          }
        });

        toTrainStationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

          @Override
          public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long arg3) {
            selecetdToStation = trainStationList.get(position);
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
