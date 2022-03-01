/*
* Programmer: Daniel Ye
* Date: Feb 10, 2022
* Teacher: Ms. Krasteva
* Description: This is an Airplane object, which is to be tested with the AirplaneDriver.java class - it contains information on
 */

package daily.feb10;

public class Airplane {
    // instance variables
    private int gasLevel;
    private String landingGear;
    private String doorStatus;
    private int passengers;

    // class constructors
    public Airplane(){
        this(100, "Down", "Open", 100);
    }

    public Airplane(int gasLevel, String gear, String door, int passengers){
        this.gasLevel = gasLevel;
        this.landingGear = gear;
        this.doorStatus = door;
        this.passengers = passengers;
    }

    // opens a door
    public void openDoor(){
        doorStatus = "Open";
    }

    // closes the door
    public void closeDoor(){
        doorStatus = "Closed";
    }

    // runs takeoff procedures
    public void takeOff(){
        closeDoor();
        gasLevel -= 30;
    }

    // procedures after takeoff
    public void doneTakeOff(){
        landingGear = "Up";
    }

    // update information during flight
    public void normalFlight(int used){
        gasLevel -= used;
    }

    // prepares the plane for landing
    public void prepLanding(){
        landingGear = "Down";
    }

    // procedures for landing
    public void land(){
        gasLevel -= 15;
    }

    // loads passengers
    public void loadPass(int passengers){
        this.passengers += passengers;
    }

    // unloads the passengers
    public void unloadPass(){
        this.passengers = 0;
    }

    // returns the percentage of gas in the plane
    public int getGasLevel() {
        return gasLevel;
    }

    // refills the gas
    public void refill(){
        this.gasLevel = 100;
    }

    // gets the current landing gear
    public String getLandingGear() {
        return landingGear;
    }

    // gets the door status
    public String getDoorStatus() {
        return doorStatus;
    }

    // get the number of passengers
    public int getPassengers() {
        return passengers;
    }
}
