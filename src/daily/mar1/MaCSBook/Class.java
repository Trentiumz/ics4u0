package daily.mar1.MaCSBook;

import java.util.*;

public class Class {

    private final ArrayList<Student> students;
    private final ArrayList<Category> categories;

    public Class(){
        students = new ArrayList<Student>();
        categories = new ArrayList<Category>();
    }

    /**
     * adds a student to the class
     * @param toAdd the student to add
     */
    public void addStudent(Student toAdd){
        students.add(toAdd);
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

}
