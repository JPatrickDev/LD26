package me.jack.ld26.Level;

import me.jack.ld26.Entity.Entity;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

import java.util.ArrayList;

/**
 * Author: Jack
 * Date: 27/04/13
 */
public class Level {


    ArrayList<Entity> entitys = new ArrayList<Entity>();
    Rectangle left = new Rectangle(0,0,16,600);
    Rectangle right = new Rectangle(784,0,16,600);
    Rectangle top = new Rectangle(0,0,800,16);
    Rectangle bottom = new Rectangle(0,584,800,16);
    public Level(){

    }


    public void render(Graphics g){
        for(Entity e : entitys){
            e.render(g);
        }
        g.fill(left);
        g.fill(right);
        g.fill(top);
        g.fill(bottom);

    }

    public void update(){
        for(Entity e : entitys){
            e.update();
        }
    }
}
