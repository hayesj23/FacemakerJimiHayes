package com.example.facemaker;
/**
 * @author Jimi Hayes
 * acts as the listener to actions and affects instance variables in face
 */

import android.graphics.Color;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

public class FaceController implements Spinner.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener, Button.OnClickListener {
    private Face faceView;
    private SeekBar redSeek;
    private SeekBar greenSeek;
    private SeekBar blueSeek;
    private Spinner hairSpinner;
    public FaceController(Face view, SeekBar red, SeekBar green, SeekBar blue, Spinner hair){
        faceView = view;
        redSeek = red;
        greenSeek = green;
        blueSeek = blue;
        hairSpinner = hair;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        faceView.setHairStyle(i);
        faceView.invalidate();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        //do nothing
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if(i==R.id.hairRadioButton){
            faceView.setActiveButton(0);
        }
        else if(i==R.id.eyesRadioButton){
            faceView.setActiveButton(1);
        }
        else if(i==R.id.skinRadioButton){
            faceView.setActiveButton(2);
        }
        if (faceView.getActiveButton()==0){
            redSeek.setProgress(Color.red(faceView.getHairColor()));
            greenSeek.setProgress(Color.green(faceView.getHairColor()));
            blueSeek.setProgress(Color.blue(faceView.getHairColor()));
        }
        else if (faceView.getActiveButton()==1){
            redSeek.setProgress(Color.red(faceView.getEyeColor()));
            greenSeek.setProgress(Color.green(faceView.getEyeColor()));
            blueSeek.setProgress(Color.blue(faceView.getEyeColor()));
        }
        else if (faceView.getActiveButton()==2){
            redSeek.setProgress(Color.red(faceView.getSkinColor()));
            greenSeek.setProgress(Color.green(faceView.getSkinColor()));
            blueSeek.setProgress(Color.blue(faceView.getSkinColor()));
        }
        faceView.invalidate();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        if(seekBar==redSeek){
            if(faceView.getActiveButton()==0){
                faceView.setHairColor(Color.rgb(i,Color.green(faceView.getHairColor()),Color.blue(faceView.getHairColor())));
            }
            else if(faceView.getActiveButton()==1){
                faceView.setEyeColor(Color.rgb(i,Color.green(faceView.getEyeColor()),Color.blue(faceView.getEyeColor())));
            }
            else{
                faceView.setSkinColor(Color.rgb(i,Color.green(faceView.getSkinColor()),Color.blue(faceView.getSkinColor())));
            }
        }
        else if(seekBar==greenSeek){
            if(faceView.getActiveButton()==0){
                faceView.setHairColor(Color.rgb(Color.red(faceView.getHairColor()),i,Color.blue(faceView.getHairColor())));
            }
            else if(faceView.getActiveButton()==1){
                faceView.setEyeColor(Color.rgb(Color.red(faceView.getEyeColor()),i,Color.blue(faceView.getEyeColor())));
            }
            else{
                faceView.setSkinColor(Color.rgb(Color.red(faceView.getSkinColor()),i,Color.blue(faceView.getSkinColor())));
            }
        }
        else{
            if(faceView.getActiveButton()==0){
                faceView.setHairColor(Color.rgb(Color.red(faceView.getHairColor()),Color.green(faceView.getHairColor()),i));
            }
            else if(faceView.getActiveButton()==1){
                faceView.setEyeColor(Color.rgb(Color.red(faceView.getEyeColor()),Color.green(faceView.getEyeColor()),i));
            }
            else{
                faceView.setSkinColor(Color.rgb(Color.red(faceView.getSkinColor()),Color.green(faceView.getSkinColor()),i));
            }
        }
        faceView.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //do nothing
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //do nothing
    }

    @Override
    public void onClick(View view) {
        faceView.Randomize();
        if (faceView.getActiveButton()==0){
            redSeek.setProgress(Color.red(faceView.getHairColor()));
            greenSeek.setProgress(Color.green(faceView.getHairColor()));
            blueSeek.setProgress(Color.blue(faceView.getHairColor()));
        }
        else if (faceView.getActiveButton()==1){
            redSeek.setProgress(Color.red(faceView.getEyeColor()));
            greenSeek.setProgress(Color.green(faceView.getEyeColor()));
            blueSeek.setProgress(Color.blue(faceView.getEyeColor()));
        }
        else if (faceView.getActiveButton()==2){
            redSeek.setProgress(Color.red(faceView.getSkinColor()));
            greenSeek.setProgress(Color.green(faceView.getSkinColor()));
            blueSeek.setProgress(Color.blue(faceView.getSkinColor()));
        }
        hairSpinner.setSelection(faceView.getHairStyle());
        faceView.invalidate();
    }
}
