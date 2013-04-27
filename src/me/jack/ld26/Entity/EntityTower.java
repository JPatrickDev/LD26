package me.jack.ld26.Entity;

import me.jack.ld26.Level.Level;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

/**
 * Author: Jack
 * Date: 27/04/13
 */
public class EntityTower extends Entity {
    private static Image image;

    private int cX, cY;

    public EntityTower(int x, int y) {
        super(x, y);
    }

    @Override
    public void update(Level level, GameContainer arg0) {

    }



    @Override
    public void render(Graphics g) {
        g.drawImage(image, x, y);
    }

    @Override
    public void spawn() {
        if (image == null) {
            try {
                image = new Image("/res/tower.png");
            } catch (SlickException e) {
                e.printStackTrace();
            }
        }

        cX = x + (16);
        cY = y + (16);

        this.shape = new Rectangle(x, y, 32, 32);
    }

    @Override
    public void collide(Entity e,Level l) {
        if(e == null){
            die(l);
        }
    }
}
