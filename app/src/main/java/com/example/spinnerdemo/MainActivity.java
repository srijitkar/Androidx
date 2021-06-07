package com.example.spinnerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button Button_Search;
    Spinner Spin_Weekday;
    String [] weeks = {"Days","Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button_Search =findViewById(R.id.Button_Search);
        Spin_Weekday =findViewById(R.id.Spin_Weekday);

        ArrayAdapter<String> obj =new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item,weeks);
        Spin_Weekday.setAdapter(obj);

        Spin_Weekday.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item=weeks[position];
                Toast.makeText(MainActivity.this,item,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Button_Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://google.com"));
                startActivity(i);
            }
        });
    }
}