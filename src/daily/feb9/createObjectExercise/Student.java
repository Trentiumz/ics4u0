/*
 * Ms. Krasteva
 * Taken from "Evaluation OOP" - used with the Driver class
 */

package daily.feb9.createObjectExercise;

public class Student {
    public String name;
    public int mark1;
    public int mark2;
    public double average;

    public Student(String n) {
        name = n;
        mark1 = 0;
        mark2 = 0;
        average = 0.0;
    }

    public void setMarks(int x, int y) {
        mark1 = x;
        mark2 = y;
    }

    public void calcAverage() {
        average = (mark1 + mark2) / 2;
    }

    public String message() {
        return name + "You got an " + average;
    }
} // Student class
