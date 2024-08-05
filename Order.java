/**
        * Order: represents an order for the coop problem.
 **/

public class Order {
    public String family_name;
    public String recipe_name;

    public Order(String family, String recipe) {
        this.family_name = family;
        this.recipe_name = recipe;
    }


    public String toString() {
        return "order: " + this.family_name + " " + this.recipe_name;
    }
}
