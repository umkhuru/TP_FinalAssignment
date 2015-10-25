package za.ac.cput.project.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by student on 2015/10/24.
 */
@RestController
@RequestMapping("/api/**")
public class HomePage {

    @RequestMapping(value = "Home",method = RequestMethod.GET)
    public String Index(){
        return "this is my home page";
    }

}
