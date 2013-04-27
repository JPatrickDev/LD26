package me.jack.ld26.Entity;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Author: Jack
 * Date: 27/04/13
 */
public class EntityTower extends Entity{
    private static Image image;

    private int cX,cY;
    public EntityTower(int x, int y) {
        super(x, y);
    }

    @Override
    public void update() {
angle+=1;
    }

    float angle = 0;
    @Override
    public void render(Graphics g) {
        g.rotate(cX,cY,angle);
        g.drawImage(image,x,y);
        g.resetTransform();
    }

    @Override
    public void spawn() {
       if(image == null){
           try {
               image = new Image("/res/tower.png");
           } catch (SlickException e) {
               e.printStackTrace();
           }
       }

        cX = x + (16);
        cY = y+ (16);
    }
}
