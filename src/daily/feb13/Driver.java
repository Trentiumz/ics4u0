/*
* Programmer: Taihan M. & Daniel Y.
* Teacher: Ms. Krasteva
* Date: Feb 14, 2022
* Description: Displays the usage of the Chimera.java and Pet.java classes
 */

package daily.feb13;

public class Driver {

    // prints the summary of a pet
    public static void printSummary(Pet pet){
        System.out.println("--- " + pet.getName() + "'s summary ---");
        System.out.println("Hunger: " + pet.getHunger());
        System.out.println("Health: " + pet.getHealth());
        System.out.println("Energy: " + pet.getEnergy());
        System.out.println("Damage: " + pet.getDamage());
        System.out.println("Current Potion: " + pet.getPotion());
        System.out.println("Current level: " + pet.getLevel());
        System.out.println("Size: " + pet.getSize());
    }

    // prints the summary of a chimera
    public static void chimeraSummary(Chimera pet){
        printSummary(pet);
        System.out.println("Durability: " + pet.getDurability());
        System.out.println("Overclocked: " + pet.isOverclocked());
        System.out.println("Ammunition: " + pet.getAmmo());
        System.out.println("Current weapon: " + pet.getWeapon());
        System.out.println("Armour level: " + pet.getArmour());
    }

    // the demo code for displaying the various properties of a generic pet
    public static void petDemo () {
        // initialize a new pet
        Pet sub = new Pet("Pepsi");

        // display the attribute summary of the first pet
        System.out.println("You have a new pet! It's name is " + sub.getName());
        System.out.println("The following is " + sub.getName() + "'s stat summary:");
        System.out.println();
        printSummary(sub);

        // manually set a few attributes from their default (simulating user choice for simplicity)
        System.out.println();
        System.out.println("Would you like to manually set " + sub.getName() + "'s stats?... Yes");
        System.out.println("Setting hunger...");
        sub.setHunger(sub.getHunger() / 2);
        System.out.println("Setting damage...");
        sub.setDamage(20);
        System.out.println("Setting health...");
        sub.setHealth(sub.getMaxHealth() / 2);
        System.out.println("Setting energy...");
        sub.setEnergy(sub.getMaxEnergy() / 2);
        System.out.println("Setting level...");
        sub.setLevel(1);
        System.out.println();

        // print out the new summary of the pet after manually setting a few attributes
        System.out.println(sub.getName() + "'s new stat summary");
        printSummary(sub);
        System.out.println();

        // display the effects of feeding - print stats, feed, then print stats again
        System.out.println(sub.getName() + " is hungry and hurt! Feed it.");
        System.out.println(sub.getName() + "'s hunger level: " + sub.getHunger());
        System.out.println(sub.getName() + "'s health level: " + sub.getHealth());
        System.out.println("What would you like to feed your pet?... fruit");
        System.out.println("How many fruits would you like to give to your pet?... 3");
        sub.feed("fruit", 3);
        System.out.println(sub.getName() + " has been satiated!");
        System.out.println(sub.getName() + "'s hunger level: " + sub.getHunger());
        System.out.println(sub.getName() + "'s health level: " + sub.getHealth());
        System.out.println();

        // display the effects of sleep on the pet
        System.out.println(sub.getName() + " is tired! Put it to sleep.");
        System.out.println(sub.getName() + "'s Energy: " + sub.getEnergy());
        System.out.println("How long would you like your pet to sleep for? ... 5 hours");
        sub.sleep(5);
        System.out.println(sub.getName() + " is well rested and energized!");
        System.out.println(sub.getName() + "'s Energy: " + sub.getEnergy());
        System.out.println();

        // display the effects of a pet taking damage
        System.out.println("AN ENEMY HAS ATTACKED YOUR PET!");
        System.out.println("The enemy does... 5 damage");
        sub.takeDamage(5);
        System.out.println("Your pet has taken damage! Health: " + sub.getHealth());
        System.out.println();

        // display the effects of the strength potion
        System.out.println("You must retaliate!");
        System.out.println("Your pet's enemy is very strong");
        System.out.println("Would you like to use a potion?... Yes");
        System.out.println("What potion would you like to use?... Strength");
        sub.setPotion("strength");
        System.out.println(sub.getName() + "'s potion: " + sub.getPotion());
        System.out.println();

        // attack a few times, displaying the fact that the strength potion has increased damage
        System.out.println("Would you like to attack back?...Yes");
        sub.attack();
        System.out.println("Would you like to attack again?...Yes");
        sub.attack();
        System.out.println("Would you like to attack again?...Yes");
        sub.attack();
        System.out.println("Your enemy has been defeated!");
        System.out.println();

        // print the summary once again
        System.out.println(sub.getName() + "'s stat summary after the fight");
        printSummary(sub);
        System.out.println();

        // display the effects of levelling up the pet
        System.out.println("Your pet is ready for a level up!");
        sub.levelUp();
        System.out.println(sub.getName() + "'s level: " + sub.getLevel());
    } // petDemo code

