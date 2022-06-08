package com.example.project5;

/**
 This is the Donut class that create the Donut object with a quantity and donutFlavor.
 @author Ashley Mathai, Shehneel Ashraf
 */
public class Donut extends MenuItem{
    private int quantity;
    private DonutFlavor donutFlavor;

    /**
     * Creates a Donut object with String donutFlavor
     * @param quantity int quantity
     * @param donutFlavor String donutFlavor
     */
    public Donut(int quantity, String donutFlavor){
        this.quantity = quantity;
        for (DonutFlavor d : DonutFlavor.values()){
            if (donutFlavor.equals(d.toString())){
                this.donutFlavor = d;
            }
        }
    }

    /**
     * Creates a Donut object with DonutFlavor donutFlavor
     * @param quantity number of donuts
     * @param donutFlavor flavor of donut
     */
    public Donut(int quantity, DonutFlavor donutFlavor){
        this.quantity = quantity;
        this.donutFlavor = donutFlavor;
    }

    /**
     * Returns the String formatted version of the donut flavor and quantity.
     * @return String flavor and quantity
     */
    @Override
    public String toString(){
        return donutFlavor.toString() + "(" + quantity + ")";
    }

    /**
     * Returns the String formatted version of the donut flavor and quantity.
     * @return String flavor
     */
    public String getDonutFlavor(){
        return donutFlavor.toString();
    }

    /**
     * Checks if two Donut objects are the same
     * @param o Object o
     * @return boolean
     */
    @Override
    public boolean equals(Object o){
        if (!(o instanceof Donut)){
            return false;
        }
        Donut d = (Donut) o;
        if (!d.donutFlavor.equals(this.donutFlavor)){
            return false;
        }
        return true;
    }

    /**
     * Adds to the donut quantity
     * @param quantity int quantity
     */
    @Override
    public void addToQuantity(int quantity){
        this.quantity += quantity;
    }

    /**
     * Returns the donut quantity
     * @return quantity int quantity
     */
    @Override
    public int getQuantity(){
        return this.quantity;
    }

    /**
     * Returns the price of the donut based on the quantity.
     * @return double price
     */
    @Override
    public double itemPrice() {
        return donutFlavor.getPrice() * quantity;
    }
}
