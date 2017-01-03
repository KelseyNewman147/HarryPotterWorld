package com.theironyard.charlotte;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.Scanner;

/**
 * Created by kelseynewman on 1/2/17.
 */
public class Character {
    protected String name;
    protected int health;
    protected int damage;

    public Object companion;

    public Object getCompanion() {
        return companion;
    }

    public void setCompanion(Object companion) {
        this.companion = companion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Character(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public Scanner scanner = new Scanner(System.in);

    public void chooseName(){
        System.out.println("What would you like to be called?");
        String name = scanner.nextLine();
        setName(name);
        System.out.println("Welcome, " + name + "!");
    }

    public void chooseCompanion() throws Exception{
        System.out.println("You'll need someone to keep you company on your journey!");
        System.out.println("Please choose your companion from the list below:");
        System.out.println("1)Harry Potter");
        System.out.println("2)Ron Weasley");
        System.out.println("3)Hermione Granger");
        System.out.println("4)Albus Dumbledore");

        String input = scanner.nextLine();

        if(input.equals("1")) {
            System.out.println("You've chosen The Boy Who Lived! This should be interesting!");
            setCompanion(Companion.companions.get("harry"));
        }
        else if (input.equals("2")) {
            System.out.println("Good choice! Ron is seriously underrated as character.");
            setCompanion(Companion.companions.get("ron"));
        }
        else if (input.equals("3")) {
            System.out.println("Nice! You're going to be with the cleverest witch in school.");
            setCompanion(Companion.companions.get("hermione"));
        }
        else if (input.equals("4")){
            System.out.println("Wise choice! Dumbledore always knows what to do.");
            setCompanion(Companion.companions.get("dumbledore"));
        }
        else {
            throw new Exception("Sorry, that character is not available for this adventure. Try again.");
        }
    }

    public void chooseAdventure() throws Exception {
        System.out.println("Now, what would you like to do?");
        System.out.println("Please enter the number that corresponds to the adventure you would like to take:");
        System.out.println("1) Visit Hagrid.");
        System.out.println("2) Take a trip to Hogsmeade.");
        System.out.println("3) Battle Voldemort.");
        String adventure = scanner.nextLine();

        if (adventure.equals("1")) {
            visitHagrid();
        }
        else if (adventure.equals("2")) {
            tripToHogsmeade();
        }
//        else if (adventure.equals("3")) {
//            battleVoldemort(Character enemy);
//        }
        else {
            throw new Exception("You can't just make up an adventure!");
        }
    }

    public void visitHagrid() throws Exception {
        System.out.println("Let's go see what Hagrid is up to!");
        System.out.println("Hagrid: Hello, you two! I need ter find a magical creature fer me next lesson.");
        System.out.println("Yeh wanna come? [y/n]");
        String response = scanner.nextLine();
        if (response.equalsIgnoreCase("y")) {
            System.out.println("Great! Let's get goin'.");
            catchCreature();
        } else if (response.equalsIgnoreCase("n")) {
            System.out.println("All righ', yer loss. See yeh later!");
            chooseAdventure();
        } else {
            throw new Exception("Yeh don' seem so sure... Try again.");
        }
    }

    public void catchCreature() throws Exception{
        System.out.println("Careful now. Yeh never know wha' yeh'll find in the forest.");
        System.out.println("I see something now!");
        System.out.println("It's a wild " + Creature.randomCreature + "! Should we try and catch it? [y/n]");
        String response = scanner.nextLine();
        if (response.equalsIgnoreCase("y")){
            System.out.println("Got 'em!");
        } else if (response.equalsIgnoreCase("n")){
            System.out.println("Yeh better let that'un go.");
        }
        System.out.println("Thanks fer yer help! Yeh best get back ter the castle now.");
        chooseAdventure();
    }

    public void tripToHogsmeade() throws Exception {
        System.out.println("Fancy a drink at the Three Broomsticks?");
        System.out.println("Madam Rosomerta: Hello, you two! What can I get you to drink?");
        System.out.println("1) Butterbeer");
        System.out.println("2) Fire Whiskey");
        System.out.println("3) Pumpkin Juice");
        System.out.println("4) Gillywater");
        String response = scanner.nextLine();
        if (response.equals("1")) {
            System.out.println("Mmmm delicious! Time to hit the road again!");
            chooseAdventure();
        } else if (response.equals("2")){
            System.out.println("Oh that burns! I've had enough. Better move on.");
            chooseAdventure();
        } else if (response.equals("3")) {
            System.out.println("Ahh refreshing. Ready for a new adventure!");
            chooseAdventure();
        } else if (response.equals("4")) {
            System.out.println("Not sure why I ordered this. Let's get out of here.");
            chooseAdventure();
        } else {
            throw new Exception("We don't serve that here.");
        }
    }

    public void battleVoldemort(Character enemy) throws Exception {
        System.out.println("You Know Who is at it again! We have to stop him!");
        System.out.println("Oh no, he's injured your companion! What would you like to do?");
        System.out.println("What would you like to do?");
        System.out.println("1)Face him yourself.");
        System.out.println("2)Run away!");
        String response = scanner.nextLine();
        if(response.equals("1")) {
            while (health > 0 && enemy.health > 0) {
                health -= enemy.damage;
                enemy.health -= damage;
                System.out.printf("%s's health: %d\n", name, health);
                System.out.printf("%s's health: %d\n", enemy.name, enemy.health);
            }
            String message = "%s has been defeated. \n";
            if (health <=0 ) {
                System.out.printf(message, name);
            }
            if (enemy.health <= 0 ) {
                System.out.printf(message, enemy.name);
            }

        } else {
            System.out.println("Probably wise. Let someone else get rid of him.");
            chooseAdventure();
        }
    }
}
