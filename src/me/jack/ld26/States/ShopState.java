package me.jack.ld26.States;

import me.jack.ld26.LD26Game;
import me.jack.ld26.Powerup.PowerUpSlot;
import me.jack.ld26.Powerup.SlowDownPowerup;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Author: Jack
 * Date: 27/04/13
 */
public class ShopState extends BasicGameState {
    @Override
    public int getID() {
        return 3;
    }


    int perRow = 24;
    int rows = 4;

    PowerUpSlot[] slots = new PowerUpSlot[perRow*rows];
    Image m  = null;
    Font f;
    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
            slots[0] = new PowerUpSlot("/res/powerups/slow.png",new SlowDownPowerup());

        m = new Image("/res/money.png");


    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.setFont(LD26Game.font);
        int x = 132;
        int y = 132;
        int i = 0;
        for(PowerUpSlot slot : slots){
            if(slot == null)
                break;
            slot.draw(graphics,x,y);
            graphics.drawImage(m, x, y + 200);
            graphics.drawString(slot.p.getCost() + "",x + 33,y+200);
            x+=128;

            i++;
            if(i == perRow){
                y+=200+15;
                x = 132;
            }



        }
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

    }
}
