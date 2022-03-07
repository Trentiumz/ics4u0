/*
 * Programmer: Daniel Ye
 * Teacher: Ms. Krasteva
 * Date: March 7, 2022
 * Description: The data structure for any particular mark. Also contains algorithms for the mode and median
 */

package daily.mar1.MaCSBook;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Mark {
    /**
     * The score "as a decimal" of the mark
     */
    private double score;
    /**
     * The weight/importance of the mark
     */
    private int importance;
    /**
     * The name of the mark/assignment
     */
    private final String name;
    /**
     * The category the mark is a part of
     */
    private final String category;

    /**
     * Class constructor
     * @param score the score (as a decimal/fraction) that the student got
     * @param importance the weight of the mark
     * @param name the name of the mark
     * @param category the category the mark is a part of
     */
    public Mark(double score, int importance, String name, String category){
        this.score = score;
        this.importance = importance;
        this.name = name;
        this.category = category;
    }

    /**
     * @return the name of the mark
     */
    public String getName() {
        return name;
    }

    /**
     * sets the score of the mark
     * @param score the score to set it to
     */
    public void setScore(double score) {
        this.score = score;
    }

    /**
     * sets the weight of the mark
     * @param importance the importance/weight of the mark
     */
    public void setImportance(int importance) {
        this.importance = importance;
    }

    /**
     * @implNote This gives the weighted contribution - is multiplied by getWeight()
     * @return the number of points that this contributes
     */
    public double getPoints() {
        return score * importance;
    }

    /**
     * @return the score (percentage mark) of this mark
     */
    public double getScore(){
        return score;
    }

    /**
     * @return the weight or importance of this mark
     */
    public int getWeight() {
        return importance;
    }

    public String toString(){
        DecimalFormat format = new DecimalFormat("00.##");
        return name + " (" + category + "): " + format.format(100 * score) + "% with a weight of " + getWeight();
    }

    /**
     * sorts the marks in a list of marks
     * @param marks the list of marks for a category or student
     * @return a new list with sorted marks
     */
    private static ArrayList<Mark> sortMarks(ArrayList<Mark> marks) {
        ArrayList<Mark> ret = new ArrayList<Mark>(marks);
        // run bubble search on the Marks, sorting by the mark score/percentage
        for (int iter = 0; iter < ret.size(); iter++) {
            for (int i = 0; i < ret.size() - 1; i++) {
                if (ret.get(i).getScore() > ret.get(i + 1).getScore()) {
                    Mark tmp = ret.get(i);
                    ret.set(i, ret.get(i + 1));
                    ret.set(i + 1, tmp);
                }
            }
        }
        return ret;
    }

    /**
     * returns the total weight of a list of marks
     * @param marks the list of marks
     * @return the total weight
     */
    private static int totWeight(ArrayList<Mark> marks){
        // sum of weights of a list of marks
        int tot = 0;
        for(Mark i : marks){
            tot += i.getWeight();
        }
        return tot;
    }

    /**
     * returns the weighted average of a list of marks
     * @param marks the list of marks
     * @return the weighted average
     */
    public static double calcAverage(ArrayList<Mark> marks){
        if(marks.isEmpty()) return 0.0;
        // total number of points divided by the total weight of the marks
        double points = 0;
        for(Mark i : marks){
            points += i.getPoints();
        }
        return points / totWeight(marks);
    }

    /**
     * returns the weighted median of a list of marks
     * @param marks the list of marks
     * @return the weighted median
     */
    public static double getMedian(ArrayList<Mark> marks){
        if(marks.isEmpty()) return 0.0;
        marks = sortMarks(marks);
        // total weight, half of the weight, weights before (for use in loop)
        int tot = totWeight(marks);
        // half is the supposed "index" at which the median should be in
        double half = (double) tot / 2;
        int weightsBefore = 0;

        for(int i = 0; i < marks.size(); i++){
            // get the current weight
            int weight = marks.get(i).getWeight();

            // if the sides to the left and right are both less than half, then this is the "middle"
            if(weightsBefore < half && tot - weightsBefore - weight < half){
                return marks.get(i).getScore();
            } else if(tot % 2 == 0 && tot - weightsBefore - weight == tot / 2) {
                // the only exception is when tot is even and this is right on the 'edge' - return the average of the two sides
                return (marks.get(i).getScore() + marks.get(i + 1).getScore()) / 2;
            }
            // before continuing, add the weight of this element
            weightsBefore += weight;
        }

        System.out.println("getMedian has unintended behavior - please check the code: " + marks);
        return 0.0;
    }

    /**
     * @return this mark's category
     */
    public String getCategory(){
        return category;
    }
}
