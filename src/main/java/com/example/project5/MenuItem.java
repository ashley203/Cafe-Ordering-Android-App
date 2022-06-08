package com.example.project5;

/**
 This is the MenuItem class that has the itemPrice and toString methods.
 @author Ashley Mathai, Shehneel Ashraf
 */
public class MenuItem{
    /**
     * Returns the item price.
     * @return double 0 --> method is overridden
     */
    public double itemPrice(){
        return 0;
    }

    /**
     * Returns the String version of the MenuItem.
     * @return String "" --> method is overridden
     */
    @Override
    public String toString() {
        return "";
    }

    /**
     * Increases quantity of MenuItem.
     * @param quantity int quantity --> method is overridden
     */
    public void addToQuantity(int quantity){

    }

    /**
     * Returns quantity of MenuItem.
     * @return double 0 --> method is overridden
     */
    public int getQuantity(){
        return 0;
    }
}
