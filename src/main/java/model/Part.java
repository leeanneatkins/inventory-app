package model;

//import model.controller.ModifyPartController;

/**
 * Represents a part.
 *
 * @author LeeAnne Atkins
 */
public abstract class Part {
    /**
     * The part id is auto generated by the program, unique to each part, and cannot be user modified.
     */
    private int id;
    /**
     * The part name.
     */
    private String name;
    /**
     * The part price.
     */
    private double price;
    /**
     * The quantity of the part in inventory. Must be between <code>min</code> and <code>max</code>.
     */
    private int stock;
    /**
     * The minimum quantity of the part that can be in inventory. Must be less than <code>max</code>.
     */
    private int min;
    /**
     * The maximum quantity of the part that can be in inventory. Must be more than <code>min</code>.
     */
    private int max;

    /**
     * Constructs a new Part.
     *
     * @param id    the unique part id
     * @param name  the part name
     * @param price the part price
     * @param stock the quantity of the part in inventory
     * @param min   the minimum quantity of the part that can be in inventory
     * @param max   the maximum quantity of the part that can be in inventory
     */
    public Part(int id, String name, double price, int stock, int min, int max) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
    }

    /**
     * Sets id.
     *
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets name.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets price.
     *
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Sets stock.
     *
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Sets min.
     *
     * @param min the min to set
     */
    public void setMin(int min) {
        this.min = min;
    }

    /**
     * Sets max.
     *
     * @param max the max to set
     */
    public void setMax(int max) {
        this.max = max;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets stock.
     *
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * Gets min.
     *
     * @return the min
     */
    public int getMin() {
        return min;
    }

    /**
     * Gets max.
     *
     * @return the max
     */
    public int getMax() {
        return max;
    }
}