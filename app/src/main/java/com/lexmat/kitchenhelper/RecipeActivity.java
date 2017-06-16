package com.lexmat.kitchenhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class RecipeActivity extends AppCompatActivity {

    Recipe recipe;
    ListView ingredientList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        String ingredientNames = intent.getStringExtra("ingredientNames");
        String ingredientAmounts = intent.getStringExtra("ingredientAmounts");
        String ingredientTypes = intent.getStringExtra("ingredientTypes");

        recipe = new Recipe(name, ingredientNames, ingredientAmounts, ingredientTypes);

        ingredientList = (ListView) findViewById(R.id.ingredientList);
        ArrayList<String> ingredients = recipe.getIngredients();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ingredients);

        ingredientList.setAdapter(arrayAdapter);


    }

    public void onSave(View view) {

        Toast.makeText(getApplicationContext(), R.string.Recipe_Saved, Toast.LENGTH_SHORT).show();
    }

    public void onView(View view) {
        Intent intent = new Intent(this, SaveActivity.class);
        startActivity(intent);
    }
}
