package me.jack.ld26.States;

import me.jack.ld26.Level.Level;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Author: Jack
 * Date: 27/04/13
 */
public class InGame extends BasicGameState {



    Level level = new Level();
    Image bg = null;



    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        level.init();
        bg = new Image("/res/bg.png");
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.drawImage(bg,0,0);
        level.render(graphics);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        level.update(gameContainer);
        if(level.tower.health < 1){
            stateBasedGame.enterState(2);
        }
    }

    @Override
    public int getID() {
        return 1;
    }
}
