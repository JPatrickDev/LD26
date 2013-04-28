package me.jack.ld26.Entity;

import me.jack.ld26.Level.Level;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;

/**
 * Author: Jack
 * Date: 28/04/13
 */
public class DistractionBomb extends Entity{

    float xSpeed,ySpeed;

    public static final float RADIUS=8f;
    public DistractionBomb(int x, int y,float xSpeed,float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed= ySpeed;
    }

    int i = 0;
    @Override
    public void update(Level level, GameContainer arg0) {
        if(i == 20){
            xSpeed = 0;
            ySpeed = 0;
            level.follow = this;
            level.updateFollow();
        }

        if(i == 200){
            level.follow = level.tower;
            level.updateFollow();
            die(level);
        }

        if(i == 0){


        }
        x+=xSpeed;
        y+=ySpeed;

        shape.setX(x);
        shape.setY(y);
        i++;
    }

    @Override
    public void render(Graphics g) {
        g.fill(shape);
    }

    @Override
     public void spawn() {
           this.shape = new Circle(x + RADIUS,y+RADIUS,RADIUS);
     }

    @Override
    public void collide(Entity e, Level level) {
    if(e == null){
        level.follow = level.tower;
        level.updateFollow();
        die(level);
    }
    }
}
