package me.jack.ld26.States;

import me.jack.ld26.Level.Level;
import me.jack.ld26.Powerup.SlowDownPowerup;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.awt.Rectangle;

/**
 * Author: Jack
 * Date: 27/04/13
 */
public class InGame extends BasicGameState {


    Level level = new Level();
    static Image bg = null;


    long timePassed = 0;

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        level.init();
        bg = new Image("/res/bg.png");
    }

    Rectangle shopButton = new Rectangle(672,30,128,32);
    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.drawImage(bg, 0, 0);
        level.render(graphics);
        graphics.setColor(Color.gray);
        graphics.fillRect(672,30,128,32);
        graphics.setColor(Color.white);
        graphics.drawString("Shop",672 + 64,10+32);
    }

    boolean enterShop = false;

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        level.update(gameContainer);
        if (level.tower.health < 1) {
            GameOver.set(timePassed,level.currentLevel);
            stateBasedGame.enterState(2);
        }

        if (level.player.health < 1) {
            GameOver.set(timePassed,level.currentLevel);
            stateBasedGame.enterState(2);
        }

        if(enterShop){
            stateBasedGame.enterState(3);
            enterShop = false;
        }
    System.out.println((timePassed / 1000));
        if((timePassed / 1000) >= 60){
            GameOver.won();
            stateBasedGame.enterState(2);
            return;
        }
        timePassed += i;
    }

    @Override
    public void mouseReleased(int button, int x, int y) {
        super.mouseReleased(button, x, y);
        if(button == 0){
            if(shopButton.contains(x,y)){
                enterShop = true;
            }
        }
        if(button == 1){
            new SlowDownPowerup().use(level);
        }
    }

    @Override
    public int getID() {
        return 1;
    }
}
