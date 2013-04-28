package me.jack.ld26.States;

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
public class GameOver extends BasicGameState{


    Image bg = null;
    static int seconds = 0;
    static int levelReached = 0;
   static boolean won = false;
    private Image win;

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
       bg = new Image("/res/over.png");
        win = new Image("/res/win.png");
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

        if(won){
            graphics.drawImage(win,0,0);
            return;
        }
        graphics.drawImage(bg,0,0);

        graphics.drawString("You survived " + seconds + " seconds!",50,276);
        graphics.drawString("You reached round " + levelReached,50,300);
        graphics.drawString("Thank you for playing!",50,330);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

    }

    @Override
    public int getID() {
        return 2;
    }

    public static void set(long timePassed,int round) {
    seconds= (int) (timePassed/1000);
        levelReached = round;

    }

    public static void won() {
        won = true;
    }

}