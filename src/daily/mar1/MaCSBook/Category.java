/*
 * Programmer: Daniel Ye
 * Teacher: Ms. Krasteva
 * Date: March 7, 2022
 * Description: The Category Data structure. Contains the Category name and weight.
 */

package daily.mar1.MaCSBook;

public class Category {
    /**
     * The name of the cateogory
     */
    private final String name;
    /**
     * The weight of the category
     */
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
