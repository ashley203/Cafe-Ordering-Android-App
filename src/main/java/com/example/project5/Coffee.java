package com.example.project5;
import java.util.ArrayList;

/**
 This is the Coffee class that create the Coffee object with a quantity, size, and AddOn.
 @author Ashley Mathai, Shehneel Ashraf
 */
public class Coffee extends MenuItem implements Customizable{
    private int quantity;
    private CoffeeSize size;
    private ArrayList<AddOn> addOns = new ArrayList<AddOn>();

    /**
     * Creates the Coffee object.
     * @param quantity how many cups
     * @param size size of coffee
     * @param addOns any add-ons
     */
    public Coffee(int quantity, CoffeeSize size, ArrayList<AddOn> addOns){
        this.size = size;
        this.quantity = quantity;
        // this.addOns = addOns;
        this.addOns.addAll(addOns);
    }

    /**
     * Creates the Coffee object.
     */
    public Coffee(){
        this.size = CoffeeSize.SHORT;
        this.quantity = 1;
    }

    /**
     * Sets the coffee size.
     * @param size String size
     */
    public void setCoffeeSize(String size){
        for (CoffeeSize s : CoffeeSize.values()){
            if (s.toString().equals(size)){
                this.size = s;
            }
        }
    }

    /**
     * Sets the coffee quantity.
     * @param quantity int quantity
     */
    public void setCoffeeQuantity(int quantity){
        this.quantity = quantity;
    }

    /**
     * Copies the Coffee object into a new object.
     * @return Coffee
     */
    public Coffee copyCoffee(){
        ArrayList<AddOn> aCopy = new ArrayList<AddOn>();
        aCopy.addAll(addOns);

        Coffee cCopy = new Coffee(this.quantity, this.size, aCopy);
        return cCopy;
    }

    /**
     * Returns the String formatted version of the Coffee object.
     * @return String "Coffee(quantity)[add-ons]"
     */
    @Override
    public String toString(){
        String output = "Coffee(" + quantity + ") " + size.toString() + " [";
        for(int i = 0; i < addOns.size() - 1; i++){
            output += addOns.get(i).toString() + ", ";
        }
        if(addOns.size() != 0){
            output += addOns.get(addOns.size() - 1);
        }
        return output + "]";
    }

    /**
     * Adds Coffee Add-On object.
     * @param obj Coffee object
     * @return boolean
     */
    @Override
    public boolean add(Object obj) {
        if (!(obj instanceof AddOn)){
            return false;
        }
        addOns.add((AddOn) obj);
        return true;
    }

    /**
     * Increases coffee quantity
     * @param quantity int quantity
     */
    @Override
    public void addToQuantity(int quantity){
        this.quantity += quantity;
    }

    /**
     * Returns the quantity of coffee
     * @return quantity int quantity
     */
    @Override
    public int getQuantity(){
        return this.quantity;
    }

    /**
     * Removes Coffee Add-On object.
     * @param obj Coffee object
     * @return boolean
     */
    @Override
    public boolean remove(Object obj) {
        if (!(obj instanceof AddOn)){
            return false;
        }
        addOns.remove((AddOn) obj);
        return true;
    }

    /**
     * Checks if two Coffee objects are the same
     * @param o Object
     * @return boolean
     */
    @Override
    public boolean equals(Object o){
        if (!(o instanceof Coffee)){
            return false;
        }
        Coffee c = (Coffee) o;
        if (!c.size.equals(this.size)){
            return false;
        }
        if (!c.addOns.equals(this.addOns)){
            return false;
        }
        return true;
    }

    /**
     * Returns the price of the Coffee object.
     * @return int price
     */
    public double itemPrice(){
        double price = size.getPrice() * quantity;
        for(AddOn a: addOns){
            price += a.getPrice();
        }
        return price;
    }
}