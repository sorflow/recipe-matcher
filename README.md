# RecipeMatcher

**RecipeMatcher** is a Java-based application that allows users to find recipes based on the ingredients they have on hand. The user selects ingredients from a predefined list, and the program identifies which recipes can be made with the selected ingredients. Additionally, the app suggests recipes that are missing only one ingredient.

## Features

- **Custom UI Font**: Uses Helvetica font for a clean, modern UI in `JOptionPane` dialogs.
- **Recipe Suggestions**: Displays all recipes that can be fully prepared with the user's selected ingredients.
- **Nearly Complete Recipes**: Shows recipes that are just one ingredient short.
- **Interactive Ingredient Selection**: A user-friendly pop-up interface for selecting ingredients.
  
## Technologies Used

- **Java Swing**: For graphical user interface (GUI) components.
- **JOptionPane**: To create dialog boxes for user interaction.
- **Collections Framework**: Used for handling recipes and ingredient lists.

## Installation

1. Clone this repository.
   ```bash
   https://github.com/sorflow/recipe-matcher.git
   ```
2. Open the project in your favorite Java IDE (e.g., IntelliJ IDEA, Eclipse).
3. Compile and run the `RecipeMatcher.java` file.

## How to Use

1. **Launch the Application**: Run `RecipeMatcher` from your IDE or terminal.
2. **Select Ingredients**: The application will display a list of available ingredients. You can choose multiple ingredients using a pop-up menu.
3. **View Recipes**: After selecting your ingredients, the application will:
   - Display all the recipes you can make with the chosen ingredients.
   - Suggest recipes that are missing only one ingredient.
4. **Exit**: You can exit the program by selecting "Cancel" or closing any dialog.

## Code Overview

The project consists of several key components:

### `Recipe`
This class holds the name, ingredients, and instructions for each recipe. 

### `getUserIngredients()`
Prompts the user to select ingredients via a dialog box. The user can select multiple ingredients, and duplicates are not allowed.

### `findCookableRecipes()`
Identifies recipes that can be made using the user's available ingredients.

### `printCookableRecipes()`
Displays the cookable recipes with detailed step-by-step instructions.

### `printNearlyCompleteRecipes()`
Lists recipes that are only missing one ingredient from the user's selection.

### `initializeRecipes()`
Creates and returns a collection of pre-defined recipes. Each recipe contains a name, a list of required ingredients, and the steps for preparation.

### `initializeAvailableIngredients()`
Provides a predefined list of available ingredients the user can choose from.

## Example Recipes

Here are a few examples of recipes included in the program:

- **Pasta Carbonara**  
  Ingredients: pasta, eggs, bacon, cheese, black pepper  
  Instructions:
  1. Cook pasta according to package instructions.
  2. Fry bacon until crispy.
  3. Beat eggs with grated cheese and pepper.
  4. Drain pasta and mix with egg mixture and bacon.
  5. Serve immediately.

- **Vegetable Stir Fry**  
  Ingredients: rice, carrot, broccoli, soy sauce, garlic  
  Instructions:
  1. Cook rice according to package instructions.
  2. Chop vegetables.
  3. Heat oil in a pan and add minced garlic.
  4. Add vegetables and stir-fry until tender-crisp.
  5. Add soy sauce and stir.
  6. Serve over rice.

- **Omelette**  
  Ingredients: eggs, cheese, milk, salt, butter  
  Instructions:
  1. Beat eggs with milk and salt.
  2. Melt butter in a non-stick pan.
  3. Pour in egg mixture and cook until almost set.
  4. Add cheese and fold omelette.
  5. Cook for another minute and serve.

## Future Improvements

- Add the ability for users to input custom recipes.
- Implement dietary filters (e.g., vegetarian, gluten-free).
- Allow users to add ingredients not in the predefined list.

## License

This project is licensed under the MIT License. 
