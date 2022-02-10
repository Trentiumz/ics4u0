/*
* Daniel Ye
* Feb 9, 2022
* Ms. Krasteva
* This is a Driver class to display the usage of the Car.java class and its objects
 */

package daily.feb9;

public class CarDriver {
    public static void main(String[] args){
        // initialize two cars
        Car vacation = new Car("Toyota", "Corolla", 20.0, 30.0);
        Car daily = new Car("Honda", "Civic", 5.0, 20.0);

        // drive to work and refill the car
        System.out.println("Driving to work...");
        daily.drive(25);
        daily.gasUp();
        daily.drive(30.0);

        // drive back from work, stopping at a gas station
        System.out.println("Driving back from work...");
        daily.drive(5);
        daily.gasUp();
        daily.drive(55);

        // inform user of the car they will use for the vacation and drive to the airport
        System.out.println("Back from work!");
        System.out.println("I plan to go on a vacation in my: " + vacation.getInfo());
        System.out.println("Driving to the airport...");
        vacation.drive(100.0);
    }
} // CarDriver class
