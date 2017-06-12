package com.lexmat.kitchenhelper;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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
            pancakesDefault.setName("Pancakes");
            pancakesDefault.setIngredientNames("Batter~Milk~Oil~Eggs");
            pancakesDefault.setIngredientAmounts("1~3/4~1~1");
            pancakesDefault.setIngredientTypes("cup~cup~tablespoon~ ");

            db.insertRecipe(pancakesDefault);

            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstTime", true);
            editor.commit();
        }

        //start the recipe activity with the default recipe
        Intent intent = new Intent(this, RecipeActivity.class);
        intent.putExtra("name","Recipe");
        intent.putExtra("ingredientNames","Ingredient A~Ingredient B~Ingredient C");
        intent.putExtra("ingredientAmounts","1~2~2");
        intent.putExtra("ingredientTypes","Cup~Teaspoon~Pound");
        startActivity(intent);
    }

    protected void onRestart(){
        super.onRestart();
        Intent intent = new Intent(this, RecipeActivity.class);
        startActivity(intent);
    }
}
