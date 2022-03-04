package daily.mar1.MaCSBook;

public class Category {
    private final String name;
    private int weight;

    public Category(String name, int weight){
        this.name = name;
        this.weight = weight;
    }
    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String toString(){
        return name + " (weighted " + weight + ")";
    }
}
