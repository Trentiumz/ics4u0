/*
* Programmer: Daniel Ye
* Date: Feb 10, 2022
* Teacher: Ms. Krasteva
* Description: This program display the usage of the Airplane.java class
 */

package daily.feb10;

public class AirplaneDriver {

    // prints the information of the plane
    public static void printInfo(Airplane plane){
        System.out.println("Door: " + plane.getDoorStatus());
        System.out.println("Landing Gear: " + plane.getLandingGear());
        System.out.println("Passengers: " + plane.getPassengers());
        System.out.println("Gas: " + plane.getGasLevel() + "%");
    }

    public static void main(String[] args){
        // initialize the plane
        Airplane plane = new Airplane();

        // load passengers and print pre-flight information
        plane.loadPass(20);
        System.out.println("--- Before Flight --- ");
        printInfo(plane);

        // take off
        System.out.println("\nTaking off...");
        plane.takeOff();

        // print the information during the flight
        System.out.println("--- During Flight --- ");
        plane.doneTakeOff();
        plane.normalFlight(40);
        printInfo(plane);

        // land
        System.out.println("\nPreparing to land...");
        plane.prepLanding();

        // after the flight, print out the plane information
        System.out.println("--- After Flight --- ");
        plane.land();
        plane.openDoor();
        plane.unloadPass();
        printInfo(plane);

        // perform maintenance and print the information after maintenance
        System.out.println("\nPerforming Maintenance...");
        plane.refill();
        plane.closeDoor();
        System.out.println("--- Post Maintenance --- ");
        printInfo(plane);
    } // main method

} // AirplaneDriver class
