package peaksoft.service;

import peaksoft.entities.Customer;

import java.util.List;

public interface CustomerService {
    void createCustomerTable();
    String addCustomer(Customer customer);
    Customer getCustomerById(Long id);
    String updateCustomerPhoneNumber(Long id, String phoneNUmber);
    String deleteCustomerById(Long id);
    List<Customer> sortCustomerByAge(String ascOrDesc);
}
