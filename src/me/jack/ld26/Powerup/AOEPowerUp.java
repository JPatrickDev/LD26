package me.jack.ld26.Powerup;

import me.jack.ld26.Level.Level;

/**
 * Author: Jack
 * Date: 28/04/13
 */
public class AOEPowerUp extends Powerup{
    @Override
    public void use(Level level) {
        if(level.towerPower == 100){
        level.tower.AOE = true;
        level.towerPower = 0;
        }else{
            //TODO SOUND
        }
    }

    @Override
    public int getCost() {
        return 100;
    }
}
