package me.jack.ld26.States;

import me.jack.ld26.Level.Level;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.awt.Rectangle;
import java.util.ArrayList;

/**
 * Author: Jack
 * Date: 28/04/13
 */
public class DifficultySelectState extends BasicGameState {


    Image logo = null;
    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

        logo = new Image("/res/logo.png");

        int x = 0;
        int y = 0;
        int   width = gameContainer.getGraphics().getFont().getWidth("Please select your level of difficulty:");
        x = (gameContainer.getWidth() / 2) - (gameContainer.getGraphics().getFont().getWidth("Please select your level of difficulty:") / 2);
        y = 50;
    //y+=64;

        y += 64;
        rects.add(new Rectangle(x,y,width,32));

        y += 10;
        y += 64;
        rects.add(new Rectangle(x,y,width,32));
        y += 10;


        y += 64;
        rects.add(new Rectangle(x,y,width,32));
        y += 10;

    }

    int x = 0;
    int y = 0;

    int width = 0;

    ArrayList<Rectangle> rects = new ArrayList<Rectangle>();

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.drawImage(logo,0,0);
        graphics.drawString("Please select your level of difficulty:", x, y);

        graphics.setColor(Color.gray);
        y += 64;
        graphics.fillRect(x, y, width, 32);
        graphics.setColor(Color.white);
        graphics.drawString("Easy", x + ((width / 2) - (graphics.getFont().getWidth(
                "Easy")/2)),y + (16 - graphics.getFont().getHeight("Easy")/2));

        y += 10;

        graphics.setColor(Color.gray);
        y += 64;
        graphics.fillRect(x, y, width, 32);
        graphics.setColor(Color.white);
        graphics.drawString("Normal", x + ((width / 2) - (graphics.getFont().getWidth(
                "Normal")/2)),y + (16 - graphics.getFont().getHeight("Normal")/2));

        y += 10;

        graphics.setColor(Color.gray);
        y += 64;
        graphics.fillRect(x, y, width, 32);
        graphics.setColor(Color.white);
        graphics.drawString("Hard", x + ((width / 2) - (graphics.getFont().getWidth(
                "Hard")/2)),y + (16 - graphics.getFont().getHeight("Hard")/2));

        y += 10;

    }

    boolean next = false;
    @Override
    public void mouseReleased(int button, int x, int y) {
        super.mouseReleased(button, x, y);
       if(button != 0)
           return;
        for(int i = 0 ;i!= rects.size();i++){
            Rectangle r = rects.get(i);
            if(r.contains(x,y)){
                if(i == 0){
                    Level.timeTillEnd = 60;
                    Level.maxHealth = 300;
                }else if(i == 1){
                    Level.timeTillEnd = 90;
                    Level.maxHealth = 200;
                }else if(i==2){
                    Level.timeTillEnd = 120;
                    Level.maxHealth = 100;
                }

                next= true;
            }
        }

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        x = (gameContainer.getWidth() / 2) - (gameContainer.getGraphics().getFont().getWidth("Please select your difficulty:") / 2);
        y = 50;

        width = gameContainer.getGraphics().getFont().getWidth("Please select your difficulty:");
    if(next)
        stateBasedGame.enterState(0);



    }


    @Override
    public int getID() {
        return 4;
    }
}
