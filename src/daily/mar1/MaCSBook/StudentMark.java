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
    public StudentMark(int mark, int outOf, int importance, String name, String category){
        super((double) mark / outOf, importance, name, category);
        this.mark = mark;
        this.outOf = outOf;
    }

    private void updateScore(){
        setScore((double) mark / outOf);
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
        updateScore();
    }

    public int getOutOf() {
        return outOf;
    }

    public void setOutOf(int outOf) {
        this.outOf = outOf;
        updateScore();
    }

    public String toString(){
        return getName() + " (" + getCategory() + "): " + mark + "/" + outOf;
    }
}
