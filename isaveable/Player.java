/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isaveable;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adder
 */
public class Player implements ISaveable {

    private String name;
    private String weapon;
    private int hitPoints;
    private int strength;

    public Player(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
        this.weapon = "Sword";
    }

    /**
     * save field of the class in an array list
     *
     * @return
     */
    @Override
    public List<String> write() {
        List<String> values = new ArrayList<>();
        values.add(0, this.name);
        values.add(1, "" + this.hitPoints);     //add double quotes so that the second parameter can be interpreted as a string
        values.add(2, "" + this.strength);
        values.add(3, this.weapon);

        return values;
    }

    /**
     * Read the values in a list note in the is method the array list is still
     * implementing the list interface therefore it can use all its
     * functionality.
     *
     * @param savedValues
     */
    @Override
    public void read(List<String> savedValues) {
        if (savedValues != null && savedValues.size() > 0) {
            this.name = savedValues.get(0);
            this.hitPoints = Integer.parseInt(savedValues.get(1));
            this.strength = Integer.parseInt(savedValues.get(2));
            this.weapon = savedValues.get(3);
        }
    }

    @Override
    public String toString() {
        return String.format("name" + "= \'" + name + "\' ," + "hitPoints=" + hitPoints + ", " + "strength=" + strength + ", weapon =" + weapon);
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

}
