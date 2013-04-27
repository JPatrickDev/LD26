package me.jack.ld26.Entity;

import me.jack.ld26.Level.Level;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;

/**
 * Author: Jack
 * Date: 27/04/13
 */
public class EntityTower extends Entity {
    private static Image image;

    private int cX, cY;

    Color[] colors = new Color[]{Color.white,Color.darkGray,Color.blue};
    int pos = 0;

    int shownFor = 0;
    public EntityTower(int x, int y) {
        super(x, y);
    }

    @Override
    public void update(Level level, GameContainer arg0) {
        if(shownFor >= 50){
            shownFor = 0;
            if(pos != colors.length-1){
                pos++;
            }else{
                pos = 0;
            }
        }
    }



    @Override
    public void render(Graphics g) {
        g.setColor(colors[pos]);
        g.fill(shape);
        g.setColor(Color.white);
        shownFor++;
    }

    @Override
    public void spawn() {

        cX = x + (16);
        cY = y + (16);

        this.shape = new Circle(cX,cY,16);
    }

    @Override
    public void collide(Entity e,Level l) {
        if(e == null){
            die(l);
        }
    }
}
