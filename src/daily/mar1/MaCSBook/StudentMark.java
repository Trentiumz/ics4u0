/*
 * Programmer: Daniel Ye
 * Teacher: Ms. Krasteva
 * Date: March 7, 2022
 * Description: The data structure for a User-Friendly Mark. This also contains information on the total number of marks assigned and the number of marks a student achieved.
 */

package daily.mar1.MaCSBook;

public class StudentMark extends Mark{
    /**
     * The mark of the student
     */
    private int mark;
    /**
     * The total number of marks of the assignment
     */
    private int outOf;

    /**
     * Class constructor
     * @param mark the mark the student got
     * @param outOf the total number of marks
     * @param importance the weight of the mark
     * @param name the name of the mark/assignment
     * @param category the category the mark is a part of
     */
    public StudentMark(int mark, int outOf, int importance, String name, String category){
        super((double) mark / outOf, importance, name, category);
        this.mark = mark;
        this.outOf = outOf;
    }

    /**
     * updates the score given the mark achieved and total marks
     */
    private void updateScore(){
        setScore((double) mark / outOf);
    }

    /**
     * @return the mark
     */
    public int getMark() {
        return mark;
    }

    /**
     * sets the mark
     * @param mark the mark to set to
     */
    public void setMark(int mark) {
        this.mark = mark;
        updateScore();
    }

    /**
     * @return the total number of marks
     */
    public int getOutOf() {
        return outOf;
    }

    /**
     * sets the total number of marks
     * @param outOf the total number of marks
     */
    public void setOutOf(int outOf) {
        this.outOf = outOf;
        updateScore();
    }

    public String toString(){
        return getName() + " (" + getCategory() + "): " + mark + "/" + outOf;
    }
}
