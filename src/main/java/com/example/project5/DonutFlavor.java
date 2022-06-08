package com.example.project5;

/**
 This is the DonutFlavor Enum class that contains information about the donut flavors and types.
 @author Ashley Mathai, Shehneel Ashraf
 */
public enum DonutFlavor {
    JELLY("Jelly", 1.00),
    OLDFASHIONED("Old Fashioned", 2.00),
    POWDERED("Powdered", 2.20),
    SUGAR("Sugar", 3.01),
    GLAZED("Glazed", 2.05),
    STRAWBERRY("Strawberry", 1.50),
    CRULLER("Cruller", 1.00),
    BOSTONKREME("Boston Kreme", 1.00),
    CHOCOLATE("Chocolate", 3.50),
    BLUEBERRY("Blueberry", 1.00),
    MAPLE("Maple", 1.50),
    REDVELVET("Red Velvet", 1.00);

    private final String name;
    private final double price;

    /**
     * Creates the Donut object.
     * @param name String name of donut
     */
    DonutFlavor(String name, double price){
        this.name = name;
        this.price = price;
    }

    /**
     * Returns the flavor of the donut
     * @return String donut flavor
     */
    @Override
    public String toString(){
        return this.name;
    }

    /**
     * Returns the price of the donut
     * @return double price
     */
    public double getPrice(){
        return this.price;
    }

}