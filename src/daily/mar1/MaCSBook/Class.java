/*
 * Programmer: Daniel Ye
 * Teacher: Ms. Krasteva
 * Date: March 7, 2022
 * Description: The data structure for a class, including categories and students
 */

package daily.mar1.MaCSBook;

import java.util.*;

public class Class {
    /**
     * The list of students
     */
    private final ArrayList<Student> students;
    /**
     * The list of categories
     */
    private final ArrayList<Category> categories;
    /**
     * The name of the class
     */
    private final String name;

    public Class(String name){
        this.name = name;
        students = new ArrayList<Student>();
        categories = new ArrayList<Category>();
    }

    /**
     * @return the name of the class
     */
    public String getName(){
        return name;
    }

    /**
     * adds a student to the class
     * @param toAdd the student to add
     */
    public void addStudent(Student toAdd){
        students.add(toAdd);
    }

    /**
     * checks for if a student number already exists
     * @param studentNumber the student number to check for
     * @return whether or not a student with that number exists
     */
    public boolean hasStudent(int studentNumber){
        for(Student i : students){
            if(i.getNumber() == studentNumber) return true;
        }
        return false;
    }

    /**
     * removes a student
     * @param index the index of the student to remove from this class
     */
    public void removeStudent(int index){
        students.remove(index);
    }

    /**
     * checks if a category exists
     * @param name the name of the category
     * @return whether a category with name [name] exists
     */
    public boolean hasCategory(String name){
        for(Category i : categories){
            if(i.getName().trim().equals(name.trim())) return true;
        }
        return false;
    }

    /**
     * Removes a category
     * @param index the index of the category
     */
    public void removeCategory(int index){
        for(Student i : students){
            i.removeCategory(categories.get(index).getName());
        }
        categories.remove(index);
    }

    /**
     * @return the list of students in this class
     */
    public ArrayList<Student> getStudents(){
        return new ArrayList<Student>(students);
    }

    /**
     * @return the list of categories this class is marked on
     */
    public ArrayList<Category> getCategories(){
        return new ArrayList<Category>(categories);
    }

    /**
     * adds a category to the class
     * @param toAdd the category to add
     */
    public void addCategory(Category toAdd){
        categories.add(toAdd);
    }

    /**
     * Converts the students into a list of marks containing their weighted (final) average and a weight of 1
     * @return a list of marks corresponding to each student
     */
    public ArrayList<Mark> asMarks(){
        ArrayList<Mark> ret = new ArrayList<Mark>();
        for(Student i : students){
            ret.add(new Mark(i.weightedAverage(categories), 1, i.toString(), i.toString()));
        }
        return ret;
    }

    /**
     * Returns the students' marks for a particular category
     * @param category the category to filter out
     * @return a list of marks for a particular category
     */
    public ArrayList<Mark> asMarks(Category category){
        ArrayList<Mark> catMarks = new ArrayList<Mark>();
        for(Student i : students){
            catMarks.add(new Mark(i.categoryMean(category), 1, i.toString(), category.getName()));
        }
        return catMarks;
    }

    /**
     * @param name the category to check for
     * @return the class average for a particular category
     */
    public double categoryAverage(Category name){
        return Mark.calcAverage(asMarks(name));
    }

    /**
     * @param name the category to check for
     * @return the class median for a particular category
     */
    public double categoryMedian(Category name){
        return Mark.getMedian(asMarks(name));
    }

    /**
     * @return the class average
     */
    public double classAverage(){
        return Mark.calcAverage(asMarks());
    }

    /**
     * @return the class median
     */
    public double classMedian(){
        return Mark.getMedian(asMarks());
    }

    public String toString(){
        return name;
    }
}
