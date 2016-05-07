package com.github.excaliburzero.units;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The <code>UnitTest</code> class is used to test the various methods of the
 * Unit class, using the DummyUnit class.
 *
 * @author Christopher Wells {@literal <cwellsny@nycap.rr.com>}
 */
public class UnitTest {

    @Test
    public void testAddExperience() {
        // Create a unit and make sure it has the correct initial values
        Unit unit = new DummyUnit();
        assertEquals(0, unit.getExperience());
        assertEquals(1, unit.getLevel(), 1);

        // Attempt to add some experience without leveling up
        unit.addExperience(50);
        assertEquals(1, unit.getLevel());
        assertEquals(50, unit.getExperience());

        // Add some experience and cause a level up
        unit.addExperience(50);
        assertEquals(2, unit.getLevel());
        assertEquals(0, unit.getExperience());

        // Add some experience causing two level ups with leftover experience
        unit.addExperience(250);
        assertEquals(4, unit.getLevel());
        assertEquals(50, unit.getExperience());
    }

    @Test
    public void testGettersAndSetters() {
        // Create a unit and make sure it has the correct initial values
        Unit unit = new DummyUnit();

        assertEquals(0, unit.getExperience());
        assertEquals("Dummy", unit.getName());
        assertEquals(20, unit.getMaxHealth());
        assertEquals(20, unit.getCurrentHealth());
        assertEquals(10, unit.getStrength());
        assertEquals(10, unit.getDefense());
        assertEquals(10, unit.getMagic());
        assertEquals(10, unit.getMagicDefense());
        assertEquals(10, unit.getSpeed());
        assertEquals(1, unit.getLevel());
        assertEquals(6, unit.getMove());

        // Use each of the setters and confirm that they work by using the getters.
        unit.setName("New Dummy");
        assertEquals("New Dummy", unit.getName());

        unit.setMaxHealth(30);
        assertEquals(30, unit.getMaxHealth());

        unit.setCurrentHealth(10);
        assertEquals(10, unit.getCurrentHealth());

        unit.setStrength(24);
        assertEquals(24, unit.getStrength());

        unit.setDefense(27);
        assertEquals(27, unit.getDefense());

        unit.setMagic(5);
        assertEquals(5, unit.getMagic());

        unit.setMagicDefense(34);
        assertEquals(34, unit.getMagicDefense());

        unit.setSpeed(25);
        assertEquals(25, unit.getSpeed());

        unit.setMove(7);
        assertEquals(7, unit.getMove());
    }
}
