package com.nadee.cbtls.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

import com.nadee.cbtls.R;
import com.nadee.cbtls.fragment.DatePickerFragment;
import com.nadee.cbtls.fragment.TimePickerFragment;


public class MainActivity extends FragmentActivity {
	
	private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;
        initializeControllers();
    }
    
    private void initializeControllers() {
		Button pickADate=(Button) findViewById(R.id.btn_pick_a_date);
		pickADate.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				showDatePickerDialog(v);
			}
		});
		
		Button fromTime=(Button) findViewById(R.id.btn_from_time);
		fromTime.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				showTimePickerDialog(v);
			}
		});
		
		Button toTime=(Button) findViewById(R.id.btn_to_time);
		toTime.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				showTimePickerDialog(v);
			}
		});
		
		Button showAdvancedFilter=(Button) findViewById(R.id.btn_advanced_filter);
		showAdvancedFilter.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				showHideAdvancedFilter(v);
			}
		});
		
		
		
	}
    
    private void showHideAdvancedFilter(View v) {
		LinearLayout linearLayout=(LinearLayout) findViewById(R.id.linearLayout_Advanced_Filter);
		Button showAdvancedFilter=(Button) v;
		if (linearLayout.getVisibility() == View.VISIBLE) {
			linearLayout.setVisibility(View.GONE);
			showAdvancedFilter.setText(R.string.show_advanced_filter);
		} else {
			linearLayout.setVisibility(View.VISIBLE);
			showAdvancedFilter.setText(R.string.hide_advanced_filter);
		}
		
		
	}

	public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }
    
    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

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
}
