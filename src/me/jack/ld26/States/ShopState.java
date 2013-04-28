package me.jack.ld26.States;

import me.jack.ld26.LD26Game;
import me.jack.ld26.Level.Level;
import me.jack.ld26.Powerup.AOEPowerUp;
import me.jack.ld26.Powerup.DistractionPowerup;
import me.jack.ld26.Powerup.PowerUpSlot;
import me.jack.ld26.Powerup.SlowDownPowerup;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.awt.Rectangle;

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
    Rectangle[] collisions = new Rectangle[perRow
            *rows];
   public static Image m  = null;
    Font f;
    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
            slots[0] = new PowerUpSlot("/res/powerups/slow.png",new SlowDownPowerup());
            slots[1] = new PowerUpSlot("/res/powerups/aoe.png",new AOEPowerUp());
            slots[2] =  new PowerUpSlot("/res/powerups/distract.png",new DistractionPowerup());
        int i  =0;

        int x = 132;
        int y = 132;
        for(PowerUpSlot s : slots){
            if(s!= null){
                collisions[i] = new Rectangle(x,y,128,200);
                x+=130;
                if(i == perRow){
                    y+=200+15;
                    x = 132;
                }
            i++;
            }else
                break;
        }
        m = new Image("/res/money.png");


    }

    Rectangle backButton = new Rectangle(672,30,128,32);


    boolean back = false;
    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.drawImage(InGame.bg,0,0);
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
            x+=130;

            i++;
            if(i == perRow){
                y+=200+15;
                x = 132;
            }
        }
        graphics.setColor(Color.gray);
        graphics.fillRect(672,30,128,32);
        graphics.setColor(Color.white);
        graphics.drawString("Back",672 + 64,10+32);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        if(back){
            stateBasedGame.enterState(1);
            back = false;
        }
    }

    @Override
    public void mouseReleased(int button, int x, int y) {
        super.mouseReleased(button, x, y);
        if(button == 0){
            if(backButton.contains(x,y)){
               back = true;
            }
            int i = 0;
            for(Rectangle r : collisions){
                if(r == null)break;
                if(r.contains(x,y)){
                    PowerUpSlot slot = slots[i];
                    if(Level.money >= slot.p.getCost()){
                        Level.money-=slot.p.getCost();
                        if(!(slot.p instanceof DistractionPowerup))
                                 Level.current = slot.p;
                        else{
                            Level.distractAmmo+=5;
                        }
                    }
                }
                i++;

            }

        }

    }

}
