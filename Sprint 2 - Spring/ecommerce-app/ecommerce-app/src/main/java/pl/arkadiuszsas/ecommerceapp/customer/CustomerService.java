package pl.arkadiuszsas.ecommerceapp.customer;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    // Dependency Injection
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }
}
