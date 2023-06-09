package lt.eif.viko.tadasviliusis._3uzdv_JAXRS_WebService.model;

import jakarta.persistence.*;


import java.util.List;
import java.util.Objects;

/**
 * The Account class represents a user account in the computer shop system.
 * An account contains a username, password, and shipping information for the client, as well as a list of categories
 * associated with the account.
 *
 * @XmlRootElement and @XmlAccessorType annotations are used for XML binding.
 * @Entity and @Table annotations are used for database mapping.
 */

@Entity
public class Account {
    @Id
    @GeneratedValue
    private int id;
    private String userName;
    private String password;
    @ManyToOne(targetEntity = ClientShipping.class, cascade = CascadeType.ALL)

    @JoinTable(name = "account_clientshipping",
            joinColumns = @JoinColumn(name = "account_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "clientshipping_id", referencedColumnName = "id"))

    private ClientShipping clientShipping;


    @ManyToMany(targetEntity = Categories.class, cascade = CascadeType.ALL)

    @JoinTable(name = "account_categories",
            joinColumns = @JoinColumn(name = "account_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "categories_id", referencedColumnName = "id"))

    private List<Categories> categories;

    /**
     * Get the unique identifier of the Account.
     *
     * @return The unique identifier of the Account.
     */
    public int getId() {
        return id;
    }

    /**
     * Set the unique identifier of the Account.
     *
     * @param id The unique identifier of the Account.
     */

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the username of the Account.
     *
     * @return The username of the Account.
     */

    public String getUserName() {
        return userName;
    }

    /**
     * Set the username of the Account.
     *
     * @param userName The username of the Account.
     */

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Get the password of the Account.
     *
     * @return The password of the Account.
     */

    public String getPassword() {
        return password;
    }

    /**
     * Set the password of the Account.
     *
     * @param password The password of the Account.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public Account() {

    }

    /**
     * Constructor for the Account class with parameters for all fields.
     *
     * @param id             The ID of the account in the database.
     * @param userName       The username associated with the account.
     * @param password       The password associated with the account.
     * @param clientShipping The shipping information associated with the client for the account.
     * @param categories     The list of categories associated with the account.
     */
    public Account(int id, String userName, String password, ClientShipping clientShipping, List<Categories> categories) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.clientShipping = clientShipping;
        this.categories = categories;


    }

    public ClientShipping getClientShipping() {
        return clientShipping;
    }

    public void setClientShipping(ClientShipping clientShipping) {
        this.clientShipping = clientShipping;
    }

    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }

    /**
     * Constructor for the Account class with parameters for user name and password only.
     *
     * @param userName The username associated with the account.
     * @param password The password associated with the account.
     */
    public Account(String userName, String password) {

        this.userName = userName;
        this.password = password;

    }

    /**
     * Constructor for the Account class with parameters for all fields except ID.
     *
     * @param userName       The username associated with the account.
     * @param password       The password associated with the account.
     * @param clientShipping The shipping information associated with the client for the account.
     * @param categories     The list of categories associated with the account.
     */

    public Account(String userName, String password, ClientShipping clientShipping, List<Categories> categories) {
        this.userName = userName;
        this.password = password;
        this.clientShipping = clientShipping;
        this.categories = categories;

    }

    @Override
    public String toString() {
        return
                String.format("Account:\n\t" +
                                "Username = %s\n\t" +
                                "Password = %s\n" +
                                "\tClientShipping: \n\t%s\n" +
                                "\tCategories: \n%s"
                        ,
                        this.userName,
                        this.password,
                        this.clientShipping,
                        this.categories);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id && Objects.equals(userName, account.userName) && Objects.equals(password, account.password) && Objects.equals(clientShipping, account.clientShipping) && Objects.equals(categories, account.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, password, clientShipping, categories);
    }
}
