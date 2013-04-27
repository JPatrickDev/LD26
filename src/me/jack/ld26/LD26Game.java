package me.jack.ld26;

import me.jack.ld26.Entity.EntityPlayer;
import me.jack.ld26.Level.Level;
import org.newdawn.slick.*;

/**
 * Author: Jack
 * Date: 27/04/13
 */
public class LD26Game extends BasicGame{

    public LD26Game(String title) {
        super(title);
    }

    EntityPlayer player = null;
    Level level = new Level();
    @Override
    public void init(GameContainer gameContainer) throws SlickException {
    player = new EntityPlayer(400,300);
        player.spawn();
    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
        player.update();
        level.update();
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
    player.render(graphics);
        level.render(graphics);
    }
}
