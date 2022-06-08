package com.example.project5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

/**
 * This class is the Activity to be started when the app is on the Order Donuts screen.
 * @author Ashley Mathai, Shehneel Ashraf
 */
public class OrderDonutsActivity extends AppCompatActivity{

    //Declare an instance of ArrayList to hold the items to be display with the RecyclerView
    private ArrayList<Item> items = new ArrayList<>();

    private int [] itemImages = {R.drawable.jelly, R.drawable.old_fashioned, R.drawable.powdered,
            R.drawable.sugar, R.drawable.glazed, R.drawable.strawberry_frosted, R.drawable.cruller,
            R.drawable.boston_kreme, R.drawable.chocolate_glazed, R.drawable.blueberry,
            R.drawable.maple, R.drawable.red_velvet};

    /**
     * Creates the screen and sets adapters and displays items.
     * @param savedInstanceState Bundle savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_donuts_view);

        Button backButtonDonut = (Button) findViewById(R.id.backButtonDonut);
        backButtonDonut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderDonutsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        
        RecyclerView rcview = findViewById(R.id.donutFlavorsRV);
        setupMenuItems(); //add the list of items to the ArrayList
        ItemsAdapter adapter = new ItemsAdapter(this, items); //create the adapter
        // ItemsAdapter adapter = new ItemsAdapter(this, items, this);
        rcview.setAdapter(adapter); //bind the list of items to the RecyclerView
        //use the LinearLayout for the RecyclerView
        rcview.setLayoutManager(new LinearLayoutManager(this));
    }


    /**
     * Helper method to set up the data (the Model of the MVC).
     */
    private void setupMenuItems() {

        String [] itemNames = getResources().getStringArray(R.array.itemNames);
        String[] unitPrices = getResources().getStringArray(R.array.unitPrices);

        for (int i = 0; i < itemNames.length; i++) {
            items.add(new Item(itemNames[i], itemImages[i], Double.parseDouble(unitPrices[i])));
        }
    }
}