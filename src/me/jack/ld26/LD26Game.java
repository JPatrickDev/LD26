package me.jack.ld26;

import me.jack.ld26.Entity.EntityPlayer;
import me.jack.ld26.Level.Level;
import me.jack.ld26.States.*;
import org.lwjgl.input.Mouse;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;

import java.awt.Font;

/**
 * Author: Jack
 * Date: 27/04/13
 */
public class LD26Game extends StateBasedGame {

    public LD26Game(String title) {
        super(title);
    }

    public static TrueTypeFont font;
    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        Font f = new Font("Calibri",Font.PLAIN,34);
        font = new TrueTypeFont(f,false);

        addState(new DifficultySelectState());
        addState(new IntroState());
        addState(new InGame());
        addState(new GameOver());
        addState(new ShopState());
    }

}