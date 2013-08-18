/**
 * A {@link LevelCounter} for keeping track of levels in the game of Munchkin.
 * Can manage your level, gear, and temporary bonus.
 * 
 * @author Tore Hanssen
 */
public class LevelCounter {
    private static final int STARTING_LEVEL = 1;
    private int level;
    private int gear;
    private int bonus;

    /**
     * Instantiates a new level counter.
     * By default, players start at level 1.
     */
    public LevelCounter() {
        level = STARTING_LEVEL;
        bonus = 0;
        gear = 0;
    }

    /**
     * Sets the level to the given value
     * @param level the value to set the level to
     * @throws IllegalArgumentException if the level passed is under your starting level in the game (level 1)
     *         According to the rules, you cannot go below level 1.
     */
    public void setLevel(int level) {
        if (STARTING_LEVEL < 1) {
            throw new IllegalArgumentException("Invalid level - level must be at least 1");
        }
        this.level = level;
    }

    
    /**
     * Increments the level.
     */
    public void incLevel() {
        level++;
    }

    /**
     * Decrements the level if the player can go lower in level.
     */
    public void decLevel() {
        if (level > STARTING_LEVEL) {
            level--;
        }
        
    }
    
    /**
     * Resets the level to the starting level
     */
    public void resetLevel() {
        level = STARTING_LEVEL;
    }

    /**
     * Sets the bonus to the given value
     * @param b the value to set the bonus to
     */
    public void setBonus(int b) {
        bonus = b;
    }

    /**
     * @return the value of the gear
     */
    public int getGear() {
        return gear;
    }
    
    /**
     * Changes the gear by the given amount, to zero at a minimum.
     * (a player cannot have negative gear, that goes in the bonus category)
     * @param delta
     */
    public void changeGear(int delta) {
        gear += delta;
        if (gear < 0) {
            gear = 0;
        }
    }
    
    /**
     * Sets the gear to the given amount or zero at a minimum
     * (a player cannot have negative gear, that goes in the bonus category)
     * @param g
     */
    public void setGear(int g) {
        gear = Math.max(g, 0);
    }
    
    /**
     * Changes the bonus by the given amount.
     * @param delta the amount to change the bonus by
     */
    public void changeBonus(int delta) {
        bonus += delta;
    }
    
    /**
     * Resets the bonus to its default.
     */
    public void resetBonus() {
        bonus = 0;
    }
    
    /**
     * Changes the level by the given amount
     * The level cannot go below 1.
     * @param delta the amount to change the level by
     */
    public void changeLevel(int delta) {
        level += delta;
        if (level < STARTING_LEVEL) {
            level = 1;
        }
    }
    
    /**
     * @return the bonus
     */
    public int getBonus() {
        return bonus;
    }

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * The combat strength is defined as the total "points" accrued, including levels, bonus, and gear.
     * @return the combat strength
     */
    public int getCombatStrength() {
        return level + gear + bonus;
    }
}