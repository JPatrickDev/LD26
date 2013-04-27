package me.jack.ld26.Entity;

import me.jack.ld26.Level.Level;
import org.newdawn.slick.GameContainer;
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

    private boolean dead = false;
    public Entity(int x,int y){
        this.x = x;
        this.y = y;
    }

    public abstract void update(Level level,GameContainer arg0);
    public abstract void render(Graphics g);
    public abstract void spawn();
    public abstract void collide(Entity e,Level l);

    public void die(Level e){
            dead= true;
            e.removeEntity(this);
        if(this instanceof BasicEnemy){
            e.alive--;
        }
    }

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
