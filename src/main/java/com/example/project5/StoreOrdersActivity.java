package com.example.project5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

/**
 * This class is the Activity to be started when the app is on the Store Orders screen.
 * @author Ashley Mathai, Shehneel Ashraf
 */
public class StoreOrdersActivity extends AppCompatActivity {

    private Spinner storeOrdersSpinner;
    private TextView storeOrdersTV;
    private ArrayAdapter<Integer> spinnerAdapter;
    private static int orderNum = 0;
    private static final double STATE_TAX = 0.06625;
    private TextView storeOrdersTotal;

    /**
     * Creates the screen and displays the dropdown and order information.
     * @param savedInstanceState Bundle savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_orders);

        Button backButtonStoreOrder = (Button) findViewById(R.id.backButtonStoreOrders);
        backButtonStoreOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StoreOrdersActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        storeOrdersTotal = findViewById(R.id.storeOrdersTotal);
        storeOrdersSpinner = findViewById(R.id.storeOrdersSpinner);
        storeOrdersTV = findViewById(R.id.storeOrdersTV);
        spinnerAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, MainActivity.s.getStoreOrdersNumbers());

        storeOrdersSpinner.setAdapter(spinnerAdapter); //dynamically set the adapter that associates with the list of String.

        storeOrdersSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String text = adapterView.getSelectedItem().toString();
                orderNum = Integer.parseInt(text);
                storeOrdersTV.setText(MainActivity.s.getOrder(orderNum).print());
                setTotal();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    /**
     * Removes an order from the orders database.
     * @param v View v
     */
    public void removeOrder(View v){

        if (MainActivity.s.getOrdersDatabase().size() == 0){
            AlertDialog.Builder alert = new AlertDialog.Builder(v.getContext());
            alert.setTitle("No orders to remove");
            alert.setNeutralButton("OK",null);
            AlertDialog dialog = alert.create();
            dialog.show();
        }
        else{
            AlertDialog.Builder alert = new AlertDialog.Builder(v.getContext());
            alert.setTitle("Order Removed");
            alert.setNeutralButton("OK",null);

            MainActivity.s.remove(MainActivity.s.getOrder(orderNum));
            storeOrdersTV.setText("");

            AlertDialog dialog = alert.create();
            dialog.show();

            spinnerAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, MainActivity.s.getStoreOrdersNumbers());
            storeOrdersSpinner.setAdapter(spinnerAdapter); //dynamically set the adapter that associates with the list of String.
            if (MainActivity.s.getOrdersDatabase().size() == 0){
                storeOrdersTotal.setText("Total: $0.00");
            }
        }
    }

    /**
     * Calculates and displays total of the order.
     */
    public void setTotal(){
        double subtotal = 0;
        for(MenuItem m: MainActivity.s.getOrder(orderNum).getItems()){
            subtotal += m.itemPrice();
        }
        double salesTax = subtotal * STATE_TAX;

        DecimalFormat df = new DecimalFormat("0.00");
        storeOrdersTotal.setText("Total: $" + df.format(subtotal + salesTax));
    }
}