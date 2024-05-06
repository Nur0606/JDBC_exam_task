package peaksoft.service.impl;

import peaksoft.dao.CustomerDao;
import peaksoft.dao.impl.CustomerDaoImpl;
import peaksoft.entities.Customer;
import peaksoft.service.CustomerService;

import java.util.List;

public class CustomerSeviceimpl implements CustomerService {
    CustomerDao dao = new CustomerDaoImpl();
    @Override
    public void createCustomerTable() {
    }

    @Override
    public String addCustomer(Customer customer) {
        return dao.addCustomer(customer);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return dao.getCustomerById(id);
    }

    @Override
    public String updateCustomerPhoneNumber(Long id, String phoneNUmber) {
        return dao.updateCustomerPhoneNumber(id, phoneNUmber);
    }

    @Override
    public String deleteCustomerById(Long id) {
        return dao.deleteCustomerById(id);
    }

    @Override
    public List<Customer> sortCustomerByAge(String ascOrDesc) {
        return dao.sortCustomerByAge(ascOrDesc);
    }
}
