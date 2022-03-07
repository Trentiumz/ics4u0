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

    /**
     * Class constructor
     * @param name name of the category
     * @param weight weight of the category
     */
    public Category(String name, int weight){
        this.name = name;
        this.weight = weight;
    }

    /**
     * @return name of the category
     */
    public String getName() {
        return name;
    }

    /**
     * @return weight of the category
     */
    public int getWeight() {
        return weight;
    }

    /**
     * sets the weight of the category
     * @param weight the weight of the category
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String toString(){
        return name + " (weighted " + weight + ")";
    }
}
