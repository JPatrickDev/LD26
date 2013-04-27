package me.jack.ld26.Level;

import me.jack.ld26.Entity.*;
import me.jack.ld26.Utils;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

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

    public Level() {

    }


    int currentLevel = 0;
    int alive = 0;

    public void init() {
        player = new EntityPlayer(400, 200);
        player.spawn();

        tower = new EntityTower(400 - 8, 300 - 8);
        tower.spawn();
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
        int toSpawn = 30;
        int x = 16;
        int y = 36;
        for (int i = 0; i != toSpawn; i++) {
            addEntity(new BasicEnemy(x, y,(int)tower.getX() + 16,(int)tower.getY() + 16));
            x += 34;
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
            if(move instanceof  BasicEnemy && e instanceof BasicEnemy)
                continue;
            if (e.getShape().intersects(move.getShape())) {
                return false;
            }
        }
        if (!(move instanceof EntityPlayer) && !(move instanceof EntityPlayerProjectile)) {
            if (move.getShape().intersects(player.getShape()))
                return false;
        }

        if (!(move instanceof EntityTower)) {
            if (move.getShape().intersects(tower.getShape()))
                return false;
        }
        if (move.getShape().intersects(left))
            return false;
        if (move.getShape().intersects(right))
            return false;
        if (move.getShape().intersects(top))
            return false;
        if (move.getShape().intersects(bottom))
            return false;

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
