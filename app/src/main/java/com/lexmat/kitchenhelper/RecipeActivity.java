package com.lexmat.kitchenhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class RecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
    }

    public void onSave(View view) {
        Toast.makeText(getApplicationContext(), "Recipe Saved!", Toast.LENGTH_SHORT).show();
    }

    public void onView(View view) {
        Intent intent = new Intent(this, SaveActivity.class);
        startActivity(intent);
    }
}
