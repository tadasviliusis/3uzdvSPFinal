package lt.eif.viko.tadasviliusis._3uzdv_JAXRS_WebService.model;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * The Components class represents a computer component in the system.
 * It contains information about the component's ID, name, and price.
 */

@Entity

public class Components {


    @Id
    @GeneratedValue

    private int id;


    private String componentName;


    private double price;

    /**
     * Creates a new Components object with default values.
     */
    public Components() {

    }

    /**
     * Gets the ID of the component.
     *
     * @return The ID of the component.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the component.
     *
     * @param id The ID of the component.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name of the component.
     *
     * @return The name of the component.
     */
    public String getComponentName() {
        return componentName;
    }

    /**
     * Sets the name of the component.
     *
     * @param componentName The name of the component.
     */
    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    /**
     * Gets the price of the component.
     *
     * @return The price of the component.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the component.
     *
     * @param price The price of the component.
     */
    public void setPrice(double price) {
        this.price = price;
    }



    /**
     * Creates a new Components object with the given ID, name, and price.
     *
     * @param id            The ID of the component.
     * @param componentName The name of the component.
     * @param price         The price of the component.
     */
    public Components(int id, String componentName, double price) {
        this.id = id;
        this.componentName = componentName;
        this.price = price;
    }

    /**
     * Creates a new Components object with the given name and price.
     *
     * @param componentName The name of the component.
     * @param price         The price of the component.
     */
    public Components(String componentName, double price) {
        this.componentName = componentName;
        this.price = price;
    }


    @Override
    public String toString() {
        return String.format("Component: \n" +
                        "\tComponentName = %s\n\t\t" +
                        "Price = %f\n\t",
                this.componentName,
                this.price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Components that = (Components) o;
        return id == that.id && Double.compare(that.price, price) == 0 && Objects.equals(componentName, that.componentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, componentName, price);
    }
}


