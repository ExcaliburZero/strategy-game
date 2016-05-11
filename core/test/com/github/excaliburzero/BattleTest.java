package com.github.excaliburzero;

import com.github.excaliburzero.units.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The <code>BattleTest</code> class is used to test the various methods of the
 * Battle class.
 *
 * @author Christopher Wells {@literal <cwellsny@nycap.rr.com>}
 */
public class BattleTest {

    @Test
    public void testCalculateDamage() {
        Unit attacker = new DummyUnit();
        Unit defender = new DummyUnit();

        int expectedDamage = 5;
        int actualDamage = Battle.calculateDamage(attacker, defender);
        assertEquals(expectedDamage, actualDamage);
    }

    @Test
    public void testUnitAttack() {
        Unit attacker = new DummyUnit();
        Unit defender = new DummyUnit();

        Battle.unitAttack(attacker, defender);

        int expectedDefenderHealth = 15;
        int actualDefenderHealth = defender.getCurrentHealth();
        assertEquals(expectedDefenderHealth, actualDefenderHealth);

        assertEquals(20, attacker.getCurrentHealth());

        // Attempt some attacks where the defender would go into negative health
        attacker = new DummyUnit();
        defender = new DummyUnit();

        Battle.unitAttack(attacker, defender);
        Battle.unitAttack(attacker, defender);
        Battle.unitAttack(attacker, defender);
        Battle.unitAttack(attacker, defender);
        Battle.unitAttack(attacker, defender);

        expectedDefenderHealth = 0;
        actualDefenderHealth = defender.getCurrentHealth();
        assertEquals(expectedDefenderHealth, actualDefenderHealth);
    }

    @Test
    public void testRunBattle() {
        Unit attacker = new DummyUnit();
        Unit defender = new DummyUnit();

        Battle.runBattle(attacker, defender);

        assertEquals(15, attacker.getCurrentHealth());
        assertEquals(15, defender.getCurrentHealth());

        // Run battles where the attacker defeats the defender.
        attacker = new DummyUnit();
        defender = new DummyUnit();

        Battle.runBattle(attacker, defender);
        Battle.runBattle(attacker, defender);
        Battle.runBattle(attacker, defender);
        Battle.runBattle(attacker, defender);

        assertEquals(5, attacker.getCurrentHealth());
        assertEquals(0, defender.getCurrentHealth());

        // Run a battle where the attacker has already been defeated
        attacker = new DummyUnit();
        defender = new DummyUnit();
        attacker.setCurrentHealth(0);

        Battle.runBattle(attacker, defender);

        assertEquals(0, attacker.getCurrentHealth());
        assertEquals(20, defender.getCurrentHealth());

        // Run a battle where the defender has already been defeated
        attacker = new DummyUnit();
        defender = new DummyUnit();
        defender.setCurrentHealth(0);

        Battle.runBattle(attacker, defender);

        assertEquals(20, attacker.getCurrentHealth());
        assertEquals(0, defender.getCurrentHealth());

        // Run a battle where both units have already been defeated
        attacker = new DummyUnit();
        defender = new DummyUnit();
        attacker.setCurrentHealth(0);
        defender.setCurrentHealth(0);

        Battle.runBattle(attacker, defender);

        assertEquals(0, attacker.getCurrentHealth());
        assertEquals(0, defender.getCurrentHealth());
    }
}
