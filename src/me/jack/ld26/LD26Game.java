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
    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        level.init();
    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
        level.update(gameContainer);
        if(Mouse.isButtonDown(0)){
            System.out.println(gameContainer.getInput().getMouseX() + " " + gameContainer.getInput().getMouseY());
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        level.render(graphics);
    }
}
