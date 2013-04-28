package me.jack.ld26.States;

import me.jack.ld26.Level.Level;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.awt.Rectangle;
import java.util.ArrayList;

/**
 * Author: Jack
 * Date: 28/04/13
 */
public class DifficultySelectState extends BasicGameState {


    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    int x = 0;
    int y = 0;

    int width = 0;

    ArrayList<Rectangle> rects = new ArrayList<Rectangle>();

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.drawString("Please select your difficulty:", x, y);

        graphics.setColor(Color.gray);
        y += 64;
        graphics.fillRect(x, y, width, 32);
        graphics.setColor(Color.white);
        graphics.drawString("Easy", x + ((width / 2) - (graphics.getFont().getWidth(
                "Easy")/2)),y + (16 - graphics.getFont().getHeight("Easy")/2));
    if(rects.size() == 0){
        rects.add(new Rectangle(x,y,width,32));
    }
        y += 10;

        rects.add(new Rectangle(x,y,width,32));
        graphics.setColor(Color.gray);
        y += 64;
        graphics.fillRect(x, y, width, 32);
        graphics.setColor(Color.white);
        graphics.drawString("Normal", x + ((width / 2) - (graphics.getFont().getWidth(
                "Normal")/2)),y + (16 - graphics.getFont().getHeight("Normal")/2));
        if(rects.size() == 1)
        rects.add(new Rectangle(x,y,width,32));
        y += 10;

        graphics.setColor(Color.gray);
        y += 64;
        graphics.fillRect(x, y, width, 32);
        graphics.setColor(Color.white);
        graphics.drawString("Hard", x + ((width / 2) - (graphics.getFont().getWidth(
                "Hard")/2)),y + (16 - graphics.getFont().getHeight("Hard")/2));
        if(rects.size() == 2)
        rects.add(new Rectangle(x,y,width,32));
        y += 10;

    }

    boolean next = false;
    @Override
    public void mouseReleased(int button, int x, int y) {
        super.mouseReleased(button, x, y);
        System.out.println(rects.size());
        int  i= 0;
        for(Rectangle r : rects){
            if(r.contains(x,y)){

                if(i == 1){
                    Level.timeTillEnd = 60;
                }else if(i==2){
                    Level.timeTillEnd = 90;
                }else{
                    Level.timeTillEnd = 120;
                }
                     next = true;

            }
            i=+1;
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
