package daily.mar1.MaCSBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Driver {

    Scanner sc = new Scanner(System.in);

    public int getInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String val = sc.nextLine();
            try {
                return Integer.parseInt(val);
            } catch (NumberFormatException ignored) {
            }
        }
    }

    public int getInt(String prompt, int lo, int hi) {
        while (true) {
            int inp = getInt(prompt);
            if (lo <= inp && inp <= hi) return inp;
        }
    }

    public String getLine(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    public boolean getYes(String prompt) {
        while (true) {
            System.out.print(prompt);
            String inp = sc.nextLine();
            if (inp.equalsIgnoreCase("Y")) return true;
            else if (inp.equalsIgnoreCase("N")) return false;
        }
    }

    public String getOption(String prompt, ArrayList<String> options) {
        String line = "";
        while (!options.contains(line)) {
            System.out.print(prompt + " " + options + ": ");
            line = sc.nextLine();
        }
        return line;
    }

    public void studentMenu(Student edit, ArrayList<Category> categories) {
        String ins = "";
        ArrayList<String> options = new ArrayList<String>();
        for (Category i : categories) options.add(i.getName());
        while (!ins.equals("4")) {
            System.out.println("Actions for " + edit + ": ");
            System.out.println("Add Assignment (1)");
            System.out.println("View Summary (2)");
            System.out.println("Edit Assignments (3)");
            System.out.println("Exit (4)");
            ins = sc.nextLine();
            switch (ins) {
                case "1":
                    String name = getLine("Please enter the name of the assignment: ");
                    int outOf = getInt("Please enter the total marks: ");
                    int mark = getInt("Please enter the mark: ", 0, outOf);
                    int weight = getInt("Please enter the importance: ");
                    String category = getOption("Please enter the category of the assignment", options);
                    if (getYes("Are you sure you want to enter in this assignment (Y/N)?")) {
                        edit.addMark(new StudentMark(mark, outOf, weight, name, category));
                    }
                    break;
                case "2":
                    System.out.println(edit);
                    System.out.println("Average: " + edit.calcAverage());
                    System.out.println("Median: " + edit.getMedian());
                    System.out.println("Weighted Average: " + edit.weightedAverage(categories));
                    System.out.println("Blended Median: " + edit.weightedMedian(categories));
                    System.out.println();
                    System.out.println("Categorical Information: ");
                    for (Category i : categories) {
                        System.out.println(i + " mark: " + edit.categoryMean(i));
                        System.out.println(i + " median mark: " + edit.categoryMedian(i));
                    }

                    System.out.println();
                    System.out.println("List of Marks");
                    for(Mark i : edit.getMarks()){
                        System.out.println(i);
                    }
                    System.out.println();
                    break;
                case "3":
                    ArrayList<StudentMark> studentMarks = edit.getMarks();
                    for (int i = 0; i < studentMarks.size(); i++) {
                        System.out.println("[" + i + "] " + studentMarks.get(i));
                    }
                    int curInd = getInt("Please enter the index of the assignment to change (-1 for none): ", -1, studentMarks.size() - 1);
                    StudentMark toChange = studentMarks.get(curInd);
                    if (curInd >= 0) {
                        System.out.println("Actions: ");
                        System.out.println("Set Mark (1)");
                        System.out.println("Set Total Marks (2)");
                        System.out.println("Set weight (3)");
                        System.out.println("Remove (4)");
                        System.out.println("Exit (5)");
                        int action = getInt("Please enter your desired action: ", 1, 5);
                        if (action == 1) {
                            mark = getInt("The student mark: ", 0, toChange.getOutOf());
                            toChange.setMark(mark);
                            System.out.println("Mark set");
                        } else if(action ==2) {
                            outOf = getInt("The total # of marks: ", 1, 1000000000);
                            toChange.setOutOf(outOf);
                            System.out.println("Mark set");
                        } else if (action == 3) {
                            studentMarks.get(curInd).setImportance(getInt("Please enter the weight of the assessment: ", 1, 10000000));
                        } else if (action == 4) {
                            edit.removeMark(curInd);
                        }
                    }
                    break;
            }
        }
    }

    public void classMenu(Class curClass){
        boolean inMenu = true;
        while(inMenu){
            System.out.println("Actions for " + curClass + ": ");
            System.out.println("View summary (1)");
            System.out.println("Edit Student (2)");
            System.out.println("Add Student (3)");
            System.out.println("Remove Student (4)");
            System.out.println("Add Category (5)");
            System.out.println("Remove Category (6)");
            System.out.println("Exit (7)");
            switch(getInt("Please enter the option you wish to take: ", 1, 7)){
                case 1:
                    System.out.println("Class Average: " + curClass.classAverage());
                    System.out.println("Class Median: " + curClass.classMedian());
                    System.out.println();
                    System.out.println("Category Averages: ");
                    for(Category i : curClass.getCategories()){
                        System.out.println(i + ": Average = " + curClass.categoryAverage(i) + "\tMedian = " + curClass.categoryMedian(i));
                    }
                    break;
                case 2:
                    ArrayList<Student> students = curClass.getStudents();
                    for(int i = 0; i < students.size(); i++){
                        System.out.println("[" + i + "] " + students.get(i));
                    }
                    int ind = getInt("Please enter the index of the student you want to edit (or -1 to not edit) ", -1, students.size() - 1);
                    if(ind >= 0){
                        studentMenu(students.get(ind), curClass.getCategories());
                    }
                    break;
                case 3:
                    String firstName = getLine("Please enter the first name of the student: ");
                    String lastName = getLine("Please enter the last name of the student: ");
                    int number = -1;
                    while(number < 0){
                        number = getInt("Please enter the student number: ", 100000000, 999999999);
                        if(curClass.hasStudent(number)){
                            System.out.println("A student with that number already exists. ");
                            number = -1;
                        }
                    }
                    if(getYes("Are you sure you want to add the student (Y/N)? ")){
                        curClass.addStudent(new Student(firstName, lastName, number));
                    }
                    break;
                case 4:
                    students = curClass.getStudents();
                    for(int i = 0; i < students.size(); i++){
                        System.out.println("[" + i + "] " + students.get(i));
                    }
                    ind = getInt("Please enter the index of the student you wish to remove (or -1 to not remove) ", -1, students.size() - 1);
                    if(getYes("Are you sure you want to remove " + students.get(ind))){
                        curClass.removeStudent(ind);
                    }
                    break;
                case 5:
                    String catName = "";
                    while(catName.trim().equals("")){
                        catName = getLine("Please enter the name of the category you wish to add: ");
                        if(curClass.hasCategory(catName)){
                            System.out.println("That category already exists. ");
                            catName = "";
                        }
                    }
                    int weight = getInt("Please enter the weight of this category: ", 1, 100000000);
                    if(getYes("Are you sure you want to add category '" + catName + "' (Y/N)? ")){
                        curClass.addCategory(new Category(catName, weight));
                        System.out.println("Category added");
                    }
                    break;
                case 6:
                    ArrayList<Category> categories = curClass.getCategories();
                    for(int i = 0; i < categories.size(); i++){
                        System.out.println("[" + i + "] " + categories.get(i));
                    }
                    ind = getInt("Please enter the index of the category to remove (or -1 to not remove any): ", -1, categories.size() - 1);
                    if(ind >= 0 && getYes("Are you sure you want to remove the category (Y/N)? ")){
                        curClass.removeCategory(ind);
                        System.out.println("Category removed.");
                    }
                    break;
                case 7:
                    inMenu = false;
                    break;
                default:
                    System.out.println("Something went wrong...");
            }
        }
    }

    public void testStudent() {
        Student tom = new Student("Tom", "Job", 335123123);
        studentMenu(tom, new ArrayList<Category>(Arrays.asList(new Category("Knowledge", 10), new Category("Understanding", 20))));
    }

    public static void main(String[] args) {
        new Driver().testStudent();
    }
}
