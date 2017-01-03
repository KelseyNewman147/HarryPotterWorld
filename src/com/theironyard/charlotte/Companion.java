package com.theironyard.charlotte;

import java.util.HashMap;

/**
 * Created by kelseynewman on 1/2/17.
 */
public class Companion extends Character {
    public Companion(String name, int health, int damage) {
        super(name, health, damage);
    }
    public static HashMap<String, Companion> companions = new HashMap();
}
