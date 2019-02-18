import com.pluralsight.service.CustomerService;
import com.pluralsight.service.CustomerServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {


    public static void main(String[] args){
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);


        CustomerService customerService =
                applicationContext.getBean("customerService", CustomerService.class);

        CustomerService customerService2 =
                applicationContext.getBean("customerService", CustomerService.class);

        System.out.println("The address:: " + customerService);
        System.out.println("The address:: " + customerService2);

        System.out.println(customerService.findAll().get(0).getFirstName());
    }
}
