package me.jack.ld26.Powerup;

import me.jack.ld26.Level.Level;

/**
 * Author: Jack
 * Date: 27/04/13
 */
public abstract class Powerup {
    public abstract void use(Level level);

    public abstract int getCost();


}
