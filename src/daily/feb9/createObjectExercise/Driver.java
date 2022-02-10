/*
* Daniel Ye
* Feb 9, 2022
* Ms. Krasteva
* This is a Driver class displaying the usage of Student.java, Car.jav, Animal.java, and House.java;
* all of which are pre-written code given in the assignment. This will display usage of objects, constructors, and instance methods
 */

package daily.feb9.createObjectExercise;

public class Driver {
    public static void main(String[] args){
        // initialize 3 Student objects
        Student bob = new Student("Bobert");
        Student fred = new Student("Fred");
        Student pun = new Student("Ponzo");

        // initialize 3 houses for each of the students
        House bobHouse = new House(32, "Callium Avenue", "North York", "Ontario", "M4K 6J3", 61.0, false, 2);
        House fredHouse = new House(23, "Pokie Street", "Markham", "Ontario", "H1M 1L1", 25.0, true, 1);
        House punHouse = new House(128, "Concation Road", "Toronto", "Ontario", "C3T 4H4", 230.0, false, 4);

        // initialize 3 cars for each of the students
        Car bobCar = new Car("Toyota", "Corolla", 5, 60);
        Car fredCar = new Car("Honda", "Civic", 20, 45);
        Car punCar = new Car("Ferarri", "Roma", 60, 85);

        // initialize 3 pets, two for respective students and one as a class pet
        Animal punPet = new Animal("Trent", 20.0);
        Animal fredPet = new Animal("Poppy", 10.0);
        Animal classPet = new Animal("Franklin", 0.5);

        // Print out the House Address of each student and their pet, if they have one
        System.out.println("Bob's House: ");
        bobHouse.displayAddress();
        System.out.println("\nFred's House: ");
        fredHouse.displayAddress();
        System.out.println("\nPonzo's House: ");
        punHouse.displayAddress();
        System.out.println();

        // Drive each of the students to school
        bobCar.drive(25.0);
        bobCar.gasUp(); // once bob's car is out of gas, refill it
        bobCar.drive(10.0);
        fredCar.drive(40.0);
        punCar.drive(30.0);

        // Once the students are at school, feed the pet
        System.out.println("Feeding the class Pet...\n");
        classPet.feed("vegetables");
        // after we feed the pet, it falls asleep
        classPet.sleep();

        // set marks for each student
        System.out.println("Marking Assignments and Tests...\n");
        bob.setMarks(70, 90);
        fred.setMarks(90, 95);
        pun.setMarks(60, 63);

        // calculate the average for each student and display their mark average
        System.out.println("Displaying Mark Summary:");
        bob.calcAverage();
        System.out.println(bob.message());
        fred.calcAverage();
        System.out.println(fred.message());
        pun.calcAverage();
        System.out.println(pun.message());

        // once the students are home, feed their pets
        System.out.println("\nFeeding Pets...");
        fredPet.feed("vegetables");
        punPet.feed("meat");
        punPet.sleep();
    }
}
