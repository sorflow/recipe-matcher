import javax.swing.*;
import java.util.*;

public class RecipeMatcher {
    private static final Map<String, Recipe> RECIPES = initializeRecipes();
    private static final List<String> AVAILABLE_INGREDIENTS = initializeAvailableIngredients();

    public static void main(String[] args) {
        List<String> userIngredients = getUserIngredients();
        List<Recipe> cookableRecipes = findCookableRecipes(RECIPES, userIngredients);
        printCookableRecipes(cookableRecipes);
        printNearlyCompleteRecipes(RECIPES, userIngredients);
    }

    // Recipe class to hold recipe information
    private static class Recipe {
        String name;
        List<String> ingredients;
        List<String> instructions;

        Recipe(String name, List<String> ingredients, List<String> instructions) {
            this.name = name;
            this.ingredients = ingredients;
            this.instructions = instructions;
        }
    }

    // Get ingredients from user by offering a pop-up list to choose from
    private static List<String> getUserIngredients() {
        List<String> userIngredients = new ArrayList<>();

        // Display a pop-up menu to choose ingredients
        String[] options = AVAILABLE_INGREDIENTS.toArray(new String[0]);
        boolean done = false;

        while (!done) {
            String selectedIngredient = (String) JOptionPane.showInputDialog(
                    null,
                    "Select an ingredient you have (or cancel when done):",
                    "Ingredient Selection",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            if (selectedIngredient != null && !userIngredients.contains(selectedIngredient.toLowerCase())) {
                userIngredients.add(selectedIngredient.toLowerCase());
            } else if (selectedIngredient == null) {
                done = true;  // User pressed cancel, so they're done
            } else {
                JOptionPane.showMessageDialog(null, "You already selected " + selectedIngredient, "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }

        return userIngredients;
    }

    // Find recipes that can be cooked with available ingredients
    private static List<Recipe> findCookableRecipes(Map<String, Recipe> recipes, List<String> userIngredients) {
        List<Recipe> cookableRecipes = new ArrayList<>();

        for (Recipe recipe : recipes.values()) {
            if (userIngredients.containsAll(recipe.ingredients)) {
                cookableRecipes.add(recipe);
            }
        }

        return cookableRecipes;
    }

    // Print the list of cookable recipes with instructions
    private static void printCookableRecipes(List<Recipe> cookableRecipes) {
        if (!cookableRecipes.isEmpty()) {
            StringBuilder message = new StringBuilder("You can make the following recipes:\n");
            for (Recipe recipe : cookableRecipes) {
                message.append("\n- ").append(recipe.name).append("\n  Instructions:\n");
                for (int i = 0; i < recipe.instructions.size(); i++) {
                    message.append("    ").append(i + 1).append(". ").append(recipe.instructions.get(i)).append("\n");
                }
            }
            JOptionPane.showMessageDialog(null, message.toString(), "Cookable Recipes", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Unfortunately, you can't make any of the recipes with the items you have.", "No Recipes", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Print recipes that are missing only one ingredient
    private static void printNearlyCompleteRecipes(Map<String, Recipe> recipes, List<String> userIngredients) {
        StringBuilder message = new StringBuilder("Recipes you're close to making (missing only one ingredient):\n");
        boolean found = false;

        for (Recipe recipe : recipes.values()) {
            List<String> missingIngredients = findMissingIngredients(recipe.ingredients, userIngredients);

            if (missingIngredients.size() == 1) {
                message.append("- ").append(recipe.name).append(" (missing: ").append(missingIngredients.get(0)).append(")\n");
                found = true;
            }
        }

        if (found) {
            JOptionPane.showMessageDialog(null, message.toString(), "Nearly Complete Recipes", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No recipes are close to being completed.", "Nearly Complete Recipes", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Find ingredients that are missing from the user's list
    private static List<String> findMissingIngredients(List<String> ingredients, List<String> userIngredients) {
        List<String> missingIngredients = new ArrayList<>(ingredients);
        missingIngredients.removeAll(userIngredients);
        return missingIngredients;
    }

    // Initialize the recipe database
    private static Map<String, Recipe> initializeRecipes() {
        Map<String, Recipe> recipes = new HashMap<>();

        recipes.put("Pasta Carbonara", new Recipe(
                "Pasta Carbonara",
                Arrays.asList("pasta", "eggs", "bacon", "cheese", "black pepper"),
                Arrays.asList(
                        "Cook pasta according to package instructions",
                        "Fry bacon until crispy",
                        "Beat eggs with grated cheese and pepper",
                        "Drain pasta and mix with egg mixture and bacon",
                        "Serve immediately"
                )
        ));

        recipes.put("Vegetable Stir Fry", new Recipe(
                "Vegetable Stir Fry",
                Arrays.asList("rice", "carrot", "broccoli", "soy sauce", "garlic"),
                Arrays.asList(
                        "Cook rice according to package instructions",
                        "Chop vegetables",
                        "Heat oil in a pan and add minced garlic",
                        "Add vegetables and stir-fry until tender-crisp",
                        "Add soy sauce and stir",
                        "Serve over rice"
                )
        ));

        recipes.put("Omelette", new Recipe(
                "Omelette",
                Arrays.asList("eggs", "cheese", "milk", "salt", "butter"),
                Arrays.asList(
                        "Beat eggs with milk and salt",
                        "Melt butter in a non-stick pan",
                        "Pour in egg mixture and cook until almost set",
                        "Add cheese and fold omelette",
                        "Cook for another minute and serve"
                )
        ));

        // Add more recipes here...

        return recipes;
    }

    // Initialize the list of available ingredients
    private static List<String> initializeAvailableIngredients() {
        return Arrays.asList(
                "pasta", "eggs", "bacon", "cheese", "black pepper", "rice", "carrot",
                "broccoli", "soy sauce", "garlic", "milk", "salt", "butter", "tomato",
                "onion", "chicken", "potato", "flour", "sugar", "lemon"
        );
    }
}
