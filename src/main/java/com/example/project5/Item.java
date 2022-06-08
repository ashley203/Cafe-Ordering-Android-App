package com.example.project5;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 * This class defines the data structure of an item to be displayed in the RecyclerView
 * @author Ashley Mathai, Shehneel Ashraf
 */
public class Item implements Serializable {
    private String itemName;
    private int image;
    private double unitPrice; //for demo purpose, the unitPrice is of String type

    /**
     * Parameterized constructor.
     * @param itemName
     * @param image
     * @param unitPrice
     */
    public Item(String itemName, int image, double unitPrice) {
        this.itemName = itemName;
        this.image = image;
        this.unitPrice = unitPrice;
    }

    /**
     * Getter method that returns the item name of an item.
     * @return the item name of an item.
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Getter method that returns the image of an item.
     * @return the image of an item.
     */
    public int getImage() {
        return image;
    }

    /**
     * Getter method that returns the unit price.
     * @return the unit price of the item.
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * Returns string formatted version of price
     * @return String price
     */
    public String convertUnitPriceString(){
        DecimalFormat df = new DecimalFormat("0.00");
        String price = df.format(unitPrice);
        return price;
    }
}
