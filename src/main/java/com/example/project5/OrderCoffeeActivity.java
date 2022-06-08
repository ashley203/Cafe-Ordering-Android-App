package com.example.project5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
/**
 * This class is the Activity to be started when the app is on the Order Coffee screen.
 * @author Ashley Mathai, Shehneel Ashraf
 */
public class OrderCoffeeActivity extends AppCompatActivity {

    private Spinner coffeeSizeSpinner;
    private Spinner coffeeQuantitySpinner;
    private TextView coffeeSizeTV, coffeeQuantityTV;
    private ArrayAdapter<CharSequence> adapter_coffeeSizes, adapter_coffeeQuantity;
    private Coffee c = new Coffee();

    /**
     * Creates the screen and changes the Coffee attributes when attributes are clicked.
     * @param savedInstanceState Bundle savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_coffee);

        Button backButtonCoffee = (Button) findViewById(R.id.backButtonCoffee);
        backButtonCoffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderCoffeeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        coffeeSizeSpinner = findViewById(R.id.coffeeSizeSpinner);
        coffeeQuantitySpinner = findViewById(R.id.coffeeQuantitySpinner);
        adapter_coffeeSizes = ArrayAdapter.createFromResource(this, R.array.coffeeSizes, android.R.layout.simple_spinner_dropdown_item);
        coffeeSizeSpinner.setAdapter(adapter_coffeeSizes); //dynamically set the adapter that associates with the list of String.
        adapter_coffeeQuantity = ArrayAdapter.createFromResource(this, R.array.coffeeQuantity, android.R.layout.simple_spinner_dropdown_item);
        coffeeQuantitySpinner.setAdapter(adapter_coffeeQuantity);
        coffeeSizeTV = findViewById(R.id.coffeeSizeTV);
        coffeeQuantityTV = findViewById(R.id.coffeeQuantityTV);

        coffeeSizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                c.setCoffeeSize(adapterView.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        coffeeQuantitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                c.setCoffeeQuantity(Integer.parseInt(adapterView.getSelectedItem().toString()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    /**
     * dummy onStart method
     */
    protected void onStart() {
        super.onStart();
    }

    /**
     * dummy onPause method
     */
    public void onPause() {
        super.onPause();
    }

    /**
     * dummy onResume method
     */
    public void onResume() {
        super.onResume();
    }

    /**
     * Checks if cream checkbox was selected. Adds to add-ons list if yes.
     * @param v View v
     */
    public void creamCBClicked(View v){
        boolean checked = (((CheckBox)v).isChecked());
        if (checked){
            c.add(AddOn.CREAM);
        }
        else{
            c.remove(AddOn.CREAM);
        }
    }

    /**
     * Checks if whipped cream checkbox was selected. Adds to add-ons list if yes.
     * @param v View v
     */
    public void whippedCreamCBClicked(View v){
        boolean checked = (((CheckBox)v).isChecked());
        if (checked){
            c.add(AddOn.WHIPPEDCREAM);
        }
        else{
            c.remove(AddOn.WHIPPEDCREAM);
        }
    }

    /**
     * Checks if caramel checkbox was selected. Adds to add-ons list if yes.
     * @param v View v
     */
    public void caramelCBClicked(View v){
        boolean checked = (((CheckBox)v).isChecked());
        if (checked){
            c.add(AddOn.CARAMEL);
        }
        else{
            c.remove(AddOn.CARAMEL);
        }
    }

    /**
     * Checks if syrup checkbox was selected. Adds to add-ons list if yes.
     * @param v View v
     */
    public void syrupCBClicked(View v){
        boolean checked = (((CheckBox)v).isChecked());
        if (checked){
            c.add(AddOn.SYRUP);
        }
        else{
            c.remove(AddOn.SYRUP);
        }
    }

    /**
     * Checks if milk checkbox was selected. Adds to add-ons list if yes.
     * @param v View v
     */
    public void milkCBClicked(View v){
        boolean checked = (((CheckBox)v).isChecked());
        if (checked){
            c.add(AddOn.MILK);
        }
        else{
            c.remove(AddOn.MILK);
        }
    }

    /**
     * Adds coffee object to order.
     * @param v View v
     */
    public void addToOrderCoffee(View v){
        MainActivity.o.add(c.copyCoffee());
        System.out.println(MainActivity.o.print());

        AlertDialog.Builder alert = new AlertDialog.Builder(v.getContext());
        alert.setTitle("Coffee added to order");
        alert.setNeutralButton("OK",null);
        AlertDialog dialog = alert.create();
        dialog.show();
    }
}