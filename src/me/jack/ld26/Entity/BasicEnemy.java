package me.jack.ld26.Entity;

import me.jack.ld26.Level.Level;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;

/**
 * Author: Jack
 * Date: 27/04/13
 */
public class BasicEnemy extends Entity {

    int tx, ty;

    boolean followingPlayer = false;

    public BasicEnemy(int x, int y, int tx, int ty, Entity follow) {
        super(x, y);

        this.tx = tx;
        this.ty = ty;
        this.following = follow;

    }


    public Entity following = null;

    boolean thisTurn = true;
    @Override
    public void update(Level level, GameContainer arg0) {
        if(followingPlayer && !(following instanceof EntityPlayer) ){
            following = level.player;
        }

        if(!followingPlayer && following instanceof EntityPlayer){
           following = level.tower;
        }

        tx = (int) following.getShape().getCenterX();
        ty = (int) following.getShape().getCenterY();

        int xMove = 0;
        int yMove = 0;
        int moveSpeed = 1;
        if (level.slow){
           if(!thisTurn){
               thisTurn = true;
               return;
           }
            else{
               thisTurn = false;
           }
        }else{
            thisTurn = true;
        }

        if (x > tx) {
            xMove = -moveSpeed;
        } else if (x < tx) {
            xMove = +moveSpeed;
        }

        if (y > ty) {
            yMove = -moveSpeed;
        } else if (y < ty) {
            yMove = +moveSpeed;
        }
        if (level.canMove((int) (x + yMove), (int) (y + yMove), this)) {
            x += xMove;
            y += yMove;
        }

        shape.setX(x);
        shape.setY(y);
    }




    @Override
    public void render(Graphics g) {
        g.fill(shape);
        g.setColor(Color.black);
        g.fillRect(tx, ty, 1, 1);
        g.setColor(Color.white);
    }

    @Override
    public void spawn() {
        shape = new Rectangle(x, y, 16, 16);
    }

    @Override
    public void collide(Entity e, Level l) {
        if (e == null) {
            die(l);
        }
        if (e instanceof EntityTower) {
            l.tower.health -= 5;
            die(l);
        }

        if (e instanceof EntityPlayer) {
            l.player.health -= 5;
            die(l);
        }
     /*   if (e instanceof EntityPlayerProjectile) {
            if (l.towerPower >= 100) {
                l.towerPower = 100;
            } else
                l.towerPower += 2;
            l.money += 5;
            die(l);
        }*/
    }
}
