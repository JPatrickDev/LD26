package me.jack.ld26.Entity;

import me.jack.ld26.Level.Level;
import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

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
    public void update(Level level) {
        handleInput(level);
        if (xVelocity != 0) {
            if (xVelocity > 0) {
                if(level.canMove(x+2,y,this)){
                xVelocity--;
                x+=2;
                }else{
                    xVelocity = 0;
                    x-=2;
                }
            } else {
                if(level.canMove(x-2,y,this)){
                xVelocity++;
                x-=2;
                }else{
                    xVelocity = 0;
                    x+=2;
                }
            }
        }
        if (yVelocity != 0) {
            if (yVelocity > 0) {
                if(level.canMove(x,y+2,this)){
                y+=2;
                yVelocity--;
                }else{
                    yVelocity = 0;
                    y-=2;
                }
            } else {
                if(level.canMove(x,y-2,this)){
                y-=2;
               yVelocity++;
                }else{
                    yVelocity = 0;
                    y+=2;
                }
            }
        }
        shape.setX(x);
        shape.setY(y);

    }


    private void handleInput(Level level) {
        if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
            yVelocity = -5;
        }

        if(Keyboard.isKeyDown(Keyboard.KEY_A)){
            xVelocity = -5;
        }

        if(Keyboard.isKeyDown(Keyboard.KEY_S)){
            yVelocity = +5;
        }

        if(Keyboard.isKeyDown(Keyboard.KEY_D)){
            xVelocity = +5;
        }
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
}
