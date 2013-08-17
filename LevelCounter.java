/**
 * A {@link LevelCounter} for keeping track of levels in the game of Munchkin.
 * Can manage your level, gear, and temporary bonus.
 * 
 * @author Tore Hanssen
 */
public class LevelCounter {
    private int level;
    private int gear;
    private int bonus;

    /**
     * Instantiates a new level counter.
     * By default, players start at level 1.
     */
    public LevelCounter() {
        level = 1;
        bonus = 0;
        gear = 0;
    }

    /**
     * Sets the level to the given value
     * @param level the value to set the level to
     */
    public void setLevel(int level) {
        this.level = level;
    }

    
    /**
     * Increments the level.
     */
    public void incLevel() {
        level++;
    }

    /**
     * Decrements the level.
     */
    public void decLevel() {
        level--;
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
     * Changes the gear by the given amount.
     * @throws IllegalArgumentException if the resulting gear is below 0.
     * (a player cannot have negative gear, that goes in the bonus category)
     * @param delta
     */
    public void changeGear(int delta) {
        gear += delta;
        if (gear < 0) {
            throw new IllegalArgumentException("Invalid change in gear - cannot have a negative gear total");
        }
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
        if (level < 1) {
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
     * @return the combat strength, or 0 if temporarily negative
     */
    public int getCombatStrength() {
        return Math.max(level + gear + bonus, 0);
    }
}