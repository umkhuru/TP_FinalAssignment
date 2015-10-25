package za.ac.cput.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Transportation Rental Service
 *
 */
@Configuration
@ComponentScan
@EnableWebMvc
@EnableAutoConfiguration
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "welcome to the transportation Rental Service" );
        SpringApplication.run(App.class, args);
    }
}
