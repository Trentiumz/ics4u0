/*
 * Programmer: Daniel Ye
 * Teacher: Ms. Krasteva
 * Date: March 7, 2022
 * Description: The behavior and attributes for a particular student
 */

package daily.mar1.MaCSBook;

import java.util.*;

public class Student {

    /**
     * the name of the student
     */
    private final String firstName, lastName;
    /**
     * The student number
     */
    private final int number;
    /**
     * A list of marks for the student
     */
    private ArrayList<StudentMark> marks;

    public Student(String firstName, String lastName, int studentNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = studentNumber;
        marks = new ArrayList<StudentMark>();

    }

    /**
     * Give this student a mark
     * @param add the mark to add
     */
    public void addMark(StudentMark add){
        marks.add(add);
    }

    /**
     * @param name the name of the category to filter for
     * @return a list with all the marks of [name] category
     */
    private ArrayList<Mark> filterCategory(String name){
        ArrayList<Mark> ret = new ArrayList<Mark>();
        for(Mark i : marks){
            if(i.getCategory().equals(name)) ret.add(i);
        }
        return ret;
    }

    /**
     * @param category the category to filter for
     * @return the mean of the category
     */
    public double categoryMean(Category category){
        return Mark.calcAverage(filterCategory(category.getName()));
    }

    /**
     * @param category the category to filter for
     * @return the median of the category
     */
    public double categoryMedian(Category category){
        return Mark.getMedian(filterCategory(category.getName()));
    }

    /**
     * Every category can be "compressed" into a percentage mark and weight
     * this method returns the corresponding mark of every category
     * @return a list of corresponding marks for each category
     */
    public ArrayList<Mark> categoryMean(ArrayList<Category> categories){
        ArrayList<Mark> catMarks = new ArrayList<Mark>();
        for(Category i : categories){
            if(!filterCategory(i.getName()).isEmpty()) catMarks.add(new Mark(categoryMean(i), i.getWeight(), i.getName(), i.getName()));
        }
        return catMarks;
    }

    /**
     * returns the mark of each category, but each mark is evaluated as a median rather than a range
     * @param categories the list of categories to check for
     * @return a list of corresponding marks for each category
     */
    public ArrayList<Mark> categoryMedian(ArrayList<Category> categories){
        ArrayList<Mark> catMarks = new ArrayList<Mark>();
        for(Category i : categories){
            if(!filterCategory(i.getName()).isEmpty()) catMarks.add(new Mark(categoryMedian(i), i.getWeight(), i.getName(), i.getName()));
        }
        return catMarks;
    }

    /**
     * @return a copy of the marks array
     */
    public ArrayList<StudentMark> getMarks(){
        return new ArrayList<StudentMark>(marks);
    }

    /**
     * removes a mark
     * @param index the index of the mark (in the internal [marks] list) to remove
     */
    public void removeMark(int index){
        marks.remove(index);
    }

    /**
     * @return the weighted average of all the marks
     */
    public double calcAverage(){
        return Mark.calcAverage(new ArrayList<Mark>(marks));
    }

    /**
     * @return the weighted median of all the marks
     */
    public double getMedian(){
        return Mark.getMedian(new ArrayList<Mark>(marks));
    }

    /**
     * Returns the weighted average of each category
     * @implNote this method converts each category into a mark, where the score is its average and its weight is
     *              the user-given value. It will then find the weighted average of such scores
     * @param categories the list of categories to check for
     * @return the weighted average of them
     */
    public double weightedAverage(ArrayList<Category> categories){
        return Mark.calcAverage(categoryMean(categories));
    }

    /**
     * Removes all marks with a specific category name
     * @param categoryName the name of the category to remove
     */
    public void removeCategory(String categoryName){
        ArrayList<StudentMark> without = new ArrayList<StudentMark>();
        for(StudentMark i : marks){
            if(!i.getCategory().equals(categoryName)) without.add(i);
        }
        marks = without;
    }

    /**
     * Returns the weighted average of each category
     * @implNote This method is the same as weightedAverage, but each category is evaluated as a median instead
     * @param categories the list of categories
     * @return the weighted average of them
     */
    public double weightedMedian(ArrayList<Category> categories){
        return Mark.calcAverage(categoryMedian(categories));
    }

    public int getNumber() {
        return number;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String toString(){
        return firstName + " " + lastName + " (" + number + ")";
    }

}
