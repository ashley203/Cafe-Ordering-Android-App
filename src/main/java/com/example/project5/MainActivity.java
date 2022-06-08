package com.example.project5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

/**
 * This class is the Activity to be started when the app is on the home screen.
 * @author Ashley Mathai, Shehneel Ashraf
 */
public class MainActivity extends AppCompatActivity {

    private ArrayList<Donut> items = new ArrayList<>();

    public static Order o = new Order();
    public static StoreOrders s = new StoreOrders();

    /**
     * This method creates the buttons for each screen, and changes the screens appropriately.
     * @param savedInstanceState Bundle savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button orderDonutButton = (Button) findViewById(R.id.orderDonutButton);
        orderDonutButton.setText("Order Donuts");

        orderDonutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OrderDonutsActivity.class);
                startActivity(intent);
            }
        });

        Button orderCoffeeButton = (Button) findViewById(R.id.orderCoffeeButton);
        orderCoffeeButton.setText("Order Coffee");

        orderCoffeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OrderCoffeeActivity.class);
                startActivity(intent);
            }
        });

        Button yourOrderButton = (Button) findViewById(R.id.yourOrderButton);
        yourOrderButton.setText("Your Order");

        yourOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, YourOrderActivity.class);
                startActivity(intent);
            }
        });

        Button storeOrdersButton = (Button) findViewById(R.id.storeOrdersButton);
        storeOrdersButton.setText("Store Orders");
        storeOrdersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StoreOrdersActivity.class);
                startActivity(intent);
            }
        });
    }

}