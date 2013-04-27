package me.jack.ld26;

import me.jack.ld26.Entity.EntityPlayer;
import me.jack.ld26.Level.Level;
import me.jack.ld26.States.GameOver;
import me.jack.ld26.States.InGame;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Author: Jack
 * Date: 27/04/13
 */
public class LD26Game extends StateBasedGame {

    public LD26Game(String title) {
        super(title);
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        addState(new InGame());
        addState(new GameOver());
    }

}