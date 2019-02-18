import com.pluralsight.service.CustomerService;
import com.pluralsight.service.CustomerServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {


    public static void main(String[] args){
        //CustomerService customerService = new CustomerServiceImpl();
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("ApplicationContext.xml");

        CustomerService customerService = applicationContext.getBean("customerService", CustomerService.class);

        System.out.println(customerService.findAll().get(0).getFirstName());
    }
}
