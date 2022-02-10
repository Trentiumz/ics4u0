/*
 * Ms. Krasteva
 * Taken from "Evaluation OOP" - to be used with the Driver class
 */

package daily.feb9.createObjectExercise;

public class Animal {
    private String name;
    private boolean tired;
    private boolean hungry;
    private double weight;

    public Animal(String n, double w) {
        name = n;
        tired = true;
        hungry = true;
        weight = w;
    }

    public void feed(String v) {
        hungry = false;
        if (v.equals("vegetables"))
            weight += 2;
        else if (v.equals("meat"))
            weight += 4;
        else
            weight += 1;
    }

    public void sleep() {
        tired = false;
        weight -= 3;
    }
} // Animal class
