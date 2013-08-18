import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @see LevelCounter
 * @author Tore Hanssen
 *
 */

public class LevelCounterTest {
    private LevelCounter counts;
    
    @Before
    public void setup() {
        counts = new LevelCounter();
    }
    
    private void resetCounts() {
        counts.setLevel(1);
        counts.resetBonus();
        counts.setGear(0);
    }
    
    /**
     * @see LevelCounter#setLevel(Integer)
     * @see LevelCounter#incLevel()
     * @see LevelCounter#decLevel()
     * @see LevelCounter#changeLevel(Integer)
     */
    @Test
    public void changingLevelsTest() {
        resetCounts();
        // Test incrementing and decrementing below 0
        counts.incLevel();
        counts.decLevel();
        assertEquals(1, counts.getLevel());
        counts.decLevel();
        assertEquals(1, counts.getLevel());
        
        counts.setBonus(5);
        counts.setLevel(3);
        assertEquals(3, counts.getLevel());
        
        // Test negative a zero levels
        try {
            counts.setLevel(-2);
        } catch (IllegalArgumentException e) {}
        try {
            counts.setLevel(0);
        } catch (IllegalArgumentException e) {}
        
        // Test changing the level
        counts.resetBonus();
        counts.changeLevel(-5);
        counts.changeLevel(8);
        assertEquals(9, counts.getLevel());
    }
    
    /**
     * @see LevelCounter#setGear(Integer)
     * @see LevelCounter#changeGear(Integer)
     */
    @Test
    public void changingGearTest() {
        resetCounts();
        counts.setGear(0);
        assertEquals(0, counts.getGear());
        counts.setGear(-5);
        assertEquals(0, counts.getGear());
        counts.changeGear(-5);
        assertEquals(0, counts.getGear());
        counts.changeGear(3);
        assertEquals(3, counts.getGear());
        
        assertEquals(4, counts.getCombatStrength());
    }
    
    /**
     * @see LevelCounter#setBonus(Integer)
     * @see LevelCounter#changeBonus(Integer)
     */
    @Test
    public void changingBonusTest() {
        resetCounts();
        counts.setBonus(-3);
        assertEquals(-3, counts.getBonus());
        counts.setBonus(0);
        assertEquals(0, counts.getBonus());
        counts.changeBonus(-5);
        counts.changeBonus(8);
        assertEquals(3, counts.getBonus());
        
        assertEquals(4, counts.getCombatStrength());
    }
    
    /**
     * @see LevelCounter#getCombatStrength()
     */
    @Test
    public void getCombatStrengthTest() {
        resetCounts();
        //Typical game scenario
        counts.incLevel();
        counts.changeGear(3);
        counts.setBonus(-5);
        
        assertEquals(0, counts.getCombatStrength());
        
        // Other cases
        resetCounts();
        counts.decLevel();
        counts.changeGear(3);
        counts.changeGear(-3);
        counts.setBonus(5);
        counts.changeBonus(-3);
        
        assertEquals(3, counts.getCombatStrength());
        
        
        counts.resetBonus();
        counts.changeGear(3);
        counts.changeLevel(2);
        counts.changeLevel(1);
        counts.changeGear(3);
        counts.setBonus(3);
        // Added 12, took away 2, strength was 3 => now 13
        assertEquals(13, counts.getCombatStrength());
    }
    
}