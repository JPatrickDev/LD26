package me.jack.ld26;

import me.jack.ld26.Entity.EntityPlayer;
import me.jack.ld26.Level.Level;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;

/**
 * Author: Jack
 * Date: 27/04/13
 */
public class LD26Game extends BasicGame{

    public LD26Game(String title) {
        super(title);
    }


    Level level = new Level();
    Image bg = null;
    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        level.init();
        bg = new Image("/res/bg.png");
    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
        level.update(gameContainer);
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.drawImage(bg,0,0);
        level.render(graphics);
    }
}
