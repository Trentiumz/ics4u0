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

    public static String studentString(Student toWrite) {
        StringBuilder cur = new StringBuilder(toWrite.getFirstName() + "," + toWrite.getLastName() + "," + toWrite.getNumber());
        for (StudentMark i : toWrite.getMarks()) {
            cur.append(';').append(i.getName()).append(',').append(i.getCategory()).append(',').append(i.getWeight()).
                    append(',').append(i.getMark()).append(',').append(i.getOutOf());
        }
        return cur.toString();
    }

    public static void writeClass(Class toWrite, String fileName) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(fileName));
            writer.println(toWrite.getName());
            writer.println("Categories:");
            ArrayList<String> catStrings = new ArrayList<String>();
            for (Category i : toWrite.getCategories()) {
                catStrings.add(i.getName() + "," + i.getWeight());
            }
            writer.println(String.join(";", catStrings));
            writer.println("Students:");
            for (Student i : toWrite.getStudents()) {
                writer.println(studentString(i));
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Something went wrong...");
        }
    }

    public static Student parseStudent(String line) {
        String[] parts = line.split(";");
        String[] summary = parts[0].split(",");
        Student cur = new Student(summary[0], summary[1], Integer.parseInt(summary[2]));
        for (int i = 1; i < parts.length; i++) {
            String[] markParts = parts[i].split(",");
            cur.addMark(new StudentMark(Integer.parseInt(markParts[3]), Integer.parseInt(markParts[4]), Integer.parseInt(markParts[2]), markParts[0], markParts[1]));
        }
        return cur;
    }

    public static Class parseClass(String fileName) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        Class cur = new Class(br.readLine());
        br.readLine();
        String[] cats = br.readLine().split(";");
        for(String i : cats){
            String[] parts = i.split(",");
            cur.addCategory(new Category(parts[0], Integer.parseInt(parts[1])));
        }
        br.readLine();
        String line;
        while((line=br.readLine()) != null){
            cur.addStudent(parseStudent(line));
        }
        return cur;
    }
}
