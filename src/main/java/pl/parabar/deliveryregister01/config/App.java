package pl.parabar.deliveryregister01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.parabar.deliveryregister01.service.TimeService;
import pl.parabar.deliveryregister01.service.TimeServiceImpl;

@Configuration
public class App {

    @Bean
    public TimeService timeService() {
        return new TimeServiceImpl();
    }
}
