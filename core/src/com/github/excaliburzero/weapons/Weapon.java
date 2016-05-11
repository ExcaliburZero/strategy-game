package com.github.excaliburzero.weapons;

/**
 * The <code>Weapon</code> class is used to represent a weapon.
 *
 * @author Christopher Wells {@literal <cwellsny@nycap.rr.com>}
 */
public abstract class Weapon {
    private final String name;
    private final int power;
    private final int weight;
    private final WeaponType type;

    public Weapon(String name, int power, int weight, WeaponType type) {
        this.name = name;
        this.power = power;
        this.weight = weight;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public int getWeight() {
        return weight;
    }

    public WeaponType getType() {
        return type;
    }
}
