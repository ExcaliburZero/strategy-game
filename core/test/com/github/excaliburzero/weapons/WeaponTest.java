package com.github.excaliburzero.weapons;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The <code>WeaponTest</code> class is used to test the various methods of the
 * Weapon class.
 *
 * @author Christopher Wells {@literal <cwellsny@nycap.rr.com>}
 */
public class WeaponTest {

    @Test
    public void testGetters() {
        Weapon weapon = new BasicSword();

        // Test each of the getter methods
        assertEquals("Basic Sword", weapon.getName());
        assertEquals(5, weapon.getPower());
        assertEquals(8, weapon.getWeight());
        assertEquals(WeaponType.Sword, weapon.getType());
    }
}
