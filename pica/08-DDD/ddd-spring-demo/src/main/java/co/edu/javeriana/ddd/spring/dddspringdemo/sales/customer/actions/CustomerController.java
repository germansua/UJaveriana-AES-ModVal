package co.edu.javeriana.ddd.spring.dddspringdemo.sales.customer.actions;

import co.edu.javeriana.ddd.spring.dddspringdemo.sales.customer.domain.Customer;
import co.edu.javeriana.ddd.spring.dddspringdemo.sales.customer.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /** Queries **/
    @GetMapping
    public List<Customer> getAllCustomer() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable("id") int customerId) {
        return null;
    }

    /** Commands **/
    @PostMapping
    public ResponseEntity<Void> createCustomer(@Valid @RequestBody Customer customer, UriComponentsBuilder uriComponentsBuilder) {
        int customerId = customerService.createCustomer(customer);
        UriComponents uriComponents = uriComponentsBuilder.path("/api/customers/{id}").buildAndExpand(customerId);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") int customerId) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
