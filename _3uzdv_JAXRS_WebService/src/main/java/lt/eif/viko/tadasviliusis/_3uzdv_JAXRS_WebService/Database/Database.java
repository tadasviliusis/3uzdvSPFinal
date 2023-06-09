package lt.eif.viko.tadasviliusis._3uzdv_JAXRS_WebService.Database;

import lt.eif.viko.tadasviliusis._3uzdv_JAXRS_WebService.ComputerShopRepo;
import lt.eif.viko.tadasviliusis._3uzdv_JAXRS_WebService.model.Account;
import lt.eif.viko.tadasviliusis._3uzdv_JAXRS_WebService.model.Categories;
import lt.eif.viko.tadasviliusis._3uzdv_JAXRS_WebService.model.ClientShipping;
import lt.eif.viko.tadasviliusis._3uzdv_JAXRS_WebService.model.Components;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Configuration class for initializing the database with sample data.
 */
@Configuration
public class Database {

    private static final Logger log = LoggerFactory.getLogger(Database.class);

    /**
     * Initializes the database with sample data.
     *
     * @param repository the repository for managing computer shop accounts
     * @return a CommandLineRunner instance
     */

    @Bean
    CommandLineRunner initDatabase(ComputerShopRepo repository) {

        return args -> {
            // log.info("Preloading " + repository.save(initData()));
        };

    }

    /**
     * Initializes sample account data.
     *
     * @return an instance of Account with sample data
     */
    public Account initData() {
        Components mb1;
        mb1 = new Components("Asus ROG STRIX B550", 120.99);
        Components mb2 = new Components("Gigabyte Elite AX V2", 169.99);
        Categories category = new Categories("Motherboard", List.of(mb1, mb2));
        ClientShipping clientShipping = new ClientShipping(869784526, "Verkiu g.45", "LT00762");
        Account account1 = new Account("Tadas", "1515", clientShipping, List.of(category));

        return account1;
    }

}
