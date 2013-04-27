package me.jack.ld26.Powerup;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Author: Jack
 * Date: 27/04/13
 */
public class PowerUpSlot {
    Image image;
   public Powerup p;
    public PowerUpSlot(String res,Powerup p ){
        try {
            image = new Image(res);
            this.p = p;
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics g,int x,int y){
        g.drawImage(image,x,y);
    }
}
