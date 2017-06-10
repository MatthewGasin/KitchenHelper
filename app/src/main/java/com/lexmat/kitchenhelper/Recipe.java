package com.lexmat.kitchenhelper;

public class Recipe {

    private String name;

    //The character or string to be used to separate ingredients
    final static String INGREDIENT_SEPARATOR = "~";

    private String ingredientNames;
    private double    ingredientAmounts;
    private String ingredientTypes;

    /* Example recipe
                name =  "pancakes"
    ingredientNames =   "Batter~Milk~Oil~Egg"
    ingredientAmounts = "1~3/4~1+1/2~1"
    ingredientTypes =   "cup~cup~tablespoon~ "
     */

    public Recipe(String name, String ingredientNames, double ingredientAmounts, String ingredientTypes) {
        this.name = name;
        this.ingredientNames = ingredientNames;
        this.ingredientAmounts = ingredientAmounts;
        this.ingredientTypes = ingredientTypes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getIngredientSeparator() {
        return INGREDIENT_SEPARATOR;
    }

    public String getIngredientNames() {
        return ingredientNames;
    }

    public void setIngredientNames(String ingredientNames) {
        this.ingredientNames = ingredientNames;
    }

    public double getIngredientAmounts() {
        return ingredientAmounts;
    }

    public void setIngredientAmounts(double ingredientAmounts) {
        this.ingredientAmounts = ingredientAmounts;
    }

    public String getIngredientTypes() {
        return ingredientTypes;
    }

    public void setIngredientTypes(String ingredientTypes) {
        this.ingredientTypes = ingredientTypes;
    }
}