    // displays the attributes and behavior of a chimera
    public static void chimeraDemo () {
        // initialize a new Chimera
        Chimera main = new Chimera("Phantom");

        // display the attribute summary of our Chimera
        System.out.println("You have a new chimera! Its name is " + main.getName());
        System.out.println();
        System.out.println("The following are its stats: ");
        chimeraSummary(main);

        // display the effects of phantom being attacked (it may dodge the attack or be hit)
        System.out.println();
        System.out.println("Phantom is being attacked!");
        main.takeDamage(20);
        System.out.println("Health: " + main.getHealth());

        // display the effects of overclocking and the strength potion
        System.out.println("Would you like Phantom to go berserk?... Yes");
        System.out.println("Overclocking Phantom...");
        main.overclock();
        System.out.println("Using strength potion...");
        main.setPotion("strength");

        // using the potions, attack 3 times
        System.out.println("\nAttacking...\n");
        main.attack();
        System.out.println("\nAttacking...\n");
        main.attack();
        System.out.println("\nAttacking...\n");
        main.attack();

        // messages for the "aftermath" of the battle
        System.out.println("\nThe enemy has been defeated! In fact, the enemy has been devastated!");
        System.out.println();

        // display the statistics of chimera after the fight
        System.out.println("Phantom took quite a toll from that attack:");
        chimeraSummary(main);
        System.out.println();

        // display the effects of feeding, repairing, and refilling the Chimera
        System.out.println("Would you like to heal and repair Phantom?... Yes");
        System.out.println("Feeding Phantom...");
        main.feed("fruit", 100);
        System.out.println("Repairing Phantom...");
        main.repair();
        System.out.println("Refilling ammo...");
        main.refill(10);

        // perform some extra maintenance, turning off its overclocked state and removing potion effects
        System.out.println("Turning off overclock...");
        main.setOverclocked(false);
        System.out.println("Taking off potion effects...");
        main.setPotion("none");

        // give the Chimera some rest, updating its software and allowing it to sleep
        System.out.println();
        System.out.println("Software update available! Would you like to update Phantom's machine software?... Yes");
        main.softwareUpdate(10);
        System.out.println("How long would you like Phantom to sleep for?... 2 hours");
        main.sleep(2);

        // print out the Chimera's statistics after its maintenance
        System.out.println("\nPhantom's stats after healing and repairing:");
        chimeraSummary(main);
        System.out.println();

        // manually set some attributes to display the usage of its set methods
        System.out.println("Manually setting durability...100%");
        main.setDurability(100);
        System.out.println("Manually setting ammo...100");
        main.setAmmo(100);
        System.out.println("Manually setting Armour...100");
        main.setArmour(100);
    } // chimeraDemo method

    // main method
    public static void main (String[] args) {
        petDemo();
        System.out.println("\n------------------------------------------------\n");
        chimeraDemo();
    }
} // Driver class
