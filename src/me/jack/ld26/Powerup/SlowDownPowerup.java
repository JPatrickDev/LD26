package me.jack.ld26.Powerup;

import me.jack.ld26.Level.Level;

/**
 * Author: Jack
 * Date: 27/04/13
 */
public class SlowDownPowerup extends Powerup{

    @Override
    public void use(final Level level) {
        if(level.towerPower != 100)
            return;

        level.towerPower = 0;
    level.slow  = true;
        new Thread(new Runnable(){

            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                level.slow = false;
            }
        }).start();

    }
    @Override
    public int getCost() {
        return 10;
    }

    @Override
    public boolean canUse(Level level) {
        return level.towerPower == 100;
    }
}
