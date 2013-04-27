package me.jack.ld26.Entity;

import me.jack.ld26.Level.Level;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

/**
 * Author: Jack
 * Date: 27/04/13
 */
public class BasicEnemy extends Entity{

    int tx,ty;
    public BasicEnemy(int x, int y,int tx,int ty) {
        super(x, y);

        this.tx = tx;
        this.ty = ty;
    }

    @Override
    public void update(Level level, GameContainer arg0) {
        int xMove = 0;
        int yMove = 0;
        if(x > tx){
            xMove = -1;
        }
        else if(x < tx){
            xMove = +1;
        }

        if(y > ty){
            yMove = -1;
        }else if(y < ty){
            yMove = +1;
        }
        if(level.canMove((int)(x + yMove),(int)(y+yMove),this)){
            x+=xMove;
            y+=yMove;
        }
        shape.setX(x);
        shape.setY(y);

    }

    @Override
    public void render(Graphics g) {
            g.fill(shape);
        g.setColor(Color.black);
        g.fillRect(tx,ty,1,1);
        g.setColor(Color.white);
    }

    @Override
    public void spawn() {
            shape = new Rectangle(x,y,16,16);
    }

    @Override
    public void collide(Entity e,Level l) {
        if(e == null){
            die(l);
        }
        if(e instanceof EntityTower)
            die(l);

        if(e instanceof  EntityPlayerProjectile)
            die(l);
    }
}
