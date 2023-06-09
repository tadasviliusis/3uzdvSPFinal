package lt.eif.viko.tadasviliusis._3uzdv_JAXRS_WebService.Database;


import lt.eif.viko.tadasviliusis._3uzdv_JAXRS_WebService.ComputerShopNotFoundException;
import lt.eif.viko.tadasviliusis._3uzdv_JAXRS_WebService.ComputerShopRepo;
import lt.eif.viko.tadasviliusis._3uzdv_JAXRS_WebService.model.Account;
import lt.eif.viko.tadasviliusis._3uzdv_JAXRS_WebService.model.Categories;
import lt.eif.viko.tadasviliusis._3uzdv_JAXRS_WebService.model.ClientShipping;
import lt.eif.viko.tadasviliusis._3uzdv_JAXRS_WebService.model.Components;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;


/**
 * Controller class for managing computer shop accounts.
 */

@RestController
public class ComputerShopController {

    private final ComputerShopRepo repository;

    public ComputerShopController(ComputerShopRepo repository) {
        this.repository = repository;
    }

    @GetMapping("/computershop")
    List<Account> all() {
        return repository.findAll();
    }

    @PostMapping("/computershop")
    Account newAccount(@RequestBody Account newAccount) {
        return repository.save(newAccount);
    }

    @GetMapping("/computershop/{id}")
    Account one(@PathVariable int id) {

        return repository.findById((long) id)
                .orElseThrow(() -> new ComputerShopNotFoundException(id));
    }
    @DeleteMapping("/computershop/{id}")
    void deleteAccount(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PostMapping("/computershop/{accountID}/categorie/{categoriesID}")
    Account newComponentForCategory(@RequestBody Components newComponent, @PathVariable Long accountID, @PathVariable Long categoriesID) {

        return repository.findById(accountID)
                .map(account -> {
                    for (Categories categories:account.getCategories()
                         ) {
                        if (categories.getId() == categoriesID)
                            categories.getComponents().add(newComponent);
                    }
                    return repository.save(account);
                }).orElseThrow(() -> new ComputerShopNotFoundException(accountID));


    }

    @GetMapping("/computershop/{accountID}/categorie/getfullcost")
    double getfullcost(@PathVariable long accountID ) {

        return repository.findById(accountID)
                .map(account -> {
                    double tmp = 0;
                    for (Categories categories:account.getCategories()

                    ) {
                            for (Components components:categories.getComponents()
                                 ) {
                                tmp += components.getPrice();
                            }
                    }
                    return tmp;
                })
                .orElseThrow(() -> new ComputerShopNotFoundException(accountID));


    }

    @PutMapping("/computershop/{id}/clientshipping")
    void changeSipping(@RequestBody ClientShipping newShipping, @PathVariable Long id) {
        repository.findById(id)
                .map(account -> {
                    account.getClientShipping().setAddress(newShipping.getAddress());
                    account.getClientShipping().setPhoneNumber(newShipping.getPhoneNumber());
                    account.getClientShipping().setPostCode(newShipping.getPostCode());
                    repository.save(account);
                    return account.getClientShipping();
                }).orElseThrow(() -> new ComputerShopNotFoundException(id));
    }

    @DeleteMapping("/computershop/{accountID}/categorie/{categoriesID}/component/{componentID}")
    void deleteComponent(@PathVariable Long accountID, @PathVariable Long categoriesID, @PathVariable Long componentID) {
        repository.findById(accountID)
                .map(account -> {
                    for(Categories categorie: account.getCategories())
                    {
                        if(categorie.getId() == categoriesID)
                        {
                            Iterator<Components> iterator = categorie.getComponents().iterator();
                            while(iterator.hasNext()) {
                                Components component = iterator.next();
                                if(component.getId() == componentID) {
                                    iterator.remove();
                                }
                            }
                        }
                    }
                    repository.save(account);
                    return account;
                }).orElseThrow(() -> new ComputerShopNotFoundException(accountID));
    }



}
