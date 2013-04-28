package me.jack.ld26.Powerup;

import me.jack.ld26.Level.Level;

/**
 * Author: Jack
 * Date: 28/04/13
 */
public class DistractionPowerup extends Powerup
{
    @Override
    public void use(Level level) {
        level.distractAmmo +=5;
    }

    @Override
    public int getCost() {
        return 40;
    }
}
