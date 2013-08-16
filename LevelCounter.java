public class LevelCounter {
    private int level;
    private int gear;
    private int bonus;

    public LevelCounter() {
        level = 1;
        bonus = 0;
        gear = 0;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void incLevel() {
        level++;
    }

    public void decLevel() {
        level--;
    }

    public void setBonus(int b) {
        bonus = b;
    }

    public int getGear() {
        return gear;
    }
    
    public void changeGear(int delta) {
        gear += delta;
        if (gear < 0) {
            throw new IllegalArgumentException("Invalid change in gear - cannot have a negative gear total");
        }
    }
    
    public void changeBonus(int delta) {
        bonus += delta;
    }
    
    public void resetBonus() {
        bonus = 0;
    }
    
    public void changeLevel(int delta) {
        level += delta;
        if (level < 1) {
            level = 1;
        }
    }
    
    public int getBonus() {
        return bonus;
    }

    public int getLevel() {
        return level;
    }

    public int getCombatStrength() {
        return level + gear - bonus;
    }
}