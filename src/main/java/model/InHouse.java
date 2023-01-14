package model;

/**
 * Represents an inhouse part.
 *
 * @author LeeAnne Atkins
 */
public class InHouse extends Part {

    /**
     * The machine id for the inhouse part.
     */
    private int machineId;

    /**
     * Constructs a new InHouse.
     *
     * @param id        the unique part id
     * @param name      the part name
     * @param price     the part price
     * @param stock     the quantity of the part in inventory
     * @param min       the minimum quantity of the part that can be in inventory
     * @param max       the maximum quantity of the part that can be in inventory
     * @param machineId the machine id
     */
    public InHouse(int id, String name, double price, int stock, int min, int max, int machineId) {
        super(id, name, price, stock, min, max);
        this.machineId = machineId;
    }

    /**
     * Sets machine id.
     *
     * @param machineId the machineId to set
     */
    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }

    /**
     * Gets machine id.
     *
     * @return the machineId
     */
    public int getMachineId() {
        return machineId;
    }
}
