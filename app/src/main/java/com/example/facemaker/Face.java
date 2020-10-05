/**
 * @author Jimi Hayes
 */

package com.example.facemaker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

import androidx.annotation.RequiresApi;

import java.text.AttributedCharacterIterator;

public class Face extends SurfaceView implements Spinner.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener {
    int skinColor;
    int eyeColor;
    int hairColor;
    int hairStyle;
    int activeButton;//0=hair, 1=eyes, 2=skin

    Paint headPaint = new Paint();
    Paint eyePaint = new Paint();
    Paint hairPaint = new Paint();
    Paint mouthPaint = new Paint();

    //constructor
    Face(Context context, AttributeSet attrs) {
        super(context, attrs);
        Randomize();
        headPaint.setColor(skinColor);
        eyePaint.setColor(eyeColor);
        hairPaint.setColor(hairColor);
        mouthPaint.setColor(Color.RED);
        activeButton=0;
    }
    //instantiates variables to random values
    void Randomize(){
        skinColor = android.graphics.Color.argb(255, (int)(256*(Math.random())),(int)(256*(Math.random())), (int)(256*(Math.random())));
        eyeColor  = android.graphics.Color.argb(255, (int)(256*(Math.random())),(int)(256*(Math.random())), (int)(256*(Math.random())));
        hairColor  = android.graphics.Color.argb(255, (int)(256*(Math.random())),(int)(256*(Math.random())), (int)(256*(Math.random())));
        hairStyle = (int)(4*(Math.random()));
    }

    /**External Citation
     * Date:  9 September 2020
     * Problem:  Did not know how to represent a color as an int
     * Resource: https://stackoverflow.com/questions/18022364/how-to-convert-rgb-color-to-int-in-java
     * Solution: I used the example code from this post.*/
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onDraw(Canvas canvas){
    canvas.drawOval(100.0f, 100.0f, 600.0f, 800.0f, headPaint);
    }

    public void DrawHair(Canvas canvas){

    }

    public void DrawEyes(Canvas canvas){

    }

    public void DrawMouth(Canvas canvas){

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        hairStyle = i;
        this.invalidate();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        //do nothing
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if(i==R.id.hairRadioButton){
            activeButton=0;
        }
        else if(i==R.id.eyesRadioButton){
            activeButton=1;
        }
        else{
            activeButton=2;
        }
        this.invalidate();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        if(seekBar==findViewById(R.id.redSeekBar)){
            if(activeButton==0){
                hairColor=Color.rgb(i,Color.green(hairColor),Color.blue(hairColor));
            }
            else if(activeButton==1){
                eyeColor=Color.rgb(i,Color.green(eyeColor),Color.blue(eyeColor));
            }
            else{
                skinColor=Color.rgb(i,Color.green(skinColor),Color.blue(skinColor));
            }
        }
        else if(seekBar==findViewById(R.id.greenSeekBar)){
            if(activeButton==0){
                hairColor=Color.rgb(Color.red(hairColor),i,Color.blue(hairColor));
            }
            else if(activeButton==1){
                eyeColor=Color.rgb(Color.red(eyeColor),i,Color.blue(eyeColor));
            }
            else{
                skinColor=Color.rgb(Color.red(skinColor),i,Color.blue(skinColor));
            }
        }
        else{
            if(activeButton==0){
                hairColor=Color.rgb(Color.red(hairColor),Color.green(hairColor),i);
            }
            else if(activeButton==1){
                eyeColor=Color.rgb(Color.red(eyeColor),Color.green(eyeColor),i);
            }
            else{
                skinColor=Color.rgb(Color.red(skinColor),Color.green(skinColor),i);
            }
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //do nothing
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //do nothing
    }
}
