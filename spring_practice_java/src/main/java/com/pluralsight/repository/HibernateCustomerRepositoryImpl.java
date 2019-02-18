package com.pluralsight.repository;

import com.pluralsight.model.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("customerRepository")
public class HibernateCustomerRepositoryImpl implements CustomerRepository {

    @Value("${dbUsername}")
    private String dbUserName;


    @Override
    public List<Customer> findAll(){

        System.out.println("The received Username:: "+ dbUserName);
        List<Customer> customers = new ArrayList<>();

        Customer sampleCustomer = new Customer();
        sampleCustomer.setFirstName("NameFirst");
        sampleCustomer.setLastName("NameLast");

        customers.add(sampleCustomer);

        return customers;
    }
}
