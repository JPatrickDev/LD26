package me.jack.ld26;

import org.newdawn.slick.geom.Vector2f;

/**
 * Author: Jack
 * Date: 27/04/13
 */
public class Utils {


    public static Vector2f getSpeed(int tX,int cX,int tY,int cY,int m){
        float xSpeed = tX - cX;
        float ySpeed = tY - cY;
        float factor = (float)(m/Math.sqrt(xSpeed * xSpeed + ySpeed*ySpeed));
        xSpeed = xSpeed * factor;
        ySpeed = ySpeed*factor;
        Vector2f vector = new Vector2f();
        vector.set(xSpeed,ySpeed);
        return vector;
    }


}
