package com.lexmat.kitchenhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class RecipeActivity extends AppCompatActivity {

    Recipe recipe;
    ListView ingredientList;
    EditText recipeName;

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

        recipeName = (EditText) findViewById(R.id.recipeNameView);
        recipeName.setText(name);

        ingredientList = (ListView) findViewById(R.id.ingredientList);
        ArrayList<String> ingredients = recipe.getIngredients();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.item_ingredient, R.id.ingredientView, ingredients);


        ingredientList.setAdapter(arrayAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_task:
                //this is when the + is hit
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onSave(View view) {

        Toast.makeText(getApplicationContext(), R.string.Recipe_Saved, Toast.LENGTH_SHORT).show();
    }

    public void onView(View view) {
        Intent intent = new Intent(this, SaveActivity.class);
        startActivity(intent);
    }
}
