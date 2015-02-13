package com.lk.rspinnerhint;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Arrays;


public class MainActivity extends ActionBarActivity {
    private Spinner mSpinnerCountry;
    private RSpinnerAdapter mAdapterCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
        mAdapterCountry = new RSpinnerAdapter(this, R.layout.spinner_item, Arrays.asList(getResources().getStringArray(R.array.countryArray)));
        mAdapterCountry.setDropDownViewResource(R.layout.spinner_dropdown);
        mSpinnerCountry.setAdapter(mAdapterCountry);
    }

    private void initViews() {
        setContentView(R.layout.activity_main);
        mSpinnerCountry = (Spinner) findViewById(R.id.spinner);
        mSpinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    final String selectedItem = mAdapterCountry.getItem(position);
                    Toast.makeText(MainActivity.this, String.format("You have selected %1d. %2s", position, selectedItem), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
