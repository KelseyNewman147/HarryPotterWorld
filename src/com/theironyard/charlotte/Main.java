package com.theironyard.charlotte;

public class Main {

    public static void main(String[] args) throws Exception {
        Character user = new Character("user", 10, 100);

        System.out.println("Hello! You are about to embark on a magical adventure!");

        Companion.companions.put("harry", new Companion("Harry Potter", 100, 250));
        Companion.companions.put("ron", new Companion("Ron Weasley", 100, 150));
        Companion.companions.put("hermione", new Companion("Hermione Granger", 100, 200));
        Companion.companions.put("dumbledore", new Companion("Albus Dumbledore", 100, 1001));
        //Trying to implement an option to have your companion help in the battle.

        user.chooseName();
        user.chooseCompanion();
        user.chooseAdventure();
    }
}
