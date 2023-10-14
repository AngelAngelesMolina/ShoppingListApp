package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class ShowItemsListActivity extends AppCompatActivity {

    private int category_id;
    private ItemsListAdapter itemsListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_items_list);

//GETTING DATA FROM THE INTENT
        category_id = getIntent().getIntExtra("category_id", 0);
        String categoryName = getIntent().getStringExtra("category_name");
        getSupportActionBar().setTitle(categoryName);

        EditText addNewITemInput = findViewById(R.id.addNewItemInput);
        ImageView saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName = addNewITemInput.getText().toString();
                if (TextUtils.isEmpty(itemName)) {
                    Toast.makeText(ShowItemsListActivity.this, "Enter item name", Toast.LENGTH_SHORT).show();
                    return;
                }
                saveNewItem(itemName);
            }
        });
    }

    private void initRecyclerView(){
       RecyclerView recyclerView = findViewById(R.id.recyclerView);
       recyclerView.setLayoutManager(new LinearLayoutManager(this));
    itemsListAdapter = new ItemsListAdapter(this, this); 
       recyclerView.setAdapter();


    }
    private void saveNewItem(String itemName) {

    }

}