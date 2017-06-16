package com.lexmat.kitchenhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
    }

    public void onNew(View view) {
        //start the recipe activity with the default recipe
        Intent intent = new Intent(this, RecipeActivity.class);
        intent.putExtra("name",getString(R.string.Recipe));
        intent.putExtra("ingredientNames", " ");
        intent.putExtra("ingredientAmounts", " ");
        intent.putExtra("ingredientTypes", " ");
        startActivity(intent);
    }
}
