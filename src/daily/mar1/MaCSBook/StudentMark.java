package daily.mar1.MaCSBook;

public class StudentMark extends Mark{
    private int mark, outOf;
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
