package me.jack.ld26.States;

import me.jack.JEngine.Util.SoundEngine;
import me.jack.JEngine.Util.SoundUtils;
import org.lwjgl.input.Keyboard;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Author: Jack
 * Date: 27/04/13
 */
public class IntroState extends BasicGameState{


    @Override
    public int getID() {
        return 0;
    }

    Image intro = null;

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        intro = new Image("/res/intro.png");
    }


    @Override
    public void enter(GameContainer container, StateBasedGame game) throws SlickException {
        super.enter(container, game);

    }

    boolean draw = false;
    boolean loaded =false;

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.drawImage(intro,0,0);
        draw = true;
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        if(draw && !loaded){
            System.out.println("Loading");
            SoundEngine.getInstance().addSound("shot", SoundUtils.loadSound("/res/sound/shot.wav"));
            SoundEngine.getInstance().addSound("aoe",SoundUtils.loadSound("/res/sound/aoe.wav"));
            SoundEngine.getInstance().addSound("nope",SoundUtils.loadSound("/res/sound/nope.wav"));
            SoundEngine.getInstance().addSound("buy",SoundUtils.loadSound("/res/sound/buy.wav"));
            loaded= true;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
            stateBasedGame.enterState(1);
        }

    }
}
