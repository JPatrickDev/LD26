package me.jack.ld26.Entity;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;

/**
 * Author: Jack
 * Date: 27/04/13
 */
public abstract class Entity {

    protected int x,y;
    protected Shape shape;
    protected int xVelocity,yVelocity;

    public Entity(int x,int y){
        this.x = x;
        this.y = y;
    }

    public abstract void update();
    public abstract void render(Graphics g);
    public abstract void spawn();

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public Shape getShape(){
        return this.shape;
    }
}
