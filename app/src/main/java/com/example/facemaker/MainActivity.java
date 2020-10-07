/**
 * @author Jimi Hayes
 */

package com.example.facemaker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar red = findViewById(R.id.redSeekBar);
        SeekBar blue = findViewById(R.id.blueSeekBar);
        SeekBar green = findViewById(R.id.greenSeekBar);
        Spinner hairstyleSpinner = findViewById(R.id.hairstyleSpinner); //connects spinner to code
        Face face = findViewById(R.id.faceView);
        FaceController controller = new FaceController(face, red, green, blue, hairstyleSpinner);
        String[] hairstyles = {"Long", "Short", "Bald"}; //sets array for hairstyles
        ArrayAdapter<String> hairAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, hairstyles);//creates array adpapter
        hairstyleSpinner.setAdapter(hairAdapter);//assigns array adapter to spinner
        hairstyleSpinner.setOnItemSelectedListener(controller);
        RadioGroup selectorGroup = findViewById(R.id.hesGroup);
        selectorGroup.setOnCheckedChangeListener(controller);
        Button randomButton = findViewById(R.id.randomizeFaceButton);
        randomButton.setOnClickListener(controller);
        red.setOnSeekBarChangeListener(controller);
        green.setOnSeekBarChangeListener(controller);
        blue.setOnSeekBarChangeListener(controller);
    }
}