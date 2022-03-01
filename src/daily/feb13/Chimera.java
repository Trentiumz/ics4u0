/*
* Programmer: Taihan M. & Daniel Y.
* Teacher: Ms. Krasteva
* Date: Feb 14, 2022
* Description: One variety of the Pet class, the Chimera, to be used with the Driver class as a support character
* in an RPG. A Chimera is a cyborg-animal, a pet that is part-lion and part-robot
 */

package daily.feb13;

public class Chimera extends Pet {

    private int ammo; // amount of ammunition in the Chimera's weapon
    private boolean overclocked; // when overclocked, chimeras do more damage
    private float agility; // the ability of the Chimera to dodge attacks
    private float durability; // the durability of a Chimera's robot part
    private int armour; // the armour of the Chimera, reduces damage taken
    private float amplifier; // the amplifier on damage when overclocked
    private String weapon; // the current weapon
    private int ammoCap; // the ammo capacity
    private int resistance; // the resistance, reduces decrease in durability when attacking
    private float amtRobot; // the amount of the chimera that's actually a robot, affects damage amplitude

    // constructor with default values
    public Chimera(String name) {
        this(200, 20, "Attack Initiated", name, 10, 2.0f, "Pistol", 100, 5, 0.3f, 0, 0);
    }

    // constructor with settable values for chimera
    public Chimera(int maxHealth, int size, String catchPhrase, String name, int energy, float amplifier,
                   String weapon, int ammoCap, int resistance, float amtRobot, float agility, int armour) {
        super(maxHealth, size, catchPhrase, name, energy);
        this.amplifier = amplifier;
        this.weapon = weapon;
        this.ammoCap = ammoCap;
        this.ammo = ammoCap;
        this.resistance = resistance;
        this.amtRobot = amtRobot;
        this.agility = agility;
        this.durability = 100;
        this.armour = armour;
        this.overclocked = false;
    }

    // code for when the Chimera is attacked
    public void takeDamage(int amt){
        // with higher agility, there is a chance to dodge the attack
        if(Math.random() < 1 / (1 + agility)){
            this.setHealth(this.getHealth() - amt / (1 + this.armour));
            System.out.println("ouch!");
        } else System.out.println(getName() + " dodged the attack");
    }

    // overridden code for when a Chimera attacks
    public void attack(){
        // sufficient energy is needed to attack
        if(getEnergy() > 0){
            // the "fleshly" body requires hunger to attack
            if(getHunger() > 0){
                int damage = getDamage();
                // strength potions & overclocking increases the damage
                if(getPotion().equals("strength")) damage *= 1.2;
                if(overclocked) damage += amplifier * amtRobot * damage;

                System.out.println(getCatchPhrase());
                System.out.println(getName() + " deals " + damage + " damage!");
                setHunger(getHunger() - 1);
            } else System.out.println("Too hungry for main attack");

            // robotic body requires ammunition and durability to attack
            if(ammo > 0 && durability > 0 && durability >= 25 - resistance){
                System.out.println("Firing " + weapon);

                // overclocking increases damage
                int amt = getDamage();
                if(overclocked) amt *= amplifier;
                System.out.println(getName() + " deals " + amt + " additional damage!");

                // reduce ammo and durability
                ammo--;
                durability -= Math.max(1, 25 - resistance);
            } else System.out.println("Insufficient conditions for mechanical attack");

            // attacking expends energy
            setEnergy(getEnergy() - 1);
        }
    }

    // overclock the chimera
    public void overclock(){
        this.overclocked = true;
    }

    // refill the magazine
    public void refill(int amt){
        this.ammo = Math.min(this.ammoCap, this.ammo + amt);
    }

    // update software
    public void softwareUpdate(int version){
        System.out.println("System running on version " + version + ".0");
    }

    // repair the chimera
    public void repair(){
        this.durability = 100;
    }

    // getter for ammo, overclocked status, durability, armour, weapon
    public int getAmmo() {
        return ammo;
    }

    public boolean isOverclocked() {
        return overclocked;
    }

    public float getDurability() {
        return durability;
    }

    public int getArmour() {
        return armour;
    }

    public String getWeapon() {
        return weapon;
    }

    // setters for ammo, overclocked status, durability, agility, and armour

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    public void setOverclocked(boolean overclocked) {
        this.overclocked = overclocked;
    }

    public void setDurability(float durability) {
        this.durability = durability;
    }

    public void setAgility(float agility){
        this.agility = agility;
    }

    public void setArmour(int armour) {
        this.armour = armour;
    }
} // Chimera class
