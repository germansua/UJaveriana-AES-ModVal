package co.edu.javeriana.ddd.spring.dddspringdemo.sales.customer.services;

import co.edu.javeriana.ddd.spring.dddspringdemo.sales.customer.domain.*;
import co.edu.javeriana.ddd.spring.dddspringdemo.sales.customer.repository.CustomerEntity;
import co.edu.javeriana.ddd.spring.dddspringdemo.sales.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public int createCustomer(Customer customer) throws CustomerException {
        var customerEntity = new CustomerEntity(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getContactInfo().getEmail(),
                customer.getContactInfo().getPhoneNumber().toString(),
                customer.getContactInfo().getAddress().toString()
        );
        customerRepository.save(customerEntity);
        return customerEntity.getCustomerId();
    }

    public List<Customer> getAllCustomers() {
        List<CustomerEntity> customers = customerRepository.findAll();

        return customers.stream().map(customerEntity -> new Customer(
                customerEntity.getId(),
                customerEntity.getFirstName(),
                customerEntity.getLastName(),
                new CustomerContactInfo(
                        customerEntity.getEmail(),
                        new PhoneNumber(PhoneNumber.PhoneNumberType.HOME, "", (short) 0, 0),
                        new Address("", "", ""))))
                .collect(Collectors.toList());
    }
}
