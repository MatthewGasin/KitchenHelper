package com.lexmat.kitchenhelper;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //adding default recipes IF this is the first time the user has opened the app
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        if(!prefs.getBoolean("firstTime", false)) {

            db = new DatabaseHelper(this);

            Recipe pancakesDefault = new Recipe();
            pancakesDefault.setName(getString(R.string.Pancakes));

            pancakesDefault.setIngredientNames(getString(R.string.Batter) + Recipe.getIngredientSeparator()
                    + getString(R.string.Milk) + Recipe.getIngredientSeparator()
                    + getString(R.string.Egg) + Recipe.getIngredientSeparator()
                    + getString(R.string.Oil));

            pancakesDefault.setIngredientAmounts(getString(R.string.One) + Recipe.getIngredientSeparator()
                    + getString(R.string.ThreeFourths) + Recipe.getIngredientSeparator()
                    + getString(R.string.One) + Recipe.getIngredientSeparator()
                    + getString(R.string.One));

            pancakesDefault.setIngredientTypes(getString(R.string.Cup) + Recipe.getIngredientSeparator()
                    + getString(R.string.Cup) + Recipe.getIngredientSeparator()
                    + getString(R.string.Space) + Recipe.getIngredientSeparator()
                    + getString(R.string.Tablespoon));



            db.insertRecipe(pancakesDefault);

            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstTime", true);
            editor.commit();
        }

        //start the recipe activity with the default recipe
        Intent intent = new Intent(this, RecipeActivity.class);
        intent.putExtra("name", getString(R.string.Recipe));
        intent.putExtra("ingredientNames", " ");
        intent.putExtra("ingredientAmounts", " ");
        intent.putExtra("ingredientTypes", " ");
        startActivity(intent);
    }

    protected void onRestart(){
        super.onRestart();
        Intent intent = new Intent(this, RecipeActivity.class);
        startActivity(intent);
    }
}
