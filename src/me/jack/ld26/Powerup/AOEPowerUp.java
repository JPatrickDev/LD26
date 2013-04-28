package me.jack.ld26.Powerup;

import me.jack.JEngine.Util.SoundEngine;
import me.jack.ld26.Level.Level;
import static me.jack.JEngine.Util.Utils.*;

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
            SoundEngine.getInstance().play("aoe");
        }else{
            SoundEngine.getInstance().play("nope");
        }
    }

    @Override
    public int getCost() {
        return 100;
    }

    @Override
    public boolean canUse(Level level) {
       return level.towerPower == 100;
    }
}
