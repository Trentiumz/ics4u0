/*
* Programmer: Taihan M. & Daniel Y.
* Teacher: Ms. Krasteva
* Date: Feb 13, 2022
* Description: A Pet is a support character in an RPG game with the ability to aid the player in attacking enemies.
* This class is used with the Driver.java class
 */

package daily.feb13;

public class Pet {
    private int health; // the health of the pet
    private int damage; // amount of damage the pet deals
    private String potion; // current potion effect
    private int hunger; // hunger level
    private int energy; // energy level
    private int level; // pet level
    private final String name;
    private final int maxHealth;
    private final int maxEnergy;
    private final String catchPhrase;
    private final int size; // the size of the pet - will presumably be used when being placed in inventory or when being placed in a "world"

    // Default pet constructor
    public Pet(String name){
        this(20, 10, "Hora!", name, 10);
    }

    // pet constructor with detailed values
    public Pet(int maxHealth, int size, String catchPhrase, String name, int maxEnergy){
        this.level = 1;
        this.maxHealth = maxHealth;
        health = maxHealth;
        this.size = size;
        this.catchPhrase = catchPhrase;
        this.name = name;
        this.energy = maxEnergy;
        this.maxEnergy = maxEnergy;
        this.damage = 5 * level;
        this.hunger = 10;
        this.potion = "none";
    }

    // attack method
    public void attack(){
        // must have energy and hunger in order to attack
        if(energy > 0 && hunger > 0){
            System.out.println(catchPhrase);

            int amt = damage;
            // if we have a strength potion, multiply the current damage by 1.2
            if(potion.equals("strength")) amt *= 1.2;

            // print out the amount of damage dealt - is stand-in for actual damaging code
            System.out.println(name + " deals " + amt + " damage!");

            // reduce energy and hunger
            energy--;
            hunger--;
        }
        // without hunger, the pet will not attack and complain instead
        if(hunger <= 0) System.out.println("grumble...");
    }

    // feed the pet
    public void feed(String type, int amt){
        if(type.equals("fruit")) hunger = Math.min(10, hunger + amt);
        else hunger = Math.min(10, hunger + 2 * amt);
    }

    // sleep; replenish energy
    public void sleep(int time){
        energy = Math.min(energy + time, maxEnergy);
    }

    // levels up the pet
    public void levelUp(){
        setLevel(level + 1);
    }

    // code for taking damage
    public void takeDamage(int amt){
        this.health -= amt;
    }

    // getters for health, potion effect, energy level, catch phrase, damage, hunger, maximum health, maximum energy, size, level, and name
    public int getHealth(){
        return health;
    }

    public String getPotion(){
        return potion;
    }

    public int getEnergy(){
        return energy;
    }

    public String getCatchPhrase(){
        return catchPhrase;
    }

    public int getDamage(){
        return damage;
    }

    public int getHunger(){
        return hunger;
    }

    public int getMaxHealth(){
        return maxHealth;
    }

    public int getMaxEnergy(){
        return maxEnergy;
    }

    public int getSize(){
        return size;
    }

    public int getLevel(){
        return level;
    }

    public String getName(){
        return name;
    }

    // setters for hunger, potion effects, health, energy, level, and damage
    public void setHunger(int hunger){
        this.hunger = hunger;
    }

    public void setPotion(String curPotion){
        if(curPotion.equals("none") || curPotion.equals("strength")){
            this.potion = curPotion;
        }
    }

    public void setHealth(int health){
        this.health = health;
    }

    public void setEnergy(int energy){
        this.energy = Math.min(maxEnergy, energy);
    }

    public void setLevel(int level){
        this.level = level;
        this.damage = 5 * level;
    }

    public void setDamage(int damage){
        this.damage = damage;
    }
} // Pet class
