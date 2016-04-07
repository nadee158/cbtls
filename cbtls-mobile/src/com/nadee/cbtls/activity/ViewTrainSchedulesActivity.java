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
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.nadee.cbtls.R;
import com.nadee.cbtls.adapter.TrainStationScheduleListAdapter;
import com.nadee.cbtls.dto.TrainScheduleSearchDTO;
import com.nadee.cbtls.dto.TrainStationScheduleDTO;
import com.nadee.cbtls.util.JSONParser;
import com.nadee.cbtls.util.JSONToDTOConverter;

public class ViewTrainSchedulesActivity extends Activity {

  private static String BASE_URL;
  private static final String TRAIN_SCHEDULE_URL = "searchTrainSchedules.json";

  TrainScheduleSearchDTO trainScheduleSearchDTO;

  JSONArray trainScheduleList = null;
  ArrayList<TrainStationScheduleDTO> scheduleList;

  private Context context;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_view_train_schedules);
    setTitle("Train Schedule List - CBTLS");
    BASE_URL = getString(R.string.base_app_url);
    Bundle extras = getIntent().getExtras();
    context = this;
    if (extras != null) {
      trainScheduleSearchDTO = (TrainScheduleSearchDTO) extras.get("TRAIN_SCHEDULE_SEARCH_DTO");

    }
    TextView textViewStationTitle = (TextView) findViewById(R.id.textView_StationTitle);
    String stationTitle = trainScheduleSearchDTO.getFromStationName() + " - " + trainScheduleSearchDTO.getToStationName();
    textViewStationTitle.setText(stationTitle);

    TextView textViewSearchType = (TextView) findViewById(R.id.textView_SearchType);
    textViewSearchType.setText(trainScheduleSearchDTO.getSearchTypeText());

    TextView textViewTimeTitle = (TextView) findViewById(R.id.textView_TimeTitle);
    String timeTitle =
        "(From " + trainScheduleSearchDTO.getFromTime() + "to " + trainScheduleSearchDTO.getToTime() + " On "
            + trainScheduleSearchDTO.getSearchedDate() + ")";
    textViewTimeTitle.setText(timeTitle);

    Button button = (Button) findViewById(R.id.btn_search_again);
    button.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        intent.putExtra("TRAIN_SCHEDULE_SEARCH_DTO", trainScheduleSearchDTO);
        startActivity(intent);
        ViewTrainSchedulesActivity.this.finish();

      }
    });

    Button button1 = (Button) findViewById(R.id.btn_view_recommendations);
    button1.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(getBaseContext(), ViewRecommendationActivity.class);
        intent.putExtra("TRAIN_SCHEDULE_SEARCH_DTO", trainScheduleSearchDTO);
        startActivity(intent);
        ViewTrainSchedulesActivity.this.finish();
      }
    });


    new SearchTrainSchedulesJSON().execute();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.view_train_schedules, menu);
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

  private class SearchTrainSchedulesJSON extends AsyncTask<String, String, JSONArray> {
    private ProgressDialog pDialog;

    @Override
    protected void onPreExecute() {
      super.onPreExecute();
      pDialog = new ProgressDialog(ViewTrainSchedulesActivity.this);
      pDialog.setMessage("Getting Data ...");
      pDialog.setIndeterminate(false);
      pDialog.setCancelable(true);
      pDialog.show();
      scheduleList = new ArrayList<TrainStationScheduleDTO>();

    }

    @Override
    protected JSONArray doInBackground(String... args) {
      JSONParser jParser = new JSONParser();
      // Getting JSON from URL
      JSONArray json = jParser.postJSONArrayFromUrl(BASE_URL + TRAIN_SCHEDULE_URL, trainScheduleSearchDTO);
      return json;
    }

    @Override
    protected void onPostExecute(JSONArray jsonArray) {
      pDialog.dismiss();
      try {
        // Getting JSON Array from URL
        trainScheduleList = jsonArray;
        for (int i = 0; i < trainScheduleList.length(); i++) {

          JSONObject c = trainScheduleList.getJSONObject(i);

          TrainStationScheduleDTO trainStationScheduleDTO = JSONToDTOConverter.convertToTrainStationScheduleDTO(c);
          scheduleList.add(trainStationScheduleDTO);

        }

        ListView customListView = (ListView) findViewById(R.id.list_train_schedule);
        // get data from the table by the ListAdapter
        ListAdapter customAdapter = new TrainStationScheduleListAdapter(context, R.layout.listview_train_schedule, scheduleList);
        customListView.setAdapter(customAdapter);
        customListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(context, "You Clicked at " + scheduleList.get(+position).getTrainStationScheduleId(), Toast.LENGTH_SHORT).show();

          }
        });

      } catch (JSONException e) {
        e.printStackTrace();
      }

    }
  }

}
