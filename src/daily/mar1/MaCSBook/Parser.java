/*
 * Programmer: Daniel Ye
 * Teacher: Ms. Krasteva
 * Date: March 7, 2022
 * Description: The class-to-file and file-to-class parser for a specific Class.
 */

package daily.mar1.MaCSBook;

import java.io.*;
import java.util.ArrayList;

public class Parser {

    /**
     * Converts the student into a string
     * @param toWrite the student to write into a string
     * @return the string-ified version of the student
     */
    public static String studentString(Student toWrite) {
        // template: [First Name],[Last Name],[Student number];[Mark 1];[Mark 2];...
        StringBuilder cur = new StringBuilder(toWrite.getFirstName() + "," + toWrite.getLastName() + "," + toWrite.getNumber());
        for (StudentMark i : toWrite.getMarks()) {
            // each mark is in this format: Name,Category,Weight,Mark,Total Number of Marks
            cur.append(';').append(i.getName()).append(',').append(i.getCategory()).append(',').append(i.getWeight()).
                    append(',').append(i.getMark()).append(',').append(i.getOutOf());
        }
        return cur.toString();
    }

    /**
     * Writes a class to a file
     * @param toWrite the class to serialize
     * @param fileName the name of the file to write to
     */
    public static void writeClass(Class toWrite, String fileName) {
        try {
            // open a writer for the class
            PrintWriter writer = new PrintWriter(new FileWriter(fileName));
            writer.println(toWrite.getName());
            // category heading
            writer.println("Categories:");
            // list of string categories
            ArrayList<String> catStrings = new ArrayList<String>();
            for (Category i : toWrite.getCategories()) {
                // Format: Category Name, Category Weight
                catStrings.add(i.getName() + "," + i.getWeight());
            }
            // write the categories, joined by a ';'
            writer.println(String.join(";", catStrings));

            // print out each student
            writer.println("Students:");
            for (Student i : toWrite.getStudents()) {
                writer.println(studentString(i));
            }

            // print to the file
            writer.close();
        } catch (IOException e) {
            System.out.println("Something went wrong...");
        }
    }

    /**
     * Parses a student from a line
     * @param line the serialized student
     * @return the object after parsing the string
     */
    public static Student parseStudent(String line) {
        // each "part" of the student is split by a semicolon
        String[] parts = line.split(";");
        // Summary Format: First Name, Last name, Student Number
        String[] summary = parts[0].split(",");
        Student cur = new Student(summary[0], summary[1], Integer.parseInt(summary[2]));

        // the remaining "parts" are the marks
        for (int i = 1; i < parts.length; i++) {
            // Mark Format: Name,Category,Weight,Mark,Total Number of Marks
            String[] markParts = parts[i].split(",");
            cur.addMark(new StudentMark(Integer.parseInt(markParts[3]), Integer.parseInt(markParts[4]), Integer.parseInt(markParts[2]), markParts[0], markParts[1]));
        }
        return cur;
    }

    /**
     * Parses a serialized file into a class object
     * @param fileName the name of the file
     * @return the class the file stores
     * @throws IOException if there was an error in opening or reading the file
     */
    public static Class parseClass(String fileName) throws IOException{
        // open a reader for the file
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        // a new class with the name of the first line
        Class cur = new Class(br.readLine());
        br.readLine();
        // list of categories (as a string)
        String[] cats = br.readLine().split(";");
        for(String i : cats){
            // initialize each category and add it
            String[] parts = i.split(",");
            cur.addCategory(new Category(parts[0], Integer.parseInt(parts[1])));
        }
        br.readLine();
        String line;
        while((line=br.readLine()) != null){
            // for each of the remaining lines, they are equivalent to a student
            cur.addStudent(parseStudent(line));
        }
        return cur;
    }
}
