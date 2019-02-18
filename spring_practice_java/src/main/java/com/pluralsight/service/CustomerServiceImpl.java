package com.pluralsight.service;

import com.pluralsight.model.Customer;
import com.pluralsight.repository.CustomerRepository;
import com.pluralsight.repository.HibernateCustomerRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerServiceImpl(){
        System.out.println("We are using Constructor Injection now...");
    }

    public CustomerServiceImpl(CustomerRepository customerRepository){

        System.out.println("We are using Constructor Injection now...");

        this.customerRepository=customerRepository;

    }



    public void setCustomerRepository(CustomerRepository customerRepository) {
        System.out.println("We are using Setter Injection now...");
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

}
