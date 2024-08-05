import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Coop {

    public static Map<String, Integer> mkCoopOrder(List<Ingredient> pantry_items,
                                                   List<Ingredient> recipe_items,
                                                   List<Order> orders) {
        // TODO: complete this function
        Map<String, Map<String,Integer>> pantryItems = new HashMap<>();
        for (Ingredient ingredient : pantry_items) {
            String key= ingredient.key;
            String name = ingredient.name;
            int amount = ingredient.amount;
            pantryItems.putIfAbsent(key, new HashMap<>());
            Map<String, Integer> nameAmount = pantryItems.get(key);
            nameAmount.put(name, amount);
            pantryItems.put(key, nameAmount);
        }

        Map<String, Map<String,Integer>> recipeItems = new HashMap<>();
        for (Ingredient ingredient : recipe_items) {
            String key= ingredient.key;
            String name = ingredient.name;
            int amount = ingredient.amount;
            recipeItems.putIfAbsent(key, new HashMap<>());
            Map<String, Integer> nameAmount = recipeItems.get(key);
            nameAmount.put(name, amount);
            pantryItems.put(key, nameAmount);
        }
        Map<String,Integer> orderItems = new HashMap<>();
        for (Order order : orders) {
            String familyName=order.family_name;
            String recipeName=order.recipe_name;

            Map<String, Integer> recipeIngredients=recipeItems.get(recipeName);
            Map<String, Integer> familyPantry=pantryItems.getOrDefault(familyName, new HashMap<>());
            for (Map.Entry<String, Integer> entry : recipeIngredients.entrySet()) {
                String ingredientName = entry.getKey();
                int quantity = entry.getValue();
                int pantryIngredient=familyPantry.get(ingredientName);
                int quantityNeeded=quantity-pantryIngredient;
                if (quantityNeeded>0) {
                    orderItems.put(ingredientName, quantity);
                }
            }
        }
        return orderItems;
    }
}