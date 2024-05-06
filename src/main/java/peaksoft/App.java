package peaksoft;

import peaksoft.config.Jdbs_db;
import peaksoft.entities.Customer;
import peaksoft.service.CustomerService;
import peaksoft.service.impl.CustomerSeviceimpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CustomerService customerService = new CustomerSeviceimpl();
        customerService.createCustomerTable();
//        System.out.println(customerService.addCustomer(new Customer("Nurmuhammed", "Rusbaev", "7774432523")));
//        System.out.println(customerService.getCustomerById(1L));
//        System.out.println(customerService.updateCustomerPhoneNumber(1L, "+996220180752"));
//        customerService.deleteCustomerById()
//        System.out.println(customerService.sortCustomerByAge("asd"));
    }
}
