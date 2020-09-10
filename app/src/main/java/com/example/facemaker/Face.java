/**
 * @author Jimi Hayes
 */

package com.example.facemaker;

public class Face {
    int skinColor;
    int eyeColor;
    int hairColor;
    int hairStyle;

    //constructor
    Face() {
        Randomize();
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
}
