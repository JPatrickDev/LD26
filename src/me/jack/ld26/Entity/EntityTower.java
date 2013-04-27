package me.jack.ld26.Entity;

import me.jack.ld26.Level.Level;
import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Transform;
import org.newdawn.slick.svg.RadialGradientFill;

import java.util.Random;

/**
 * Author: Jack
 * Date: 27/04/13
 */
public class EntityTower extends Entity {
    private static Image image;

    private int cX, cY;

    Color[] colors = new Color[]{Color.white, Color.darkGray, Color.blue};
    int pos = 0;

    int shownFor = 0;

    boolean AOE = false;
    float AOERadius = 0.0f;
    public Circle AOEShape = null;
    Color color = null;
    public EntityTower(int x, int y) {
        super(x, y);
        color = new Color(0,255,33,128);
    }

    @Override
    public void update(Level level, GameContainer arg0) {
        if (shownFor >= 50) {
            shownFor = 0;
            if (pos != colors.length - 1) {
                pos++;
            } else {
                pos = 0;
            }
        }
        if (AOE) {
            if (AOEShape == null) {
                AOERadius = 4.0f;
                AOEShape = new Circle(this.getShape().getCenterX(), this.getShape().getCenterY(), AOERadius);

            }else{
                AOERadius+=4f;
                AOEShape.setRadius(AOERadius);
                AOEShape.setCenterX(this.getShape().getCenterX());
                AOEShape.setCenterY(this.getShape().getCenterY());
            }

            if(AOERadius >= 300){
                AOE = false;
                AOEShape = null;
                AOERadius = 0.0f;
            }

            for(Entity e : level.entitys){
                if(AOEShape == null)
                    break;
                if(e.getShape().intersects(AOEShape)){
                    e.die(level);
                }
            }
        }

        if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
           if(level.towerPower == 100){
                level.towerPower = 0;
                AOE = true;
           }
        }
    }


    @Override
    public void render(Graphics g) {
        g.setColor(colors[pos]);
        g.fill(shape);
        g.setColor(Color.white);
        shownFor++;
        if (AOE) {
            if(AOEShape != null){
                if(new Random().nextInt(500) != 5)
                g.setColor(color);
                  g.fill(AOEShape);
                g.setColor(Color.white);

            }
        }
    }

    @Override
    public void spawn() {
        cX = x + (16);
        cY = y + (16);
        this.shape = new Circle(cX, cY, 16);
    }

    @Override
    public void collide(Entity e, Level l) {
        if (e == null) {
            die(l);
        }
    }
}
