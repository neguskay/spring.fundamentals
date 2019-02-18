package com.pluralsight.repository;

import com.pluralsight.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class HibernateCustomerRepositoryImpl implements CustomerRepository {

    @Override
    public List<Customer> findAll(){
        List<Customer> customers = new ArrayList<>();

        Customer sampleCustomer = new Customer();
        sampleCustomer.setFirstName("NameFirst");
        sampleCustomer.setLastName("NameLast");

        customers.add(sampleCustomer);

        return customers;
    }
}
