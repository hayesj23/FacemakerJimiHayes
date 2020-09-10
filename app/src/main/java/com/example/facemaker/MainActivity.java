/**
 * @author Jimi Hayes
 */

package com.example.facemaker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner hairstyleSpinner = findViewById(R.id.hairstyleSpinner); //connects spinner to code
        String[] hairstyles = {"Long", "Short", "Medium"}; //sets array for hairstyles
        ArrayAdapter<String> hairAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, hairstyles);//creates array adpapter
        hairstyleSpinner.setAdapter(hairAdapter);//assigns array adapter to spinner
    }
}