package me.jack.ld26.Level;

import me.jack.ld26.Entity.*;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Author: Jack
 * Date: 27/04/13
 */
public class Level {


    CopyOnWriteArrayList<Entity> entitys = new CopyOnWriteArrayList<Entity>();
    Rectangle left = new Rectangle(0, 0, 16, 600);
    Rectangle right = new Rectangle(784, 0, 16, 600);
    Rectangle top = new Rectangle(0, 0, 800, 16);
    Rectangle bottom = new Rectangle(0, 584, 800, 16);
    private EntityPlayer player;

    private EntityTower tower;


    public int towerPower =0;


    public Level() {

    }


    int currentLevel = 0;
  public  int alive = 0;

    Image towerPowerEnd = null;
    Animation towerPowerAnim = null;
    public void init() {
        player = new EntityPlayer(400, 200);
        player.spawn();

        tower = new EntityTower(400 - 8, 300 - 8);
        tower.spawn();
        try {
            towerPowerEnd = new Image("/res/barEnd.png");
            SpriteSheet sheet = new SpriteSheet("/res/barEndAnim.png",10,5);
            towerPowerAnim = new Animation();
            towerPowerAnim.addFrame(sheet.getSprite(0,0),500);
            towerPowerAnim.addFrame(sheet.getSprite(1,0),500);
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    public void render(Graphics g) {

        tower.render(g);
        for (Entity e : entitys) {
            e.render(g);
        }

        player.render(g);
        g.fill(left);
        g.fill(right);
        g.fill(top);
        g.fill(bottom);


        if(towerPower != 100){
            g.setColor(Color.cyan);
            g.fillRect(20, 40, towerPower, 5);
        g.drawImage(towerPowerEnd,20+towerPower,40);
        }else{
            g.setColor(Color.blue);
            g.fillRect(20, 40, towerPower, 5);
        towerPowerAnim.draw(20+towerPower,40);
        }
        g.setColor(Color.white);
    }

    public void update(GameContainer arg0) {

        player.update(this, arg0);
        for (Entity e : entitys) {
            e.update(this, arg0);
        }
      tower.update(this, arg0);

        checkLevel(arg0);

    }

    public void checkLevel(GameContainer arg0) {
        if (alive == 0) {
            currentLevel++;
            spawn(arg0);
        }
    }

    private void spawn(GameContainer arg0) {
        int toSpawn = currentLevel * 2;
        int x = 16;
        int y = 36;

        int eachSide = toSpawn / 4;

        int w = eachSide * 34;

        x = (arg0.getWidth() / 2) - (w / 2);

        for (int i = 0; i <= toSpawn; i++) {
            x = new Random().nextInt(700) + 16;
            y = new Random().nextInt(500) + 16;
            addEntity(new BasicEnemy(x, y, (int) tower.getX() + 16, (int) tower.getY() + 16));
            alive++;
        }
    }


    public boolean canMove(int nX, int nY, Entity move) {

        for (Entity e : entitys) {
            if (e == move)
                continue;
            if (e instanceof EntityPlayerProjectile && move instanceof EntityPlayerProjectile)
                continue;
            if (move instanceof EntityPlayer && e instanceof EntityPlayerProjectile)
                continue;
            if (move instanceof BasicEnemy && e instanceof BasicEnemy) {
                continue;
            }
            if (e.getShape().intersects(move.getShape())) {
                move.collide(e, this);
                return false;
            }
        }
        if (!(move instanceof EntityPlayer) && !(move instanceof EntityPlayerProjectile)) {
            if (move.getShape().intersects(player.getShape())) {
                move.collide(player, this);
                return false;
            }
        }

        if (!(move instanceof EntityTower) && !(move instanceof EntityPlayerProjectile)) {
            if (move.getShape().intersects(tower.getShape())) {
                move.collide(tower, this);
                return false;
            }
        }
        if (move.getShape().intersects(left)) {
            move.collide(null, this);
            return false;
        }
        if (move.getShape().intersects(right)) {
            move.collide(null, this);
            return false;
        }
        if (move.getShape().intersects(top)) {
            move.collide(null, this);
            return false;
        }
        if (move.getShape().intersects(bottom)) {
            move.collide(null, this);
            return false;
        }


        return true;

    }

    public void addEntity(Entity entity) {
        entitys.add(entity);
        entity.spawn();
    }

    public void removeEntity(Entity e) {
        entitys.remove(e);
    }
}
