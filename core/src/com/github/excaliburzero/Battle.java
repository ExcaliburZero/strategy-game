package com.github.excaliburzero;

import com.github.excaliburzero.units.Unit;

/**
 * The <code>Battle</code> class contains methods for running battles between
 * units.
 *
 * @author Christopher Wells {@literal <cwellsny@nycap.rr.com>}
 */
public class Battle {

    /**
     * Performs a round of a battle, changing the units' health based on the
     * results of the battle.
     *
     * @param attacker The attacking unit.
     * @param defender The defending unit.
     */
    public static void runBattle(Unit attacker, Unit defender) {
        boolean unitsBothHaveHealth = attacker.getCurrentHealth() > 0 &&
                defender.getCurrentHealth() > 0;
        if (unitsBothHaveHealth) {
            unitAttack(attacker, defender);

            // Have the defender attack the attacker, if they are not defeated.
            if (defender.getCurrentHealth() > 0) {
                unitAttack(defender, attacker);
            }
        }
    }

    /**
     * Performs a sinlge unit attack.
     *
     * @param attacker The attacking unit.
     * @param defender The defending unit.
     */
    public static void unitAttack(Unit attacker, Unit defender) {
        int defenderHealth = defender.getCurrentHealth();
        int newDefenderHealth = defenderHealth - calculateDamage(attacker, defender);

        // Set the new current health of the defender
        if (newDefenderHealth >= 0) {
            defender.setCurrentHealth(newDefenderHealth);
        } else {
            defender.setCurrentHealth(0);
        }
    }

    /**
     * Calculates the damage for a single attack.
     *
     * @param attacker The attacking unit.
     * @param defender The defending unit.
     * @return The damage calculated to be done to the defending unit.
     */
    public static int calculateDamage(Unit attacker, Unit defender) {
        int attackerPower = attacker.getStrength() + attacker.getWeapon().getPower();
        int defenderDefense = defender.getDefense();

        int damage = attackerPower - defenderDefense;
        return damage;
    }
}
