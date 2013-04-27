package me.jack.ld26.Entity;

import me.jack.ld26.Level.Level;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;

/**
 * Author: Jack
 * Date: 27/04/13
 */
public class EntityPlayerProjectile extends Entity{
    private float xSpeed,ySpeed;
    private static final float RADIUS = 8;
    public EntityPlayerProjectile(int x, int y,float xSpeed,float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public void update(Level level,GameContainer arg0) {
        if(level.canMove((int)(x + xSpeed),(int)(y+ySpeed),this)){
        x+=xSpeed;
        y+=ySpeed;
        }
        shape.setX(x);
        shape.setY(y);
    }

    @Override
    public void render(Graphics g) {
        g.fill(shape);
    }

    @Override
    public void spawn() {
        float cX = x + (RADIUS / 2);
        float cY = y + (RADIUS / 2);
        shape = new Circle(cX, cY, RADIUS);

    }

    @Override
    public void collide(Entity e,Level l) {
            if(e == null){
                die(l);
            }
        if(e instanceof EntityTower)
            die(l);
    }
}
