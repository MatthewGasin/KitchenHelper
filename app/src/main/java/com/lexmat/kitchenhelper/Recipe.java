package com.lexmat.kitchenhelper;

import java.util.ArrayList;

public class Recipe {

    private String name;

    //The character or string to be used to separate ingredients
    final static String INGREDIENT_SEPARATOR = "~";

    private String ingredientNames;
    private String ingredientAmounts;
    private String ingredientTypes;

    /* Example recipe
                name =  "pancakes"
    ingredientNames =   "Batter~Milk~Oil~Egg"
    ingredientAmounts = "1~3/4~1+1/2~1"
    ingredientTypes =   "cup~cup~tablespoon~ "
     */

    public Recipe(String name, String ingredientNames, String ingredientAmounts, String ingredientTypes) {
        this.name = name;
        this.ingredientNames = ingredientNames;
        this.ingredientAmounts = ingredientAmounts;
        this.ingredientTypes = ingredientTypes;
    }

    public Recipe() {
        this.name = "default";
        this.ingredientNames = "default";
        this.ingredientAmounts = "default";
        this.ingredientTypes = "default";
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


    public String getIngredientAmounts() {
        return ingredientAmounts;
    }

    public void setIngredientAmounts(String ingredientAmounts) {
        this.ingredientAmounts = ingredientAmounts;
    }

    public String getIngredientTypes() {
        return ingredientTypes;
    }

    public void setIngredientTypes(String ingredientTypes) {
        this.ingredientTypes = ingredientTypes;
    }

    public ArrayList<String> getIngredients(){
        String names = getIngredientNames();
        String amounts = getIngredientAmounts();
        String types = getIngredientTypes();

        ArrayList<String> ingredients = new ArrayList<String>();

        while(names.contains(INGREDIENT_SEPARATOR)){
            String ingredient = "";
            ingredient += names.substring(0, names.indexOf(INGREDIENT_SEPARATOR)) + " ";
            ingredient += amounts.substring(0, amounts.indexOf(INGREDIENT_SEPARATOR)) + " ";
            ingredient += types.substring(0, types.indexOf(INGREDIENT_SEPARATOR)) + " ";

            names = parse(names);
            amounts = parse(amounts);
            types = parse(types);
            ingredients.add(ingredient);
        }
        ingredients.add(names+" "+amounts+" "+types);

        return ingredients;
    }

    private String parse(String s){
        return s.substring(s.indexOf(INGREDIENT_SEPARATOR)+1);
    }

}
