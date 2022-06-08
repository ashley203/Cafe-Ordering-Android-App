package com.example.project5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * This class is the Activity to be started when the app is on the Your Order screen.
 * @author Ashley Mathai, Shehneel Ashraf
 */
public class YourOrderActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listview;
    private ArrayAdapter<String> adapter;
    private static final double STATE_TAX = 0.06625;
    private TextView subtotalTV, taxTV, totalTV;

    /**
     * Creates the screen and displays the order items.
     * @param savedInstanceState Bundle savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_order);

        Button backButtonYourOrder = (Button) findViewById(R.id.backButtonYourOrder);
        backButtonYourOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(YourOrderActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, MainActivity.o.returnMenuItems());
        listview = findViewById(R.id.yourOrderListView);
        listview.setOnItemClickListener(this); //register the listener for an OnItemClick event.
        listview.setAdapter(adapter);
        setSubtotal();
    }

    /**
     * Removes item from order.
     * @param adapterView AdapterView<?> adapterView
     * @param view View view
     * @param i int i
     * @param l long l
     */
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Remove?");
        alert.setMessage(adapterView.getAdapter().getItem(i).toString());
        final int positionToRemove = i;
        //anonymous inner class to handle the onClick event of YES or NO.
        alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "YES", Toast.LENGTH_LONG).show();
                adapter.remove(adapter.getItem(positionToRemove));
                MainActivity.o.getItems().remove(positionToRemove);
                adapter.notifyDataSetChanged();
                setSubtotal();
            }
        }).setNegativeButton("no", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "NO", Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }

    /**
     * Calculates and displays subtotal, tax, and total.
     */
    public void setSubtotal(){
        subtotalTV = findViewById(R.id.yourOrderSubtotalTV);
        taxTV = findViewById(R.id.yourOrderSalesTV);
        totalTV = findViewById(R.id.yourOrderTotalTV);

        double subtotal = 0;
        for(MenuItem m: MainActivity.o.getItems()){
            subtotal += m.itemPrice();
        }
        double salesTax = subtotal * STATE_TAX;

        DecimalFormat df = new DecimalFormat("0.00");
        subtotalTV.setText("Subtotal: $" + df.format(subtotal));
        taxTV.setText("Sales Tax: $" + df.format(salesTax));
        totalTV.setText("Total: $" + df.format(subtotal + salesTax));
    }

    /**
     * Places the order to the database if an order exists.
     * @param v View v
     */
    public void placeYourOrder(View v){

        if (MainActivity.o.getItems().size() == 0){
            AlertDialog.Builder alert = new AlertDialog.Builder(v.getContext());
            alert.setTitle("No items to order");
            alert.setNeutralButton("OK",null);
            AlertDialog dialog = alert.create();
            dialog.show();
        }
        else{
            AlertDialog.Builder alert = new AlertDialog.Builder(v.getContext());
            alert.setTitle("Order Placed");
            alert.setNeutralButton("OK",null);

            MainActivity.s.add(MainActivity.o);
            System.out.println(MainActivity.s.print());
            MainActivity.o = new Order();

            AlertDialog dialog = alert.create();
            dialog.show();

            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, MainActivity.o.returnMenuItems());
            listview = findViewById(R.id.yourOrderListView);
            listview.setOnItemClickListener(this); //register the listener for an OnItemClick event.
            listview.setAdapter(adapter);

            setSubtotal();
        }
    }

}