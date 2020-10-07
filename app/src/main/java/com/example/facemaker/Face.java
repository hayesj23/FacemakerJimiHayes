/**
 * @author Jimi Hayes
 *
 * models the face and draws the face on the screen. Is the surfaceView in the app
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

public class Face extends SurfaceView{
    private int skinColor;
    private int eyeColor;
    private int hairColor;
    private int hairStyle;
    private int activeButton;//0=hair, 1=eyes, 2=skin

    private Paint headPaint = new Paint();
    private Paint eyePaint = new Paint();
    private Paint hairPaint = new Paint();
    private Paint whitePaint = new Paint();
    private Paint redPaint = new Paint();

    //constructor
    public Face(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        Randomize();
        headPaint.setColor(skinColor);
        eyePaint.setColor(eyeColor);
        hairPaint.setColor(hairColor);
        whitePaint.setColor(Color.WHITE);
        activeButton=-1;
        setBackgroundColor(Color.WHITE);
    }
    /**External Citation
     * Date:  6 October 2020
     * Problem:  had android error at run time due to forgotten public
     * Resource: Dr. Nuxoll
     * Solution: included public.*/
    //instantiates variables to random values
    void Randomize(){
        skinColor = android.graphics.Color.argb(255, (int)(256*(Math.random())),(int)(256*(Math.random())), (int)(256*(Math.random())));
        eyeColor  = android.graphics.Color.argb(255, (int)(256*(Math.random())),(int)(256*(Math.random())), (int)(256*(Math.random())));
        hairColor  = android.graphics.Color.argb(255, (int)(256*(Math.random())),(int)(256*(Math.random())), (int)(256*(Math.random())));
        hairStyle = (int)(3*(Math.random()));
    }

    /**External Citation
     * Date:  9 September 2020
     * Problem:  Did not know how to represent a color as an int
     * Resource: https://stackoverflow.com/questions/18022364/how-to-convert-rgb-color-to-int-in-java
     * Solution: I used the example code from this post.*/
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onDraw(Canvas canvas){
        float width = canvas.getWidth();
        float height = canvas.getHeight();
        headPaint.setColor(skinColor);
        eyePaint.setColor(eyeColor);
        hairPaint.setColor(hairColor);
        whitePaint.setColor(Color.WHITE);
        redPaint.setColor(Color.RED);
        drawHair(canvas, width, height);
        canvas.drawOval(100.0f, 100.0f, width-100.0f, width-100.0f, headPaint);
        drawEyes(canvas, width);
        drawMouth(canvas, width);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void drawHair(Canvas canvas, float width, float height){
        if (hairStyle==2){
            //bald, do nothing
        }
        else if (hairStyle==1){
            canvas.drawOval(80.0f, 100.0f, width-80.0f, height-80.0f, hairPaint);
        }
        else {
            canvas.drawOval(80.0f, 100.0f, width-80.0f, height+50.0f, hairPaint);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void drawEyes(Canvas canvas, float width){
        canvas.drawOval(300.0f, 300.0f, 600.0f, 600.0f, whitePaint);
        canvas.drawOval(width-600.0f, 300.0f, width-300.0f, 600.0f, whitePaint);
        canvas.drawOval(350.0f, 350.0f, 550.0f, 550.0f, eyePaint);
        canvas.drawOval(width-550.0f,350.0f, width-350.0f, 550.0f, eyePaint);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void drawMouth(Canvas canvas, float width){
        canvas.drawArc(150.0f, 300.0f, width-150.0f, width-150.0f, 180, -180,false,redPaint);
    }

    public int getActiveButton() {
        return activeButton;
    }

    public int getEyeColor() {
        return eyeColor;
    }

    public int getHairColor() {
        return hairColor;
    }

    public int getHairStyle() {
        return hairStyle;
    }

    public int getSkinColor() {
        return skinColor;
    }

    public void setActiveButton(int activeButton) {
        this.activeButton = activeButton;
    }

    public void setEyeColor(int eyeColor) {
        this.eyeColor = eyeColor;
    }

    public void setHairColor(int hairColor) {
        this.hairColor = hairColor;
    }

    public void setHairStyle(int hairStyle) {
        this.hairStyle = hairStyle;
    }

    public void setSkinColor(int skinColor) {
        this.skinColor = skinColor;
    }

}
