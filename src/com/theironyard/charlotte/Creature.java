package com.theironyard.charlotte;

import java.util.Random;

/**
 * Created by kelseynewman on 1/2/17.
 */
public class Creature {
    public static String [] creatures = {"niffler", "acromantula", "unicorn", "thestral", "erumpent", "dung beetle"};

    public static String randomCreature = (creatures[new Random().nextInt(creatures.length)]);
}
