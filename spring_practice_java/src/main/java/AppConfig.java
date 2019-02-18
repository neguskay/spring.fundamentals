import com.pluralsight.repository.CustomerRepository;
import com.pluralsight.repository.HibernateCustomerRepositoryImpl;
import com.pluralsight.service.CustomerService;
import com.pluralsight.service.CustomerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan({"com.pluralsight"})
@PropertySource("application.properties")
public class AppConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }



//    @Bean(name="customerRepository")
//    public CustomerRepository getCustomerRepository(){
//        System.out.println("Getting the Customer Repo");
//        return new HibernateCustomerRepositoryImpl();
//
//    }

//    @Bean(name="customerService")
//    public CustomerService getCustomerService(){
//        System.out.println("Instantiating  the Custo Serv Impl");
//        //CustomerServiceImpl customerService = new CustomerServiceImpl(getCustomerRepository());
//
//        CustomerServiceImpl customerService = new CustomerServiceImpl();
//
//        //customerService.setCustomerRepository(getCustomerRepository());
//
//        System.out.println("Setting the Custo Serv Impl");
//
//        return customerService;
//    }
}
