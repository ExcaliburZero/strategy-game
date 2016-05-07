package com.github.excaliburzero.units;

/**
 * The <code>Unit</code> class is used to represent a single battle unit.
 *
 * @author Christopher Wells {@literal <cwellsny@nycap.rr.com>}
 */
public abstract class Unit {

    private String name;
    private int maxHealth;
    private int currentHealth;
    private int strength;
    private int defense;
    private int magic;
    private int magicDefense;
    private int speed;
    private int level;
    private int experience;
    private int move;

    public Unit(int experience, String name, int maxHealth, int currentHealth, int strength, int defense, int magic, int magicDefense, int speed, int level, int move) {
        this.experience = experience;
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = currentHealth;
        this.strength = strength;
        this.defense = defense;
        this.magic = magic;
        this.magicDefense = magicDefense;
        this.speed = speed;
        this.level = level;
        this.move = move;
    }

    /**
     * Increases the unit's experience by the given amount. Also levels up the
     * unit if the experience becomes greater than 100.
     *
     * @param experienceIncrease The amount of experience that is added to the
     *                           unit.
     */
    public void addExperience(int experienceIncrease) {
        this.experience += experienceIncrease;

        // Check to see if the unit levels up one or more times
        while (this.experience >= 100) {
            this.levelUp();
        }
    }

    /**
     * Increments the level of the unit by one. Also decreases the experience of
     * the unit by 100.
     */
    private void levelUp() {
        this.experience -= 100;
        this.level += 1;
    }

    public int getMove() {
        return move;
    }

    public int getExperience() {
        return experience;
    }

    public String getName() {
        return name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getStrength() {
        return strength;
    }

    public int getDefense() {
        return defense;
    }

    public int getMagic() {
        return magic;
    }

    public int getMagicDefense() {
        return magicDefense;
    }

    public int getSpeed() {
        return speed;
    }

    public int getLevel() {
        return level;
    }

    public void setMove(int move) {
        this.move = move;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public void setMagicDefense(int magicDefense) {
        this.magicDefense = magicDefense;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
