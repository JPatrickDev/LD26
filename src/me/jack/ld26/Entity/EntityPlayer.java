package me.jack.ld26.Entity;

import me.jack.ld26.Level.Level;
import me.jack.ld26.Utils;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

/**
 * Author: Jack
 * Date: 27/04/13
 */
public class EntityPlayer extends Entity {


    private static final float RADIUS = 16;

    public EntityPlayer(int x, int y) {
        super(x, y);
    }

    @Override
    public void update(Level level,GameContainer arg0) {
        handleInput(level,arg0);
        shape.setX(x);
        shape.setY(y);

    }

    long lastShot = 0;
    long shotDelay = 100;
    private void handleInput(Level level,GameContainer arg0) {
        int xa = 0;
        int ya = 0;

        boolean up = false;
        boolean dir = false;
        if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
            move(0,-1,level);
            move(0,-1,level);
        }

        if(Keyboard.isKeyDown(Keyboard.KEY_A)){
            move(-1,0,level);
            move(-1,0,level);
        }

        if(Keyboard.isKeyDown(Keyboard.KEY_S)){
            move(0,1,level);
            move(0,1,level);
        }

        if(Keyboard.isKeyDown(Keyboard.KEY_D)){
        move(1,0,level);
            move(1,0,level);
        }


    if(!canShoot())
        return;
        Input i = arg0.getInput();
        if(Mouse.isButtonDown(0)){
            int mX = i.getMouseX();
            int mY = i.getMouseY();
            Vector2f speed= Utils.getSpeed(mX,x,mY,y,9);
            level.addEntity(new EntityPlayerProjectile(x,y,speed.getX(),speed.getY()));


        }
    }

    private void move(int xa,int ya,Level level){
        if(level.canMove(x+xa,y+ya,this)){
            x+=xa;
            y+=ya;
        }
    }
    public boolean canShoot(){
        if(lastShot == 0){
            lastShot = System.currentTimeMillis();
            return true;
        }
        long current = System.currentTimeMillis();
        long diff = Math.abs(current - lastShot);
        if(diff >=shotDelay){
            lastShot = System.currentTimeMillis();
            return true;
        }

        return false;

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

    }
}
