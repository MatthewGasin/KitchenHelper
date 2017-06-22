package com.lexmat.kitchenhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class SaveActivity extends AppCompatActivity {

    DatabaseHelper db;
    ListView recipeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);

        db = new DatabaseHelper(this);
        ArrayList<String> recipeNames = db.getRecipeNames();
        recipeList = (ListView) findViewById(R.id.recipeList);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, recipeNames);
        recipeList.setAdapter(arrayAdapter);

        recipeList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                String name = recipeList.getItemAtPosition(position).toString();
                Recipe recipe = db.getRecipe(name);
                if(recipe != null){
                    toRecipeActivity(recipe);
                }
            }
        });
    }

    public void onNew(View view) {
        //start the recipe activity with the default recipe
        Recipe defaultRecipe = new Recipe();
        toRecipeActivity(defaultRecipe);

    }

    private void toRecipeActivity(Recipe recipe){
        Intent intent = new Intent(this, RecipeActivity.class);
        intent.putExtra("name",recipe.getName());
        intent.putExtra("ingredientNames", recipe.getIngredientNames());
        intent.putExtra("ingredientAmounts", recipe.getIngredientAmounts());
        intent.putExtra("ingredientTypes", recipe.getIngredientTypes());
        startActivity(intent);
    }
}
