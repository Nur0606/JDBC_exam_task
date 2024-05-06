package peaksoft.dao.impl;

import org.postgresql.jdbc.PgConnection;
import peaksoft.config.Jdbs_db;
import peaksoft.dao.CustomerDao;
import peaksoft.entities.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    Connection connection = Jdbs_db.getConnection();

    @Override
    public void createCustomerTable() {
        String sql = """
                 create table if not exists customers (
                 id serial primary key ,
                 first_name varchar ,
                 last_name varchar ,
                 phone_number varchar);
                """;
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("Success created!");
        } catch (SQLException e) {
            System.out.println("Error: "+e.getMessage());
        }
    }

    @Override
    public String addCustomer(Customer customer) {
        String sql = """
                insert into customers(first_name,last_name,phone_number)
                values(?,?,?)
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setString(3, customer.getPhoneNumber());
            preparedStatement.executeUpdate();
            System.out.println("Successfully saved!");
        } catch (SQLException e) {
            System.out.println("Error: "+e.getMessage());
        }
        return null;
    }

    @Override
    public Customer getCustomerById(Long id) {
        Customer customer = new Customer();
        String sql = "select * from customers where id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.next()) {
                return null;
            }


            customer.setId(resultSet.getLong("id"));
            customer.setFirstName(resultSet.getString("first_name"));
            customer.setLastName(resultSet.getString("last_name"));
            customer.setPhoneNumber(resultSet.getString("phone_number"));

            return customer;
        } catch (SQLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public String updateCustomerPhoneNumber(Long id, String phoneNUmber) {
        String sql = """
            update customers set phone_number = ? where id = ?
            """;
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,phoneNUmber);
            preparedStatement.setLong(2,id);
            preparedStatement.executeUpdate();
            System.out.println("Success updates");
        }catch (SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
        return null;
    }

    @Override
    public String deleteCustomerById(Long id) {

        return null;
    }

    @Override
    public List<Customer> sortCustomerByAge(String ascOrDesc) {
        List<Customer> customers = new ArrayList<>();

        String sql = null;
        if (ascOrDesc.equalsIgnoreCase("asc")) {
            sql = """ 
                       select * from customers c order by c.age;
                    """;

        } else if (ascOrDesc.equalsIgnoreCase("desc")) {
            sql = """
                    select * from customers c2 order by c2.age desc;
                    """;
        }
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            Customer customer = new Customer();
            customer.setId(resultSet.getLong("id"));
            customer.setFirstName(resultSet.getNString("first_name"));
            customer.setLastName(resultSet.getString("last_name"));
            customer.setPhoneNumber(resultSet.getString("phone_number"));
            customers.add(customer);
            return customers;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
