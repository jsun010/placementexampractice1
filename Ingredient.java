/**
 * Ingredient: represent an ingredient in a family's pantry, an
 *   ingredient needed for a recipe, or an ingredient in the
 *   coop's ledger.
 **/
public class Ingredient {
    String name;        // the name of the ingredient
    String key;         // a family name or recipe name
    int amount;

    public Ingredient(String ingredient_name,
                      String key,
                      int amount) {
        this.name = ingredient_name;
        this.key = key;
        this.amount = amount;
    }

    public String toString() {
        return "item: " + this.key + " " + this.name + " " + this.amount;
    }
}