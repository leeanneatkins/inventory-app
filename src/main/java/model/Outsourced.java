package model;

/**
 * Represents an outsourced part.
 *
 * @author LeeAnne Atkins
 */
public class Outsourced extends Part{

    /**
     * The company name for the outsourced part.
     */
    private String companyName;

    /**
     * Constructs a new Outsourced.
     *
     * @param id          the unique part id
     * @param name        the part name
     * @param price       the part price
     * @param stock       the quantity of the part in inventory
     * @param min         the minimum quantity of the part that can be in inventory
     * @param max         the maximum quantity of the part that can be in inventory
     * @param companyName the company name
     */
    public Outsourced(int id, String name, double price, int stock, int min, int max, String companyName) {
        super(id, name, price, stock, min, max);
        this.companyName = companyName;
    }

    /**
     * Sets company name.
     *
     * @param companyName the company name to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * Gets company name.
     *
     * @return the companyName
     */
    public String getCompanyName() {
        return companyName;
    }
}
