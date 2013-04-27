package me.jack.ld26.Level;

import me.jack.ld26.Entity.Entity;
import me.jack.ld26.Entity.EntityPlayer;
import me.jack.ld26.Entity.EntityPlayerProjectile;
import me.jack.ld26.Entity.EntityTower;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Author: Jack
 * Date: 27/04/13
 */
public class Level {


    CopyOnWriteArrayList<Entity> entitys = new CopyOnWriteArrayList<Entity>();
    Rectangle left = new Rectangle(0,0,16,600);
    Rectangle right = new Rectangle(784,0,16,600);
    Rectangle top = new Rectangle(0,0,800,16);
    Rectangle bottom = new Rectangle(0,584,800,16);
    private EntityPlayer player;

    private EntityTower tower;
    public Level(){

    }

    public void init(){
        player = new EntityPlayer(400,200);
        player.spawn();

        tower =new EntityTower(400-8,300-8);
        tower.spawn();
    }

    public void render(Graphics g){
        tower.render(g);
        for(Entity e : entitys){
            e.render(g);
        }

        player.render(g);
        g.fill(left);
        g.fill(right);
        g.fill(top);
        g.fill(bottom);

    }

    public void update(GameContainer arg0){
        player.update(this,arg0);
        for(Entity e : entitys){
            e.update(this,arg0);
        }
        tower.update(this,arg0);
        System.out.println(entitys.size());
    }

    public boolean canMove(int nX,int nY,Entity move){
        for(Entity e : entitys){
            if(e == move)
                continue;
            if(e instanceof EntityPlayerProjectile && move instanceof EntityPlayerProjectile)
                continue;

            if(move instanceof EntityPlayer && e instanceof EntityPlayerProjectile)
                continue;
            if(e.getShape().intersects(move.getShape())){
                return false;
            }
        }
        if(!(move instanceof EntityPlayer) && !(move instanceof EntityPlayerProjectile)){
            if(move.getShape().intersects(player.getShape()))
                return false;
        }

        if(!(move instanceof EntityTower)){
            if(move.getShape().intersects(tower.getShape()))
                return false;
        }
        if(move.getShape().intersects(left))
            return false;
        if(move.getShape().intersects(right))
            return false;
        if(move.getShape().intersects(top))
            return false;
        if(move.getShape().intersects(bottom))
            return false;

        return true;

    }

    public void addEntity(Entity entity) {
        entitys.add(entity);
        entity.spawn();
        System.out.println("Added new entity: " + entity.getClass().getCanonicalName());
    }

    public void removeEntity(Entity e) {
    entitys.remove(e);
    }
}
